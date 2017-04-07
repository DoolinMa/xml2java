package org.doolin.analysis;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.doolin.model.Attribute;
import org.doolin.model.JavaFileContent;
import org.doolin.utils.JavaFileUtil;

public class XMLAnalysis {

	public void analysisXml2Model(File file, String desDir){
		// Create saxReader object.  
        SAXReader reader = new SAXReader();  
        // 通过read方法读取一个文件 转换成Document对象  
        Document document = null;
		try {
			document = reader.read(file);
		} catch (DocumentException e) {
			System.out.println("Read xml file error!");
			e.printStackTrace();
		}  
        //获取根节点元素对象  
        Element node = document.getRootElement();  
        //遍历所有的元素节点  
        List<Element> pList = node.elements("package");
        for(Element p:pList){
        	//创建包
        	createPackage(desDir,p);
        }
	}
    
    private void createPackage(String desdir, Element p) {
    	//生成java文件类
    	JavaFileContent jfc = new JavaFileContent();
    	jfc.setPackageName(p.attribute("name").getText());
    	
    	File file =new File(desdir);    
    	//创建包下的类
    	List<Element> cList = p.elements("class");
    	for (Element c : cList) {
    		
    		String className = c.attribute("name").getText();
    		if(className == null) {
    			new Exception("未获取到类名！");
    			return;
    		}
    		jfc.setClassName(className);
			List<Element> aList = c.element("attributes").elements("attribute");
			List<Attribute> attributes = new ArrayList<Attribute>();
			for (Element a : aList) {
				attributes.add(new Attribute(a.attribute("name").getText(),a.attribute("type").getText()));
				
				jfc.setAttributes(attributes);
				try {
					JavaFileUtil.genJavaFile(file, jfc);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}

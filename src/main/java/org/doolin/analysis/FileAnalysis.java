package org.doolin.analysis;

import java.io.File;
import java.io.FilenameFilter;

public class FileAnalysis {
	private String sourceDir;
	private String desDir;
	
	public FileAnalysis(String sourceDir, String desDir) {
		this.sourceDir = sourceDir;
		this.desDir = desDir;
	}
	
	public void ParserFile(){
		File file = new File(sourceDir);
		//获取结尾为XML的文件，将左右XML都放入在同一个文件夹内。
		FilenameFilter filenameFilter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".xml");
			}
		};
		//if(file.isFile()) System.out.println(file.getName());
		if(file.isDirectory()){
			XMLAnalysis xmlAnalysis = new XMLAnalysis();
			for (File f : file.listFiles(filenameFilter)) 
			{
				xmlAnalysis.analysisXml2Model(f, desDir);
			}
		}
	}
}

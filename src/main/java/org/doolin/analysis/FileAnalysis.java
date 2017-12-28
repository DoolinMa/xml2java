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
		//获取结尾为XML的文件，将所有XML都放入在同一个文件夹内。
		FilenameFilter filenameFilter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".xml");
			}
		};
		XMLAnalysis xmlAnalysis = new XMLAnalysis();
		if(file.isDirectory()){
			for (File f : file.listFiles(filenameFilter)) 
			{
				xmlAnalysis.analysisXml2Model(f, desDir);
			}
		}else if (file.isFile() && file.getName().endsWith(".xml")) {
				xmlAnalysis.analysisXml2Model(file, desDir);
		}
	}
}

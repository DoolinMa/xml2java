package org.doolin.xml2java;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.doolin.analysis.FileAnalysis;

/**
 * Startup the application！
 */
public class App
{
	//The directory of xml files.
	public String sourceDir;
	//The directory of javabean files.
	public String desDir;
	
	public App() {
		//Default directory;
		this.sourceDir = "./";
		this.desDir = "./";
	}
	
	/**
	 * Assign directory from command lines.
	 * @param sourceDir
	 * @param desDir
	 */
	public App(String sourceDir,String desDir) {
		this.sourceDir = sourceDir;
		this.desDir = desDir;
	}
	
    public static void main(String[] args ){
    	System.out.println("Welcome to xml2java!");
    	Options options = new Options();
    	options.addOption("h", "help" ,false,"List help!");
    	options.addOption("s", "S", true, "Set the source dir!");
    	options.addOption("d", "D", true, "Set the destination!");
    	
    	CommandLineParser parser = new PosixParser();
    	HelpFormatter hf = new HelpFormatter();
    	CommandLine cmd = null;
    	
    	if(args.length<4){
    		hf.printHelp("xml2java help","",options,"Example:[ java -jar xml2java.jar -s ./sourceDir -d ./desDir ]");
    		return;
    	}
    	
		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			hf.printHelp("list help",options);
			e.printStackTrace();
			return;
		}
    	
    	if(cmd.hasOption("h")){
    		hf.printHelp("list help",options);
            return;
    	}
    	App app = new App();
    	
    	if(cmd.hasOption("s")){
    		app.sourceDir = cmd.getOptionValue("s");
    		System.out.println("Source dir is "+cmd.getOptionValue("s"));
    	}
    	if(cmd.hasOption("d")){
    		app.desDir = cmd.getOptionValue("d");
    		System.out.println("Des dir is "+cmd.getOptionValue("d"));
    	}
        new FileAnalysis(app.sourceDir,app.desDir).ParserFile();
        System.out.println("successed!");
    }
}

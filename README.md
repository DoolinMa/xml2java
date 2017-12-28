# xml2java
A tool for xml file to java bean source code
# 使用方式及案例
```
Welcome to xml2java!
usage: xml2java help
 -d,--D <arg>   Set the destination!
 -h,--help      List help!
 -s,--S <arg>   Set the source!(It can be directory or xml files)
Example directory:[ java -jar xml2java.jar -s ./sourceDir -d ./desDir ]
Example xml file:[ java -jar xml2java.jar -s ./test.xml -d ./desDir ]
```
# xml案例
```
<?xml version="1.0" encoding="UTF-8"?>
<xml2java>
	<package name="org.doolin">
		<class name="Test">
			<attributes>
				<attribute name="id" type="int" />
				<attribute name="name" type="String" />
				<attribute name="time" type="java.util.Date" />
			</attributes>
		</class>
	</package>
</xml2java>
```
# 转换后java bean代码
```
 package org.doolin;                    
                                       
import java.util.Date;                 
                                       
public class Test {                    
    private int id;                    
    private String name;               
    private Date time;                 
                                       
   public void setId(int id) {        
        this.id = id;                  
    }                                  
                                       
   public int getId() {               
        return id;                     
    }                                  
                                       
   public void setName(String name) { 
        this.name = name;              
    }                                  
                                       
   public String getName() {          
        return name;                   
    }                                  
                                       
   public void setTime(Date time) {   
        this.time = time;              
    }                                  
                                       
   public Date getTime() {            
        return time;                   
    }                                  
}                                      
```
#更新说明
date 2017-12-28 
1、添加对单个xml文件的支持；
2、修改READMD。md，添加详细文件

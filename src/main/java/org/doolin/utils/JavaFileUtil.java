package org.doolin.utils;

import java.io.File;
import java.util.Date;

import org.doolin.model.Attribute;
import org.doolin.model.JavaFileContent;
import org.hibernate.validator.constraints.NotEmpty;

import com.helger.jcodemodel.AbstractJType;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JExpr;
import com.helger.jcodemodel.JFieldVar;
import com.helger.jcodemodel.JMethod;
import com.helger.jcodemodel.JMod;

public class JavaFileUtil {
	private static final String[] DATATYPE={"String","int","double","boolean","float","byte","short","long","char"};

	public static void genJavaFile(File file,JavaFileContent jfc) throws Exception{
		JCodeModel jcm = new JCodeModel();
		
		JDefinedClass dc = jcm._class(jfc.getPackageName()+"."+StringUtil.toUpperCaseFirstOne(jfc.getClassName()));
		for (Attribute a : jfc.getAttributes()) {
			String paramStr = a.getName().toLowerCase();			
			
			AbstractJType type= getJavaType(a.getType(),jcm);
			JFieldVar fieldParam = dc.field(JMod.PRIVATE,type,paramStr);
			//fieldParam.annotate(NotEmpty.class);
			JMethod setMethod = dc.method(JMod.PUBLIC, jcm.VOID, "set"+StringUtil.toUpperCaseFirstOne(paramStr));
			setMethod.param(type, paramStr);
			setMethod.body().assign(JExpr.refthis(fieldParam), JExpr.ref(paramStr));
			JMethod getMethod = dc.method(JMod.PUBLIC, type, "get"+StringUtil.toUpperCaseFirstOne(paramStr));
			getMethod.body()._return(JExpr.ref(paramStr));
		}
		jcm.build(file);
	}
	
	private static AbstractJType getJavaType(String str,JCodeModel jcm){
		for(String s:DATATYPE){ 
			if(s.equalsIgnoreCase(str.trim())) return jcm.parseType(s);
		}
		
		if("Date".equalsIgnoreCase(str.trim())) return jcm.ref(Date.class);
		
		return jcm.parseType("undefined");
	}
	
}

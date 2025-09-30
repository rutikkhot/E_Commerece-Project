package com.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.Base;

public class Takescreenshot extends Base {

	public static String takeScreenShot(String name)
	{
		String path=System.getProperty("user.dir")+"/ScrrenShot/"+name+".png";
		
		TakesScreenshot tks=(TakesScreenshot)driver;
		File source=tks.getScreenshotAs(OutputType.FILE);
		File target=new File(path);
		
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return path;
	}
	
	
}

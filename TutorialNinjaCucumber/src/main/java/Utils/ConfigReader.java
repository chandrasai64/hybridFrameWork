package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
public class ConfigReader {

	public  Properties intializeProperties()
	{
		Properties prop=new Properties();
		File propFile=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Config\\Config.properties");
		try {
			FileInputStream fi=new FileInputStream(propFile);
			prop.load(fi);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return prop;
	}
}

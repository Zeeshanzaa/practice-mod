package commonLibs.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {

	public static Properties readProperties(String filename) throws IOException {
		
		filename=filename.trim();
		
		InputStream input = new FileInputStream(filename);
		
		Properties prop = new Properties();
		
		prop.load(input);
		
		return prop;
	}
	
	
}

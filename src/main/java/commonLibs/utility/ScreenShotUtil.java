package commonLibs.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtil {
	
private TakesScreenshot camera;

	public ScreenShotUtil(WebDriver driver) {
		
		camera = (TakesScreenshot)driver;
		
	}
	
	public void captureAndTakeScreenShot(String filename) throws Exception {
		
		filename=filename.trim();
		
		File imageFile, temporaryFile;
		
		imageFile = new File(filename);
		if(imageFile.exists()) {
			throw new Exception("File exists");
		}
		
		temporaryFile=camera.getScreenshotAs(OutputType.FILE);
		
		FileUtils.moveFile(temporaryFile, imageFile);//src--destination
		
		
		
	}
}

package tests.base;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class Listener implements ITestListener {
    private Logger Logger = LogManager.getLogger();

    @Override
    public void onTestFailure(ITestResult result){
        Logger.info("Test {} - FAILED!", result.getTestName());
        String screenshotName = result.getTestName() + String.valueOf(System.currentTimeMillis()).substring(9,13);
        Logger.info("Trying to trace ScreenShot...");
        TakesScreenshot ts = (TakesScreenshot) ((BaseTest) result.getInstance()).driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(source, new File("build/reports/tests" + screenshotName + ".png"));
        }
        catch (IOException e){
            Logger.info("Exception on saving screenshot");
            e.printStackTrace();
        }
    }

}

package steps;

import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver=null;
    public static void user_open_chrome_browser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        //options.addArguments("--headless");
        options.addArguments("--remote-debugging-port=9222");

        driver = new ChromeDriver(options);                                 //Headless Mode: new ChromeOptions().addArguments("--headless")
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("https://www.itoucheg.com/");
        driver.manage().window().maximize();
    }
    @After
    public void tareDown(Scenario scenario) throws IOException {
        var camera = (TakesScreenshot) driver;
        File ScreenShot = camera.getScreenshotAs(OutputType.FILE);
        String basePath = "C:" + File.separator + "Users" + File.separator + "TC" + File.separator +
                "Desktop" + File.separator + "New folder" + File.separator +
                "iToucheg_Cucumber" + File.separator + "Test-Output" + File.separator + "ScreenShoots" + File.separator;

        switch (scenario.getStatus()) {
            case PASSED:
                Files.move(ScreenShot, new File(basePath + "Passed" + File.separator + scenario.getName() + ".png"));
                break;
            case FAILED:
                Files.move(ScreenShot, new File(basePath + "Failed" + File.separator + scenario.getName() + ".png"));
                break;
            case SKIPPED:
                Files.move(ScreenShot, new File(basePath + "Skipped" + File.separator + scenario.getName() + ".png"));
                break;
        }
        driver.quit();
    }

}

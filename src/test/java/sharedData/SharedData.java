package sharedData;
import loggerUtility.LoggerUtility;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

@Getter
public class SharedData {
    private WebDriver driver;

    @BeforeMethod
    public void prepareEnvironment(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--Headless=new");
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoggerUtility.info("The browser has opened successfully");
    }

    @AfterMethod
    public void clearEnvironment(ITestResult result){
        if(!result.isSuccess()){
            LoggerUtility.error(result.getThrowable().getMessage());
        }
        driver.quit();
        LoggerUtility.info("The browser has closed successfully");
    }

    public WebDriver getDriver(){
        return driver;
    }
}

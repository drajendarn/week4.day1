package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.*;
public class ExplicitWaitTextChanges {

public static void main(String[] args) throws IOException, InterruptedException {
	

WebDriverManager.chromedriver().setup(); 
ChromeDriver driver = new ChromeDriver(); 
driver.manage().window().maximize();
driver.get("http://www.leafground.com/pages/TextChange.html"); 
WebElement btnDisplayed=driver.findElement(By.id("btn"));
String b=btnDisplayed.getText();
System.out.println("Text displayed in the Button is : " + b);

WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
WebElement btnappears=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Click ME!']")));
String textdisplayed=btnappears.getText();
System.out.println("Text displayed in the Button is Changed to : " + textdisplayed);

File output=driver.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(output, new File("./src/main/resources/snaps/Textchanges.jpg"));

btnappears.click();    
Alert alert=driver.switchTo().alert();
String popUp=alert.getText();
System.out.println("Text displayed in the Popup is : "+ popUp);
 
  }
}



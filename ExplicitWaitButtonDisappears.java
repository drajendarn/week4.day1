package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitButtonDisappears {

public static void main(String[] args) throws IOException {
	

WebDriverManager.chromedriver().setup(); 
ChromeDriver driver = new ChromeDriver(); 
driver.manage().window().maximize();
driver.get("http://www.leafground.com/pages/disapper.html"); 
//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
WebElement btnDisplayed=driver.findElement(By.id("btn"));
Boolean b=btnDisplayed.isDisplayed();
System.out.println("Button is Displayed: " + b);
//WebDriverWait wait=new WebDriverWait(driver,10);
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement btnDisappear=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@style, 'display: block')]")));
Boolean d=btnDisappear.isDisplayed();
System.out.println("Button is Disappered now: " + d);

WebElement text=driver.findElement(By.xpath("//div[@id='show']/p/strong"));
String textdisplayed=text.getText();
System.out.println(textdisplayed);
File output=driver.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(output, new File("./src/main/resources/snaps/btnDisappears.jpg"));
  }

}



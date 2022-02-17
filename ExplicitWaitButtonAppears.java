package week4.day1;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.*;
import io.github.bonigarcia.wdm.WebDriverManager;
public class ExplicitWaitButtonAppears {

public static void main(String[] args) {
	

WebDriverManager.chromedriver().setup(); 
ChromeDriver driver = new ChromeDriver(); 
driver.manage().window().maximize();
driver.get("http://www.leafground.com/pages/appear.html"); 
WebElement btnDisplayed=driver.findElement(By.id("btn"));
Boolean b=btnDisplayed.isDisplayed();
System.out.println("Button is Displayed: " + b);
@SuppressWarnings("deprecation")
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
//WebDriverWait wait=new WebDriverWait(driver,30);
WebElement btnappears=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='btn']/b")));
Boolean d=btnappears.isDisplayed();
System.out.println("Button is Appeares now: " + d);
String textdisplayed=btnappears.getText();
System.out.println(textdisplayed);

  }

}



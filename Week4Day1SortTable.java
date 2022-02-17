package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.types.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Week4Day1SortTable {

public static void main(String[] args) throws IOException {
	

WebDriverManager.chromedriver().setup(); 
ChromeDriver driver = new ChromeDriver(); // Open a new chrome browser
driver.manage().window().maximize(); // Maximize the opened chrome browser window 
driver.get("http://www.leafground.com/pages/sorttable.html"); 
WebElement elementTable=driver.findElement(By.id("table_id"));
List<String> obtainedList = new ArrayList<>();  
List<WebElement> allRows= elementTable.findElements(By.tagName("tr"));
List<WebElement> cols=allRows.get(1).findElements(By.xpath("//table/tbody/tr/td[2]")); 
 for(WebElement we:cols){
	String value= we.getText();
	System.out.println(value);
   obtainedList.add(we.getText());
}
ArrayList<String> sortedList = new ArrayList<>();   
for(String s:obtainedList){
sortedList.add(s);
}
Collections.sort(sortedList);

List<String> obtainedList1 = new ArrayList<>();  
driver.findElement(By.xpath("//th[text()='Name']")).click();
List<WebElement> cols1=allRows.get(1).findElements(By.xpath("//table/tbody/tr/td[2]")); 
for(WebElement we1:cols1){
	String value= we1.getText();
	System.out.println(value);
  obtainedList1.add(we1.getText());
}
ArrayList<String> sortedList1 = new ArrayList<>();   
for(String s:obtainedList1){
sortedList1.add(s);
}
File output=driver.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(output, new File("./src/main/resources/snaps/sortTable.jpg"));

if (sortedList .equals(sortedList1))
{
	System.out.println("Name column is sorted");
}
else
	System.out.println("Name column is not sorted");
  }


}




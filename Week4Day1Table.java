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
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.types.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Week4Day1Table {

public static void main(String[] args) throws IOException {
	

WebDriverManager.chromedriver().setup(); 
ChromeDriver driver = new ChromeDriver(); // Open a new chrome browser
driver.manage().window().maximize(); // Maximize the opened chrome browser window 
driver.get("http://www.leafground.com/pages/table.html"); // Loads the URL in the opened browser 
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
//WebDriverWait wait=new WebDriverWait(driver,10);
//wait.until(Expected)

WebElement elementTable=driver.findElement(By.id("table_id"));
List<WebElement> rows=elementTable.findElements(By.tagName("tr"));
int num_rows=rows.size();
System.out.println("Total number of Rows are :" + num_rows);

List<WebElement> col=rows.get(0).findElements(By.tagName("th"));
int num_col=col.size();
System.out.println("Total number of columns are :" + num_col);
WebElement getValue=driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
String value=getValue.getText();
System.out.println("Progress Value for Learn to interact with elemennts column is : "+ value);

WebElement onClick=driver.findElement(By.xpath("//table/tbody/tr[4]/td[3]/input"));
onClick.click();
Boolean b=onClick.isSelected();
File output=driver.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(output, new File("./src/main/resources/snaps/Table.jpg"));
if(b==true)
{
	System.out.println("Vital task for least completed progress check box is checked");
}
	else
		System.out.println("Vital task for least completed progress checkbox is not checked");
  }

}



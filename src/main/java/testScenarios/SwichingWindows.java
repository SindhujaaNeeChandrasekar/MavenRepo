package testScenarios;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SwichingWindows {

	@Test
	public void switchWind()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		//count the window ids opened by the drive object
		Set<String> allWin=driver.getWindowHandles();
		System.out.println("Total windows opened by the driver object-"+allWin.size());
		String win1=null;
		String win2=null;
		Iterator<String> itr=allWin.iterator();
		if(itr.hasNext())
		{
			win1=itr.next();
			win2=itr.next();
		}
		System.out.println("Window1 Id="+win1);
		System.out.println("Window2 id="+win2);
		System.out.println("Window1 title="+driver.getTitle());
		driver.switchTo().window(win2);
		String title=driver.getTitle();
		System.out.println("Window2 title="+title);
		driver.quit();
	}
}

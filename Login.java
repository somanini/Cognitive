
package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {
  public static WebDriver wbdv=null;
  public static String baseUrl;
  public boolean acceptNextAlert = true;
  public static StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass()
  public  static void setUp()  {
    wbdv = new FirefoxDriver();
    baseUrl =  "https://www.facebook.com/";
    wbdv.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  //==========================================================================================================================================================
  // 1.Create login test case, which accepts username and password using xpath
  @Test
  public void testLogin() throws Exception {
	  wbdv.get(baseUrl + "/");
	  wbdv.findElement(By.id("email")).clear();
	  wbdv.findElement(By.id("email")).sendKeys("s_nageshn@yahoo.co.in");
	  wbdv.findElement(By.id("pass")).clear();
	  wbdv.findElement(By.id("pass")).sendKeys("test123");
	  wbdv.findElement(By.id("u_0_q")).click();
  }

  //2.Create at least 3 test cases using complete path of the elements (Headers, etc.) in webpage..
  @Test
  public void testcompletexpath() throws Exception {
	  wbdv.get(baseUrl + "/");
	  wbdv.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div/div/div[2]/form/table/tbody/tr[2]/td[1]/input")).clear();
	  wbdv.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div/div/div[2]/form/table/tbody/tr[2]/td[1]/input")).sendKeys("s_nageshn@yahoo.co.in");
	  wbdv.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div/div/div[2]/form/table/tbody/tr[2]/td[2]/input")).clear();
	  wbdv.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div/div/div[2]/form/table/tbody/tr[2]/td[2]/input")).sendKeys("test123");
	  wbdv.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div/div/div[2]/form/table/tbody/tr[2]/td[3]/label/input")).click();
  }
  
  //3.Write test cases to check the font, color, alignment of elements (Headers, etc.) in webpage.
  @Test
  public void teststructure() throws Exception {
	  wbdv.get(baseUrl + "/");
	  wbdv.findElement(By.id("email")).getCssValue("font-size");
	  wbdv.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div/div/div[2]/form/table/tbody/tr[2]/td[1]/input")).getCssValue("color");
	  wbdv.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div/div/div[2]/form/table/tbody/tr[2]/td[1]/input")).clear();
	  
  }
  
  // Finding width of the Webpage.
  private float getWidthInRelationToWindow(WebElement element){
	    return ((float)element.getSize().getWidth())/
	                  this.wbdv.manage().window().getSize().getWidth();
	}
  
  //======================================================================================================================================================
  
  @AfterClass()
  public static void tearDown() throws Exception {
	  wbdv.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      
    }
  }

  private boolean isElementPresent(By by) {
    try {
    	wbdv.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
    	wbdv.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = wbdv.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

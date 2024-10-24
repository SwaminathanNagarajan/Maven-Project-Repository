package com.automationpractise.mavenproject;

//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class tabswitch {
    public static void main(String[] args) {
        // Set up WebDriver and open the first tab
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Open first URL
        driver.get("https://www.google.com");
        try{
        	Thread.sleep(5000);
        	
        }catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
        // Open second tab using JavascriptExecutor
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.youtube.com', '_blank');");
        try{
        	Thread.sleep(5000);
        	
        }catch (InterruptedException e) {
        	e.printStackTrace();
        }
        // Get the window handles of all open tabs
        Set<String> windowHandles = driver.getWindowHandles();
        
        // Store the first tab (Google) handle for switching back later
        String firstTab = driver.getWindowHandle();
        
        // Loop through the window handles and switch to the YouTube tab
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains("YouTube")) {
                System.out.println("Switched to the YouTube tab: " + driver.getTitle());
                try{
                	Thread.sleep(5000);
                	
                }catch (InterruptedException e) {
                	e.printStackTrace();
                }
                break;  // Stop switching once you find the desired tab
            }
        }

        // Switch back to the first tab (Google)
        driver.switchTo().window(firstTab);
        System.out.println("Switched back to the first tab: " + driver.getTitle());
        try{
        	Thread.sleep(5000);
        	
        }catch (InterruptedException e) {
        	e.printStackTrace();
        }
        String title = driver.getTitle();
        System.out.println("Required operations are done" +title);
        // Close all windows
        driver.quit();
    }
}

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
        
        // Open second tab using JavascriptExecutor
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.youtube.com', '_blank');");

        // Get the window handles of all open tabs
        Set<String> windowHandles = driver.getWindowHandles();
        
        // Store the first tab (Google) handle for switching back later
        String firstTab = driver.getWindowHandle();
        
        // Loop through the window handles and switch to the YouTube tab
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains("YouTube")) {
                System.out.println("Switched to the YouTube tab: " + driver.getTitle());
                break;  // Stop switching once you find the desired tab
            }
        }

        // Switch back to the first tab (Google)
        driver.switchTo().window(firstTab);
        System.out.println("Switched back to the first tab: " + driver.getTitle());
        
        // Close all windows
        driver.quit();
    }
}

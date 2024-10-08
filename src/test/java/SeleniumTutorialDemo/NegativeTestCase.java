package SeleniumTutorialDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NegativeTestCase {
	@Test(priority = 1)
	public void NegativeTest() {
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/index.php");
		driver.manage().window().maximize();
		
		try {
            // Valid Test Case: Search and Book a Flight
            // Select departure and destination cities
            WebElement departureCity = driver.findElement(By.name("fromPort"));
            departureCity.sendKeys("Boston");

            WebElement destinationCity = driver.findElement(By.name("toPort"));
            destinationCity.sendKeys("New York");

            // Click on the "Find Flights" button
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            // Select a flight from the search results (assuming the first one is chosen)
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            // Enter passenger details and book the flight
            driver.findElement(By.id("inputName")).sendKeys("John Doe");
            driver.findElement(By.id("address")).sendKeys("123 Main St");
            driver.findElement(By.id("city")).sendKeys("Anytown");
            driver.findElement(By.id("state")).sendKeys("Anystate");
            driver.findElement(By.id("zipCode")).sendKeys("12345");
            driver.findElement(By.id("creditCardNumber")).sendKeys("1234567890123456");
            driver.findElement(By.id("creditCardMonth")).sendKeys("12");
            driver.findElement(By.id("creditCardYear")).sendKeys("2025");
            driver.findElement(By.id("nameOnCard")).sendKeys("John Doe");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            // Confirm the successful booking
            String bookingConfirmation = driver.findElement(By.tagName("h1")).getText();
            System.out.println("Booking Confirmation: " + bookingConfirmation);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
		
	}



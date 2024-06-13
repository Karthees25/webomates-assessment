package com.karthees;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Xpath {

    public static WebDriver createWebDriver() {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver.exe");

        // Initialize the WebDriver (Chrome in this case)
        WebDriver driver = new ChromeDriver();

        return driver;
    }

    public static void Launch(WebDriver driver) {
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
    }

    public static void main(String[] args) throws InterruptedException {
        // Get WebDriver instance
        WebDriver driver = createWebDriver();

        // Open a webpage
        Launch(driver);

        String title = driver.getCurrentUrl();

        System.out.println(title);

        WebElement firstName = driver
                .findElement(By.xpath("//label[normalize-space()='First Name']/following-sibling::input[1]"));
        firstName.sendKeys("Kartheeswaran");

        WebElement lastName = driver
                .findElement(By.xpath("//label[normalize-space()='Last Name']/following-sibling::input[1]"));
        lastName.sendKeys("Govintharajan");

        WebElement email = driver
                .findElement(By.xpath("//label[normalize-space()='Email']/following-sibling::input[1]"));
        email.sendKeys("rgkarthees@gmail.com");

        WebElement password = driver.findElement(By.xpath("//div[@class='container']//div//input[@type='password']"));
        password.sendKeys("123456");

        WebElement repeatPassword = driver.findElement(By.xpath("//input[4]"));
        repeatPassword.sendKeys("123456");

        WebElement register = driver.findElement(By.xpath("//button[normalize-space()='Register']"));
        register.click();

        List<WebElement> salaryElements = driver.findElements(
                By.xpath("//table[@id='contactList']//td[count(//th[text()='Salary']/preceding-sibling::th)+1]"));

        for (WebElement salaryElement : salaryElements) {
            String salaryText = salaryElement.getText();
            System.out.println("Salary: " + salaryText);
        }

        List<WebElement> countryElements = driver.findElements(
                By.xpath("//table[@id='contactList']//td[count(//th[text()='Country']/preceding-sibling::th)+1]"));
        for (WebElement countryElement : countryElements) {
            String countryText = countryElement.getText();
            System.out.println("Country: " + countryText);
        }

        List<WebElement> contactElements = driver.findElements(
                By.xpath("//table[@id='contactList']//td[count(//th[text()='Contact']/preceding-sibling::th)+1]"));
        for (WebElement contactElement : contactElements) {
            String contactText = contactElement.getText();
            System.out.println("Contact: " + contactText);
        }
        driver.quit();

    }
}

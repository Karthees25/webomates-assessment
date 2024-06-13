package com.karthees;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CssSelector {

    public static WebDriver createWebDriver() {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver.exe");

        // Initialize the WebDriver (Chrome in this case)
        WebDriver driver = new ChromeDriver();

        return driver;
    }

    public static void Launch(WebDriver driver) {
        driver.get("https://www.hyrtutorials.com/p/css-selectors-practice.html");
    }

    public static void main(String[] args) throws InterruptedException {
        // Get WebDriver instance
        WebDriver driver = createWebDriver();

        // Open a webpage
        Launch(driver);

        String title = driver.getCurrentUrl();

        System.out.println(title);

        /*
         * Css Selector is pattern to find elements in webpages and it's classified by
         * four types
         * 1.css simple selector
         * 2.css pseduo-class selector
         * 3.css combinator selector
         * 4. css attributes selector
         */

        // Css Simple Selector has four types-Element,id,class,universal
        // css Element selector
        WebElement element = driver.findElement(By.cssSelector("input"));
        System.out.println("The id attribute of input tagname is " + element.getAttribute("id"));

        // css id selector
        WebElement firstName = driver.findElement(By.cssSelector("#firstName"));
        firstName.sendKeys("Kartheeswaran");

        WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("Govintharajan");

        // css class selector
        WebElement gender = driver.findElement(By.cssSelector(".gender"));
        gender.sendKeys("Male");

        // css universal selector
        System.out.println(driver.findElements(By.cssSelector("*")).size());

        /*
         * Css Attributes Selector has 7 types
         * 1.AttributeName
         * 2.AttributeValue
         * 3.AttributeValue-PartialText-Wholeword
         * 4.AttributeValue-PartialText-Text
         * 5.AttributeValue-Startwith-Text
         * 6.AttributeValue-Endwith-Text
         * 7.AttributeValue-StartWith-WholeWord
         * 
         */

        // 1.AttributeName
        List<WebElement> elementsWithPlaceholder = driver.findElements(By.cssSelector("input[placeholder]"));
        System.out.println(elementsWithPlaceholder.size());

        // 2.AttributeValue
        WebElement city = driver.findElement(By.cssSelector("[placeholder='City']"));
        city.sendKeys("bengaluru");

        WebElement country = driver.findElement(By.cssSelector("[placeholder='Country']"));
        country.sendKeys("india");

        // 3.AttributeValue-PartialText-Wholeword
        WebElement question = driver.findElement(By.cssSelector("input[placeholder~='question']"));
        question.sendKeys("who are you");

        // 4.AttributeValue-PartialText-Text
        WebElement answer = driver.findElement(By.cssSelector("input[placeholder*='ans']"));
        answer.sendKeys("Tester");

        // 5.AttributeValue-Startwith-Text
        WebElement verification = driver.findElement(By.cssSelector("input[placeholder^='Verify']"));
        verification.sendKeys("verified");

        /*
         * Css Combinator Selector
         * 1. Descendant Selector
         * 2.Child Selector
         * 3. Adjacent sibling Selector
         * 4.General sibling Selector
         */

        // 1.Descendant Selector
        driver.findElement(By.cssSelector(".container>select")).click();
        // Initialize WebDriverWait with a timeout (e.g., 10 seconds)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 6.AttributeValue-Endwith-Text
        WebElement elements = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("option[value$='le']")));

        // Perform actions on the element
        elements.click();

        WebElement confirmation = driver.findElement(By.cssSelector("[ type='checkbox']"));
        confirmation.click();

        // Css AND Condition Selector
        WebElement selectElements = driver.findElement(By.cssSelector("input[class=button][type='button']"));
        selectElements.click();

        // Css NOT Condition Selector
        WebElement selectElements1 = driver.findElement(By.cssSelector("input.button:not([type='submit'])"));
        selectElements1.click();

        driver.findElement(By.cssSelector(".container>:nth-child(11)")).click();

        // 2.child Selector
        driver.findElement(By.cssSelector(".container>div>select")).click();

        WebElement skills = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("option[value='java']")));

        // Perform actions on the element
        skills.click();

        // 3.Adjacent sibling Selector
        System.out.println(driver.findElement(By.cssSelector("p[class='my_test']+p")).getText());

        // 4.General sibling Selector
        List<WebElement> listofcontry = driver.findElements(By.cssSelector("p[class='my_test']~p"));
        System.out.println(listofcontry.size());

        // 7.AttributeValue-StartWith-WholeWord
        WebElement countries = driver.findElement(By.cssSelector("p[class|='my']"));
        System.out.println(countries.getText());

        // css Pseudo class Selector
        driver.findElement(By.cssSelector(".container>:last-child")).click();

        Thread.sleep(5000);

        // Close the driver
        driver.quit();
    }
}

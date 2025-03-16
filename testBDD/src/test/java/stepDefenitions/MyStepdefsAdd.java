package stepDefenitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


public class MyStepdefsAdd {

    private WebDriver driver;


    @Given("I have the first number {int}")
    public void iHaveTheFirstNumber(int first) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.marshu.com/articles/calculate-addition-calculator-add-two-numbers.php");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By acceptButtonLocator =  By.cssSelector("button.fc-button.fc-cta-consent.fc-primary-button"); //By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div[2]/button[1]/p");
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(acceptButtonLocator));
        acceptButton.sendKeys(Keys.ENTER);

        WebElement field = driver.findElement(By.name("n01"));
        field.sendKeys(Integer.toString(first));
    }

    @And("I have the second number {int}")
    public void iHaveTheSecondNumber(int second) {
        WebElement field = driver.findElement(By.name("n02"));
        field.sendKeys(Integer.toString(second));
    }

    @When("I add two numbers")
    public void iAddTwoNumbers() {
        driver.findElement(By.cssSelector("[value='Find Addition']")).click();
    }

    @Then("I get the result {int}")
    public void iGetTheResult(int expected) {
        WebElement field = driver.findElement(By.name("answer"));
        String actual = field.getText();

        assertEquals(Integer.toString(expected),actual);
    }


}

package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp () {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay() {

        WebElement register = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        register.click();

        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[@class='title']"));
        String actualtext = actualMessageElement.getText();
        String expectedResult = "Signing up is easy!";
        Assert.assertEquals("Signin",actualtext,expectedResult);

    }
    @Test
    public void userShouldRegisterAccountSuccessfully() {
// user navigate to  Registration page
        WebElement register = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        register.click();
        //Enter the First Name
        WebElement firstName = driver.findElement(By.xpath("//input[@name='customer.firstName']"));
        firstName.sendKeys("Pappu");
        //Enter the Last Name
        WebElement lastName = driver.findElement(By.xpath("//input[@name='customer.lastName']"));
        lastName.sendKeys("Pager");
        //address
        WebElement address = driver.findElement(By.xpath("//input[@id='customer.address.street']"));
        address.sendKeys("Mumbai High Street");
        //city name
        WebElement cityName = driver.findElement(By.xpath("//input[@id='customer.address.city']"));
        cityName.sendKeys("Mumbai");
        // state name
        WebElement stateName = driver.findElement(By.xpath("//input[@id='customer.address.state']"));
        stateName.sendKeys("Maharastra");
        //Zip code
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='customer.address.zipCode']"));
        zipCode.sendKeys("m2569846");
        // Enter the Phone number
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='customer.phoneNumber']"));
        phoneNumber.sendKeys("075566778899");
        // SSN number
        WebElement ssnNum = driver.findElement(By.xpath("//input[@id='customer.ssn']"));
        ssnNum.sendKeys("786786");
        // Enter User name
        WebElement userName = driver.findElement(By.xpath("//input[@name='customer.username']"));
        userName.sendKeys("SunderPraptichekam");
        // Enter password
        WebElement password = driver.findElement(By.xpath("//input[@name='customer.password']"));
        password.sendKeys("123456");
        // confirm password
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@name='repeatedPassword']"));
        confirmPassword.sendKeys("123456");
        WebElement registerme = driver.findElement(By.xpath("//input[@value='Register']"));
        registerme.click();

        WebElement actualMessageElement = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        String actualMessage = actualMessageElement.getText();
        String expectedMessage ="Your account was created successfully. You are now logged in.";

        Assert.assertEquals("Message printed correctly",actualMessage,expectedMessage);


    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}

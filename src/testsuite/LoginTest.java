package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //valid user name
        WebElement validUserName = driver.findElement(By.xpath("//input[@name='username']"));
        validUserName.sendKeys("SunderPraptichekam");
        // valid password
        WebElement validpassword = driver.findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        validpassword.sendKeys("123456");
        //click on login
        WebElement clickOnLogin = driver.findElement(By.xpath("//input[@value='Log In']"));
        clickOnLogin.click();

    }

    @Test
    public void verifyTheErrorMessage() {
        //Enter Invalid user Name
        WebElement invalidUserName = driver.findElement(By.xpath("//input[@name='username']"));
        invalidUserName.sendKeys("underprapti");
        // Enter Invalid Password
        WebElement invalidPassword = driver.findElement(By.xpath("//input[@name='password']"));
        invalidPassword.sendKeys("123789");
        //click on login
        WebElement clickOnLogin = driver.findElement(By.xpath("//input[@value='Log In']"));
        clickOnLogin.click();
        //verification of error message
        WebElement actualMessageElement = driver.findElement(By.xpath("//p[text()='The username and password could not be verified.']"));
        String actualMessage = actualMessageElement.getText();
        String expectedMessage = "The username and password could not be verified.";

        Assert.assertEquals("Message printed correctly", actualMessage, expectedMessage);

    }

    @Test
    public void userShouldLogoutSuccessfully() {
        //Enter valid user name
        WebElement validUserName = driver.findElement(By.xpath("//input[@name='username']"));
        validUserName.sendKeys("SunderPraptichekam");
        // Enter valid password
        WebElement validPassword = driver.findElement(By.xpath("//input[@name='password']"));
        validPassword.sendKeys("123456");
        //click on login button
        WebElement clickonLogin = driver.findElement(By.xpath("//input[@value='Log In']"));
        clickonLogin.click();
        //click on log out button
        //click on logout
      //  WebElement clickonLogout = driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
        //clickonLogout.click();
        // check Customer login text
        WebElement actualMessageElement = driver.findElement(By.xpath("//h2[text()='Customer Login']"));
        String acutalMessage = actualMessageElement.getText();
        String expectedMessage = "Customer Login";
        Assert.assertEquals("Customer Login", acutalMessage,expectedMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

package newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="firstName")
    private WebElement firstname;

    @FindBy(name="lastName")
    private WebElement lastname;

    @FindBy(id="email")
    private WebElement username;

    @FindBy(name ="password")
    private WebElement pwd;

    @FindBy(name = "confirmPassword")
    private WebElement cpwd;

    @FindBy(name = "register")
    private WebElement submit;

    public RegistrationPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void goTo()
    {
        this.driver.get("http://newtours.demoaut.com/mercuryregister.php");
        this.wait.until(ExpectedConditions.visibilityOf(this.firstname));
    }

    public void contactDetails(String Firstname,String Lastname)
    {
        this.firstname.sendKeys(Firstname);
        this.lastname.sendKeys(Lastname);
    }

    public void userDetails(String Username,String password)
    {
        this.username.sendKeys(Username);
        this.pwd.sendKeys(password);
        this.cpwd.sendKeys(password);
    }

    public void clickSubmit()
    {
        this.submit.click();
    }

}

package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * Created by QA on 12/5/2016.
 */
public class AdminLoginPage {

    WebDriver driver;
    By tf_adminUserName = By.xpath("//input[@name='username']");
    By tf_adminPassWord = By.xpath("//input[@name='password']");
    By btn_adminLoginSubmit = By.xpath("//button[@type='submit']");


    public AdminLoginPage(WebDriver driver){
        this.driver = driver;
    }

    public String getLoginTitle(){
        return    driver.getTitle();
    }

    public void typeAdminUserName(String adminUserName){
        driver.findElement(tf_adminUserName).sendKeys(adminUserName);
    }

    public void typeAdminPassword(String adminPassword){
        driver.findElement(tf_adminPassWord).sendKeys(adminPassword);
    }

    public void clickSubmit(){
        driver.findElement(btn_adminLoginSubmit).click();
    }

    public void adminLogin(String adminUserName, String adminPassword) throws InterruptedException {
        //Fill user name
        this.typeAdminUserName(adminUserName);
        //Fill password
        this.typeAdminPassword(adminPassword);
        //Click Login button
        this.clickSubmit();
        Thread.sleep(3000);
    }
}

package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * Created by QA on 12/5/2016.
 */
public class AdminLoginPage {

    WebDriver driver;
    public AdminLoginPage(WebDriver driver){
        this.driver = driver;
    }

    By tf_adminUserName = By.xpath("//h3[text()='Login']/../../div[2]//input");
    By tf_adminPassWord = By.xpath("//h3[text()='Login']/../../div[2]/form/div[2]/input");
    By btn_adminLoginSubmit = By.xpath("//h3[text()='Login']/../../div[2]//button");


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

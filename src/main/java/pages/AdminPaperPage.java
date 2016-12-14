package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Random;
/**
 * Created by QA on 12/7/2016.
 */
public class AdminPaperPage {
    WebDriver driver;
    Random rand = new Random(); //for generate random numbers
    public AdminPaperPage(WebDriver driver) {this.driver = driver;}

    //=====================================Web elements=================================================================
    By btn_createPaper = By.xpath("//button[contains(text(),\"Create Paper\")]");
    By tf_paperTitle = By.xpath("//input[@name='title']");
    By tf_paperSummary = By.xpath("//textarea[@name='summary']");
    By btn_createdPaperSubmit = By.xpath("//textarea[@name='summary']/parent::div/parent::div/parent::form/div[3]/button[2]");


    //=====================================Parametrized Web elements====================================================
    public By paramLblNewlyCreatedPaper(String testTile){
        By lbl_newlyCreatedPaper = By.xpath("//span[contains(text(),'" +testTile+ "')]");
        return lbl_newlyCreatedPaper;
    }


    //=====================================Methods for Web elements=====================================================
    public void clickBtnCreatePaper(){
        driver.findElement(btn_createPaper).click();
    }

    public void typePaperTitle(String paperTitle){
        driver.findElement(tf_paperTitle).sendKeys(paperTitle);
    }

    public void typePaperSummary(String paperSummary){
        driver.findElement(tf_paperSummary).sendKeys(paperSummary);
    }

    public void clickBtnSubmitPaper(){

        driver.findElement(btn_createdPaperSubmit).click();
    }
    //=====================================Re-Usable components=========================================================
    public int createNewPaper() throws InterruptedException {
        int randomNum = rand.nextInt(1000);
        Thread.sleep(1000);
        clickBtnCreatePaper();
        Thread.sleep(1000);
        typePaperTitle("Automated_Paper_"+randomNum);
        typePaperSummary("Automated_Summary_"+randomNum);
        Thread.sleep(1000);
        clickBtnSubmitPaper();
        Thread.sleep(1000);
        return randomNum;
    }

    public void checkPresenceOfCreatedPaper(String paperNameVerify) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(paramLblNewlyCreatedPaper(paperNameVerify)).isDisplayed(); //Verify the newly created paper
    }

}

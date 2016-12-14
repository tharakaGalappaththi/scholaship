package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Random;
/**
 * Created by QA on 12/5/2016.
 */
public class AdminPaperSetPage {
    WebDriver driver;
    Random rand = new Random(); //for generate random numbers
    public AdminPaperSetPage(WebDriver driver) {this.driver = driver;}

    //=====================================Web elements=================================================================
    public By btn_createPaperSet = By.xpath("//*[contains(text(),\"Create Paper\")]");
        By tf_paperSetTitle = By.xpath("//input[@name='title']");
        By tf_paperSetSummary = By.xpath("//textarea[@name='summary']");
        By btn_createdPaperSetSubmit = By.xpath("//textarea[@name='summary']/parent::div/parent::div/parent::form/div[3]/button[2]");
        By lbl_createdPapersetLast = By.xpath("//*[contains(text(),'Previous')]/parent::li/parent::ul/li[last()-1]//span");

    //=====================================Parametrized Web elements====================================================
    public By paramLblNewlyCreatedPaperSet(String paperSetName){
        By lbl_newlyCreatedPaperSet = By.xpath("//h4[contains(text(),'"+paperSetName+"')]");
        return lbl_newlyCreatedPaperSet;
    }

    //=====================================Methods for Web elements=====================================================
    public void clickBtnCreatePaperSet(){
        driver.findElement(btn_createPaperSet).click();
    }

    public void typePaperSetTitle(String paperSetTitle){
        driver.findElement(tf_paperSetTitle).sendKeys(paperSetTitle);
    }

    public void typePaperSetSummary(String paperSetSummary){
        driver.findElement(tf_paperSetSummary).sendKeys(paperSetSummary);
    }

    public void clickBtnSubmitPaperSet(){

        driver.findElement(btn_createdPaperSetSubmit).click();
    }

    public void clickLblPaperSetLast(){
        driver.findElement(lbl_createdPapersetLast).click();
    }

    public void clickLblCreatedPaperSet(String createdPaperSetName){
        driver.findElement(paramLblNewlyCreatedPaperSet(createdPaperSetName)).click();
    }

    //=====================================Re-Usable components=========================================================
    public int createNewPaperSet() throws InterruptedException {
        int randomNum = rand.nextInt(1000);

        Thread.sleep(1000);
        clickBtnCreatePaperSet();
        Thread.sleep(1000);
        typePaperSetTitle("Automated_PaperSet_"+randomNum);
        typePaperSetSummary("Automated_Summary_"+randomNum);
        Thread.sleep(1000);
        clickBtnSubmitPaperSet();
        Thread.sleep(3000);
        return randomNum;
    }

    public void checkPresenceOfCreatedPaperSet(String paperSetNameVerify) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(paramLblNewlyCreatedPaperSet(paperSetNameVerify)).isDisplayed(); //Verify the newly created paper set
    }


}


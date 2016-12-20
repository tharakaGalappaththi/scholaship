package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

/**
 * Created by QA on 12/20/2016.
 */
public class AdminPaperPartPage {
    WebDriver driver;
    Random rand = new Random(); //for generate random numbers
    public AdminPaperPartPage(WebDriver driver) {this.driver = driver;}

    //=====================================Web elements=================================================================
    By btn_createPaperPart = By.xpath("//button[contains(text(), 'Create Paper Part')]");
    By tf_paperPartTitle = By.xpath("//label[contains(text(), 'Title')]/../input");
    By tf_paperPartSummary = By.xpath("//label[contains(text(), 'Summary')]/../textarea");
    By btn_paperPartCancel = By.xpath("//label[contains(text(), 'Status')]/../../../div[3]/button");
    By btn_paperPartCreate = By.xpath("//label[contains(text(), 'Status')]/../../../div[3]/button[2]");

    //=====================================Parametrized Web elements====================================================
    public By paramLblNewlyCreatedPaperPart(String testSummary){
        By lbl_newlyCreatedPaperPart = By.xpath("//div[contains(text(),'" +testSummary+ "')]");
        return lbl_newlyCreatedPaperPart;
    }

    //=====================================Methods for Web elements=====================================================
    public void clickBtnCreatePaperPart(){
        driver.findElement(btn_createPaperPart).click();
    }
    public void typePaperPartTitle(String paperPartTitle){driver.findElement(tf_paperPartTitle).sendKeys(paperPartTitle);}
    public void typePaperPartSummary(String paperPartSummary){driver.findElement(tf_paperPartSummary).sendKeys(paperPartSummary);}
    public void clickBtnCancel(){driver.findElement(btn_paperPartCancel).click();}
    public void clickBtnCreate(){driver.findElement(btn_paperPartCreate).click();}

    //=====================================Re-Usable components=========================================================
    public int createNewPaperPart() throws InterruptedException {
        Thread.sleep(1000);
        clickBtnCreatePaperPart();
        int randomNum = rand.nextInt(1000);
        Thread.sleep(1000);
        typePaperPartTitle("Automated_Paper_Part_"+randomNum);
        typePaperPartSummary("Automated_Summary_"+randomNum);
        Thread.sleep(1000);
        clickBtnCreate();
        Thread.sleep(1000);
        return randomNum;
    }

    public void checkPresenceOfCreatedPaperPart(String paperPartNameVerify) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(paramLblNewlyCreatedPaperPart(paperPartNameVerify)).isDisplayed(); //Verify the newly created paper
    }


}

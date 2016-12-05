package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by QA on 12/5/2016.
 */
public class AdminPaperSetPage {
    WebDriver driver;
   public By btn_createPaperSet = By.xpath("//*[contains(text(),\"Create Paper\")]");
    By tf_paperSetTitle = By.xpath("//*[@id=\"newSetModal\"]/div/div/form/div[1]/div[2]/input");
    By tf_paperSetSummary = By.xpath("//*[@id=\"newSetModal\"]/div/div/form/div[1]/div[3]/textarea");
    By btn_paperSetSubmit = By.xpath("//*[@id=\"newSetModal\"]/div/div/form/div[2]/button");

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
        driver.findElement(btn_paperSetSubmit).click();
    }

    //=====================================Re-Usable components===============================================
    public void createNewPaperSet() throws InterruptedException {
        Thread.sleep(2000);
        clickBtnCreatePaperSet();
        Thread.sleep(2000);
        typePaperSetTitle("Automated_PaperSet_"+Math.random() * ( 3 - 6 ));
        typePaperSetSummary("Automated_Summary_"+Math.random() * ( 3 - 6 ));
        Thread.sleep(2000);
        clickBtnSubmitPaperSet();
        Thread.sleep(2000);
    }

    public AdminPaperSetPage(WebDriver driver) {
        this.driver = driver;
    }

}


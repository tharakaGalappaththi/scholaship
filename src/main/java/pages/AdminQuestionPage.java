package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
/**
 * Created by QA on 12/20/2016.
 */
public class AdminQuestionPage {
    WebDriver driver;
    public AdminQuestionPage(WebDriver driver) {this.driver = driver;}

    //=====================================Web elements=================================================================
    By btn_addQuestion = By.xpath("//button[contains(text(),'Add Question')]");
    By rdb_groupQuestion = By.xpath("//input[@name='mainType']");
    By rdb_individualQuestion = By.xpath("//input[@name='mainType']/../../label[2]/input");
    By btn_cancel = By.xpath("//button[contains(text(),'Cancel')]");
    By btn_ok = By.xpath("//button[contains(text(),'Ok')]");
    By dd_selectQuestionType = By.xpath("//select[@name='questionType']");

    //=====================================Methods for Web elements=====================================================
    public void clickBtnAddQuestion(){
        driver.findElement(btn_addQuestion).click();
    }
    public void clickRdbGroup(){
        driver.findElement(rdb_groupQuestion).click();
    }
    public void clickRdbIndividual(){
        driver.findElement(rdb_individualQuestion).click();
    }
    public void clickBtnCancel(){
        driver.findElement(btn_cancel).click();
    }
    public void clickBtnOk(){
        driver.findElement(btn_ok).click();
    }

    //=====================================Re-Usable components=========================================================
    public void startAddingGroupQuestion() throws InterruptedException{
        Thread.sleep(1000);
        clickBtnAddQuestion();
        Thread.sleep(1000);
        clickRdbGroup();
        clickBtnOk();
    }

    public void selectGroupQuestionType(String questionType){
        Select selectQuestionType = new Select(driver.findElement(dd_selectQuestionType));
        selectQuestionType.selectByVisibleText(questionType);
    }

    public void selectIndividualQuestionType(){

    }
}

package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.*;
import org.sikuli.script.FindFailed;


import java.io.File;
import java.io.InterruptedIOException;

/**
 * Created by QA on 12/21/2016.
 */
public class AdminAddQuestionP1_G_T3 {
    Screen s;
    WebDriver driver;
    public AdminAddQuestionP1_G_T3(WebDriver driver) {this.driver = driver;}

    //=====================================Web elements=================================================================
    By dd_numOfQuestions = By.xpath("//select[@name=\"numOfQuestion\"]");
    By tf_lessonUrl = By.xpath("//input[@id='msg']");
    By tf_mainTitle = By.xpath("//textarea[@name='title']");
    By dd_subjectCategory = By.xpath("//select[@name='category']");
    By dd_subjectKeyWord = By.xpath("//select[@name='subCategory']");
    By img_uploadImageOne = By.xpath("//img");
    By btn_saveUploadedImage = By.xpath("//button[text()='Save']");
    By tf_answerOne = By.xpath("//textarea[@name='answer1']");
    By tf_answerTwo = By.xpath("//textarea[@name='answer1']/../../../../../../div[2]//textarea");
    By tf_answerThree = By.xpath("//textarea[@name='answer1']/../../../../../../div[3]//textarea");
    By rdb_selectedOption = By.xpath("//textarea[@name='answer1']/..//input");
    By tf_mark = By.xpath("//input[@name='mark']");
    By btn_saveQuestion = By.xpath("//button[contains(text(),'Priview')]/../button[2]");

    //=====================================Methods for Web elements=====================================================
    public void selectNumberOfQuestions(String numberOfQuestions){
        Select NumberOfQuestions = new Select(driver.findElement(dd_numOfQuestions));
        NumberOfQuestions.selectByVisibleText(numberOfQuestions);
    }
    public void typeLessonUrl(String lessonUrl){
        driver.findElement(tf_lessonUrl).sendKeys(lessonUrl);
    }
    public void typeQuestionMainTitle(String questionMainTitle){
        driver.findElement(tf_mainTitle).sendKeys(questionMainTitle);
    }
    public void selectSubjectCategory(String subjectCategory){
        Select SubjectCategory = new Select(driver.findElement(dd_subjectCategory));
        SubjectCategory.selectByVisibleText(subjectCategory);
    }
    public void selectSubjectKeyword(String subjectKeyword){
        Select SubjectKeyword = new Select(driver.findElement(dd_subjectKeyWord));
        SubjectKeyword.selectByVisibleText(subjectKeyword);
    }
    public void clickImageUploadAreaOne(){driver.findElement(img_uploadImageOne).click();}
    public void clickBtnSaveImageUploadOne(){
        driver.findElement(btn_saveUploadedImage).click();
    }
    public void typeAnswerOne(String answerOne){
        driver.findElement(tf_answerOne).sendKeys(answerOne);
    }
    public void typeAnswerTwo(String answerTwo){
        driver.findElement(tf_answerTwo).sendKeys(answerTwo);
    }
    public void typeAnswerThree(String answerThree){
        driver.findElement(tf_answerThree).sendKeys(answerThree);
    }
    public void clickRdbSelectedOption(){
        driver.findElement(rdb_selectedOption).click();
    }
    public void typeMarkForQuestion(String markForQuestion){
        driver.findElement(tf_mark).sendKeys(markForQuestion);
    }
    public void clickBtnSaveQuestion(){
        driver.findElement(btn_saveQuestion).click();
    }


    //=====================================Re-Usable components=========================================================
    public void uploadImageOne(String windowsUrl) throws Exception {
        Thread.sleep(1000);
        s = new Screen();
        clickImageUploadAreaOne();
        Thread.sleep(2000);
        s.find("src/test/java/Images/tf_url.PNG").click();
        s.type(Key.DELETE);
        s.find("src/test/java/Images/tf_urlEmpty.PNG").type(windowsUrl+Key.ENTER);
        Thread.sleep(2000);
        s.find("src/test/java/Images/icn_imageFolder.PNG").doubleClick();
        Thread.sleep(2000);
        s.find("src/test/java/Images/img_P1_G_T3.PNG").click();
        Thread.sleep(2000);
        s.find("src/test/java/Images/btn_openImage.PNG").click();
        Thread.sleep(2000);
        s.find("src/test/java/Images/btn_save.PNG").click();
        Thread.sleep(2000);
        s.find("src/test/java/Images/tf_answerOne.PNG").click();
      //  clickBtnSaveImageUploadOne();
        Thread.sleep(2000);
    }

    public void createP1GT3Question(String numOfQuestions, String lessonUrl, String mainTitle,String subjectCategory,String subjectKeyword,
                                    String windowsUrl, String answerOne, String answerTwo, String answerThree, String markForQuestion) throws Exception{
        selectNumberOfQuestions(numOfQuestions);
        typeLessonUrl(lessonUrl);
        typeQuestionMainTitle(mainTitle);
        selectSubjectCategory(subjectCategory);
        selectSubjectKeyword(subjectKeyword);
        uploadImageOne(windowsUrl);
        typeAnswerOne(answerOne);
        typeAnswerTwo(answerTwo);
        typeAnswerThree(answerThree);
        Thread.sleep(2000);
        clickRdbSelectedOption();
        typeMarkForQuestion(markForQuestion);
        Thread.sleep(2000);
        clickBtnSaveQuestion();
        Thread.sleep(2000);
    }

}

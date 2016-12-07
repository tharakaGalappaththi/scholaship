package testHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.logging.Logger;

/**
 * Created by QA on 12/5/2016.
 */
public class AssertHelper {
    //Verify the title of the web page
    public static void verifyAdminPageTitle(String actualTitle, String expectedTitle){
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    //Verify whether user in the admin paper set page
    public static void verifyAdminPaperSetPage(By createPaperSet, WebDriver driver){
        if( driver.findElement(createPaperSet).isEnabled()){
            System.out.println("Page is loaded");
        //    Logger.getLogger("Logging an INFO-level message");
        }else{
            System.out.println("Page is not loaded");
        }
    }

    //Verify the created paper set
    public static void verifyCreatedPaperSet(String expectedPaperSetName){
        //Assert.assertTrue(paperSetName.contains());
    }

}

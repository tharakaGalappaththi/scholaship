package scholarshipTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AdminLoginPage;
import pages.AdminPaperPage;
import pages.AdminPaperSetPage;
import testHelper.AssertHelper;


import java.util.concurrent.TimeUnit;

/**
 * Created by QA on 12/5/2016.
 */
public class SmokeTest {
	WebDriver driver;
	AdminLoginPage objLogin;
	AdminPaperSetPage objPaperSet;
	AdminPaperPage objPaper;


	@BeforeTest
	public void setup(){
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\QA\\Desktop\\UI\\scholarship\\src\\main\\resources\\geckodriver.exe"); // for selenium 3.0
		driver =new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://qa.admin.grade5.lk/"); // Go to the application under test
	}

	@Test(priority=0)
	public void smokeTest() {
		try {
			objLogin = new AdminLoginPage(driver); //Create objects of Pages
			objPaper = new AdminPaperPage(driver);
			objPaperSet = new AdminPaperSetPage(driver);

			String loginPageTitle = objLogin.getLoginTitle();
			AssertHelper.verifyAdminPageTitle(loginPageTitle,"SchoolAdminApp"); //Verify login page title
			objLogin.adminLogin("lasantha2@gmail.com", "123456"); //login to the application


			AssertHelper.verifyAdminPaperSetPage(objPaperSet.btn_createPaperSet,this.driver); //Verify landing on paper set page
			Integer randomPaperSetNum = objPaperSet.createNewPaperSet(); // Create new paper set
			objPaperSet.checkPresenceOfCreatedPaperSet(randomPaperSetNum.toString()); //Verify the created paper set
			objPaperSet.clickLblCreatedPaperSet(randomPaperSetNum.toString()); // Clicked on newly created paper set


			Integer randomPaperNum = objPaper.createNewPaper();
			objPaper.checkPresenceOfCreatedPaper(randomPaperNum.toString());
			Thread.sleep(3000);

		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void closeDriver(){
		driver.quit();
	}

	}

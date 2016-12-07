package scholarshipTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AdminLoginPage;
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

	@BeforeTest
	public void setup(){
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\QA\\Desktop\\UI\\scholarship\\src\\main\\resources\\geckodriver.exe"); // for selenium 3.0
		driver =new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://qa.admin.grade5.lk/");
	}

	@Test(priority=0)
	public void test_Home_Page_Appear_Correct() {
		try {
			//Creating objects of pages
			objLogin = new AdminLoginPage(driver);
			objPaperSet = new AdminPaperSetPage(driver);

			//Verify login page title
			String loginPageTitle = objLogin.getLoginTitle();
			//Assert.assertTrue(loginPageTitle.contains("SchoolAdminApp"));
			AssertHelper.verifyAdminPageTitle(loginPageTitle,"SchoolAdminApp");
			//login to application
			objLogin.adminLogin("lasantha2@gmail.com", "123456");

			//Verify landing on paper set page
			AssertHelper.verifyAdminPaperSetPage(objPaperSet.btn_createPaperSet,this.driver);
			Integer randomNum = objPaperSet.createNewPaperSet();
			//Verify the created paper set
			objPaperSet.checkPresenceOfCreatedPaperSet(randomNum.toString());



		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void closeDriver(){
		driver.quit();
	}

	}

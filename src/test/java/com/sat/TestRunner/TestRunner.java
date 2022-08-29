package com.sat.TestRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//	@RunWith(Cucumber.class)
	@CucumberOptions(
			features={"src/test/resources/com.sat.Features"},
			glue={"com.sat.StepDefinitions","com.sat.AppHooks"},
			monochrome=true,
			strict = true,
			plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
			//plugin={"pretty","json:target/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","html:target/cucumber-reports/report.html"},
			//tags=("@IBANnumberValidation"))
			//tags ={"@ResalRegistration or @ResalForgotpassword or @RegisteringItem"})//@ResalForgotpassword //@RegisteringItem //@ResalRegistration
	//tags= {	"@2488_DeclineItem or @2498_2495_ExpToInstore2ndTry or @2709_RelevantStoresList or @2864_BrandSettings or @2909_4289_3618_3540_AddingNewItem or @3158_3161_3033_ExpToMisBrkUnsoldarchive or @3162_ResalRegistration or @3314_CheckSoldArchieveByAdmin or @3348_CheckMissingArchieveByAdmin or @3548_3557_storeUserSOLD or @3558_4079_creatingB2Bseller or @3617_UpdateallInfobyStoreuser or @3169_3262_3269_3443_RegisteringCancellingItem or @2498_2495_ExpToInstore2ndTry or @3167_ResalForgotpassword or @3979_SingleItemToOtherStore or @3990_MultipleleItemsToOtherStore or @3799_4244_4291_3319_IBANnumberValidation or @3843_AddAgreementDetailsByBrandUser"
			
		tags= {"@3979_SingleItemToOtherStore"	
			})
	
	
	
	
	public class TestRunner extends AbstractTestNGCucumberTests{
		/* @Override
	      
	      @DataProvider(parallel = true) public Object[][] scenarios() { 
			 return super.scenarios();
		 }*/
	}
		
		/*@BeforeStep
		public void beforeStep() {
		}

		@AfterStep
		public void afterStep() {
		}

		@Before
		public void beforeScenario() {
		}

		@After
		public void afterScenario(Scenario scenario) {
//			scenario.attach(Util.takeScreenShot(), "image/png", scenario.getName());
		}*/
	
	
	//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//	import cucumber.api.CucumberOptions;
//	import cucumber.api.testng.AbstractTestNGCucumberTests;
//	@CucumberOptions(features="src/test/resources/features",glue="stepDefinitions",tags="@Test01",plugin= {"pretty", "html:target/cucumber-reports" },monochrome=true)

//public class TestRunner {
//    private TestNGCucumberRunner testNGCucumberRunner;
// 
//    @BeforeClass(alwaysRun = true)
//    public void setUpClass() throws Exception {
//        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//    }
// 
//    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
//    public void feature(CucumberFeatureWrapper cucumberFeature) {
//        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
//    }
// 
//    @DataProvider
//    public Object[][] scenarios() {
//        return testNGCucumberRunner.provideScenarios();
//    }
// 
//    @AfterClass(alwaysRun = true)
//    public void tearDownClass() throws Exception {
//        testNGCucumberRunner.finish();
//    }
//}	
//	
//		
//	

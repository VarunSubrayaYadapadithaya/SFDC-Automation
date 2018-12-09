import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper

not_run: WebUI.openBrowser('')

not_run: WebUI.maximizeWindow()

not_run: WebUI.navigateToUrl('developer.salesforce.com')

not_run: PageTitle = WebUI.getWindowTitle()

not_run: WebUI.verifyMatch(PageTitle, 'Salesforce Developers | API Documentation, Developer Forums & More', false)

not_run: if (WebUI.verifyElementPresent(findTestObject('Page_Salesforce Developers  API Doc/GDPR_Div_CloseButton'), 60, 
    FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Page_Salesforce Developers  API Doc/GDPR_Div_CloseButton'))
}

WebUI.waitForElementVisible(findTestObject('Page_Salesforce Developers  API Doc/Search_TextBox'), 60)

WebUI.scrollToElement(findTestObject('Page_Salesforce Developers  API Doc/Search_TextBox'), 60)

WebUI.setText(findTestObject('Page_Salesforce Developers  API Doc/Search_TextBox'), 'Writing Tests')

WebUI.sendKeys(findTestObject('Page_Salesforce Developers  API Doc/Search_TextBox'), Keys.chord(Keys.ENTER))

WebUI.waitForPageLoad(30, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Page_Search/a_Writing Tests  Apex Develope'), 30)

WebUI.waitForElementClickable(findTestObject('Page_Search/a_Writing Tests  Apex Develope'), 20)

WebUI.click(findTestObject('Page_Search/a_Writing Tests  Apex Develope'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

'On the Writing Tests Page, Click Link Testing Apex'
WebUI.scrollToElement(findTestObject('Page_Writing Tests  Apex Developer/a_Testing Apex'), 15)

WebUI.click(findTestObject('Page_Writing Tests  Apex Developer/a_Testing Apex'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

header = WebUI.getText(findTestObject('Page_Writing Tests  Apex Developer/h1_ContentHeader'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Page_Writing Tests  Apex Developer/h1_ContentHeader'), 10, FailureHandling.CONTINUE_ON_FAILURE)

'Verify Testing Apex page is loaded.'
WebUI.verifyElementText(findTestObject('Page_Writing Tests  Apex Developer/h1_ContentHeader'), 'Testing Apex', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()


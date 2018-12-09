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

if (WebUI.verifyElementPresent(findTestObject('Page_Salesforce Developers  API Doc/GDPR_Div_CloseButton'), 60, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Page_Salesforce Developers  API Doc/GDPR_Div_CloseButton'))
}

WebUI.waitForElementVisible(findTestObject('Page_Salesforce Developers  API Doc/Search_TextBox'), 60)

'Search for Writing Tests'
WebUI.setText(findTestObject('Page_Salesforce Developers  API Doc/Search_TextBox'), 'Writing Tests')

WebUI.sendKeys(findTestObject('Page_Salesforce Developers  API Doc/Search_TextBox'), Keys.chord(Keys.ENTER))

WebUI.waitForPageLoad(30, FailureHandling.STOP_ON_FAILURE)

'Assert Writing test page is listed'
WebUI.verifyElementPresent(findTestObject('Page_Search/a_Writing Tests  Apex Develope'), 30)

WebUI.waitForElementClickable(findTestObject('Page_Search/a_Writing Tests  Apex Develope'), 20)

WebUI.click(findTestObject('Page_Search/a_Writing Tests  Apex Develope'), FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver()

WebUI.delay(5)

int contentSize = driver.findElements(By.xpath('(//div[@class=\'toc-container\']/following::span[contains(@class,\'ng-binding ng-scope\')])')).size()

int index = 1

'Retrieve the links in the contents, click each one of them and verify links are working'
while (contentSize != index) {
    WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Page_Writing Tests  Apex Developer/ContentLinks', 
            [('x') : index]), 30)

    WebUI.scrollToElement(findTestObject('Page_Writing Tests  Apex Developer/ContentLinks', [('x') : index]), 10, FailureHandling.CONTINUE_ON_FAILURE)

    contentLinkText = WebUI.getText(findTestObject('Page_Writing Tests  Apex Developer/ContentLinks', [('x') : index]), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Page_Writing Tests  Apex Developer/ContentLinks', [('x') : index]), FailureHandling.CONTINUE_ON_FAILURE)

    // not_run: WebUI.executeJavaScript('arguments[0].click()', Arrays.asList(element), FailureHandling.CONTINUE_ON_FAILURE)
    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

    header = WebUI.getText(findTestObject('Page_Writing Tests  Apex Developer/h1_ContentHeader'), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.scrollToElement(findTestObject('Page_Writing Tests  Apex Developer/h1_ContentHeader'), 10, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementText(findTestObject('Page_Writing Tests  Apex Developer/h1_ContentHeader'), contentLinkText, FailureHandling.CONTINUE_ON_FAILURE)

    if (index == 100) {
        break
    }
    
    index++

    contentSize = driver.findElements(By.xpath('(//div[@class=\'toc-container\']/following::span[contains(@class,\'ng-binding ng-scope\')])')).size()
}

not_run: WebUI.closeBrowser()


import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.apache.commons.lang3.RandomStringUtils as RandomStringUtils

WebUI.callTestCase(findTestCase('Login/cogmento_login'), [:], FailureHandling.STOP_ON_FAILURE)


WebUI.click(findTestObject('Page_Cogmento CRM/span_Companies'))

WebUI.click(findTestObject('Page_Cogmento CRM/button_Create'))

name = RandomStringUtils.randomAlphabetic(251)

WebUI.setText(findTestObject('Page_Cogmento CRM/input_name'), name)

WebUI.click(findTestObject('Page_Cogmento CRM/button_Save'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Cogmento CRM/p_Validation error Name is longer than 250 _51c07f'), 
    'Validation error: Name is longer than 250 characters')

WebUI.closeBrowser()


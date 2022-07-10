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

Mobile.startExistingApplication(GlobalVariable.bundleID, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

Mobile.tap(findTestObject('Home/Top/btn_cart'), 0)

WebUI.delay(5)

Mobile.tap(findTestObject('Cart/Bottom/android.widget.Button - CHECKOUT'), 0)

Mobile.verifyElementVisible(findTestObject('Checkout/Body/android.widget.EditText - sanji'), 0)

Mobile.setText(findTestObject('Checkout/Body/android.widget.EditText - sanji'), 'zoro', 0)

WebUI.delay(5)

Mobile.verifyElementVisible(findTestObject('Checkout/Body/android.widget.EditText - your.emailgmail.com'), 0)

Mobile.setText(findTestObject('Checkout/Body/android.widget.EditText - your.emailgmail.com'), 'zoro@gmail.com', 0)

WebUI.delay(5)

Mobile.verifyElementVisible(findTestObject('Checkout/Body/android.widget.EditText - 628123456789'), 0)

Mobile.setText(findTestObject('Checkout/Body/android.widget.EditText - 628123456789'), '547466345', 0)

WebUI.delay(5)

Mobile.verifyElementVisible(findTestObject('Checkout/Body/android.widget.EditText - Your Address'), 0)

Mobile.setText(findTestObject('Checkout/Body/android.widget.EditText - Your Address'), 'zoro street no 8', 0)

WebUI.delay(5)

Mobile.verifyElementVisible(findTestObject('Checkout/Body/spinner_shipping'), 0)

Mobile.tap(findTestObject('Checkout/Body/spinner_shipping'), 0)

WebUI.delay(5)

Mobile.verifyElementVisible(findTestObject('Checkout/Proceed to checkout/android.widget.CheckedTextView - TNT Express'), 
    0)

Mobile.tap(findTestObject('Checkout/Proceed to checkout/android.widget.CheckedTextView - TNT Express'), 0)

Mobile.tap(findTestObject('Checkout/Bottom/android.widget.Button - PROCESS CHECKOUT'), 0)

WebUI.delay(5)

Mobile.verifyElementVisible(findTestObject('Checkout/Proceed to checkout/android.widget.TextView - Process Checkout'), 0)

Mobile.verifyElementVisible(findTestObject('Checkout/Proceed to checkout/android.widget.TextView - Are you sure want to checkout'), 
    0)

Mobile.verifyElementVisible(findTestObject('Checkout/Proceed to checkout/android.widget.Button - YES'), 0)

Mobile.verifyElementVisible(findTestObject('Checkout/Proceed to checkout/android.widget.Button - NO'), 0)

Mobile.tap(findTestObject('Checkout/Proceed to checkout/android.widget.Button - YES'), 0)

WebUI.delay(5)

Mobile.verifyElementVisible(findTestObject('Checkout/Thank you for ordering/android.widget.TextView - Congratulation'), 
    0)

Mobile.verifyElementVisible(findTestObject('Checkout/Thank you for ordering/Thank you for ordering'), 0)

Mobile.verifyElementVisible(findTestObject('Checkout/Thank you for ordering/android.widget.Button - OK'), 0)

Mobile.tap(findTestObject('Checkout/Thank you for ordering/android.widget.Button - OK'), 0)

WebUI.callTestCase(findTestCase('Close application'), [:], FailureHandling.STOP_ON_FAILURE)


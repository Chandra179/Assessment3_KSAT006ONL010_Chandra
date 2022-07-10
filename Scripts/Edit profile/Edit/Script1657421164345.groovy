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

WebUI.delay(5)

Mobile.verifyElementVisible(findTestObject('Menu/nav_profile'), 3)

Mobile.tap(findTestObject('Menu/nav_profile'), 10)

Mobile.tap(findTestObject('Profile/android.widget.TextView - EDIT'), 10)

Mobile.tap(findTestObject('Profile/Edit profile/layout_name'), 10)

Mobile.clearText(findTestObject('Profile/Edit profile/Modal name/android.widget.EditText - ,'), 5)

Mobile.setText(findTestObject('Profile/Edit profile/Modal name/android.widget.EditText - ,'), name, 10)

Mobile.tap(findTestObject('Profile/Edit profile/android.widget.Button - OK'), 5)

Mobile.verifyElementText(findTestObject('Profile/Edit profile/view_name'), name)

Mobile.tap(findTestObject('Profile/Edit profile/layout_email'), 10)

Mobile.clearText(findTestObject('Profile/Edit profile/Modal email/android.widget.EditText - your.emailgmail.com'), 5)

Mobile.setText(findTestObject('Profile/Edit profile/Modal email/android.widget.EditText - your.emailgmail.com'), email, 
    10)

Mobile.tap(findTestObject('Profile/Edit profile/android.widget.Button - OK'), 5)

Mobile.verifyElementText(findTestObject('Profile/Edit profile/view_email'), email)

Mobile.tap(findTestObject('Profile/Edit profile/layout_phone'), 10)

Mobile.clearText(findTestObject('Profile/Edit profile/Modal phone/android.widget.EditText - 628123456789'), 5)

Mobile.setText(findTestObject('Profile/Edit profile/Modal phone/android.widget.EditText - 628123456789'), phone, 10)

Mobile.tap(findTestObject('Profile/Edit profile/android.widget.Button - OK'), 5)

Mobile.verifyElementText(findTestObject('Profile/Edit profile/view_phone'), phone)

Mobile.tap(findTestObject('Profile/Edit profile/layout_address'), 10)

Mobile.clearText(findTestObject('Profile/Edit profile/Modal address/android.widget.EditText - Your Address'), 5)

Mobile.setText(findTestObject('Profile/Edit profile/Modal address/android.widget.EditText - Your Address'), address, 10)

Mobile.tap(findTestObject('Profile/Edit profile/android.widget.Button - OK'), 5)

Mobile.verifyElementText(findTestObject('Profile/Edit profile/view_address'), address)

WebUI.callTestCase(findTestCase('Close application'), [:], FailureHandling.STOP_ON_FAILURE)


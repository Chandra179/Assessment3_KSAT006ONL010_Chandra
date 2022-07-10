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

// ====================================
// CURRENT XPATH INDEX
// ====================================
Integer currIdx = 1


// ====================================
// PRODUCT IMAGE XPATH : HOME PAGE
// ====================================
String imageXpath = '\n//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/\nandroid.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/\nandroid.widget.RelativeLayout[1]/android.view.ViewGroup[1]/android.support.v4.view.ViewPager[1]/\nandroid.widget.LinearLayout[1]/android.view.ViewGroup[1]/android.support.v7.widget.RecyclerView[1]/\nandroid.widget.FrameLayout[\n'
String imageXpath2 = '\n]/android.widget.RelativeLayout[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]\n'
String imageFullXpath = (imageXpath + currIdx) + imageXpath2

def imageObject = CustomKeywords.'tesPackage.loopXpath.getTestObjectWithXpath'(imageFullXpath)


// =============================================
// PRODUCT DETAILS XPATH  : PRODUCT DETAILS PAGE
// ==============================================
String textXpath = '\n//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/\nandroid.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/\nandroid.widget.RelativeLayout[1]/android.view.ViewGroup[1]/android.support.v4.view.ViewPager[1]/\nandroid.widget.LinearLayout[1]/android.view.ViewGroup[1]/android.support.v7.widget.RecyclerView[1]/\nandroid.widget.FrameLayout[\n'
String textNameXpath = '\n]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]\n'
String textPriceXpath = '\n]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]\n'
String nameFullXpath = (textXpath + currIdx) + textNameXpath
String priceFullXpath = (textXpath + currIdx) + textPriceXpath

def nameObject = CustomKeywords.'tesPackage.loopXpath.getTestObjectWithXpath'(nameFullXpath)
def priceObject = CustomKeywords.'tesPackage.loopXpath.getTestObjectWithXpath'(priceFullXpath)


// ====================================
// CART XPATH : CART PAGE
// ====================================
String cartItemXpath = """
//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[
"""

String cartItemNameXpath = """
]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]
"""

String cartItemPriceXQtyXpath = """
]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]
"""

String cartSubTotalXpath = """
]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]
"""

String cartItemNameFullXpath = (cartItemXpath + currIdx) + cartItemNameXpath
String cartItemPriceXQtyFullXpath = (cartItemXpath + currIdx) + cartItemPriceXQtyXpath
String cartSubTotalFullXpath = (cartItemXpath + currIdx) + cartSubTotalXpath

def cartNameObject = CustomKeywords.'tesPackage.loopXpath.getTestObjectWithXpath'(cartItemNameFullXpath)
def cartPriceObject = CustomKeywords.'tesPackage.loopXpath.getTestObjectWithXpath'(cartItemPriceXQtyFullXpath)
def cartSubTotalObject = CustomKeywords.'tesPackage.loopXpath.getTestObjectWithXpath'(cartSubTotalFullXpath)


// Only 3 object, dont know how to perform scroll while looping
while (currIdx < 4) {
	
	Mobile.delay(5)
	
	// =============================================
	// GET PRODUCT INFORMATION : HOME PAGE
	// =============================================
    def name1 = Mobile.getText(nameObject, 0)
    def price1 = Mobile.getText(priceObject, 0)

	
	// =============================================
	// GO TO PRODUCT DETAILS
	// =============================================
    Mobile.tap(imageObject, 0)

	
    // =============================================
    // GET PRODUCT DETAIL INFORMATION : PRODUCT PAGE
	// =============================================
    def name2 = Mobile.getText(findTestObject('Product details/Body/product_name'), 0)
    def price2 = Mobile.getText(findTestObject('Product details/Body/price'), 0)

	
    // =============================================
    // VERIFY PRODUCT DETAILS ITEM : CART PAGE
	// =============================================
    Mobile.verifyElementVisible(findTestObject('Object Repository/Product details/Body/icon_price'), 0)
    Mobile.verifyElementVisible(findTestObject('Object Repository/Product details/Body/icon_items'), 0)
    Mobile.verifyMatch(name1, name2, false)
    Mobile.verifyMatch(price1, price2, false)

	
	// =============================================
    // ADD PRODUCT TO CART : PRODUCT DETAILS PAGE
	// =============================================
    Mobile.tap(findTestObject('Object Repository/Product details/Bottom/android.widget.Button - ADD TO CART'), 3)
    Mobile.waitForElementPresent(findTestObject('Object Repository/Product details/Input quantity/android.widget.EditText'), 3)
    Mobile.setText(findTestObject('Object Repository/Product details/Input quantity/android.widget.EditText'), '2', 3)
    Mobile.tap(findTestObject('Object Repository/Product details/Input quantity/android.widget.Button - ADD'), 3)

	
	// =============================================
	// VERIFY CART ITEMS : CART PAGE
	// =============================================
	Mobile.tap(findTestObject('Object Repository/Product details/Top/btn_cart'), currIdx)
	Mobile.verifyElementVisible(cartPriceObject, 0)
	Mobile.verifyElementVisible(cartSubTotalObject, 0)
	
	def name3 = Mobile.getText(cartNameObject, 0)
	Mobile.verifyMatch(name2, name3, false)
	
	
	// =============================================
    // BACK
	// =============================================
    Mobile.tap(findTestObject('Object Repository/Cart/Top/btn_back'), 0) // back to product details page
	Mobile.delay(5)
    Mobile.tap(findTestObject('Object Repository/Product details/Top/btn_back'), 0) // back to home page
	
	
	// =============================================
    // INCREMENT XPATH INDEX
	// =============================================
    currIdx += 1
    imageFullXpath = ((imageXpath + currIdx) + imageXpath2)
    nameFullXpath = ((textXpath + currIdx) + textNameXpath)
    priceFullXpath = ((textXpath + currIdx) + textPriceXpath)
	
	cartItemNameFullXpath = (cartItemXpath + currIdx) + cartItemNameXpath
	cartItemPriceXQtyFullXpath = (cartItemXpath + currIdx) + cartItemPriceXQtyXpath
	cartSubTotalFullXpath = (cartItemXpath + currIdx) + cartSubTotalXpath
	
	
	// =============================================
	// UPDATE TEST OBJECT
	// =============================================
    nameObject = CustomKeywords.'tesPackage.loopXpath.getTestObjectWithXpath'(nameFullXpath)
    priceObject = CustomKeywords.'tesPackage.loopXpath.getTestObjectWithXpath'(priceFullXpath)
    imageObject = CustomKeywords.'tesPackage.loopXpath.getTestObjectWithXpath'(priceFullXpath)
	
	cartNameObject = CustomKeywords.'tesPackage.loopXpath.getTestObjectWithXpath'(cartItemNameFullXpath)
	cartPriceObject = CustomKeywords.'tesPackage.loopXpath.getTestObjectWithXpath'(cartItemPriceXQtyFullXpath)
	cartSubTotalObject = CustomKeywords.'tesPackage.loopXpath.getTestObjectWithXpath'(cartSubTotalFullXpath)
}

WebUI.callTestCase(findTestCase('Close application'), [:], FailureHandling.STOP_ON_FAILURE)


package helpers.com.randrmusic.ios.system.settings.page;

import framework.Loggable;
import framework.dataobjects.UserObject;
import helpers.BasePage;
import helpers.com.randrmusic.ios.system.main.data.MainPageDataProviders;
import helpers.com.randrmusic.ios.system.settings.data.SettingsPageDataProviders;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.WaitUtils;

/**
 * Created by admin on 26.05.14.
 */
public class FacebookSettingsPage extends BasePage implements Loggable, SettingsPageDataProviders, MainPageDataProviders {

    @FindBy(how = How.NAME, using = SettingsPageDataProviders.FacebookUserName)
    WebElement facebookUserName;
    @FindBy(how = How.NAME, using = SettingsPageDataProviders.FacebookPassword)
    WebElement facebookPassword;
    @FindBy(how = How.XPATH, using = SettingsPageDataProviders.FacebookSignIn)
    WebElement facebookSignIn;
    @FindBy(how = How.XPATH, using = SettingsPageDataProviders.FacebookSignInApprove)
    WebElement facebookSignInApprove;
    @FindBy(how = How.NAME, using = SettingsPageDataProviders.FacebooKUserInfo)
    WebElement facebookUserInfo;

    @FindBy(how = How.XPATH, using = MainPageDataProviders.letterA)
    WebElement letterA;
    @FindBy(how = How.XPATH, using = MainPageDataProviders.letterR)
    WebElement letterR;
    @FindBy(how = How.XPATH, using = MainPageDataProviders.letterT)
    WebElement letterT;
    @FindBy(how = How.XPATH, using = MainPageDataProviders.letterI)
    WebElement letterI;
    @FindBy(how = How.XPATH, using = MainPageDataProviders.letterO)
    WebElement letterO;
    @FindBy(how = How.XPATH, using = MainPageDataProviders.letterM)
    WebElement letterM;
    @FindBy(how = How.XPATH, using = MainPageDataProviders.letterY)
    WebElement letterY;
    @FindBy(how = How.XPATH, using = MainPageDataProviders.letterK)
    WebElement letterK;
    @FindBy(how = How.XPATH, using = MainPageDataProviders.letterH)
    WebElement letterH;
    @FindBy(how = How.XPATH, using = MainPageDataProviders.letterN)
    WebElement letterN;
    @FindBy(how = How.XPATH, using = MainPageDataProviders.letterV)
    WebElement letterV;
    @FindBy(how = How.XPATH, using = MainPageDataProviders.letterD)
    WebElement letterD;
    @FindBy(how = How.XPATH, using = MainPageDataProviders.letterU)
    WebElement letterU;
    @FindBy(how = How.XPATH, using = MainPageDataProviders.letterS)
    WebElement letterS;
    @FindBy(how = How.XPATH, using = MainPageDataProviders.letterC)
    WebElement letterC;

    @FindBy(how = How.XPATH, using = MainPageDataProviders.moreKey)
    WebElement moreKey;
    @FindBy(how = How.XPATH, using = MainPageDataProviders.abcKey)
    WebElement abcKey;
    @FindBy(how = How.XPATH, using = MainPageDataProviders.dotAddKey)
    WebElement dotAddKey;
    @FindBy(how = How.XPATH, using = MainPageDataProviders.atKey)
    WebElement atKey;
    @FindBy(how = How.XPATH, using = MainPageDataProviders.dotKey)
    WebElement dotKey;
    @FindBy(how = How.XPATH, using = MainPageDataProviders.returnKey)
    WebElement returnKey;

    public void signIn(UserObject user) {
        LOG_STEP.info("User fills email field");
        facebookUserName.click();
        enterFacebookUserName();
        returnKey.click();
        LOG_STEP.info("User fills password field");
        enterFacebookUserPassword();
        LOG_STEP.info("User clicks on Sign In button");
        facebookSignIn.click();
        WaitUtils.waitForResult(6);
        LOG_STEP.info("User approve to sign in");
        facebookSignInApprove.click();
        WaitUtils.waitForResult(5);
    }

    public void checkLoggedInUser() {
        LOG_STEP.info("System checks if user is logged in");
        Assert.assertTrue(facebookUserInfo.isDisplayed(),"User is not logged in");
    }

    /**
     * Enter default user name
     * P.S.: This method is look very dummy, but I cannot find other solution for now :(
     */
    private void enterFacebookUserName() {
        letterA.click();
        letterR.click();
        letterT.click();
        letterI.click();
        letterO.click();
        letterM.click();
        dotKey.click();
        letterT.click();
        atKey.click();
        letterR.click();
        letterA.click();
        letterN.click();
        letterD.click();
        letterR.click();
        letterM.click();
        letterU.click();
        letterS.click();
        letterI.click();
        letterC.click();
        dotKey.click();
        letterC.click();
        letterO.click();
        letterM.click();
    }

    /**
     * Enter default user facebook password
     * P.S:Dummy method#2. Shame on me :(
     */
    private void enterFacebookUserPassword() {
        letterA.click();
        letterR.click();
        letterT.click();
        moreKey.click();
        dotAddKey.click();
        abcKey.click();
        letterT.click();
        letterY.click();
        letterK.click();
        letterH.click();
    }
}

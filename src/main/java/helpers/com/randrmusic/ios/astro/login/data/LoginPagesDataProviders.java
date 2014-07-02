package helpers.com.randrmusic.ios.astro.login.data;

/**
 * Created by admin on 20.05.14.
 */
public interface LoginPagesDataProviders {

    // Sign In
    String EmailSignIn = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAImage[1]/UIATextField[1]";
    String PasswordSignIn = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAImage[1]/UIASecureTextField[1]";

    String SignInButton = "Log in";

    String SignInFacebook = "Sign in with Facebook";
    String AllowFacebookAccessToProfile = "//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIATableView[2]/UIATableCell[1]";

    String IncorrectCredentialsError = "//UIAApplication[1]/UIAWindow[3]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[1]";
    String IncorrectCredentialsErrorText = "Something went wrong. Please check your login details. If you don't have an account yet, please register on the Astro web page";
}

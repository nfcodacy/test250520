package web;

import basetest.BaseCodacyTest;
import com.codacy.web.login.Authentication;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static basetest.BaseCodacyTest.Group.AUTHENTICATION;
import static basetest.BaseCodacyTest.Group.INTEGRATIONS;

@Test(groups = {AUTHENTICATION, INTEGRATIONS})
public class TC_59_LoginWithGitLab extends BaseCodacyTest {

    private Authentication authentication;

    @BeforeClass
    public void tc59setup() {
        authentication = new Authentication(driver, config);
    }

    @Test
    public void tc59CheckIfLoginRedirectsToGitLab_onLandingPage() {
        authentication
                .goToLoginPage()
                .declineCookiesIfNecessary()
                .assertGitLabLoginRedirection();
    }

    @Test
    public void tc59CheckIfLoginRedirectsToGitLab_onAppPage() {
        authentication
                .goToAppLoginPage()
                .assertGitLabLoginRedirection();
    }
}

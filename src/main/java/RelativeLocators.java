import com.microsoft.playwright.*;

import java.util.List;

public class RelativeLocators {
    static Page page;
    public static void main(String[] args) {

        Playwright playwright=Playwright.create();
        Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        page = browser.newPage();
        page.navigate("https://selectorshub.com/xpath-practice-page/");
        //page.locator("input[type='checkbox']:left-of(:text('Joe.Root'))").first().click();
        selectUser("Joe.Root");
        selectUser("Jasmine.Morgan");
//        System.out.print(getUserRole("Joe.Root"));

//        String aboveUser = page.locator("a:above(:text('Joe.Root'))").first().textContent();
//        System.out.print(aboveUser);
//
//        String belowUser = page.locator("a:below(:text('Joe.Root'))").first().textContent();
//        System.out.print(belowUser);

        Locator nearElements = page.locator("td:near(:text('Joe.Root'),200)");

        List<String> nearEleText =nearElements.allInnerTexts();

        for(String e:nearEleText){
            System.out.print(e);
        }

        browser.close();
        playwright.close();
    }

    public static void selectUser(String username){
        page.locator("input[type='checkbox']:left-of(:text('"+username+"'))").first().click();
    }
//    public static String getUserRole(String username){
//        return page.locator("td:right-of(:text('"+username+"'))").textContent();
//    }
}

import com.microsoft.playwright.*;

public class HasElements {

    public static void main(String[] args) {

        Playwright playwright=Playwright.create();
        Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context=browser.newContext();
        Page page =  context.newPage();
        page.navigate("https://www.orangehrm.com/en/contact-sales/");
        Locator locator=page.locator("select#Form_getForm_Country:has(option[value='India'])");
        locator.allInnerTexts().forEach(e->System.out.print(e));


        Page page1 = context.newPage();
        page1.navigate("https://www.amazon.com");
        Locator locator1=page1.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs'])");
        locator1.allInnerTexts().forEach(a->System.out.print(a));



        browser.close();
        playwright.close();

    }
}

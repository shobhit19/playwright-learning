import com.microsoft.playwright.*;

import java.util.List;

public class LocatorConcept {
    public static void main(String []rags){

        Playwright playwright=Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();

        launchOptions.setChannel("chrome");
        launchOptions.setHeadless(false);

        Browser browser=playwright.chromium().launch(launchOptions);
        Page page = browser.newPage();

        // single element
//        page.navigate("https://www.orangehrm.com/");
//        Locator contactSales = page.locator("text = CONTACT SALES");
//        contactSales.hover();
//        contactSales.click();

        // multiple elements
//        page.navigate("https://academy.naveenautomationlabs.com/");
//        Locator loginBtn=page.locator("text = Login");
//        int loginCount = loginBtn.count();
//        System.out.println(loginCount);
//
//        loginBtn.first().click(); // first() method is in-built in Playwright and clicks on first element
//        loginBtn.last().click(); // last() method in in-built in Playwright and clicks on last element

        // multiple elements
        page.navigate("https://www.orangehrm.com/en/orangehrm-30-day-trial");
        Locator countryOptions=page.locator("//select[@id='Form_getForm_Country']/option");
        for(int i=0;i<countryOptions.count();i++){
             String text=countryOptions.nth(i).textContent();
             System.out.println(text);
        }

        // multiple elements using allTextContents() that will return List<String>
        List<String> listCountry =countryOptions.allTextContents();
        for(String e:listCountry){
            System.out.println(e);
        }



    }
}

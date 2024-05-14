import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class GetByLocatorsDemo {

    public static void main(String[] args) {


        Playwright playwright=Playwright.create();
        Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://bookcart.azurewebsites.net/");
        page.getByText("Login");
        page.getByLabel("username").type("ortoni");
        page.getByLabel("password").type("Pass1234$");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"))
                .last()
                    .click();
        page.getByPlaceholder("Search books or authors").type("The Hate U Give");
        page.getByRole(AriaRole.OPTION).first().click();
        page.getByAltText("Book cover image").click();
        System.out.println(page.url());

        playwright.close();

    }
}

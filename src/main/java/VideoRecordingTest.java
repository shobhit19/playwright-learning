import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class VideoRecordingTest {

    public static void main(String []args){

        Playwright playwright = Playwright.create();
        Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

        BrowserContext context =browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myVideos/")));

        Page page = context.newPage();

        page.navigate("https://www.google.co.in/");
        page.navigate("https://www.google.co.in/");

        page.close();
        context.close();
        playwright.close();
    }
}

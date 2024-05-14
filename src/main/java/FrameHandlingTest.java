import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.util.List;
import java.util.regex.Pattern;

public class FrameHandlingTest {

    @Test
    public void handleSingleFrame(){

        Page page=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)).newPage();

        page.navigate("https://dev.automationtesting.in/frames");

        page.frameLocator("//iframe[@name='single iframe']").locator("//input[@name='email']").fill("Playwright");

        page.close();

    }

    @Test
    public void handleMultipleFrames(){
        Page page=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)).newPage();

        page.navigate("https://dev.automationtesting.in/frames");

        page.click("text = Nested iFrames");
        page.frameLocator("//iframe[@name='Multiple iFrame']").frameLocator("//iframe[@name='single iframe']").locator("//input[@name='email']").fill("Playwright");

        page.close();
    }

    @Test
    public void usingFrameAttribute(){
        Page page=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)).newPage();

        page.navigate("https://dev.automationtesting.in/frames");

        Frame frame=page.frame("single iframe");

        frame.locator("//input[@name='email']").fill("Playwright");

        page.close();

    }

    // https://www.youtube.com/watch?v=FDTFu_rZSqg - by LetCode with Kaushik

    @Test
    public void learnFrames(){

        Playwright playwright=Playwright.create();
        Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        Page page = browser.newPage();
        page.navigate("https://letcode.in/frame");

        //1
        List<Frame> list=page.frames();
        System.out.println(list.size());

        //2
        Frame frame=page.frame("firstFr");
        frame.getByPlaceholder("Enter name").type("test");
        frame.getByPlaceholder("Enter email").type("test 1");

        //3
        List<Frame> childFrames=frame.childFrames();
        System.out.println(childFrames.size());

        //4
        childFrames.forEach(e->System.out.println(e.url()));



        // 5
//        Frame innerFrame = page.frameByUrl("https://letcode.in/innerFrame");
        Frame innerFrame =  page.frameByUrl(Pattern.compile("innerFrame"));
        innerFrame.getByPlaceholder("Enter email").type("fr3kfr3@gmail.com");
        playwright.close();


    }

}

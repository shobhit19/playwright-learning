import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Base64;

public class VisualTesting {

    static String imageDataStored;
    public static void main(String []args){

        String path = "screenshots/visual_Testing.png";
        Playwright playwright=Playwright.create();
        Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
                .setChannel("chrome"));
        Page page=browser.newPage();
        page.navigate("https://naveenautomationlabs.com/opencart/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path))
                .setFullPage(true));

        Assert.assertEquals(encodedPicture(path),getImageDataFromSavedFile());
        playwright.close();
    }
    private static String encodedPicture(String path){
        String encodedImage = null;
        try{
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            byte[] imageData = new byte[(int) file.length()];
            fis.read(imageData);


            // Encode the image to Base 64
            encodedImage=Base64.getEncoder().encodeToString(imageData);
            FileUtils.write(new File("data.txt"),encodedImage, StandardCharsets.UTF_8);
            System.out.println("text of the screenshot "+encodedImage);
            fis.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return encodedImage;
    }

    public static String getImageDataFromSavedFile() {
        String fileContent = null;
        try {
            fileContent = FileUtils.readFileToString(new File("data.txt"), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}

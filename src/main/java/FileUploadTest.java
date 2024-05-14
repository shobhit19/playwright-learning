import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUploadTest {

public static void main(String []agrd){

    Playwright playwright = Playwright.create();

    Page page=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome")).newPage();

    page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");

//    // imput type = file
//
//    // select one file
//    page.setInputFiles("input#filesToUpload", Paths.get("C:\\Users\\shobhit\\Downloads\\testERP (1) (2).txt"));
//
//    // de select the same file
//    page.setInputFiles("//input[@id='filesToUpload']",new Path[0]);
//
//
//    // multiple files:
//    page.setInputFiles("//input[@id='filesToUpload']", new Path[] {Paths.get("fullPage/.png"),Paths.get("emailField.png")});
//
//    // deselect files:
//    page.setInputFiles("//input[@id='filesToUpload']",new Path[0]);



    // create a file at run time and upload it
    page.setInputFiles("//input[@id='filesToUpload']",new FilePayload("Shobhit.txt","text/plain","this is shobhit here".getBytes(StandardCharsets.UTF_8)));


    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

    // de select the same file
    page.setInputFiles("//input[@id='filesToUpload']",new Path[0]);

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

    page.close();
    playwright.close();

}

}

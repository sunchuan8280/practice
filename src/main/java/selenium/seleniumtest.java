package selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
/**
 * Created by chuan on 2018/10/5.
 */
public class seleniumtest {

    public static void main(String[] args){
        System.setProperty("webdriver.firefox.marionette", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");

        FirefoxDriver firefoxDriver=new FirefoxDriver();
        firefoxDriver.get("https://www.baidu.com");
        FirefoxDriver firefoxDriver2=new FirefoxDriver();
        firefoxDriver2.manage().window().maximize();
        firefoxDriver.manage().window().maximize();
        firefoxDriver.manage().window().setSize(new Dimension(100,100));
        firefoxDriver2.manage().window().maximize();
        firefoxDriver2.manage().window().setSize(new Dimension(100,100));
        firefoxDriver.manage().window().maximize();
        System.out.println(firefoxDriver2.getWindowHandles());
        System.out.println(firefoxDriver.getWindowHandles());
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyPress(KeyEvent.VK_N);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_N);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

package selenium;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
/**
 * Created by chuan on 2018/10/5.
 */
public class RobotTest {
    public static void main(String[] args){
        try {
            Thread.sleep(5000);
            Robot robot = new Robot();
            //鼠标移动到坐标(635,454)
            RobotTest.clickMouse(robot, 673, 415, 500);

            int[] keys = {
                    KeyEvent.VK_W,KeyEvent.VK_A,
                    KeyEvent.VK_N,KeyEvent.VK_G,
                    KeyEvent.VK_T,KeyEvent.VK_I,
                    KeyEvent.VK_A,KeyEvent.VK_N,
                    KeyEvent.VK_Z,KeyEvent.VK_E};
            robot.delay(500);
            RobotTest.pressKey(robot,keys,500);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void pressKey(Robot robot, int[] keys, int delay){
        for(int i=0;i<keys.length;i++){
            System.out.println(keys[i]);
            robot.keyPress(keys[i]);

            robot.keyRelease(keys[i]);
            robot.delay(500);
        }
        //处理完需要延迟
        robot.delay(delay);
    }

    public static void clickMouse(Robot robot, int x, int y, int delay){
        robot.mouseMove(x, y);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(delay);
    }

}
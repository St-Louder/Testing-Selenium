package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class DemoGuru99Test {
    private static WebDriver myBrowser;
    @Test // Test Case #1: Check login sucessfull with
    // manager
    // steps
    // 1. OPEN A CERTAIN browser, e.g. chorme
    // 2. Navigate to the login page typing the url
    //  https://demo.guru99.com/v4
    // input a valid manager account. e.g mngr577497/esytegE
    // 4. hit login button to login to the system with admin role
    // expected result:
    // the admin page appears with the welcome message
    // in the format of : manager Id: <user.name>
        // e.g with the above account
    // manager ID =mngr577497
    // Status: nhờ dân qc khác , test thử xem tính năng chạy đúng không ?
    // đúng - ghi passed
    // sai - ghi failed , mô tả lại tình huống này trên jira , bugzilla -> log bug
    // nếu việc test chạy bằng cơm manual testing
    // néu việc động hóa việc này , kể cả báo đúng sai ( xanh đỏ ) gọi là test tự động test automaction
    // dân qc phải biết viết code để tự đông hóa quá trình kiểm thử
    // code này gọi là test script, test automation script

    public void testLoginGivenRightManagerAccoountRunsWell() throws InterruptedException {
        // test script
        myBrowser.get("https://demo.guru99.com/v4");

        // Sử dụng WebDriverWait để chờ đợi các phần tử xuất hiện
//        WebDriverWait wait = new WebDriverWait(myBrowser, Duration.ofMillis(50));
//        WebElement txtUserName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='uid']")));
//        txtUserName.sendKeys("mngr577497");
//        WebElement txtPassWord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
//        txtPassWord.sendKeys("esytegE");
//        WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='btnLogin']")));
//        btnLogin.click();
        WebElement txtUserName = myBrowser.findElement(By.xpath("//input[@name='uid']"));
        txtUserName.sendKeys("mngr577497");
        WebElement txtPassword = myBrowser.findElement(By.xpath("//input[@name='password']"));
        txtPassword.sendKeys("esytegE");
        WebElement btnLogin = myBrowser.findElement(By.xpath("//input[@name='btnLogin']"));
        btnLogin.click();
        // cực kì quan trọng ở đoạn code dưới hành động click login btn
        // vì lúc này đổi trang mới, mybrowser sẽ tải trang mainmenu về ram máy tính mình
        // nhưng do tải trang mới trên mạng thì có thể bị lag => nên trang chưa kịp tải về
        // nhưng code ở đây lại đi tìm ngay tại hello của trang Main Menu
        // vì tiến trình tải trang về trình duyệt và đoạn code này là 2 tiến trình độc lập nhau bất đồng bộ
        // bắt code java chờ 1 chút để trang main menu về máy mình , rồi mới đi tìm tag hello
        // khái niệm wait là khái niệm cực kì quan trọng trong code test automation
        // có 2 kĩ thuật wait: bắt trình duyệt chờ hoặc bắt code mình chờ.
        Thread.sleep(5000);
        // did tìm tag hello do đã tải về
        WebElement lbHelo = myBrowser.findElement(By.cssSelector("tr[class='heading3'] td"));
        System.out.println(lbHelo.getText()); // lấy value trong thẻ <td>
        // xanh đỏ luôn - mượn ké JUnit
        assertEquals("Manger Id : mngr577497", lbHelo.getText());
        // muốn dáp dụng DDT : là mảng 2 chiều gồm các cặp user/ pass
        //  đẩy vào hàm này, thêm 2 đầu vào user, pass ghép chuỗi assertEquals()
        }
    @BeforeAll // hàm này sẽ chạy 1 lần duy nhất trước tất cả các hàm @Test
    // thường được dùng để khởi đôngj biến dùng chung trong các hàm @Test hay chuẩn bị data,... cho mọi hàm @Test
    public static void setup(){
        System.setProperty("webdriver.edge.driver","msedgedriver.exe");

        EdgeOptions otps = new EdgeOptions();
        
        otps.addArguments("-inprivate");
        http://www.lingoes.net/en/translator/langcode.htm
        otps.addArguments("--lang=vi-VN");
        myBrowser = new EdgeDriver(otps);
        // biến mybrowser lúc này chính là object trình duyệt
        // sai khiến nó làm gì thì gọi nó là chấm các hàm của nó
        myBrowser.manage().window().maximize();

    }
    @AfterAll
    // chạy 1 lần duy nhất, sau khi tất cả vài trăm @Test  đã chạy xong
    // rác trong quá trình test các chức năng
    public static void  teardown() throws InterruptedException {
        Thread.sleep(8000);
        myBrowser.quit();
    }
}
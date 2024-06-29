package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver","msedgedriver.exe");

        EdgeOptions otps = new EdgeOptions();
        otps.addArguments("-inprivate");
        otps.addArguments("--lang=ja-JP");
        WebDriver myBrowser = new EdgeDriver(otps);
        // biến mybrowser lúc này chính là object trình duyệt
        // sai khiến nó làm gì thì gọi nó là chấm các hàm của nó
        myBrowser.manage().window().maximize();
        myBrowser.get("https://google.com");
        WebElement searchBox = myBrowser.findElement(By.name("q"));
        searchBox.sendKeys("Đừng làm trái tim anh đau");
        searchBox.submit();
        Thread.sleep(10000);
        myBrowser.quit(); // quit tử tế nó sẽ gỡ driver nó ra

    }
}
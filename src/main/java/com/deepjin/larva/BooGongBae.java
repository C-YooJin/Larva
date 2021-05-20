package com.deepjin.larva;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BooGongBae {
    public static void main(String[] args) {

        BooGongBae crawler = new BooGongBae();
        crawler.crawl();

    }

    //WebDriver
    private WebDriver driver;

    // Logger
    private static final Logger logger = LoggerFactory.getLogger(BooGongBae.class);

    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    //    public static final String WEB_DRIVER_PATH = "/Users/user/Documents/etc/chromedriver";
    public static final String WEB_DRIVER_PATH = "/usr/local/bin/chromedriver";

    //크롤링 할 URL
    private String base_url;

    public BooGongBae() {
        super();

        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        // Options for driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");   // 팝업창 무시

        //Driver SetUp
        driver = new ChromeDriver();
        base_url = "https://www.naver.com";
    }

    public void crawl() {

        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            driver.get(base_url);

            WebElement test = driver.findElement(By.xpath("//*[@id=\"themecast\"]/div[1]/div[1]"));
            System.out.println(test.getText());

            WebElement intoLogin = driver.findElement(By.xpath("//*[@id=\"account\"]/a"));
            intoLogin.click();
            driver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys("아이디입력");
            driver.findElement(By.xpath("//*[@id=\"pw\"]")).sendKeys("비번입력");
            WebElement completeLogin = driver.findElement(By.xpath("//*[@id=\"log.login\"]"));
            completeLogin.click();
//
//            WebElement after = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div/div[1]/a[1]"));
//            System.out.println(after.getText());


        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}

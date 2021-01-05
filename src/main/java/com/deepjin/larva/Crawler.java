package com.deepjin.larva;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Crawler {
    public static void main(String[] args) {

        Crawler crawler = new Crawler();
        crawler.crawl();

    }

    //WebDriver
    private WebDriver driver;

    // Logger
    private static final Logger logger = LoggerFactory.getLogger(Crawler.class);

    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "/Users/user/Documents/etc/chromedriver";

    //크롤링 할 URL
    private String base_url;

    public Crawler() {
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
//            driver.findElement(By.xpath("//*[@id=\"themecast\"]/div[2]/div[1]/div/ul/li[1]/a[2]/strong"));
            WebElement test = driver.findElement(By.xpath("//*[@id=\"NM_FAVORITE\"]/div[1]/ul[1]/li[5]/a"));
            test.click();
            WebElement afterClick = driver.findElement(By.xpath("//*[@id=\"gnb_menu_layer\"]/li[2]/a/em/span"));
            System.out.println("Result After Click");
            System.out.println(afterClick.getText());

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            driver.close();
        }

    }
}

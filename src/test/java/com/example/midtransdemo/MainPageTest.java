package com.example.midtransdemo;

import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.*;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();
    Faker faker = new Faker();

    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        ChromeOptions options = new ChromeOptions();
//        options.setBinary("/opt/hostedtoolcache/chromium/1084013/x64/chrome");
        List<String> args = Arrays.asList("--disable-infobars", "--headless", "--no-sandbox", "--disable-gpu", "--disable-setuid-sandbox", "--disable-dev-shm-usage");
        options.addArguments(args);
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
//        Configuration.browserBinary = "/opt/hostedtoolcache/chromium/1084013/x64/chrome";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        open("https://demo.midtrans.com/");
    }

    @Test
    public void checkout() {
        mainPage.buyNowButton.click();
        mainPage.inputName.setValue(String.valueOf(faker.name().name()));
        mainPage.inputEmail.setValue(faker.internet().emailAddress());
        mainPage.inputPhone.setValue(faker.phoneNumber().phoneNumber().toString());
        mainPage.inputCity.setValue(faker.address().cityName());
        mainPage.inputAddress.setValue(faker.address().fullAddress());
        mainPage.inputPostalCode.setValue(faker.address().zipCode());
        mainPage.checkoutButton.click();
        assertEquals(mainPage.iframeCheckout.isDisplayed(), true);
    }

    @Test
    public void payment() {
        this.checkout();
        Selenide.switchTo().frame(0);
        mainPage.creditCardButton.click();
        mainPage.inputCreditCardNumber.setValue("5211111111111117");
        mainPage.inputCardExpiry.setValue("1225");
        mainPage.inputCardCVV.setValue("123");
        mainPage.inputCreditCardNumber.click();
        mainPage.payNowButton.click();
        Selenide.sleep(5000);
        Selenide.switchTo().frame(0);
        mainPage.inputOTP.shouldHave(appear,Duration.ofSeconds(10));
        mainPage.inputOTP.setValue("112233");
        mainPage.okButton.click();
        Selenide.sleep(5000);
        assertEquals(mainPage.statusSuccessLabel.shouldHave(appear, Duration.ofSeconds(5)).isDisplayed(), true);
    }
}

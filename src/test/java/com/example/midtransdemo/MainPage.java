package com.example.midtransdemo;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://demo.midtrans.com/
public class MainPage {
    public SelenideElement buyNowButton = $x("//*[@data-reactid='.0.0.0.2.0.0.5']");
    public SelenideElement inputName = $x("//*[@data-reactid='.0.0.1.0.3.0.0.0.1.0']");
    public SelenideElement inputEmail = $x("//*[@data-reactid='.0.0.1.0.3.0.0.1.1.0']");
    public SelenideElement inputPhone = $x("//*[@data-reactid='.0.0.1.0.3.0.0.2.1.0']");
    public SelenideElement inputCity = $x("//*[@data-reactid='.0.0.1.0.3.0.0.3.1.0']");
    public SelenideElement inputAddress = $x("//*[@data-reactid='.0.0.1.0.3.0.0.4.1.0']");
    public SelenideElement inputPostalCode = $x("//*[@data-reactid='.0.0.1.0.3.0.0.5.1.0']");
    public SelenideElement checkoutButton = $(".cart-checkout");
    public SelenideElement iframeCheckout = $("#snap-midtrans");
    public SelenideElement creditCardButton = $x("//a[@href='#/credit-card']");
    public SelenideElement inputCreditCardNumber = $x("//*[@class='card-number-input-container']/input");
    public SelenideElement inputCardExpiry = $x("//*[@id='card-expiry']");
    public SelenideElement inputCardCVV = $x("//*[@id='card-cvv']");
    public SelenideElement payNowButton = $x("//*[@class='card-pay-button-part']/button");
    public SelenideElement inputOTP = $x("//*[@id='otp']");
    public SelenideElement okButton = $x("//*[@name='ok']");
    public SelenideElement statusSuccessLabel = $x("//*[@class='trans-status trans-success']");

}

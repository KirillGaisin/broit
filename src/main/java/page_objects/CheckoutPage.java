package page_objects;

import org.openqa.selenium.By;

public class CheckoutPage {
    public static final By personalInfoHeader = By.xpath("//*[@id='checkout-personal-information-step']/h1");
    public static final String genderSelect = "//input[@name='id_gender'][@value='%d']";
    public static final By firstNameField = By.xpath("//input[@id='field-firstname']");
    public static final By lastNameField = By.xpath("//input[@id='field-lastname']");
    public static final By emailField = By.xpath("//input[@id='field-email']");
    public static final By agreementTick = By.xpath("//input[@name='psgdpr']"); //doesn't find by text
    public static final By customerPrivacyTick = By.xpath("//input[@name='customer_privacy']");
    public static final By continueWithRegistration =
            By.xpath("//button[@name='continue'][@data-link-action='register-new-customer']");
    public static final By addressField = By.xpath("//input[@id='field-address1']");
    public static final By cityField = By.xpath("//input[@id='field-city']");
    public static final By postcodeField = By.xpath("//input[@id='field-postcode']"); //5 digits
    public static final By phoneField = By.xpath("//input[@id='field-phone']");
    public static final By continueConfirmAddress = By.xpath("//button[@name='confirm-addresses']");
    public static final By continueConfirmDelivery = By.xpath("//button[@name='confirmDeliveryOption']");
    public static final String paymentSelect = "//input[@id='payment-option-%d']";
    public static final By termsAndConditionsTick =
            By.xpath("//input[@id='conditions_to_approve[terms-and-conditions]']");
    public static final By placeOrderBtn = By.xpath("//button[contains(text(), 'Place order')]");
}

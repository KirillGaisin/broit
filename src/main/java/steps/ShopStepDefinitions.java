package steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static page_objects.CartPage.cartHeader;
import static page_objects.CartPage.checkoutBtn;
import static page_objects.CheckoutPage.*;
import static page_objects.MainPage.*;
import static page_objects.ProductPage.*;

public class ShopStepDefinitions {

    //todo разбить степы по ПО

    @Given("^browser is opened and Presta shop page is navigated to$")
    public void preconditions() {
        Configuration.pageLoadTimeout = 120000L;
        open("https://demo.prestashop.com/");
        switchTo().frame("framelive");
    }

    @When("^user selects product$")
    public void openMainPage() {
        $(By.xpath(String.format(product, ThreadLocalRandom.current().nextInt(1, 9))))
                .scrollIntoView(false).shouldBe(interactable).click();
    }

    @And("^product is added to the cart and user checks it out$")
    public void addToCartAndCheckout() throws InterruptedException {
        Thread.sleep(1000); // BUG - if you click too fast on add to cart, nothing actually goes there
        $(addToCart).scrollIntoView(false).shouldBe(interactable).click();
        $(productAddedPopup).should(appear).shouldHave(text("Product successfully added to your shopping cart"));
    }

    @And("^product is added to the cart and user continues browsing$")
    public void addToCartAndContinue() {
        $(addToCart).scrollIntoView(false).shouldBe(interactable).click();
        $(productAddedPopup).shouldBe(visible).shouldHave(text("Product successfully added to your shopping cart"));
        $(continueShoppingBtn).scrollIntoView(false).shouldBe(interactable).click();
    }

    @And("^product is checked out from the cart$")
    public void navigateThroughCheckout() {
        $(checkout).shouldBe(interactable).click();
        $(cartHeader).shouldBe(visible);
        $(checkoutBtn).shouldBe(interactable).click();
    }

    @And("credentials are filled in as first name {string}, last name {string}, email {string}")
    public void fillInCredentials(String name, String lastName, String email) {
        $(personalInfoHeader).shouldBe(visible);
        $(By.xpath(String.format(genderSelect, ThreadLocalRandom.current().nextInt(1, 3))))
                .shouldBe(interactable).click();
        $(firstNameField).shouldBe(enabled).sendKeys(name);
        $(lastNameField).shouldBe(enabled).sendKeys(lastName);
        $(emailField).shouldBe(enabled).sendKeys(email);
        $(agreementTick).shouldBe(enabled).click();
        $(customerPrivacyTick).shouldBe(enabled).click();
        $(continueWithRegistration).shouldBe(enabled).click();
    }

    @And("address is filled in as address 1 {string}, city {string}, post code {string}")
    public void fillInAddress(String addressOne, String city, String postCode) {
        $(addressField).shouldBe(enabled).sendKeys(addressOne);
        $(cityField).shouldBe(enabled).sendKeys(city);
        $(postcodeField).shouldBe(enabled).sendKeys(postCode); // todo написать констрейнт, 5 цифр
        $(continueConfirmAddress).shouldBe(enabled).click();
    }

    @And("^payment is finalized$")
    public void finalizePayment() {
        $(continueConfirmDelivery).shouldBe(enabled).click();
        $(By.xpath(String.format(paymentSelect, ThreadLocalRandom.current().nextInt(1, 3))))
                .shouldBe(interactable).click();
        $(termsAndConditionsTick).shouldBe(enabled).click();
        $(placeOrderBtn).shouldBe(enabled).click();
    }
}

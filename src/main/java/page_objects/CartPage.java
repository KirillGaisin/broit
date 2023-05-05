package page_objects;

import org.openqa.selenium.By;

public class CartPage {
    public static final By cartHeader = By.xpath("//h1[text()='Shopping Cart']");
    public static final By checkoutBtn = By.xpath("//a[text()='Proceed to checkout']");
}

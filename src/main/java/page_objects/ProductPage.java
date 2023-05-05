package page_objects;

import org.openqa.selenium.By;

public class ProductPage {
    public static final By addToCart = By.xpath("//button[contains(@class, 'add-to-cart')]");
    public static final By productAddedPopup = By.xpath("//*[@id='myModalLabel']");
    public static final By checkout = By.xpath("//a[text()='Proceed to checkout']");
    public static final By continueShoppingBtn = By.xpath("//button[text()='Continue shopping']");
}

package page_objects;

import org.openqa.selenium.By;

public class MainPage {
    public static final By maintenanceMsg = By.xpath("//h1[text()='We'll be back soon.']");
    public static final String product = "//div[@class='products row']//*[@data-id-product='%d']";
    public static final By cartCount = By.xpath("//span[@class='cart-products-count']");
}

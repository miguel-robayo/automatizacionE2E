package pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {

    public static final Target PLACE_ORDER_BTN =
            Target.the("Place order button")
                    .located(By.xpath("//button[text()='Place Order']"));

    public static final Target PURCHASE_BTN =
            Target.the("Purchase button")
                    .located(By.xpath("//button[text()='Purchase']"));

    public static final Target SUCCESS_MESSAGE =
            Target.the("Success confirmation message")
                    .located(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]"));
}

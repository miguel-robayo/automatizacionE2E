package pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductPage {

    public static final Target ADD_TO_CART =
            Target.the("add to cart btn")
                    .located(By.xpath("//a[text()='Add to cart']"));
}

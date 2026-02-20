package pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target PRODUCT =
            Target.the("product{0}")
                    .locatedBy("//a[text()='{0}']");

    public static final Target CART =
            Target.the("cart link")
                    .located(By.id("cartur"));

    public static final  Target HOME_LINK = Target.the("Home link")
            .located(By.xpath("//a[contains(text(),'Home')]"));

}

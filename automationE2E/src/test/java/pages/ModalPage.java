package pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ModalPage {

    public static final Target NAME=
            Target.the("Name field")
                    .located(By.id("name"));

    public static final Target COUNTRY=
            Target.the("country field")
                    .located(By.id("country"));

    public static final Target CITY=
            Target.the("city field")
                    .located(By.id("city"));

    public static final Target CARD=
            Target.the("card field")
                    .located(By.id("card"));

    public static final Target MONTH=
            Target.the("month field")
                    .located(By.id("month"));

    public static final Target YEAR=
            Target.the("year field")
                    .located(By.id("year"));

}

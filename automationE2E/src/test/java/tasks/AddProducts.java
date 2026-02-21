package tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import pages.HomePage;
import pages.ProductPage;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProducts implements Task {

    private List<String> products;

    public AddProducts(List<String> products){
        this.products = products;
    }

    public static AddProducts called(List<String> products){
        return instrumented(AddProducts.class, products);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        for (String product: products){
            actor.attemptsTo(
                    Click.on(HomePage.PRODUCT.of(product)),
                    Click.on(ProductPage.ADD_TO_CART),
                    Click.on(HomePage.HOME_LINK)
            );
        }

        actor.attemptsTo(
                Click.on(HomePage.CART)
        );

    }
}

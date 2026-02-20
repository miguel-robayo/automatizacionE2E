package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import pages.CartPage;
import pages.ModalPage;

public class FillOrderForm implements Task {

    private final String name;
    private final String country;
    private final String city;
    private final String card;
    private final String month;
    private final String year;

    public FillOrderForm(String name, String country, String city, String card, String month, String year) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.card = card;
        this.month = month;
        this.year = year;
    }

    public static FillOrderForm withData(String name, String country, String city, String card,
                                         String month, String year){
        return Tasks.instrumented(FillOrderForm.class, name, country, city, card, month, year);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(name).into(ModalPage.NAME),
                Enter.theValue(country).into(ModalPage.COUNTRY),
                Enter.theValue(city).into(ModalPage.CITY),
                Enter.theValue(card).into(ModalPage.CARD),
                Enter.theValue(month).into(ModalPage.MONTH),
                Enter.theValue(year).into(ModalPage.YEAR),
                Click.on(CartPage.PURCHASE_BTN)
        );

    }
}

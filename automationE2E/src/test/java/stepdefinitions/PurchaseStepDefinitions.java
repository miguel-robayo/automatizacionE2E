package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import questions.ConfirmationMessage;
import tasks.AddProducts;
import tasks.FillOrderForm;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PurchaseStepDefinitions {

    @Managed(driver = "chrome")
    protected WebDriver driver;

    @Before
    public void setTheStage(){

        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(Cast.ofStandardActors());

        OnStage.theActorCalled("Miguel")
                .can(BrowseTheWeb.with(driver));

    }
    @Given("Miguel is logged in the platform")
    public void miguelIsLoggedInThePlatform() throws InterruptedException {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url("https://demoblaze.com/")
        );

    }

    @When("he adds the following products to the cart")
    public void heAddTheFollowingProductsToTheCart(DataTable table){

        List<String> products = table.asList();

        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProducts.called(products)
        );
    }

    @And("he places the order with the folloing information")
    public void hePlacesTheOrderWithTheFolloingInformation(Map<String, String> data){

        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(CartPage.PLACE_ORDER_BTN),

                FillOrderForm.withData(
                        data.get("name"),
                        data.get("country"),
                        data.get("city"),
                        data.get("card"),
                        data.get("month"),
                        data.get("year")
                )

        );
    }

    @Then("he see the success message after purchasing the products")
    public void heSeeTheSuccessMessageAfterPurchasingTheProducts(){
        OnStage.theActorInTheSpotlight().should(
            seeThat(ConfirmationMessage.isDisplayed())
        );
    }

}

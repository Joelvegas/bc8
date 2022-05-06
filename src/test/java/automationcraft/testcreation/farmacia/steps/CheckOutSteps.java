package automationcraft.testcreation.farmacia.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.farmacia.pages.CheckOutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckOutSteps {
    CheckOutPage checkOut;

    @Given("que el cliente está el en carrito de compras con al menos {int} producto")
    public void que_el_cliente_está_el_en_carrito_de_compras_con_al_menos_producto(Integer int1) {
        checkOut = new CheckOutPage(DriverFactory.getDriver());
        checkOut.irALaPagina();
    }

    @When("el cliente aumenta la cantidad a pedir del producto a un número mayor de {int}")
    public void el_cliente_aumenta_la_cantidad_a_pedir_del_producto_a_un_número_mayor_de(Integer int1) {
        checkOut.nueveAñadidosMas("12");
    }

    @When("hace clic en {string}")
    public void hace_clic_en(String string) {
        checkOut.actualizarCompra();
    }

    @Then("se debe mostrar un popup que dice {string}")
    public void se_debe_mostrar_un_popup_que_dice(String string) {
        Assert.assertTrue(checkOut.mensajeAvisoPopup().contains("Has excedido el número"));
    }

    //snipets segundo escenario

}
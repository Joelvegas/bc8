package automationcraft.testcreation.farmacia.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.apache.commons.math3.distribution.LevyDistribution;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends SeleniumBase {
    public CheckOutPage(WebDriver driver) {super(driver);}

    //atributos
    String Url = "https://www.farmaciasahumada.cl/checkout/cart/";
    By boxDeCantidades = By.xpath("class=\"input-text qty valid\"");
    By btnActualizarCompra = By.xpath("//button[@class=\"action update\"]");
    By popUpMensajeAviso = By.xpath("//div[@id=\"modal-content-26\"]");

    //funcionalidades
    //escenario 1
    public void irALaPagina(){
        goToUrl(Url);
    }

    public void nueveAñadidosMas(String text){
        type(text, boxDeCantidades);
    }

    public void actualizarCompra(){
        click(btnActualizarCompra);
    }

    public String mensajeAvisoPopup(){
        if (isDisplayed(popUpMensajeAviso)) {
            return getText(popUpMensajeAviso);
        }
        return "el maximo de productos es de 10";
    }

    //escenario 2
    //localizadores
    By warningRecetaMedica = By.xpath("//div[@class=\"message message-warning warning\"]");

    public void inicioPaginaDeCompra(){
        goToUrl(Url);
    }
    public String alertPorRecetaMedica(){
        if (isDisplayed(warningRecetaMedica)) {
            return getText(warningRecetaMedica);
        }
        return "no se puede comprar este articulo";
    }

    //escenario 3
    //localizadores
    By boxCMRTarjeta = By.xpath("(//div[@class=\"input-control\"]/descendant::input)[1]");
    By mensajeCMRInvalido = By.xpath("//div[@class=\"toast-message\"]");
    By aplicarCMRTarjeta = By.xpath("(//button[@class=\"button-cupon send-cupon\"])[1]");

    //funcionalidades
    public void inicioPaginaDeCompras(){
        goToUrl(Url);
    }
    public void IntroducirCMRTarjeta(String tarjeta){
        type(tarjeta, boxCMRTarjeta);
    }
    public void aplicarCMR(){
        click(aplicarCMRTarjeta);
    }
    public String validarCMRInvalido(){
        if (isDisplayed(mensajeCMRInvalido)) {
            return getText(mensajeCMRInvalido);
        }
        return "CMR invalido";
    }
}
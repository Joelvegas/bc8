package pom.equipo3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo3.base.SeleniumBasePage;

public class ViajesFalabellaHomePage extends SeleniumBasePage {

    public ViajesFalabellaHomePage(WebDriver driver) {
        super(driver);
    }

    //identificar locators (page object model) o webElements (PageFactory Model)
    String url = "https://www.viajesfalabella.cl/vuelos/";
    By BotonCookie = By.xpath("//a[@class=\"lgpd-banner--button eva-3-btn -white -md\"]");
    By botonAlojamiento = By.xpath("//li[@class=\"header-product-item \"]/descendant::a[@class=\"shifu-3-button-circle HOTELS paint-circle \"]");
    By barraBuscarDestino = By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-destination sbox-primary undefined\"]");
    By AutoCompletadoTc09 = By.xpath("(//span[@class=\"item-text\"])[6]");
    By botonSinFechasDefinidas = By.xpath("//label[@class=\"checkbox-label\"]");
    By botonBuscar = By.xpath("//div[@class=\"sbox-button-container\"]");

    //funciones o acciones que podemos hacer en la web -> buscar en barra google
    public void irAHomePage(){
        goToUrl(url);
    }
    public void btnCookies(){
        click(BotonCookie);
    }
    public void btnAlojamiento(){
        click(botonAlojamiento);
    }
    public void buscarDestino(String texto){
        type(texto,barraBuscarDestino);
    }
    public void autoCompletado(){
        click(AutoCompletadoTc09);
    }
    public void sinFechasDefinidas(){
        click(botonSinFechasDefinidas);
    }
    public void btnBuscar(){
        click(botonBuscar);
    }
}

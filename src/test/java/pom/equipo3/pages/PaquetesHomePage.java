package pom.equipo3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo3.base.SeleniumBasePage;

public class PaquetesHomePage extends SeleniumBasePage {
    public PaquetesHomePage(WebDriver driver) {
        super(driver);
    }


    //localizadores
    String linkPage = "https://www.viajesfalabella.cl/";
    By BotonCookie = By.xpath("//a[@class=\"lgpd-banner--button eva-3-btn -white -md\"]");
    By botonPaquetes = By.xpath("//a[@class=\"shifu-3-button-circle PACKAGES paint-circle \"]");
    By barraOrigen = By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first sbox-origin-container places-inline\"]");
    By autocompleteOrigen = By.xpath("(//ul[@class=\"ac-group-items\"]/descendant::li)[1]");
    By barraDestino = By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline\"]");
    By autocompleteDestino = By.xpath("(//ul[@class=\"ac-group-items\"]/descendant::li)[1]");
    By fechasIda = By.xpath("//div[@class=\"sbox-3-input -md sbox-3-validation -top-right -icon-left sbox-dates-input sbox-checkin-container sbox-datein-container\"]");
    By botonMesSiguiente = By.xpath("(//div[@class=\"_dpmg2--controls-next\"])[3]");
    By monthActive = By.xpath("(//div[@class=\"_dpmg2--month _dpmg2--o-7 _dpmg2--month-active\"])[3]");
    By fechasVuelta = By.xpath("//input[@class=\"input-tag sbox-checkout-date\"]");
    By monthActiveRange = By.xpath("//div[contains(@class, \"_dpmg2--has-start-range\")]");
    By botonAplicarFechas = By.xpath("(//button[@class=\"_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary\"])[3]");
    By btnHabitaciones = By.xpath("(//div[contains(@class, \"sbox-guests-container\")])[1]");
    By añadirHabitacion = By.xpath("//a[@class=\"_pnlpk-panel__button _pnlpk-panel__button--link-left _pnlpk-add-room-button\"]");
    By btnAplicarAñadidos = By.xpath("(//a[@class=\"_pnlpk-apply-button sbox-3-btn -primary _pnlpk-panel__button--link-right -lg\"])[2]");
    By botonBuscar = By.xpath("//div[@class=\"sbox-button-container\"]");
    By checkboxDesayuno = By.xpath("(//ul[@class=\"dropdown-subcontent\"]/descendant::li[@class=\"dropdown-subitem\"])[3]");
    By checkboxDepartamentos = By.xpath("(//li[@class=\"dropdown-item -active\"]/descendant::li[@class=\"dropdown-subitem\"])[7]");
    By departamentoDetalles = By.xpath("(//button[@class=\"eva-3-btn -md -primary -eva-3-fwidth\"])[2]");
    By confirmarCompra = By.xpath("//button[@class=\"eva-3-btn -md -primary -eva-3-fwidth\"]");

    //funcionalidades

    public void irAPage(){
        goToUrl(linkPage);
    }
    public void aceptarCookies(){
        click(BotonCookie);
    }
    public void seleccionPaquetes(){
        click(botonPaquetes);
    }
    public void ingresarOrigen(String text){
        type(text, barraOrigen);
        click(autocompleteOrigen);
    }
    public void ingresarDestino(String text){
        type(text, barraDestino);
        click(autocompleteDestino);
    }

    public void ingresoFechaDeIda(int añoIda, int mesIda, int diaIda) {
        click(fechasIda);
        String mesInt = getAttribute(monthActive, "data-month").split("-")[1];
        String añoInt = getAttribute(monthActive, "data-month").split("-")[0];
        if (Integer.parseInt(añoInt) == añoIda) {
            for (int i = Integer.parseInt(mesInt); i <= mesIda; i++) {
                if (i == mesIda) {
                    break;
                }
                click(botonMesSiguiente);
            }
        } else if (Integer.parseInt(añoInt) < añoIda) {
            for (int i = Integer.parseInt(mesInt); i < 12 + mesIda; i++) {
                if (i == mesIda) {
                    break;
                }
                click(botonMesSiguiente);
            }
        }
        String diaIdaData = mesIda > 9 ? añoIda + "-" + mesIda : añoIda + "-" + "0" + mesIda;
        By DiaDeIda = By.xpath("(//div[contains(@data-month, \"" +  diaIdaData + "\")]/descendant::span[text()=\"" + diaIda + "\"])[3]");
        click(DiaDeIda);
    }

    public void ingresoFechaDeVuelta(int añoVuelta, int mesVuelta, int diaVuelta, int añoIda, int mesIda) {
        click(fechasVuelta);
        String mesIntVuelta = getAttribute(monthActiveRange, "data-month").split("-")[1];
        String añoIntVuelta = getAttribute(monthActiveRange, "data-month").split("-")[0];
        if (mesIda <= mesVuelta || añoIda <= añoVuelta) {
            if (Integer.parseInt(añoIntVuelta) == añoVuelta) {
                for (int i = Integer.parseInt(mesIntVuelta); i <= mesVuelta; i++) {
                    if (i == mesVuelta) {
                        break;
                    }
                    click(botonMesSiguiente);
                }
            } else if (Integer.parseInt(añoIntVuelta) < añoVuelta) {
                for (int i = Integer.parseInt(mesIntVuelta); i < 12 + mesVuelta; i++) {
                    if (i == mesVuelta) {
                        break;
                    }
                    click(botonMesSiguiente);
                }
            }
        }
        String diaVueltaData = mesVuelta > 9 ? añoIda + "-" + mesVuelta : añoVuelta + "-" + "0" + mesVuelta;
        By diaRegreso = By.xpath("(//div[contains(@data-month, \"" +  diaVueltaData +"\")]/descendant::span[text()=\""+diaVuelta+"\"])[3]");
        click(diaRegreso);
    }

    public void aplicarFechas() {
        click(botonAplicarFechas);
    }

    public void cantHabitaciones() {
        click(btnHabitaciones);
        click(añadirHabitacion);
    }

    public void aplicarAñadidos() {
        click(btnAplicarAñadidos);
    }

    public void buscarAlojamientos() {
        click(botonBuscar);
    }

    //filtros

    public void filtros() {
        click(checkboxDesayuno);
        click(checkboxDepartamentos);
    }

    //elegir alojamiento
    public void selecionarAlojamiento() {
        click(departamentoDetalles);
    }
    public void verHabitaciones(){
        click(confirmarCompra);
    }
}

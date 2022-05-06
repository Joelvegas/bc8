package pom.equipo3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo3.base.SeleniumBasePage;

public class AlojamientoHomePage extends SeleniumBasePage {
    public AlojamientoHomePage(WebDriver driver) {
        super(driver);
    }

    //localizadores
    //tc16
    String url = "https://www.viajesfalabella.cl/";
    By BotonCookie = By.xpath("//a[@class=\"lgpd-banner--button eva-3-btn -white -md\"]");
    By botonAlojamiento = By.xpath("//li[@class=\"header-product-item \"]/descendant::a[@class=\"shifu-3-button-circle HOTELS paint-circle \"]");
    By barraBuscarDestino = By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-destination sbox-primary undefined\"]");
    By AutoCompletadoTc16 = By.xpath("//li[@class=\"item -active\"]");
    By fechasIda = By.xpath("//input[@class=\"input-tag sbox-checkin-date\"]");
    By fechasVuelta = By.xpath("//input[@class=\"input-tag sbox-checkout-date\"]");
    By botonMesSiguiente = By.xpath("(//i[@class=\"_dpmg2--icon-ico-arrow\"])[2]");
    By MonthActive = By.xpath("//div[@class=\"_dpmg2--month _dpmg2--o-7 _dpmg2--month-active\"]");
    By MonthActiveRange = By.xpath("//div[contains(@class, \"_dpmg2--has-start-range\")]");
    By botonAplicarFechas = By.xpath("//button[@class=\"_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary\"]");
    By botonBuscar = By.xpath("//div[@class=\"sbox-button-container\"]");
    By btnHabitaciones = By.xpath("(//div[contains(@class, \"sbox-guests-container\")])[1]");
    By añadirHabitacion = By.xpath("(//div[@class=\"_pnlpk-panel__footer -medium-down-to-lg\"]/descendant::a)[2]");
    By añadirAdulto = By.xpath("(//a[@class = \"steppers-icon-right sbox-3-icon-plus\"])[1]");
    By btnAplicarAñadidos = By.xpath("//a[text() =\"Aplicar\"]");

    By checkboxDesayuno = By.xpath("(//ul[@class=\"dropdown-subcontent\"]/descendant::li[@class=\"dropdown-subitem\"])[2]");
    By checkboxCuatroEstrellas = By.xpath("(//ul[@class=\"dropdown-subcontent\"]/descendant::li[@class=\"dropdown-subitem\"])[5]");
    By hotelVerDetalles = By.xpath("//button[@class=\"eva-3-btn -md -primary -eva-3-fwidth\"]");
    By verHabitaciones = By.xpath("//button[@class=\"eva-3-btn -md -primary -eva-3-fwidth\"]/descendant::em");


    public void irAHomePage() {
        goToUrl(url);
    }

    public void btnCookies() {
        click(BotonCookie);
    }

    public void btnAlojamiento() {
        click(botonAlojamiento);
    }

    public void ingresarElDestino(String texto) {
        type(texto, barraBuscarDestino);
        click(AutoCompletadoTc16);
    }

    //fechas
    public void ingresoFechaDeIda(int añoIda, int mesIda, int diaIda) {
        click(fechasIda);
        String mesInt = getAttribute(MonthActive, "data-month").split("-")[1];
        String añoInt = getAttribute(MonthActive, "data-month").split("-")[0];
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
        By DiaDeIda = By.xpath("//div[contains(@data-month, \"" + diaIdaData + "\")]/descendant::span[text()=\"" + diaIda + "\"]");
        click(DiaDeIda);
    }

    public void ingresoFechaDeVuelta(int añoVuelta, int mesVuelta, int diaVuelta, int añoIda, int mesIda) {
        click(fechasVuelta);
        String mesIntVuelta = getAttribute(MonthActiveRange, "data-month").split("-")[1];
        String añoIntVuelta = getAttribute(MonthActiveRange, "data-month").split("-")[0];
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
        By DiaDeRegreso = By.xpath("//div[contains(@data-month, \"" + diaVueltaData + "\")]/descendant::span[text()=\"" + diaVuelta + "\"]");
        click(DiaDeRegreso);
    }

    public void aplicarFechas() {
        click(botonAplicarFechas);
    }

    //habitaciones y pasajeros
    public void cantHabitaciones() {
        click(btnHabitaciones);
        click(añadirHabitacion);
    }

    public void cantPasajeros() {
        click(añadirAdulto);
    }

    public void aplicarAñadidos() {
        click(btnAplicarAñadidos);
    }

    public void buscarAlojamiento() {
        click(botonBuscar);
    }

    //filtros

    public void filtros() {
        click(checkboxDesayuno);
        click(checkboxCuatroEstrellas);
    }

    //elegir alojamiento
    public void selecionarAlojamiento() {
        click(hotelVerDetalles);
    }
    public void verHabitaciones(){
        click(verHabitaciones);
    }
}

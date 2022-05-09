package pom.equipo3.test;

import org.junit.Test;
import pom.equipo3.base.JunitBaseTest;
import pom.equipo3.pages.PaquetesHomePage;

public class PaquetesHomePageTest extends JunitBaseTest {

    PaquetesHomePage paquetesHomePage;

    @Test
    public void ReservaHotelEnIbiza(){
        paquetesHomePage = new PaquetesHomePage(driver);
        paquetesHomePage = new PaquetesHomePage(driver);
        paquetesHomePage.irAPage();
        paquetesHomePage.aceptarCookies();
        paquetesHomePage.seleccionPaquetes();
        paquetesHomePage.ingresarOrigen("Buenos Aires");
        paquetesHomePage.ingresarDestino("Ibiza, España");
        paquetesHomePage.ingresoFechaDeIda(2022, 5, 10);
        paquetesHomePage.ingresoFechaDeVuelta(2022, 5, 28, 2022, 5);
        paquetesHomePage.aplicarFechas();
        paquetesHomePage.cantHabitaciones();
        paquetesHomePage.aplicarAñadidos();
        paquetesHomePage.buscarAlojamientos();
        paquetesHomePage.filtros();
        paquetesHomePage.selecionarAlojamiento();
        paquetesHomePage.verHabitaciones();
    }
}

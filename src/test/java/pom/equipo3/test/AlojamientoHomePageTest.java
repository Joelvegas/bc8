package pom.equipo3.test;

import org.junit.Test;
import pom.equipo3.base.JunitBaseTest;
import pom.equipo3.pages.AlojamientoHomePage;

public class AlojamientoHomePageTest extends JunitBaseTest {
    AlojamientoHomePage alojamientoHomePage;

    @Test
    public void busquedaAlojamiento(){
        alojamientoHomePage = new AlojamientoHomePage(driver);
        alojamientoHomePage.irAHomePage();
        alojamientoHomePage.btnCookies();
        alojamientoHomePage.btnAlojamiento();
        alojamientoHomePage.ingresarElDestino("Dublín, Leinster, Irlanda");
        alojamientoHomePage.ingresoFechaDeIda(2022, 5, 7);
        alojamientoHomePage.ingresoFechaDeVuelta(2022, 5, 14, 2022, 5);
        alojamientoHomePage.aplicarFechas();
        alojamientoHomePage.cantHabitaciones();
        alojamientoHomePage.cantPasajeros();
        alojamientoHomePage.aplicarAñadidos();
        alojamientoHomePage.buscarAlojamiento();
        alojamientoHomePage.filtros();
        alojamientoHomePage.selecionarAlojamiento();
        alojamientoHomePage.verHabitaciones();
    }
}

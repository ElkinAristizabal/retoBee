package stepDefinitions;

import questions.ValidarPrecioCorrecto;
import questions.ValidarPrecioMenorA400;
import task.EliminarArticuloAlAzar;
import io.cucumber.java.*;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import interactions.AbrirPaginaWeb;
import task.AgregarArticulosAlCarrito;

import static enums.Constantes.PRECIO_MASTERING_JAVASCRIPT;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;


public class AgregarProductosAlCarritoStepDefinitions {

    private static final String actor = "Elkin Aristizabal";

    @Before
    public void setUp(){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(actor);
    }

    @Dado("que el usuario esta en la pagina principal de automationtesting")
    public void queElUsuarioEstaEnLaPaginaPrincipalDeAutomationtesting() {
        theActorCalled(actor).attemptsTo(AbrirPaginaWeb.paraComenzarEscenario());
    }

    @Cuando("el usuario agregue dos productos al carrito")
    public void elUsuarioAgregueDosProductosAlCarrito() {
        theActorCalled(actor).attemptsTo(AgregarArticulosAlCarrito.enShop());
    }

    @Y("luego elimine uno")
    public void luegoElimineUno() {
        theActorCalled(actor).attemptsTo(EliminarArticuloAlAzar.enCarrito());
    }

    @Entonces("valida que el precio es menor de 400")
    public void validaQueElPrecioEsMenorDe() {
        theActorCalled(actor).should(
                seeThat("El precio es menor a 400", ValidarPrecioMenorA400.enCarrito())
        );
    }

    @Y("valida que el precio es correcto")
    public void validaQueElPrecioEsCorrecto() {
        theActorCalled(actor).should(
                seeThat("El precio es correcto", ValidarPrecioCorrecto.enCarrito())
        );
    }
}

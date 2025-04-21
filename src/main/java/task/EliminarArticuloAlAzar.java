package task;

import interactions.EsperarLoadersNoPresente;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import java.util.List;
import java.util.Random;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterface.CarritoPage.BOTON_ELIMINAR_ARTICULO;

public class EliminarArticuloAlAzar implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> removeLinks = BrowseTheWeb.as(actor)
                .findAll(BOTON_ELIMINAR_ARTICULO);

        if (!removeLinks.isEmpty()) {
            int indexRandom = new Random().nextInt(removeLinks.size());
            removeLinks.get(indexRandom).click();
        }

        actor.attemptsTo(EsperarLoadersNoPresente.completamente());
    }

    public static EliminarArticuloAlAzar enCarrito() {
        return instrumented(EliminarArticuloAlAzar.class);
    }
}

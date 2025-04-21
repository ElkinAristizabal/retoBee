package task;

import interactions.ClickConJavaScript;
import interactions.EsperarCantidadCarrito;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;

import static enums.Constantes.PRECIO_HTML5_FORMS;
import static enums.Constantes.PRECIO_MASTERING_JAVASCRIPT;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterface.ShopPage.*;

public class AgregarArticulosAlCarrito implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String precioHTML = Text.of(TXT_PRECIO_HTML5_FORMS).answeredBy(actor);
        actor.remember(PRECIO_HTML5_FORMS.getDescripcion(), precioHTML);
        String precioJS = Text.of(TXT_PRECIO_MASTERING_JAVASCRIPT).answeredBy(actor);
        actor.remember(PRECIO_MASTERING_JAVASCRIPT.getDescripcion(), precioJS);
        actor.attemptsTo(
                Scroll.to(BOTON_AGREGAR_A_CARRITO_HTML5_FORMS).then(ClickConJavaScript.en(BOTON_AGREGAR_A_CARRITO_HTML5_FORMS)),
                EsperarCantidadCarrito.sea(1),
                Scroll.to(BOTON_AGREGAR_A_CARRITO_MASTERING_JAVASCRIPT).then(ClickConJavaScript.en(BOTON_AGREGAR_A_CARRITO_MASTERING_JAVASCRIPT)),
                EsperarCantidadCarrito.sea(2),
                ClickConJavaScript.en(BOTON_CARRITO)
        );
    }

    public static AgregarArticulosAlCarrito enShop(){
        return instrumented(AgregarArticulosAlCarrito.class);
    }
}

package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.math.BigDecimal;

import static enums.Constantes.PRECIO_HTML5_FORMS;
import static enums.Constantes.PRECIO_MASTERING_JAVASCRIPT;
import static userinterface.CarritoPage.*;
import static utils.PrecioUtil.parsearPrecio;
import static utils.PrecioUtil.sumarDosPrecios;

public class ValidarPrecioCorrecto implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        String impuestos = Text.of(TXT_IMPUESTOS).answeredBy(actor);
        String precioHTML5Forms = actor.recall(PRECIO_HTML5_FORMS.getDescripcion());
        String precioMasteringJavaScript = actor.recall(PRECIO_MASTERING_JAVASCRIPT.getDescripcion());
        String precioArticuloEnCarrito = Text.of(TXT_ARTICULO_EN_CARRITO).answeredBy(actor);
        String precioTotal = Text.of(TXT_PRECIO_TOTAL).answeredBy(actor);

        if (precioArticuloEnCarrito.contains(precioHTML5Forms)
                || precioArticuloEnCarrito.contains(precioMasteringJavaScript)) {
            BigDecimal TotalEsperado = sumarDosPrecios(precioArticuloEnCarrito, impuestos);
            BigDecimal totalReal = parsearPrecio(precioTotal);
            return TotalEsperado.equals(totalReal);
        }
        return false;
    }

    public static ValidarPrecioCorrecto enCarrito() {
        return new ValidarPrecioCorrecto();
    }
}

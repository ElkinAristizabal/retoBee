package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.math.BigDecimal;

import static userinterface.CarritoPage.*;
import static utils.PrecioUtil.parsearPrecio;

public class ValidarPrecioMenorA400 implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        BigDecimal precioTotal = parsearPrecio(Text.of(TXT_PRECIO_TOTAL).answeredBy(actor));
        return precioTotal.compareTo(BigDecimal.ZERO) > 0 && precioTotal.compareTo(new BigDecimal("400")) < 0;

    }

    public static ValidarPrecioMenorA400 enCarrito() {
        return new ValidarPrecioMenorA400();
    }
}

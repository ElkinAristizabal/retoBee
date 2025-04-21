package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterface.ShopPage.TXT_CANTIDAD_ITEMS;

public class EsperarCantidadCarrito implements Interaction {

    private final int cantidadEsperada;

    public EsperarCantidadCarrito(int cantidadEsperada) {
        this.cantidadEsperada = cantidadEsperada;
    }



    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        String cantidadEsperadaTexto = String.valueOf(cantidadEsperada);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(Exception.class)
                .until(d -> {
                    WebElement elemento = TXT_CANTIDAD_ITEMS.resolveFor(actor);
                    String texto = elemento.getText().trim();
                    String numero = texto.replaceAll("[^0-9]", "");
                    return numero.equals(cantidadEsperadaTexto);
                });
    }

    public static EsperarCantidadCarrito sea(int cantidadEsperada) {
        return instrumented(EsperarCantidadCarrito.class, cantidadEsperada);
    }
}

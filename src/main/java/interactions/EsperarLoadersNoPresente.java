package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterface.CarritoPage.LOADERS;

public class EsperarLoadersNoPresente  implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class)
                .until(d -> {
                    List<WebElementFacade> overlays = LOADERS.resolveAllFor(actor);
                    return overlays.isEmpty() || overlays.stream().noneMatch(WebElement::isDisplayed);
                });
    }

    public static EsperarLoadersNoPresente completamente() {
        return instrumented(EsperarLoadersNoPresente.class);
    }
}

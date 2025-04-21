package userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CarritoPage extends PageObject {

    public static final Target BOTON_ELIMINAR_ARTICULO = Target.the("Boton de eliminar articulo")
            .locatedBy("//a[@class='remove']");

    public static final Target LOADERS = Target.the("Boton de eliminar articulo")
            .locatedBy("//div[contains(@class, 'blockUI') and contains(@class, 'blockOverlay')]");

    public static final Target TXT_ARTICULO_EN_CARRITO = Target.the("Texto de precio del articulo en carrito")
            .locatedBy("//td[@data-title='Total']/span");

    public static final Target TXT_IMPUESTOS = Target.the("Texto de impuestos")
            .locatedBy("//td[@data-title='Tax']/span");

    public static final Target TXT_PRECIO_TOTAL = Target.the("Texto de impuestos")
            .locatedBy("//td[@data-title='Total']/strong/span");
}

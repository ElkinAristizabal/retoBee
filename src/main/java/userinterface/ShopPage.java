package userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ShopPage extends PageObject {

    public static final Target BOTON_AGREGAR_A_CARRITO_HTML5_FORMS = Target.the("Boton de agregar a carrito curso de HTML5 Forms")
            .locatedBy("//li[a[contains(@href, 'html5-forms')]]/a[contains(text(),'Add to basket')]");

    public static final Target TXT_PRECIO_HTML5_FORMS = Target.the("Texto del precio de HTML5 Forms")
            .locatedBy("//li/a[contains(@href, 'html5-forms')]/span/span");

    public static final Target BOTON_AGREGAR_A_CARRITO_MASTERING_JAVASCRIPT = Target.the("Boton de agregar a carrito curso de mastering JavaSript")
            .locatedBy("//li[a[contains(@href, 'mastering-javascript')]]/a[contains(text(),'Add to basket')]");

    public static final Target TXT_PRECIO_MASTERING_JAVASCRIPT = Target.the("Texto del precio de mastering JavaSript")
            .locatedBy("//li/a[contains(@href, 'mastering-javascript')]/span/span");

    public static final Target TXT_CANTIDAD_ITEMS = Target.the("Texto de cantidad de articulos")
            .locatedBy("//a[@title='View your shopping cart']/span[@class='cartcontents']");

    public static final Target BOTON_CARRITO = Target.the("Boton de carrito")
            .locatedBy("//i[@class='wpmenucart-icon-shopping-cart-0']");
}

package enums;

public enum Constantes {

    PRECIO_HTML5_FORMS("Precio de articulo HTML5 Forms"),
    PRECIO_MASTERING_JAVASCRIPT("Precio de articulo mastering JavaScript");

    private final String descripcion;
    Constantes(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }
}

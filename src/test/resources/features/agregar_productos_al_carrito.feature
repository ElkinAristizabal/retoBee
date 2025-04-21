#language:es
  Característica: Agregar productos al carrito

    Yo como usuario
    quiero agregar productos al carrito
    para validar que el precio sea correcto

    Escenario: Validar precio correcto despues de eliminar un producto
      Dado que el usuario esta en la pagina principal de automationtesting
      Cuando el usuario agregue dos productos al carrito
      Y luego elimine uno
      Entonces valida que el precio es menor de 400
      Y valida que el precio es correcto
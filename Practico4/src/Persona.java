

public class Persona {
    private String nombre;
    private Carrito carro;

    public Persona(String nombre) {
        this.nombre = nombre;

        this.carro = new Carrito();
    }

    public void comprar(Producto producto) {
        carro.agregarProducto(producto);
    }

    public void verCarro() {
        System.out.println(nombre + " tiene en su carro:");
        carro.mostrarProductos();
    }
}





public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Juan");
        Producto producto1 = new Producto("Leche", 1.50);
        Producto producto2 = new Producto("Pan", 0.80);
        persona.comprar(producto1);
        persona.comprar(producto2);
        persona.verCarro();
        Carrito carrito = new Carrito();
        carrito.precio();
    }
}
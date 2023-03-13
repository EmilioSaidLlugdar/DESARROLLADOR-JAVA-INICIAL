import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos;

    public Carrito() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void mostrarProductos() {
        for (Producto producto : productos) {
            System.out.println("- " + producto.getNombre() +
                               "\n -"+ producto.getFechaAlta()+
                               "\n -"+ producto.getPrecio());
        }
    }

    public void precio(){
        double totalPrecio=0;
        for (Producto producto: productos) {
            totalPrecio= totalPrecio+producto.getPrecio();
            }
        System.out.println("El total es: "+ totalPrecio);
        }

}

import java.time.LocalDate;

public class Producto {
    private String nombre;
    private double precio;

    private LocalDate fechaAlta;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.fechaAlta = LocalDate.now();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public double getPrecio() {
        return precio;
    }
}
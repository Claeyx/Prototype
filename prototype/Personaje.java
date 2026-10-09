package prototype;
import model.Inventario;
public class Personaje implements Clonable <Personaje> {
    private String nombre;
    private String clase;
    private Inventario inventario;

    public Personaje(String nombre, String clase, Inventario inventario) {
        this.nombre = nombre;
        this.clase = clase;
        this.inventario = inventario;
    }

    // Constructor de copia para facilitar la clonación profunda
    private Personaje(Personaje objetivo) {
        if (objetivo != null) {
            this.nombre = objetivo.nombre;
            this.clase = objetivo.clase;
            // Clonación profunda del inventario para romper la referencia compartida
            this.inventario = objetivo.inventario.clonar();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Inventario getInventario() {
        return inventario;
    }

    @Override
    public Personaje clonar() {
        return new Personaje(this);
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", clase='" + clase + '\'' +
                ", inventario=" + inventario +
                '}';
    }
}

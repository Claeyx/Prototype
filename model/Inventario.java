package model;

import prototype.Clonable;
import java.util.ArrayList;
import java.util.List;

public class Inventario implements Clonable <Inventario> {
    private List<String> items;

    public Inventario() {
        this.items = new ArrayList<>();
    }

    // Constructor privado utilizado para la clonación profunda
    private Inventario(List<String> items) {
        this.items = new ArrayList<>(items);
    }

    public void agregarItem(String item) {
        this.items.add(item);
    }

    public List<String> getItems() {
        return items;
    }

    @Override
    public Inventario clonar() {
        // Se genera una nueva instancia de Inventario con una copia independiente de la lista de ítems
        return new Inventario(this.items);
    }

    @Override
    public String toString() {
        return items.toString();
    }

}

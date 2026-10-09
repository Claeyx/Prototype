import model.Inventario;
import prototype.Personaje;
import registry.RegistroPrototipos;
void main() {
    RegistroPrototipos registro = new RegistroPrototipos();
    Inventario invGuerrero = new Inventario();
    invGuerrero.agregarItem("Poción de vida");
    Personaje guerreroBase = new Personaje("Guerrero Base", "Guerrero", invGuerrero);

    Inventario invMago = new Inventario();
    invMago.agregarItem("Poción de mana");
    invMago.agregarItem("Varita básica");
    Personaje magoBase = new Personaje("Mago Base", "Mago", invMago);

    registro.registrarPrototipo("GUERRERO", guerreroBase);
    registro.registrarPrototipo("MAGO", magoBase);

    System.out.println("ESTADO INICIAL DE PROTOTIPOS BASE");
    System.out.println("Base Guerrero: " + guerreroBase);
    System.out.println("Base Mago:     " + magoBase);

    Personaje copiaGuerrero = registro.obtenerCopia("GUERRERO");
    Personaje copiaMago = registro.obtenerCopia("MAGO");

    if (copiaGuerrero != null) {
        copiaGuerrero.setNombre("Conan el Bárbaro");
        // Modificación del inventario de la copia
        copiaGuerrero.getInventario().agregarItem("Escudo");
        copiaGuerrero.getInventario().agregarItem("Espada de Hierro");
    }

    if (copiaMago != null) {
        copiaMago.setNombre("Gandalf el Gris");
        copiaMago.getInventario().agregarItem("Báculo Sagrado");
    }

    System.out.println("VERIFICACIÓN TRAS MODIFICAR COPIAS");
    System.out.println("Prototipo Original Guerrero : " + guerreroBase);
    System.out.println("Copia Guerrero Modificada   : " + copiaGuerrero);
    System.out.println();
    System.out.println("Prototipo Original Mago     : " + magoBase);
    System.out.println("Copia Mago Modificada       : " + copiaMago);

    System.out.println("PRUEBA DE CLAVE INEXISTENTE");
    Personaje inexistente = registro.obtenerCopia("ARQUERO");
    System.out.println("Resultado: " + inexistente);
}

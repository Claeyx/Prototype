package registry;

import prototype.Personaje;
import java.util.HashMap;
import java.util.Map;

public class RegistroPrototipos {
    private final Map<String, Personaje> prototipos = new HashMap<>();
    public void registrarPrototipo(String clave, Personaje prototipo) {
        prototipos.put(clave, prototipo);
    }

    public Personaje obtenerCopia(String clave) {
        Personaje prototipo = prototipos.get(clave);
        if (prototipo == null) {
            System.out.println("[WARN] No existe un prototipo registrado con la clave: " + clave);
            return null;
        }
        return prototipo.clonar();
    }
}

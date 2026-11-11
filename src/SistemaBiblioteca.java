import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SistemaBiblioteca {
    private Map<String, Material> catalogo;
    private Map<String, List<String>> listaEspera;
    private Set<String> miembros;

    public SistemaBiblioteca() {
        this.catalogo = new HashMap<>();
        this.listaEspera = new HashMap<>();
        this.miembros = new HashSet<>();
    }

    // Paso 3: Catálogo con HashMap
    public void registrarMaterial(Material m) {
        catalogo.put(m.getCodigo(), m);
    }

    public Material buscarMaterial(String codigo) {
        return catalogo.get(codigo);
    }

    public void mostrarCatalogo() {
        for (Map.Entry<String, Material> entry : catalogo.entrySet()) {
            entry.getValue().mostrarInfo();
        }
    }

    // Paso 4: Lista de espera con ArrayList
    public void agregarEspera(String codigoMaterial, String usuario) {
        if (!listaEspera.containsKey(codigoMaterial)) {
            listaEspera.put(codigoMaterial, new ArrayList<>());
        }
        listaEspera.get(codigoMaterial).add(usuario);
    }

    public String siguienteEnEspera(String codigoMaterial) {
        List<String> lista = listaEspera.get(codigoMaterial);
        if (lista != null && !lista.isEmpty()) {
            return lista.remove(0);
        }
        return null;
    }

    // Paso 5: Membresías con HashSet
    public boolean registrarMiembro(String usuario) {
        return miembros.add(usuario);
    }

    public boolean tieneMembresia(String usuario) {
        return miembros.contains(usuario);
    }
}
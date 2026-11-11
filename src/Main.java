public class Main {
    public static void main(String[] args) {
        SistemaBiblioteca biblioteca = new SistemaBiblioteca();

        // 1. Probar catalogo (HashMap) y polimorfismo
        System.out.println("--- Catalogo ---");
        Material libro1 = new Libro("L-101", "Cien anos de soledad", 1967, true, "Gabriel Garcia Marquez", "978-0307474728");
        Material libro2 = new Libro("L-102", "El principito", 1943, false, "Antoine de Saint-Exupery", "978-0156012195");
        Material revista1 = new Revista("R-201", "National Geographic", 2024, true, 215, "Ciencia");
        Material revista2 = new Revista("R-202", "Muy Interesante", 2023, false, 85, "Tecnologia");

        biblioteca.registrarMaterial(libro1);
        biblioteca.registrarMaterial(libro2);
        biblioteca.registrarMaterial(revista1);
        biblioteca.registrarMaterial(revista2);

        biblioteca.mostrarCatalogo();

        System.out.println("\n--- Busqueda en catalogo ---");
        Material busqueda = biblioteca.buscarMaterial("L-101");
        if (busqueda != null) {
            busqueda.mostrarInfo();
        }

        Material noExiste = biblioteca.buscarMaterial("XYZ-999");
        System.out.println("Resultado de material inexistente: " + noExiste);

        // 2. Probar lista de espera (ArrayList)
        System.out.println("\n--- Lista de espera ---");
        biblioteca.agregarEspera("L-102", "Carlos");
        biblioteca.agregarEspera("L-102", "Diana");
        biblioteca.agregarEspera("L-102", "Elena");

        System.out.println("Atendiendo a: " + biblioteca.siguienteEnEspera("L-102"));
        System.out.println("Atendiendo a: " + biblioteca.siguienteEnEspera("L-102"));

        // 3. Probar membresias (HashSet)
        System.out.println("\n--- Registro de membresias ---");
        System.out.println("Registrar a Carlos: " + biblioteca.registrarMiembro("Carlos"));
        System.out.println("Registrar a Diana: " + biblioteca.registrarMiembro("Diana"));
        System.out.println("Reintentar Carlos (duplicado): " + biblioteca.registrarMiembro("Carlos"));

        System.out.println("¿Diana tiene membresia?: " + biblioteca.tieneMembresia("Diana"));
        System.out.println("¿Pedro tiene membresia?: " + biblioteca.tieneMembresia("Pedro"));
    }
}
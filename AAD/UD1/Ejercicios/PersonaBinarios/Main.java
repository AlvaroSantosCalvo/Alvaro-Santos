import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

    private static final String fichero = "bbdd.txt";

    public static void main(String[] args) {
        boolean ok = true;

        while (ok) {
            System.out.println("=============================");
            System.out.println("1. Crear cinco personas");
            System.out.println("2. Leer personas del fichero");
            System.out.println("3. Salir");
            System.out.println("=============================");

            String opc = IO.readln();

            switch (opc) {
                case "1":
                    guardarPersonas();
                    break;
                case "2":
                    leerPersonas();
                    break;
                default:
                    ok = false;
                    System.out.println("Fin del programa.");
                    break;
            }
        }

    }

    private static void guardarPersonas() {
        Persona[] personas = {
                new Persona("ana", "ana@ejemplo.com", "claveAna"),
                new Persona("luis", "luis@ejemplo.com", "claveLuis"),
                new Persona("marta", "marta@ejemplo.com", "claveMarta"),
                new Persona("diego", "diego@ejemplo.com", "claveDiego"),
                new Persona("lucia", "lucia@ejemplo.com", "claveLucia")
        };

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fichero)))
        {
            outputStream.writeObject(personas);
            System.out.println("Personas guardadas correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar las personas: " + e.getMessage());
        }
    }

    private static void leerPersonas() {
        try (ObjectInputStream entrada = new ObjectInputStream(
                new FileInputStream(fichero))) {
            Persona[] personas = (Persona[]) entrada.readObject();
            for (Persona persona : personas) {
                System.out.println(persona);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer las personas: " + e.getMessage());
        }
    }
}

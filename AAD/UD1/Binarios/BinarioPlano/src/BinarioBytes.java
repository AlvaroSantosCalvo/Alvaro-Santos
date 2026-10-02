import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BinarioBytes {
    public static void main(String[] args) {
        escribir();
        leer();
        deUnoAOtro("uno.jpg", "uno.bin");
    }

    public static void leer() {

        File file = new File("bytes.bin");

        try (FileInputStream fStream = new FileInputStream(file)) {
            int byteLeido;
            while ((byteLeido = fStream.read()) != -1) {
                System.out.println((char)byteLeido);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void escribir() {

        String contrasena = "123456789";
        File file = new File("bytes.bin");

        try (FileOutputStream fStream = new  FileOutputStream(file)) {
            byte [] datos = contrasena.getBytes();
            fStream.write(datos);
            fStream.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void deUnoAOtro(String ruta1, String ruta2) {
        File f1 = new File(ruta1);
        File f2 = new File(ruta2);
        try(
            FileInputStream leer = new FileInputStream(f1);
            FileOutputStream escribir = new FileOutputStream(f2)
        ) {
            int byteLeido;
            while ((byteLeido = leer.read()) != -1) {
                escribir.write(byteLeido);
            }
            escribir.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

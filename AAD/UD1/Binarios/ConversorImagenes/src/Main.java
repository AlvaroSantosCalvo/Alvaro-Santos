import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        JPGtoBIN();
    }

    public static void JPGtoBIN() {
        File f1 = new File("uno.jpg");
        File f2 = new File("uno.bin");

        try (
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
    public static void BINtoJPG() {
        File f1 = new File("uno.jpg");
        File f2 = new File("uno.bin");

        try (
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

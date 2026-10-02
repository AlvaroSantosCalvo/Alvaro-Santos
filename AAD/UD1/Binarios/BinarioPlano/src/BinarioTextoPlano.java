import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BinarioTextoPlano {
    public static void main(String[] args) throws Exception {
        escribir();
        leer();        
    }

    public static void leer() {

        File file = new File("password.bin");
        try (
            FileInputStream fStream = new FileInputStream(file);
            DataInputStream reader = new DataInputStream(fStream);
        ) {
            String password = reader.readUTF();
            System.out.println(password);
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void escribir() {
        String password = "DaM1dos3cuatro";

        File file = new File("password.bin");
        try (
            FileOutputStream fStream = new FileOutputStream(file);
            DataOutputStream writer = new DataOutputStream(fStream);
        ) {
            writer.writeUTF(password);
            writer.close();
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}

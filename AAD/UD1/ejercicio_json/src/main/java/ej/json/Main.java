package ej.json;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ej.json.model.Usuario;

public class Main {
    public static void main(String[] args) {

        Usuario us1 = new Usuario(
                1, "Álvaro", "alvaro");
        Usuario us2 = new Usuario(
                2, "Carlos", "carlos");
        Usuario us3 = new Usuario(
                3, "Juan", "juan");

        File f1 = new File("src\\main\\java\\ej\\json\\data\\usuarios.json");
        File f2 = new File("src\\main\\java\\ej\\json\\data\\lista_usuarios.json");
        File f3 = new File("src\\main\\java\\ej\\json\\data\\mapa_usuarios.json");

        List<Usuario> lista_usuarios = List.of(us1, us2, us3);
        Map<Integer, Usuario> mapa_usuarios = Map.of(
                us1.getId(), us1,
                us2.getId(), us2,
                us3.getId(), us3);

        ObjectMapper mapper = new ObjectMapper();

        // Escribir
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(f1, us1);
            mapper.writerWithDefaultPrettyPrinter().writeValue(f2, lista_usuarios);
            mapper.writeValue(f3, mapa_usuarios);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Leer
        try {
            Usuario u = mapper.readValue(f1, Usuario.class);
            System.out.println(u);
            System.out.println("------------------");
            Usuario[] array_usuarios = mapper.readValue(f2, Usuario[].class);
            for (Usuario user : array_usuarios) {
                System.out.println(user);
            }
            System.out.println("------------------");
            Map<Integer, Usuario> mapa = mapper.readValue(f3, new TypeReference<Map<Integer, Usuario>>(){});
            for (Entry <Integer, Usuario> entry : mapa.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

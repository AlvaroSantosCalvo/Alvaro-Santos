package demo;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import demo.model.Persona;

public class Main {
    public static void main(String[] args) {
        
        Persona persona = new Persona(
            "Álvaro", "Santos", 22
        );
        Persona persona2 = new Persona(
            "Carlos", "Gonzalez", 42
        );
        List<Persona> lista = List.of(persona, persona2);

        File fichero = new File("src\\main\\java\\demo\\data\\personas.json");
        File fichero2 = new File("src\\main\\java\\demo\\data\\personas2.json");

        ObjectMapper mapper = new ObjectMapper();

        try {
            
            Persona [] array = mapper.readValue(fichero2, Persona[].class);
            List<Persona> aList = List.of(array);
            for(Persona p : aList){
                System.out.println(p.getNombre());
            }

            List<Persona> lista1 = mapper.readValue(fichero2, new TypeReference<List<Persona>>(){});
            for(Persona p : lista1){
                System.out.println(p.getNombre());
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(fichero, lista);
            mapper.writeValue(fichero2, lista);
            String s = mapper.writeValueAsString(lista);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
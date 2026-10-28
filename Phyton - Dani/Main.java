import java.util.List;

public class Main {
    public static void main(String[] args) {
        say_my_name("Álvaro");
    }

    public static void say_hello() {
        System.out.println("Hello !");
    }

    public static void say_my_name(String name) {
    System.out.println("Hello " + name + "!");
    }

    public static int count_my_letters(String name) {
        return name.length();
    }

    public static int suma_lista(List<Integer> lista) {
        int suma = 0;
        for(Integer i : lista){
            suma+=i;
        }
        return suma;
    }

}
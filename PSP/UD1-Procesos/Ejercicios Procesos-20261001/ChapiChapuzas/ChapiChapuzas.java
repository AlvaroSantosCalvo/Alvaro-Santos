package ChapiChapuzas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class ChapiChapuzas {
    
    public static void main(String[] args) {
        
        Trabajo t = new Trabajo(
            new File("Prueba.txt"), 
            "-fr",
            new File("Frances.txt"));

        checkANDTranlate2();
        
    }

    public static void check(){
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c","check.bat");
        pb.redirectInput(new File("Prueba.txt"));
        pb.redirectOutput(new File("Salida.txt"));
        try {
            Process p = pb.start();
            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }

    public static void translate(){
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c","translate.bat", "-it");
        pb.redirectInput(new File("Prueba.txt"));
        pb.redirectOutput(new File("Italiano.txt"));
        try {
            Process p = pb.start();
            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }

    public static void checkANDTranlate(){
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c","check.bat");
        pb.redirectInput(new File("Prueba.txt"));
        List<String> lineas = new ArrayList<>();
        try (
            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        ){
            lineas = br.readAllLines();
        } catch (IOException e) {
            e.printStackTrace();
        } 

        ProcessBuilder pb2 = new ProcessBuilder("cmd", "/c","translate.bat", "-it");
        pb2.redirectOutput(new File("Italiano.txt"));
        try (
            Process p2 = pb2.start();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p2.getOutputStream()));
        ){
            for(String linea : lineas){
                bw.write(linea);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    public static void checkANDTranlate2(){
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c","check.bat");
        pb.redirectInput(new File("Prueba.txt"));
        ProcessBuilder pb2 = new ProcessBuilder("cmd", "/c","translate.bat");
        pb2.redirectOutput(new File("Ingles.txt"));
        try (
            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

            Process p2 = pb2.start();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p2.getOutputStream()));
        ){
            bw.write("-en");
            bw.newLine();
            bw.flush();
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                bw.write(linea);
                bw.newLine();
                bw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    public static void checkANDTranlate3(Trabajo t){
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c","check.bat");
        pb.redirectInput(t.getSourcePath());
        ProcessBuilder pb2 = new ProcessBuilder("cmd", "/c","translate.bat", t.getLanguage());
        pb2.redirectOutput(t.getDestinationPath());
        List<ProcessBuilder> pBuilders = List.of(pb, pb2);
        try{
            List<Process> processes = ProcessBuilder.startPipeline(pBuilders);
            Process last = processes.getLast();
            last.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }

    public static void checkANDTranlate4(){
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c","check.bat");
        pb.redirectInput(new File("Prueba.txt"));
        String lineas = "";
        try (
            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        ){
            lineas = br.readAllAsString();
        } catch (IOException e) {
            e.printStackTrace();
        } 

        ProcessBuilder pb2 = new ProcessBuilder("cmd", "/c","translate.bat", "-it", lineas);
        pb2.redirectOutput(new File("Italiano.txt"));
        try (
            Process p2 = pb2.start();
        ){
            p2.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }

    public static void checkANDTranlate5(){

        ProcessBuilder pb = new ProcessBuilder("cmd", "/c","check.bat");
        File f = new File("Prueba.txt");
        try (
            BufferedReader bReader = new BufferedReader(new FileReader(f));
            Process p = pb.start();
            BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
        ) {
            String linea;
            while ((linea = bReader.readLine()) != null) {
                bWriter.write(linea);
                bWriter.newLine();
                bWriter.newLine();
            }
        } catch (Exception e) {
        }

    }

}

package ex3;

import java.io.*;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Capitales {

    public static void main(String[] args) {

        HashMap<String,String> llistaPaisesiCap=leerArchivo();
        guardaPuntos(pideString("Cual es tu nombre?"),Juega(llistaPaisesiCap));
    }

    private static int Juega(HashMap<String,String> llistaPaisesiCap){
        int puntos=0;
        String pais;

        for (int i=0;i<10;i++){

            pais=PaisAleatorio(llistaPaisesiCap);

            if(llistaPaisesiCap.get(pais).equalsIgnoreCase(pideString("Cual és la capital de "+pais))){
                ++puntos;
                System.out.println("Enhorabuena has acertado, obtienes un punto");}
            else{System.out.println( "Has fallado !");
            }

        }
        System.out.println("Has acabado el juego, tu puntuación es de "+ puntos);
        return puntos;}

    private static String PaisAleatorio(HashMap<String,String> llistaPaisesiCap){
        Random r1 = new Random();
        int numAzar = r1.nextInt(llistaPaisesiCap.size());
        String pais = (String) llistaPaisesiCap.keySet().toArray()[numAzar];

        return pais;
    }

    private static HashMap<String, String> leerArchivo (){
        HashMap<String, String> llistaPaisesiCap=new HashMap<>();
        FileReader lectortxt=null;
        BufferedReader lectorPalabras=null;
        String lecturaLinea=" ";


        try {
            lectortxt=new FileReader("src/countries.txt");
            lectorPalabras=new BufferedReader(lectortxt);


            while ((lecturaLinea=lectorPalabras.readLine())!=null){
                String[] divisor=lecturaLinea.split(" ");//dividimos la linea de texto.
                // Ponemos la condición que este formado por dos palabras(el pais y la capital) y asignamos cada una de sus partes a un String para añadirlo al HashMap
                if (divisor.length==2){
                    String Pais=divisor[0].trim();
                    String Capital=divisor[1].trim();
                    llistaPaisesiCap.put(Pais,Capital);}
            }

        }catch (FileNotFoundException e)
        {
            System.out.println("No se ha cargado ningún archivo");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }finally {

            try {
                lectorPalabras.close();
                lectortxt.close();//Cerrar recursos

            } catch (IOException e) {
                System.out.println(e.getMessage());

            }
        }

        return llistaPaisesiCap;
    }
    private static void guardaPuntos(String nombre, int puntos) {

        try (FileWriter clasificacion = new FileWriter("src/clasificacion.txt", true)) {

            clasificacion.write("Nombre jugador"+ nombre + " Puntos: " + puntos+"\n");


        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

    }
    public static String pideString(String pregunta){
        Scanner input=new Scanner(System.in);
        System.out.println(pregunta);
        String respostaUsuari=input.nextLine();
        return respostaUsuari;}
}
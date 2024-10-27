package operacionesConFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UsoBuffered {
    public static void main(String[] args) throws IOException{
        /*
         * Leer un fichero línea por línea y mostrarlo por pantalla.
         * Después, modificar el contenido del fichero del fichero (p.e. agregar el número de línea al principio)
         * y volver a visualizar el contenido por pantalla.
         */


         //Lectura de fichero
        try {
            BufferedReader leerFichero = new BufferedReader(new FileReader("D:\\Documentos\\escritura.txt"));
            String linea=leerFichero.readLine();
            while (linea!=null) {
                System.out.println(linea);
                linea=leerFichero.readLine();
            }
            leerFichero.close();
        } catch (Exception e) {
            System.out.println(e);
        }


        //Escritura del fichero
        try {
            BufferedWriter writeFichero = new BufferedWriter(new FileWriter("D:\\Documentos\\escritura.txt"));
            for (int i=0; i<11; i++) {
                writeFichero.write("Linea del fichero numero: "+i);
                writeFichero.newLine();
            }
            writeFichero.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

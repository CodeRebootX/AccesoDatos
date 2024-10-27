package operacionesConFicheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirFicheroBytes {
    public static void main(String[] args) throws IOException {
        /*
         * Escribir datos a un fichero binario (.dat) y después leer el contenido
         * de ese fichero binario para sacarlo por pantalla.
         * Agregar una sección del código que añade datos al final del fichero.
         */
        File fichero = new File ("D:\\Documentos\\ejemplodat.dat");
        //Creamos un flujo de salida hacia el fichero
        try {
            FileOutputStream escribir = new FileOutputStream(fichero,true);
            for (int i=0; i<100; i++) {
                escribir.write(i);
            }

            //Añadimos datos al final del fichero
            byte []array = {0,1,2};
            escribir.write(array);
            escribir.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        //Creamos un flujo de entrada desde el fichero
        try {
            FileInputStream leer = new FileInputStream(fichero);
            int salida=leer.read();
            while (salida!=-1) {
                System.out.println(salida);
                salida=leer.read();
            }
            leer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}

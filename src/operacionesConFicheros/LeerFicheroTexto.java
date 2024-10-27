package operacionesConFicheros;

import java.io.FileReader;
import java.io.IOException;

public class LeerFicheroTexto {
    /*
     * USO FILE READER
     * Leer el contenido de un fichero en grupos de 20 en 20.
     * Probar a realizar la declaración directamente con la clase FileReader (sin crear un objeto File)
     */
    public static void main(String[] args) throws IOException {
        try {
            FileReader fichero = new FileReader("D:\\Documentos\\apuntes.txt");
            int i=0;
            char [] lector = new char[20];
            while (i!=-1) {
                i=fichero.read(lector);
                System.out.println(lector);
            } 
            fichero.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}

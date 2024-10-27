package operacionesConFicheros;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
public class EscribirFicheroTexto {
    public static void main(String[] args) throws IOException{
        /*
         * Crear un fichero de texto con un editor cualquiera y después
         * modificar su contenido con la clase FileWriter.
         * Añadir un carácter cualquiera al final del fichero (p.e. una coma).
         * En el mismo código, añadir una sección en la que escriba el contenido
         * de un String[] en el fichero.
         */
        File archivo = new File("D:\\Documentos\\escritura.txt");
        try {
            FileWriter fw = new FileWriter(archivo, true);
            String cadena = "Añadido al final de fichero\n";
            char[] arrayCadena= cadena.toCharArray();
            for (int i=0; i<cadena.length();i++) {
                fw.write(arrayCadena[i]);
            }
            fw.append("Fin\n\n");

            String [] ciudades ={"Zaragoza", "Madrid", "Barcelona"};
            for (int i=0;i<ciudades.length;i++) {
                fw.write(ciudades[i]+"\n");
            }
            fw.append("Fin ciudades");
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

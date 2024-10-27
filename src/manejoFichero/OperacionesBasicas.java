package manejoFichero;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class OperacionesBasicas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Utiliza el método list() para recuperar una lista de los archivos del directorio actual.
        //Muestra por pantalla si cada elemento recuperado del directorio es un archivo o un directorio.
        File fichero = new File("D:\\Documentos\\");
        String [] listado = fichero.list();
        System.out.println("En la ruta especificada tienes los siguientes archivos y directorios:\n"+Arrays.toString(listado));
        System.out.println("****************************************************************");
        //Mostramos por pantalla si cada elemento es fichero o directorio

        for (String x: listado) {
            File archivo= new File("D:\\Documentos\\", x);
            if (archivo.isFile()) {
                System.out.println(archivo.getName()+" es un archivo");
            } else if (archivo.isDirectory()) {
                System.out.println(archivo.getName()+" es un directorio");
            }
            else System.out.println("No es archivo ni directorio\n\n");
        }
        System.out.println("****************************************************************");
        /*
         * Realiza un programa en Java que muestre los ficheros de un directorio. 
         * El nombre del directorio se pasará al programa desde los argumentos de main(). 
         * Si el directorio no existe se debe mostrar un mensaje indicándolo. 
         * Recupera 6 propiedades (las que prefieras) de cada fichero y muéstralas por pantalla
         */
        System.out.println("Introduce directorio: (ruta)\n");
        String ruta= sc.nextLine();
        fichero= new File(ruta);
        if (fichero.exists()) {
            File [] archivos =fichero.listFiles();
            for (File x: archivos) {
                System.out.println(x.getName());
                System.out.println("Su camino relativo es: "+x.getPath());
                System.out.println("Su camino absoluto es: "+x.getAbsolutePath());
                System.out.println("Se puede escribir?  "+x.canWrite());
                System.out.println("El tamaño del archivo es:  "+x.length());
                System.out.println("Nombre del directorio padre:  "+x.getParent());
                System.out.println("Está oculto? "+x.isHidden()+"\n");
                System.out.println();
            }
        } else System.out.println("El directorio/archivo no existe\n");
        System.out.println("****************************************************************");
        /*
         * Crea un nuevo directorio, dentro crea dos ficheros.
         * Una vez creados, renombra uno de los archivos y elimina el otro.
         * Se debe utilizar manejo de excepciones (IOException).
         */
        
         try {
            File prueba = new File ("D:\\Documentos\\ManejoFicheros");
            if(prueba.mkdir()) {
                System.out.println("El directorio ha sido creado");
                File fichero1= new File(prueba, "fichero.txt");
                File fichero2= new File(prueba, "fichero2.txt");
                if (fichero1.createNewFile()&&fichero2.createNewFile()) {
                    System.out.println("Ficheros creados");
                    File cambioNombre= new File("D:\\Documentos\\ManejoFicheros\\ficheros3.txt");
                    if (fichero1.renameTo(cambioNombre)) {
                        System.out.println("Fichero1 ha cambiado de nombre a fichero3");
                    }
                    if (fichero2.delete()) {
                        System.out.println("Fichero2 ha sido borrado");
                    }
                }
            } else System.out.println("El directorio ya existe!!!!");
         } catch (Exception e) {
            System.out.println(e);
         }
        sc.close();
    }
}
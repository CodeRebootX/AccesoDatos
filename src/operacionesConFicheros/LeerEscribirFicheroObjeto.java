package operacionesConFicheros;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import objetos.Persona;

public class LeerEscribirFicheroObjeto {
    public static void main(String[] args) throws IOException {
        Persona persona;

        String [] nombres = {"Rolando", "Gabriel", "Manolo", "Bombero"};
        int [] edades = {35, 35, 54, 19};
        File fichero = new File ("D:\\Documentos\\ejemplodat.dat");

        //Escribimos los datos
        FileOutputStream fileout = new FileOutputStream(fichero);
        ObjectOutputStream dataout = new ObjectOutputStream(fileout);
        for (int i=0; i<nombres.length; i++) {
            persona = new Persona(nombres[i], edades[i]);
            dataout.writeObject(persona);
        }
        dataout.close();

        //Lectura de los datos

        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream datain = new ObjectInputStream(filein);
        try {
            while (true) {
                persona=(Persona)datain.readObject();
                System.out.printf("Nombre: %s, edad: %d %n", persona.getNombre(), persona.getEdad());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        datain.close();
    }
}

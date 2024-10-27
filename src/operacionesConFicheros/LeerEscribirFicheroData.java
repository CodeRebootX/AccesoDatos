package operacionesConFicheros;

import java.io.IOException;
import java.io.EOFException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class LeerEscribirFicheroData {
    public static void main(String[] args) throws IOException {
        /*
         * Lectura/escritura de primitivas (DataInputStream/DataOutputStream)
         */
        File fichero= new File ("D:\\Documentos\\ejemplodat.dat");
        FileOutputStream escribir = new FileOutputStream(fichero);
        DataOutputStream dataout = new DataOutputStream(escribir);

        //Escritura de datos
        String [] nombres = {"Rolando", "Gabriel", "Manolo", "Bombero"};
        int [] edades = {35, 35, 54, 19};
        for (int i=0; i<nombres.length; i++) {
            dataout.writeUTF(nombres[i]);
            dataout.writeInt(edades[i]);
        }
        dataout.close();

        //Lectura de datos
        FileInputStream filein = new FileInputStream(fichero);
        DataInputStream datain = new DataInputStream(filein);
        String n;
        int e;
        try {
            while (true) {
                n=datain.readUTF();
                e=datain.readInt();
                System.out.printf("Nombre: %s, edad: %d\n",n,e);
            }
            
        } catch (EOFException ex) {
            System.out.println(ex);
        }
        datain.close();
    }
}

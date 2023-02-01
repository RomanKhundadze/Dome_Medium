import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.net.Socket;

public class Datenbank {
    private ArrayList<Medium> medien;
    private String filename = "11223344.bin";

    public Datenbank(){
        this.medien = new ArrayList<Medium>();
    }

    public void erfasseMediumRAM(Medium medium){
        this.medien.add(medium);
    }

    public void auflistenMedienRAM(){
        for (Medium medium : medien) {
            System.out.println(medium);
        }
    }

    public void speichernMedienHD(){
        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
            os.writeObject((ArrayList<Medium>)medien);
            os.close();
        }catch(IOException ex){
            
        }
    }

    public void ladeMedienHD(){
        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename));
            medien = (ArrayList<Medium>)is.readObject();
            is.close();
        }catch(IOException | ClassNotFoundException ex){

        }
    }

    public void ladeMedienServer(){
        try{
            Socket s = new Socket("localhost",1587);

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            dos.writeUTF(filename);
            dos.writeUTF("read");
            
            byte[] bytesToMedien = dis.readAllBytes();    

            ByteArrayInputStream bis = new ByteArrayInputStream(bytesToMedien);
            ObjectInputStream ois = new ObjectInputStream(bis);

            medien = (ArrayList<Medium>)ois.readObject();
            speichernMedienHD();

            bis.close();
            ois.close();
            dos.close();
            dis.close();
            s.close();
        }catch(IOException | ClassNotFoundException exception){

        }
    }

    public void speicherMedienServer(){
        try{
            Socket s = new Socket("localhost",1587);
            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            dos.writeUTF(filename);
            dos.writeUTF("write");
            
            oos.writeObject((ArrayList<Medium>)medien);
            byte[] medienToBytes = bos.toByteArray();

            dos.write(medienToBytes);

            bos.close();
            oos.close();
            dos.close();
            s.close();
        }catch(IOException exception){

        }
    }
}

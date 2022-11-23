import java.net.*;
import java.io.*;
import java.util.*;

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

    public void speichernMedienServer(){
        try{
            Socket s = new Socket("10.128.25.187",1587);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            
            dos.writeUTF(filename);
            dos.writeUTF("read");
            
            DataInputStream dis = new DataInputStream(s.getInputStream());
            byte[] test = dis.readAllBytes();    

            String testString = new String(test);
            System.out.println(testString);

            dis.close();
            s.close();
        }catch(IOException exception){

        }
    }

    public void ladeMedienServer(){
        try{
            Socket s = new Socket("10.128.25.187",1587);
            
            String str = "Test Hallo"; 
            byte[] ladeBytesHoch = str.getBytes();

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            
            dos.writeUTF(filename);
            dos.writeUTF("Hello");
            dos.write(ladeBytesHoch);

            dos.close();
            s.close();
        }catch(IOException exception){

        }
    }


}
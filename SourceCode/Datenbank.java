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

    public void speichernMedien(){
        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
            os.writeObject((ArrayList<Medium>)medien);
        }catch(Exception io){

        }
    }

    public void ladeMedienHD(){
        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename));
            medien = (ArrayList<Medium>)is.readObject();
        }catch(Exception io){

        }
    }
}
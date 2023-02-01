import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class main{
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args){
       // ArrayList<Medium> collect = new ArrayList<>();
       // Datenbank datenbank = new Datenbank();
       // 

       //datenbank.ladeMedienServer();
       //datenbank.auflistenMedienRAM();
       //datenbank.speichernMedienHD();

       //collect.add(new CD("true",
       //    "false", 
       //    inputCreatePlaytime(),
       //    true,
       //    "hello",
       //    15)
       //);

       //collect.add(new DVD("test",
       //    "test",
       //    inputCreatePlaytime(),
       //    false,
       //    "hello darkness my old friend")
       //);
        	
       //System.out.println("Speichern und ausgeben des array inhalts");
       //for (Medium medium : collect) {
       //    datenbank.erfasseMediumRAM(medium);
       //    System.out.println("done"); 
       // }
       // 
       //System.out.println("Speichern des arrays in eine datei!");
       //datenbank.speichernMedienHD();
       //System.out.println("Auslesen der datei!");
       //datenbank.ladeMedienHD();
       //datenbank.auflistenMedienRAM();
       // System.out.println("Ab hier wird das Array ausgegeben!");
   }


   public static boolean inputOwnMedia() {
       while (true) {
           System.out.println("own media yes/no/y/n");
           try {
               String ownMediaYesNo = input.nextLine();
               if (ownMediaYesNo == "yes" || ownMediaYesNo == "y") {
                   return true;
               } else if (ownMediaYesNo == "no" || ownMediaYesNo == "n") {
                   return false;
               }
           } catch (Exception wrongInput) {
               System.out.print("Error:");
               System.out.println(wrongInput.getMessage());
           }
       }
   }

   public static PlayTime inputCreatePlaytime() {
       System.out.println("tipe in play lenght hour minute(max 60) second");
       while (true) {
           try {
               int stunde = input.nextInt(), minute = input.nextInt(), secunde = input.nextInt();
               return new PlayTime(stunde, minute, secunde);
           } catch (Exception wrongInput) {
               System.out.print("Error:");
               System.out.println(wrongInput.getMessage());
           }
       }
   }
}
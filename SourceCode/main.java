import java.util.*;

public class main{
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        ArrayList<Medium> collect = new ArrayList<>();
        Datenbank datenbank = new Datenbank();

        collect.add(new CD("true",
            "false", 
            inputCreatePlaytime(),
            true,
            "hello",
            15)
        );
        collect.add(new DVD("test",
            "test",
            inputCreatePlaytime(),
            false,
            "hello darkness my friend")
        );

        for (Medium medium : collect) {
            System.out.println(medium);
            datenbank.erfasseMediumRAM(medium);
        }

        datenbank.speichernMedien();
    }

    public static boolean inputOwnMedia(){
        while(true){
            System.out.println("own media yes/no/y/n");
            try{
                String ownMediaYesNo = input.nextLine();
                if(ownMediaYesNo == "yes" || ownMediaYesNo == "y"){
                    return true;
                }else if(ownMediaYesNo == "no" || ownMediaYesNo == "n"){
                    return false;
                }
            }catch(Exception wrongInput){
                System.out.print("Error:");
                System.out.println(wrongInput.getMessage());
            }
        }
    }

    public static PlayTime inputCreatePlaytime(){        
        System.out.println("tipe in play lenght hour minute(max 60) second");
        while(true){
            try{
                int stunde = input.nextInt(),minute = input.nextInt(),secunde = input.nextInt();
                return new PlayTime(stunde,minute,secunde);
            }
            catch(Exception wrongInput){
                System.out.print("Error:");
                System.out.println(wrongInput.getMessage());
            }
        }
    }
}
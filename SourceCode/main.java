import java.util.*;

public class main{
    public static void main(String[] args){
        List<Medium> collect = new ArrayList<>();
        
        collect.add(new CD("true",
            "false", 
            inputCreatePlaytime(),
            inputOwnMedia(),
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
        }
    }

    public static boolean inputOwnMedia(){
        while(true){
            System.out.println("own media yes/no/y/n");
            try{
                Scanner input = new Scanner(System.in);
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

    //falls user input genutzt werde muss
    public static PlayTime inputCreatePlaytime(){        
        while(true){
            try{
                Scanner input = new Scanner(System.in);
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
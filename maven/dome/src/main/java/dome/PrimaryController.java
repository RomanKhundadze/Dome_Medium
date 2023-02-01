package dome;
import java.net.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController{
    private Datenbank datenbank;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> choiceBox;
    ObservableList<String> typeList = FXCollections.observableArrayList();

    //nicht vom nutzer editierbar
    @FXML
    private TextArea output;

    //vom nuter editierbar
    @FXML
    private TextArea kommentar;
    @FXML
    private TextField titel;
    @FXML
    private TextField kuenstler;
    @FXML
    private TextField anzahlTitel;
    //soll nur nur numern entgegen nehmen
    @FXML
    private TextField gesamtZeitMinuten;

    //wird nach dem ausführen der FXML ausgeführt
    @FXML
    public void initialize(){
        datenbank = new Datenbank();
        loadTypeListData();
    }

    @FXML
    private CheckBox besitzCheck;
    
    @FXML
    private void Exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void Save(ActionEvent event) {
        Medium tempMedium = SaveAction();
        
        datenbank.erfasseMediumRAM(tempMedium);
        output.setText(tempMedium.toString());
    }

    private Medium SaveAction(){
        switch(choiceBox.getValue()){
            case "CD":
                return new CD(this.titel.getText(), this.kuenstler.getText(), 
                new PlayTime(Integer.parseInt(this.gesamtZeitMinuten.getText())), 
                this.besitzCheck.isSelected(), 
                this.kommentar.getText(), 
                Integer.parseInt(this.anzahlTitel.getText()));
            case "DVD":
                return new DVD(this.titel.getText(), this.kuenstler.getText(), 
                new PlayTime(Integer.parseInt(this.gesamtZeitMinuten.getText())), 
                this.besitzCheck.isSelected(), 
                this.kommentar.getText());
            case "Maxi":
                return new Maxi(this.titel.getText(), this.kuenstler.getText(), 
                new PlayTime(Integer.parseInt(this.gesamtZeitMinuten.getText())), 
                this.besitzCheck.isSelected(), 
                this.kommentar.getText(), 
                Integer.parseInt(this.anzahlTitel.getText()));
            case "LP":
                return new LP(this.titel.getText(), this.kuenstler.getText(), 
                new PlayTime(Integer.parseInt(this.gesamtZeitMinuten.getText())), 
                this.besitzCheck.isSelected(), 
                this.kommentar.getText(), 
                Integer.parseInt(this.anzahlTitel.getText()));

        }
        return null;
    }

    private void loadTypeListData(){
        typeList.removeAll(typeList);
        String a = "CD";
        String b = "DVD";
        String c = "Maxi";
        String d = "LP";
        typeList.addAll(a,b,c,d);
        choiceBox.getItems().addAll(typeList);
    }
}
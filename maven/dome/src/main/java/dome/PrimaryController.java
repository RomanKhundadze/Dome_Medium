package dome;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.UnaryOperator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class PrimaryController{
    private ArrayList<Medium> collect = new ArrayList<>();
    private Datenbank datenbank;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> type;
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
    }

    @FXML
    private void Exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void Save(ActionEvent event) {

    }
}

package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Button clickMeButton;

    /*public void initialize() {
        clickMeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("You clicked a button using Action Event Handler - Code without Lamba Expressions");
            }
        });
    }
    */

    public void initialize(){
        //we dont need parentheses around the input argument, when we are using a single input to lambda expression.
        clickMeButton.setOnAction(event -> System.out.println("You clicked me .... this is the code with lambda " +
                "expressions"));

    }
}

/* =============================================
 * This is a practice program for event handling.
 * 
 * The Window displays a RED button, a BLUE button,
 * and a circle. If the RED button is clicked the
 * circle turns red. If the BLUE button is clicked
 * the circle turns blue.
 * ============================================= */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.event.Event;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class MouseClicks extends Application {
    
    // Instance circle made so the handleButtonAction method will recognize it
    private Circle circle;
    
    public void start (Stage primaryStage) {
        
        // BorderPane creation
        BorderPane pane = new BorderPane();
        
        // Creation of a two buttons, red and blue
        Button red = new Button ("RED");
        Button blue = new Button ("BLUE");

        // HBox creation and adding the butotns to the HBox
        HBox hb = new HBox(red,  blue);
        
        // Alignment the HBox in the center
        hb.setAlignment(Pos.CENTER);
        
        // Sets spacing between the buttons
        hb.setSpacing(10);
        
        // Adding the HBox to the bottom of the pane
        pane.setBottom(hb);
        
        circle = new Circle(0, 0, 50);
        
        pane.setCenter(circle);
        
        Scene scene = new Scene(pane, 400, 300);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        red.setOnAction(this::handleButtonAction);
        blue.setOnAction(this::handleButtonAction);
    }
    
    public void handleButtonAction (ActionEvent event) {
        
        // Checking if the source of the event is a button
        if (event.getSource() instanceof Button) {
            
            Button button = (Button) event.getSource();
            
            // Checking the text of the button to determine the correct color
            if (button.getText().equals("RED")) {
                
                circle.setFill(Color.RED);        
                
            } else if (button.getText().equals("BLUE")) {
            
                circle.setFill(Color.BLUE);
            }
        }
    }
    
    public static void main (String [] args) {
        
        launch (args);
    }
}
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application{
    public static void main(String[] args){
        launch(args); // launch defined in application class
    }

    // Organizes stage and scene. Main stage where everything visual will happen
    public void start(Stage mainStage){
        mainStage.setTitle("Hello World Program");

        Button btn = new Button(); // Create new Button
        btn.setText("Print Hello World!"); // set text of button
        btn.setOnAction(new CustomEventHandler()); // Set click action to custom event handler, defines what button will do when clicked

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 300); // Construct a scene
        mainStage.setScene(scene); // add scene to mainstage
        mainStage.show();
    }
    // Method called to print when custom event handler is called
    private class CustomEventHandler implements EventHandler<ActionEvent>{
        public void handle(ActionEvent event){
            System.out.println("Hello World!");
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package aplikasifx;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author alibabam
 */
public class AplikasiFX extends Application {
    
   
    //This is our PrimaryStage (It contains everything)
    private Stage primaryStage;

    //This is the BorderPane of RootLayout
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        //1) Declare a primary stage (Everything will be on this stage)
        this.primaryStage = primaryStage;

        //Optional: Set a title for primary stage
        this.primaryStage.setTitle("Sample JavaFX App");

        //2) Initialize RootLayout
        initRootLayout();

        //3) Display the EmployeeOperations View
        showEmployeeView();
    }

    //Initializes the root layout.
    public void initRootLayout() {
        try {
            //First, load root layout from RootLayout.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AplikasiFX.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            //Second, show the scene containing the root layout.
            Scene scene = new Scene(rootLayout); //We are sending rootLayout to the Scene.
            primaryStage.setScene(scene); //Set the scene in primary stage.

            /*//Give the controller access to the main.
            RootLayoutController controller = loader.getController();
            controller.setMain(this);*/

            //Third, show the primary stage
            primaryStage.show(); //Display the primary stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Shows the employee operations view inside the root layout.
    public void showEmployeeView() {
        try {
            //First, load EmployeeView from EmployeeView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AplikasiFX.class.getResource("view/EmployeeView.fxml"));
            AnchorPane employeeOperationsView = (AnchorPane) loader.load();

            // Set Employee Operations view into the center of root layout.
            rootLayout.setCenter(employeeOperationsView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package maincontroller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Atividade8 extends Application {

    private static Scene mainScene;
    private static Scene relatorioScene;
    private static Stage stage1;
    @Override
    public void start(Stage stage) throws Exception {
        try {
            stage1 = stage;
            stage.setTitle("Cadastro");

            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            mainScene = new Scene(root);

            Parent relatorioFXML = FXMLLoader.load(getClass().getResource("FXML2.fxml"));
            relatorioScene = new Scene(relatorioFXML);

            stage.setScene(mainScene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void changeScene(String src){
        switch (src) {
            case "Relatorio":
                stage1.setScene(relatorioScene);
                break;
            case "Main":
                stage1.setScene(mainScene);
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

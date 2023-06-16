package maincontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import servicos.Relatorio;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXML2DocumentController implements Initializable {
    @FXML
    private Button botaoGerar = new Button();
    @FXML
    private Button botaoVoltar = new Button();
    @FXML
    private TextArea textRelatorio = new TextArea();

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
        String face = ((Button)event.getSource()).getText();

        if(face.equals("Gerar Relatorio")){
            textRelatorio.setText(Relatorio.retornaRelatorio());
        }

        if(face.equals("Voltar")){
            textRelatorio.clear();
            Atividade8.changeScene("Main");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

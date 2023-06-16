/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package maincontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import filemanager.FIleManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.StageStyle;
import servicos.ControlPacientes;
import servicos.Relatorio;

public class FXMLDocumentController implements Initializable  {

    /*
    Professora eu tentei instanciar os objetos na initialize, porém não funciona e não faço ideia do porque tentei de tudo que é jeito.
    Me desculpe.
     */

    @FXML
    private Button botaoNovo = new Button();
    @FXML
    private Button botaoRelatorio = new Button();
    @FXML
    private Button botaoSair = new Button();
    @FXML
    private Button botaoConsultar = new Button();
    @FXML
    private Button botaoExcluir = new Button();
    @FXML
    private Button botaoAlterar = new Button();
    @FXML
    private ComboBox<String> barraGenero = new ComboBox<>();
    @FXML
    private TextField textCod = new TextField(), textNome = new TextField(), textPeso = new TextField(), textIdade = new TextField(), textAltura = new TextField();
    private ArrayList<String> lista;
    private static ControlPacientes pacientes;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        String face = ((Button)event.getSource()).getText();
        
        if(face.equals("Novo")){
            botaoNovo.setText("Incluir");
        }
        
        if(face.equals("Incluir")){
            try {
                if (pacientes.adicionarPaciente(textNome.getText(), Double.parseDouble(textPeso.getText()), barraGenero.getSelectionModel().getSelectedItem(), Integer.parseInt(textIdade.getText()), Double.parseDouble(textAltura.getText()))) {
                    botaoNovo.setText("Novo");
                    textCod.clear();
                    textNome.clear();
                    textPeso.clear();
                    barraGenero.setValue(null);
                    textIdade.clear();
                    textAltura.clear();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.initStyle(StageStyle.UTILITY);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("Paciente incerido");
                    alert.showAndWait();
                }
            }catch (Exception e){
                botaoNovo.setText("Novo");
                textCod.clear();
                textNome.clear();
                textPeso.clear();
                barraGenero.setValue(null);
                textIdade.clear();
                textAltura.clear();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Maneira correta de preencher:" + "\n" + "Nome: Seu nome" + "\n" + "Peso: 0.0" + "\n" + "Altura: 0.0");
                alert.showAndWait();
           }
        }

        if(face.equals("OK")){
            Atividade8.changeScene("Main");
        }
        
        if(face.equals("Relatorio")){
            Relatorio.gerarRelatorio(pacientes);
            Atividade8.changeScene("Relatorio");
        }

        if(face.equals("Consultar")){
            try {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText(pacientes.consultarPaciente(textNome.getText()));
                alert.showAndWait();
                textCod.clear();
                textNome.clear();
                textPeso.clear();
                barraGenero.setValue(null);
                textIdade.clear();
                textAltura.clear();
            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Paciente nao encontrado!");
                alert.showAndWait();
                textCod.clear();
                textNome.clear();
                textPeso.clear();
                barraGenero.setValue(null);
                textIdade.clear();
                textAltura.clear();
            }
        }

        if(face.equals("Excluir")){
            if(pacientes.excluirPaciente(textNome.getText())){
                textCod.clear();
                textNome.clear();
                textPeso.clear();
                barraGenero.setValue(null);
                textIdade.clear();
                textAltura.clear();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Paciente excluido!");
                alert.showAndWait();
            }else{
                textCod.clear();
                textNome.clear();
                textPeso.clear();
                barraGenero.setValue(null);
                textIdade.clear();
                textAltura.clear();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Paciente nao encontrado!");
                alert.showAndWait();
            }
        }

        if(face.equals("Alterar")){
            try {
                if(pacientes.alterarPaciente(textNome.getText(), Double.parseDouble(textPeso.getText()), barraGenero.getSelectionModel().getSelectedItem(), Integer.parseInt(textIdade.getText()), Double.parseDouble(textAltura.getText()))){
                    textCod.clear();
                    textNome.clear();
                    textPeso.clear();
                    barraGenero.setValue(null);
                    textIdade.clear();
                    textAltura.clear();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.initStyle(StageStyle.UTILITY);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("Paciente alterado!");
                    alert.showAndWait();
                }else{
                    textCod.clear();
                    textNome.clear();
                    textPeso.clear();
                    barraGenero.setValue(null);
                    textIdade.clear();
                    textAltura.clear();
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.initStyle(StageStyle.UTILITY);
                    alert.setTitle("Erro");
                    alert.setHeaderText(null);
                    alert.setContentText("Paciente nao encontrado!");
                    alert.showAndWait();
                }
            }catch (Exception e){
                textCod.clear();
                textNome.clear();
                textPeso.clear();
                barraGenero.setValue(null);
                textIdade.clear();
                textAltura.clear();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Preencha todos os campos!");
                alert.showAndWait();
            }
        }
        
        if(face.equals("Sair")){
            FIleManager.gravarBanco("BancoPacientes.txt",pacientes.ordemIdade());
            System.exit(1);
        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pacientes = new ControlPacientes();
        pacientes.setPacientes(FIleManager.lerBanco("BancoPacientes.txt"));
        lista = new ArrayList<>();

        /*botaoNovo = new Button();
        botaoRelatorio = new Button();
        botaoSair = new Button();
        barraGenero = new ComboBox<>();
        textCod = new TextField();
        textAltura = new TextField();
        textPeso = new TextField();
        textNome = new TextField();
        textIdade = new TextField();*/


        textCod.setDisable(true);
        lista.add("Masculino");
        lista.add("Feminino");
        lista.add("Outro");
        for(String palavra : lista) {
            barraGenero.getItems().add(palavra);
        }
    }
}

module principal.atividade8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens maincontroller to javafx.fxml;
    exports maincontroller;
    exports servicos;
    opens servicos to javafx.fxml;
}
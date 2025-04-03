module es.iesfranciscodelosrios.dam.alfonso.agendapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.iesfranciscodelosrios.dam1.alfonso.agendapp to javafx.fxml;
    exports es.iesfranciscodelosrios.dam1.alfonso.agendapp;
}
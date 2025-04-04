package es.iesfranciscodelosrios.dam1.alfonso.agendapp.controller;

import es.iesfranciscodelosrios.dam1.alfonso.agendapp.model.Contacto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class PrincipalController {
    public ListView<Contacto> contactosListView;
    public Label nombreLabel;
    public Label emailLabel;
    public Label telefonoLabel;
    public Label textoTelefonoLabel;
    public Label textoEmailLabel;
    private ObservableList<Contacto> contactos = FXCollections.observableArrayList();

    public void initialize() {
        Contacto contacto1 = new Contacto("Paco",
                                     "Pérez",
                                   "Fernández",
                                         "957 123 456",
                                            "pacoperez@gmail.com");
        contactos.add(contacto1);
        contactosListView.setItems(contactos);
    }

    public void manejarClickEnContactosListView(MouseEvent mouseEvent) {
        if (contactosListView.getSe(mouseEvent.getY()) == null) {
            listView.getSelectionModel().clearSelection();
        }
        Contacto contactoSeleccionado = contactosListView.getSelectionModel().getSelectedItem();
        if (contactoSeleccionado != null) {

        }
    }

    private void mostrarDatosContacto(Contacto contacto) {
        nombreLabel.setText(contacto.getNombre() + " " + contacto.getPrimerApellido() + " " + contacto.getSegundoApellido());
        textoTelefonoLabel.setVisible(true);
        telefonoLabel.setText(contacto.getTelefono());
        textoEmailLabel.setVisible(true);
        emailLabel.setText(contacto.getEmail());
    }

    private void limpiarDatosContacto() {
        nombreLabel.setText("");
        textoTelefonoLabel.setVisible(false);
        telefonoLabel.setText("");
        textoEmailLabel.setVisible(false);
        emailLabel.setText("");
    }
}

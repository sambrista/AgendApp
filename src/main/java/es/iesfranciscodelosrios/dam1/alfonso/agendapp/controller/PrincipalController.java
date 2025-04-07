package es.iesfranciscodelosrios.dam1.alfonso.agendapp.controller;

import es.iesfranciscodelosrios.dam1.alfonso.agendapp.AgendaApplication;
import es.iesfranciscodelosrios.dam1.alfonso.agendapp.model.Contacto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

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

    private void mostrarContactoEnPanelLateral(Contacto contacto) {
        if (contacto != null) {
            nombreLabel.setText(contacto.getNombre() + " " + contacto.getPrimerApellido() + " " + contacto.getSegundoApellido());
            emailLabel.setText(contacto.getEmail());
            telefonoLabel.setText(contacto.getTelefono());
            textoTelefonoLabel.setVisible(true);
            textoEmailLabel.setVisible(true);
        } else {
            nombreLabel.setText("");
            emailLabel.setText("");
            telefonoLabel.setText("");
            textoTelefonoLabel.setVisible(false);
            textoEmailLabel.setVisible(false);
        }
    }

    public void manejarClickEnContactosListView(MouseEvent mouseEvent) {
        Contacto contactoSeleccionado = contactosListView.getSelectionModel().getSelectedItem();
        mostrarContactoEnPanelLateral(contactoSeleccionado);
    }

    private void mostrarFormularioAnadirEditar(Contacto contacto) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(AgendaApplication.class.getResource("anadir-editar-view.fxml"));
            Scene scene = null;
            scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            AnadirEditarController controlador = fxmlLoader.getController();
            controlador.setListaContactos(contactos);
            if (contacto != null) { // Editando
                controlador.setContacto(contacto);
                stage.setTitle("Editar contacto");
            } else {
                controlador.setContacto(null);
                stage.setTitle("Añadir contacto");
            }
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void manejarBotonAnadir(ActionEvent actionEvent) {
        mostrarFormularioAnadirEditar(null);
    }

    public void manejarBotonEditar(ActionEvent actionEvent) {
        Contacto contactoSeleccionado = contactosListView.getSelectionModel().getSelectedItem();
        if (contactoSeleccionado != null) {
            mostrarFormularioAnadirEditar(contactoSeleccionado);
            contactosListView.refresh();
            mostrarContactoEnPanelLateral(contactoSeleccionado);
        }
    }

    public void manejarBotonBorrar(ActionEvent actionEvent) {
        Contacto contactoSeleccionado = contactosListView.getSelectionModel().getSelectedItem();
        if (contactoSeleccionado != null) {
            contactos.remove(contactoSeleccionado);
            mostrarContactoEnPanelLateral(null);
        }
    }
}

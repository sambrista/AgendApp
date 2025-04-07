package es.iesfranciscodelosrios.dam1.alfonso.agendapp.controller;

import es.iesfranciscodelosrios.dam1.alfonso.agendapp.model.Contacto;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AnadirEditarController {
    public TextField nombreTextField;
    public TextField primerApellidoTextField;
    public TextField segundoApellidoTextField;
    public TextField telefonoTextField;
    public TextField emailTextField;
    public Button guardarButton;

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
        if (contacto != null) {
            nombreTextField.setText(contacto.getNombre());
            primerApellidoTextField.setText(contacto.getPrimerApellido());
            segundoApellidoTextField.setText(contacto.getSegundoApellido());
            telefonoTextField.setText(contacto.getTelefono());
            emailTextField.setText(contacto.getEmail());
        } else {
            nombreTextField.setText("");
            primerApellidoTextField.setText("");
            segundoApellidoTextField.setText("");
            telefonoTextField.setText("");
            emailTextField.setText("");
        }
    }

    public void setListaContactos(ObservableList<Contacto> listaContactos) {
        this.listaContactos = listaContactos;
    }

    private Contacto contacto;
    private ObservableList<Contacto> listaContactos;

    public void manejarBotonGuardar(ActionEvent actionEvent) {
        if (this.contacto == null) { // Añadiendo
            String nombre = nombreTextField.getText();
            String primerApellido = primerApellidoTextField.getText();
            String segundoApellido = segundoApellidoTextField.getText();
            String telefono = telefonoTextField.getText();
            String email = emailTextField.getText();
            Contacto nuevoContacto = new Contacto(nombre, primerApellido, segundoApellido, telefono, email);
            listaContactos.add(nuevoContacto);
        } else { // Editando
            contacto.setNombre(nombreTextField.getText());
            contacto.setPrimerApellido(primerApellidoTextField.getText());
            contacto.setSegundoApellido(segundoApellidoTextField.getText());
            contacto.setTelefono(telefonoTextField.getText());
            contacto.setEmail(emailTextField.getText());
        }
        ((Stage) nombreTextField.getScene().getWindow()).close();
    }
}

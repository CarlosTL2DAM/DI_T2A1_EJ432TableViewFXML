/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmltableview;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author usuario
 */
public class FXMLTableViewController{
    //Atributos
    @FXML private TableView<Person> tableView;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField emailField;
    @FXML
    private TableColumn<?, ?> firstNameColumn;
    
    //Realizamos el evento que se denomina como addPerson, enlazando así con el fxml donde el boton era "onAction=#addPerson"
    @FXML protected void addPerson(ActionEvent evento) {
        //Creamos una instancia de una observable list, que le añadiremos los valores de tableView que se trata de los datos 
        //que incluimos de cada persona
        ObservableList<Person> data = tableView.getItems();
        //A la observableList que se trata de los datos de las personas, vamos a añadir una nueva persona con los datos
        //que incluimos en los campos de firstNameField, lastNameField y emailField
        data.add(new Person(firstNameField.getText(),lastNameField.getText(),emailField.getText()));
        //Posteriormente tras añadirlos los volvemos a dejar a vacio
        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
    }
 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmltableview;

import java.text.Format;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;

/**
 *
 * @author usuario
 */
public class FormattedTableCellFactory<S,T> implements Callback<TableColumn<S, T>, TableCell<S, T>>{
    //Atributos
    private TextAlignment alignment;
    private Format format;
    
    //Metodo para obtener la alineacion
    public TextAlignment getAlignment(){
        return alignment;
    }
    
    //Metodo para introducir la alineacion
    public void setAlignment(TextAlignment alignment) {
        this.alignment = alignment;
    }
    
    //Devuelve el formato
    public Format getFormat() {
        return format;
    }
    
    //Da un formato
    public void setFormat(Format format){
        this.format = format;
    }

    @Override
    @SuppressWarnings("unchecked")
    //Constructor
    public TableCell<S, T> call(TableColumn<S, T> arg0) {
        //Creamos una instancia de la clase TableCell
        TableCell<S,T> cell = new TableCell<S,T>() {
            @Override
            //Método subir un item
            public void updateItem(Object item, boolean empty) {
                //En caso de que item sea igual a la obtención del item?¿
                if(item == getItem()) {
                    return;
                }
                //sino le añadimos el item que se introduce por parametros
                super.updateItem((T) item, empty);
                //Si el item es nulo
                if(item == null)
                {
                    super.setText(null);
                    super.setGraphic(null);
                }
                //Si el formato es nulo
                else if(format != null) {
                    super.setText(format.format(item));
                }
                //Si el item es una instancia de nodo
                else if(item instanceof Node) {
                    super.setText(null);
                    super.setGraphic((Node) item);
                }
                //Cualquier otro caso
                else {
                    super.setText(item.toString());
                    super.setGraphic(null);
                }
            }
        };
        //Alineacion de la celda que sea alignmment
        cell.setTextAlignment(alignment);
        //Alineacion en funcion de alignment
        switch(alignment) {
            case CENTER:
                cell.setAlignment(Pos.CENTER);
                break;
            case RIGHT:
                cell.setAlignment(Pos.CENTER_RIGHT);
                break;
            case LEFT:
                cell.setAlignment(Pos.CENTER_LEFT);
                break;
        }
        //devolvemos la celda.
        return cell;
    }
}

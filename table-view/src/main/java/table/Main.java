package table;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        TableView tableView = new TableView();
        tableView.setEditable(true);

        TableColumn<Person, String> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Person, String> column2 = new TableColumn<>("Last Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        column2.setCellFactory(TextFieldTableCell.<Person>forTableColumn());

        TableColumn<Person, String> column3 = new TableColumn<>("Category");
        column3.setCellValueFactory(new PropertyValueFactory<>("category"));
        column3.setCellFactory(ComboBoxTableCell.<Person, String>forTableColumn("Category 1", "Category 2"));

        TableColumn<Person, Boolean> column4 = new TableColumn<>("Is XYZ");
        column4.setCellValueFactory( cellData -> new ReadOnlyBooleanWrapper(cellData.getValue().getIsXyz()));
        column4.setCellFactory(CheckBoxTableCell.<Person>forTableColumn(column4));


        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);

        tableView.getItems().add(new Person("Alina"  , "Preda"  , null, false));
        tableView.getItems().add(new Person("Roxana"  , "Preda" , "Category 1", true));
        tableView.getItems().add(new Person("Tudor", "Preda", "Category 2", true));



        Button button1 = new Button("Save changes");

        button1.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");

        VBox vbox = new VBox(tableView, button1);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Edit Table View by Alina");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

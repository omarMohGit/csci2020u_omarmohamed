package sample;
import com.sun.net.httpserver.Headers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
public class Controller {
    @FXML private TableView tableView;
    @FXML private TableColumn studentID;
    @FXML private TableColumn midterm;
    @FXML
    public void initialize (){
        studentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        midterm.setCellValueFactory(new PropertyValueFactory<>("midterm"));

    }
}

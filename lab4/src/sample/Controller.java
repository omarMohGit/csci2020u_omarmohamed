package sample;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller {

    private @FXML TextField userName;
    private @FXML TextField passWord;
    private @FXML TextField fName;
    private @FXML TextField eMail;
    private @FXML TextField phoneNum;
    private @FXML DatePicker birthDay;

    public void execute (ActionEvent actionEvent) {
        System.out.println("Username: " + userName.getText());
        System.out.println("Password: " + passWord.getText());
        System.out.println("Full name: " + fName.getText());
        System.out.println("Email: " + eMail.getText());
        System.out.println("Phone number: " + phoneNum.getText());
        System.out.println("Date of birth: " + birthDay.getValue().toString());
    }
}
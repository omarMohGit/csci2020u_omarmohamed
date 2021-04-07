package sample;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.Scanner;
import java.net.Socket;
import java.io.PrintWriter;

public class clientController {

    @FXML
    private TextField usernameField;
    @FXML
    private TextField messageField;
    private Socket socket;
    private BufferedReader inputC;
    private PrintWriter outputC;

    public static String SERVER_ADDRESS="localhost";
    public static int SERVER_PORT = 7000;

    @FXML
    public void initialize(){
        try{
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            outputC= new PrintWriter(socket.getOutputStream(), true);
            inputC= new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }catch(IOException e){
            System.err.println("IOEXception when connecting; Server Address: "+SERVER_ADDRESS);
        }
    }
    public void clientnewMSG(){
        outputC.println(usernameField.getText()+":"+messageField.getText());
        outputC.flush();
    }


    @FXML
    public void exitClientS(){
        try{
            socket.close();
            System.exit(0);
        }catch(IOException e){

        }
    }





}

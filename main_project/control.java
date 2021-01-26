package main_project;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class control {

	@FXML
	private JFXTextField textfield;

	@FXML
	private JFXButton btnlogin;

	@FXML
	private Label lblerror;

	@FXML
	private JFXPasswordField pssfield;

	@FXML
	void setonaction(ActionEvent event) {

		staff login_staff = dbcontrol.logincheck(textfield.getText(), pssfield.getText());
		if (login_staff != null && login_staff.getPosition().equals("admin")) {
			new Alert(AlertType.INFORMATION, "login Successful", ButtonType.OK).showAndWait();
			try {
				Node node = (Node) event.getSource();
				Stage stage = (Stage) node.getScene().getWindow();

				stage.close();
				Scene sc = new Scene(FXMLLoader.load(getClass().getResource("draft1.fxml")));
				stage.setMaximized(false);
				stage.setResizable(false);
				stage.setScene(sc);
				stage.show();

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else if (login_staff != null && login_staff.getPosition().equals("staff")) {
			new Alert(AlertType.INFORMATION, "login Successful", ButtonType.OK).showAndWait();
			try {
				Node node = (Node) event.getSource();
				Stage stage = (Stage) node.getScene().getWindow();

				stage.close();

				Scene sc = new Scene(FXMLLoader.load(getClass().getResource("staff_ui.fxml")));
				stage.setMaximized(false);
				stage.setResizable(false);
				stage.setScene(sc);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {

			new Alert(AlertType.WARNING, "login fail! Please enter correctly", ButtonType.OK).showAndWait();
			textfield.clear();
			pssfield.clear();

		}

	}

}

package main_project;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;

public class AddStaffcontrol implements Initializable {
	@FXML
	private JFXTextField txfname;

	@FXML
	private JFXTextArea txfaddress;

	@FXML
	private JFXTextField txfpassword;

	@FXML
	private JFXRadioButton radstaff;

	@FXML
	private ToggleGroup tggroup;

	@FXML
	private JFXRadioButton radadmin;

	@FXML
	void addaction(ActionEvent event) {
		String status = "active";
		String name;
		String password;
		String address;
		radstaff.setToggleGroup(tggroup);
		radadmin.setToggleGroup(tggroup);
		name = txfname.getText();
		if (!name.matches("^\\w+( +\\w+)*$")) {

			new Alert(AlertType.WARNING, "Please enter the name", ButtonType.OK).showAndWait();
			txfname.requestFocus();
			return;

		}
		password = txfpassword.getText();
		if (!password.matches("^\\w+( +\\w+)*$")) {

			new Alert(AlertType.WARNING, "Please enter the password", ButtonType.OK).showAndWait();
		}
		address = txfaddress.getText();
		if (!address.matches("^\\w+( +\\w+)*$")) {
			new Alert(AlertType.WARNING, "Please enter the address", ButtonType.OK).showAndWait();
			return;
		} else {
			if (radstaff.isSelected()) {
				if (dbcontrol.insertStaff(name, password, address, radstaff.getText(),status)) {
					new Alert(AlertType.INFORMATION, "add new record Successfully", ButtonType.OK).showAndWait();
					txfname.clear();
					txfaddress.clear();
					txfpassword.clear();

				} else {
					new Alert(AlertType.WARNING, "Fail to add", ButtonType.OK).showAndWait();

				}

			} else {
				if (dbcontrol.insertStaff(name, password, address, radadmin.getText(),status)) {
					new Alert(AlertType.INFORMATION, "add new record Successful", ButtonType.OK).showAndWait();
					txfname.clear();
					txfaddress.clear();
					txfpassword.clear();
				} else {
					new Alert(AlertType.WARNING, "Fail to add", ButtonType.OK).showAndWait();
				}
			}
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}

package main_project;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import com.jfoenix.controls.JFXButton;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class itemcontrol implements Initializable {

	@FXML
	private TextField txfqty;
	@FXML
	private Label name;

	@FXML
	private Label price;

	 private Menu menu;
	@FXML
	private ImageView imgview;

	@FXML
	private JFXButton btnadd;
	private actionlistener al;
	@FXML
    void btnadd(MouseEvent event) {
		//
		//al.clickaction(menu);
    }
	

	public void setdata(Menu menu,actionlistener al) {
		this.al = al;
		 this.menu = menu;
		name.setText(menu.getName());
		imgview.setImage(convertTomage(menu.getPhoto()));
		price.setText(String.valueOf(menu.getPrice()));

	}
	private static Image convertTomage(byte[] raw) {
		WritableImage image = new WritableImage(180, 98);
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(raw);
			BufferedImage read = ImageIO.read(bis);
			image = SwingFXUtils.toFXImage(read, null);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return image;
	}
	public List<saledata> getbuyitem(Menu menu) {
		

				ArrayList<saledata> sd = new ArrayList<>();
		

			saledata s1 = new saledata(name.getText(),4,
					Integer.parseInt(price.getText()),
					4 * Integer.parseInt(price.getText()));
			sd.add(s1);
		
			
		
		return sd;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}

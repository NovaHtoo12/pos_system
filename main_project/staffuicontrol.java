package main_project;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class staffuicontrol implements Initializable {
	@FXML
	private TableView<saledata> sale_table;
private actionlistener al;
	@FXML
	private TableColumn<saledata, String> col_name;

	@FXML
	private TableColumn<saledata, Integer> col_qty;

	@FXML
	private TableColumn<saledata, Integer> col_unitprice;

	@FXML
	private TableColumn<saledata, Integer> col_total;
	@FXML
	private JFXButton btninvoice;

	@FXML
	private ImageView logout;

	@FXML
	private ScrollPane scroll;
	@FXML
	void allmenu(ActionEvent event) {
		
		menulist.clear();
		menulist.addAll(dbcontrol.getAllMenu());
		scroll.setContent(null);
		GridPane p = new GridPane();
		
		
		
		System.out.println(menulist.size());
		
		
		System.out.print(menulist.size());

		
		int column = 0;
		int row = 1;
		try {
			for (int i = 0; i < menulist.size(); i++) {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("menuitem.fxml"));
				AnchorPane anchorPane = fxmlLoader.load();

				itemcontrol itemController = fxmlLoader.getController();
				itemController.setdata(menulist.get(i),al);

				if (column == 3) {
					column = 0;
					row++;
				}

				p.add(anchorPane, column++, row); // (child,column,row)

				GridPane.setMargin(anchorPane, new Insets(0, 0, 20, 20));
			}
			scroll.setContent(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void dessertmenu(ActionEvent event) {
		
		scroll.setContent(null);
		GridPane p = new GridPane();
		
		menulist.clear();
		
		System.out.println(menulist.size());
		
		menulist.addAll(dbcontrol.getbycategory("Dessert"));
		System.out.print(menulist.size());

		
		int column = 0;
		int row = 1;
		try {
			for (int i = 0; i < menulist.size(); i++) {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("menuitem.fxml"));
				AnchorPane anchorPane = fxmlLoader.load();

				itemcontrol itemController = fxmlLoader.getController();
				itemController.setdata(menulist.get(i),al);

				if (column == 3) {
					column = 0;
					row++;
				}

				p.add(anchorPane, column++, row); // (child,column,row)

				GridPane.setMargin(anchorPane, new Insets(0, 0, 20, 20));
			}
			scroll.setContent(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void drinkmenu(ActionEvent event) {
		//scroll.setContent(null);
		GridPane p = new GridPane();
		
		menulist.clear();
		
		System.out.println(menulist.size());
		
		menulist.addAll(dbcontrol.getbycategory("Drinks"));
		System.out.print(menulist.size());

		
		int column = 0;
		int row = 1;
		try {
			for (int i = 0; i < menulist.size(); i++) {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("menuitem.fxml"));
				AnchorPane anchorPane = fxmlLoader.load();

				itemcontrol itemController = fxmlLoader.getController();
				itemController.setdata(menulist.get(i),al);

				if (column == 3) {
					column = 0;
					row++;
				}

				p.add(anchorPane, column++, row); // (child,column,row)

				GridPane.setMargin(anchorPane, new Insets(0, 0, 20, 20));
			}
			scroll.setContent(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void mainmenu(ActionEvent event) {
		
		scroll.setContent(null);
		GridPane p = new GridPane();
		
		menulist.clear();
		
		System.out.println(menulist.size());
		
		menulist.addAll(dbcontrol.getbycategory("Main Course"));
		System.out.print(menulist.size());

		
		int column = 0;
		int row = 1;
		try {
			for (int i = 0; i < menulist.size(); i++) {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("menuitem.fxml"));
				AnchorPane anchorPane = fxmlLoader.load();

				itemcontrol itemController = fxmlLoader.getController();
				itemController.setdata(menulist.get(i),al);
				
				if (column == 3) {
					column = 0;
					row++;
				}

				p.add(anchorPane, column++, row); // (child,column,row)

				GridPane.setMargin(anchorPane, new Insets(0, 0, 20, 20));
			}
			scroll.setContent(p);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void invoiceaction(ActionEvent event) {
		try {
			Node node = (Node) event.getSource();
			Stage stage = new Stage();
			Stage oldstage = (Stage) node.getScene().getWindow();
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(oldstage);
			Scene sc = new Scene(FXMLLoader.load(getClass().getResource("invoice.fxml")));
			stage.setScene(sc);

			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void actionlogout(ActionEvent event) {
		try {
			Node node = (Node) event.getSource();
			Stage stage = (Stage) node.getScene().getWindow();

			stage.close();

			Scene sc = new Scene(FXMLLoader.load(getClass().getResource("login_ui.fxml")));
			sc.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			stage.setScene(sc);
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private List<Menu> menulist = new ArrayList<>();
	FXMLLoader fxmlLoader = new FXMLLoader();
	private Menu menu;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		col_qty.setCellValueFactory(new PropertyValueFactory<>("qty"));
		col_unitprice.setCellValueFactory(new PropertyValueFactory<>("price"));
		col_total.setCellValueFactory(new PropertyValueFactory<>("totalamount"));
		showdata();
		actionlistener action = new actionlistener() {
			@Override
			public void clickaction(Menu m) {
				itemcontrol itemController = fxmlLoader.getController();
				sale_table.getItems().addAll(itemController.getbuyitem(m));
			}
		};

		//showdata(menulist);
		// itemcontrol itemController = fxmlLoader.getController();

		// sale_table.getItems().addAll(itemController.getbuyitem());
	}

	public void showdata() {
		menulist.addAll(dbcontrol.getAllMenu());
		scroll.setContent(null);
		GridPane p = new GridPane();
		
		
		
		System.out.println(menulist.size());
		
		
		System.out.print(menulist.size());

		
		int column = 0;
		int row = 1;
		try {
			for (int i = 0; i < menulist.size(); i++) {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("menuitem.fxml"));
				AnchorPane anchorPane = fxmlLoader.load();

				itemcontrol itemController = fxmlLoader.getController();
				itemController.setdata(menulist.get(i),al);
				
				if (column == 3) {
					column = 0;
					row++;
				}
				
				p.add(anchorPane, column++, row); // (child,column,row)

				GridPane.setMargin(anchorPane, new Insets(0, 0, 20, 20));
			}
			
			scroll.setContent(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}

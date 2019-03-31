package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartamentoService;

public class MainViewController implements Initializable{
	@FXML
	private MenuItem menuItemVendedor;
	@FXML
	private MenuItem menuItemDepartamento;
	@FXML
	private MenuItem menuItemAbout;

	@FXML
	public void onMenuItemVendedorAction() {
		System.out.println("onMenuItemVendedorAction");
	}
	
	@FXML
	public void onMenuItemDepartamentoAction() {
		loadView2("/gui/ListaDepartamento.fxml");
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml");
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle resource) {
			
		
	}
	
	private void loadView (String nomeCaminho) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(nomeCaminho));
			VBox newVBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			// getRoot pega o primeiro elemento da view
			VBox mainVBox = (VBox)((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox);
		}		
		catch (IOException e) {
			Alerts.showAlert("IO Exception", "Erro ao carregar a página", e.getMessage(), AlertType.ERROR);
		}
	}
	
	private void loadView2 (String nomeCaminho) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(nomeCaminho));
			VBox newVBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			// getRoot pega o primeiro elemento da view
			VBox mainVBox = (VBox)((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox);
			
			DepartamentoController controller = loader.getController();
			controller.setDepartamentoService(new DepartamentoService());
			controller.updateTableView();
			
		}		
		catch (IOException e) {
			Alerts.showAlert("IO Exception", "Erro ao carregar a página", e.getMessage(), AlertType.ERROR);
		}
	}
}

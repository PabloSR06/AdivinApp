package dad.AdivinApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;



public class AdivinApp extends Application {

	// Variables
	private Label adivinLabel;
	private Button adivinaButton;
	private TextField numText;
	private VBox rootPanel;
	private Alert alerta;
	private int resultado = aleatorio();
	private int intentos = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {

		// Etiqueta
		adivinLabel = new Label();
		adivinLabel.setText("Introduce un numero del 1-100");

		// Cuadro de texto
		numText = new TextField();
		numText.setPromptText("1-100");
		numText.setMaxWidth(150);
		
		//Boton
		adivinaButton = new Button();
		adivinaButton.setText("Comprobar");
		adivinaButton.setOnAction(e -> onAdivinarButtonAction(e));
		
		//Panel Con disposicion vertical
		rootPanel = new VBox();
		rootPanel.setSpacing(15);
		rootPanel.setAlignment(Pos.CENTER);
		rootPanel.getChildren().addAll(adivinLabel, numText, adivinaButton);
		
		Scene scene = new Scene(rootPanel, 320, 200);
		
		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	private void onAdivinarButtonAction(ActionEvent e) {

		try {
			int entrada = Integer.parseInt(numText.getText());
			intentos++;
			if(entrada == resultado) {
				alerta = new Alert(AlertType.INFORMATION);
				alerta.setTitle("AdivinApp");
				alerta.setHeaderText("¡Has ganado!");
				alerta.setContentText("Has necesitado " + intentos + " intentos. \n" + "Vuelve a jugar");
				alerta.showAndWait();
			}else {
				alerta = new Alert(AlertType.WARNING);
				alerta.setTitle("AdivinApp");
				alerta.setHeaderText("¡Has fallado!");
				alerta.setContentText("El número a adivinar es " + (resultado > entrada ? "mayor" : "menor") + " que " + entrada + ".");
				alerta.showAndWait();
			}
			
		} catch (NumberFormatException n) {
			alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("AdivinApp");
			alerta.setHeaderText("Error");
			alerta.setContentText("El número introducido no es valido.");
			alerta.showAndWait();		
		}
		
	}
	private int aleatorio(){
		int num = (int) (Math.random() * 100) + 1;
		return num;
	}

	public static void main(String[] args) {
		launch(args);
	}

}

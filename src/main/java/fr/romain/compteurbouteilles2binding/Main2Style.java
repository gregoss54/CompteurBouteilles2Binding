package fr.romain.compteurbouteilles2binding;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class Main2Style<titleLabel> extends Application {

    private static int totalBottleCount = 0;
    private Label statusLabel;
    private Button addBottleButton, removeBottleButton;
    private final int HEIGHT = 30;
    private final int WIDTH = 30;

    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("Compteur de Bouteilles");
        stage.setResizable(false); // La fenêtre est fixe

        VBox root = new VBox(10);
        root.setBackground(new Background(new BackgroundFill(Color.web("#F8F4F8"), null, null)));
        root.setPadding(new Insets(25));
        root.setAlignment(Pos.CENTER);

        ImageView likeImageView = new ImageView(getClass().getResource("/images/heart1.png").toString());
        likeImageView.setFitWidth(WIDTH);
        likeImageView.setFitHeight(HEIGHT);
        likeImageView.setPreserveRatio(true);

        ImageView likeImageView2 = new ImageView(getClass().getResource("/images/heart2.png").toString());
        likeImageView2.setFitWidth(WIDTH);
        likeImageView2.setFitHeight(HEIGHT);
        likeImageView2.setPreserveRatio(true);

        ImageView dislikeImageView = new ImageView(getClass().getResource("/images/dislike1.png").toString());
        dislikeImageView.setFitWidth(WIDTH);
        dislikeImageView.setFitHeight(HEIGHT);
        dislikeImageView.setPreserveRatio(true);

        ImageView dislikeImageView2 = new ImageView(getClass().getResource("/images/dislike2.png").toString());
        dislikeImageView2.setFitWidth(WIDTH);
        dislikeImageView2.setFitHeight(HEIGHT);
        dislikeImageView2.setPreserveRatio(true);

        Label titleLabel = new Label("Mon compteur de bouteilles");
        titleLabel.setFont(Font.font("Avenir Next", FontWeight.BOLD, 14));
        titleLabel.setTextFill(Color.web("#844E54"));
        titleLabel.setPadding(new Insets( 20,20,  0, 20));

        statusLabel = new Label("Nombre de Bouteille : " + totalBottleCount);
        statusLabel.setTextFill(Color.web("#044E54"));

        addBottleButton = new Button("Ajouter une bouteille");
        addBottleButton.setGraphic(likeImageView);
        addBottleButton.setContentDisplay(ContentDisplay.TOP);
        addBottleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                totalBottleCount++;
                updateStatusLabel(totalBottleCount);
            }
        });

        addBottleButton.setOnMouseEntered(mouseEvent -> {
            addBottleButton.setGraphic(likeImageView2);
            addBottleButton.setContentDisplay(ContentDisplay.TOP);
        });

        addBottleButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                addBottleButton.setGraphic(likeImageView);
                addBottleButton.setContentDisplay(ContentDisplay.TOP);
            }
        });

        removeBottleButton = new Button("Retirer une bouteille");
        removeBottleButton.setGraphic(dislikeImageView);
        removeBottleButton.setContentDisplay(ContentDisplay.TOP);
        removeBottleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                totalBottleCount--;
                if (totalBottleCount < 0) {
                    totalBottleCount = 0;
                }
                updateStatusLabel(totalBottleCount);
            }
        });

        removeBottleButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                removeBottleButton.setGraphic(dislikeImageView2);
                removeBottleButton.setContentDisplay(ContentDisplay.TOP);
            }
        });

        removeBottleButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                removeBottleButton.setGraphic(dislikeImageView);
                removeBottleButton.setContentDisplay(ContentDisplay.TOP);
            }
        });

        root.getChildren().addAll(titleLabel, statusLabel, addBottleButton, removeBottleButton);
        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    public void updateStatusLabel(int totalBottleCount) {
        if (totalBottleCount > 1) {
            statusLabel.setText("Nombre de Bouteilles : " + totalBottleCount);
        } else {
            statusLabel.setText("Nombre de Bouteille : " + totalBottleCount);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}

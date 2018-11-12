package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    ListView<String> listView = new ListView<String>();
    public static void main(String[] args) {
        launch(args);
    }


     @Override
    public void start(Stage primaryStage) throws Exception{
        final Deck deck = new Deck();
        final ObservableList cards = deck.getCards();
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Kartenspiel");
        primaryStage.setWidth(280);
        primaryStage.setHeight(550);


        final Label label = new Label("Card sort");
        label.setFont(new Font("Arial", 20));

        Button buttonShuffle = new Button("Shuffle");
        buttonShuffle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                deck.shuffle(12);
            }
        });


        Button buttonQuicksort = new Button("Quicksort");
        buttonQuicksort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                deck.quicksort(0, cards.size()-1);
            }
        });

         listView.setItems(deck.getCards());
         listView.setPrefHeight(100);
         listView.setPrefHeight(470);

         final VBox vBox = new VBox();
         vBox.setSpacing(5);
         vBox.setPadding(new Insets(10,0,0,10));
         vBox.getChildren().addAll(label, buttonShuffle, buttonQuicksort, listView);

         ((Group) scene.getRoot()).getChildren().addAll(vBox);

         primaryStage.setScene(scene);
         primaryStage.show();
    }

}

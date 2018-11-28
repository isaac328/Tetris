package main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * @author Chad
 *
 */
public class test extends Application implements EventHandler<ActionEvent> {
    private String[] colors = {"blue", "green", "red", "yellow"};
    Button btn = new Button("Click Me");
    Pane pane1 = new Pane();

    private int colorIterate = 0;

    private long timeStamp = 0;
    private long tmp = 0;
    private long diff = 0;

    AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            diff = now - tmp;

            System.out.println(diff);
            tmp = now;
            if (now - timeStamp > 1000000000) {
                timeStamp = now;
                changeColor();
            }
        }
    };

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane mainPane = new BorderPane();
        pane1.setPrefSize(200, 200);

        mainPane.setTop(btn);
        mainPane.setCenter(pane1);

        btn.setOnAction(this);

        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                animationTimer.stop();
            }
        });
    }

    private void changeColor() {
        pane1.setStyle("-fx-background-color: " + colors[colorIterate%colors.length]);
        colorIterate++;
    }


    @Override
    public void handle(ActionEvent event) {
        animationTimer.start();
    }
}
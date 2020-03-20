package UserInterface;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ControlsMenu
{
    private Scene cm;

    public ControlsMenu(Stage stage, Menu ms)
    {
        Image imageBackground = new Image("Assets/Menu/Start_Menu.gif");
        ImageView background = new ImageView(imageBackground);
        Image imageBack = new Image("Assets/back.png");

        Image controlButtons = new Image("Assets/Menu/controlButtons.png");
        ImageView controlPic = new ImageView(controlButtons);
        background.setX(0);
        background.setY(0);
        background.setFitHeight(603);
        background.setFitWidth(1200);


        Button back = new Button();
        back.setGraphic(new ImageView(imageBack));
        back.setStyle("-fx-background-color: transparent;");
        back.setOnAction(event -> stage.setScene(ms.getStartMenu()));
        back.setOnMouseEntered(event -> back.setGraphic(new ImageView("Assets/back_hover.png")));
        back.setOnMouseExited(event -> back.setGraphic(new ImageView("Assets/back.png")));
        back.setLayoutX(0);
        back.setLayoutY(503);

        Group characterMenuLayout = new Group();
        characterMenuLayout.getChildren().addAll(background, controlPic, back);

        this.cm = new Scene(characterMenuLayout, 1200, 603);

    }

    public Scene getControlScene ()
    {
        return this.cm;
    }
}

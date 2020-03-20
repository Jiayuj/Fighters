package UserInterface;

import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class ArenaSelectScreen
{

    private Arena arenaSetup;
    private Scene arena;
    private Image arenaChoice;
    private CharacterSelectScreen characterSelectScreen;

    public ArenaSelectScreen(Stage stage)
    {

        Image imageBackground = new Image("Assets/Menu/Start_Menu.gif");
        Image imageBgOption0 = new Image("Assets/Background0.gif");
        Image imageBgOption1 = new Image("Assets/Background1.gif");
        Image imageBgOption2 = new Image("Assets/Background2.gif");
        Image imageArrowLeft = new Image("Assets/leftt.png");
        Image imageArrowRight = new Image("Assets/right.png");
        Image imageArenaSelect = new Image("Assets/arena_selection.png");
        Image imageChooseMap = new Image("Assets/choose_map.png");

        ImageView arenaSelectTitle = new ImageView(imageArenaSelect);
        arenaSelectTitle.setX(200);
        arenaSelectTitle.setY(-25);

        ImageView background = new ImageView(imageBackground);
        background.setX(0);
        background.setY(0);
        background.setFitHeight(603);
        background.setFitWidth(1200);

        ImageView BgOption = new ImageView(imageBgOption1);
        BgOption.setFitHeight(301.5);
        BgOption.setFitWidth(600);
        BgOption.setX(301.5);
        BgOption.setY(150);
        BgOption.setStyle("-fx-border-color: black; -fx-border-style: solid; -fx-border-width: 5;");

        Button arrowLeft = new Button("", new ImageView(imageArrowLeft));
        arrowLeft.setLayoutX(100);
        arrowLeft.setLayoutY(151.5+35);
        arrowLeft.setStyle("-fx-background-color: transparent;");

        Button arrowRight = new Button("", new ImageView(imageArrowRight));
        arrowRight.setLayoutX(900);
        arrowRight.setLayoutY(151.5+35);
        arrowRight.setStyle("-fx-background-color: transparent;");

        arrowLeft.setOnAction(event -> {
            if(BgOption.getImage() == imageBgOption1)
            {
                BgOption.setImage(imageBgOption0);
                arrowLeft.setVisible(false);
            }
            else if(BgOption.getImage() == imageBgOption2)
            {
                BgOption.setImage(imageBgOption1);
                arrowRight.setVisible(true);
            }
        } );
        arrowLeft.setOnMouseEntered(event -> arrowLeft.setGraphic(new ImageView("Assets/left_hover.png")));
        arrowLeft.setOnMouseExited(event -> arrowLeft.setGraphic(new ImageView(imageArrowLeft)));

        arrowRight.setOnAction(event ->
        {
            if(BgOption.getImage() == imageBgOption1)
            {
                BgOption.setImage(imageBgOption2);
                arrowRight.setVisible(false);
            }
            else if(BgOption.getImage() == imageBgOption0)
            {
                BgOption.setImage(imageBgOption1);
                arrowLeft.setVisible(true);
            }
        });
        arrowRight.setOnMouseEntered(event -> arrowRight.setGraphic(new ImageView("Assets/right_hover.png")));
        arrowRight.setOnMouseExited(event -> arrowRight.setGraphic(new ImageView(imageArrowRight)));

        Button back = new Button("", new ImageView("Assets/back.png"));
        back.setStyle("-fx-background-color: transparent;");
        back.setOnAction(event -> stage.setScene(characterSelectScreen.getCharacterSelectScene()));
        back.setOnMouseEntered(event -> back.setGraphic(new ImageView("Assets/back_hover.png")));
        back.setOnMouseExited(event -> back.setGraphic(new ImageView("Assets/back.png")));
        back.setLayoutX(0);
        back.setLayoutY(503);


        Button selectMap = new Button("", new ImageView(imageChooseMap));
        selectMap.setLayoutX(400);
        selectMap.setLayoutY(403);
        selectMap.setStyle("-fx-background-color: transparent;");
        selectMap.setOnMouseEntered(event -> selectMap.setGraphic(new ImageView("Assets/choose_map_hover.png")));
        selectMap.setOnMouseExited(event -> selectMap.setGraphic(new ImageView(imageChooseMap)));
        selectMap.setOnAction(event -> {
            setArenaMap((BgOption.getImage()));
            arenaSetup.setArenaChoice(BgOption.getImage());
            arenaSetup.play(stage);
            stage.setScene(this.arenaSetup.getArena());

        });

        Group arenaSelectLayout = new Group();
        arenaSelectLayout.getChildren().addAll(background, arenaSelectTitle, BgOption, arrowLeft, arrowRight, selectMap,
                back);
        Scene arenaSelect = new Scene(arenaSelectLayout, 1200, 603);
        arenaSelect.setCursor(new ImageCursor(new Image("Assets/cursor.png")));
        this.arena = arenaSelect;
    }

    public void setArena(Arena a)
    {
        this.arenaSetup = a;
    }

    public Scene getArenaSelectScene()
    {
        return this.arena;
    }

    public void setArenaMap(Image chosenMap)
    {
        this.arenaChoice = chosenMap;
    }

    public Image getArenaChoice()
    {
        return this.arenaChoice;
    }

    public void setCharacterSelectScreen(CharacterSelectScreen characterSelectScreen)
    {
        this.characterSelectScreen = characterSelectScreen;
    }
}

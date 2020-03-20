package UserInterface;

import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application
{

    public static void main(String args[])
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException
    {
        stage.setTitle("Sauga Fighterz");
        stage.getIcons().add(new Image("Assets/Logo.png"));
        stage.setResizable(false);

        Menu ms = new Menu(stage);
        ArenaSelectScreen as = new ArenaSelectScreen(stage);
        CharacterSelectScreen cs = new CharacterSelectScreen(stage);
        ControlsMenu cm = new ControlsMenu(stage, ms);
        Arena arena = new Arena();
        Music music = new Music();
        music.playMusic();

        cs.setMenu(ms);
        cs.setArenaSelect(as);
        cs.setArena(arena);
        as.setArena(arena);
        as.setCharacterSelectScreen(cs);
        ms.setCharacterSelectScreen(cs);
        ms.setControlsMenu(cm);
        arena.setMenu(ms);
        stage.setScene(ms.getStartMenu());
        stage.show();
    }
}
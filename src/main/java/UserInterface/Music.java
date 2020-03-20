package UserInterface;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Music
{
    private static MediaPlayer mediaPlayer;

    public MediaPlayer playMusic()
    {
        Media song1 = new Media(new File("src/main/resources/Audio/Music/song_1.mp3").toURI().toString());
        Media song2 = new Media(new File("src/main/resources/Audio/Music/song_2.mp3").toURI().toString());
        Media song3 = new Media(new File("src/main/resources/Audio/Music/song_3.mp3").toURI().toString());
        Media song4 = new Media(new File("src/main/resources/Audio/Music/song_4.mp3").toURI().toString());
        Media song5 = new Media(new File("src/main/resources/Audio/Music/song_5.mp3").toURI().toString());

        List<Media> playlist = new ArrayList<>();
        playlist.add(song1);
        playlist.add(song2);
        playlist.add(song3);
        playlist.add(song4);
        playlist.add(song5);

        mediaPlayer = new MediaPlayer(playlist.get((int)(Math.random()*4)+1));

        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(25);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        return mediaPlayer;
    }
}

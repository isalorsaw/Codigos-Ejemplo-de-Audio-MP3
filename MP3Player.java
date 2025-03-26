import javazoom.jl.player.Player;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Scanner;

public class MP3Player 
{
    private final String mp3FileToPlay;
    private Player jlPlayer;

    public MP3Player(String mp3FileToPlay)//Constructor
    {
        this.mp3FileToPlay = mp3FileToPlay;
    }

    public void play()//Reproducir
    {
        try 
        {
            FileInputStream fileInputStream = new FileInputStream(mp3FileToPlay);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            jlPlayer = new Player(bufferedInputStream);
        }
        catch (Exception e) 
        {
            System.out.println("Problem playing mp3 file " + mp3FileToPlay);
            System.out.println(e);
        }

        new Thread() //Hilo=Thread
        {
            public void run() 
            {
                try 
                {
                    jlPlayer.play();
                }
                catch (Exception e) 
                {
                    System.out.println(e.getMessage());
                }
            }
        }.start();
    }
    public void close()//Stop o Parar
    {
        if (jlPlayer != null) jlPlayer.close();
    }
}
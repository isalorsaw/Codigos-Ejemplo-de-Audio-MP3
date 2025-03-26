import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.File;
public class Main
{
    public static void main(String[] args) 
    {
        File file=new File("sonido de disparo.mp3");
        String ruta=file.getAbsolutePath();
        
        MP3Player mp3Player = new MP3Player(ruta);//Inicializamos MP3Player
        mp3Player.play();//Reproducimos
    }
}
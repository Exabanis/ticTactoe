import java.io.File; 
import java.io.IOException;
  
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip;

public class Sounds{

    Clip clip;
    AudioInputStream audioInputStream;
    public static void main(String[] args){
        Sounds s = new Sounds();
        s.play("draw.wav");
    }

    public void play(String audioPath){
        try { 
            // create AudioInputStream object 
            audioInputStream = AudioSystem.getAudioInputStream(new File(audioPath).getAbsoluteFile()); 
              
            // create clip reference 
            clip = AudioSystem.getClip(); 
              
            // open audioInputStream to the clip 
            clip.open(audioInputStream); 
              
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            clip.start();
            Thread.sleep(2300);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }    
}
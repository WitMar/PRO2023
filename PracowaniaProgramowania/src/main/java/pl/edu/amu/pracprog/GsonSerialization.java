package pl.edu.amu.pracprog;

import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import com.google.gson.Gson;
import pl.edu.amu.pracprog.music.*;

import java.time.LocalDateTime;

public class GsonSerialization {

    final static Logger logger = Logger.getLogger(GsonSerialization.class);


    public static void printJson(){
        Album album = new Album("Dark Side of the Moon", 1973);
        album.addTrack(new Track(1, "Speak to Me/Breathe", 237));

        Gson gson = new Gson();
        String serializedAlbum = gson.toJson(album);
        logger.info("Print album json:");
        System.out.println(serializedAlbum);

        Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
        String prettySerializedAlbum = gsonPretty.toJson(album);
        logger.info("Pretty-print album json:");
        System.out.println(prettySerializedAlbum);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.toString());
        String serializedTime = gsonPretty.toJson(now);
        System.out.println(serializedTime);
        LocalDateTime now2 = gson.fromJson(serializedTime, LocalDateTime.class);
        System.out.println(now2.toString());
    }


    public static void main(String [ ] args) {
        printJson();
    }
}


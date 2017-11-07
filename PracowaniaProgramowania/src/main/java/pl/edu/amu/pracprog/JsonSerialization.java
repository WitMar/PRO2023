package pl.edu.amu.pracprog;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;
import com.google.gson.Gson;
import pl.edu.amu.pracprog.music.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

public class JsonSerialization {

    final static Logger logger = Logger.getLogger(JsonSerialization.class);


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


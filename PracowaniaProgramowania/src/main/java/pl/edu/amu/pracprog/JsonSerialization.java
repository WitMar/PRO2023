package pl.edu.amu.pracprog;

import org.apache.log4j.Logger;
import com.google.gson.Gson;
import pl.edu.amu.pracprog.music.Album;

public class JsonSerialization {

    final static Logger logger = Logger.getLogger(JsonSerialization.class);

    public static void main(String [ ] args) {
        Gson gson = new Gson();
        Album album = new Album("Dark Side of the Moon", 1973);
        String serializedAlbum = gson.toJson(album);
        System.out.println(serializedAlbum);
    }
}


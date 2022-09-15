package util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataUserProvider {
    static List<String> listName= Arrays.asList("Bill", "Mark", "Tom");

    public static String getName(){
        return listName.get(new Random().nextInt(listName.size()));
    }
}

package util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataProvider {
    static List<String> listName= Arrays.asList("Andrii","Natali","Alex","Olga");

    public static List<Integer> listAges=Arrays.asList(20,24,45,68,50,35,40);

    public static String getRandomName(){
        return listName.get(new Random().nextInt(listName.size()));
    }

    public static Integer getRandomAges(){
        return listAges.get(new Random().nextInt(listAges.size()));
    }


}

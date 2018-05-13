package ru.arkhipov.autotest.utils;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aasx .
 */
public class Stash {

    private static Map<String, Object> stash = new HashMap<>();

    public static Object get (String key){
        return stash.get(key);
    }

    public static void put(String key, Object value){
        stash.put(key, value);
    }

}

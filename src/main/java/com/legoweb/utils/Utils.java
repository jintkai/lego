package com.legoweb.utils;

import java.util.UUID;

public class Utils {

    public static String getUUID32(){
        return UUID.randomUUID().toString().replace("-","").toLowerCase();
    }
}

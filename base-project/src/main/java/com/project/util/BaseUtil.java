package com.project.util;

public class BaseUtil {

    public static String lastDotSubStringItem(String item) {
        return item.substring(item.lastIndexOf('.')+1);
    }
}

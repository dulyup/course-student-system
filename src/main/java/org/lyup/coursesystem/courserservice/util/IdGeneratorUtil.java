package org.lyup.coursesystem.courserservice.util;

public class IdGeneratorUtil {

    public static String generateId(String prefix, int count) {
        return String.format("%s%07d", prefix , count++);
    }

}

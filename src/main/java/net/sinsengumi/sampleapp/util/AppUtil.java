package net.sinsengumi.sampleapp.util;

import org.apache.commons.lang3.RandomStringUtils;

public final class AppUtil {

    public static String createErrorCode() {
        return RandomStringUtils.randomAlphanumeric(15);
    }
}

package net.sinsengumi.sampleapp.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Site {
    API("API", "/api", false),
    SCREEN_RESTRICTED("管理画面", "/restricted", true),
    SCREEN_USER("ユーザ画面", "/", true);

    private String label;
    private String baseUrl;
    private boolean protectCsrf;

    // 列挙子の順番を変えると、誤判定するので注意。
    public static Site of(String url) {
        if (url == null) {
            return SCREEN_USER;
        }

        for (Site location : values()) {
            if (url.startsWith(location.baseUrl)) {
                return location;
            }
        }

        return SCREEN_USER;
    }
}

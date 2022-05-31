package com.example.taserfan.API;

import static com.example.taserfan.API.API.Routes.URL;

public class API {
    public static class Routes {
        // Oracle
        public static final String AUTHENTICATE = "/authenticate";
        public static String URL = "http://10.11.19.5:4567";
        public static void changeURL(String IP, String Puerto){
            URL = "http://"+IP+":"+Puerto;
        }
    }





}

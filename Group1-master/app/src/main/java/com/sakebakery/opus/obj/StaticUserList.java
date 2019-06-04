package com.sakebakery.opus.obj;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StaticUserList {

    public static ArrayList<Userobj> getUserList(){
        ArrayList<Userobj> userobjs = new ArrayList<>();

        Userobj userobj = new Userobj();
        userobj.setActive(1);
        userobj.setUser_id("USR0001");
        userobj.setUser_name("Kyaw Phyo Aung");
        userobj.setUser_email("kpa@gmail.com");
        userobj.setUser_password("******");
        userobj.setUser_address("Botahtaung");
        userobj.setUser_phone("09691234342");

        return userobjs;
    }
}

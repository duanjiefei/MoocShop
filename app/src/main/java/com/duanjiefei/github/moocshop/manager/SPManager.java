package com.duanjiefei.github.moocshop.manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.duanjiefei.github.moocshop.application.MoocApplication;

public class SPManager {
    private static SPManager spManager = null;
    private static SharedPreferences sp = null;
    private static SharedPreferences.Editor editor = null;

    //向导页是否已经走过
    public static final String IS_SHOW_GUIDE = "is_show_guide";

    //sharePreference 文件的名字
    private final static String MOOC_PRE = "mooc.pre";

    public static SPManager getInstance(){
        if(spManager == null || sp == null || editor == null){
            spManager = new SPManager();
        }
        return spManager;
    }

    private SPManager(){
        sp  = MoocApplication.getInstance().getSharedPreferences(MOOC_PRE, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public int getInt(String key, int defaultValue) {
        return sp.getInt(key, defaultValue);
    }

    public void putLong(String key, Long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    public long getLong(String key, int defaultValue) {
        return sp.getLong(key, defaultValue);
    }

    public void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key, String defaultValue) {
        return sp.getString(key, defaultValue);
    }

    public void putFloat(String key, float value) {
        editor.putFloat(key, value);
        editor.commit();
    }

    public boolean isKeyExist(String key) {
        return sp.contains(key);
    }

    public float getFloat(String key, float defaultValue) {
        return sp.getFloat(key, defaultValue);
    }

    public void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return sp.getBoolean(key, defaultValue);
    }

    public void remove(String key) {
        editor.remove(key);
        editor.commit();
    }

}

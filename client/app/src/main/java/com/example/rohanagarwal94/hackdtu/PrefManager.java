//package com.example.rohanagarwal94.hackdtu;
//
//import android.content.SharedPreferences;
//import android.preference.PreferenceManager;
//
//import java.util.Set;
//
///**
// * Created by rohanagarwal94 on 4/2/17.
// */
//public class PrefManager {
//
//    private static SharedPreferences getPreferences() {
//        return PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance()
//                .getApplicationContext());
//    }
//
//    public static void clearPrefs() {
//        getPreferences().edit().clear().apply();
//    }
//
//    public static int getInt(String preferenceKey, int preferenceDefaultValue) {
//        return getPreferences().getInt(preferenceKey, preferenceDefaultValue);
//    }
//
//    public static void putInt(String preferenceKey, int preferenceValue) {
//        getPreferences().edit().putInt(preferenceKey, preferenceValue).apply();
//    }
//
//    public static long getLong(String preferenceKey, long preferenceDefaultValue) {
//        return getPreferences().getLong(preferenceKey, preferenceDefaultValue);
//    }
//
//    public static void putLong(String preferenceKey, long preferenceValue) {
//        getPreferences().edit().putLong(preferenceKey, preferenceValue).apply();
//    }
//
//    public static float getFloat(String preferenceKey, float preferenceDefaultValue) {
//        return getPreferences().getFloat(preferenceKey, preferenceDefaultValue);
//    }
//
//    public static void putFloat(String preferenceKey, float preferenceValue) {
//        getPreferences().edit().putFloat(preferenceKey, preferenceValue).apply();
//    }
//
//    public static boolean getBoolean(String preferenceKey, boolean preferenceDefaultValue) {
//        return getPreferences().getBoolean(preferenceKey, preferenceDefaultValue);
//    }
//
//    public static void putBoolean(String preferenceKey, boolean preferenceValue) {
//        getPreferences().edit().putBoolean(preferenceKey, preferenceValue).apply();
//    }
//
//    public static String getString(String preferenceKey, String preferenceDefaultValue) {
//        return getPreferences().getString(preferenceKey, preferenceDefaultValue);
//    }
//
//    public static void putString(String preferenceKey, String preferenceValue) {
//        getPreferences().edit().putString(preferenceKey, preferenceValue).apply();
//    }
//
//    public static void putStringSet(String preferencesKey, Set<String> values) {
//        getPreferences().edit().putStringSet(preferencesKey, values).apply();
//    }
//
//    public static Set<String> getStringSet(String preferencesKey) {
//        return getPreferences().getStringSet(preferencesKey, null);
//    }
//
//}
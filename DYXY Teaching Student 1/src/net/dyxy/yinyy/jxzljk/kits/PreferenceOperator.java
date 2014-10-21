package net.dyxy.yinyy.jxzljk.kits;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class PreferenceOperator {

	public static final class Keys {
		public static String REMEMBER = "remember";
		public static String USERNAME = "username";
		public static String PASSWORD = "password";
		public static String CURRENT = "current";
	}

	public static String getStringPref(Context context, String key) {
		return getStringPref(context, key, "");
	}

	public static String getStringPref(Context context, String key, String defaultValue) {
		return PreferenceManager.getDefaultSharedPreferences(context).getString(key, defaultValue);
	}

	public static boolean getBooleanPref(Context context, String key) {
		return getBooleanPref(context, key, false);
	}

	public static boolean getBooleanPref(Context context, String key, boolean defaultValue) {
		return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(key, defaultValue);
	}

	public static void putBooleanPref(Context context, String key, boolean value) {
		Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	public static void putStringPref(Context context, String key, String value) {
		Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
		editor.putString(key, value);
		editor.commit();
	}

	public static void removePreference(Context context, String key) {
		Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
		editor.remove(key);
		editor.commit();
	}
}

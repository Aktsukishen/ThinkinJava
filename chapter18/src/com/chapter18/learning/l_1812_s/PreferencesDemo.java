package com.chapter18.learning.l_1812_s;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PreferencesDemo {

	public static void main(String[] args) throws BackingStoreException {
		Preferences prefs=Preferences.userNodeForPackage(PreferencesDemo.class);
		prefs.put("Location","Oz");
		prefs.put("Footwear", "Ruby Slippers");
		prefs.putInt("Companions", 4);
		prefs.putBoolean("Are there witches?", true);
		int usageCount=prefs.getInt("UsageCount", 0);
		usageCount++;
		prefs.putInt("UsageCount", usageCount);//每次运行程序都会自增1
		for(String key:prefs.keys()){
			System.out.println(key+":"+prefs.get(key, null));
		}
		System.out.println("How many companios does Dorothy hava?"+prefs.getInt("Companions", 0));
	}

}

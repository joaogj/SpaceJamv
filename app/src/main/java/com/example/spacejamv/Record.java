package com.example.spacejamv;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Record {

	private Context c;
	
	public Record(Context c){
		this.c = c;
	}
	
	public void saveRecord(int newScore){
		if(newScore > read()){
			SharedPreferences prefs = c.getSharedPreferences("records", Context.MODE_PRIVATE);
			
			Editor edit = prefs.edit();
			edit.putInt("score", newScore);
			edit.commit();
		}
    }

	private int read(){
    	SharedPreferences prefs = c.getSharedPreferences("records", Context.MODE_PRIVATE);
    	return prefs.getInt("score", 0);
    }
	
	public String getRecordString(){
		return Integer.toString(read());
	}
	
}

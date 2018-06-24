package com.example.spacejamv;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Record {

	private Context c;
	
	public Record(Context c){
		this.c = c;
	}
	
	/*SharedPreferences userDetails = context.getSharedPreferences("userdetails", MODE_PRIVATE);
	Editor edit = userDetails.edit();
	edit.clear();
	edit.putString("username", txtUname.getText().toString().trim());
	edit.putString("password", txtPass.getText().toString().trim());
	edit.commit();*/
	
	public void SaveRecord(int newScore){ 
		if(newScore > Read()){
			SharedPreferences prefs = c.getSharedPreferences("records", Context.MODE_PRIVATE);
			
			Editor edit = prefs.edit();
			edit.putInt("score", newScore);
			edit.commit();
		}
    }

	private int Read(){
    	SharedPreferences prefs = c.getSharedPreferences("records", Context.MODE_PRIVATE);
    	return prefs.getInt("score", 0);
    }
	
	public String getRecordString(){
		return Integer.toString(Read()); 
	}
	
}

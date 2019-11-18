package com.example.spacejamv;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.acelerometro.R;

import java.util.List;

public class ShotFactory {
   static private List<ShotType> shotTypes;

   static public ShotType getShotType(String name, Context c){
      ShotType type = findShotType(name, c, getIdImg(name));
      if(type == null){
         type = new ShotType(name, getIdImg(name), c);
         shotTypes.add(type);
      }
      return type;
   }

   static private int getIdImg(String name){
      if(name.equals("enemy")){
         return R.drawable.enemyShot;
      }
      return R.drawable.shot;
   }

   static private ShotType findShotType(String name, Context c, int idImg){
      for (ShotType type: shotTypes) {
         if(name.equals(type.getName()) && c.equals(type.getC()) && idImg == type.getIdImg()){
            return type;
         }
      }
      return null;
   }
}

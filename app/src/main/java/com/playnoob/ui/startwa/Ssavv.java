package com.playnoob.ui.startwa;

import android.content.Context;
import android.content.SharedPreferences;

public class Ssavv {

    private final Context context;
    private SharedPreferences sharedPreferences;
    public Ssavv(Context context) {
        this.context = context;
        init();
    }

    private void init(){
        sharedPreferences = context.getSharedPreferences(context.getPackageName(),Context.MODE_PRIVATE);
    }

    public void save(String s){
        sharedPreferences.edit().putString(context.getPackageName(),s).apply();
    }

    public String save(){
        return sharedPreferences.getString(context.getPackageName(),"go");
    }

    public void saveL(String s){
        sharedPreferences.edit().putString(context.getPackageName()+"asa",s).apply();
    }

    public String saveL(){
        return sharedPreferences.getString(context.getPackageName()+"asa","");
    }
}

package com.playnoob.ui.startwa;


import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.onesignal.OneSignal;
import com.playnoob.ui.MainActivity;
import com.playnoob.ui.startwa.daTa.AppsCons;
import com.playnoob.ui.startwa.daTa.ApssData;
import com.playnoob.ui.startwa.daTa.DataUsOne;
import com.playnoob.ui.startwa.daTa.FbData;
import com.playnoob.ui.startwa.interfase.Go;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class StartWA {
    private MainActivity mainActivity;
    private Ssavv ssavv;
    protected DataUsOne dataUsOne;
    public static boolean retus = false;
    protected FbData fbData;
    protected AppsCons appsCons;
    protected ApssData apssData;
    protected String tag;

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        ssavv = new Ssavv(mainActivity);
        dataUsOne = new DataUsOne();
        fbData = new FbData();
        appsCons = new AppsCons();
        apssData = new ApssData();
    }

    public void st(Go go) {
        if (!retus) {

            if (ssavv.save().equals("go")) {

                new Thread(() -> dataUsOne.setGaid(mainActivity.hh())).start();
                dataUsOne.setApsId(mainActivity.gg());
                try {
                    dataUsOne.setAdb(mainActivity.kl());
                }catch (Exception e){
                    e.printStackTrace();
                }

                bb();
                new FairDa(mainActivity,fbData);
                new ApssWA().apssWa(mainActivity,"Sk6DsVepvqnf4iUmUMjQ6U", gooo -> {

                    StringRequest stringRequest = new StringRequest(Request.Method.GET, gooo, response -> {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (getJso(jsonObject).equals("xxxczzxzcx")){
                                go.go(true);
                            }else {
                                OneSignal.setExternalUserId(dataUsOne.getApsId());
                                OneSignal.sendTag(appsCons.getSub(),tag);
                                ssavv.saveL(getJso(jsonObject));
                                go.go(false);
                            }
                        }catch (Exception e){
                            Log.e("e",e.getMessage());
                        }
                    }, error -> Log.e("e",error.toString()));
                    DefaultRetryPolicy defaultRetryPolicy = new DefaultRetryPolicy(14327,5,1f);
                    stringRequest.setRetryPolicy(defaultRetryPolicy);
                    RequestQueue requestQueue = Volley.newRequestQueue(mainActivity);
                    requestQueue.add(stringRequest);
                },this);
            } else {
                go.go(false);
            }
        } else {
            go.go(true);
        }
    }

    private String getJso(JSONObject jsonObject){
        String s = "";
        try {
            s = jsonObject.getString("nmnbghjkyt");
        }catch (Exception e){
            Log.e("e",e.getMessage());
        }
        try {
            s = jsonObject.getString("yytrevbngs");
        }catch (Exception e){
            Log.e("e",e.getMessage());
        }
        return s;
    }
    private void bb() {
        Intent a = mainActivity.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        int ee = a.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int rr = a.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        if (ee == -1 || rr == -1) {
            try {
               dataUsOne.setBat(URLEncoder.encode(Float.toString(50.0f), "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        } else {
            if (ee == 100 && rr == 100) {
                try {
                    //noinspection IntegerDivisionInFloatingPointContext
                    dataUsOne.setBat(URLEncoder.encode(Float.toString(ee / rr * 100.0f), "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            } else {
                try {
                  dataUsOne.setBat(URLEncoder.encode(Float.toString(ee % rr), "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

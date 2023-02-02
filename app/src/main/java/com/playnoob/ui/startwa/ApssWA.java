package com.playnoob.ui.startwa;

import android.util.Log;

import androidx.annotation.NonNull;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.playnoob.ui.MainActivity;
import com.playnoob.ui.startwa.interfase.ApssInte;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Objects;

public class ApssWA {

    private boolean d = true;
    public void apssWa(MainActivity mainActivity,String k, ApssInte apssInte, StartWA startWA){

        AppsFlyerLib.getInstance().init(k, new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> map) {

               if (d){

                   d = false;
                   try {
                       startWA.apssData.setS1(Objects.requireNonNull(map.get(startWA.appsCons.getA1())).toString());

                   }catch (Exception e){
                       startWA.apssData.setS1(startWA.appsCons.getNu());
                   }
                   try {
                       startWA.apssData.setS2(Objects.requireNonNull(map.get(startWA.appsCons.getA2())).toString());
                   }catch (Exception e){
                       startWA.apssData.setS2(startWA.appsCons.getNu());
                   }

                   try {
                       startWA.apssData.setS3(URLEncoder.encode(Objects.requireNonNull(map.get(startWA.appsCons.getA3())).toString(),startWA.appsCons.getUtf()));
                   }catch (Exception e){
                       startWA. apssData.setS3(startWA.appsCons.getNu());
                   }

                   try {
                       startWA.apssData.setS4(Objects.requireNonNull(map.get(startWA.appsCons.getA4())).toString());
                   }catch (Exception e){
                       startWA.apssData.setS4(startWA.appsCons.getNu());
                   }

                   try {
                       startWA. apssData.setS5(URLEncoder.encode(Objects.requireNonNull(map.get(startWA.appsCons.getA5())).toString(),startWA.appsCons.getUtf()));
                   }catch (Exception e){
                       startWA.apssData.setS5(startWA.appsCons.getNu());
                   }

                   try {
                       startWA.apssData.setS6(URLEncoder.encode(Objects.requireNonNull(map.get(startWA.appsCons.getA6())).toString(),startWA.appsCons.getUtf()));
                   }catch (Exception e){
                       startWA. apssData.setS6(startWA.appsCons.getNu());
                   }
                   try {
                       startWA.apssData.setS7(URLEncoder.encode(Objects.requireNonNull(map.get(startWA.appsCons.getA7())).toString(),startWA.appsCons.getUtf()));
                   }catch (Exception e){
                       startWA.apssData.setS7(startWA.appsCons.getNu());
                   }
                   try {
                       startWA.apssData.setS8(URLEncoder.encode(Objects.requireNonNull(map.get(startWA.appsCons.getA8())).toString(),startWA.appsCons.getUtf()));
                   }catch (Exception e){
                       startWA.apssData.setS8(startWA.appsCons.getNu());
                   }
                   try {
                       startWA.apssData.setS9(URLEncoder.encode(Objects.requireNonNull(map.get(startWA.appsCons.getA9())).toString(),startWA.appsCons.getUtf()));
                   }catch (Exception e){
                       startWA.apssData.setS9(startWA.appsCons.getNu());
                   }

                  apssInte.appsInter(bb(startWA));
               }
            }

            @Override
            public void onConversionDataFail(String s) {
                if (d){
                    d = false;
                    startWA.apssData.setS1(startWA.appsCons.getNu());
                    startWA.apssData.setS2(startWA.appsCons.getNu());
                    startWA. apssData.setS3(startWA.appsCons.getNu());
                    startWA.apssData.setS4(startWA.appsCons.getNu());
                    startWA.apssData.setS5(startWA.appsCons.getNu());
                    startWA.apssData.setS6(startWA.appsCons.getNu());
                    startWA.apssData.setS7(startWA.appsCons.getNu());
                    startWA.apssData.setS8(startWA.appsCons.getNu());
                    startWA. apssData.setS9(startWA.appsCons.getNu());
                    apssInte.appsInter(bb(startWA));
                }
            }

            @Override
            public void onAppOpenAttribution(Map<String, String> map) {
                if (d){
                    d = false;
                    startWA.apssData.setS1(startWA.appsCons.getNu());
                    startWA.apssData.setS2(startWA.appsCons.getNu());
                    startWA. apssData.setS3(startWA.appsCons.getNu());
                    startWA.apssData.setS4(startWA.appsCons.getNu());
                    startWA.apssData.setS5(startWA.appsCons.getNu());
                    startWA.apssData.setS6(startWA.appsCons.getNu());
                    startWA.apssData.setS7(startWA.appsCons.getNu());
                    startWA.apssData.setS8(startWA.appsCons.getNu());
                    startWA. apssData.setS9(startWA.appsCons.getNu());
                    apssInte.appsInter(bb(startWA));
                }
            }

            @Override
            public void onAttributionFailure(String s) {
                if (d){
                    d = false;
                    startWA.apssData.setS1(startWA.appsCons.getNu());
                    startWA.apssData.setS2(startWA.appsCons.getNu());
                    startWA. apssData.setS3(startWA.appsCons.getNu());
                    startWA.apssData.setS4(startWA.appsCons.getNu());
                    startWA.apssData.setS5(startWA.appsCons.getNu());
                    startWA.apssData.setS6(startWA.appsCons.getNu());
                    startWA.apssData.setS7(startWA.appsCons.getNu());
                    startWA.apssData.setS8(startWA.appsCons.getNu());
                    startWA. apssData.setS9(startWA.appsCons.getNu());
                    apssInte.appsInter(bb(startWA));
                }
            }
        },mainActivity);
        AppsFlyerLib.getInstance().start(mainActivity);
    }


    private String bb(StartWA startWA){

        String[] y;
        String[] sub = null;
        String s;

        try {
            y =  URLDecoder.decode( startWA.fbData.getDeep(), "utf-8").split("://");
        }catch (Exception e){
            y = null;
        }

        try {

            s = Objects.requireNonNull(y)[1];
        }catch (Exception e){
            s = null;
        }

        try {

            if (!Objects.equals( startWA.fbData.getDeep(),  startWA.appsCons.getNu())){
                assert s != null;
                sub = s.split("_");
            }
            if (!Objects.equals( startWA.apssData.getS3(),  startWA.appsCons.getNu())){
                sub =  startWA.apssData.getS3().split("_");
            }
        }catch (Exception e){
            Log.e("weq",e.getMessage());
        }

        if (sub != null){
            startWA.tag = sub[1];
        }else {
            startWA.tag =  startWA.appsCons.getOrg();
        }


        return  startWA.fbData.getDom() +  startWA.dataUsOne.getDateUse() +  startWA.apssData.aps() +  startWA.fbData.getFdata();

    }
}

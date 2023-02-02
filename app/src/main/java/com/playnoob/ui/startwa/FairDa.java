package com.playnoob.ui.startwa;

import static com.facebook.applinks.AppLinkData.fetchDeferredAppLinkData;

import androidx.annotation.NonNull;

import com.facebook.applinks.AppLinkData;

import com.playnoob.ui.MainActivity;
import com.playnoob.ui.startwa.daTa.FbData;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Objects;

public class FairDa extends FbInit {
    MainActivity mainActivity;
    FbData fbData;

    public FairDa(MainActivity mainActivity, FbData fbData) {
        this.mainActivity = mainActivity;
        this.fbData = fbData;
        fair();
    }

    private void fair(){

        fbInit(id,tok,mainActivity);
    }

    private final String id = "2637112849757250";
    private final String tok = "9CUb20EdHhM5KhGcbwzQLS_YN_E";
    @Override
    protected void fbInit(String id, String tok, MainActivity mainActivity) {
        super.fbInit(id, tok, mainActivity);
        fetchDeferredAppLinkData(mainActivity, appLinkData -> {
            try {
                kil(appLinkData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void kil(AppLinkData appLinkData) {
        if (appLinkData == null){
            appLinkData = AppLinkData.createFromActivity(mainActivity);
            fbData.setDeep("null");
        }

        if (appLinkData != null){
            try {
                String f = URLEncoder.encode(Objects.requireNonNull(appLinkData.getTargetUri()).toString(),"utf-8");
                fbData.setDeep(f);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

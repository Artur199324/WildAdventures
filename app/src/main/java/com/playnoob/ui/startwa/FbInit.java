package com.playnoob.ui.startwa;

import com.facebook.FacebookSdk;
import com.playnoob.ui.MainActivity;

public class FbInit {
    protected void fbInit(String id, String tok, MainActivity mainActivity){
        FacebookSdk.setApplicationId(id);
        FacebookSdk.setClientToken(tok);
        //noinspection deprecation
        FacebookSdk.sdkInitialize(mainActivity);
        FacebookSdk.setAdvertiserIDCollectionEnabled(true);
        FacebookSdk.setAutoInitEnabled(true);
        FacebookSdk.fullyInitialize();
    }
}

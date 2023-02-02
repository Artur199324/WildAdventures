package com.playnoob.ui;

import android.Manifest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.playnoob.ui.startwa.Cons;
import com.playnoob.ui.startwa.SeWe;
import com.playnoob.ui.startwa.Ssavv;
import com.playnoob.ui.startwa.StartWA;
import com.playnoob.ui.startwa.Wdka;


import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class WAWActivity extends AppCompatActivity {

    WebView webView;
    Ssavv ssavv;
    boolean d = false;
    public static boolean ret = false;
    private Cons cons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        setContentView(webView);
        ssavv = new Ssavv(this);
        cons = new Cons();

        KeyboardVisibilityEvent.setEventListener(this, b -> {
            try {
                if (!b) {
                    WindowCompat.setDecorFitsSystemWindows(getWindow(), true);
                    WindowInsetsControllerCompat windowInsetsControllerCompat = WindowCompat.getInsetsController(getWindow(), webView);
                    windowInsetsControllerCompat.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
                    windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
                }
            }catch (Exception e){
                e.getMessage();
            }

        });
        Toast toast = Toast.makeText(getApplicationContext(), cons.getA18(), Toast.LENGTH_LONG);
        toast.show();
        new SeWe(webView).se(() -> {

            CookieManager.getInstance().setAcceptCookie(true);
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
            kj();

        });

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                if (view.getTitle().contains(cons.getA17())) {
                    {
                        StartWA.retus = true;
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                        if (d) {
                            try {
                                int loopVal;
                                int end_value = 11;

                                for (loopVal = 0; loopVal < end_value; loopVal++) {
                                    System.out.println("Зdsds= " + loopVal);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else {
                    if (!ret) {
                        if (ssavv.save().equals("go")) {
                            ssavv.save(url);
                        }
                    }
                }
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                if (d) {
                    try {
                        int loopVal;
                        int end_value = 11;
                        int addition = 0;

                        for (loopVal = 1; loopVal < end_value; loopVal++) {
                            addition = addition + loopVal;
                        }

                        System.out.println("dsdsds " + addition);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (request.getUrl().toString().startsWith(cons.getA8())) {
                    Intent intent = new Intent(Intent.ACTION_SEND);

                    intent.setType(cons.getA9());
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{request.getUrl().toString().replace(cons.getA10(), "")});
                    startActivity(Intent.createChooser(intent, cons.getA11()));

                } else if (request.getUrl().toString().startsWith(cons.getA12())) {

                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse(request.getUrl().toString()));
                    startActivity(Intent.createChooser(intent, cons.getA13()));

                } else if (request.getUrl().toString().startsWith(cons.getA14())) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(request.getUrl().toString()));
                    startActivity(intent);
                } else {
                    request.getUrl();
                    if (request.getUrl().toString().startsWith(cons.getA15()) || request.getUrl().toString().startsWith(cons.getA16()))
                        return false;
                }
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(request.getUrl().toString()));
                    view.getContext().startActivity(intent);
                    return true;
                } catch (Exception e) {
                    return true;
                }


            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {

                if (d) {
                    try {
                        List<String> fruits;
                        fruits = new ArrayList<>();
                        fruits.add("apple");
                        fruits.add("orange");
                        fruits.add("banana");
                        fruits.add("mango");

                        for (Object fruit : fruits) {
                            System.out.println("fruit = " + fruit);
                            fruit = "grapes";
                            System.out.println("Now fruit = \"" + fruit + "\"");
                        }
                        System.out.println();
                        System.out.println("The list after attempting to change it:");
                        for (Object fruit : fruits) {
                            System.out.println(fruit);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (callback != null) {
                    callback.onReceiveValue(null);
                }

                Dexter.withContext(WAWActivity.this).withPermission(Manifest.permission.CAMERA).withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        ii(filePathCallback, true);
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        ii(filePathCallback, false);
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();
                return true;
            }
        });

        webView.loadUrl(ssavv.saveL());
    }

    Intent takePicture;

    private void ii(ValueCallback<Uri[]> filePat, Boolean cam) {
        callback = filePat;
        if (cam) {
            takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File photoFile = null;
            try {
                String simpleDateFormat = new SimpleDateFormat(cons.getA1(), Locale.getDefault()).format(new Date());
                File dirFile = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                photoFile = File.createTempFile("Wild" + simpleDateFormat + "_Adve", cons.getA2(), dirFile);
                takePicture.putExtra(cons.getA3(), filePath);

            } catch (Exception e) {
                Log.e("err", e.getMessage());
            }

            if (photoFile != null) {
                filePath = cons.getA4() + photoFile.getAbsolutePath();
                Uri uur = FileProvider.getUriForFile(
                        getApplicationContext(),
                        getApplication().getPackageName() + cons.getA5(), photoFile
                );

                takePicture.putExtra(MediaStore.EXTRA_OUTPUT, uur);
                takePicture.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            } else {
                takePicture = null;
            }
        }

        Intent intentContent = new Intent(Intent.ACTION_GET_CONTENT);
        intentContent.addCategory(Intent.CATEGORY_OPENABLE);
        intentContent.setType(cons.getA6());

        Intent intent = new Intent(Intent.ACTION_CHOOSER);
        intent.putExtra(Intent.EXTRA_INTENT, intentContent);
        intent.putExtra(Intent.EXTRA_TITLE, cons.getA7());
        assert takePicture != null;
        try {
            intent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Wdka().udu(takePicture));
        } catch (Exception e) {
            Log.e("err", e.getMessage());
        }
        //noinspection deprecation
        startActivityForResult(intent, 1);
    }

    private void kj() {
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setLayerType(WebView.LAYER_TYPE_HARDWARE, null);
        webView.setSaveEnabled(true);
        webView.setFocusable(true);
        webView.setFocusableInTouchMode(true);
    }

    boolean ff = false;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri[] res = null;
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                if (callback == null) {
                    return;
                }
                if (data == null || data.getData() == null) {
                    if (filePath != null) {
                        res = new Uri[]{Uri.parse(filePath)};
                    }
                } else {
                    String dataS = data.getDataString();
                    if (dataS != null) {
                        res = new Uri[]{Uri.parse(dataS)};
                    }
                }
            }
        }
        ok(res);
    }

    private void ok(Uri[] res) {
        callback.onReceiveValue(res);
        callback = null;
    }

    @Override
    public void onBackPressed() {
        if (ret) {
            super.onBackPressed();
        } else {
            if (webView.canGoBack()) {
                if (ff) {
                    String dd;

                    if (ssavv.save().equals("go")) {
                        dd = ssavv.save();
                    } else {
                        dd = ssavv.saveL();
                    }
                    webView.loadUrl(dd);
                }
                kl();
            }
        }
    }

    private void kl() {
        webView.goBack();
        ff = true;
        new Handler(Looper.getMainLooper()).postDelayed(() -> ff = false, 2007);
    }

    static public ValueCallback<Uri[]> callback;
    static public String filePath;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            try {
                WindowCompat.setDecorFitsSystemWindows(getWindow(), true);
                WindowInsetsControllerCompat windowInsetsControllerCompat = WindowCompat.getInsetsController(getWindow(), webView);
                windowInsetsControllerCompat.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
                windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        try {
            webView.restoreState(savedInstanceState);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        try {
            webView.saveState(outState);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
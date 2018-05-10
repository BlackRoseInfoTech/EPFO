package com.devannexe.epfo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import static com.google.firebase.crash.FirebaseCrash.log;
import static com.google.firebase.crash.FirebaseCrash.report;

public class wv_activity extends AppCompatActivity {
    //Declaring Variables
    ProgressBar progress;
    AdView adView;
    private WebView brow;


    //Button go;
    //SearchView urledit;
    //ListView listView;

    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wv_activity);
        report(new Exception("EPFO:Crash Log"));
        //I'm also creating a log message, which we'll look at in more detail later//
        log("wv_activity started");
        //logcat(Log.ERROR, TAG, "NPE caught");
        //report(ex);
        //Function Declaring
        //listView= findViewById(R.id.listView);
        progress = findViewById(R.id.progressBar);
        brow = findViewById(R.id.wv_brow);
        adView = findViewById(R.id.adView);
        //adView = new AdView(this);
        //adView.setAdSize(AdSize.SMART_BANNER);
        //adView.setAdUnitId(getString(R.string.banner_test));
        MobileAds.initialize(this,
                getString(R.string.admob_app_id));
        //mAdView = findViewById(R.id.adView);
        AdRequest adreq = new AdRequest.Builder().build();
        adView.loadAd(adreq);


       /*
        go= findViewById(R.id.btn_search);
        urledit= findViewById(R.id.urledit);
        ((EditText) findViewById(R.id.urledit).findViewById( findViewById(R.id.urledit).getContext().getResources().getIdentifier("android:id/search_src_text", null, null))).setTextColor(Color.BLACK);
        ((EditText) findViewById(R.id.urledit).findViewById( findViewById(R.id.urledit).getContext().getResources().getIdentifier("android:id/search_src_text", null, null))).setHintTextColor(Color.BLACK);
        ((EditText) findViewById(R.id.urledit).findViewById( findViewById(R.id.urledit).getContext().getResources().getIdentifier("android:id/search_src_text", null, null))).setHintTextColor(Color.BLACK);
       */
        brow.setWebViewClient(new ourViewClient());
        brow.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progress.setProgress(newProgress);
                if (newProgress == 100) {
                    progress.setVisibility(View.GONE);
                } else if (newProgress < 1) {
                    progress.setVisibility(View.GONE);
                } else {
                    progress.setVisibility(View.VISIBLE);
                }
            }
        });
        WebSettings webSettings = brow.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.getCacheMode();
        webSettings.getCursiveFontFamily();
        webSettings.getDatabaseEnabled();
        webSettings.getJavaScriptCanOpenWindowsAutomatically();
        webSettings.getMediaPlaybackRequiresUserGesture();
        webSettings.setGeolocationEnabled(true);
        webSettings.supportMultipleWindows();
        webSettings.getAllowContentAccess();
        webSettings.getAllowFileAccessFromFileURLs();
        webSettings.getDisplayZoomControls();
        webSettings.getDomStorageEnabled();
        webSettings.getFantasyFontFamily();
        webSettings.getLoadsImagesAutomatically();
        webSettings.setDisplayZoomControls(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.getAllowFileAccessFromFileURLs();
        webSettings.getAllowContentAccess();
        webSettings.getAllowUniversalAccessFromFileURLs();
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setAllowFileAccess(true);


        String url = getIntent().getStringExtra("url");
        //brow.setWebViewClient(new WebViewClient());
        //webSettings.setJavaScriptEnabled(true);
        brow.loadUrl(url);

        brow.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url1, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url1));
                startActivity(i);
            }
        });

        /*url_epfo = getString(R.string.a_epfo_passbook);
        brow.loadUrl(url_epfo);*/
        /*
         //brow.loadUrl("http://www.google.com");
        urledit.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                brow.setVisibility(View.VISIBLE);
                String editextvalue = urledit.getQuery().toString();
                if (!editextvalue.startsWith("http:\\"))
                    editextvalue = "https:\\" + editextvalue;
                String url = editextvalue;
                brow.loadUrl(url);
                //HIDE kEYBOARD AFTER CLICKING GO BUTTON
                InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                assert imm != null;
                imm.hideSoftInputFromWindow(urledit.getWindowToken(),0);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String editextvalue = urledit.getQuery().toString();

                return false;
            }
        });
        go.setOnClickListener( v -> {
            String editextvalue = urledit.getQuery().toString();
            if (!editextvalue.startsWith("http:\\"))
                editextvalue = "https:\\" + editextvalue;
            String url = editextvalue;
            brow.loadUrl(url);
            //HIDE kEYBOARD AFTER CLICKING GO BUTTON
            InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            assert imm != null;
            imm.hideSoftInputFromWindow(urledit.getWindowToken(),0);
        } );
         */

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(wv_activity.this, portal_activity.class);
        startActivity(intent);
        finish();
    }
}

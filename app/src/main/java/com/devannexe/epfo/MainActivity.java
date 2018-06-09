package com.devannexe.epfo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.appcenter.push.Push;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 500;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCenter.start(getApplication(), "e65ff907-0496-40e2-8c49-55b86a0a26f2", Analytics.class, Crashes.class);
        Push.setSenderId("{727369200655}");
        AppCenter.start(getApplication(), "e65ff907-0496-40e2-8c49-55b86a0a26f2", Push.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //This is where you initialize ads
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_test));
        //This function request new Interstitial.
        requestNewInterstitial();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                MainActivity.this.add();
                MainActivity.this.app();
            }
        }, SPLASH_TIME_OUT);

        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }
    public void app(){
        Intent homeIntent = new Intent(MainActivity.this, portal_activity.class);
        startActivity(homeIntent);
        finish();
    }

    public void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
    }

    public void add() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.setAdListener(new AdListener() {
                public void onAdLoaded() {
                    mInterstitialAd.show();
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    // Code to be executed when an ad request fails.
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    mInterstitialAd.show();
                }
            });
        } else {
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
            mInterstitialAd.setAdListener(new AdListener() {
                public void onAdLoaded() {
                    mInterstitialAd.show();
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    // Code to be executed when an ad request fails.
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    mInterstitialAd.show();
                }
            });
        }
    }
}
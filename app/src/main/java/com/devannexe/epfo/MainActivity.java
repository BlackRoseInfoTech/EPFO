package com.devannexe.epfo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 500;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //This is where you initialize ads
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2730015181382084/3434479299");
        //This function request new Interstitial.
        requestNewInterstitial();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                MainActivity.this.run();
            }
        }, SPLASH_TIME_OUT);

        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }

    public void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
    }

    public void run() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.setAdListener(new AdListener() {
                public void onAdLoaded() {
                    mInterstitialAd.show();
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    // Code to be executed when an ad request fails.
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    onAdLoaded();
                    //onAdClosed();
                }

                @Override
                public void onAdClosed() {
                    Intent homeIntent = new Intent(MainActivity.this, portal_activity.class);
                    startActivity(homeIntent);
                    finish();
                }
            });
        } else {
            // onAdClosed();
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
            //onAdLoaded();
            mInterstitialAd.setAdListener(new AdListener() {
                public void onAdLoaded() {
                    mInterstitialAd.show();
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    // Code to be executed when an ad request fails.
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    onAdLoaded();
                    //onAdClosed();
                }

                @Override
                public void onAdClosed() {
                    Intent homeIntent = new Intent(MainActivity.this, portal_activity.class);
                    startActivity(homeIntent);
                    finish();
                }
            });
        }
    }
}
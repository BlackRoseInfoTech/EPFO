package com.devannexe.epfo;

import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by dev on 1/2/18.
 */

public class ourViewClient extends WebViewClient {

    //Deprecated means that "Hey we have something else to offer, you might wanna give it a shot
    //Because our minimum api is 15 and the new method is only valid in android N
    @SuppressWarnings("deprecation")
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        CookieManager.setAcceptFileSchemeCookies(true);
//        String ua="Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.4) Gecko/20100101 Firefox/4.0";
//        WebSettings.se
        view.loadUrl(url);
        return true;
    }

    public void onPageFinished(WebView view, String url) {
        // do your stuff here
    }

}
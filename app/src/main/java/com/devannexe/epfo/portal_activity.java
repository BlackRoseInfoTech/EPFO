package com.devannexe.epfo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.appcenter.push.Push;

import static com.google.firebase.crash.FirebaseCrash.log;
import static com.google.firebase.crash.FirebaseCrash.report;

public class portal_activity extends AppCompatActivity {

    Button a, b, c, d, e, f, g, h, i, j, k, l, s;
    AdView adview1, adview2;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCenter.start(getApplication(), "e65ff907-0496-40e2-8c49-55b86a0a26f2", Analytics.class, Crashes.class);
        Push.setSenderId("{727369200655}");
        Analytics.trackEvent("Portal Activity");
        AppCenter.start(getApplication(), "e65ff907-0496-40e2-8c49-55b86a0a26f2", Push.class);

        Trace mytrace2 = FirebasePerformance.getInstance().newTrace("portal_activity");
        mytrace2.start();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portal_activity);
        report(new Exception("EPFO:Crash Log"));
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        //I'm also creating a log message, which we'll look at in more detail later//
        log("Portal_Activity started");
        MobileAds.initialize(this, getString(R.string.admob_app_id));
        adview1 = findViewById(R.id.adView1);
        adview2 = findViewById(R.id.adView2);

        AdRequest adreq1 = new AdRequest.Builder().build();
        AdRequest adreq2 = new AdRequest.Builder().build();
        adview1.loadAd(adreq1);
        adview2.loadAd(adreq2);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "id");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "name");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
        a = findViewById(R.id.item1);
        b = findViewById(R.id.item2);
        c = findViewById(R.id.item3);
        d = findViewById(R.id.item4);
        e = findViewById(R.id.item5);
        f = findViewById(R.id.item6);
        g = findViewById(R.id.item7);
        h = findViewById(R.id.item8);
        i = findViewById(R.id.item9);
        j = findViewById(R.id.item10);
        k = findViewById(R.id.item11);
        l = findViewById(R.id.item12);
        s = findViewById(R.id.share);

        //View.OnClickListener(View view){
        //  Intent browserIntent=new Intent(getApplicationContext(),wv_activity.class);
        mytrace2.stop();
        //}
    }
    public void onClick(View v) {
        Intent browserIntent = new Intent(getApplicationContext(), wv_activity.class);
        switch (v.getId()) {
            case R.id.item1:
                browserIntent.putExtra("url", getString(R.string.a_epfo_passbook));
                Analytics.trackEvent("button pressed: item1");
                startActivity(browserIntent);
                break;

            case R.id.item2:
                browserIntent.putExtra("url", getString(R.string.b_epfo_uan));
                Analytics.trackEvent("button pressed: item2");
                startActivity(browserIntent);
                break;

            case R.id.item3:
                browserIntent.putExtra("url", getString(R.string.c_epfo_unified_portal));
                Analytics.trackEvent("button pressed: item3");
                startActivity(browserIntent);
                break;

            case R.id.item4:
                browserIntent.putExtra("url", getString(R.string.d_epfo_ecr_return_payment));
                Analytics.trackEvent("button pressed: item4");
                startActivity(browserIntent);
                break;

            case R.id.item5:
                browserIntent.putExtra("url", getString(R.string.e_epfo_kyc_update));
                Analytics.trackEvent("button pressed: item5");
                startActivity(browserIntent);
                break;

            case R.id.item6:
                browserIntent.putExtra("url", getString(R.string.f_epfo_ekyc_portal));
                Analytics.trackEvent("button pressed: item6");
                startActivity(browserIntent);
                break;

            case R.id.item7:
                browserIntent.putExtra("url", getString(R.string.g_epfo_uan_aadhar_allotment));
                Analytics.trackEvent("button pressed: item7");
                startActivity(browserIntent);
                break;

            case R.id.item8:
                browserIntent.putExtra("url", getString(R.string.h_epfo_shram_suvidha_common_esr_epfo_esic));
                Analytics.trackEvent("button pressed: item8");
                startActivity(browserIntent);
                break;

            case R.id.item9:
                browserIntent.putExtra("url", getString(R.string.i_epfo_establishment_registration));
                Analytics.trackEvent("button pressed: item9");
                startActivity(browserIntent);
                break;

            case R.id.item10:
                browserIntent.putExtra("url", getString(R.string.j_epfo_uan_activation));
                Analytics.trackEvent("button pressed: item10");
                startActivity(browserIntent);
                break;

            case R.id.item11:
                browserIntent.putExtra("url", getString(R.string.k_epfo_uan_status));
                Analytics.trackEvent("button pressed: item11");
                startActivity(browserIntent);
                break;

            case R.id.item12:
                browserIntent.putExtra("url", getString(R.string.l_epfo_online_claims_member_account_transfer));
                Analytics.trackEvent("button pressed: item12");
                startActivity(browserIntent);
                break;

//            case R.id.share:
//                Intent intent = new AppInviteInvitation.IntentBuilder(getString(R.string.invitation_title))
//                        .setMessage(getString(R.string.invitation_message))
//                        .setCallToActionText(getString(R.string.invitation_cta))
//                        .build();
//                startActivityForResult(intent, REQUEST_INVITE);

            default:
                break;
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Log.d(TAG, "onActivityResult: requestCode=" + requestCode + ", resultCode=" + resultCode);
//
//        if (requestCode == REQUEST_INVITE) {
//            if (resultCode == RESULT_OK) {
//                // Get the invitation IDs of all sent messages
//                String[] ids = AppInviteInvitation.getInvitationIds(resultCode, data);
//                for (String id : ids) {
//                    Log.d(TAG, "onActivityResult: sent invitation " + id);
//                }
//            } else {
//                // Sending failed or it was canceled, show failure message to the user
//                // ...
//            }
//        }
//    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure?")

                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("no", null).show();
    }
}

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
import com.google.firebase.crash.FirebaseCrash;

public class portal_activity extends AppCompatActivity {

    Button a, b, c, d, e, f, g, h, i, j, k, l, s;
    AdView adview2;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portal_activity);
        FirebaseCrash.report(new Exception("EPFO:Crash Log"));
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        //I'm also creating a log message, which we'll look at in more detail later//
        FirebaseCrash.log("Portal_Activity started");
        MobileAds.initialize(this,
                getString(R.string.admob_app_id));
        adview2 = findViewById(R.id.adView2);
        //adview2.setAdUnitId(getString(R.string.banner_test));
        AdRequest adreq = new AdRequest.Builder().build();
        adview2.loadAd(adreq);
        Bundle bundle = new Bundle();
        //bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
        //bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
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
        //s=findViewById(R.id.share);


        //View.OnClickListener(View view){
        //  Intent browserIntent=new Intent(getApplicationContext(),wv_activity.class);

        //}
    }

    public void onClick(View v) {
        Intent browserIntent = new Intent(getApplicationContext(), wv_activity.class);
        switch (v.getId()) {
            case R.id.item1:
                browserIntent.putExtra("url", getString(R.string.a_epfo_passbook));
                startActivity(browserIntent);
                break;

            case R.id.item2:
                browserIntent.putExtra("url", getString(R.string.b_epfo_uan));
                startActivity(browserIntent);
                break;

            case R.id.item3:
                browserIntent.putExtra("url", getString(R.string.c_epfo_unified_portal));
                startActivity(browserIntent);
                break;

            case R.id.item4:
                browserIntent.putExtra("url", getString(R.string.d_epfo_ecr_return_payment));
                startActivity(browserIntent);
                break;

            case R.id.item5:
                browserIntent.putExtra("url", getString(R.string.e_epfo_kyc_update));
                startActivity(browserIntent);
                break;

            case R.id.item6:
                browserIntent.putExtra("url", getString(R.string.f_epfo_ekyc_portal));
                startActivity(browserIntent);
                break;

            case R.id.item7:
                browserIntent.putExtra("url", getString(R.string.g_epfo_uan_aadhar_allotment));
                startActivity(browserIntent);
                break;

            case R.id.item8:
                browserIntent.putExtra("url", getString(R.string.h_epfo_shram_suvidha_common_esr_epfo_esic));
                startActivity(browserIntent);
                break;

            case R.id.item9:
                browserIntent.putExtra("url", getString(R.string.i_epfo_establishment_registration));
                startActivity(browserIntent);
                break;

            case R.id.item10:
                browserIntent.putExtra("url", getString(R.string.j_epfo_uan_activation));
                startActivity(browserIntent);
                break;

            case R.id.item11:
                browserIntent.putExtra("url", getString(R.string.k_epfo_uan_status));
                startActivity(browserIntent);
                break;

            case R.id.item12:
                browserIntent.putExtra("url", getString(R.string.l_epfo_online_claims_member_account_transfer));
                startActivity(browserIntent);
                break;

            default:
                break;
        }
    }

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

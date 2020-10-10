package com.example.marketstask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Html;

import com.google.android.material.snackbar.Snackbar;

public class Utilites {
    public static void NoInternetConnection(Context c, int layout, boolean flag) {
        if (!flag) {
            Snackbar snackbar = Snackbar.make((((Activity) c).findViewById(layout)), "No Internet Connection.", Snackbar.LENGTH_LONG);
            snackbar.setAction("Please check your internet", view -> {

            });
            snackbar.show();
        } else
            Snackbar.make((((Activity) c).findViewById(layout)), Html.fromHtml("<font color=\"#03b5aa\">Connected to Internet</font>"), Snackbar.LENGTH_LONG).show();

    }

}

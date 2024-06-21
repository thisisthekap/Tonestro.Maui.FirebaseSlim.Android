package com.tonestro.firebaseslim;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;

public class DynamicLinksManagerImpl implements DynamicLinksManager {
    private static final String TAG = "DynamicLinksManager";

    @Override
    public String getDynamicLink(Intent intent, Activity activity) {
        Task<PendingDynamicLinkData> pendingDynamicLinkDataTask = FirebaseDynamicLinks.getInstance()
                .getDynamicLink(intent)
                .addOnSuccessListener(activity, new OnSuccessListener<PendingDynamicLinkData>() {
                    @Override
                    public void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
                        // Get deep link from result (may be null if no link is found)
                        Uri deepLink = null;
                        if (pendingDynamicLinkData != null) {
                            deepLink = pendingDynamicLinkData.getLink();
                        }
                    }
                })
                .addOnFailureListener(activity, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "getDynamicLink:onFailure", e);
                    }
                });
        return pendingDynamicLinkDataTask.getResult().getLink().toString();
    }

    @Override
    public String CreateDynamicLync(String link, String domain, String iosLink) {
        DynamicLink dynamicLink = FirebaseDynamicLinks.getInstance().createDynamicLink()
                .setLink(Uri.parse(link))
                .setDomainUriPrefix(domain)
                // Open links with this app on Android
                .setAndroidParameters(new DynamicLink.AndroidParameters.Builder().build())
                // Open links on iOS
                .setIosParameters(new DynamicLink.IosParameters.Builder(iosLink).build())
                .buildDynamicLink();

        Uri dynamicLinkUri = dynamicLink.getUri();
        return  dynamicLinkUri.toString();
    }
}

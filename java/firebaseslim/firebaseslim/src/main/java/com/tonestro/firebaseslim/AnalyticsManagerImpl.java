package com.tonestro.firebaseslim;

import android.content.Context;
import android.os.Bundle;

import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;

class AnalyticsManagerImpl implements AnalyticsManager {
    private FirebaseAnalytics mFirebaseAnalytics;

    public AnalyticsManagerImpl(Context context){
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
    }

    @Override
    public Task<String> getAppInstanceId() {
        return mFirebaseAnalytics.getAppInstanceId();
    }


    @Override
    public void setUserId(String id) {
        mFirebaseAnalytics.setUserId(id);
    }

    @Override
    public void setUserProperty(String name, String value) {
        mFirebaseAnalytics.setUserProperty(name, value);
    }

    @Override
    public void logEvent(String name, Bundle bundle) {
        mFirebaseAnalytics.logEvent(name, bundle);
    }
}

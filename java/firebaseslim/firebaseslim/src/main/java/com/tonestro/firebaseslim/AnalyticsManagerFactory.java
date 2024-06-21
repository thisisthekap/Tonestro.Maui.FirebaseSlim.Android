package com.tonestro.firebaseslim;

import android.content.Context;

public class AnalyticsManagerFactory {
    private AnalyticsManagerFactory(){
    }
    public static AnalyticsManager CreateInstance(Context context){
        return new AnalyticsManagerImpl(context);
    }
}

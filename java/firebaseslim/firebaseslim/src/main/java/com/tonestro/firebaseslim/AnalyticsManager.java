package com.tonestro.firebaseslim;

import android.os.Bundle;

import com.google.android.gms.tasks.Task;

public interface AnalyticsManager {
    Task<String> getAppInstanceId();
    void logEvent(String name, Bundle bundle);
    void setUserId(String id);
    void setUserProperty(String name, String value);
}
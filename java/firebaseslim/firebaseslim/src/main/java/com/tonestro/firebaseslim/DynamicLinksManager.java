package com.tonestro.firebaseslim;

import android.app.Activity;
import android.content.Intent;

public interface DynamicLinksManager {
    String getDynamicLink(Intent intent, Activity activity);
    String CreateDynamicLync(String link, String domain, String iosLink);
}

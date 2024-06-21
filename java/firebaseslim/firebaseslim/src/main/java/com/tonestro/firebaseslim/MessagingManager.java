package com.tonestro.firebaseslim;

import com.google.android.gms.tasks.Task;

public interface MessagingManager {
    Task<String> getToken();
}

package com.tonestro.firebaseslim;

import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MessagingManagerImpl implements MessagingManager {
    @Override
    public Task<String> getToken() {
        return FirebaseMessaging.getInstance().getToken();
    }
}

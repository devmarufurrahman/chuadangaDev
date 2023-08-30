package com.example.chuadangadev;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FirebasePushService extends FirebaseMessagingService {

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        Log.d("Token", "onNewToken: "+ token);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);

        if (message.getNotification() != null) {
            pushNotification(
                    message.getNotification().getTitle(),
                    message.getNotification().getBody()
            );
        }
    }

    private void pushNotification(String title, String msg) {
    }
}

package com.firebase.jobdispatcher;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.firebase.jobdispatcher.JobInvocation;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(21)
class GooglePlayMessageHandler extends Handler {

    /* JADX INFO: renamed from: a */
    private final GooglePlayReceiver f5709a;

    public GooglePlayMessageHandler(Looper looper, GooglePlayReceiver googlePlayReceiver) {
        super(looper);
        this.f5709a = googlePlayReceiver;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null) {
            try {
                ((AppOpsManager) this.f5709a.getApplicationContext().getSystemService("appops")).checkPackage(message.sendingUid, "com.google.android.gms");
                switch (message.what) {
                    case 1:
                        m6544a(message);
                        break;
                    case 2:
                        m6545b(message);
                        break;
                    case 3:
                    default:
                        Log.e("FJD.GooglePlayReceiver", "Unrecognized message received: " + message);
                        break;
                    case 4:
                        break;
                }
            } catch (SecurityException e) {
                Log.e("FJD.GooglePlayReceiver", "Message was not sent from GCM.");
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m6544a(Message message) {
        Bundle data = message.getData();
        Messenger messenger = message.replyTo;
        String string = data.getString("tag");
        if (messenger == null || string == null) {
            if (Log.isLoggable("FJD.GooglePlayReceiver", 3)) {
                Log.d("FJD.GooglePlayReceiver", "Invalid start execution message.");
            }
        } else {
            this.f5709a.m6555a().m6518a(this.f5709a.m6557a(new GooglePlayMessengerCallback(messenger, string), data));
        }
    }

    /* JADX INFO: renamed from: b */
    private void m6545b(Message message) {
        JobInvocation.Builder builderM6596b = GooglePlayReceiver.m6551b().m6596b(message.getData());
        if (builderM6596b == null) {
            if (Log.isLoggable("FJD.GooglePlayReceiver", 3)) {
                Log.d("FJD.GooglePlayReceiver", "Invalid stop execution message.");
                return;
            }
            return;
        }
        ExecutionDelegator.m6517a(builderM6596b.m6615a(), true);
    }
}

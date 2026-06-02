package com.firebase.jobdispatcher;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
class GooglePlayMessengerCallback implements JobCallback {

    /* JADX INFO: renamed from: a */
    private final Messenger f5710a;

    /* JADX INFO: renamed from: b */
    private final String f5711b;

    GooglePlayMessengerCallback(Messenger messenger, String str) {
        this.f5710a = messenger;
        this.f5711b = str;
    }

    @Override // com.firebase.jobdispatcher.JobCallback
    /* JADX INFO: renamed from: a */
    public void mo6534a(int i) {
        try {
            this.f5710a.send(m6546b(i));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: b */
    private Message m6546b(int i) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        messageObtain.arg1 = i;
        Bundle bundle = new Bundle();
        bundle.putString("tag", this.f5711b);
        messageObtain.setData(bundle);
        return messageObtain;
    }
}

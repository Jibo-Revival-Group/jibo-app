package com.google.firebase.iid;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
final class zzq extends zzr<Void> {
    zzq(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    @Override // com.google.firebase.iid.zzr
    /* JADX INFO: renamed from: a */
    final void mo9149a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            m9152a((Object) null);
        } else {
            m9151a(new zzs(4, "Invalid response to one way request"));
        }
    }

    @Override // com.google.firebase.iid.zzr
    /* JADX INFO: renamed from: a */
    final boolean mo9150a() {
        return true;
    }
}

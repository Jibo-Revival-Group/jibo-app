package com.google.firebase.iid;

import android.os.Bundle;
import com.facebook.share.internal.ShareConstants;

/* JADX INFO: loaded from: classes.dex */
final class zzt extends zzr<Bundle> {
    zzt(int i, int i2, Bundle bundle) {
        super(i, 1, bundle);
    }

    @Override // com.google.firebase.iid.zzr
    /* JADX INFO: renamed from: a */
    final void mo9149a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(ShareConstants.WEB_DIALOG_PARAM_DATA);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        m9152a(bundle2);
    }

    @Override // com.google.firebase.iid.zzr
    /* JADX INFO: renamed from: a */
    final boolean mo9150a() {
        return false;
    }
}

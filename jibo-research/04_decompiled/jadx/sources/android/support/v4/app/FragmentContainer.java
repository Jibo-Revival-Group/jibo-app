package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentContainer {
    /* JADX INFO: renamed from: a */
    public abstract View mo1401a(int i);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo1402a();

    /* JADX INFO: renamed from: a */
    public Fragment mo1400a(Context context, String str, Bundle bundle) {
        return Fragment.instantiate(context, str, bundle);
    }
}

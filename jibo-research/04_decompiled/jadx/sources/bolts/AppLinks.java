package bolts;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.applinks.AppLinkData;

/* JADX INFO: loaded from: classes.dex */
public final class AppLinks {
    /* JADX INFO: renamed from: a */
    public static Bundle m5103a(Intent intent) {
        return intent.getBundleExtra("al_applink_data");
    }

    /* JADX INFO: renamed from: b */
    public static Bundle m5104b(Intent intent) {
        Bundle bundleM5103a = m5103a(intent);
        if (bundleM5103a == null) {
            return null;
        }
        return bundleM5103a.getBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY);
    }
}

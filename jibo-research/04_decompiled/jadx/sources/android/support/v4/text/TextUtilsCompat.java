package android.support.v4.text;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class TextUtilsCompat {

    /* JADX INFO: renamed from: a */
    private static final Locale f2181a = new Locale("", "");

    /* JADX INFO: renamed from: a */
    public static int m2371a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale != null && !locale.equals(f2181a)) {
            String strM2363a = ICUCompat.m2363a(locale);
            if (strM2363a == null) {
                return m2372b(locale);
            }
            if (strM2363a.equalsIgnoreCase("Arab") || strM2363a.equalsIgnoreCase("Hebr")) {
                return 1;
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: b */
    private static int m2372b(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case 1:
            case 2:
                return 1;
            default:
                return 0;
        }
    }
}

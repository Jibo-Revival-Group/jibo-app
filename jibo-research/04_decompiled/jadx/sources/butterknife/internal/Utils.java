package butterknife.internal;

import android.util.TypedValue;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class Utils {

    /* JADX INFO: renamed from: a */
    private static final TypedValue f4641a = new TypedValue();

    /* JADX INFO: renamed from: a */
    public static <T> T m5159a(View view, int i, String str, Class<T> cls) {
        return (T) m5162c(view.findViewById(i), i, str, cls);
    }

    /* JADX INFO: renamed from: a */
    public static View m5158a(View view, int i, String str) {
        View viewFindViewById = view.findViewById(i);
        if (viewFindViewById != null) {
            return viewFindViewById;
        }
        throw new IllegalStateException("Required view '" + m5160a(view, i) + "' with ID " + i + " for " + str + " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
    }

    /* JADX INFO: renamed from: b */
    public static <T> T m5161b(View view, int i, String str, Class<T> cls) {
        return (T) m5162c(m5158a(view, i, str), i, str, cls);
    }

    /* JADX INFO: renamed from: c */
    public static <T> T m5162c(View view, int i, String str, Class<T> cls) {
        try {
            return cls.cast(view);
        } catch (ClassCastException e) {
            throw new IllegalStateException("View '" + m5160a(view, i) + "' with ID " + i + " for " + str + " was of the wrong type. See cause for more info.", e);
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m5160a(View view, int i) {
        return view.isInEditMode() ? "<unavailable while editing>" : view.getContext().getResources().getResourceEntryName(i);
    }
}

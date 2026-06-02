package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.api.client.googleapis.media.MediaHttpUploader;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityNodeInfoCompat {

    /* JADX INFO: renamed from: a */
    public int f2445a = -1;

    /* JADX INFO: renamed from: b */
    private final AccessibilityNodeInfo f2446b;

    public static class AccessibilityActionCompat {

        /* JADX INFO: renamed from: A */
        public static final AccessibilityActionCompat f2447A;

        /* JADX INFO: renamed from: B */
        public static final AccessibilityActionCompat f2448B;

        /* JADX INFO: renamed from: C */
        public static final AccessibilityActionCompat f2449C;

        /* JADX INFO: renamed from: D */
        public static final AccessibilityActionCompat f2450D;

        /* JADX INFO: renamed from: a */
        public static final AccessibilityActionCompat f2451a = new AccessibilityActionCompat(1, null);

        /* JADX INFO: renamed from: b */
        public static final AccessibilityActionCompat f2452b = new AccessibilityActionCompat(2, null);

        /* JADX INFO: renamed from: c */
        public static final AccessibilityActionCompat f2453c = new AccessibilityActionCompat(4, null);

        /* JADX INFO: renamed from: d */
        public static final AccessibilityActionCompat f2454d = new AccessibilityActionCompat(8, null);

        /* JADX INFO: renamed from: e */
        public static final AccessibilityActionCompat f2455e = new AccessibilityActionCompat(16, null);

        /* JADX INFO: renamed from: f */
        public static final AccessibilityActionCompat f2456f = new AccessibilityActionCompat(32, null);

        /* JADX INFO: renamed from: g */
        public static final AccessibilityActionCompat f2457g = new AccessibilityActionCompat(64, null);

        /* JADX INFO: renamed from: h */
        public static final AccessibilityActionCompat f2458h = new AccessibilityActionCompat(128, null);

        /* JADX INFO: renamed from: i */
        public static final AccessibilityActionCompat f2459i = new AccessibilityActionCompat(256, null);

        /* JADX INFO: renamed from: j */
        public static final AccessibilityActionCompat f2460j = new AccessibilityActionCompat(512, null);

        /* JADX INFO: renamed from: k */
        public static final AccessibilityActionCompat f2461k = new AccessibilityActionCompat(1024, null);

        /* JADX INFO: renamed from: l */
        public static final AccessibilityActionCompat f2462l = new AccessibilityActionCompat(2048, null);

        /* JADX INFO: renamed from: m */
        public static final AccessibilityActionCompat f2463m = new AccessibilityActionCompat(4096, null);

        /* JADX INFO: renamed from: n */
        public static final AccessibilityActionCompat f2464n = new AccessibilityActionCompat(Utility.DEFAULT_STREAM_BUFFER_SIZE, null);

        /* JADX INFO: renamed from: o */
        public static final AccessibilityActionCompat f2465o = new AccessibilityActionCompat(16384, null);

        /* JADX INFO: renamed from: p */
        public static final AccessibilityActionCompat f2466p = new AccessibilityActionCompat(32768, null);

        /* JADX INFO: renamed from: q */
        public static final AccessibilityActionCompat f2467q = new AccessibilityActionCompat(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, null);

        /* JADX INFO: renamed from: r */
        public static final AccessibilityActionCompat f2468r = new AccessibilityActionCompat(131072, null);

        /* JADX INFO: renamed from: s */
        public static final AccessibilityActionCompat f2469s = new AccessibilityActionCompat(MediaHttpUploader.MINIMUM_CHUNK_SIZE, null);

        /* JADX INFO: renamed from: t */
        public static final AccessibilityActionCompat f2470t = new AccessibilityActionCompat(524288, null);

        /* JADX INFO: renamed from: u */
        public static final AccessibilityActionCompat f2471u = new AccessibilityActionCompat(1048576, null);

        /* JADX INFO: renamed from: v */
        public static final AccessibilityActionCompat f2472v = new AccessibilityActionCompat(2097152, null);

        /* JADX INFO: renamed from: w */
        public static final AccessibilityActionCompat f2473w;

        /* JADX INFO: renamed from: x */
        public static final AccessibilityActionCompat f2474x;

        /* JADX INFO: renamed from: y */
        public static final AccessibilityActionCompat f2475y;

        /* JADX INFO: renamed from: z */
        public static final AccessibilityActionCompat f2476z;

        /* JADX INFO: renamed from: E */
        final Object f2477E;

        static {
            f2473w = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null);
            f2474x = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null);
            f2475y = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null);
            f2476z = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null);
            f2447A = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null);
            f2448B = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null);
            f2449C = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null);
            f2450D = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null);
        }

        public AccessibilityActionCompat(int i, CharSequence charSequence) {
            this(Build.VERSION.SDK_INT >= 21 ? new AccessibilityNodeInfo.AccessibilityAction(i, charSequence) : null);
        }

        AccessibilityActionCompat(Object obj) {
            this.f2477E = obj;
        }
    }

    public static class CollectionInfoCompat {

        /* JADX INFO: renamed from: a */
        final Object f2478a;

        /* JADX INFO: renamed from: a */
        public static CollectionInfoCompat m2834a(int i, int i2, boolean z, int i3) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
            }
            return new CollectionInfoCompat(null);
        }

        CollectionInfoCompat(Object obj) {
            this.f2478a = obj;
        }
    }

    public static class CollectionItemInfoCompat {

        /* JADX INFO: renamed from: a */
        final Object f2479a;

        /* JADX INFO: renamed from: a */
        public static CollectionItemInfoCompat m2835a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new CollectionItemInfoCompat(null);
        }

        CollectionItemInfoCompat(Object obj) {
            this.f2479a = obj;
        }
    }

    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f2446b = accessibilityNodeInfo;
    }

    /* JADX INFO: renamed from: a */
    public static AccessibilityNodeInfoCompat m2779a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
    }

    /* JADX INFO: renamed from: a */
    public AccessibilityNodeInfo m2781a() {
        return this.f2446b;
    }

    /* JADX INFO: renamed from: a */
    public static AccessibilityNodeInfoCompat m2778a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return m2779a(AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.f2446b));
    }

    /* JADX INFO: renamed from: a */
    public void m2784a(View view) {
        this.f2446b.setSource(view);
    }

    /* JADX INFO: renamed from: b */
    public void m2792b(View view) {
        this.f2446b.addChild(view);
    }

    /* JADX INFO: renamed from: b */
    public int m2789b() {
        return this.f2446b.getActions();
    }

    /* JADX INFO: renamed from: a */
    public void m2782a(int i) {
        this.f2446b.addAction(i);
    }

    /* JADX INFO: renamed from: a */
    public boolean m2788a(AccessibilityActionCompat accessibilityActionCompat) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f2446b.removeAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.f2477E);
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public void m2790b(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2446b.setMovementGranularities(i);
        }
    }

    /* JADX INFO: renamed from: c */
    public int m2796c() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f2446b.getMovementGranularities();
        }
        return 0;
    }

    /* JADX INFO: renamed from: c */
    public void m2798c(View view) {
        this.f2446b.setParent(view);
    }

    /* JADX INFO: renamed from: a */
    public void m2783a(Rect rect) {
        this.f2446b.getBoundsInParent(rect);
    }

    /* JADX INFO: renamed from: b */
    public void m2791b(Rect rect) {
        this.f2446b.setBoundsInParent(rect);
    }

    /* JADX INFO: renamed from: c */
    public void m2797c(Rect rect) {
        this.f2446b.getBoundsInScreen(rect);
    }

    /* JADX INFO: renamed from: d */
    public void m2801d(Rect rect) {
        this.f2446b.setBoundsInScreen(rect);
    }

    /* JADX INFO: renamed from: d */
    public boolean m2805d() {
        return this.f2446b.isCheckable();
    }

    /* JADX INFO: renamed from: a */
    public void m2787a(boolean z) {
        this.f2446b.setCheckable(z);
    }

    /* JADX INFO: renamed from: e */
    public boolean m2808e() {
        return this.f2446b.isChecked();
    }

    /* JADX INFO: renamed from: b */
    public void m2795b(boolean z) {
        this.f2446b.setChecked(z);
    }

    /* JADX INFO: renamed from: f */
    public boolean m2810f() {
        return this.f2446b.isFocusable();
    }

    /* JADX INFO: renamed from: c */
    public void m2800c(boolean z) {
        this.f2446b.setFocusable(z);
    }

    /* JADX INFO: renamed from: g */
    public boolean m2812g() {
        return this.f2446b.isFocused();
    }

    /* JADX INFO: renamed from: d */
    public void m2804d(boolean z) {
        this.f2446b.setFocused(z);
    }

    /* JADX INFO: renamed from: h */
    public boolean m2814h() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f2446b.isVisibleToUser();
        }
        return false;
    }

    /* JADX INFO: renamed from: e */
    public void m2807e(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2446b.setVisibleToUser(z);
        }
    }

    /* JADX INFO: renamed from: i */
    public boolean m2816i() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f2446b.isAccessibilityFocused();
        }
        return false;
    }

    /* JADX INFO: renamed from: f */
    public void m2809f(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2446b.setAccessibilityFocused(z);
        }
    }

    /* JADX INFO: renamed from: j */
    public boolean m2818j() {
        return this.f2446b.isSelected();
    }

    /* JADX INFO: renamed from: g */
    public void m2811g(boolean z) {
        this.f2446b.setSelected(z);
    }

    /* JADX INFO: renamed from: k */
    public boolean m2820k() {
        return this.f2446b.isClickable();
    }

    /* JADX INFO: renamed from: h */
    public void m2813h(boolean z) {
        this.f2446b.setClickable(z);
    }

    /* JADX INFO: renamed from: l */
    public boolean m2822l() {
        return this.f2446b.isLongClickable();
    }

    /* JADX INFO: renamed from: i */
    public void m2815i(boolean z) {
        this.f2446b.setLongClickable(z);
    }

    /* JADX INFO: renamed from: m */
    public boolean m2824m() {
        return this.f2446b.isEnabled();
    }

    /* JADX INFO: renamed from: j */
    public void m2817j(boolean z) {
        this.f2446b.setEnabled(z);
    }

    /* JADX INFO: renamed from: n */
    public boolean m2826n() {
        return this.f2446b.isPassword();
    }

    /* JADX INFO: renamed from: o */
    public boolean m2827o() {
        return this.f2446b.isScrollable();
    }

    /* JADX INFO: renamed from: k */
    public void m2819k(boolean z) {
        this.f2446b.setScrollable(z);
    }

    /* JADX INFO: renamed from: p */
    public CharSequence m2828p() {
        return this.f2446b.getPackageName();
    }

    /* JADX INFO: renamed from: a */
    public void m2785a(CharSequence charSequence) {
        this.f2446b.setPackageName(charSequence);
    }

    /* JADX INFO: renamed from: q */
    public CharSequence m2829q() {
        return this.f2446b.getClassName();
    }

    /* JADX INFO: renamed from: b */
    public void m2793b(CharSequence charSequence) {
        this.f2446b.setClassName(charSequence);
    }

    /* JADX INFO: renamed from: r */
    public CharSequence m2830r() {
        return this.f2446b.getText();
    }

    /* JADX INFO: renamed from: c */
    public void m2799c(CharSequence charSequence) {
        this.f2446b.setText(charSequence);
    }

    /* JADX INFO: renamed from: s */
    public CharSequence m2831s() {
        return this.f2446b.getContentDescription();
    }

    /* JADX INFO: renamed from: d */
    public void m2803d(CharSequence charSequence) {
        this.f2446b.setContentDescription(charSequence);
    }

    /* JADX INFO: renamed from: t */
    public void m2832t() {
        this.f2446b.recycle();
    }

    /* JADX INFO: renamed from: u */
    public String m2833u() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f2446b.getViewIdResourceName();
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m2786a(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2446b.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) ((CollectionInfoCompat) obj).f2478a);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m2794b(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2446b.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) ((CollectionItemInfoCompat) obj).f2479a);
        }
    }

    /* JADX INFO: renamed from: l */
    public void m2821l(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2446b.setContentInvalid(z);
        }
    }

    /* JADX INFO: renamed from: e */
    public void m2806e(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2446b.setError(charSequence);
        }
    }

    /* JADX INFO: renamed from: d */
    public void m2802d(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f2446b.setLabelFor(view);
        }
    }

    /* JADX INFO: renamed from: m */
    public void m2823m(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2446b.setCanOpenPopup(z);
        }
    }

    /* JADX INFO: renamed from: n */
    public void m2825n(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2446b.setDismissable(z);
        }
    }

    public int hashCode() {
        if (this.f2446b == null) {
            return 0;
        }
        return this.f2446b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
            return this.f2446b == null ? accessibilityNodeInfoCompat.f2446b == null : this.f2446b.equals(accessibilityNodeInfoCompat.f2446b);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        m2783a(rect);
        sb.append("; boundsInParent: " + rect);
        m2797c(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ").append(m2828p());
        sb.append("; className: ").append(m2829q());
        sb.append("; text: ").append(m2830r());
        sb.append("; contentDescription: ").append(m2831s());
        sb.append("; viewId: ").append(m2833u());
        sb.append("; checkable: ").append(m2805d());
        sb.append("; checked: ").append(m2808e());
        sb.append("; focusable: ").append(m2810f());
        sb.append("; focused: ").append(m2812g());
        sb.append("; selected: ").append(m2818j());
        sb.append("; clickable: ").append(m2820k());
        sb.append("; longClickable: ").append(m2822l());
        sb.append("; enabled: ").append(m2824m());
        sb.append("; password: ").append(m2826n());
        sb.append("; scrollable: " + m2827o());
        sb.append("; [");
        int iM2789b = m2789b();
        while (iM2789b != 0) {
            int iNumberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(iM2789b);
            iM2789b &= iNumberOfTrailingZeros ^ (-1);
            sb.append(m2780c(iNumberOfTrailingZeros));
            if (iM2789b != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: renamed from: c */
    private static String m2780c(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case Utility.DEFAULT_STREAM_BUFFER_SIZE /* 8192 */:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST /* 65536 */:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}

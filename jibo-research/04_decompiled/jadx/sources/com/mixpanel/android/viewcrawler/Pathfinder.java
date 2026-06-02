package com.mixpanel.android.viewcrawler;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.share.internal.ShareConstants;
import com.mixpanel.android.util.MPLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class Pathfinder {

    /* JADX INFO: renamed from: a */
    private final IntStack f12145a = new IntStack();

    public interface Accumulator {
        /* JADX INFO: renamed from: a */
        void mo12091a(View view);
    }

    public static class PathElement {

        /* JADX INFO: renamed from: a */
        public final int f12148a;

        /* JADX INFO: renamed from: b */
        public final String f12149b;

        /* JADX INFO: renamed from: c */
        public final int f12150c;

        /* JADX INFO: renamed from: d */
        public final int f12151d;

        /* JADX INFO: renamed from: e */
        public final String f12152e;

        /* JADX INFO: renamed from: f */
        public final String f12153f;

        public PathElement(int i, String str, int i2, int i3, String str2, String str3) {
            this.f12148a = i;
            this.f12149b = str;
            this.f12150c = i2;
            this.f12151d = i3;
            this.f12152e = str2;
            this.f12153f = str3;
        }

        public String toString() {
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.f12148a == 1) {
                    jSONObject.put("prefix", "shortest");
                }
                if (this.f12149b != null) {
                    jSONObject.put("view_class", this.f12149b);
                }
                if (this.f12150c > -1) {
                    jSONObject.put("index", this.f12150c);
                }
                if (this.f12151d > -1) {
                    jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_ID, this.f12151d);
                }
                if (this.f12152e != null) {
                    jSONObject.put("contentDescription", this.f12152e);
                }
                if (this.f12153f != null) {
                    jSONObject.put("tag", this.f12153f);
                }
                return jSONObject.toString();
            } catch (JSONException e) {
                throw new RuntimeException("Can't serialize PathElement to String", e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m12090a(View view, List<PathElement> list, Accumulator accumulator) {
        if (!list.isEmpty()) {
            if (this.f12145a.m12093a()) {
                MPLog.m12028d("MixpanelAPI.PathFinder", "There appears to be a concurrency issue in the pathfinding code. Path will not be matched.");
                return;
            }
            PathElement pathElement = list.get(0);
            List<PathElement> listSubList = list.subList(1, list.size());
            View viewM12086a = m12086a(pathElement, view, this.f12145a.m12094b());
            this.f12145a.m12096c();
            if (viewM12086a != null) {
                m12089b(viewM12086a, listSubList, accumulator);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m12089b(View view, List<PathElement> list, Accumulator accumulator) {
        if (list.isEmpty()) {
            accumulator.mo12091a(view);
            return;
        }
        if (view instanceof ViewGroup) {
            if (this.f12145a.m12093a()) {
                MPLog.m12021a("MixpanelAPI.PathFinder", "Path is too deep, will not match");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            PathElement pathElement = list.get(0);
            List<PathElement> listSubList = list.subList(1, list.size());
            int childCount = viewGroup.getChildCount();
            int iM12094b = this.f12145a.m12094b();
            for (int i = 0; i < childCount; i++) {
                View viewM12086a = m12086a(pathElement, viewGroup.getChildAt(i), iM12094b);
                if (viewM12086a != null) {
                    m12089b(viewM12086a, listSubList, accumulator);
                }
                if (pathElement.f12150c >= 0 && this.f12145a.m12092a(iM12094b) > pathElement.f12150c) {
                    break;
                }
            }
            this.f12145a.m12096c();
        }
    }

    /* JADX INFO: renamed from: a */
    private View m12086a(PathElement pathElement, View view, int i) {
        int iM12092a = this.f12145a.m12092a(i);
        if (m12087a(pathElement, view)) {
            this.f12145a.m12095b(i);
            if (pathElement.f12150c == -1 || pathElement.f12150c == iM12092a) {
                return view;
            }
        }
        if (pathElement.f12148a == 1 && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View viewM12086a = m12086a(pathElement, viewGroup.getChildAt(i2), i);
                if (viewM12086a != null) {
                    return viewM12086a;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private boolean m12087a(PathElement pathElement, View view) {
        if (pathElement.f12149b != null && !m12088a(view, pathElement.f12149b)) {
            return false;
        }
        if (-1 != pathElement.f12151d && view.getId() != pathElement.f12151d) {
            return false;
        }
        if (pathElement.f12152e == null || pathElement.f12152e.equals(view.getContentDescription())) {
            return pathElement.f12153f == null || (view.getTag() != null && pathElement.f12153f.equals(view.getTag().toString()));
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m12088a(Object obj, String str) {
        for (Class<?> superclass = obj.getClass(); !superclass.getCanonicalName().equals(str); superclass = superclass.getSuperclass()) {
            if (superclass == Object.class) {
                return false;
            }
        }
        return true;
    }

    private static class IntStack {

        /* JADX INFO: renamed from: a */
        private final int[] f12146a = new int[256];

        /* JADX INFO: renamed from: b */
        private int f12147b = 0;

        /* JADX INFO: renamed from: a */
        public boolean m12093a() {
            return this.f12146a.length == this.f12147b;
        }

        /* JADX INFO: renamed from: b */
        public int m12094b() {
            int i = this.f12147b;
            this.f12147b++;
            this.f12146a[i] = 0;
            return i;
        }

        /* JADX INFO: renamed from: a */
        public int m12092a(int i) {
            return this.f12146a[i];
        }

        /* JADX INFO: renamed from: b */
        public void m12095b(int i) {
            int[] iArr = this.f12146a;
            iArr[i] = iArr[i] + 1;
        }

        /* JADX INFO: renamed from: c */
        public void m12096c() {
            this.f12147b--;
            if (this.f12147b < 0) {
                throw new ArrayIndexOutOfBoundsException(this.f12147b);
            }
        }
    }
}

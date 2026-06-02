package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentTransitionImpl {
    /* JADX INFO: renamed from: a */
    public abstract Object mo1137a(Object obj, Object obj2, Object obj3);

    /* JADX INFO: renamed from: a */
    public abstract void mo1138a(ViewGroup viewGroup, Object obj);

    /* JADX INFO: renamed from: a */
    public abstract void mo1139a(Object obj, Rect rect);

    /* JADX INFO: renamed from: a */
    public abstract void mo1140a(Object obj, View view);

    /* JADX INFO: renamed from: a */
    public abstract void mo1141a(Object obj, View view, ArrayList<View> arrayList);

    /* JADX INFO: renamed from: a */
    public abstract void mo1142a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    /* JADX INFO: renamed from: a */
    public abstract void mo1143a(Object obj, ArrayList<View> arrayList);

    /* JADX INFO: renamed from: a */
    public abstract void mo1144a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo1145a(Object obj);

    /* JADX INFO: renamed from: b */
    public abstract Object mo1146b(Object obj);

    /* JADX INFO: renamed from: b */
    public abstract Object mo1147b(Object obj, Object obj2, Object obj3);

    /* JADX INFO: renamed from: b */
    public abstract void mo1148b(Object obj, View view);

    /* JADX INFO: renamed from: b */
    public abstract void mo1149b(Object obj, View view, ArrayList<View> arrayList);

    /* JADX INFO: renamed from: b */
    public abstract void mo1150b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* JADX INFO: renamed from: c */
    public abstract Object mo1151c(Object obj);

    /* JADX INFO: renamed from: c */
    public abstract void mo1152c(Object obj, View view);

    /* JADX INFO: renamed from: a */
    protected void m1673a(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    /* JADX INFO: renamed from: a */
    ArrayList<String> m1672a(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = arrayList.get(i);
            arrayList2.add(ViewCompat.m2611o(view));
            ViewCompat.m2588a(view, (String) null);
        }
        return arrayList2;
    }

    /* JADX INFO: renamed from: a */
    void m1674a(View view, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final ArrayList<String> arrayList3, Map<String, String> map) {
        final int size = arrayList2.size();
        final ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = arrayList.get(i);
            String strM2611o = ViewCompat.m2611o(view2);
            arrayList4.add(strM2611o);
            if (strM2611o != null) {
                ViewCompat.m2588a(view2, (String) null);
                String str = map.get(strM2611o);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    if (!str.equals(arrayList3.get(i2))) {
                        i2++;
                    } else {
                        ViewCompat.m2588a(arrayList2.get(i2), strM2611o);
                        break;
                    }
                }
            }
        }
        OneShotPreDrawListener.m1780a(view, new Runnable() { // from class: android.support.v4.app.FragmentTransitionImpl.1
            @Override // java.lang.Runnable
            public void run() {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < size) {
                        ViewCompat.m2588a((View) arrayList2.get(i4), (String) arrayList3.get(i4));
                        ViewCompat.m2588a((View) arrayList.get(i4), (String) arrayList4.get(i4));
                        i3 = i4 + 1;
                    } else {
                        return;
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    void m1677a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (ViewGroupCompat.m2681a(viewGroup)) {
                    arrayList.add(viewGroup);
                    return;
                }
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m1677a(arrayList, viewGroup.getChildAt(i));
                }
                return;
            }
            arrayList.add(view);
        }
    }

    /* JADX INFO: renamed from: a */
    void m1678a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String strM2611o = ViewCompat.m2611o(view);
            if (strM2611o != null) {
                map.put(strM2611o, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m1678a(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m1675a(View view, final ArrayList<View> arrayList, final Map<String, String> map) {
        OneShotPreDrawListener.m1780a(view, new Runnable() { // from class: android.support.v4.app.FragmentTransitionImpl.2
            @Override // java.lang.Runnable
            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view2 = (View) arrayList.get(i);
                    String strM2611o = ViewCompat.m2611o(view2);
                    if (strM2611o != null) {
                        ViewCompat.m2588a(view2, FragmentTransitionImpl.m1668a((Map<String, String>) map, strM2611o));
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    void m1676a(ViewGroup viewGroup, final ArrayList<View> arrayList, final Map<String, String> map) {
        OneShotPreDrawListener.m1780a(viewGroup, new Runnable() { // from class: android.support.v4.app.FragmentTransitionImpl.3
            @Override // java.lang.Runnable
            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view = (View) arrayList.get(i);
                    ViewCompat.m2588a(view, (String) map.get(ViewCompat.m2611o(view)));
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    protected static void m1669a(List<View> list, View view) {
        int size = list.size();
        if (!m1671a(list, view, size)) {
            list.add(view);
            for (int i = size; i < list.size(); i++) {
                View view2 = list.get(i);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!m1671a(list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1671a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    protected static boolean m1670a(List list) {
        return list == null || list.isEmpty();
    }

    /* JADX INFO: renamed from: a */
    static String m1668a(Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}

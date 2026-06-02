package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.app.BackStackRecord;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class FragmentTransition {

    /* JADX INFO: renamed from: a */
    private static final int[] f1578a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};

    /* JADX INFO: renamed from: b */
    private static final FragmentTransitionImpl f1579b;

    /* JADX INFO: renamed from: c */
    private static final FragmentTransitionImpl f1580c;

    static {
        f1579b = Build.VERSION.SDK_INT >= 21 ? new FragmentTransitionCompat21() : null;
        f1580c = m1634a();
    }

    /* JADX INFO: renamed from: a */
    private static FragmentTransitionImpl m1634a() {
        try {
            return (FragmentTransitionImpl) Class.forName("android.support.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    static void m1649a(FragmentManagerImpl fragmentManagerImpl, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (fragmentManagerImpl.f1498l >= 1) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                BackStackRecord backStackRecord = arrayList.get(i3);
                if (arrayList2.get(i3).booleanValue()) {
                    m1662b(backStackRecord, (SparseArray<FragmentContainerTransition>) sparseArray, z);
                } else {
                    m1646a(backStackRecord, (SparseArray<FragmentContainerTransition>) sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(fragmentManagerImpl.f1499m.m1464i());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int iKeyAt = sparseArray.keyAt(i4);
                    ArrayMap<String, String> arrayMapM1636a = m1636a(iKeyAt, arrayList, arrayList2, i, i2);
                    FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition) sparseArray.valueAt(i4);
                    if (z) {
                        m1648a(fragmentManagerImpl, iKeyAt, fragmentContainerTransition, view, arrayMapM1636a);
                    } else {
                        m1664b(fragmentManagerImpl, iKeyAt, fragmentContainerTransition, view, arrayMapM1636a);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static ArrayMap<String, String> m1636a(int i, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            BackStackRecord backStackRecord = arrayList.get(i4);
            if (backStackRecord.m1382b(i)) {
                boolean zBooleanValue = arrayList2.get(i4).booleanValue();
                if (backStackRecord.f1418r != null) {
                    int size = backStackRecord.f1418r.size();
                    if (zBooleanValue) {
                        arrayList3 = backStackRecord.f1418r;
                        arrayList4 = backStackRecord.f1419s;
                    } else {
                        ArrayList<String> arrayList5 = backStackRecord.f1418r;
                        arrayList3 = backStackRecord.f1419s;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String strRemove = arrayMap.remove(str2);
                        if (strRemove != null) {
                            arrayMap.put(str, strRemove);
                        } else {
                            arrayMap.put(str, str2);
                        }
                    }
                }
            }
        }
        return arrayMap;
    }

    /* JADX INFO: renamed from: a */
    private static void m1648a(FragmentManagerImpl fragmentManagerImpl, int i, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap) {
        Fragment fragment;
        Fragment fragment2;
        FragmentTransitionImpl fragmentTransitionImplM1635a;
        ViewGroup viewGroup = null;
        if (fragmentManagerImpl.f1500n.mo1402a()) {
            viewGroup = (ViewGroup) fragmentManagerImpl.f1500n.mo1401a(i);
        }
        if (viewGroup != null && (fragmentTransitionImplM1635a = m1635a((fragment2 = fragmentContainerTransition.f1612d), (fragment = fragmentContainerTransition.f1609a))) != null) {
            boolean z = fragmentContainerTransition.f1610b;
            boolean z2 = fragmentContainerTransition.f1613e;
            ArrayList<View> arrayList = new ArrayList<>();
            ArrayList<View> arrayList2 = new ArrayList<>();
            Object objM1640a = m1640a(fragmentTransitionImplM1635a, fragment, z);
            Object objM1659b = m1659b(fragmentTransitionImplM1635a, fragment2, z2);
            Object objM1641a = m1641a(fragmentTransitionImplM1635a, viewGroup, view, arrayMap, fragmentContainerTransition, arrayList2, arrayList, objM1640a, objM1659b);
            if (objM1640a != null || objM1641a != null || objM1659b != null) {
                ArrayList<View> arrayListM1661b = m1661b(fragmentTransitionImplM1635a, objM1659b, fragment2, arrayList2, view);
                ArrayList<View> arrayListM1661b2 = m1661b(fragmentTransitionImplM1635a, objM1640a, fragment, arrayList, view);
                m1665b(arrayListM1661b2, 4);
                Object objM1642a = m1642a(fragmentTransitionImplM1635a, objM1640a, objM1659b, objM1641a, fragment, z);
                if (objM1642a != null) {
                    m1651a(fragmentTransitionImplM1635a, objM1659b, fragment2, arrayListM1661b);
                    ArrayList<String> arrayListM1672a = fragmentTransitionImplM1635a.m1672a(arrayList);
                    fragmentTransitionImplM1635a.mo1142a(objM1642a, objM1640a, arrayListM1661b2, objM1659b, arrayListM1661b, objM1641a, arrayList);
                    fragmentTransitionImplM1635a.mo1138a(viewGroup, objM1642a);
                    fragmentTransitionImplM1635a.m1674a(viewGroup, arrayList2, arrayList, arrayListM1672a, arrayMap);
                    m1665b(arrayListM1661b2, 0);
                    fragmentTransitionImplM1635a.mo1144a(objM1641a, arrayList2, arrayList);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1651a(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, final ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            fragmentTransitionImpl.mo1149b(obj, fragment.getView(), arrayList);
            OneShotPreDrawListener.m1780a(fragment.mContainer, new Runnable() { // from class: android.support.v4.app.FragmentTransition.1
                @Override // java.lang.Runnable
                public void run() {
                    FragmentTransition.m1665b(arrayList, 4);
                }
            });
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m1664b(FragmentManagerImpl fragmentManagerImpl, int i, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap) {
        Fragment fragment;
        Fragment fragment2;
        FragmentTransitionImpl fragmentTransitionImplM1635a;
        ViewGroup viewGroup = null;
        if (fragmentManagerImpl.f1500n.mo1402a()) {
            viewGroup = (ViewGroup) fragmentManagerImpl.f1500n.mo1401a(i);
        }
        if (viewGroup != null && (fragmentTransitionImplM1635a = m1635a((fragment2 = fragmentContainerTransition.f1612d), (fragment = fragmentContainerTransition.f1609a))) != null) {
            boolean z = fragmentContainerTransition.f1610b;
            boolean z2 = fragmentContainerTransition.f1613e;
            Object objM1640a = m1640a(fragmentTransitionImplM1635a, fragment, z);
            Object objM1659b = m1659b(fragmentTransitionImplM1635a, fragment2, z2);
            ArrayList arrayList = new ArrayList();
            ArrayList<View> arrayList2 = new ArrayList<>();
            Object objM1660b = m1660b(fragmentTransitionImplM1635a, viewGroup, view, arrayMap, fragmentContainerTransition, arrayList, arrayList2, objM1640a, objM1659b);
            if (objM1640a != null || objM1660b != null || objM1659b != null) {
                ArrayList<View> arrayListM1661b = m1661b(fragmentTransitionImplM1635a, objM1659b, fragment2, (ArrayList<View>) arrayList, view);
                Object obj = (arrayListM1661b == null || arrayListM1661b.isEmpty()) ? null : objM1659b;
                fragmentTransitionImplM1635a.mo1148b(objM1640a, view);
                Object objM1642a = m1642a(fragmentTransitionImplM1635a, objM1640a, obj, objM1660b, fragment, fragmentContainerTransition.f1610b);
                if (objM1642a != null) {
                    ArrayList<View> arrayList3 = new ArrayList<>();
                    fragmentTransitionImplM1635a.mo1142a(objM1642a, objM1640a, arrayList3, obj, arrayListM1661b, objM1660b, arrayList2);
                    m1650a(fragmentTransitionImplM1635a, viewGroup, fragment, view, arrayList2, objM1640a, arrayList3, obj, arrayListM1661b);
                    fragmentTransitionImplM1635a.m1675a((View) viewGroup, arrayList2, (Map<String, String>) arrayMap);
                    fragmentTransitionImplM1635a.mo1138a(viewGroup, objM1642a);
                    fragmentTransitionImplM1635a.m1676a(viewGroup, arrayList2, (Map<String, String>) arrayMap);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1650a(final FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, final Fragment fragment, final View view, final ArrayList<View> arrayList, final Object obj, final ArrayList<View> arrayList2, final Object obj2, final ArrayList<View> arrayList3) {
        OneShotPreDrawListener.m1780a(viewGroup, new Runnable() { // from class: android.support.v4.app.FragmentTransition.2
            @Override // java.lang.Runnable
            public void run() {
                if (obj != null) {
                    fragmentTransitionImpl.mo1152c(obj, view);
                    arrayList2.addAll(FragmentTransition.m1661b(fragmentTransitionImpl, obj, fragment, (ArrayList<View>) arrayList, view));
                }
                if (arrayList3 != null) {
                    if (obj2 != null) {
                        ArrayList<View> arrayList4 = new ArrayList<>();
                        arrayList4.add(view);
                        fragmentTransitionImpl.mo1150b(obj2, arrayList3, arrayList4);
                    }
                    arrayList3.clear();
                    arrayList3.add(view);
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    private static FragmentTransitionImpl m1635a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (f1579b != null && m1656a(f1579b, arrayList)) {
            return f1579b;
        }
        if (f1580c != null && m1656a(f1580c, arrayList)) {
            return f1580c;
        }
        if (f1579b == null && f1580c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1656a(FragmentTransitionImpl fragmentTransitionImpl, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!fragmentTransitionImpl.mo1145a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private static Object m1639a(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, Fragment fragment2, boolean z) {
        Object sharedElementEnterTransition;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            sharedElementEnterTransition = fragment2.getSharedElementReturnTransition();
        } else {
            sharedElementEnterTransition = fragment.getSharedElementEnterTransition();
        }
        return fragmentTransitionImpl.mo1151c(fragmentTransitionImpl.mo1146b(sharedElementEnterTransition));
    }

    /* JADX INFO: renamed from: a */
    private static Object m1640a(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        Object enterTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            enterTransition = fragment.getReenterTransition();
        } else {
            enterTransition = fragment.getEnterTransition();
        }
        return fragmentTransitionImpl.mo1146b(enterTransition);
    }

    /* JADX INFO: renamed from: b */
    private static Object m1659b(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        Object exitTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            exitTransition = fragment.getReturnTransition();
        } else {
            exitTransition = fragment.getExitTransition();
        }
        return fragmentTransitionImpl.mo1146b(exitTransition);
    }

    /* JADX INFO: renamed from: a */
    private static Object m1641a(final FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        final Rect rect;
        final View viewM1658b;
        final Fragment fragment = fragmentContainerTransition.f1609a;
        final Fragment fragment2 = fragmentContainerTransition.f1612d;
        if (fragment != null) {
            fragment.getView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z = fragmentContainerTransition.f1610b;
        Object objM1639a = arrayMap.isEmpty() ? null : m1639a(fragmentTransitionImpl, fragment, fragment2, z);
        ArrayMap<String, View> arrayMapM1657b = m1657b(fragmentTransitionImpl, arrayMap, objM1639a, fragmentContainerTransition);
        final ArrayMap<String, View> arrayMapM1666c = m1666c(fragmentTransitionImpl, arrayMap, objM1639a, fragmentContainerTransition);
        if (arrayMap.isEmpty()) {
            obj3 = null;
            if (arrayMapM1657b != null) {
                arrayMapM1657b.clear();
            }
            if (arrayMapM1666c != null) {
                arrayMapM1666c.clear();
            }
        } else {
            m1655a(arrayList, arrayMapM1657b, arrayMap.keySet());
            m1655a(arrayList2, arrayMapM1666c, arrayMap.values());
            obj3 = objM1639a;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        m1663b(fragment, fragment2, z, arrayMapM1657b, true);
        if (obj3 != null) {
            arrayList2.add(view);
            fragmentTransitionImpl.mo1141a(obj3, view, arrayList);
            m1652a(fragmentTransitionImpl, obj3, obj2, arrayMapM1657b, fragmentContainerTransition.f1613e, fragmentContainerTransition.f1614f);
            rect = new Rect();
            viewM1658b = m1658b(arrayMapM1666c, fragmentContainerTransition, obj, z);
            if (viewM1658b != null) {
                fragmentTransitionImpl.mo1139a(obj, rect);
            }
        } else {
            rect = null;
            viewM1658b = null;
        }
        OneShotPreDrawListener.m1780a(viewGroup, new Runnable() { // from class: android.support.v4.app.FragmentTransition.3
            @Override // java.lang.Runnable
            public void run() {
                FragmentTransition.m1663b(fragment, fragment2, z, (ArrayMap<String, View>) arrayMapM1666c, false);
                if (viewM1658b != null) {
                    fragmentTransitionImpl.m1673a(viewM1658b, rect);
                }
            }
        });
        return obj3;
    }

    /* JADX INFO: renamed from: a */
    private static void m1655a(ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, Collection<String> collection) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View viewC = arrayMap.m2453c(size);
            if (collection.contains(ViewCompat.m2611o(viewC))) {
                arrayList.add(viewC);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private static Object m1660b(final FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, final View view, final ArrayMap<String, String> arrayMap, final FragmentContainerTransition fragmentContainerTransition, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final Object obj, Object obj2) {
        Object obj3;
        final Rect rect;
        final Fragment fragment = fragmentContainerTransition.f1609a;
        final Fragment fragment2 = fragmentContainerTransition.f1612d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z = fragmentContainerTransition.f1610b;
        Object objM1639a = arrayMap.isEmpty() ? null : m1639a(fragmentTransitionImpl, fragment, fragment2, z);
        ArrayMap<String, View> arrayMapM1657b = m1657b(fragmentTransitionImpl, arrayMap, objM1639a, fragmentContainerTransition);
        if (arrayMap.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(arrayMapM1657b.values());
            obj3 = objM1639a;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        m1663b(fragment, fragment2, z, arrayMapM1657b, true);
        if (obj3 != null) {
            rect = new Rect();
            fragmentTransitionImpl.mo1141a(obj3, view, arrayList);
            m1652a(fragmentTransitionImpl, obj3, obj2, arrayMapM1657b, fragmentContainerTransition.f1613e, fragmentContainerTransition.f1614f);
            if (obj != null) {
                fragmentTransitionImpl.mo1139a(obj, rect);
            }
        } else {
            rect = null;
        }
        final Object obj4 = obj3;
        OneShotPreDrawListener.m1780a(viewGroup, new Runnable() { // from class: android.support.v4.app.FragmentTransition.4
            @Override // java.lang.Runnable
            public void run() {
                ArrayMap arrayMapM1666c = FragmentTransition.m1666c(fragmentTransitionImpl, arrayMap, obj4, fragmentContainerTransition);
                if (arrayMapM1666c != null) {
                    arrayList2.addAll(arrayMapM1666c.values());
                    arrayList2.add(view);
                }
                FragmentTransition.m1663b(fragment, fragment2, z, (ArrayMap<String, View>) arrayMapM1666c, false);
                if (obj4 != null) {
                    fragmentTransitionImpl.mo1144a(obj4, arrayList, arrayList2);
                    View viewM1658b = FragmentTransition.m1658b((ArrayMap<String, View>) arrayMapM1666c, fragmentContainerTransition, obj, z);
                    if (viewM1658b != null) {
                        fragmentTransitionImpl.m1673a(viewM1658b, rect);
                    }
                }
            }
        });
        return obj3;
    }

    /* JADX INFO: renamed from: b */
    private static ArrayMap<String, View> m1657b(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        ArrayList<String> arrayList;
        SharedElementCallback sharedElementCallback;
        if (arrayMap.isEmpty() || obj == null) {
            arrayMap.clear();
            return null;
        }
        Fragment fragment = fragmentContainerTransition.f1612d;
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        fragmentTransitionImpl.m1678a((Map<String, View>) arrayMap2, fragment.getView());
        BackStackRecord backStackRecord = fragmentContainerTransition.f1614f;
        if (fragmentContainerTransition.f1613e) {
            SharedElementCallback enterTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.f1419s;
            sharedElementCallback = enterTransitionCallback;
        } else {
            SharedElementCallback exitTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.f1418r;
            sharedElementCallback = exitTransitionCallback;
        }
        arrayMap2.m2374a((Collection<?>) arrayList);
        if (sharedElementCallback != null) {
            sharedElementCallback.m1805a(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = arrayMap2.get(str);
                if (view == null) {
                    arrayMap.remove(str);
                } else if (!str.equals(ViewCompat.m2611o(view))) {
                    arrayMap.put(ViewCompat.m2611o(view), arrayMap.remove(str));
                }
            }
        } else {
            arrayMap.m2374a((Collection<?>) arrayMap2.keySet());
        }
        return arrayMap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public static ArrayMap<String, View> m1666c(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        ArrayList<String> arrayList;
        SharedElementCallback sharedElementCallback;
        String strM1643a;
        Fragment fragment = fragmentContainerTransition.f1609a;
        View view = fragment.getView();
        if (arrayMap.isEmpty() || obj == null || view == null) {
            arrayMap.clear();
            return null;
        }
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        fragmentTransitionImpl.m1678a((Map<String, View>) arrayMap2, view);
        BackStackRecord backStackRecord = fragmentContainerTransition.f1611c;
        if (fragmentContainerTransition.f1610b) {
            SharedElementCallback exitTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.f1418r;
            sharedElementCallback = exitTransitionCallback;
        } else {
            SharedElementCallback enterTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.f1419s;
            sharedElementCallback = enterTransitionCallback;
        }
        if (arrayList != null) {
            arrayMap2.m2374a((Collection<?>) arrayList);
            arrayMap2.m2374a((Collection<?>) arrayMap.values());
        }
        if (sharedElementCallback != null) {
            sharedElementCallback.m1805a(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view2 = arrayMap2.get(str);
                if (view2 == null) {
                    String strM1643a2 = m1643a(arrayMap, str);
                    if (strM1643a2 != null) {
                        arrayMap.remove(strM1643a2);
                    }
                } else if (!str.equals(ViewCompat.m2611o(view2)) && (strM1643a = m1643a(arrayMap, str)) != null) {
                    arrayMap.put(strM1643a, ViewCompat.m2611o(view2));
                }
            }
        } else {
            m1653a(arrayMap, arrayMap2);
        }
        return arrayMap2;
    }

    /* JADX INFO: renamed from: a */
    private static String m1643a(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(arrayMap.m2453c(i))) {
                return arrayMap.m2452b(i);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static View m1658b(ArrayMap<String, View> arrayMap, FragmentContainerTransition fragmentContainerTransition, Object obj, boolean z) {
        String str;
        BackStackRecord backStackRecord = fragmentContainerTransition.f1611c;
        if (obj != null && arrayMap != null && backStackRecord.f1418r != null && !backStackRecord.f1418r.isEmpty()) {
            if (z) {
                str = backStackRecord.f1418r.get(0);
            } else {
                str = backStackRecord.f1419s.get(0);
            }
            return arrayMap.get(str);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private static void m1652a(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, ArrayMap<String, View> arrayMap, boolean z, BackStackRecord backStackRecord) {
        String str;
        if (backStackRecord.f1418r != null && !backStackRecord.f1418r.isEmpty()) {
            if (z) {
                str = backStackRecord.f1419s.get(0);
            } else {
                str = backStackRecord.f1418r.get(0);
            }
            View view = arrayMap.get(str);
            fragmentTransitionImpl.mo1140a(obj, view);
            if (obj2 != null) {
                fragmentTransitionImpl.mo1140a(obj2, view);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1653a(ArrayMap<String, String> arrayMap, ArrayMap<String, View> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey(arrayMap.m2453c(size))) {
                arrayMap.m2454d(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static void m1663b(Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap, boolean z2) {
        SharedElementCallback enterTransitionCallback;
        if (z) {
            enterTransitionCallback = fragment2.getEnterTransitionCallback();
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
        }
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = arrayMap == null ? 0 : arrayMap.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(arrayMap.m2452b(i));
                arrayList.add(arrayMap.m2453c(i));
            }
            if (z2) {
                enterTransitionCallback.m1804a(arrayList2, arrayList, (List<View>) null);
            } else {
                enterTransitionCallback.m1806b(arrayList2, arrayList, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static ArrayList<View> m1661b(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        ArrayList<View> arrayList2 = null;
        if (obj != null) {
            arrayList2 = new ArrayList<>();
            View view2 = fragment.getView();
            if (view2 != null) {
                fragmentTransitionImpl.m1677a(arrayList2, view2);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (!arrayList2.isEmpty()) {
                arrayList2.add(view);
                fragmentTransitionImpl.mo1143a(obj, arrayList2);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static void m1665b(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static Object m1642a(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean allowReturnTransitionOverlap = true;
        if (obj != null && obj2 != null && fragment != null) {
            allowReturnTransitionOverlap = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        if (allowReturnTransitionOverlap) {
            return fragmentTransitionImpl.mo1137a(obj2, obj, obj3);
        }
        return fragmentTransitionImpl.mo1147b(obj2, obj, obj3);
    }

    /* JADX INFO: renamed from: a */
    public static void m1646a(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        int size = backStackRecord.f1402b.size();
        for (int i = 0; i < size; i++) {
            m1645a(backStackRecord, backStackRecord.f1402b.get(i), sparseArray, false, z);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m1662b(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        if (backStackRecord.f1401a.f1500n.mo1402a()) {
            for (int size = backStackRecord.f1402b.size() - 1; size >= 0; size--) {
                m1645a(backStackRecord, backStackRecord.f1402b.get(size), sparseArray, true, z);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1645a(BackStackRecord backStackRecord, BackStackRecord.C0116Op c0116Op, SparseArray<FragmentContainerTransition> sparseArray, boolean z, boolean z2) {
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        FragmentContainerTransition fragmentContainerTransitionM1633a;
        FragmentContainerTransition fragmentContainerTransitionM1633a2;
        Fragment fragment = c0116Op.f1423b;
        if (fragment != null && (i = fragment.mContainerId) != 0) {
            switch (z ? f1578a[c0116Op.f1422a] : c0116Op.f1422a) {
                case 1:
                case 7:
                    if (z2) {
                        z9 = fragment.mIsNewlyAdded;
                    } else {
                        z9 = (fragment.mAdded || fragment.mHidden) ? false : true;
                    }
                    z4 = true;
                    z5 = false;
                    z6 = false;
                    z7 = z9;
                    break;
                case 2:
                default:
                    z4 = false;
                    z5 = false;
                    z6 = false;
                    z7 = false;
                    break;
                case 3:
                case 6:
                    if (z2) {
                        z3 = !fragment.mAdded && fragment.mView != null && fragment.mView.getVisibility() == 0 && fragment.mPostponedAlpha >= CropImageView.DEFAULT_ASPECT_RATIO;
                    } else {
                        z3 = fragment.mAdded && !fragment.mHidden;
                    }
                    z4 = false;
                    z5 = z3;
                    z6 = true;
                    z7 = false;
                    break;
                case 4:
                    if (z2) {
                        z8 = fragment.mHiddenChanged && fragment.mAdded && fragment.mHidden;
                    } else {
                        z8 = fragment.mAdded && !fragment.mHidden;
                    }
                    z4 = false;
                    z5 = z8;
                    z6 = true;
                    z7 = false;
                    break;
                case 5:
                    if (z2) {
                        z10 = fragment.mHiddenChanged && !fragment.mHidden && fragment.mAdded;
                    } else {
                        z10 = fragment.mHidden;
                    }
                    z4 = true;
                    z5 = false;
                    z6 = false;
                    z7 = z10;
                    break;
            }
            FragmentContainerTransition fragmentContainerTransition = sparseArray.get(i);
            if (z7) {
                fragmentContainerTransitionM1633a = m1633a(fragmentContainerTransition, sparseArray, i);
                fragmentContainerTransitionM1633a.f1609a = fragment;
                fragmentContainerTransitionM1633a.f1610b = z;
                fragmentContainerTransitionM1633a.f1611c = backStackRecord;
            } else {
                fragmentContainerTransitionM1633a = fragmentContainerTransition;
            }
            if (!z2 && z4) {
                if (fragmentContainerTransitionM1633a != null && fragmentContainerTransitionM1633a.f1612d == fragment) {
                    fragmentContainerTransitionM1633a.f1612d = null;
                }
                FragmentManagerImpl fragmentManagerImpl = backStackRecord.f1401a;
                if (fragment.mState < 1 && fragmentManagerImpl.f1498l >= 1 && !backStackRecord.f1420t) {
                    fragmentManagerImpl.m1573g(fragment);
                    fragmentManagerImpl.m1539a(fragment, 1, 0, 0, false);
                }
            }
            if (z5 && (fragmentContainerTransitionM1633a == null || fragmentContainerTransitionM1633a.f1612d == null)) {
                fragmentContainerTransitionM1633a2 = m1633a(fragmentContainerTransitionM1633a, sparseArray, i);
                fragmentContainerTransitionM1633a2.f1612d = fragment;
                fragmentContainerTransitionM1633a2.f1613e = z;
                fragmentContainerTransitionM1633a2.f1614f = backStackRecord;
            } else {
                fragmentContainerTransitionM1633a2 = fragmentContainerTransitionM1633a;
            }
            if (!z2 && z6 && fragmentContainerTransitionM1633a2 != null && fragmentContainerTransitionM1633a2.f1609a == fragment) {
                fragmentContainerTransitionM1633a2.f1609a = null;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static FragmentContainerTransition m1633a(FragmentContainerTransition fragmentContainerTransition, SparseArray<FragmentContainerTransition> sparseArray, int i) {
        if (fragmentContainerTransition == null) {
            FragmentContainerTransition fragmentContainerTransition2 = new FragmentContainerTransition();
            sparseArray.put(i, fragmentContainerTransition2);
            return fragmentContainerTransition2;
        }
        return fragmentContainerTransition;
    }

    static class FragmentContainerTransition {

        /* JADX INFO: renamed from: a */
        public Fragment f1609a;

        /* JADX INFO: renamed from: b */
        public boolean f1610b;

        /* JADX INFO: renamed from: c */
        public BackStackRecord f1611c;

        /* JADX INFO: renamed from: d */
        public Fragment f1612d;

        /* JADX INFO: renamed from: e */
        public boolean f1613e;

        /* JADX INFO: renamed from: f */
        public BackStackRecord f1614f;

        FragmentContainerTransition() {
        }
    }
}

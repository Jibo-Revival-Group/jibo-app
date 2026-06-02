package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public abstract class Transition implements Cloneable {

    /* JADX INFO: renamed from: g */
    private static final int[] f1262g = {2, 1, 3, 4};

    /* JADX INFO: renamed from: h */
    private static final PathMotion f1263h = new PathMotion() { // from class: android.support.transition.Transition.1
        @Override // android.support.transition.PathMotion
        /* JADX INFO: renamed from: a */
        public Path mo1067a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    };

    /* JADX INFO: renamed from: z */
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> f1264z = new ThreadLocal<>();

    /* JADX INFO: renamed from: H */
    private EpicenterCallback f1272H;

    /* JADX INFO: renamed from: I */
    private ArrayMap<String, String> f1273I;

    /* JADX INFO: renamed from: f */
    TransitionPropagation f1280f;

    /* JADX INFO: renamed from: x */
    private ArrayList<TransitionValues> f1296x;

    /* JADX INFO: renamed from: y */
    private ArrayList<TransitionValues> f1297y;

    /* JADX INFO: renamed from: i */
    private String f1281i = getClass().getName();

    /* JADX INFO: renamed from: j */
    private long f1282j = -1;

    /* JADX INFO: renamed from: a */
    long f1275a = -1;

    /* JADX INFO: renamed from: k */
    private TimeInterpolator f1283k = null;

    /* JADX INFO: renamed from: b */
    ArrayList<Integer> f1276b = new ArrayList<>();

    /* JADX INFO: renamed from: c */
    ArrayList<View> f1277c = new ArrayList<>();

    /* JADX INFO: renamed from: l */
    private ArrayList<String> f1284l = null;

    /* JADX INFO: renamed from: m */
    private ArrayList<Class> f1285m = null;

    /* JADX INFO: renamed from: n */
    private ArrayList<Integer> f1286n = null;

    /* JADX INFO: renamed from: o */
    private ArrayList<View> f1287o = null;

    /* JADX INFO: renamed from: p */
    private ArrayList<Class> f1288p = null;

    /* JADX INFO: renamed from: q */
    private ArrayList<String> f1289q = null;

    /* JADX INFO: renamed from: r */
    private ArrayList<Integer> f1290r = null;

    /* JADX INFO: renamed from: s */
    private ArrayList<View> f1291s = null;

    /* JADX INFO: renamed from: t */
    private ArrayList<Class> f1292t = null;

    /* JADX INFO: renamed from: u */
    private TransitionValuesMaps f1293u = new TransitionValuesMaps();

    /* JADX INFO: renamed from: v */
    private TransitionValuesMaps f1294v = new TransitionValuesMaps();

    /* JADX INFO: renamed from: d */
    TransitionSet f1278d = null;

    /* JADX INFO: renamed from: w */
    private int[] f1295w = f1262g;

    /* JADX INFO: renamed from: A */
    private ViewGroup f1265A = null;

    /* JADX INFO: renamed from: e */
    boolean f1279e = false;

    /* JADX INFO: renamed from: B */
    private ArrayList<Animator> f1266B = new ArrayList<>();

    /* JADX INFO: renamed from: C */
    private int f1267C = 0;

    /* JADX INFO: renamed from: D */
    private boolean f1268D = false;

    /* JADX INFO: renamed from: E */
    private boolean f1269E = false;

    /* JADX INFO: renamed from: F */
    private ArrayList<TransitionListener> f1270F = null;

    /* JADX INFO: renamed from: G */
    private ArrayList<Animator> f1271G = new ArrayList<>();

    /* JADX INFO: renamed from: J */
    private PathMotion f1274J = f1263h;

    public static abstract class EpicenterCallback {
        /* JADX INFO: renamed from: a */
        public abstract Rect mo1153a(Transition transition);
    }

    public interface TransitionListener {
        /* JADX INFO: renamed from: a */
        void mo1088a(Transition transition);

        /* JADX INFO: renamed from: b */
        void mo1089b(Transition transition);

        /* JADX INFO: renamed from: c */
        void mo1090c(Transition transition);

        /* JADX INFO: renamed from: d */
        void mo1154d(Transition transition);
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo406a(TransitionValues transitionValues);

    /* JADX INFO: renamed from: b */
    public abstract void mo407b(TransitionValues transitionValues);

    public Transition() {
    }

    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f1253c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long jM1925a = TypedArrayUtils.m1925a(typedArrayObtainStyledAttributes, (XmlPullParser) xmlResourceParser, "duration", 1, -1);
        if (jM1925a >= 0) {
            mo1212a(jM1925a);
        }
        long jM1925a2 = TypedArrayUtils.m1925a(typedArrayObtainStyledAttributes, (XmlPullParser) xmlResourceParser, "startDelay", 2, -1);
        if (jM1925a2 > 0) {
            mo1226b(jM1925a2);
        }
        int iM1932c = TypedArrayUtils.m1932c(typedArrayObtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (iM1932c > 0) {
            mo1213a(AnimationUtils.loadInterpolator(context, iM1932c));
        }
        String strM1927a = TypedArrayUtils.m1927a(typedArrayObtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (strM1927a != null) {
            m1223a(m1209b(strM1927a));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: b */
    private static int[] m1209b(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String strTrim = stringTokenizer.nextToken().trim();
            if (ShareConstants.WEB_DIALOG_PARAM_ID.equalsIgnoreCase(strTrim)) {
                iArr[i] = 3;
            } else if ("instance".equalsIgnoreCase(strTrim)) {
                iArr[i] = 1;
            } else if ("name".equalsIgnoreCase(strTrim)) {
                iArr[i] = 2;
            } else if ("itemId".equalsIgnoreCase(strTrim)) {
                iArr[i] = 4;
            } else if (strTrim.isEmpty()) {
                int[] iArr2 = new int[iArr.length - 1];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                i--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + strTrim + "'");
            }
            i++;
        }
        return iArr;
    }

    /* JADX INFO: renamed from: a */
    public Transition mo1212a(long j) {
        this.f1275a = j;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public long m1225b() {
        return this.f1275a;
    }

    /* JADX INFO: renamed from: b */
    public Transition mo1226b(long j) {
        this.f1282j = j;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public long m1231c() {
        return this.f1282j;
    }

    /* JADX INFO: renamed from: a */
    public Transition mo1213a(TimeInterpolator timeInterpolator) {
        this.f1283k = timeInterpolator;
        return this;
    }

    /* JADX INFO: renamed from: d */
    public TimeInterpolator m1234d() {
        return this.f1283k;
    }

    /* JADX INFO: renamed from: a */
    public String[] mo1075a() {
        return null;
    }

    /* JADX INFO: renamed from: a */
    public Animator mo405a(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m1223a(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.f1295w = f1262g;
            return;
        }
        for (int i = 0; i < iArr.length; i++) {
            if (!m1205a(iArr[i])) {
                throw new IllegalArgumentException("matches contains invalid value");
            }
            if (m1207a(iArr, i)) {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.f1295w = (int[]) iArr.clone();
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1205a(int i) {
        return i >= 1 && i <= 4;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1207a(int[] iArr, int i) {
        int i2 = iArr[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private void m1201a(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        TransitionValues transitionValuesRemove;
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View viewB = arrayMap.m2452b(size);
            if (viewB != null && m1230b(viewB) && (transitionValuesRemove = arrayMap2.remove(viewB)) != null && transitionValuesRemove.f1324b != null && m1230b(transitionValuesRemove.f1324b)) {
                this.f1296x.add(arrayMap.m2454d(size));
                this.f1297y.add(transitionValuesRemove);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1203a(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        View viewM2406a;
        int iM2409b = longSparseArray.m2409b();
        for (int i = 0; i < iM2409b; i++) {
            View viewM2414c = longSparseArray.m2414c(i);
            if (viewM2414c != null && m1230b(viewM2414c) && (viewM2406a = longSparseArray2.m2406a(longSparseArray.m2410b(i))) != null && m1230b(viewM2406a)) {
                TransitionValues transitionValues = arrayMap.get(viewM2414c);
                TransitionValues transitionValues2 = arrayMap2.get(viewM2406a);
                if (transitionValues != null && transitionValues2 != null) {
                    this.f1296x.add(transitionValues);
                    this.f1297y.add(transitionValues2);
                    arrayMap.remove(viewM2414c);
                    arrayMap2.remove(viewM2406a);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1204a(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View viewValueAt = sparseArray.valueAt(i);
            if (viewValueAt != null && m1230b(viewValueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && m1230b(view)) {
                TransitionValues transitionValues = arrayMap.get(viewValueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.f1296x.add(transitionValues);
                    this.f1297y.add(transitionValues2);
                    arrayMap.remove(viewValueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1202a(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        View view;
        int size = arrayMap3.size();
        for (int i = 0; i < size; i++) {
            View viewC = arrayMap3.m2453c(i);
            if (viewC != null && m1230b(viewC) && (view = arrayMap4.get(arrayMap3.m2452b(i))) != null && m1230b(view)) {
                TransitionValues transitionValues = arrayMap.get(viewC);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.f1296x.add(transitionValues);
                    this.f1297y.add(transitionValues2);
                    arrayMap.remove(viewC);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m1208b(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        for (int i = 0; i < arrayMap.size(); i++) {
            TransitionValues transitionValuesC = arrayMap.m2453c(i);
            if (m1230b(transitionValuesC.f1324b)) {
                this.f1296x.add(transitionValuesC);
                this.f1297y.add(null);
            }
        }
        for (int i2 = 0; i2 < arrayMap2.size(); i2++) {
            TransitionValues transitionValuesC2 = arrayMap2.m2453c(i2);
            if (m1230b(transitionValuesC2.f1324b)) {
                this.f1297y.add(transitionValuesC2);
                this.f1296x.add(null);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1199a(TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        ArrayMap<View, TransitionValues> arrayMap = new ArrayMap<>(transitionValuesMaps.f1326a);
        ArrayMap<View, TransitionValues> arrayMap2 = new ArrayMap<>(transitionValuesMaps2.f1326a);
        for (int i = 0; i < this.f1295w.length; i++) {
            switch (this.f1295w[i]) {
                case 1:
                    m1201a(arrayMap, arrayMap2);
                    break;
                case 2:
                    m1202a(arrayMap, arrayMap2, transitionValuesMaps.f1329d, transitionValuesMaps2.f1329d);
                    break;
                case 3:
                    m1204a(arrayMap, arrayMap2, transitionValuesMaps.f1327b, transitionValuesMaps2.f1327b);
                    break;
                case 4:
                    m1203a(arrayMap, arrayMap2, transitionValuesMaps.f1328c, transitionValuesMaps2.f1328c);
                    break;
            }
        }
        m1208b(arrayMap, arrayMap2);
    }

    /* JADX INFO: renamed from: a */
    protected void mo1221a(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        Animator animatorMo405a;
        View view;
        TransitionValues transitionValues;
        Animator animator;
        Animator animator2;
        ArrayMap<Animator, AnimationInfo> arrayMapM1211p = m1211p();
        long jMin = Long.MAX_VALUE;
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            TransitionValues transitionValues2 = arrayList.get(i2);
            TransitionValues transitionValues3 = arrayList2.get(i2);
            TransitionValues transitionValues4 = (transitionValues2 == null || transitionValues2.f1325c.contains(this)) ? transitionValues2 : null;
            TransitionValues transitionValues5 = (transitionValues3 == null || transitionValues3.f1325c.contains(this)) ? transitionValues3 : null;
            if (transitionValues4 != null || transitionValues5 != null) {
                if ((transitionValues4 == null || transitionValues5 == null || mo1224a(transitionValues4, transitionValues5)) && (animatorMo405a = mo405a(viewGroup, transitionValues4, transitionValues5)) != null) {
                    TransitionValues transitionValues6 = null;
                    if (transitionValues5 != null) {
                        View view2 = transitionValues5.f1324b;
                        String[] strArrMo1075a = mo1075a();
                        if (view2 != null && strArrMo1075a != null && strArrMo1075a.length > 0) {
                            TransitionValues transitionValues7 = new TransitionValues();
                            transitionValues7.f1324b = view2;
                            TransitionValues transitionValues8 = transitionValuesMaps2.f1326a.get(view2);
                            if (transitionValues8 != null) {
                                for (int i3 = 0; i3 < strArrMo1075a.length; i3++) {
                                    transitionValues7.f1323a.put(strArrMo1075a[i3], transitionValues8.f1323a.get(strArrMo1075a[i3]));
                                }
                            }
                            int size2 = arrayMapM1211p.size();
                            int i4 = 0;
                            while (true) {
                                if (i4 >= size2) {
                                    transitionValues6 = transitionValues7;
                                    animator2 = animatorMo405a;
                                    break;
                                }
                                AnimationInfo animationInfo = arrayMapM1211p.get(arrayMapM1211p.m2452b(i4));
                                if (animationInfo.f1303c == null || animationInfo.f1301a != view2 || !animationInfo.f1302b.equals(m1248o()) || !animationInfo.f1303c.equals(transitionValues7)) {
                                    i4++;
                                } else {
                                    animator2 = null;
                                    transitionValues6 = transitionValues7;
                                    break;
                                }
                            }
                        } else {
                            animator2 = animatorMo405a;
                        }
                        transitionValues = transitionValues6;
                        animator = animator2;
                        view = view2;
                    } else {
                        view = transitionValues4.f1324b;
                        transitionValues = null;
                        animator = animatorMo405a;
                    }
                    if (animator != null) {
                        if (this.f1280f != null) {
                            long jMo1126a = this.f1280f.mo1126a(viewGroup, this, transitionValues4, transitionValues5);
                            sparseIntArray.put(this.f1271G.size(), (int) jMo1126a);
                            jMin = Math.min(jMo1126a, jMin);
                        }
                        arrayMapM1211p.put(animator, new AnimationInfo(view, m1248o(), this, ViewUtils.m1303b(viewGroup), transitionValues));
                        this.f1271G.add(animator);
                    }
                }
            }
            i = i2 + 1;
        }
        if (jMin != 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 < sparseIntArray.size()) {
                    Animator animator3 = this.f1271G.get(sparseIntArray.keyAt(i6));
                    animator3.setStartDelay((((long) sparseIntArray.valueAt(i6)) - jMin) + animator3.getStartDelay());
                    i5 = i6 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    boolean m1230b(View view) {
        int id = view.getId();
        if (this.f1286n != null && this.f1286n.contains(Integer.valueOf(id))) {
            return false;
        }
        if (this.f1287o != null && this.f1287o.contains(view)) {
            return false;
        }
        if (this.f1288p != null) {
            int size = this.f1288p.size();
            for (int i = 0; i < size; i++) {
                if (this.f1288p.get(i).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f1289q != null && ViewCompat.m2611o(view) != null && this.f1289q.contains(ViewCompat.m2611o(view))) {
            return false;
        }
        if (this.f1276b.size() == 0 && this.f1277c.size() == 0 && ((this.f1285m == null || this.f1285m.isEmpty()) && (this.f1284l == null || this.f1284l.isEmpty()))) {
            return true;
        }
        if (this.f1276b.contains(Integer.valueOf(id)) || this.f1277c.contains(view)) {
            return true;
        }
        if (this.f1284l != null && this.f1284l.contains(ViewCompat.m2611o(view))) {
            return true;
        }
        if (this.f1285m == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.f1285m.size(); i2++) {
            if (this.f1285m.get(i2).isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: p */
    private static ArrayMap<Animator, AnimationInfo> m1211p() {
        ArrayMap<Animator, AnimationInfo> arrayMap = f1264z.get();
        if (arrayMap == null) {
            ArrayMap<Animator, AnimationInfo> arrayMap2 = new ArrayMap<>();
            f1264z.set(arrayMap2);
            return arrayMap2;
        }
        return arrayMap;
    }

    /* JADX INFO: renamed from: e */
    protected void mo1236e() {
        m1243j();
        ArrayMap<Animator, AnimationInfo> arrayMapM1211p = m1211p();
        for (Animator animator : this.f1271G) {
            if (arrayMapM1211p.containsKey(animator)) {
                m1243j();
                m1198a(animator, arrayMapM1211p);
            }
        }
        this.f1271G.clear();
        m1244k();
    }

    /* JADX INFO: renamed from: a */
    private void m1198a(Animator animator, final ArrayMap<Animator, AnimationInfo> arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.Transition.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    Transition.this.f1266B.add(animator2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    arrayMap.remove(animator2);
                    Transition.this.f1266B.remove(animator2);
                }
            });
            m1217a(animator);
        }
    }

    /* JADX INFO: renamed from: c */
    public Transition mo1232c(View view) {
        this.f1277c.add(view);
        return this;
    }

    /* JADX INFO: renamed from: d */
    public Transition mo1235d(View view) {
        this.f1277c.remove(view);
        return this;
    }

    /* JADX INFO: renamed from: f */
    public List<Integer> m1238f() {
        return this.f1276b;
    }

    /* JADX INFO: renamed from: g */
    public List<View> m1240g() {
        return this.f1277c;
    }

    /* JADX INFO: renamed from: h */
    public List<String> m1241h() {
        return this.f1284l;
    }

    /* JADX INFO: renamed from: i */
    public List<Class> m1242i() {
        return this.f1285m;
    }

    /* JADX INFO: renamed from: a */
    void m1222a(ViewGroup viewGroup, boolean z) {
        m1229b(z);
        if ((this.f1276b.size() > 0 || this.f1277c.size() > 0) && ((this.f1284l == null || this.f1284l.isEmpty()) && (this.f1285m == null || this.f1285m.isEmpty()))) {
            for (int i = 0; i < this.f1276b.size(); i++) {
                View viewFindViewById = viewGroup.findViewById(this.f1276b.get(i).intValue());
                if (viewFindViewById != null) {
                    TransitionValues transitionValues = new TransitionValues();
                    transitionValues.f1324b = viewFindViewById;
                    if (z) {
                        mo406a(transitionValues);
                    } else {
                        mo407b(transitionValues);
                    }
                    transitionValues.f1325c.add(this);
                    mo1233c(transitionValues);
                    if (z) {
                        m1200a(this.f1293u, viewFindViewById, transitionValues);
                    } else {
                        m1200a(this.f1294v, viewFindViewById, transitionValues);
                    }
                }
            }
            for (int i2 = 0; i2 < this.f1277c.size(); i2++) {
                View view = this.f1277c.get(i2);
                TransitionValues transitionValues2 = new TransitionValues();
                transitionValues2.f1324b = view;
                if (z) {
                    mo406a(transitionValues2);
                } else {
                    mo407b(transitionValues2);
                }
                transitionValues2.f1325c.add(this);
                mo1233c(transitionValues2);
                if (z) {
                    m1200a(this.f1293u, view, transitionValues2);
                } else {
                    m1200a(this.f1294v, view, transitionValues2);
                }
            }
        } else {
            m1210c(viewGroup, z);
        }
        if (!z && this.f1273I != null) {
            int size = this.f1273I.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(this.f1293u.f1329d.remove(this.f1273I.m2452b(i3)));
            }
            for (int i4 = 0; i4 < size; i4++) {
                View view2 = (View) arrayList.get(i4);
                if (view2 != null) {
                    this.f1293u.f1329d.put(this.f1273I.m2453c(i4), view2);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m1200a(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues transitionValues) {
        transitionValuesMaps.f1326a.put(view, transitionValues);
        int id = view.getId();
        if (id >= 0) {
            if (transitionValuesMaps.f1327b.indexOfKey(id) >= 0) {
                transitionValuesMaps.f1327b.put(id, null);
            } else {
                transitionValuesMaps.f1327b.put(id, view);
            }
        }
        String strM2611o = ViewCompat.m2611o(view);
        if (strM2611o != null) {
            if (transitionValuesMaps.f1329d.containsKey(strM2611o)) {
                transitionValuesMaps.f1329d.put(strM2611o, null);
            } else {
                transitionValuesMaps.f1329d.put(strM2611o, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (transitionValuesMaps.f1328c.m2413c(itemIdAtPosition) >= 0) {
                    View viewM2406a = transitionValuesMaps.f1328c.m2406a(itemIdAtPosition);
                    if (viewM2406a != null) {
                        ViewCompat.m2589a(viewM2406a, false);
                        transitionValuesMaps.f1328c.m2412b(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                ViewCompat.m2589a(view, true);
                transitionValuesMaps.f1328c.m2412b(itemIdAtPosition, view);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    void m1229b(boolean z) {
        if (z) {
            this.f1293u.f1326a.clear();
            this.f1293u.f1327b.clear();
            this.f1293u.f1328c.m2415c();
        } else {
            this.f1294v.f1326a.clear();
            this.f1294v.f1327b.clear();
            this.f1294v.f1328c.m2415c();
        }
    }

    /* JADX INFO: renamed from: c */
    private void m1210c(View view, boolean z) {
        if (view != null) {
            int id = view.getId();
            if (this.f1286n == null || !this.f1286n.contains(Integer.valueOf(id))) {
                if (this.f1287o == null || !this.f1287o.contains(view)) {
                    if (this.f1288p != null) {
                        int size = this.f1288p.size();
                        for (int i = 0; i < size; i++) {
                            if (this.f1288p.get(i).isInstance(view)) {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        TransitionValues transitionValues = new TransitionValues();
                        transitionValues.f1324b = view;
                        if (z) {
                            mo406a(transitionValues);
                        } else {
                            mo407b(transitionValues);
                        }
                        transitionValues.f1325c.add(this);
                        mo1233c(transitionValues);
                        if (z) {
                            m1200a(this.f1293u, view, transitionValues);
                        } else {
                            m1200a(this.f1294v, view, transitionValues);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        if (this.f1290r == null || !this.f1290r.contains(Integer.valueOf(id))) {
                            if (this.f1291s == null || !this.f1291s.contains(view)) {
                                if (this.f1292t != null) {
                                    int size2 = this.f1292t.size();
                                    for (int i2 = 0; i2 < size2; i2++) {
                                        if (this.f1292t.get(i2).isInstance(view)) {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                    m1210c(viewGroup.getChildAt(i3), z);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public TransitionValues m1215a(View view, boolean z) {
        if (this.f1278d != null) {
            return this.f1278d.m1215a(view, z);
        }
        return (z ? this.f1293u : this.f1294v).f1326a.get(view);
    }

    /* JADX INFO: renamed from: b */
    TransitionValues m1228b(View view, boolean z) {
        TransitionValues transitionValues;
        if (this.f1278d != null) {
            return this.f1278d.m1228b(view, z);
        }
        ArrayList<TransitionValues> arrayList = z ? this.f1296x : this.f1297y;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            TransitionValues transitionValues2 = arrayList.get(i);
            if (transitionValues2 == null) {
                return null;
            }
            if (transitionValues2.f1324b == view) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            transitionValues = (z ? this.f1297y : this.f1296x).get(i);
        } else {
            transitionValues = null;
        }
        return transitionValues;
    }

    /* JADX INFO: renamed from: e */
    public void mo1237e(View view) {
        if (!this.f1269E) {
            ArrayMap<Animator, AnimationInfo> arrayMapM1211p = m1211p();
            int size = arrayMapM1211p.size();
            WindowIdImpl windowIdImplM1303b = ViewUtils.m1303b(view);
            for (int i = size - 1; i >= 0; i--) {
                AnimationInfo animationInfoC = arrayMapM1211p.m2453c(i);
                if (animationInfoC.f1301a != null && windowIdImplM1303b.equals(animationInfoC.f1304d)) {
                    AnimatorUtils.m1060a(arrayMapM1211p.m2452b(i));
                }
            }
            if (this.f1270F != null && this.f1270F.size() > 0) {
                ArrayList arrayList = (ArrayList) this.f1270F.clone();
                int size2 = arrayList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((TransitionListener) arrayList.get(i2)).mo1089b(this);
                }
            }
            this.f1268D = true;
        }
    }

    /* JADX INFO: renamed from: f */
    public void mo1239f(View view) {
        if (this.f1268D) {
            if (!this.f1269E) {
                ArrayMap<Animator, AnimationInfo> arrayMapM1211p = m1211p();
                int size = arrayMapM1211p.size();
                WindowIdImpl windowIdImplM1303b = ViewUtils.m1303b(view);
                for (int i = size - 1; i >= 0; i--) {
                    AnimationInfo animationInfoC = arrayMapM1211p.m2453c(i);
                    if (animationInfoC.f1301a != null && windowIdImplM1303b.equals(animationInfoC.f1304d)) {
                        AnimatorUtils.m1062b(arrayMapM1211p.m2452b(i));
                    }
                }
                if (this.f1270F != null && this.f1270F.size() > 0) {
                    ArrayList arrayList = (ArrayList) this.f1270F.clone();
                    int size2 = arrayList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((TransitionListener) arrayList.get(i2)).mo1090c(this);
                    }
                }
            }
            this.f1268D = false;
        }
    }

    /* JADX INFO: renamed from: a */
    void m1220a(ViewGroup viewGroup) {
        AnimationInfo animationInfo;
        this.f1296x = new ArrayList<>();
        this.f1297y = new ArrayList<>();
        m1199a(this.f1293u, this.f1294v);
        ArrayMap<Animator, AnimationInfo> arrayMapM1211p = m1211p();
        int size = arrayMapM1211p.size();
        WindowIdImpl windowIdImplM1303b = ViewUtils.m1303b(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator animatorB = arrayMapM1211p.m2452b(i);
            if (animatorB != null && (animationInfo = arrayMapM1211p.get(animatorB)) != null && animationInfo.f1301a != null && windowIdImplM1303b.equals(animationInfo.f1304d)) {
                TransitionValues transitionValues = animationInfo.f1303c;
                View view = animationInfo.f1301a;
                TransitionValues transitionValuesM1215a = m1215a(view, true);
                TransitionValues transitionValuesM1228b = m1228b(view, true);
                if (!(transitionValuesM1215a == null && transitionValuesM1228b == null) && animationInfo.f1305e.mo1224a(transitionValues, transitionValuesM1228b)) {
                    if (animatorB.isRunning() || animatorB.isStarted()) {
                        animatorB.cancel();
                    } else {
                        arrayMapM1211p.remove(animatorB);
                    }
                }
            }
        }
        mo1221a(viewGroup, this.f1293u, this.f1294v, this.f1296x, this.f1297y);
        mo1236e();
    }

    /* JADX INFO: renamed from: a */
    public boolean mo1224a(TransitionValues transitionValues, TransitionValues transitionValues2) {
        boolean z;
        if (transitionValues == null || transitionValues2 == null) {
            return false;
        }
        String[] strArrMo1075a = mo1075a();
        if (strArrMo1075a != null) {
            int length = strArrMo1075a.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                }
                if (m1206a(transitionValues, transitionValues2, strArrMo1075a[i])) {
                    z = true;
                    break;
                }
                i++;
            }
            return z;
        }
        Iterator<String> it = transitionValues.f1323a.keySet().iterator();
        while (it.hasNext()) {
            if (m1206a(transitionValues, transitionValues2, it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1206a(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        Object obj = transitionValues.f1323a.get(str);
        Object obj2 = transitionValues2.f1323a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        return obj == null || obj2 == null || !obj.equals(obj2);
    }

    /* JADX INFO: renamed from: a */
    protected void m1217a(Animator animator) {
        if (animator == null) {
            m1244k();
            return;
        }
        if (m1225b() >= 0) {
            animator.setDuration(m1225b());
        }
        if (m1231c() >= 0) {
            animator.setStartDelay(m1231c());
        }
        if (m1234d() != null) {
            animator.setInterpolator(m1234d());
        }
        animator.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.Transition.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                Transition.this.m1244k();
                animator2.removeListener(this);
            }
        });
        animator.start();
    }

    /* JADX INFO: renamed from: j */
    protected void m1243j() {
        if (this.f1267C == 0) {
            if (this.f1270F != null && this.f1270F.size() > 0) {
                ArrayList arrayList = (ArrayList) this.f1270F.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((TransitionListener) arrayList.get(i)).mo1154d(this);
                }
            }
            this.f1269E = false;
        }
        this.f1267C++;
    }

    /* JADX INFO: renamed from: k */
    protected void m1244k() {
        this.f1267C--;
        if (this.f1267C == 0) {
            if (this.f1270F != null && this.f1270F.size() > 0) {
                ArrayList arrayList = (ArrayList) this.f1270F.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((TransitionListener) arrayList.get(i)).mo1088a(this);
                }
            }
            for (int i2 = 0; i2 < this.f1293u.f1328c.m2409b(); i2++) {
                View viewM2414c = this.f1293u.f1328c.m2414c(i2);
                if (viewM2414c != null) {
                    ViewCompat.m2589a(viewM2414c, false);
                }
            }
            for (int i3 = 0; i3 < this.f1294v.f1328c.m2409b(); i3++) {
                View viewM2414c2 = this.f1294v.f1328c.m2414c(i3);
                if (viewM2414c2 != null) {
                    ViewCompat.m2589a(viewM2414c2, false);
                }
            }
            this.f1269E = true;
        }
    }

    /* JADX INFO: renamed from: a */
    public Transition mo1214a(TransitionListener transitionListener) {
        if (this.f1270F == null) {
            this.f1270F = new ArrayList<>();
        }
        this.f1270F.add(transitionListener);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public Transition mo1227b(TransitionListener transitionListener) {
        if (this.f1270F != null) {
            this.f1270F.remove(transitionListener);
            if (this.f1270F.size() == 0) {
                this.f1270F = null;
            }
        }
        return this;
    }

    /* JADX INFO: renamed from: l */
    public PathMotion m1245l() {
        return this.f1274J;
    }

    /* JADX INFO: renamed from: a */
    public void mo1218a(EpicenterCallback epicenterCallback) {
        this.f1272H = epicenterCallback;
    }

    /* JADX INFO: renamed from: m */
    public Rect m1246m() {
        if (this.f1272H == null) {
            return null;
        }
        return this.f1272H.mo1153a(this);
    }

    /* JADX INFO: renamed from: a */
    public void mo1219a(TransitionPropagation transitionPropagation) {
        this.f1280f = transitionPropagation;
    }

    /* JADX INFO: renamed from: c */
    void mo1233c(TransitionValues transitionValues) {
        String[] strArrMo1256a;
        boolean z = false;
        if (this.f1280f != null && !transitionValues.f1323a.isEmpty() && (strArrMo1256a = this.f1280f.mo1256a()) != null) {
            int i = 0;
            while (true) {
                if (i >= strArrMo1256a.length) {
                    z = true;
                    break;
                } else if (!transitionValues.f1323a.containsKey(strArrMo1256a[i])) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                this.f1280f.mo1255a(transitionValues);
            }
        }
    }

    public String toString() {
        return mo1216a("");
    }

    @Override // 
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.f1271G = new ArrayList<>();
            transition.f1293u = new TransitionValuesMaps();
            transition.f1294v = new TransitionValuesMaps();
            transition.f1296x = null;
            transition.f1297y = null;
            return transition;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /* JADX INFO: renamed from: o */
    public String m1248o() {
        return this.f1281i;
    }

    /* JADX INFO: renamed from: a */
    String mo1216a(String str) {
        String str2;
        String str3 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f1275a != -1) {
            str3 = str3 + "dur(" + this.f1275a + ") ";
        }
        if (this.f1282j != -1) {
            str3 = str3 + "dly(" + this.f1282j + ") ";
        }
        if (this.f1283k != null) {
            str3 = str3 + "interp(" + this.f1283k + ") ";
        }
        if (this.f1276b.size() > 0 || this.f1277c.size() > 0) {
            String str4 = str3 + "tgts(";
            if (this.f1276b.size() > 0) {
                str2 = str4;
                for (int i = 0; i < this.f1276b.size(); i++) {
                    if (i > 0) {
                        str2 = str2 + ", ";
                    }
                    str2 = str2 + this.f1276b.get(i);
                }
            } else {
                str2 = str4;
            }
            if (this.f1277c.size() > 0) {
                for (int i2 = 0; i2 < this.f1277c.size(); i2++) {
                    if (i2 > 0) {
                        str2 = str2 + ", ";
                    }
                    str2 = str2 + this.f1277c.get(i2);
                }
            }
            return str2 + ")";
        }
        return str3;
    }

    private static class AnimationInfo {

        /* JADX INFO: renamed from: a */
        View f1301a;

        /* JADX INFO: renamed from: b */
        String f1302b;

        /* JADX INFO: renamed from: c */
        TransitionValues f1303c;

        /* JADX INFO: renamed from: d */
        WindowIdImpl f1304d;

        /* JADX INFO: renamed from: e */
        Transition f1305e;

        AnimationInfo(View view, String str, Transition transition, WindowIdImpl windowIdImpl, TransitionValues transitionValues) {
            this.f1301a = view;
            this.f1302b = str;
            this.f1303c = transitionValues;
            this.f1304d = windowIdImpl;
            this.f1305e = transition;
        }
    }
}

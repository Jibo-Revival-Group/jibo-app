package android.support.v4.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.arch.lifecycle.ViewModelStore;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.ArraySet;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import com.yalantis.ucrop.view.CropImageView;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: FragmentManager.java */
/* JADX INFO: loaded from: classes.dex */
final class FragmentManagerImpl extends FragmentManager implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: B */
    ArrayList<StartEnterTransitionListener> f1484B;

    /* JADX INFO: renamed from: C */
    FragmentManagerNonConfig f1485C;

    /* JADX INFO: renamed from: b */
    ArrayList<OpGenerator> f1488b;

    /* JADX INFO: renamed from: c */
    boolean f1489c;

    /* JADX INFO: renamed from: f */
    SparseArray<Fragment> f1492f;

    /* JADX INFO: renamed from: g */
    ArrayList<BackStackRecord> f1493g;

    /* JADX INFO: renamed from: h */
    ArrayList<Fragment> f1494h;

    /* JADX INFO: renamed from: i */
    ArrayList<BackStackRecord> f1495i;

    /* JADX INFO: renamed from: j */
    ArrayList<Integer> f1496j;

    /* JADX INFO: renamed from: k */
    ArrayList<FragmentManager.OnBackStackChangedListener> f1497k;

    /* JADX INFO: renamed from: m */
    FragmentHostCallback f1499m;

    /* JADX INFO: renamed from: n */
    FragmentContainer f1500n;

    /* JADX INFO: renamed from: o */
    Fragment f1501o;

    /* JADX INFO: renamed from: p */
    Fragment f1502p;

    /* JADX INFO: renamed from: r */
    boolean f1503r;

    /* JADX INFO: renamed from: s */
    boolean f1504s;

    /* JADX INFO: renamed from: t */
    boolean f1505t;

    /* JADX INFO: renamed from: u */
    String f1506u;

    /* JADX INFO: renamed from: v */
    boolean f1507v;

    /* JADX INFO: renamed from: w */
    ArrayList<BackStackRecord> f1508w;

    /* JADX INFO: renamed from: x */
    ArrayList<Boolean> f1509x;

    /* JADX INFO: renamed from: y */
    ArrayList<Fragment> f1510y;

    /* JADX INFO: renamed from: a */
    static boolean f1481a = false;

    /* JADX INFO: renamed from: q */
    static Field f1482q = null;

    /* JADX INFO: renamed from: E */
    static final Interpolator f1477E = new DecelerateInterpolator(2.5f);

    /* JADX INFO: renamed from: F */
    static final Interpolator f1478F = new DecelerateInterpolator(1.5f);

    /* JADX INFO: renamed from: G */
    static final Interpolator f1479G = new AccelerateInterpolator(2.5f);

    /* JADX INFO: renamed from: H */
    static final Interpolator f1480H = new AccelerateInterpolator(1.5f);

    /* JADX INFO: renamed from: d */
    int f1490d = 0;

    /* JADX INFO: renamed from: e */
    final ArrayList<Fragment> f1491e = new ArrayList<>();

    /* JADX INFO: renamed from: I */
    private final CopyOnWriteArrayList<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> f1487I = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: l */
    int f1498l = 0;

    /* JADX INFO: renamed from: z */
    Bundle f1511z = null;

    /* JADX INFO: renamed from: A */
    SparseArray<Parcelable> f1483A = null;

    /* JADX INFO: renamed from: D */
    Runnable f1486D = new Runnable() { // from class: android.support.v4.app.FragmentManagerImpl.1
        @Override // java.lang.Runnable
        public void run() {
            FragmentManagerImpl.this.m1579i();
        }
    };

    /* JADX INFO: compiled from: FragmentManager.java */
    static class FragmentTag {

        /* JADX INFO: renamed from: a */
        public static final int[] f1535a = {R.attr.name, R.attr.id, R.attr.tag};
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    interface OpGenerator {
        /* JADX INFO: renamed from: a */
        boolean mo1375a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2);
    }

    FragmentManagerImpl() {
    }

    /* JADX INFO: renamed from: a */
    static boolean m1519a(AnimationOrAnimator animationOrAnimator) {
        if (animationOrAnimator.f1528a instanceof AlphaAnimation) {
            return true;
        }
        if (animationOrAnimator.f1528a instanceof AnimationSet) {
            List<Animation> animations = ((AnimationSet) animationOrAnimator.f1528a).getAnimations();
            for (int i = 0; i < animations.size(); i++) {
                if (animations.get(i) instanceof AlphaAnimation) {
                    return true;
                }
            }
            return false;
        }
        return m1518a(animationOrAnimator.f1529b);
    }

    /* JADX INFO: renamed from: a */
    static boolean m1518a(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            for (PropertyValuesHolder propertyValuesHolder : ((ValueAnimator) animator).getValues()) {
                if ("alpha".equals(propertyValuesHolder.getPropertyName())) {
                    return true;
                }
            }
            return false;
        }
        if (!(animator instanceof AnimatorSet)) {
            return false;
        }
        ArrayList<Animator> childAnimations = ((AnimatorSet) animator).getChildAnimations();
        for (int i = 0; i < childAnimations.size(); i++) {
            if (m1518a(childAnimations.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    static boolean m1520a(View view, AnimationOrAnimator animationOrAnimator) {
        return view != null && animationOrAnimator != null && Build.VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && ViewCompat.m2615s(view) && m1519a(animationOrAnimator);
    }

    /* JADX INFO: renamed from: a */
    private void m1515a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
        if (this.f1499m != null) {
            try {
                this.f1499m.mo1426a("  ", (FileDescriptor) null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
                throw runtimeException;
            }
        }
        try {
            mo1474a("  ", (FileDescriptor) null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e2) {
            Log.e("FragmentManager", "Failed dumping state", e2);
            throw runtimeException;
        }
    }

    @Override // android.support.v4.app.FragmentManager
    /* JADX INFO: renamed from: a */
    public FragmentTransaction mo1471a() {
        return new BackStackRecord(this);
    }

    @Override // android.support.v4.app.FragmentManager
    /* JADX INFO: renamed from: b */
    public boolean mo1477b() {
        boolean zM1579i = m1579i();
        m1502E();
        return zM1579i;
    }

    @Override // android.support.v4.app.FragmentManager
    /* JADX INFO: renamed from: c */
    public void mo1479c() {
        m1545a((OpGenerator) new PopBackStackState(null, -1, 0), false);
    }

    @Override // android.support.v4.app.FragmentManager
    /* JADX INFO: renamed from: d */
    public boolean mo1480d() {
        m1499B();
        return m1521a((String) null, -1, 0);
    }

    @Override // android.support.v4.app.FragmentManager
    /* JADX INFO: renamed from: a */
    public boolean mo1475a(String str, int i) {
        m1499B();
        return m1521a(str, -1, i);
    }

    @Override // android.support.v4.app.FragmentManager
    /* JADX INFO: renamed from: a */
    public void mo1472a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        m1545a((OpGenerator) new PopBackStackState(null, i, i2), false);
    }

    @Override // android.support.v4.app.FragmentManager
    /* JADX INFO: renamed from: b */
    public boolean mo1478b(int i, int i2) {
        m1499B();
        m1579i();
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        return m1521a((String) null, i, i2);
    }

    /* JADX INFO: renamed from: a */
    private boolean m1521a(String str, int i, int i2) {
        FragmentManager fragmentManagerPeekChildFragmentManager;
        m1579i();
        m1527c(true);
        if (this.f1502p != null && i < 0 && str == null && (fragmentManagerPeekChildFragmentManager = this.f1502p.peekChildFragmentManager()) != null && fragmentManagerPeekChildFragmentManager.mo1480d()) {
            return true;
        }
        boolean zM1550a = m1550a(this.f1508w, this.f1509x, str, i, i2);
        if (zM1550a) {
            this.f1489c = true;
            try {
                m1525b(this.f1508w, this.f1509x);
            } finally {
                m1501D();
            }
        }
        m1580j();
        m1504G();
        return zM1550a;
    }

    @Override // android.support.v4.app.FragmentManager
    /* JADX INFO: renamed from: e */
    public int mo1481e() {
        if (this.f1493g != null) {
            return this.f1493g.size();
        }
        return 0;
    }

    @Override // android.support.v4.app.FragmentManager
    /* JADX INFO: renamed from: b */
    public FragmentManager.BackStackEntry mo1476b(int i) {
        return this.f1493g.get(i);
    }

    @Override // android.support.v4.app.FragmentManager
    /* JADX INFO: renamed from: a */
    public void mo1473a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mIndex < 0) {
            m1515a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.mIndex);
    }

    @Override // android.support.v4.app.FragmentManager
    /* JADX INFO: renamed from: a */
    public Fragment mo1469a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        Fragment fragment = this.f1492f.get(i);
        if (fragment == null) {
            m1515a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
            return fragment;
        }
        return fragment;
    }

    @Override // android.support.v4.app.FragmentManager
    /* JADX INFO: renamed from: f */
    public List<Fragment> mo1482f() {
        List<Fragment> list;
        if (this.f1491e.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.f1491e) {
            list = (List) this.f1491e.clone();
        }
        return list;
    }

    @Override // android.support.v4.app.FragmentManager
    /* JADX INFO: renamed from: a */
    public Fragment.SavedState mo1467a(Fragment fragment) {
        Bundle bundleM1590o;
        if (fragment.mIndex < 0) {
            m1515a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.mState <= 0 || (bundleM1590o = m1590o(fragment)) == null) {
            return null;
        }
        return new Fragment.SavedState(bundleM1590o);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (this.f1501o != null) {
            DebugUtils.m2402a(this.f1501o, sb);
        } else {
            DebugUtils.m2402a(this.f1499m, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    @Override // android.support.v4.app.FragmentManager
    /* JADX INFO: renamed from: a */
    public void mo1474a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        String str2 = str + "    ";
        if (this.f1492f != null && (size5 = this.f1492f.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size5; i++) {
                Fragment fragmentValueAt = this.f1492f.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragmentValueAt);
                if (fragmentValueAt != null) {
                    fragmentValueAt.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size6 = this.f1491e.size();
        if (size6 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size6; i2++) {
                Fragment fragment = this.f1491e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        if (this.f1494h != null && (size4 = this.f1494h.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                Fragment fragment2 = this.f1494h.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        if (this.f1493g != null && (size3 = this.f1493g.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                BackStackRecord backStackRecord = this.f1493g.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.m1372a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.f1495i != null && (size2 = this.f1495i.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    Object obj = (BackStackRecord) this.f1495i.get(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            if (this.f1496j != null && this.f1496j.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f1496j.toArray()));
            }
        }
        if (this.f1488b != null && (size = this.f1488b.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                Object obj2 = (OpGenerator) this.f1488b.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(obj2);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f1499m);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f1500n);
        if (this.f1501o != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f1501o);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f1498l);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f1504s);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f1505t);
        if (this.f1503r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f1503r);
        }
        if (this.f1506u != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f1506u);
        }
    }

    /* JADX INFO: renamed from: a */
    static AnimationOrAnimator m1507a(Context context, float f, float f2, float f3, float f4) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f1477E);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(f1478F);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new AnimationOrAnimator(animationSet);
    }

    /* JADX INFO: renamed from: a */
    static AnimationOrAnimator m1506a(Context context, float f, float f2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f1478F);
        alphaAnimation.setDuration(220L);
        return new AnimationOrAnimator(alphaAnimation);
    }

    /* JADX INFO: renamed from: a */
    AnimationOrAnimator m1534a(Fragment fragment, int i, boolean z, int i2) {
        int iM1522b;
        boolean z2;
        int nextAnim = fragment.getNextAnim();
        Animation animationOnCreateAnimation = fragment.onCreateAnimation(i, z, nextAnim);
        if (animationOnCreateAnimation != null) {
            return new AnimationOrAnimator(animationOnCreateAnimation);
        }
        Animator animatorOnCreateAnimator = fragment.onCreateAnimator(i, z, nextAnim);
        if (animatorOnCreateAnimator != null) {
            return new AnimationOrAnimator(animatorOnCreateAnimator);
        }
        if (nextAnim != 0) {
            boolean zEquals = "anim".equals(this.f1499m.m1464i().getResources().getResourceTypeName(nextAnim));
            if (!zEquals) {
                z2 = false;
            } else {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.f1499m.m1464i(), nextAnim);
                    if (animationLoadAnimation != null) {
                        return new AnimationOrAnimator(animationLoadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e) {
                    throw e;
                } catch (RuntimeException e2) {
                    z2 = false;
                }
            }
            if (!z2) {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(this.f1499m.m1464i(), nextAnim);
                    if (animatorLoadAnimator != null) {
                        return new AnimationOrAnimator(animatorLoadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (zEquals) {
                        throw e3;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(this.f1499m.m1464i(), nextAnim);
                    if (animationLoadAnimation2 != null) {
                        return new AnimationOrAnimator(animationLoadAnimation2);
                    }
                }
            }
        }
        if (i != 0 && (iM1522b = m1522b(i, z)) >= 0) {
            switch (iM1522b) {
                case 1:
                    return m1507a(this.f1499m.m1464i(), 1.125f, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                case 2:
                    return m1507a(this.f1499m.m1464i(), 1.0f, 0.975f, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO);
                case 3:
                    return m1507a(this.f1499m.m1464i(), 0.975f, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                case 4:
                    return m1507a(this.f1499m.m1464i(), 1.0f, 1.075f, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO);
                case 5:
                    return m1506a(this.f1499m.m1464i(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
                case 6:
                    return m1506a(this.f1499m.m1464i(), 1.0f, CropImageView.DEFAULT_ASPECT_RATIO);
                default:
                    if (i2 == 0 && this.f1499m.mo1433e()) {
                        i2 = this.f1499m.mo1434f();
                    }
                    return i2 == 0 ? null : null;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public void m1553b(Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.f1489c) {
                this.f1507v = true;
            } else {
                fragment.mDeferStart = false;
                m1539a(fragment, this.f1498l, 0, 0, false);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m1524b(View view, AnimationOrAnimator animationOrAnimator) {
        if (view != null && animationOrAnimator != null && m1520a(view, animationOrAnimator)) {
            if (animationOrAnimator.f1529b != null) {
                animationOrAnimator.f1529b.addListener(new AnimatorOnHWLayerIfNeededListener(view));
                return;
            }
            Animation.AnimationListener animationListenerM1508a = m1508a(animationOrAnimator.f1528a);
            view.setLayerType(2, null);
            animationOrAnimator.f1528a.setAnimationListener(new AnimateOnHWLayerIfNeededListener(view, animationListenerM1508a));
        }
    }

    /* JADX INFO: renamed from: a */
    private static Animation.AnimationListener m1508a(Animation animation) {
        try {
            if (f1482q == null) {
                f1482q = Animation.class.getDeclaredField("mListener");
                f1482q.setAccessible(true);
            }
            return (Animation.AnimationListener) f1482q.get(animation);
        } catch (IllegalAccessException e) {
            Log.e("FragmentManager", "Cannot access Animation's mListener field", e);
            return null;
        } catch (NoSuchFieldException e2) {
            Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e2);
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    boolean m1564c(int i) {
        return this.f1498l >= i;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX INFO: renamed from: a */
    void m1539a(android.support.v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
            Method dump skipped, instruction units count: 1216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.m1539a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    /* JADX INFO: renamed from: a */
    private void m1510a(final Fragment fragment, AnimationOrAnimator animationOrAnimator, int i) {
        final View view = fragment.mView;
        final ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        fragment.setStateAfterAnimating(i);
        if (animationOrAnimator.f1528a != null) {
            EndViewTransitionAnimator endViewTransitionAnimator = new EndViewTransitionAnimator(animationOrAnimator.f1528a, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            endViewTransitionAnimator.setAnimationListener(new AnimationListenerWrapper(m1508a(endViewTransitionAnimator)) { // from class: android.support.v4.app.FragmentManagerImpl.2
                @Override // android.support.v4.app.FragmentManagerImpl.AnimationListenerWrapper, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    viewGroup.post(new Runnable() { // from class: android.support.v4.app.FragmentManagerImpl.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (fragment.getAnimatingAway() != null) {
                                fragment.setAnimatingAway(null);
                                FragmentManagerImpl.this.m1539a(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                            }
                        }
                    });
                }
            });
            m1524b(view, animationOrAnimator);
            fragment.mView.startAnimation(endViewTransitionAnimator);
            return;
        }
        Animator animator = animationOrAnimator.f1529b;
        fragment.setAnimator(animationOrAnimator.f1529b);
        animator.addListener(new AnimatorListenerAdapter() { // from class: android.support.v4.app.FragmentManagerImpl.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                viewGroup.endViewTransition(view);
                Animator animator3 = fragment.getAnimator();
                fragment.setAnimator(null);
                if (animator3 != null && viewGroup.indexOfChild(view) < 0) {
                    FragmentManagerImpl.this.m1539a(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                }
            }
        });
        animator.setTarget(fragment.mView);
        m1524b(fragment.mView, animationOrAnimator);
        animator.start();
    }

    /* JADX INFO: renamed from: c */
    void m1561c(Fragment fragment) {
        m1539a(fragment, this.f1498l, 0, 0, false);
    }

    /* JADX INFO: renamed from: d */
    void m1566d(Fragment fragment) {
        if (fragment.mFromLayout && !fragment.mPerformedCreateView) {
            fragment.mView = fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
            if (fragment.mView != null) {
                fragment.mInnerView = fragment.mView;
                fragment.mView.setSaveFromParentEnabled(false);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                m1542a(fragment, fragment.mView, fragment.mSavedFragmentState, false);
                return;
            }
            fragment.mInnerView = null;
        }
    }

    /* JADX INFO: renamed from: e */
    void m1569e(final Fragment fragment) {
        if (fragment.mView != null) {
            AnimationOrAnimator animationOrAnimatorM1534a = m1534a(fragment, fragment.getNextTransition(), !fragment.mHidden, fragment.getNextTransitionStyle());
            if (animationOrAnimatorM1534a != null && animationOrAnimatorM1534a.f1529b != null) {
                animationOrAnimatorM1534a.f1529b.setTarget(fragment.mView);
                if (fragment.mHidden) {
                    if (fragment.isHideReplaced()) {
                        fragment.setHideReplaced(false);
                    } else {
                        final ViewGroup viewGroup = fragment.mContainer;
                        final View view = fragment.mView;
                        viewGroup.startViewTransition(view);
                        animationOrAnimatorM1534a.f1529b.addListener(new AnimatorListenerAdapter() { // from class: android.support.v4.app.FragmentManagerImpl.4
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                viewGroup.endViewTransition(view);
                                animator.removeListener(this);
                                if (fragment.mView != null) {
                                    fragment.mView.setVisibility(8);
                                }
                            }
                        });
                    }
                } else {
                    fragment.mView.setVisibility(0);
                }
                m1524b(fragment.mView, animationOrAnimatorM1534a);
                animationOrAnimatorM1534a.f1529b.start();
            } else {
                if (animationOrAnimatorM1534a != null) {
                    m1524b(fragment.mView, animationOrAnimatorM1534a);
                    fragment.mView.startAnimation(animationOrAnimatorM1534a.f1528a);
                    animationOrAnimatorM1534a.f1528a.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            }
        }
        if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
            this.f1503r = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    /* JADX INFO: renamed from: f */
    void m1571f(Fragment fragment) {
        if (fragment != null) {
            int iMin = this.f1498l;
            if (fragment.mRemoving) {
                if (fragment.isInBackStack()) {
                    iMin = Math.min(iMin, 1);
                } else {
                    iMin = Math.min(iMin, 0);
                }
            }
            m1539a(fragment, iMin, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
            if (fragment.mView != null) {
                Fragment fragmentM1531q = m1531q(fragment);
                if (fragmentM1531q != null) {
                    View view = fragmentM1531q.mView;
                    ViewGroup viewGroup = fragment.mContainer;
                    int iIndexOfChild = viewGroup.indexOfChild(view);
                    int iIndexOfChild2 = viewGroup.indexOfChild(fragment.mView);
                    if (iIndexOfChild2 < iIndexOfChild) {
                        viewGroup.removeViewAt(iIndexOfChild2);
                        viewGroup.addView(fragment.mView, iIndexOfChild);
                    }
                }
                if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                    if (fragment.mPostponedAlpha > CropImageView.DEFAULT_ASPECT_RATIO) {
                        fragment.mView.setAlpha(fragment.mPostponedAlpha);
                    }
                    fragment.mPostponedAlpha = CropImageView.DEFAULT_ASPECT_RATIO;
                    fragment.mIsNewlyAdded = false;
                    AnimationOrAnimator animationOrAnimatorM1534a = m1534a(fragment, fragment.getNextTransition(), true, fragment.getNextTransitionStyle());
                    if (animationOrAnimatorM1534a != null) {
                        m1524b(fragment.mView, animationOrAnimatorM1534a);
                        if (animationOrAnimatorM1534a.f1528a != null) {
                            fragment.mView.startAnimation(animationOrAnimatorM1534a.f1528a);
                        } else {
                            animationOrAnimatorM1534a.f1529b.setTarget(fragment.mView);
                            animationOrAnimatorM1534a.f1529b.start();
                        }
                    }
                }
            }
            if (fragment.mHiddenChanged) {
                m1569e(fragment);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void m1536a(int r7, boolean r8) {
        /*
            r6 = this;
            r3 = 0
            android.support.v4.app.FragmentHostCallback r0 = r6.f1499m
            if (r0 != 0) goto Lf
            if (r7 == 0) goto Lf
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "No activity"
            r0.<init>(r1)
            throw r0
        Lf:
            if (r8 != 0) goto L16
            int r0 = r6.f1498l
            if (r7 != r0) goto L16
        L15:
            return
        L16:
            r6.f1498l = r7
            android.util.SparseArray<android.support.v4.app.Fragment> r0 = r6.f1492f
            if (r0 == 0) goto L15
            java.util.ArrayList<android.support.v4.app.Fragment> r0 = r6.f1491e
            int r4 = r0.size()
            r2 = r3
            r1 = r3
        L24:
            if (r2 >= r4) goto L41
            java.util.ArrayList<android.support.v4.app.Fragment> r0 = r6.f1491e
            java.lang.Object r0 = r0.get(r2)
            android.support.v4.app.Fragment r0 = (android.support.v4.app.Fragment) r0
            r6.m1571f(r0)
            android.support.v4.app.LoaderManagerImpl r5 = r0.mLoaderManager
            if (r5 == 0) goto L8f
            android.support.v4.app.LoaderManagerImpl r0 = r0.mLoaderManager
            boolean r0 = r0.mo1686a()
            r0 = r0 | r1
        L3c:
            int r1 = r2 + 1
            r2 = r1
            r1 = r0
            goto L24
        L41:
            android.util.SparseArray<android.support.v4.app.Fragment> r0 = r6.f1492f
            int r4 = r0.size()
            r2 = r3
        L48:
            if (r2 >= r4) goto L73
            android.util.SparseArray<android.support.v4.app.Fragment> r0 = r6.f1492f
            java.lang.Object r0 = r0.valueAt(r2)
            android.support.v4.app.Fragment r0 = (android.support.v4.app.Fragment) r0
            if (r0 == 0) goto L8d
            boolean r5 = r0.mRemoving
            if (r5 != 0) goto L5c
            boolean r5 = r0.mDetached
            if (r5 == 0) goto L8d
        L5c:
            boolean r5 = r0.mIsNewlyAdded
            if (r5 != 0) goto L8d
            r6.m1571f(r0)
            android.support.v4.app.LoaderManagerImpl r5 = r0.mLoaderManager
            if (r5 == 0) goto L8d
            android.support.v4.app.LoaderManagerImpl r0 = r0.mLoaderManager
            boolean r0 = r0.mo1686a()
            r0 = r0 | r1
        L6e:
            int r1 = r2 + 1
            r2 = r1
            r1 = r0
            goto L48
        L73:
            if (r1 != 0) goto L78
            r6.m1575h()
        L78:
            boolean r0 = r6.f1503r
            if (r0 == 0) goto L15
            android.support.v4.app.FragmentHostCallback r0 = r6.f1499m
            if (r0 == 0) goto L15
            int r0 = r6.f1498l
            r1 = 5
            if (r0 != r1) goto L15
            android.support.v4.app.FragmentHostCallback r0 = r6.f1499m
            r0.mo1432d()
            r6.f1503r = r3
            goto L15
        L8d:
            r0 = r1
            goto L6e
        L8f:
            r0 = r1
            goto L3c
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.m1536a(int, boolean):void");
    }

    /* JADX INFO: renamed from: h */
    void m1575h() {
        if (this.f1492f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f1492f.size()) {
                    Fragment fragmentValueAt = this.f1492f.valueAt(i2);
                    if (fragmentValueAt != null) {
                        m1553b(fragmentValueAt);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: g */
    void m1573g(Fragment fragment) {
        if (fragment.mIndex < 0) {
            int i = this.f1490d;
            this.f1490d = i + 1;
            fragment.setIndex(i, this.f1501o);
            if (this.f1492f == null) {
                this.f1492f = new SparseArray<>();
            }
            this.f1492f.put(fragment.mIndex, fragment);
            if (f1481a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    /* JADX INFO: renamed from: h */
    void m1576h(Fragment fragment) {
        if (fragment.mIndex >= 0) {
            if (f1481a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.f1492f.put(fragment.mIndex, null);
            fragment.initState();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1543a(Fragment fragment, boolean z) {
        if (f1481a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        m1573g(fragment);
        if (!fragment.mDetached) {
            if (this.f1491e.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            synchronized (this.f1491e) {
                this.f1491e.add(fragment);
            }
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.f1503r = true;
            }
            if (z) {
                m1561c(fragment);
            }
        }
    }

    /* JADX INFO: renamed from: i */
    public void m1578i(Fragment fragment) {
        if (f1481a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            synchronized (this.f1491e) {
                this.f1491e.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.f1503r = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    /* JADX INFO: renamed from: j */
    public void m1581j(Fragment fragment) {
        if (f1481a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = fragment.mHiddenChanged ? false : true;
        }
    }

    /* JADX INFO: renamed from: k */
    public void m1583k(Fragment fragment) {
        if (f1481a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = fragment.mHiddenChanged ? false : true;
        }
    }

    /* JADX INFO: renamed from: l */
    public void m1585l(Fragment fragment) {
        if (f1481a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (f1481a) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                synchronized (this.f1491e) {
                    this.f1491e.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.f1503r = true;
                }
                fragment.mAdded = false;
            }
        }
    }

    /* JADX INFO: renamed from: m */
    public void m1587m(Fragment fragment) {
        if (f1481a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                if (this.f1491e.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (f1481a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                synchronized (this.f1491e) {
                    this.f1491e.add(fragment);
                }
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.f1503r = true;
                }
            }
        }
    }

    @Override // android.support.v4.app.FragmentManager
    /* JADX INFO: renamed from: a */
    public Fragment mo1468a(int i) {
        for (int size = this.f1491e.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f1491e.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        if (this.f1492f != null) {
            for (int size2 = this.f1492f.size() - 1; size2 >= 0; size2--) {
                Fragment fragmentValueAt = this.f1492f.valueAt(size2);
                if (fragmentValueAt != null && fragmentValueAt.mFragmentId == i) {
                    return fragmentValueAt;
                }
            }
        }
        return null;
    }

    @Override // android.support.v4.app.FragmentManager
    /* JADX INFO: renamed from: a */
    public Fragment mo1470a(String str) {
        if (str != null) {
            for (int size = this.f1491e.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f1491e.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (this.f1492f != null && str != null) {
            for (int size2 = this.f1492f.size() - 1; size2 >= 0; size2--) {
                Fragment fragmentValueAt = this.f1492f.valueAt(size2);
                if (fragmentValueAt != null && str.equals(fragmentValueAt.mTag)) {
                    return fragmentValueAt;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public Fragment m1551b(String str) {
        Fragment fragmentFindFragmentByWho;
        if (this.f1492f != null && str != null) {
            for (int size = this.f1492f.size() - 1; size >= 0; size--) {
                Fragment fragmentValueAt = this.f1492f.valueAt(size);
                if (fragmentValueAt != null && (fragmentFindFragmentByWho = fragmentValueAt.findFragmentByWho(str)) != null) {
                    return fragmentFindFragmentByWho;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: B */
    private void m1499B() {
        if (this.f1504s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.f1506u != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f1506u);
        }
    }

    @Override // android.support.v4.app.FragmentManager
    /* JADX INFO: renamed from: g */
    public boolean mo1483g() {
        return this.f1504s;
    }

    /* JADX INFO: renamed from: a */
    public void m1545a(OpGenerator opGenerator, boolean z) {
        if (!z) {
            m1499B();
        }
        synchronized (this) {
            if (this.f1505t || this.f1499m == null) {
                if (!z) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } else {
                if (this.f1488b == null) {
                    this.f1488b = new ArrayList<>();
                }
                this.f1488b.add(opGenerator);
                m1500C();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: C */
    public void m1500C() {
        synchronized (this) {
            boolean z = (this.f1484B == null || this.f1484B.isEmpty()) ? false : true;
            boolean z2 = this.f1488b != null && this.f1488b.size() == 1;
            if (z || z2) {
                this.f1499m.m1465j().removeCallbacks(this.f1486D);
                this.f1499m.m1465j().post(this.f1486D);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public int m1533a(BackStackRecord backStackRecord) {
        int size;
        synchronized (this) {
            if (this.f1496j == null || this.f1496j.size() <= 0) {
                if (this.f1495i == null) {
                    this.f1495i = new ArrayList<>();
                }
                size = this.f1495i.size();
                if (f1481a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + backStackRecord);
                }
                this.f1495i.add(backStackRecord);
            } else {
                size = this.f1496j.remove(this.f1496j.size() - 1).intValue();
                if (f1481a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + backStackRecord);
                }
                this.f1495i.set(size, backStackRecord);
            }
        }
        return size;
    }

    /* JADX INFO: renamed from: a */
    public void m1535a(int i, BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.f1495i == null) {
                this.f1495i = new ArrayList<>();
            }
            int size = this.f1495i.size();
            if (i < size) {
                if (f1481a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + backStackRecord);
                }
                this.f1495i.set(i, backStackRecord);
            } else {
                while (size < i) {
                    this.f1495i.add(null);
                    if (this.f1496j == null) {
                        this.f1496j = new ArrayList<>();
                    }
                    if (f1481a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f1496j.add(Integer.valueOf(size));
                    size++;
                }
                if (f1481a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + backStackRecord);
                }
                this.f1495i.add(backStackRecord);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public void m1565d(int i) {
        synchronized (this) {
            this.f1495i.set(i, null);
            if (this.f1496j == null) {
                this.f1496j = new ArrayList<>();
            }
            if (f1481a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f1496j.add(Integer.valueOf(i));
        }
    }

    /* JADX INFO: renamed from: c */
    private void m1527c(boolean z) {
        if (this.f1489c) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f1499m == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        if (Looper.myLooper() != this.f1499m.m1465j().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            m1499B();
        }
        if (this.f1508w == null) {
            this.f1508w = new ArrayList<>();
            this.f1509x = new ArrayList<>();
        }
        this.f1489c = true;
        try {
            m1516a((ArrayList<BackStackRecord>) null, (ArrayList<Boolean>) null);
        } finally {
            this.f1489c = false;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m1557b(OpGenerator opGenerator, boolean z) {
        if (!z || (this.f1499m != null && !this.f1505t)) {
            m1527c(z);
            if (opGenerator.mo1375a(this.f1508w, this.f1509x)) {
                this.f1489c = true;
                try {
                    m1525b(this.f1508w, this.f1509x);
                } finally {
                    m1501D();
                }
            }
            m1580j();
            m1504G();
        }
    }

    /* JADX INFO: renamed from: D */
    private void m1501D() {
        this.f1489c = false;
        this.f1509x.clear();
        this.f1508w.clear();
    }

    /* JADX INFO: renamed from: i */
    public boolean m1579i() {
        m1527c(true);
        boolean z = false;
        while (m1528c(this.f1508w, this.f1509x)) {
            this.f1489c = true;
            try {
                m1525b(this.f1508w, this.f1509x);
                m1501D();
                z = true;
            } catch (Throwable th) {
                m1501D();
                throw th;
            }
        }
        m1580j();
        m1504G();
        return z;
    }

    /* JADX INFO: renamed from: a */
    private void m1516a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        int iIndexOf;
        int iIndexOf2;
        int i = 0;
        int size = this.f1484B == null ? 0 : this.f1484B.size();
        while (i < size) {
            StartEnterTransitionListener startEnterTransitionListener = this.f1484B.get(i);
            if (arrayList != null && !startEnterTransitionListener.f1540a && (iIndexOf2 = arrayList.indexOf(startEnterTransitionListener.f1541b)) != -1 && arrayList2.get(iIndexOf2).booleanValue()) {
                startEnterTransitionListener.m1608e();
            } else if (startEnterTransitionListener.m1606c() || (arrayList != null && startEnterTransitionListener.f1541b.m1374a(arrayList, 0, arrayList.size()))) {
                this.f1484B.remove(i);
                i--;
                size--;
                if (arrayList != null && !startEnterTransitionListener.f1540a && (iIndexOf = arrayList.indexOf(startEnterTransitionListener.f1541b)) != -1 && arrayList2.get(iIndexOf).booleanValue()) {
                    startEnterTransitionListener.m1608e();
                } else {
                    startEnterTransitionListener.m1607d();
                }
            }
            i++;
            size = size;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m1525b(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        int i;
        int i2 = 0;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            m1516a(arrayList, arrayList2);
            int size = arrayList.size();
            int i3 = 0;
            while (i2 < size) {
                if (arrayList.get(i2).f1420t) {
                    i = i2;
                } else {
                    if (i3 != i2) {
                        m1517a(arrayList, arrayList2, i3, i2);
                    }
                    int i4 = i2 + 1;
                    if (arrayList2.get(i2).booleanValue()) {
                        while (i4 < size && arrayList2.get(i4).booleanValue() && !arrayList.get(i4).f1420t) {
                            i4++;
                        }
                    }
                    int i5 = i4;
                    m1517a(arrayList, arrayList2, i2, i5);
                    i3 = i5;
                    i = i5 - 1;
                }
                i2 = i + 1;
            }
            if (i3 != size) {
                m1517a(arrayList, arrayList2, i3, size);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1517a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int iM1505a;
        Fragment fragmentM1376b;
        boolean z = arrayList.get(i).f1420t;
        if (this.f1510y == null) {
            this.f1510y = new ArrayList<>();
        } else {
            this.f1510y.clear();
        }
        this.f1510y.addAll(this.f1491e);
        int i3 = i;
        Fragment fragmentM1603z = m1603z();
        boolean z2 = false;
        while (i3 < i2) {
            BackStackRecord backStackRecord = arrayList.get(i3);
            if (!arrayList2.get(i3).booleanValue()) {
                fragmentM1376b = backStackRecord.m1361a(this.f1510y, fragmentM1603z);
            } else {
                fragmentM1376b = backStackRecord.m1376b(this.f1510y, fragmentM1603z);
            }
            i3++;
            fragmentM1603z = fragmentM1376b;
            z2 = z2 || backStackRecord.f1409i;
        }
        this.f1510y.clear();
        if (!z) {
            FragmentTransition.m1649a(this, arrayList, arrayList2, i, i2, false);
        }
        m1526b(arrayList, arrayList2, i, i2);
        if (z) {
            ArraySet<Fragment> arraySet = new ArraySet<>();
            m1523b(arraySet);
            iM1505a = m1505a(arrayList, arrayList2, i, i2, arraySet);
            m1514a(arraySet);
        } else {
            iM1505a = i2;
        }
        if (iM1505a != i && z) {
            FragmentTransition.m1649a(this, arrayList, arrayList2, i, iM1505a, true);
            m1536a(this.f1498l, true);
        }
        while (i < i2) {
            BackStackRecord backStackRecord2 = arrayList.get(i);
            if (arrayList2.get(i).booleanValue() && backStackRecord2.f1413m >= 0) {
                m1565d(backStackRecord2.f1413m);
                backStackRecord2.f1413m = -1;
            }
            backStackRecord2.m1384c();
            i++;
        }
        if (z2) {
            m1582k();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1514a(ArraySet<Fragment> arraySet) {
        int size = arraySet.size();
        for (int i = 0; i < size; i++) {
            Fragment fragmentM2394b = arraySet.m2394b(i);
            if (!fragmentM2394b.mAdded) {
                View view = fragmentM2394b.getView();
                fragmentM2394b.mPostponedAlpha = view.getAlpha();
                view.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private int m1505a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, ArraySet<Fragment> arraySet) {
        int i3;
        int i4 = i2 - 1;
        int i5 = i2;
        while (i4 >= i) {
            BackStackRecord backStackRecord = arrayList.get(i4);
            boolean zBooleanValue = arrayList2.get(i4).booleanValue();
            if (backStackRecord.m1390i() && !backStackRecord.m1374a(arrayList, i4 + 1, i2)) {
                if (this.f1484B == null) {
                    this.f1484B = new ArrayList<>();
                }
                StartEnterTransitionListener startEnterTransitionListener = new StartEnterTransitionListener(backStackRecord, zBooleanValue);
                this.f1484B.add(startEnterTransitionListener);
                backStackRecord.m1371a(startEnterTransitionListener);
                if (zBooleanValue) {
                    backStackRecord.m1389h();
                } else {
                    backStackRecord.m1381b(false);
                }
                int i6 = i5 - 1;
                if (i4 != i6) {
                    arrayList.remove(i4);
                    arrayList.add(i6, backStackRecord);
                }
                m1523b(arraySet);
                i3 = i6;
            } else {
                i3 = i5;
            }
            i4--;
            i5 = i3;
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m1509a(BackStackRecord backStackRecord, boolean z, boolean z2, boolean z3) {
        if (z) {
            backStackRecord.m1381b(z3);
        } else {
            backStackRecord.m1389h();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(backStackRecord);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            FragmentTransition.m1649a(this, (ArrayList<BackStackRecord>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z3) {
            m1536a(this.f1498l, true);
        }
        if (this.f1492f != null) {
            int size = this.f1492f.size();
            for (int i = 0; i < size; i++) {
                Fragment fragmentValueAt = this.f1492f.valueAt(i);
                if (fragmentValueAt != null && fragmentValueAt.mView != null && fragmentValueAt.mIsNewlyAdded && backStackRecord.m1382b(fragmentValueAt.mContainerId)) {
                    if (fragmentValueAt.mPostponedAlpha > CropImageView.DEFAULT_ASPECT_RATIO) {
                        fragmentValueAt.mView.setAlpha(fragmentValueAt.mPostponedAlpha);
                    }
                    if (z3) {
                        fragmentValueAt.mPostponedAlpha = CropImageView.DEFAULT_ASPECT_RATIO;
                    } else {
                        fragmentValueAt.mPostponedAlpha = -1.0f;
                        fragmentValueAt.mIsNewlyAdded = false;
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: q */
    private Fragment m1531q(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        View view = fragment.mView;
        if (viewGroup == null || view == null) {
            return null;
        }
        for (int iIndexOf = this.f1491e.indexOf(fragment) - 1; iIndexOf >= 0; iIndexOf--) {
            Fragment fragment2 = this.f1491e.get(iIndexOf);
            if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                return fragment2;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    private static void m1526b(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            BackStackRecord backStackRecord = arrayList.get(i);
            if (arrayList2.get(i).booleanValue()) {
                backStackRecord.m1369a(-1);
                backStackRecord.m1381b(i == i2 + (-1));
            } else {
                backStackRecord.m1369a(1);
                backStackRecord.m1389h();
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m1523b(ArraySet<Fragment> arraySet) {
        if (this.f1498l >= 1) {
            int iMin = Math.min(this.f1498l, 4);
            int size = this.f1491e.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = this.f1491e.get(i);
                if (fragment.mState < iMin) {
                    m1539a(fragment, iMin, fragment.getNextAnim(), fragment.getNextTransition(), false);
                    if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                        arraySet.add(fragment);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: E */
    private void m1502E() {
        if (this.f1484B != null) {
            while (!this.f1484B.isEmpty()) {
                this.f1484B.remove(0).m1607d();
            }
        }
    }

    /* JADX INFO: renamed from: F */
    private void m1503F() {
        int size = this.f1492f == null ? 0 : this.f1492f.size();
        for (int i = 0; i < size; i++) {
            Fragment fragmentValueAt = this.f1492f.valueAt(i);
            if (fragmentValueAt != null) {
                if (fragmentValueAt.getAnimatingAway() != null) {
                    int stateAfterAnimating = fragmentValueAt.getStateAfterAnimating();
                    View animatingAway = fragmentValueAt.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    fragmentValueAt.setAnimatingAway(null);
                    m1539a(fragmentValueAt, stateAfterAnimating, 0, 0, false);
                } else if (fragmentValueAt.getAnimator() != null) {
                    fragmentValueAt.getAnimator().end();
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private boolean m1528c(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.f1488b == null || this.f1488b.size() == 0) {
                return false;
            }
            int size = this.f1488b.size();
            boolean zMo1375a = false;
            for (int i = 0; i < size; i++) {
                zMo1375a |= this.f1488b.get(i).mo1375a(arrayList, arrayList2);
            }
            this.f1488b.clear();
            this.f1499m.m1465j().removeCallbacks(this.f1486D);
            return zMo1375a;
        }
    }

    /* JADX INFO: renamed from: j */
    void m1580j() {
        if (this.f1507v) {
            boolean zMo1686a = false;
            for (int i = 0; i < this.f1492f.size(); i++) {
                Fragment fragmentValueAt = this.f1492f.valueAt(i);
                if (fragmentValueAt != null && fragmentValueAt.mLoaderManager != null) {
                    zMo1686a |= fragmentValueAt.mLoaderManager.mo1686a();
                }
            }
            if (!zMo1686a) {
                this.f1507v = false;
                m1575h();
            }
        }
    }

    /* JADX INFO: renamed from: k */
    void m1582k() {
        if (this.f1497k != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f1497k.size()) {
                    this.f1497k.get(i2).m1498a();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    void m1552b(BackStackRecord backStackRecord) {
        if (this.f1493g == null) {
            this.f1493g = new ArrayList<>();
        }
        this.f1493g.add(backStackRecord);
    }

    /* JADX INFO: renamed from: a */
    boolean m1550a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        if (this.f1493g == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = this.f1493g.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f1493g.remove(size));
            arrayList2.add(true);
        } else {
            int i3 = -1;
            if (str != null || i >= 0) {
                int size2 = this.f1493g.size() - 1;
                while (size2 >= 0) {
                    BackStackRecord backStackRecord = this.f1493g.get(size2);
                    if ((str != null && str.equals(backStackRecord.m1391j())) || (i >= 0 && i == backStackRecord.f1413m)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        BackStackRecord backStackRecord2 = this.f1493g.get(size2);
                        if ((str == null || !str.equals(backStackRecord2.m1391j())) && (i < 0 || i != backStackRecord2.f1413m)) {
                            break;
                        }
                        size2--;
                    }
                }
                i3 = size2;
            }
            if (i3 == this.f1493g.size() - 1) {
                return false;
            }
            for (int size3 = this.f1493g.size() - 1; size3 > i3; size3--) {
                arrayList.add(this.f1493g.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: l */
    FragmentManagerNonConfig m1584l() {
        m1513a(this.f1485C);
        return this.f1485C;
    }

    /* JADX INFO: renamed from: a */
    private static void m1513a(FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (fragmentManagerNonConfig != null) {
            List<Fragment> listM1609a = fragmentManagerNonConfig.m1609a();
            if (listM1609a != null) {
                Iterator<Fragment> it = listM1609a.iterator();
                while (it.hasNext()) {
                    it.next().mRetaining = true;
                }
            }
            List<FragmentManagerNonConfig> listM1610b = fragmentManagerNonConfig.m1610b();
            if (listM1610b != null) {
                Iterator<FragmentManagerNonConfig> it2 = listM1610b.iterator();
                while (it2.hasNext()) {
                    m1513a(it2.next());
                }
            }
        }
    }

    /* JADX INFO: renamed from: m */
    void m1586m() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        FragmentManagerNonConfig fragmentManagerNonConfig;
        if (this.f1492f != null) {
            int i = 0;
            arrayList = null;
            arrayList2 = null;
            arrayList3 = null;
            while (i < this.f1492f.size()) {
                Fragment fragmentValueAt = this.f1492f.valueAt(i);
                if (fragmentValueAt != null) {
                    if (fragmentValueAt.mRetainInstance) {
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList3.add(fragmentValueAt);
                        fragmentValueAt.mTargetIndex = fragmentValueAt.mTarget != null ? fragmentValueAt.mTarget.mIndex : -1;
                        if (f1481a) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragmentValueAt);
                        }
                    }
                    if (fragmentValueAt.mChildFragmentManager != null) {
                        fragmentValueAt.mChildFragmentManager.m1586m();
                        fragmentManagerNonConfig = fragmentValueAt.mChildFragmentManager.f1485C;
                    } else {
                        fragmentManagerNonConfig = fragmentValueAt.mChildNonConfig;
                    }
                    if (arrayList2 == null && fragmentManagerNonConfig != null) {
                        arrayList2 = new ArrayList(this.f1492f.size());
                        for (int i2 = 0; i2 < i; i2++) {
                            arrayList2.add(null);
                        }
                    }
                    if (arrayList2 != null) {
                        arrayList2.add(fragmentManagerNonConfig);
                    }
                    if (arrayList == null && fragmentValueAt.mViewModelStore != null) {
                        arrayList = new ArrayList(this.f1492f.size());
                        for (int i3 = 0; i3 < i; i3++) {
                            arrayList.add(null);
                        }
                    }
                    if (arrayList != null) {
                        arrayList.add(fragmentValueAt.mViewModelStore);
                    }
                }
                i++;
                arrayList3 = arrayList3;
                arrayList2 = arrayList2;
                arrayList = arrayList;
            }
        } else {
            arrayList = null;
            arrayList2 = null;
            arrayList3 = null;
        }
        if (arrayList3 == null && arrayList2 == null && arrayList == null) {
            this.f1485C = null;
        } else {
            this.f1485C = new FragmentManagerNonConfig(arrayList3, arrayList2, arrayList);
        }
    }

    /* JADX INFO: renamed from: n */
    void m1589n(Fragment fragment) {
        if (fragment.mInnerView != null) {
            if (this.f1483A == null) {
                this.f1483A = new SparseArray<>();
            } else {
                this.f1483A.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.f1483A);
            if (this.f1483A.size() > 0) {
                fragment.mSavedViewState = this.f1483A;
                this.f1483A = null;
            }
        }
    }

    /* JADX INFO: renamed from: o */
    Bundle m1590o(Fragment fragment) {
        Bundle bundle;
        if (this.f1511z == null) {
            this.f1511z = new Bundle();
        }
        fragment.performSaveInstanceState(this.f1511z);
        m1567d(fragment, this.f1511z, false);
        if (this.f1511z.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f1511z;
            this.f1511z = null;
        }
        if (fragment.mView != null) {
            m1589n(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle;
    }

    /* JADX INFO: renamed from: n */
    Parcelable m1588n() {
        int[] iArr;
        int size;
        boolean z;
        BackStackState[] backStackStateArr = null;
        m1502E();
        m1503F();
        m1579i();
        this.f1504s = true;
        this.f1485C = null;
        if (this.f1492f == null || this.f1492f.size() <= 0) {
            return null;
        }
        int size2 = this.f1492f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size2];
        int i = 0;
        boolean z2 = false;
        while (i < size2) {
            Fragment fragmentValueAt = this.f1492f.valueAt(i);
            if (fragmentValueAt != null) {
                if (fragmentValueAt.mIndex < 0) {
                    m1515a(new IllegalStateException("Failure saving state: active " + fragmentValueAt + " has cleared index: " + fragmentValueAt.mIndex));
                }
                FragmentState fragmentState = new FragmentState(fragmentValueAt);
                fragmentStateArr[i] = fragmentState;
                if (fragmentValueAt.mState > 0 && fragmentState.f1564k == null) {
                    fragmentState.f1564k = m1590o(fragmentValueAt);
                    if (fragmentValueAt.mTarget != null) {
                        if (fragmentValueAt.mTarget.mIndex < 0) {
                            m1515a(new IllegalStateException("Failure saving state: " + fragmentValueAt + " has target not in fragment manager: " + fragmentValueAt.mTarget));
                        }
                        if (fragmentState.f1564k == null) {
                            fragmentState.f1564k = new Bundle();
                        }
                        mo1473a(fragmentState.f1564k, "android:target_state", fragmentValueAt.mTarget);
                        if (fragmentValueAt.mTargetRequestCode != 0) {
                            fragmentState.f1564k.putInt("android:target_req_state", fragmentValueAt.mTargetRequestCode);
                        }
                    }
                } else {
                    fragmentState.f1564k = fragmentValueAt.mSavedFragmentState;
                }
                if (f1481a) {
                    Log.v("FragmentManager", "Saved state of " + fragmentValueAt + ": " + fragmentState.f1564k);
                }
                z = true;
            } else {
                z = z2;
            }
            i++;
            z2 = z;
        }
        if (!z2) {
            if (!f1481a) {
                return null;
            }
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
        int size3 = this.f1491e.size();
        if (size3 > 0) {
            iArr = new int[size3];
            for (int i2 = 0; i2 < size3; i2++) {
                iArr[i2] = this.f1491e.get(i2).mIndex;
                if (iArr[i2] < 0) {
                    m1515a(new IllegalStateException("Failure saving state: active " + this.f1491e.get(i2) + " has cleared index: " + iArr[i2]));
                }
                if (f1481a) {
                    Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f1491e.get(i2));
                }
            }
        } else {
            iArr = null;
        }
        if (this.f1493g != null && (size = this.f1493g.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i3 = 0; i3 < size; i3++) {
                backStackStateArr[i3] = new BackStackState(this.f1493g.get(i3));
                if (f1481a) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.f1493g.get(i3));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f1546a = fragmentStateArr;
        fragmentManagerState.f1547b = iArr;
        fragmentManagerState.f1548c = backStackStateArr;
        if (this.f1502p != null) {
            fragmentManagerState.f1549d = this.f1502p.mIndex;
        }
        fragmentManagerState.f1550e = this.f1490d;
        m1586m();
        return fragmentManagerState;
    }

    /* JADX INFO: renamed from: a */
    void m1538a(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        List<ViewModelStore> list;
        List<FragmentManagerNonConfig> list2;
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f1546a != null) {
                if (fragmentManagerNonConfig != null) {
                    List<Fragment> listM1609a = fragmentManagerNonConfig.m1609a();
                    List<FragmentManagerNonConfig> listM1610b = fragmentManagerNonConfig.m1610b();
                    List<ViewModelStore> listM1611c = fragmentManagerNonConfig.m1611c();
                    int size = listM1609a != null ? listM1609a.size() : 0;
                    for (int i = 0; i < size; i++) {
                        Fragment fragment = listM1609a.get(i);
                        if (f1481a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        int i2 = 0;
                        while (i2 < fragmentManagerState.f1546a.length && fragmentManagerState.f1546a[i2].f1555b != fragment.mIndex) {
                            i2++;
                        }
                        if (i2 == fragmentManagerState.f1546a.length) {
                            m1515a(new IllegalStateException("Could not find active fragment with index " + fragment.mIndex));
                        }
                        FragmentState fragmentState = fragmentManagerState.f1546a[i2];
                        fragmentState.f1565l = fragment;
                        fragment.mSavedViewState = null;
                        fragment.mBackStackNesting = 0;
                        fragment.mInLayout = false;
                        fragment.mAdded = false;
                        fragment.mTarget = null;
                        if (fragmentState.f1564k != null) {
                            fragmentState.f1564k.setClassLoader(this.f1499m.m1464i().getClassLoader());
                            fragment.mSavedViewState = fragmentState.f1564k.getSparseParcelableArray("android:view_state");
                            fragment.mSavedFragmentState = fragmentState.f1564k;
                        }
                    }
                    list = listM1611c;
                    list2 = listM1610b;
                } else {
                    list = null;
                    list2 = null;
                }
                this.f1492f = new SparseArray<>(fragmentManagerState.f1546a.length);
                int i3 = 0;
                while (i3 < fragmentManagerState.f1546a.length) {
                    FragmentState fragmentState2 = fragmentManagerState.f1546a[i3];
                    if (fragmentState2 != null) {
                        Fragment fragmentM1625a = fragmentState2.m1625a(this.f1499m, this.f1500n, this.f1501o, (list2 == null || i3 >= list2.size()) ? null : list2.get(i3), (list == null || i3 >= list.size()) ? null : list.get(i3));
                        if (f1481a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i3 + ": " + fragmentM1625a);
                        }
                        this.f1492f.put(fragmentM1625a.mIndex, fragmentM1625a);
                        fragmentState2.f1565l = null;
                    }
                    i3++;
                }
                if (fragmentManagerNonConfig != null) {
                    List<Fragment> listM1609a2 = fragmentManagerNonConfig.m1609a();
                    int size2 = listM1609a2 != null ? listM1609a2.size() : 0;
                    for (int i4 = 0; i4 < size2; i4++) {
                        Fragment fragment2 = listM1609a2.get(i4);
                        if (fragment2.mTargetIndex >= 0) {
                            fragment2.mTarget = this.f1492f.get(fragment2.mTargetIndex);
                            if (fragment2.mTarget == null) {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.mTargetIndex);
                            }
                        }
                    }
                }
                this.f1491e.clear();
                if (fragmentManagerState.f1547b != null) {
                    for (int i5 = 0; i5 < fragmentManagerState.f1547b.length; i5++) {
                        Fragment fragment3 = this.f1492f.get(fragmentManagerState.f1547b[i5]);
                        if (fragment3 == null) {
                            m1515a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f1547b[i5]));
                        }
                        fragment3.mAdded = true;
                        if (f1481a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i5 + ": " + fragment3);
                        }
                        if (this.f1491e.contains(fragment3)) {
                            throw new IllegalStateException("Already added!");
                        }
                        synchronized (this.f1491e) {
                            this.f1491e.add(fragment3);
                        }
                    }
                }
                if (fragmentManagerState.f1548c != null) {
                    this.f1493g = new ArrayList<>(fragmentManagerState.f1548c.length);
                    for (int i6 = 0; i6 < fragmentManagerState.f1548c.length; i6++) {
                        BackStackRecord backStackRecordM1393a = fragmentManagerState.f1548c[i6].m1393a(this);
                        if (f1481a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i6 + " (index " + backStackRecordM1393a.f1413m + "): " + backStackRecordM1393a);
                            PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                            backStackRecordM1393a.m1373a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f1493g.add(backStackRecordM1393a);
                        if (backStackRecordM1393a.f1413m >= 0) {
                            m1535a(backStackRecordM1393a.f1413m, backStackRecordM1393a);
                        }
                    }
                } else {
                    this.f1493g = null;
                }
                if (fragmentManagerState.f1549d >= 0) {
                    this.f1502p = this.f1492f.get(fragmentManagerState.f1549d);
                }
                this.f1490d = fragmentManagerState.f1550e;
            }
        }
    }

    /* JADX INFO: renamed from: G */
    private void m1504G() {
        if (this.f1492f != null) {
            for (int size = this.f1492f.size() - 1; size >= 0; size--) {
                if (this.f1492f.valueAt(size) == null) {
                    this.f1492f.delete(this.f1492f.keyAt(size));
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1544a(FragmentHostCallback fragmentHostCallback, FragmentContainer fragmentContainer, Fragment fragment) {
        if (this.f1499m != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f1499m = fragmentHostCallback;
        this.f1500n = fragmentContainer;
        this.f1501o = fragment;
    }

    /* JADX INFO: renamed from: o */
    public void m1591o() {
        this.f1485C = null;
        this.f1504s = false;
        int size = this.f1491e.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = this.f1491e.get(i);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    /* JADX INFO: renamed from: p */
    public void m1592p() {
        this.f1504s = false;
        m1530f(1);
    }

    /* JADX INFO: renamed from: q */
    public void m1594q() {
        this.f1504s = false;
        m1530f(2);
    }

    /* JADX INFO: renamed from: r */
    public void m1595r() {
        this.f1504s = false;
        m1530f(4);
    }

    /* JADX INFO: renamed from: s */
    public void m1596s() {
        this.f1504s = false;
        m1530f(5);
    }

    /* JADX INFO: renamed from: t */
    public void m1597t() {
        m1530f(4);
    }

    /* JADX INFO: renamed from: u */
    public void m1598u() {
        this.f1504s = true;
        m1530f(3);
    }

    /* JADX INFO: renamed from: v */
    public void m1599v() {
        m1530f(2);
    }

    /* JADX INFO: renamed from: w */
    public void m1600w() {
        m1530f(1);
    }

    /* JADX INFO: renamed from: x */
    public void m1601x() {
        this.f1505t = true;
        m1579i();
        m1530f(0);
        this.f1499m = null;
        this.f1500n = null;
        this.f1501o = null;
    }

    /* JADX INFO: renamed from: f */
    private void m1530f(int i) {
        try {
            this.f1489c = true;
            m1536a(i, false);
            this.f1489c = false;
            m1579i();
        } catch (Throwable th) {
            this.f1489c = false;
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1546a(boolean z) {
        for (int size = this.f1491e.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f1491e.get(size);
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m1559b(boolean z) {
        for (int size = this.f1491e.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f1491e.get(size);
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1537a(Configuration configuration) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f1491e.size()) {
                Fragment fragment = this.f1491e.get(i2);
                if (fragment != null) {
                    fragment.performConfigurationChanged(configuration);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: y */
    public void m1602y() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f1491e.size()) {
                Fragment fragment = this.f1491e.get(i2);
                if (fragment != null) {
                    fragment.performLowMemory();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m1548a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        if (this.f1498l < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        int i = 0;
        boolean z2 = false;
        while (i < this.f1491e.size()) {
            Fragment fragment = this.f1491e.get(i);
            if (fragment == null || !fragment.performCreateOptionsMenu(menu, menuInflater)) {
                z = z2;
            } else {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
            i++;
            z2 = z;
        }
        if (this.f1494h != null) {
            for (int i2 = 0; i2 < this.f1494h.size(); i2++) {
                Fragment fragment2 = this.f1494h.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f1494h = arrayList;
        return z2;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1547a(Menu menu) {
        if (this.f1498l < 1) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f1491e.size(); i++) {
            Fragment fragment = this.f1491e.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1549a(MenuItem menuItem) {
        if (this.f1498l < 1) {
            return false;
        }
        for (int i = 0; i < this.f1491e.size(); i++) {
            Fragment fragment = this.f1491e.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public boolean m1560b(MenuItem menuItem) {
        if (this.f1498l < 1) {
            return false;
        }
        for (int i = 0; i < this.f1491e.size(); i++) {
            Fragment fragment = this.f1491e.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public void m1558b(Menu menu) {
        if (this.f1498l >= 1) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f1491e.size()) {
                    Fragment fragment = this.f1491e.get(i2);
                    if (fragment != null) {
                        fragment.performOptionsMenuClosed(menu);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: p */
    public void m1593p(Fragment fragment) {
        if (fragment != null && (this.f1492f.get(fragment.mIndex) != fragment || (fragment.mHost != null && fragment.getFragmentManager() != this))) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        this.f1502p = fragment;
    }

    /* JADX INFO: renamed from: z */
    public Fragment m1603z() {
        return this.f1502p;
    }

    /* JADX INFO: renamed from: a */
    void m1540a(Fragment fragment, Context context, boolean z) {
        if (this.f1501o != null) {
            FragmentManager fragmentManager = this.f1501o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m1540a(fragment, context, true);
            }
        }
        for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.f1487I) {
            if (!z || pair.f2229b.booleanValue()) {
                pair.f2228a.m1485a(this, fragment, context);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    void m1554b(Fragment fragment, Context context, boolean z) {
        if (this.f1501o != null) {
            FragmentManager fragmentManager = this.f1501o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m1554b(fragment, context, true);
            }
        }
        for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.f1487I) {
            if (!z || pair.f2229b.booleanValue()) {
                pair.f2228a.m1489b(this, fragment, context);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m1541a(Fragment fragment, Bundle bundle, boolean z) {
        if (this.f1501o != null) {
            FragmentManager fragmentManager = this.f1501o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m1541a(fragment, bundle, true);
            }
        }
        for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.f1487I) {
            if (!z || pair.f2229b.booleanValue()) {
                pair.f2228a.m1486a(this, fragment, bundle);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    void m1555b(Fragment fragment, Bundle bundle, boolean z) {
        if (this.f1501o != null) {
            FragmentManager fragmentManager = this.f1501o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m1555b(fragment, bundle, true);
            }
        }
        for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.f1487I) {
            if (!z || pair.f2229b.booleanValue()) {
                pair.f2228a.m1490b(this, fragment, bundle);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    void m1562c(Fragment fragment, Bundle bundle, boolean z) {
        if (this.f1501o != null) {
            FragmentManager fragmentManager = this.f1501o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m1562c(fragment, bundle, true);
            }
        }
        for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.f1487I) {
            if (!z || pair.f2229b.booleanValue()) {
                pair.f2228a.m1492c(this, fragment, bundle);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m1542a(Fragment fragment, View view, Bundle bundle, boolean z) {
        if (this.f1501o != null) {
            FragmentManager fragmentManager = this.f1501o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m1542a(fragment, view, bundle, true);
            }
        }
        for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.f1487I) {
            if (!z || pair.f2229b.booleanValue()) {
                pair.f2228a.m1487a(this, fragment, view, bundle);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    void m1556b(Fragment fragment, boolean z) {
        if (this.f1501o != null) {
            FragmentManager fragmentManager = this.f1501o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m1556b(fragment, true);
            }
        }
        for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.f1487I) {
            if (!z || pair.f2229b.booleanValue()) {
                pair.f2228a.m1484a(this, fragment);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    void m1563c(Fragment fragment, boolean z) {
        if (this.f1501o != null) {
            FragmentManager fragmentManager = this.f1501o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m1563c(fragment, true);
            }
        }
        for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.f1487I) {
            if (!z || pair.f2229b.booleanValue()) {
                pair.f2228a.m1488b(this, fragment);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    void m1568d(Fragment fragment, boolean z) {
        if (this.f1501o != null) {
            FragmentManager fragmentManager = this.f1501o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m1568d(fragment, true);
            }
        }
        for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.f1487I) {
            if (!z || pair.f2229b.booleanValue()) {
                pair.f2228a.m1491c(this, fragment);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    void m1570e(Fragment fragment, boolean z) {
        if (this.f1501o != null) {
            FragmentManager fragmentManager = this.f1501o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m1570e(fragment, true);
            }
        }
        for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.f1487I) {
            if (!z || pair.f2229b.booleanValue()) {
                pair.f2228a.m1493d(this, fragment);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    void m1567d(Fragment fragment, Bundle bundle, boolean z) {
        if (this.f1501o != null) {
            FragmentManager fragmentManager = this.f1501o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m1567d(fragment, bundle, true);
            }
        }
        for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.f1487I) {
            if (!z || pair.f2229b.booleanValue()) {
                pair.f2228a.m1494d(this, fragment, bundle);
            }
        }
    }

    /* JADX INFO: renamed from: f */
    void m1572f(Fragment fragment, boolean z) {
        if (this.f1501o != null) {
            FragmentManager fragmentManager = this.f1501o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m1572f(fragment, true);
            }
        }
        for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.f1487I) {
            if (!z || pair.f2229b.booleanValue()) {
                pair.f2228a.m1495e(this, fragment);
            }
        }
    }

    /* JADX INFO: renamed from: g */
    void m1574g(Fragment fragment, boolean z) {
        if (this.f1501o != null) {
            FragmentManager fragmentManager = this.f1501o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m1574g(fragment, true);
            }
        }
        for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.f1487I) {
            if (!z || pair.f2229b.booleanValue()) {
                pair.f2228a.m1496f(this, fragment);
            }
        }
    }

    /* JADX INFO: renamed from: h */
    void m1577h(Fragment fragment, boolean z) {
        if (this.f1501o != null) {
            FragmentManager fragmentManager = this.f1501o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m1577h(fragment, true);
            }
        }
        for (Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> pair : this.f1487I) {
            if (!z || pair.f2229b.booleanValue()) {
                pair.f2228a.m1497g(this, fragment);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public static int m1529e(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    /* JADX INFO: renamed from: b */
    public static int m1522b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FragmentTag.f1535a);
        String string = attributeValue == null ? typedArrayObtainStyledAttributes.getString(0) : attributeValue;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        String string2 = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
        if (!Fragment.isSupportFragmentClass(this.f1499m.m1464i(), string)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment fragmentMo1468a = resourceId != -1 ? mo1468a(resourceId) : null;
        if (fragmentMo1468a == null && string2 != null) {
            fragmentMo1468a = mo1470a(string2);
        }
        if (fragmentMo1468a == null && id != -1) {
            fragmentMo1468a = mo1468a(id);
        }
        if (f1481a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + fragmentMo1468a);
        }
        if (fragmentMo1468a == null) {
            Fragment fragmentMo1400a = this.f1500n.mo1400a(context, string, null);
            fragmentMo1400a.mFromLayout = true;
            fragmentMo1400a.mFragmentId = resourceId != 0 ? resourceId : id;
            fragmentMo1400a.mContainerId = id;
            fragmentMo1400a.mTag = string2;
            fragmentMo1400a.mInLayout = true;
            fragmentMo1400a.mFragmentManager = this;
            fragmentMo1400a.mHost = this.f1499m;
            fragmentMo1400a.onInflate(this.f1499m.m1464i(), attributeSet, fragmentMo1400a.mSavedFragmentState);
            m1543a(fragmentMo1400a, true);
            fragment = fragmentMo1400a;
        } else {
            if (fragmentMo1468a.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
            }
            fragmentMo1468a.mInLayout = true;
            fragmentMo1468a.mHost = this.f1499m;
            if (!fragmentMo1468a.mRetaining) {
                fragmentMo1468a.onInflate(this.f1499m.m1464i(), attributeSet, fragmentMo1468a.mSavedFragmentState);
            }
            fragment = fragmentMo1468a;
        }
        if (this.f1498l < 1 && fragment.mFromLayout) {
            m1539a(fragment, 1, 0, 0, false);
        } else {
            m1561c(fragment);
        }
        if (fragment.mView == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.mView.setId(resourceId);
        }
        if (fragment.mView.getTag() == null) {
            fragment.mView.setTag(string2);
        }
        return fragment.mView;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* JADX INFO: renamed from: A */
    LayoutInflater.Factory2 m1532A() {
        return this;
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    private class PopBackStackState implements OpGenerator {

        /* JADX INFO: renamed from: a */
        final String f1536a;

        /* JADX INFO: renamed from: b */
        final int f1537b;

        /* JADX INFO: renamed from: c */
        final int f1538c;

        PopBackStackState(String str, int i, int i2) {
            this.f1536a = str;
            this.f1537b = i;
            this.f1538c = i2;
        }

        @Override // android.support.v4.app.FragmentManagerImpl.OpGenerator
        /* JADX INFO: renamed from: a */
        public boolean mo1375a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            FragmentManager fragmentManagerPeekChildFragmentManager;
            if (FragmentManagerImpl.this.f1502p == null || this.f1537b >= 0 || this.f1536a != null || (fragmentManagerPeekChildFragmentManager = FragmentManagerImpl.this.f1502p.peekChildFragmentManager()) == null || !fragmentManagerPeekChildFragmentManager.mo1480d()) {
                return FragmentManagerImpl.this.m1550a(arrayList, arrayList2, this.f1536a, this.f1537b, this.f1538c);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    static class StartEnterTransitionListener implements Fragment.OnStartEnterTransitionListener {

        /* JADX INFO: renamed from: a */
        private final boolean f1540a;

        /* JADX INFO: renamed from: b */
        private final BackStackRecord f1541b;

        /* JADX INFO: renamed from: c */
        private int f1542c;

        StartEnterTransitionListener(BackStackRecord backStackRecord, boolean z) {
            this.f1540a = z;
            this.f1541b = backStackRecord;
        }

        @Override // android.support.v4.app.Fragment.OnStartEnterTransitionListener
        /* JADX INFO: renamed from: a */
        public void mo1419a() {
            this.f1542c--;
            if (this.f1542c == 0) {
                this.f1541b.f1401a.m1500C();
            }
        }

        @Override // android.support.v4.app.Fragment.OnStartEnterTransitionListener
        /* JADX INFO: renamed from: b */
        public void mo1420b() {
            this.f1542c++;
        }

        /* JADX INFO: renamed from: c */
        public boolean m1606c() {
            return this.f1542c == 0;
        }

        /* JADX INFO: renamed from: d */
        public void m1607d() {
            boolean z = this.f1542c > 0;
            FragmentManagerImpl fragmentManagerImpl = this.f1541b.f1401a;
            int size = fragmentManagerImpl.f1491e.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = fragmentManagerImpl.f1491e.get(i);
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            this.f1541b.f1401a.m1509a(this.f1541b, this.f1540a, z ? false : true, true);
        }

        /* JADX INFO: renamed from: e */
        public void m1608e() {
            this.f1541b.f1401a.m1509a(this.f1541b, this.f1540a, false, false);
        }
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    private static class AnimationOrAnimator {

        /* JADX INFO: renamed from: a */
        public final Animation f1528a;

        /* JADX INFO: renamed from: b */
        public final Animator f1529b;

        private AnimationOrAnimator(Animation animation) {
            this.f1528a = animation;
            this.f1529b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        private AnimationOrAnimator(Animator animator) {
            this.f1528a = null;
            this.f1529b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    private static class AnimationListenerWrapper implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a */
        private final Animation.AnimationListener f1527a;

        private AnimationListenerWrapper(Animation.AnimationListener animationListener) {
            this.f1527a = animationListener;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (this.f1527a != null) {
                this.f1527a.onAnimationStart(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.f1527a != null) {
                this.f1527a.onAnimationEnd(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            if (this.f1527a != null) {
                this.f1527a.onAnimationRepeat(animation);
            }
        }
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    private static class AnimateOnHWLayerIfNeededListener extends AnimationListenerWrapper {

        /* JADX INFO: renamed from: a */
        View f1525a;

        AnimateOnHWLayerIfNeededListener(View view, Animation.AnimationListener animationListener) {
            super(animationListener);
            this.f1525a = view;
        }

        @Override // android.support.v4.app.FragmentManagerImpl.AnimationListenerWrapper, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (ViewCompat.m2570B(this.f1525a) || Build.VERSION.SDK_INT >= 24) {
                this.f1525a.post(new Runnable() { // from class: android.support.v4.app.FragmentManagerImpl.AnimateOnHWLayerIfNeededListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnimateOnHWLayerIfNeededListener.this.f1525a.setLayerType(0, null);
                    }
                });
            } else {
                this.f1525a.setLayerType(0, null);
            }
            super.onAnimationEnd(animation);
        }
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    private static class AnimatorOnHWLayerIfNeededListener extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a */
        View f1530a;

        AnimatorOnHWLayerIfNeededListener(View view) {
            this.f1530a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f1530a.setLayerType(2, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1530a.setLayerType(0, null);
            animator.removeListener(this);
        }
    }

    /* JADX INFO: compiled from: FragmentManager.java */
    private static class EndViewTransitionAnimator extends AnimationSet implements Runnable {

        /* JADX INFO: renamed from: a */
        private final ViewGroup f1531a;

        /* JADX INFO: renamed from: b */
        private final View f1532b;

        /* JADX INFO: renamed from: c */
        private boolean f1533c;

        /* JADX INFO: renamed from: d */
        private boolean f1534d;

        EndViewTransitionAnimator(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f1531a = viewGroup;
            this.f1532b = view;
            addAnimation(animation);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (this.f1533c) {
                return !this.f1534d;
            }
            if (super.getTransformation(j, transformation)) {
                return true;
            }
            this.f1533c = true;
            this.f1531a.post(this);
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            if (this.f1533c) {
                return !this.f1534d;
            }
            if (super.getTransformation(j, transformation, f)) {
                return true;
            }
            this.f1533c = true;
            this.f1531a.post(this);
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1531a.endViewTransition(this.f1532b);
            this.f1534d = true;
        }
    }
}

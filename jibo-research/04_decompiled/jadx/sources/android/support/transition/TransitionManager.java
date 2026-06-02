package android.support.transition;

import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class TransitionManager {

    /* JADX INFO: renamed from: a */
    private static Transition f1306a = new AutoTransition();

    /* JADX INFO: renamed from: b */
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> f1307b = new ThreadLocal<>();

    /* JADX INFO: renamed from: c */
    private static ArrayList<ViewGroup> f1308c = new ArrayList<>();

    /* JADX INFO: renamed from: a */
    static ArrayMap<ViewGroup, ArrayList<Transition>> m1249a() {
        WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> weakReference = f1307b.get();
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new ArrayMap());
            f1307b.set(weakReference);
        }
        return weakReference.get();
    }

    /* JADX INFO: renamed from: b */
    private static void m1252b(ViewGroup viewGroup, Transition transition) {
        if (transition != null && viewGroup != null) {
            MultiListener multiListener = new MultiListener(transition, viewGroup);
            viewGroup.addOnAttachStateChangeListener(multiListener);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
        }
    }

    private static class MultiListener implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a */
        Transition f1309a;

        /* JADX INFO: renamed from: b */
        ViewGroup f1310b;

        MultiListener(Transition transition, ViewGroup viewGroup) {
            this.f1309a = transition;
            this.f1310b = viewGroup;
        }

        /* JADX INFO: renamed from: a */
        private void m1254a() {
            this.f1310b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f1310b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            m1254a();
            TransitionManager.f1308c.remove(this.f1310b);
            ArrayList<Transition> arrayList = TransitionManager.m1249a().get(this.f1310b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().mo1239f(this.f1310b);
                }
            }
            this.f1309a.m1229b(true);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ArrayList<Transition> arrayList;
            ArrayList arrayList2;
            m1254a();
            if (TransitionManager.f1308c.remove(this.f1310b)) {
                final ArrayMap<ViewGroup, ArrayList<Transition>> arrayMapM1249a = TransitionManager.m1249a();
                ArrayList<Transition> arrayList3 = arrayMapM1249a.get(this.f1310b);
                if (arrayList3 == null) {
                    ArrayList<Transition> arrayList4 = new ArrayList<>();
                    arrayMapM1249a.put(this.f1310b, arrayList4);
                    arrayList = arrayList4;
                    arrayList2 = null;
                } else if (arrayList3.size() <= 0) {
                    arrayList = arrayList3;
                    arrayList2 = null;
                } else {
                    arrayList = arrayList3;
                    arrayList2 = new ArrayList(arrayList3);
                }
                arrayList.add(this.f1309a);
                this.f1309a.mo1214a(new TransitionListenerAdapter() { // from class: android.support.transition.TransitionManager.MultiListener.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.support.transition.TransitionListenerAdapter, android.support.transition.Transition.TransitionListener
                    /* JADX INFO: renamed from: a */
                    public void mo1088a(Transition transition) {
                        ((ArrayList) arrayMapM1249a.get(MultiListener.this.f1310b)).remove(transition);
                    }
                });
                this.f1309a.m1222a(this.f1310b, false);
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((Transition) it.next()).mo1239f(this.f1310b);
                    }
                }
                this.f1309a.m1220a(this.f1310b);
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m1253c(ViewGroup viewGroup, Transition transition) {
        ArrayList<Transition> arrayList = m1249a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Transition> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().mo1237e(viewGroup);
            }
        }
        if (transition != null) {
            transition.m1222a(viewGroup, true);
        }
        Scene sceneM1187a = Scene.m1187a(viewGroup);
        if (sceneM1187a != null) {
            sceneM1187a.m1189a();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m1250a(ViewGroup viewGroup, Transition transition) {
        if (!f1308c.contains(viewGroup) && ViewCompat.m2621y(viewGroup)) {
            f1308c.add(viewGroup);
            if (transition == null) {
                transition = f1306a;
            }
            Transition transitionClone = transition.clone();
            m1253c(viewGroup, transitionClone);
            Scene.m1188a(viewGroup, null);
            m1252b(viewGroup, transitionClone);
        }
    }
}

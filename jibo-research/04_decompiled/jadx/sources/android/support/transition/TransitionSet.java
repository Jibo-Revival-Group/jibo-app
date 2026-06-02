package android.support.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.transition.Transition;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class TransitionSet extends Transition {

    /* JADX INFO: renamed from: g */
    private ArrayList<Transition> f1313g;

    /* JADX INFO: renamed from: h */
    private boolean f1314h;

    /* JADX INFO: renamed from: i */
    private int f1315i;

    /* JADX INFO: renamed from: j */
    private boolean f1316j;

    /* JADX INFO: renamed from: b */
    static /* synthetic */ int m1259b(TransitionSet transitionSet) {
        int i = transitionSet.f1315i - 1;
        transitionSet.f1315i = i;
        return i;
    }

    public TransitionSet() {
        this.f1313g = new ArrayList<>();
        this.f1314h = true;
        this.f1316j = false;
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1313g = new ArrayList<>();
        this.f1314h = true;
        this.f1316j = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f1259i);
        m1262a(TypedArrayUtils.m1925a(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "transitionOrdering", 0, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: a */
    public TransitionSet m1262a(int i) {
        switch (i) {
            case 0:
                this.f1314h = true;
                return this;
            case 1:
                this.f1314h = false;
                return this;
            default:
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
    }

    /* JADX INFO: renamed from: b */
    public TransitionSet m1266b(Transition transition) {
        this.f1313g.add(transition);
        transition.f1278d = this;
        if (this.f1275a >= 0) {
            transition.mo1212a(this.f1275a);
        }
        return this;
    }

    /* JADX INFO: renamed from: p */
    public int m1272p() {
        return this.f1313g.size();
    }

    /* JADX INFO: renamed from: b */
    public Transition m1264b(int i) {
        if (i < 0 || i >= this.f1313g.size()) {
            return null;
        }
        return this.f1313g.get(i);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public TransitionSet mo1212a(long j) {
        super.mo1212a(j);
        if (this.f1275a >= 0) {
            int size = this.f1313g.size();
            for (int i = 0; i < size; i++) {
                this.f1313g.get(i).mo1212a(j);
            }
        }
        return this;
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public TransitionSet mo1226b(long j) {
        return (TransitionSet) super.mo1226b(j);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TransitionSet mo1213a(TimeInterpolator timeInterpolator) {
        return (TransitionSet) super.mo1213a(timeInterpolator);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public TransitionSet mo1232c(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f1313g.size()) {
                this.f1313g.get(i2).mo1232c(view);
                i = i2 + 1;
            } else {
                return (TransitionSet) super.mo1232c(view);
            }
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public TransitionSet mo1214a(Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.mo1214a(transitionListener);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public TransitionSet mo1235d(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f1313g.size()) {
                this.f1313g.get(i2).mo1235d(view);
                i = i2 + 1;
            } else {
                return (TransitionSet) super.mo1235d(view);
            }
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public TransitionSet mo1227b(Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.mo1227b(transitionListener);
    }

    /* JADX INFO: renamed from: q */
    private void m1261q() {
        TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        Iterator<Transition> it = this.f1313g.iterator();
        while (it.hasNext()) {
            it.next().mo1214a(transitionSetListener);
        }
        this.f1315i = this.f1313g.size();
    }

    static class TransitionSetListener extends TransitionListenerAdapter {

        /* JADX INFO: renamed from: a */
        TransitionSet f1319a;

        TransitionSetListener(TransitionSet transitionSet) {
            this.f1319a = transitionSet;
        }

        @Override // android.support.transition.TransitionListenerAdapter, android.support.transition.Transition.TransitionListener
        /* JADX INFO: renamed from: d */
        public void mo1154d(Transition transition) {
            if (!this.f1319a.f1316j) {
                this.f1319a.m1243j();
                this.f1319a.f1316j = true;
            }
        }

        @Override // android.support.transition.TransitionListenerAdapter, android.support.transition.Transition.TransitionListener
        /* JADX INFO: renamed from: a */
        public void mo1088a(Transition transition) {
            TransitionSet.m1259b(this.f1319a);
            if (this.f1319a.f1315i == 0) {
                this.f1319a.f1316j = false;
                this.f1319a.m1244k();
            }
            transition.mo1227b(this);
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    protected void mo1221a(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long jC = m1231c();
        int size = this.f1313g.size();
        for (int i = 0; i < size; i++) {
            Transition transition = this.f1313g.get(i);
            if (jC > 0 && (this.f1314h || i == 0)) {
                long jM1231c = transition.m1231c();
                if (jM1231c > 0) {
                    transition.mo1226b(jM1231c + jC);
                } else {
                    transition.mo1226b(jC);
                }
            }
            transition.mo1221a(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: e */
    protected void mo1236e() {
        if (this.f1313g.isEmpty()) {
            m1243j();
            m1244k();
            return;
        }
        m1261q();
        if (!this.f1314h) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= this.f1313g.size()) {
                    break;
                }
                Transition transition = this.f1313g.get(i2 - 1);
                final Transition transition2 = this.f1313g.get(i2);
                transition.mo1214a(new TransitionListenerAdapter() { // from class: android.support.transition.TransitionSet.1
                    @Override // android.support.transition.TransitionListenerAdapter, android.support.transition.Transition.TransitionListener
                    /* JADX INFO: renamed from: a */
                    public void mo1088a(Transition transition3) {
                        transition2.mo1236e();
                        transition3.mo1227b(this);
                    }
                });
                i = i2 + 1;
            }
            Transition transition3 = this.f1313g.get(0);
            if (transition3 != null) {
                transition3.mo1236e();
                return;
            }
            return;
        }
        Iterator<Transition> it = this.f1313g.iterator();
        while (it.hasNext()) {
            it.next().mo1236e();
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo406a(TransitionValues transitionValues) {
        if (m1230b(transitionValues.f1324b)) {
            for (Transition transition : this.f1313g) {
                if (transition.m1230b(transitionValues.f1324b)) {
                    transition.mo406a(transitionValues);
                    transitionValues.f1325c.add(transition);
                }
            }
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: b */
    public void mo407b(TransitionValues transitionValues) {
        if (m1230b(transitionValues.f1324b)) {
            for (Transition transition : this.f1313g) {
                if (transition.m1230b(transitionValues.f1324b)) {
                    transition.mo407b(transitionValues);
                    transitionValues.f1325c.add(transition);
                }
            }
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: c */
    void mo1233c(TransitionValues transitionValues) {
        super.mo1233c(transitionValues);
        int size = this.f1313g.size();
        for (int i = 0; i < size; i++) {
            this.f1313g.get(i).mo1233c(transitionValues);
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: e */
    public void mo1237e(View view) {
        super.mo1237e(view);
        int size = this.f1313g.size();
        for (int i = 0; i < size; i++) {
            this.f1313g.get(i).mo1237e(view);
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: f */
    public void mo1239f(View view) {
        super.mo1239f(view);
        int size = this.f1313g.size();
        for (int i = 0; i < size; i++) {
            this.f1313g.get(i).mo1239f(view);
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo1219a(TransitionPropagation transitionPropagation) {
        super.mo1219a(transitionPropagation);
        int size = this.f1313g.size();
        for (int i = 0; i < size; i++) {
            this.f1313g.get(i).mo1219a(transitionPropagation);
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo1218a(Transition.EpicenterCallback epicenterCallback) {
        super.mo1218a(epicenterCallback);
        int size = this.f1313g.size();
        for (int i = 0; i < size; i++) {
            this.f1313g.get(i).mo1218a(epicenterCallback);
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    String mo1216a(String str) {
        String strMo1216a = super.mo1216a(str);
        int i = 0;
        while (i < this.f1313g.size()) {
            String str2 = strMo1216a + "\n" + this.f1313g.get(i).mo1216a(str + "  ");
            i++;
            strMo1216a = str2;
        }
        return strMo1216a;
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: n */
    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.f1313g = new ArrayList<>();
        int size = this.f1313g.size();
        for (int i = 0; i < size; i++) {
            transitionSet.m1266b(this.f1313g.get(i).clone());
        }
        return transitionSet;
    }
}

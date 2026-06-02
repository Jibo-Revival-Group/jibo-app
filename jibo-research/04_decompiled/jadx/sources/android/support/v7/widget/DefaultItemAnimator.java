package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DefaultItemAnimator extends SimpleItemAnimator {

    /* JADX INFO: renamed from: i */
    private static TimeInterpolator f3786i;

    /* JADX INFO: renamed from: j */
    private ArrayList<RecyclerView.ViewHolder> f3794j = new ArrayList<>();

    /* JADX INFO: renamed from: k */
    private ArrayList<RecyclerView.ViewHolder> f3795k = new ArrayList<>();

    /* JADX INFO: renamed from: l */
    private ArrayList<MoveInfo> f3796l = new ArrayList<>();

    /* JADX INFO: renamed from: m */
    private ArrayList<ChangeInfo> f3797m = new ArrayList<>();

    /* JADX INFO: renamed from: a */
    ArrayList<ArrayList<RecyclerView.ViewHolder>> f3787a = new ArrayList<>();

    /* JADX INFO: renamed from: b */
    ArrayList<ArrayList<MoveInfo>> f3788b = new ArrayList<>();

    /* JADX INFO: renamed from: c */
    ArrayList<ArrayList<ChangeInfo>> f3789c = new ArrayList<>();

    /* JADX INFO: renamed from: d */
    ArrayList<RecyclerView.ViewHolder> f3790d = new ArrayList<>();

    /* JADX INFO: renamed from: e */
    ArrayList<RecyclerView.ViewHolder> f3791e = new ArrayList<>();

    /* JADX INFO: renamed from: f */
    ArrayList<RecyclerView.ViewHolder> f3792f = new ArrayList<>();

    /* JADX INFO: renamed from: g */
    ArrayList<RecyclerView.ViewHolder> f3793g = new ArrayList<>();

    private static class MoveInfo {

        /* JADX INFO: renamed from: a */
        public RecyclerView.ViewHolder f3832a;

        /* JADX INFO: renamed from: b */
        public int f3833b;

        /* JADX INFO: renamed from: c */
        public int f3834c;

        /* JADX INFO: renamed from: d */
        public int f3835d;

        /* JADX INFO: renamed from: e */
        public int f3836e;

        MoveInfo(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
            this.f3832a = viewHolder;
            this.f3833b = i;
            this.f3834c = i2;
            this.f3835d = i3;
            this.f3836e = i4;
        }
    }

    private static class ChangeInfo {

        /* JADX INFO: renamed from: a */
        public RecyclerView.ViewHolder f3826a;

        /* JADX INFO: renamed from: b */
        public RecyclerView.ViewHolder f3827b;

        /* JADX INFO: renamed from: c */
        public int f3828c;

        /* JADX INFO: renamed from: d */
        public int f3829d;

        /* JADX INFO: renamed from: e */
        public int f3830e;

        /* JADX INFO: renamed from: f */
        public int f3831f;

        private ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.f3826a = viewHolder;
            this.f3827b = viewHolder2;
        }

        ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
            this(viewHolder, viewHolder2);
            this.f3828c = i;
            this.f3829d = i2;
            this.f3830e = i3;
            this.f3831f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f3826a + ", newHolder=" + this.f3827b + ", fromX=" + this.f3828c + ", fromY=" + this.f3829d + ", toX=" + this.f3830e + ", toY=" + this.f3831f + '}';
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    /* JADX INFO: renamed from: a */
    public void mo4100a() {
        boolean z = !this.f3794j.isEmpty();
        boolean z2 = !this.f3796l.isEmpty();
        boolean z3 = !this.f3797m.isEmpty();
        boolean z4 = !this.f3795k.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.ViewHolder> it = this.f3794j.iterator();
            while (it.hasNext()) {
                m4098u(it.next());
            }
            this.f3794j.clear();
            if (z2) {
                final ArrayList<MoveInfo> arrayList = new ArrayList<>();
                arrayList.addAll(this.f3796l);
                this.f3788b.add(arrayList);
                this.f3796l.clear();
                Runnable runnable = new Runnable() { // from class: android.support.v7.widget.DefaultItemAnimator.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (MoveInfo moveInfo : arrayList) {
                            DefaultItemAnimator.this.m4107b(moveInfo.f3832a, moveInfo.f3833b, moveInfo.f3834c, moveInfo.f3835d, moveInfo.f3836e);
                        }
                        arrayList.clear();
                        DefaultItemAnimator.this.f3788b.remove(arrayList);
                    }
                };
                if (z) {
                    ViewCompat.m2587a(arrayList.get(0).f3832a.itemView, runnable, m4448g());
                } else {
                    runnable.run();
                }
            }
            if (z3) {
                final ArrayList<ChangeInfo> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.f3797m);
                this.f3789c.add(arrayList2);
                this.f3797m.clear();
                Runnable runnable2 = new Runnable() { // from class: android.support.v7.widget.DefaultItemAnimator.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            DefaultItemAnimator.this.m4101a((ChangeInfo) it2.next());
                        }
                        arrayList2.clear();
                        DefaultItemAnimator.this.f3789c.remove(arrayList2);
                    }
                };
                if (z) {
                    ViewCompat.m2587a(arrayList2.get(0).f3826a.itemView, runnable2, m4448g());
                } else {
                    runnable2.run();
                }
            }
            if (z4) {
                final ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f3795k);
                this.f3787a.add(arrayList3);
                this.f3795k.clear();
                Runnable runnable3 = new Runnable() { // from class: android.support.v7.widget.DefaultItemAnimator.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            DefaultItemAnimator.this.m4111c((RecyclerView.ViewHolder) it2.next());
                        }
                        arrayList3.clear();
                        DefaultItemAnimator.this.f3787a.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    ViewCompat.m2587a(arrayList3.get(0).itemView, runnable3, (z ? m4448g() : 0L) + Math.max(z2 ? m4445e() : 0L, z3 ? m4450h() : 0L));
                } else {
                    runnable3.run();
                }
            }
        }
    }

    @Override // android.support.v7.widget.SimpleItemAnimator
    /* JADX INFO: renamed from: a */
    public boolean mo4103a(RecyclerView.ViewHolder viewHolder) {
        m4099v(viewHolder);
        this.f3794j.add(viewHolder);
        return true;
    }

    /* JADX INFO: renamed from: u */
    private void m4098u(final RecyclerView.ViewHolder viewHolder) {
        final View view = viewHolder.itemView;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f3792f.add(viewHolder);
        viewPropertyAnimatorAnimate.setDuration(m4448g()).alpha(CropImageView.DEFAULT_ASPECT_RATIO).setListener(new AnimatorListenerAdapter() { // from class: android.support.v7.widget.DefaultItemAnimator.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.m4793l(viewHolder);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                view.setAlpha(1.0f);
                DefaultItemAnimator.this.m4790i(viewHolder);
                DefaultItemAnimator.this.f3792f.remove(viewHolder);
                DefaultItemAnimator.this.m4110c();
            }
        }).start();
    }

    @Override // android.support.v7.widget.SimpleItemAnimator
    /* JADX INFO: renamed from: b */
    public boolean mo4109b(RecyclerView.ViewHolder viewHolder) {
        m4099v(viewHolder);
        viewHolder.itemView.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
        this.f3795k.add(viewHolder);
        return true;
    }

    /* JADX INFO: renamed from: c */
    void m4111c(final RecyclerView.ViewHolder viewHolder) {
        final View view = viewHolder.itemView;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f3790d.add(viewHolder);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(m4446f()).setListener(new AnimatorListenerAdapter() { // from class: android.support.v7.widget.DefaultItemAnimator.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.m4795n(viewHolder);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                DefaultItemAnimator.this.m4792k(viewHolder);
                DefaultItemAnimator.this.f3790d.remove(viewHolder);
                DefaultItemAnimator.this.m4110c();
            }
        }).start();
    }

    @Override // android.support.v7.widget.SimpleItemAnimator
    /* JADX INFO: renamed from: a */
    public boolean mo4104a(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.itemView;
        int translationX = i + ((int) viewHolder.itemView.getTranslationX());
        int translationY = i2 + ((int) viewHolder.itemView.getTranslationY());
        m4099v(viewHolder);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            m4791j(viewHolder);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.f3796l.add(new MoveInfo(viewHolder, translationX, translationY, i3, i4));
        return true;
    }

    /* JADX INFO: renamed from: b */
    void m4107b(final RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        final View view = viewHolder.itemView;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(CropImageView.DEFAULT_ASPECT_RATIO);
        }
        if (i6 != 0) {
            view.animate().translationY(CropImageView.DEFAULT_ASPECT_RATIO);
        }
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f3791e.add(viewHolder);
        viewPropertyAnimatorAnimate.setDuration(m4445e()).setListener(new AnimatorListenerAdapter() { // from class: android.support.v7.widget.DefaultItemAnimator.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.m4794m(viewHolder);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i5 != 0) {
                    view.setTranslationX(CropImageView.DEFAULT_ASPECT_RATIO);
                }
                if (i6 != 0) {
                    view.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                DefaultItemAnimator.this.m4791j(viewHolder);
                DefaultItemAnimator.this.f3791e.remove(viewHolder);
                DefaultItemAnimator.this.m4110c();
            }
        }).start();
    }

    @Override // android.support.v7.widget.SimpleItemAnimator
    /* JADX INFO: renamed from: a */
    public boolean mo4105a(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        if (viewHolder == viewHolder2) {
            return mo4104a(viewHolder, i, i2, i3, i4);
        }
        float translationX = viewHolder.itemView.getTranslationX();
        float translationY = viewHolder.itemView.getTranslationY();
        float alpha = viewHolder.itemView.getAlpha();
        m4099v(viewHolder);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        viewHolder.itemView.setTranslationX(translationX);
        viewHolder.itemView.setTranslationY(translationY);
        viewHolder.itemView.setAlpha(alpha);
        if (viewHolder2 != null) {
            m4099v(viewHolder2);
            viewHolder2.itemView.setTranslationX(-i5);
            viewHolder2.itemView.setTranslationY(-i6);
            viewHolder2.itemView.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
        }
        this.f3797m.add(new ChangeInfo(viewHolder, viewHolder2, i, i2, i3, i4));
        return true;
    }

    /* JADX INFO: renamed from: a */
    void m4101a(final ChangeInfo changeInfo) {
        RecyclerView.ViewHolder viewHolder = changeInfo.f3826a;
        final View view = viewHolder == null ? null : viewHolder.itemView;
        RecyclerView.ViewHolder viewHolder2 = changeInfo.f3827b;
        final View view2 = viewHolder2 != null ? viewHolder2.itemView : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(m4450h());
            this.f3793g.add(changeInfo.f3826a);
            duration.translationX(changeInfo.f3830e - changeInfo.f3828c);
            duration.translationY(changeInfo.f3831f - changeInfo.f3829d);
            duration.alpha(CropImageView.DEFAULT_ASPECT_RATIO).setListener(new AnimatorListenerAdapter() { // from class: android.support.v7.widget.DefaultItemAnimator.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    DefaultItemAnimator.this.m4787b(changeInfo.f3826a, true);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(CropImageView.DEFAULT_ASPECT_RATIO);
                    view.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
                    DefaultItemAnimator.this.m4786a(changeInfo.f3826a, true);
                    DefaultItemAnimator.this.f3793g.remove(changeInfo.f3826a);
                    DefaultItemAnimator.this.m4110c();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.f3793g.add(changeInfo.f3827b);
            viewPropertyAnimatorAnimate.translationX(CropImageView.DEFAULT_ASPECT_RATIO).translationY(CropImageView.DEFAULT_ASPECT_RATIO).setDuration(m4450h()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: android.support.v7.widget.DefaultItemAnimator.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    DefaultItemAnimator.this.m4787b(changeInfo.f3827b, false);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorAnimate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(CropImageView.DEFAULT_ASPECT_RATIO);
                    view2.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
                    DefaultItemAnimator.this.m4786a(changeInfo.f3827b, false);
                    DefaultItemAnimator.this.f3793g.remove(changeInfo.f3827b);
                    DefaultItemAnimator.this.m4110c();
                }
            }).start();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4095a(List<ChangeInfo> list, RecyclerView.ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = list.get(size);
            if (m4096a(changeInfo, viewHolder) && changeInfo.f3826a == null && changeInfo.f3827b == null) {
                list.remove(changeInfo);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m4097b(ChangeInfo changeInfo) {
        if (changeInfo.f3826a != null) {
            m4096a(changeInfo, changeInfo.f3826a);
        }
        if (changeInfo.f3827b != null) {
            m4096a(changeInfo, changeInfo.f3827b);
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m4096a(ChangeInfo changeInfo, RecyclerView.ViewHolder viewHolder) {
        boolean z = false;
        if (changeInfo.f3827b == viewHolder) {
            changeInfo.f3827b = null;
        } else {
            if (changeInfo.f3826a != viewHolder) {
                return false;
            }
            changeInfo.f3826a = null;
            z = true;
        }
        viewHolder.itemView.setAlpha(1.0f);
        viewHolder.itemView.setTranslationX(CropImageView.DEFAULT_ASPECT_RATIO);
        viewHolder.itemView.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
        m4786a(viewHolder, z);
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    /* JADX INFO: renamed from: d */
    public void mo4113d(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        view.animate().cancel();
        for (int size = this.f3796l.size() - 1; size >= 0; size--) {
            if (this.f3796l.get(size).f3832a == viewHolder) {
                view.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
                view.setTranslationX(CropImageView.DEFAULT_ASPECT_RATIO);
                m4791j(viewHolder);
                this.f3796l.remove(size);
            }
        }
        m4095a(this.f3797m, viewHolder);
        if (this.f3794j.remove(viewHolder)) {
            view.setAlpha(1.0f);
            m4790i(viewHolder);
        }
        if (this.f3795k.remove(viewHolder)) {
            view.setAlpha(1.0f);
            m4792k(viewHolder);
        }
        for (int size2 = this.f3789c.size() - 1; size2 >= 0; size2--) {
            ArrayList<ChangeInfo> arrayList = this.f3789c.get(size2);
            m4095a(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.f3789c.remove(size2);
            }
        }
        for (int size3 = this.f3788b.size() - 1; size3 >= 0; size3--) {
            ArrayList<MoveInfo> arrayList2 = this.f3788b.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f3832a != viewHolder) {
                    size4--;
                } else {
                    view.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
                    view.setTranslationX(CropImageView.DEFAULT_ASPECT_RATIO);
                    m4791j(viewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f3788b.remove(size3);
                    }
                }
            }
        }
        for (int size5 = this.f3787a.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.ViewHolder> arrayList3 = this.f3787a.get(size5);
            if (arrayList3.remove(viewHolder)) {
                view.setAlpha(1.0f);
                m4792k(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.f3787a.remove(size5);
                }
            }
        }
        if (this.f3792f.remove(viewHolder)) {
        }
        if (this.f3790d.remove(viewHolder)) {
        }
        if (this.f3793g.remove(viewHolder)) {
        }
        if (this.f3791e.remove(viewHolder)) {
        }
        m4110c();
    }

    /* JADX INFO: renamed from: v */
    private void m4099v(RecyclerView.ViewHolder viewHolder) {
        if (f3786i == null) {
            f3786i = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(f3786i);
        mo4113d(viewHolder);
    }

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    /* JADX INFO: renamed from: b */
    public boolean mo4108b() {
        return (this.f3795k.isEmpty() && this.f3797m.isEmpty() && this.f3796l.isEmpty() && this.f3794j.isEmpty() && this.f3791e.isEmpty() && this.f3792f.isEmpty() && this.f3790d.isEmpty() && this.f3793g.isEmpty() && this.f3788b.isEmpty() && this.f3787a.isEmpty() && this.f3789c.isEmpty()) ? false : true;
    }

    /* JADX INFO: renamed from: c */
    void m4110c() {
        if (!mo4108b()) {
            m4452i();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    /* JADX INFO: renamed from: d */
    public void mo4112d() {
        for (int size = this.f3796l.size() - 1; size >= 0; size--) {
            MoveInfo moveInfo = this.f3796l.get(size);
            View view = moveInfo.f3832a.itemView;
            view.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
            view.setTranslationX(CropImageView.DEFAULT_ASPECT_RATIO);
            m4791j(moveInfo.f3832a);
            this.f3796l.remove(size);
        }
        for (int size2 = this.f3794j.size() - 1; size2 >= 0; size2--) {
            m4790i(this.f3794j.get(size2));
            this.f3794j.remove(size2);
        }
        for (int size3 = this.f3795k.size() - 1; size3 >= 0; size3--) {
            RecyclerView.ViewHolder viewHolder = this.f3795k.get(size3);
            viewHolder.itemView.setAlpha(1.0f);
            m4792k(viewHolder);
            this.f3795k.remove(size3);
        }
        for (int size4 = this.f3797m.size() - 1; size4 >= 0; size4--) {
            m4097b(this.f3797m.get(size4));
        }
        this.f3797m.clear();
        if (mo4108b()) {
            for (int size5 = this.f3788b.size() - 1; size5 >= 0; size5--) {
                ArrayList<MoveInfo> arrayList = this.f3788b.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    MoveInfo moveInfo2 = arrayList.get(size6);
                    View view2 = moveInfo2.f3832a.itemView;
                    view2.setTranslationY(CropImageView.DEFAULT_ASPECT_RATIO);
                    view2.setTranslationX(CropImageView.DEFAULT_ASPECT_RATIO);
                    m4791j(moveInfo2.f3832a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f3788b.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f3787a.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.ViewHolder> arrayList2 = this.f3787a.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ViewHolder viewHolder2 = arrayList2.get(size8);
                    viewHolder2.itemView.setAlpha(1.0f);
                    m4792k(viewHolder2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f3787a.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f3789c.size() - 1; size9 >= 0; size9--) {
                ArrayList<ChangeInfo> arrayList3 = this.f3789c.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    m4097b(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f3789c.remove(arrayList3);
                    }
                }
            }
            m4102a(this.f3792f);
            m4102a(this.f3791e);
            m4102a(this.f3790d);
            m4102a(this.f3793g);
            m4452i();
        }
    }

    /* JADX INFO: renamed from: a */
    void m4102a(List<RecyclerView.ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemAnimator
    /* JADX INFO: renamed from: a */
    public boolean mo4106a(RecyclerView.ViewHolder viewHolder, List<Object> list) {
        return !list.isEmpty() || super.mo4106a(viewHolder, list);
    }
}

package android.support.v7.widget;

import android.support.v4.os.TraceCompat;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class GapWorker implements Runnable {

    /* JADX INFO: renamed from: a */
    static final ThreadLocal<GapWorker> f3904a = new ThreadLocal<>();

    /* JADX INFO: renamed from: e */
    static Comparator<Task> f3905e = new Comparator<Task>() { // from class: android.support.v7.widget.GapWorker.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Task task, Task task2) {
            if ((task.f3917d == null) != (task2.f3917d == null)) {
                return task.f3917d == null ? 1 : -1;
            }
            if (task.f3914a != task2.f3914a) {
                return task.f3914a ? -1 : 1;
            }
            int i = task2.f3915b - task.f3915b;
            if (i == 0) {
                int i2 = task.f3916c - task2.f3916c;
                if (i2 == 0) {
                    return 0;
                }
                return i2;
            }
            return i;
        }
    };

    /* JADX INFO: renamed from: c */
    long f3907c;

    /* JADX INFO: renamed from: d */
    long f3908d;

    /* JADX INFO: renamed from: b */
    ArrayList<RecyclerView> f3906b = new ArrayList<>();

    /* JADX INFO: renamed from: f */
    private ArrayList<Task> f3909f = new ArrayList<>();

    GapWorker() {
    }

    static class Task {

        /* JADX INFO: renamed from: a */
        public boolean f3914a;

        /* JADX INFO: renamed from: b */
        public int f3915b;

        /* JADX INFO: renamed from: c */
        public int f3916c;

        /* JADX INFO: renamed from: d */
        public RecyclerView f3917d;

        /* JADX INFO: renamed from: e */
        public int f3918e;

        Task() {
        }

        /* JADX INFO: renamed from: a */
        public void m4188a() {
            this.f3914a = false;
            this.f3915b = 0;
            this.f3916c = 0;
            this.f3917d = null;
            this.f3918e = 0;
        }
    }

    static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {

        /* JADX INFO: renamed from: a */
        int f3910a;

        /* JADX INFO: renamed from: b */
        int f3911b;

        /* JADX INFO: renamed from: c */
        int[] f3912c;

        /* JADX INFO: renamed from: d */
        int f3913d;

        LayoutPrefetchRegistryImpl() {
        }

        /* JADX INFO: renamed from: a */
        void m4184a(int i, int i2) {
            this.f3910a = i;
            this.f3911b = i2;
        }

        /* JADX INFO: renamed from: a */
        void m4185a(RecyclerView recyclerView, boolean z) {
            this.f3913d = 0;
            if (this.f3912c != null) {
                Arrays.fill(this.f3912c, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && layoutManager != null && layoutManager.m4555p()) {
                if (z) {
                    if (!recyclerView.mAdapterHelper.m3821d()) {
                        layoutManager.mo4292a(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    layoutManager.mo4291a(this.f3910a, this.f3911b, recyclerView.mState, this);
                }
                if (this.f3913d > layoutManager.f4087x) {
                    layoutManager.f4087x = this.f3913d;
                    layoutManager.f4088y = z;
                    recyclerView.mRecycler.m4610b();
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry
        /* JADX INFO: renamed from: b */
        public void mo4187b(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.f3913d * 2;
            if (this.f3912c == null) {
                this.f3912c = new int[4];
                Arrays.fill(this.f3912c, -1);
            } else if (i3 >= this.f3912c.length) {
                int[] iArr = this.f3912c;
                this.f3912c = new int[i3 * 2];
                System.arraycopy(iArr, 0, this.f3912c, 0, iArr.length);
            }
            this.f3912c[i3] = i;
            this.f3912c[i3 + 1] = i2;
            this.f3913d++;
        }

        /* JADX INFO: renamed from: a */
        boolean m4186a(int i) {
            if (this.f3912c == null) {
                return false;
            }
            int i2 = this.f3913d * 2;
            for (int i3 = 0; i3 < i2; i3 += 2) {
                if (this.f3912c[i3] == i) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        void m4183a() {
            if (this.f3912c != null) {
                Arrays.fill(this.f3912c, -1);
            }
            this.f3913d = 0;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m4179a(RecyclerView recyclerView) {
        this.f3906b.add(recyclerView);
    }

    /* JADX INFO: renamed from: b */
    public void m4181b(RecyclerView recyclerView) {
        this.f3906b.remove(recyclerView);
    }

    /* JADX INFO: renamed from: a */
    void m4180a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f3907c == 0) {
            this.f3907c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.m4184a(i, i2);
    }

    /* JADX INFO: renamed from: a */
    private void m4173a() {
        Task task;
        int i;
        int size = this.f3906b.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            RecyclerView recyclerView = this.f3906b.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.m4185a(recyclerView, false);
                i = recyclerView.mPrefetchRegistry.f3913d + i3;
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        this.f3909f.ensureCapacity(i3);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView2 = this.f3906b.get(i5);
            if (recyclerView2.getWindowVisibility() == 0) {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView2.mPrefetchRegistry;
                int iAbs = Math.abs(layoutPrefetchRegistryImpl.f3910a) + Math.abs(layoutPrefetchRegistryImpl.f3911b);
                int i6 = i4;
                for (int i7 = 0; i7 < layoutPrefetchRegistryImpl.f3913d * 2; i7 += 2) {
                    if (i6 >= this.f3909f.size()) {
                        task = new Task();
                        this.f3909f.add(task);
                    } else {
                        task = this.f3909f.get(i6);
                    }
                    int i8 = layoutPrefetchRegistryImpl.f3912c[i7 + 1];
                    task.f3914a = i8 <= iAbs;
                    task.f3915b = iAbs;
                    task.f3916c = i8;
                    task.f3917d = recyclerView2;
                    task.f3918e = layoutPrefetchRegistryImpl.f3912c[i7];
                    i6++;
                }
                i4 = i6;
            }
        }
        Collections.sort(this.f3909f, f3905e);
    }

    /* JADX INFO: renamed from: a */
    static boolean m4176a(RecyclerView recyclerView, int i) {
        int iM4017c = recyclerView.mChildHelper.m4017c();
        for (int i2 = 0; i2 < iM4017c; i2++) {
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.m4020d(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private RecyclerView.ViewHolder m4172a(RecyclerView recyclerView, int i, long j) {
        if (m4176a(recyclerView, i)) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.ViewHolder viewHolderM4595a = recycler.m4595a(i, false, j);
            if (viewHolderM4595a != null) {
                if (viewHolderM4595a.isBound() && !viewHolderM4595a.isInvalid()) {
                    recycler.m4606a(viewHolderM4595a.itemView);
                } else {
                    recycler.m4605a(viewHolderM4595a, false);
                }
            }
            return viewHolderM4595a;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4175a(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.m4017c() != 0) {
                recyclerView.removeAndRecycleViews();
            }
            LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
            layoutPrefetchRegistryImpl.m4185a(recyclerView, true);
            if (layoutPrefetchRegistryImpl.f3913d != 0) {
                try {
                    TraceCompat.m2325a("RV Nested Prefetch");
                    recyclerView.mState.m4657a(recyclerView.mAdapter);
                    for (int i = 0; i < layoutPrefetchRegistryImpl.f3913d * 2; i += 2) {
                        m4172a(recyclerView, layoutPrefetchRegistryImpl.f3912c[i], j);
                    }
                } finally {
                    TraceCompat.m2324a();
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4174a(Task task, long j) {
        RecyclerView.ViewHolder viewHolderM4172a = m4172a(task.f3917d, task.f3918e, task.f3914a ? Long.MAX_VALUE : j);
        if (viewHolderM4172a != null && viewHolderM4172a.mNestedRecyclerView != null && viewHolderM4172a.isBound() && !viewHolderM4172a.isInvalid()) {
            m4175a(viewHolderM4172a.mNestedRecyclerView.get(), j);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m4177b(long j) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f3909f.size()) {
                Task task = this.f3909f.get(i2);
                if (task.f3917d != null) {
                    m4174a(task, j);
                    task.m4188a();
                    i = i2 + 1;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m4178a(long j) {
        m4173a();
        m4177b(j);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            TraceCompat.m2325a("RV Prefetch");
            if (this.f3906b.isEmpty()) {
                return;
            }
            int size = this.f3906b.size();
            int i = 0;
            long jMax = 0;
            while (i < size) {
                RecyclerView recyclerView = this.f3906b.get(i);
                i++;
                jMax = recyclerView.getWindowVisibility() == 0 ? Math.max(recyclerView.getDrawingTime(), jMax) : jMax;
            }
            if (jMax == 0) {
                return;
            }
            m4178a(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f3908d);
        } finally {
            this.f3907c = 0L;
            TraceCompat.m2324a();
        }
    }
}

package android.support.v7.widget;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.Pools;
import android.support.v7.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
class ViewInfoStore {

    /* JADX INFO: renamed from: a */
    final ArrayMap<RecyclerView.ViewHolder, InfoRecord> f4494a = new ArrayMap<>();

    /* JADX INFO: renamed from: b */
    final LongSparseArray<RecyclerView.ViewHolder> f4495b = new LongSparseArray<>();

    interface ProcessCallback {
        /* JADX INFO: renamed from: a */
        void mo4416a(RecyclerView.ViewHolder viewHolder);

        /* JADX INFO: renamed from: a */
        void mo4417a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        /* JADX INFO: renamed from: b */
        void mo4418b(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        /* JADX INFO: renamed from: c */
        void mo4419c(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);
    }

    ViewInfoStore() {
    }

    /* JADX INFO: renamed from: a */
    void m5010a() {
        this.f4494a.clear();
        this.f4495b.m2415c();
    }

    /* JADX INFO: renamed from: a */
    void m5012a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecordM5025a = this.f4494a.get(viewHolder);
        if (infoRecordM5025a == null) {
            infoRecordM5025a = InfoRecord.m5025a();
            this.f4494a.put(viewHolder, infoRecordM5025a);
        }
        infoRecordM5025a.f4498b = itemHolderInfo;
        infoRecordM5025a.f4497a |= 4;
    }

    /* JADX INFO: renamed from: a */
    boolean m5014a(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f4494a.get(viewHolder);
        return (infoRecord == null || (infoRecord.f4497a & 1) == 0) ? false : true;
    }

    /* JADX INFO: renamed from: b */
    RecyclerView.ItemAnimator.ItemHolderInfo m5015b(RecyclerView.ViewHolder viewHolder) {
        return m5008a(viewHolder, 4);
    }

    /* JADX INFO: renamed from: c */
    RecyclerView.ItemAnimator.ItemHolderInfo m5018c(RecyclerView.ViewHolder viewHolder) {
        return m5008a(viewHolder, 8);
    }

    /* JADX INFO: renamed from: a */
    private RecyclerView.ItemAnimator.ItemHolderInfo m5008a(RecyclerView.ViewHolder viewHolder, int i) {
        InfoRecord infoRecordC;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo = null;
        int iA = this.f4494a.m2446a(viewHolder);
        if (iA >= 0 && (infoRecordC = this.f4494a.m2453c(iA)) != null && (infoRecordC.f4497a & i) != 0) {
            infoRecordC.f4497a &= i ^ (-1);
            if (i == 4) {
                itemHolderInfo = infoRecordC.f4498b;
            } else if (i == 8) {
                itemHolderInfo = infoRecordC.f4499c;
            } else {
                throw new IllegalArgumentException("Must provide flag PRE or POST");
            }
            if ((infoRecordC.f4497a & 12) == 0) {
                this.f4494a.m2454d(iA);
                InfoRecord.m5026a(infoRecordC);
            }
        }
        return itemHolderInfo;
    }

    /* JADX INFO: renamed from: a */
    void m5011a(long j, RecyclerView.ViewHolder viewHolder) {
        this.f4495b.m2412b(j, viewHolder);
    }

    /* JADX INFO: renamed from: b */
    void m5017b(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecordM5025a = this.f4494a.get(viewHolder);
        if (infoRecordM5025a == null) {
            infoRecordM5025a = InfoRecord.m5025a();
            this.f4494a.put(viewHolder, infoRecordM5025a);
        }
        infoRecordM5025a.f4497a |= 2;
        infoRecordM5025a.f4498b = itemHolderInfo;
    }

    /* JADX INFO: renamed from: d */
    boolean m5020d(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f4494a.get(viewHolder);
        return (infoRecord == null || (infoRecord.f4497a & 4) == 0) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    RecyclerView.ViewHolder m5009a(long j) {
        return this.f4495b.m2406a(j);
    }

    /* JADX INFO: renamed from: c */
    void m5019c(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecordM5025a = this.f4494a.get(viewHolder);
        if (infoRecordM5025a == null) {
            infoRecordM5025a = InfoRecord.m5025a();
            this.f4494a.put(viewHolder, infoRecordM5025a);
        }
        infoRecordM5025a.f4499c = itemHolderInfo;
        infoRecordM5025a.f4497a |= 8;
    }

    /* JADX INFO: renamed from: e */
    void m5021e(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecordM5025a = this.f4494a.get(viewHolder);
        if (infoRecordM5025a == null) {
            infoRecordM5025a = InfoRecord.m5025a();
            this.f4494a.put(viewHolder, infoRecordM5025a);
        }
        infoRecordM5025a.f4497a |= 1;
    }

    /* JADX INFO: renamed from: f */
    void m5022f(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f4494a.get(viewHolder);
        if (infoRecord != null) {
            infoRecord.f4497a &= -2;
        }
    }

    /* JADX INFO: renamed from: a */
    void m5013a(ProcessCallback processCallback) {
        for (int size = this.f4494a.size() - 1; size >= 0; size--) {
            RecyclerView.ViewHolder viewHolderB = this.f4494a.m2452b(size);
            InfoRecord infoRecordD = this.f4494a.m2454d(size);
            if ((infoRecordD.f4497a & 3) == 3) {
                processCallback.mo4416a(viewHolderB);
            } else if ((infoRecordD.f4497a & 1) != 0) {
                if (infoRecordD.f4498b == null) {
                    processCallback.mo4416a(viewHolderB);
                } else {
                    processCallback.mo4417a(viewHolderB, infoRecordD.f4498b, infoRecordD.f4499c);
                }
            } else if ((infoRecordD.f4497a & 14) == 14) {
                processCallback.mo4418b(viewHolderB, infoRecordD.f4498b, infoRecordD.f4499c);
            } else if ((infoRecordD.f4497a & 12) == 12) {
                processCallback.mo4419c(viewHolderB, infoRecordD.f4498b, infoRecordD.f4499c);
            } else if ((infoRecordD.f4497a & 4) != 0) {
                processCallback.mo4417a(viewHolderB, infoRecordD.f4498b, null);
            } else if ((infoRecordD.f4497a & 8) != 0) {
                processCallback.mo4418b(viewHolderB, infoRecordD.f4498b, infoRecordD.f4499c);
            } else if ((infoRecordD.f4497a & 2) != 0) {
            }
            InfoRecord.m5026a(infoRecordD);
        }
    }

    /* JADX INFO: renamed from: g */
    void m5023g(RecyclerView.ViewHolder viewHolder) {
        int iM2409b = this.f4495b.m2409b() - 1;
        while (true) {
            if (iM2409b < 0) {
                break;
            }
            if (viewHolder != this.f4495b.m2414c(iM2409b)) {
                iM2409b--;
            } else {
                this.f4495b.m2408a(iM2409b);
                break;
            }
        }
        InfoRecord infoRecordRemove = this.f4494a.remove(viewHolder);
        if (infoRecordRemove != null) {
            InfoRecord.m5026a(infoRecordRemove);
        }
    }

    /* JADX INFO: renamed from: b */
    void m5016b() {
        InfoRecord.m5027b();
    }

    /* JADX INFO: renamed from: h */
    public void m5024h(RecyclerView.ViewHolder viewHolder) {
        m5022f(viewHolder);
    }

    static class InfoRecord {

        /* JADX INFO: renamed from: d */
        static Pools.Pool<InfoRecord> f4496d = new Pools.SimplePool(20);

        /* JADX INFO: renamed from: a */
        int f4497a;

        /* JADX INFO: renamed from: b */
        RecyclerView.ItemAnimator.ItemHolderInfo f4498b;

        /* JADX INFO: renamed from: c */
        RecyclerView.ItemAnimator.ItemHolderInfo f4499c;

        private InfoRecord() {
        }

        /* JADX INFO: renamed from: a */
        static InfoRecord m5025a() {
            InfoRecord infoRecordMo2438a = f4496d.mo2438a();
            return infoRecordMo2438a == null ? new InfoRecord() : infoRecordMo2438a;
        }

        /* JADX INFO: renamed from: a */
        static void m5026a(InfoRecord infoRecord) {
            infoRecord.f4497a = 0;
            infoRecord.f4498b = null;
            infoRecord.f4499c = null;
            f4496d.mo2439a(infoRecord);
        }

        /* JADX INFO: renamed from: b */
        static void m5027b() {
            while (f4496d.mo2438a() != null) {
            }
        }
    }
}

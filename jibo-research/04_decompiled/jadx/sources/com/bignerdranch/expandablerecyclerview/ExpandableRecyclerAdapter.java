package com.bignerdranch.expandablerecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.bignerdranch.expandablerecyclerview.model.ExpandableWrapper;
import com.bignerdranch.expandablerecyclerview.model.Parent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class ExpandableRecyclerAdapter<P extends Parent<C>, C, PVH extends ParentViewHolder, CVH extends ChildViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a */
    protected List<ExpandableWrapper<P, C>> f4649a;

    /* JADX INFO: renamed from: b */
    private List<P> f4650b;

    /* JADX INFO: renamed from: c */
    private ExpandCollapseListener f4651c;

    /* JADX INFO: renamed from: e */
    private Map<P, Boolean> f4653e;

    /* JADX INFO: renamed from: f */
    private ParentViewHolder.ParentViewHolderExpandCollapseListener f4654f = new ParentViewHolder.ParentViewHolderExpandCollapseListener() { // from class: com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter.1
        @Override // com.bignerdranch.expandablerecyclerview.ParentViewHolder.ParentViewHolderExpandCollapseListener
        /* JADX INFO: renamed from: a */
        public void mo5184a(int i) {
            ExpandableRecyclerAdapter.this.m5179c(i);
        }

        @Override // com.bignerdranch.expandablerecyclerview.ParentViewHolder.ParentViewHolderExpandCollapseListener
        /* JADX INFO: renamed from: b */
        public void mo5185b(int i) {
            ExpandableRecyclerAdapter.this.m5180d(i);
        }
    };

    /* JADX INFO: renamed from: d */
    private List<RecyclerView> f4652d = new ArrayList();

    public interface ExpandCollapseListener {
        /* JADX INFO: renamed from: a */
        void m5186a(int i);

        /* JADX INFO: renamed from: b */
        void m5187b(int i);
    }

    /* JADX INFO: renamed from: a */
    public abstract PVH mo5171a(ViewGroup viewGroup, int i);

    /* JADX INFO: renamed from: a */
    public abstract void mo5173a(CVH cvh, int i, int i2, C c);

    /* JADX INFO: renamed from: a */
    public abstract void mo5174a(PVH pvh, int i, P p);

    /* JADX INFO: renamed from: b */
    public abstract CVH mo5176b(ViewGroup viewGroup, int i);

    public ExpandableRecyclerAdapter(List<P> list) {
        this.f4650b = list;
        this.f4649a = m5163a(list);
        this.f4653e = new HashMap(this.f4650b.size());
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (mo5178b(i)) {
            ParentViewHolder parentViewHolderMo5171a = mo5171a(viewGroup, i);
            parentViewHolderMo5171a.m5189a(this.f4654f);
            parentViewHolderMo5171a.f4657b = this;
            return parentViewHolderMo5171a;
        }
        ChildViewHolder childViewHolderMo5176b = mo5176b(viewGroup, i);
        childViewHolderMo5176b.f4648b = this;
        return childViewHolderMo5176b;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (i > this.f4649a.size()) {
            throw new IllegalStateException("Trying to bind item out of bounds, size " + this.f4649a.size() + " flatPosition " + i + ". Was the data changed without a call to notify...()?");
        }
        ExpandableWrapper<P, C> expandableWrapper = this.f4649a.get(i);
        if (expandableWrapper.m5201d()) {
            ParentViewHolder parentViewHolder = (ParentViewHolder) viewHolder;
            if (parentViewHolder.m5193c()) {
                parentViewHolder.m5188a();
            }
            parentViewHolder.m5190a(expandableWrapper.m5200c());
            parentViewHolder.f4656a = (P) expandableWrapper.m5197a();
            mo5174a(parentViewHolder, m5182f(i), expandableWrapper.m5197a());
            return;
        }
        ChildViewHolder childViewHolder = (ChildViewHolder) viewHolder;
        childViewHolder.f4647a = expandableWrapper.m5199b();
        mo5173a(childViewHolder, m5182f(i), m5183g(i), expandableWrapper.m5199b());
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f4649a.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.f4649a.get(i).m5201d() ? mo5169a(m5182f(i)) : m5170a(m5182f(i), m5183g(i));
    }

    /* JADX INFO: renamed from: a */
    public int mo5169a(int i) {
        return 0;
    }

    /* JADX INFO: renamed from: a */
    public int m5170a(int i, int i2) {
        return 1;
    }

    /* JADX INFO: renamed from: b */
    public boolean mo5178b(int i) {
        return i == 0;
    }

    /* JADX INFO: renamed from: a */
    public List<P> m5172a() {
        return this.f4650b;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f4652d.add(recyclerView);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.f4652d.remove(recyclerView);
    }

    /* JADX INFO: renamed from: c */
    protected void m5179c(int i) {
        m5165a((ExpandableWrapper) this.f4649a.get(i), i, true);
    }

    /* JADX INFO: renamed from: d */
    protected void m5180d(int i) {
        m5168b(this.f4649a.get(i), i, true);
    }

    /* JADX INFO: renamed from: a */
    public void m5175a(P p) {
        int iIndexOf = this.f4649a.indexOf(new ExpandableWrapper((Parent) p));
        if (iIndexOf != -1) {
            m5164a(this.f4649a.get(iIndexOf), iIndexOf);
        }
    }

    /* JADX INFO: renamed from: e */
    public void m5181e(int i) {
        m5175a(this.f4650b.get(i));
    }

    /* JADX INFO: renamed from: b */
    public void m5177b() {
        Iterator<P> it = this.f4650b.iterator();
        while (it.hasNext()) {
            m5175a(it.next());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5164a(ExpandableWrapper<P, C> expandableWrapper, int i) {
        Iterator<RecyclerView> it = this.f4652d.iterator();
        while (it.hasNext()) {
            ParentViewHolder parentViewHolder = (ParentViewHolder) it.next().findViewHolderForAdapterPosition(i);
            if (parentViewHolder != null && parentViewHolder.m5192b()) {
                parentViewHolder.m5190a(false);
                parentViewHolder.mo5191b(true);
            }
        }
        m5168b(expandableWrapper, i, false);
    }

    /* JADX INFO: renamed from: a */
    private void m5165a(ExpandableWrapper<P, C> expandableWrapper, int i, boolean z) {
        if (!expandableWrapper.m5200c()) {
            expandableWrapper.m5198a(true);
            this.f4653e.put((P) expandableWrapper.m5197a(), true);
            List<ExpandableWrapper<P, C>> listM5202e = expandableWrapper.m5202e();
            if (listM5202e != null) {
                int size = listM5202e.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f4649a.add(i + i2 + 1, listM5202e.get(i2));
                }
                notifyItemRangeInserted(i + 1, size);
            }
            if (z && this.f4651c != null) {
                this.f4651c.m5186a(m5182f(i));
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m5168b(ExpandableWrapper<P, C> expandableWrapper, int i, boolean z) {
        if (expandableWrapper.m5200c()) {
            expandableWrapper.m5198a(false);
            this.f4653e.put((P) expandableWrapper.m5197a(), false);
            List<ExpandableWrapper<P, C>> listM5202e = expandableWrapper.m5202e();
            if (listM5202e != null) {
                int size = listM5202e.size();
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    this.f4649a.remove(i + i2 + 1);
                }
                notifyItemRangeRemoved(i + 1, size);
            }
            if (z && this.f4651c != null) {
                this.f4651c.m5187b(m5182f(i));
            }
        }
    }

    /* JADX INFO: renamed from: f */
    int m5182f(int i) {
        int i2 = 0;
        if (i != 0) {
            int i3 = 0;
            i2 = -1;
            while (i3 <= i) {
                int i4 = this.f4649a.get(i3).m5201d() ? i2 + 1 : i2;
                i3++;
                i2 = i4;
            }
        }
        return i2;
    }

    /* JADX INFO: renamed from: g */
    int m5183g(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = this.f4649a.get(i2).m5201d() ? 0 : i3 + 1;
            i2++;
            i3 = i4;
        }
        return i3;
    }

    /* JADX INFO: renamed from: a */
    private List<ExpandableWrapper<P, C>> m5163a(List<P> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            P p = list.get(i);
            m5167a(arrayList, p, p.mo5204b());
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    private void m5167a(List<ExpandableWrapper<P, C>> list, P p, boolean z) {
        ExpandableWrapper<P, C> expandableWrapper = new ExpandableWrapper<>((Parent) p);
        list.add(expandableWrapper);
        if (z) {
            m5166a(list, expandableWrapper);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5166a(List<ExpandableWrapper<P, C>> list, ExpandableWrapper<P, C> expandableWrapper) {
        expandableWrapper.m5198a(true);
        List<ExpandableWrapper<P, C>> listM5202e = expandableWrapper.m5202e();
        int size = listM5202e.size();
        for (int i = 0; i < size; i++) {
            list.add(listM5202e.get(i));
        }
    }
}

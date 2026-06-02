package com.salesforce.android.service.common.p023ui.internal.messaging;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.salesforce.android.service.common.p023ui.internal.android.LayoutInflaterFactory;
import com.salesforce.android.service.common.p023ui.internal.android.RecyclerViewAdapter;
import com.salesforce.android.service.common.p023ui.internal.android.RecyclerViewAdapterDelegate;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MessageFeedAdapter implements RecyclerViewAdapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a */
    private final ViewHolderFactory f13667a;

    /* JADX INFO: renamed from: b */
    private final LayoutInflaterFactory f13668b;

    /* JADX INFO: renamed from: c */
    private final RecyclerViewAdapterDelegate<RecyclerView.ViewHolder> f13669c;

    /* JADX INFO: renamed from: d */
    private final long f13670d;

    /* JADX INFO: renamed from: e */
    private RecyclerView f13671e;

    /* JADX INFO: renamed from: f */
    private LinearLayoutManager f13672f;

    /* JADX INFO: renamed from: g */
    private List<Object> f13673g = new ArrayList();

    MessageFeedAdapter(Builder builder) {
        this.f13667a = builder.f13674a;
        this.f13668b = builder.f13675b;
        this.f13669c = builder.f13676c;
        this.f13669c.m13936a(this);
        this.f13670d = builder.f13677d.longValue();
    }

    /* JADX INFO: renamed from: a */
    public void m13946a(RecyclerView recyclerView) {
        recyclerView.setAdapter(this.f13669c);
    }

    /* JADX INFO: renamed from: a */
    public void m13947a(Object obj) {
        if (m13940a(m13948b(), obj)) {
            m13937a(m13949c());
        }
        this.f13673g.add(obj);
        this.f13669c.notifyItemInserted(this.f13673g.indexOf(obj));
    }

    /* JADX INFO: renamed from: a */
    public void m13945a() {
        this.f13673g.clear();
        this.f13669c.notifyDataSetChanged();
    }

    @Override // com.salesforce.android.service.common.p023ui.internal.android.RecyclerViewAdapter
    public int getItemCount() {
        return this.f13673g.size();
    }

    @Override // com.salesforce.android.service.common.p023ui.internal.android.RecyclerViewAdapter
    public long getItemId(int i) {
        return this.f13669c.getItemId(i);
    }

    @Override // com.salesforce.android.service.common.p023ui.internal.android.RecyclerViewAdapter
    public int getItemViewType(int i) {
        return this.f13667a.mo12809a(this.f13673g.get(i));
    }

    /* JADX INFO: renamed from: b */
    public Object m13948b() {
        return m13944a(this.f13673g.size() - 1);
    }

    /* JADX INFO: renamed from: a */
    public Object m13944a(int i) {
        if (this.f13673g.isEmpty() || i >= this.f13673g.size() || i < 0) {
            return null;
        }
        return this.f13673g.get(i);
    }

    @Override // com.salesforce.android.service.common.p023ui.internal.android.RecyclerViewAdapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return this.f13667a.mo12810a(viewGroup, i, this.f13668b.m13935a(viewGroup.getContext()));
    }

    @Override // com.salesforce.android.service.common.p023ui.internal.android.RecyclerViewAdapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Object obj = this.f13673g.get(i);
        if (m13940a(obj, m13944a(i + 1))) {
            m13937a(viewHolder);
        } else {
            m13942b(viewHolder);
        }
        this.f13667a.mo12811a(viewHolder, viewHolder.getItemViewType(), obj);
    }

    /* JADX INFO: renamed from: c */
    RecyclerView.ViewHolder m13949c() {
        if (this.f13671e == null || this.f13673g.isEmpty()) {
            return null;
        }
        return this.f13671e.findViewHolderForAdapterPosition(this.f13673g.size() - 1);
    }

    @Override // com.salesforce.android.service.common.p023ui.internal.android.RecyclerViewAdapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.f13671e = recyclerView;
        this.f13672f = (LinearLayoutManager) recyclerView.getLayoutManager();
    }

    @Override // com.salesforce.android.service.common.p023ui.internal.android.RecyclerViewAdapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        if (this.f13671e == recyclerView) {
            this.f13671e = null;
            this.f13672f = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m13940a(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        if (m13941a(obj, obj2, MultiActorMessage.class)) {
            return m13939a((MultiActorMessage) obj, (MultiActorMessage) obj2);
        }
        if (!m13941a(obj, obj2, Message.class) || m13943b(obj, obj2, MultiActorMessage.class)) {
            return false;
        }
        return m13938a((Message) obj, (Message) obj2);
    }

    /* JADX INFO: renamed from: a */
    private boolean m13941a(Object obj, Object obj2, Class cls) {
        return cls.isInstance(obj) && cls.isInstance(obj2);
    }

    /* JADX INFO: renamed from: b */
    private boolean m13943b(Object obj, Object obj2, Class cls) {
        return cls.isInstance(obj) || cls.isInstance(obj2);
    }

    /* JADX INFO: renamed from: a */
    private boolean m13938a(Message message, Message message2) {
        return message2.mo12829d().getTime() - message.mo12829d().getTime() <= this.f13670d;
    }

    /* JADX INFO: renamed from: a */
    private boolean m13939a(MultiActorMessage multiActorMessage, MultiActorMessage multiActorMessage2) {
        return m13938a((Message) multiActorMessage, (Message) multiActorMessage2) && multiActorMessage.mo12830e().equals(multiActorMessage2.mo12830e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private void m13937a(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder != 0 && (viewHolder instanceof GroupableView)) {
            ((GroupableView) viewHolder).mo12812a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: b */
    private void m13942b(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder != 0 && (viewHolder instanceof GroupableView)) {
            ((GroupableView) viewHolder).mo12814b();
        }
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        ViewHolderFactory f13674a;

        /* JADX INFO: renamed from: b */
        LayoutInflaterFactory f13675b;

        /* JADX INFO: renamed from: c */
        RecyclerViewAdapterDelegate<RecyclerView.ViewHolder> f13676c;

        /* JADX INFO: renamed from: d */
        Long f13677d;

        /* JADX INFO: renamed from: a */
        public Builder m13951a(ViewHolderFactory viewHolderFactory) {
            this.f13674a = viewHolderFactory;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m13950a(LayoutInflaterFactory layoutInflaterFactory) {
            this.f13675b = layoutInflaterFactory;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public MessageFeedAdapter m13952a() {
            Arguments.m14236a(this.f13674a, "Please provide a ViewHolderFactory instance to the MessageFeedAdapter.");
            if (this.f13675b == null) {
                this.f13675b = new LayoutInflaterFactory();
            }
            if (this.f13676c == null) {
                this.f13676c = new RecyclerViewAdapterDelegate<>();
            }
            if (this.f13677d == null) {
                this.f13677d = 60000L;
            }
            return new MessageFeedAdapter(this);
        }
    }
}

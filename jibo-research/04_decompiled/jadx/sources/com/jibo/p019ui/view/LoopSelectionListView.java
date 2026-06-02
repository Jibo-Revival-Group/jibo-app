package com.jibo.p019ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.loop.model.Loop;

/* JADX INFO: loaded from: classes.dex */
public class LoopSelectionListView extends ListView {

    /* JADX INFO: renamed from: a */
    private ListAdapter f11559a;

    /* JADX INFO: renamed from: b */
    private OnLoopSelectedListener f11560b;

    /* JADX INFO: renamed from: c */
    private AdapterView.OnItemClickListener f11561c;

    static class MessagesLoopViewHolder {

        @BindView
        ImageView loopImage;

        @BindView
        TextView messageDateText;

        @BindView
        TextView messageText;

        @BindView
        TextView titleText;

        @BindView
        TextView unreadMessagesCount;
    }

    public interface OnLoopSelectedListener {
        /* JADX INFO: renamed from: a */
        void mo10808a(Loop loop);
    }

    public class MessagesLoopViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private MessagesLoopViewHolder f11563b;

        public MessagesLoopViewHolder_ViewBinding(MessagesLoopViewHolder messagesLoopViewHolder, View view) {
            this.f11563b = messagesLoopViewHolder;
            messagesLoopViewHolder.loopImage = (ImageView) Utils.m5161b(view, R.id.loop_image, "field 'loopImage'", ImageView.class);
            messagesLoopViewHolder.titleText = (TextView) Utils.m5161b(view, android.R.id.text1, "field 'titleText'", TextView.class);
            messagesLoopViewHolder.messageText = (TextView) Utils.m5161b(view, android.R.id.text2, "field 'messageText'", TextView.class);
            messagesLoopViewHolder.messageDateText = (TextView) Utils.m5161b(view, R.id.message_date, "field 'messageDateText'", TextView.class);
            messagesLoopViewHolder.unreadMessagesCount = (TextView) Utils.m5161b(view, R.id.unread_messages_count, "field 'unreadMessagesCount'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            MessagesLoopViewHolder messagesLoopViewHolder = this.f11563b;
            if (messagesLoopViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11563b = null;
            messagesLoopViewHolder.loopImage = null;
            messagesLoopViewHolder.titleText = null;
            messagesLoopViewHolder.messageText = null;
            messagesLoopViewHolder.messageDateText = null;
            messagesLoopViewHolder.unreadMessagesCount = null;
        }
    }

    public LoopSelectionListView(Context context) {
        super(context);
        this.f11561c = new AdapterView.OnItemClickListener() { // from class: com.jibo.ui.view.LoopSelectionListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Loop loop = (Loop) LoopSelectionListView.this.f11559a.getItem(i);
                if (LoopSelectionListView.this.f11560b != null) {
                    LoopSelectionListView.this.f11560b.mo10808a(loop);
                }
            }
        };
        m11258a();
    }

    public LoopSelectionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11561c = new AdapterView.OnItemClickListener() { // from class: com.jibo.ui.view.LoopSelectionListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Loop loop = (Loop) LoopSelectionListView.this.f11559a.getItem(i);
                if (LoopSelectionListView.this.f11560b != null) {
                    LoopSelectionListView.this.f11560b.mo10808a(loop);
                }
            }
        };
        m11258a();
    }

    public LoopSelectionListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11561c = new AdapterView.OnItemClickListener() { // from class: com.jibo.ui.view.LoopSelectionListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                Loop loop = (Loop) LoopSelectionListView.this.f11559a.getItem(i2);
                if (LoopSelectionListView.this.f11560b != null) {
                    LoopSelectionListView.this.f11560b.mo10808a(loop);
                }
            }
        };
        m11258a();
    }

    /* JADX INFO: renamed from: a */
    private void m11258a() {
        setOnItemClickListener(this.f11561c);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        this.f11559a = listAdapter;
    }

    public void setOnLoopSelectedListener(OnLoopSelectedListener onLoopSelectedListener) {
        this.f11560b = onLoopSelectedListener;
    }
}

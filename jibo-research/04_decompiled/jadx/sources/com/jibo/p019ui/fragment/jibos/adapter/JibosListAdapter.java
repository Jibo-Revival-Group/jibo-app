package com.jibo.p019ui.fragment.jibos.adapter;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.RemoveRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.p018db.EntityData;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.SharedPreferencesUtil;
import com.jibo.utils.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpHeaders;

/* JADX INFO: loaded from: classes.dex */
public class JibosListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a */
    private Account f10625a;

    /* JADX INFO: renamed from: e */
    private View.OnClickListener f10629e;

    /* JADX INFO: renamed from: b */
    private List<Loop> f10626b = new ArrayList();

    /* JADX INFO: renamed from: c */
    private List<Loop> f10627c = new ArrayList();

    /* JADX INFO: renamed from: d */
    private List<Loop> f10628d = new ArrayList();

    /* JADX INFO: renamed from: f */
    private SparseIntArray f10630f = new SparseIntArray();

    private enum JiboItemTypes {
        myLoop,
        invitedLoop,
        joinedLoop,
        newjibo
    }

    public class JiboViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private JiboViewHolder f10637b;

        public JiboViewHolder_ViewBinding(JiboViewHolder jiboViewHolder, View view) {
            this.f10637b = jiboViewHolder;
            jiboViewHolder.avatar = (ImageView) Utils.m5161b(view, R.id.icon, "field 'avatar'", ImageView.class);
            jiboViewHolder.titleText = (TextView) Utils.m5161b(view, R.id.text1, "field 'titleText'", TextView.class);
            jiboViewHolder.ownerText = (TextView) Utils.m5161b(view, R.id.text2, "field 'ownerText'", TextView.class);
            jiboViewHolder.loopSuspended = (TextView) Utils.m5159a(view, com.jibo.R.id.loop_suspended, "field 'loopSuspended'", TextView.class);
            jiboViewHolder.checkbox = (ImageView) Utils.m5159a(view, com.jibo.R.id.checkbox, "field 'checkbox'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            JiboViewHolder jiboViewHolder = this.f10637b;
            if (jiboViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f10637b = null;
            jiboViewHolder.avatar = null;
            jiboViewHolder.titleText = null;
            jiboViewHolder.ownerText = null;
            jiboViewHolder.loopSuspended = null;
            jiboViewHolder.checkbox = null;
        }
    }

    public JibosListAdapter(View.OnClickListener onClickListener) {
        this.f10629e = onClickListener;
    }

    /* JADX INFO: renamed from: a */
    public void m10812a(Account account, List<Loop> list) {
        this.f10625a = account;
        this.f10626b.clear();
        this.f10627c.clear();
        this.f10628d.clear();
        if (list != null && account != null) {
            for (Loop loop : list) {
                if (account.getId().equals(loop.getOwner())) {
                    this.f10626b.add(loop);
                } else if (!loop.isSuspended().booleanValue()) {
                    if (LoopHelper.isMemberInvited(loop, account.getId())) {
                        this.f10627c.add(loop);
                    } else {
                        this.f10628d.add(loop);
                    }
                }
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int size = this.f10626b.size();
        int size2 = this.f10627c.size();
        if (i < size2) {
            return JiboItemTypes.invitedLoop.ordinal();
        }
        if (i < size2 + size) {
            return JiboItemTypes.myLoop.ordinal();
        }
        if (i >= size + size2 && i < getItemCount() - 1) {
            return JiboItemTypes.joinedLoop.ordinal();
        }
        return JiboItemTypes.newjibo.ordinal();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (JiboItemTypes.values()[i]) {
            case joinedLoop:
            case myLoop:
                return new JiboViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(com.jibo.R.layout.item_jibo, viewGroup, false));
            case invitedLoop:
                return new JiboViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(com.jibo.R.layout.item_jibo_invitation, viewGroup, false));
            case newjibo:
                return new SetupJiboViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(com.jibo.R.layout.item_jibo_newjibo, viewGroup, false), this.f10629e);
            default:
                return null;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (JiboItemTypes.values()[getItemViewType(i)]) {
            case joinedLoop:
            case myLoop:
            case invitedLoop:
                ((JiboViewHolder) viewHolder).m10817a(m10811a(i), this.f10625a, this.f10629e);
                ((JiboViewHolder) viewHolder).m10816a(this.f10630f.get(i, 0));
                break;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        switch (JiboItemTypes.values()[getItemViewType(i)]) {
            case joinedLoop:
            case myLoop:
            case invitedLoop:
                if (list != null && !list.isEmpty()) {
                    if (list.get(0) instanceof Robot) {
                        ((JiboViewHolder) viewHolder).m10816a(this.f10630f.get(i, 0));
                    }
                } else {
                    onBindViewHolder(viewHolder, i);
                }
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    public Loop m10811a(int i) {
        int size = this.f10626b.size();
        int size2 = this.f10627c.size();
        if (i < size2) {
            return this.f10627c.get(i);
        }
        if (i < size2 + size) {
            return this.f10626b.get(i - size2);
        }
        return this.f10628d.get((i - size2) - size);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f10628d.size() + this.f10626b.size() + this.f10627c.size() + 1;
    }

    /* JADX INFO: renamed from: a */
    public int m10810a() {
        return this.f10626b.size();
    }

    /* JADX INFO: renamed from: b */
    public int m10814b() {
        return this.f10628d.size();
    }

    /* JADX INFO: renamed from: c */
    public List<Loop> m10815c() {
        return this.f10627c;
    }

    /* JADX INFO: renamed from: a */
    public void m10813a(String str, Robot robot) {
        int iIndexOf;
        int iIndexOf2;
        int size = this.f10626b.size();
        int size2 = this.f10627c.size();
        Iterator<Loop> it = this.f10627c.iterator();
        while (true) {
            if (!it.hasNext()) {
                iIndexOf = -1;
                break;
            }
            Loop next = it.next();
            if (next.getRobotFriendlyId() != null && next.getRobotFriendlyId().equals(str)) {
                iIndexOf = this.f10627c.indexOf(next);
                break;
            }
        }
        if (iIndexOf == -1) {
            Iterator<Loop> it2 = this.f10626b.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Loop next2 = it2.next();
                if (next2.getRobotFriendlyId() != null && next2.getRobotFriendlyId().equals(str)) {
                    iIndexOf = size2 + this.f10626b.indexOf(next2);
                    break;
                }
            }
        }
        if (iIndexOf == -1) {
            for (Loop loop : this.f10628d) {
                if (loop.getRobotFriendlyId() != null && loop.getRobotFriendlyId().equals(str)) {
                    iIndexOf2 = this.f10628d.indexOf(loop) + size2 + size;
                    break;
                }
            }
            iIndexOf2 = iIndexOf;
        } else {
            iIndexOf2 = iIndexOf;
        }
        if (iIndexOf2 != -1) {
            this.f10630f.put(iIndexOf2, RobotHelper.getAvatar(robot));
            notifyItemChanged(iIndexOf2, robot);
        }
    }

    public static class JiboViewHolder extends RecyclerView.ViewHolder {

        @BindView
        ImageView avatar;

        @BindView
        ImageView checkbox;

        @BindView
        TextView loopSuspended;

        @BindView
        TextView ownerText;

        @BindView
        TextView titleText;

        public JiboViewHolder(View view) {
            super(view);
            ButterKnife.m5154a(this, view);
            if (this.checkbox != null) {
                this.checkbox.setImageDrawable(ImageUtils.m11392a(view.getContext(), com.jibo.R.drawable.ic_check, com.jibo.R.color.jibo_blue));
            }
        }

        /* JADX INFO: renamed from: a */
        public void m10817a(Loop loop, Account account, View.OnClickListener onClickListener) {
            String str;
            Util.m11496b(this.titleText, loop.getName());
            this.itemView.setTag(loop);
            if (this.checkbox != null) {
                if (loop.equals(SharedPreferencesUtil.m11443f(this.itemView.getContext()))) {
                    this.checkbox.setVisibility(0);
                } else {
                    this.checkbox.setVisibility(8);
                }
            }
            if (this.loopSuspended != null) {
                this.loopSuspended.setVisibility(loop.isSuspended().booleanValue() ? 0 : 8);
                this.ownerText.setVisibility(loop.isSuspended().booleanValue() ? 8 : 0);
            }
            if (LoopHelper.isOwner(loop, account.getId())) {
                this.ownerText.setText(this.itemView.getContext().getResources().getString(com.jibo.R.string.item_loop_member_status_owner) + ": " + this.itemView.getContext().getResources().getString(com.jibo.R.string.item_loop_member_status_you));
            } else {
                Member owner = LoopHelper.getOwner(loop);
                TextView textView = this.ownerText;
                if (owner != null) {
                    str = this.itemView.getContext().getResources().getString(com.jibo.R.string.item_loop_member_status_owner) + ": " + (TextUtils.isEmpty(owner.getNickname()) ? owner.getAccount().getFullName() : owner.getNickname());
                } else {
                    str = "";
                }
                textView.setText(str);
            }
            this.itemView.setOnClickListener(onClickListener);
            this.itemView.setOnLongClickListener(new ViewOnLongClickListenerC12181(account, loop));
        }

        /* JADX INFO: renamed from: com.jibo.ui.fragment.jibos.adapter.JibosListAdapter$JiboViewHolder$1 */
        class ViewOnLongClickListenerC12181 implements View.OnLongClickListener {

            /* JADX INFO: renamed from: a */
            final /* synthetic */ Account f10632a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ Loop f10633b;

            ViewOnLongClickListenerC12181(Account account, Loop loop) {
                this.f10632a = account;
                this.f10633b = loop;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (this.f10632a.getId().equals(this.f10633b.getOwner()) && this.f10633b.isSuspended().booleanValue()) {
                    new AlertDialog.Builder(JiboViewHolder.this.itemView.getContext()).m3228a(HttpHeaders.WARNING).m3234b("Do you want to delete this loop?").m3230a(false).m3235b("Cancel", (DialogInterface.OnClickListener) null).m3229a("Ok", new DialogInterface.OnClickListener() { // from class: com.jibo.ui.fragment.jibos.adapter.JibosListAdapter.JiboViewHolder.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (i == -1) {
                                EntityData.m10089a(JiboViewHolder.this.itemView.getContext()).m10122b().removeLoop(ViewOnLongClickListenerC12181.this.f10633b.getId(), new AsyncHandler<RemoveRequest, Loop>() { // from class: com.jibo.ui.fragment.jibos.adapter.JibosListAdapter.JiboViewHolder.1.1.1
                                    @Override // com.amazonaws.handlers.AsyncHandler
                                    public void onError(Exception exc) {
                                    }

                                    @Override // com.amazonaws.handlers.AsyncHandler
                                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                                    public void onSuccess(RemoveRequest removeRequest, Loop loop) throws Throwable {
                                        EntityData.m10089a(JiboViewHolder.this.itemView.getContext()).m10123b(loop.getId());
                                    }
                                });
                            }
                        }
                    }).m3237c();
                    return true;
                }
                return true;
            }
        }

        /* JADX INFO: renamed from: a */
        public void m10816a(int i) {
            this.avatar.setImageLevel(i);
        }
    }

    public static class SetupJiboViewHolder extends RecyclerView.ViewHolder {
        public SetupJiboViewHolder(View view, View.OnClickListener onClickListener) {
            super(view);
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a */
        private int f10638a;

        public SpacesItemDecoration(Context context, int i) {
            this.f10638a = i != -1 ? context.getResources().getDimensionPixelOffset(i) : 0;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        /* JADX INFO: renamed from: a */
        public void mo4460a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (recyclerView.getChildAdapterPosition(view) < recyclerView.getAdapter().getItemCount() - 1) {
                rect.bottom = this.f10638a;
            }
        }
    }
}

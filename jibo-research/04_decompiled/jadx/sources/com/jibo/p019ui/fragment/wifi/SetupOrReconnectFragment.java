package com.jibo.p019ui.fragment.wifi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.key.model.Backup;
import com.jibo.aws.integration.aws.services.key.model.RestoreRequest;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.activity.WifiActivity;
import com.jibo.p019ui.fragment.dialog.passphrase.LoopPassphraseRestoreDialog;
import com.jibo.p019ui.fragment.dialog.passphrase.LoopPassphraseUtils;
import com.jibo.p019ui.helpers.Items;
import com.jibo.p019ui.helpers.ViewHolders;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SetupOrReconnectFragment extends WiFiBaseFragment implements LoopPassphraseRestoreDialog.BackupKeyRestoredListener {

    /* JADX INFO: renamed from: b */
    private ArrayList<Loop> f11275b;

    /* JADX INFO: renamed from: c */
    private JibosListAdapter f11276c;

    @BindView
    RecyclerView list;

    /* JADX INFO: renamed from: a */
    private List<Items.Item> f11274a = new ArrayList();

    /* JADX INFO: renamed from: l */
    private View.OnClickListener f11277l = new ViewOnClickListenerC13884();

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_recyclerview, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f11276c = new JibosListAdapter(this.f11274a);
        this.list.setHasFixedSize(true);
        this.list.setItemAnimator(new DefaultItemAnimator());
        this.list.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        this.list.addItemDecoration(new JibosListAdapter.SpacesItemDecoration(getActivity(), R.dimen.activity_double_vertical_margin, R.dimen.divider_thickness));
        this.list.setAdapter(this.f11276c);
        m11136a();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        this.f11275b = bundle.getParcelableArrayList("ARGS_SUSPENDED_LOOP_LIST");
    }

    /* JADX INFO: renamed from: a */
    private void m11136a() {
        this.f11274a.clear();
        if (this.f11275b == null || this.f11275b.isEmpty()) {
            this.f11274a.add(new Items.FooterItem(getString(R.string.reconnect_no_key_no_backup_text)));
        } else {
            this.f11274a.add(new Items.FooterItem(getString(R.string.setup_or_reconnect_text)));
            this.f11274a.add(new Items.SubheaderItem(R.string.select_an_option));
            Iterator<Loop> it = this.f11275b.iterator();
            while (it.hasNext()) {
                this.f11274a.add(new Items.SuspendedLoopItem(this.f11277l, it.next()));
            }
            Iterator<Loop> it2 = this.f11275b.iterator();
            while (it2.hasNext()) {
                m11141c(it2.next());
            }
        }
        this.f11274a.add(new Items.SimpleItem(Items.ItemType.setup_jibo, new View.OnClickListener() { // from class: com.jibo.ui.fragment.wifi.SetupOrReconnectFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((WifiActivity) SetupOrReconnectFragment.this.getActivity()).m10318q();
            }
        }));
        this.f11274a.add(new Items.SimpleItem(Items.ItemType.text_button, new View.OnClickListener() { // from class: com.jibo.ui.fragment.wifi.SetupOrReconnectFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SetupOrReconnectFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(SetupOrReconnectFragment.this.getString(R.string.support_url))));
            }
        }, R.string.learn_more_about_reconnecting));
        this.f11276c.notifyDataSetChanged();
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.set_up_a_new_loop);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m11139b(Loop loop) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Loop.class.getSimpleName(), this.f9934k);
        ((WifiActivity) getActivity()).m10317a(WifiActivity.Mode.RECONNECT_SUSPENDED);
        ((BaseActivity) getActivity()).m10193c(NetworkSelectionFragment.class, bundle);
    }

    @Override // com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseRestoreDialog.BackupKeyRestoredListener
    /* JADX INFO: renamed from: a */
    public void mo10576a(Loop loop) {
        m11139b(loop);
    }

    /* JADX INFO: renamed from: c */
    private void m11141c(final Loop loop) {
        EntityData.m10089a(getActivity()).m10132g().getRobot(loop.getRobotFriendlyId(), new AsyncHandler<GetRobotRequest, Robot>() { // from class: com.jibo.ui.fragment.wifi.SetupOrReconnectFragment.3
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                SetupOrReconnectFragment.this.m10338a((Throwable) exc, "get robot", false);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(GetRobotRequest getRobotRequest, final Robot robot) {
                SetupOrReconnectFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.wifi.SetupOrReconnectFragment.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (robot != null) {
                            SetupOrReconnectFragment.this.f11276c.m11147a(loop.getRobotFriendlyId(), robot);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: renamed from: com.jibo.ui.fragment.wifi.SetupOrReconnectFragment$4 */
    class ViewOnClickListenerC13884 implements View.OnClickListener {
        ViewOnClickListenerC13884() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            KeyManager.SymmetricKeyHolder symmetricKeyHolderObtainKeyHolder;
            final Loop loopM11217a = ((Items.SuspendedLoopItem) view.getTag()).m11217a();
            try {
                symmetricKeyHolderObtainKeyHolder = KeyManager.getInstance(SetupOrReconnectFragment.this.getContext(), EntityData.m10089a(SetupOrReconnectFragment.this.getActivity()).m10134i().getId()).obtainKeyHolder(SetupOrReconnectFragment.this.getContext(), loopM11217a.getId());
            } catch (Exception e) {
                symmetricKeyHolderObtainKeyHolder = null;
            }
            if (symmetricKeyHolderObtainKeyHolder != null) {
                SetupOrReconnectFragment.this.m11139b(loopM11217a);
            } else {
                SetupOrReconnectFragment.this.m10344f();
                EntityData.m10089a(SetupOrReconnectFragment.this.getContext()).m10126d().restoreEncryptedKey(loopM11217a.getId(), null, new AsyncHandler<RestoreRequest, Backup>() { // from class: com.jibo.ui.fragment.wifi.SetupOrReconnectFragment.4.1
                    @Override // com.amazonaws.handlers.AsyncHandler
                    public void onError(final Exception exc) {
                        SetupOrReconnectFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.wifi.SetupOrReconnectFragment.4.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SetupOrReconnectFragment.this.m10338a((Throwable) exc, "Error restoring key", true);
                            }
                        });
                    }

                    @Override // com.amazonaws.handlers.AsyncHandler
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(RestoreRequest restoreRequest, Backup backup) {
                        SetupOrReconnectFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.wifi.SetupOrReconnectFragment.4.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                SetupOrReconnectFragment.this.mo10345g();
                                LoopPassphraseUtils.m10582a(SetupOrReconnectFragment.this, LoopPassphraseUtils.DialogType.ON_RECONNECT_TO_JIBO, loopM11217a);
                            }
                        });
                    }
                });
            }
        }
    }

    public static class JibosListAdapter extends RecyclerView.Adapter<ViewHolders.AbstractViewHolder> {

        /* JADX INFO: renamed from: a */
        private final List<Items.Item> f11291a;

        /* JADX INFO: renamed from: b */
        private SparseIntArray f11292b = new SparseIntArray();

        public JibosListAdapter(List<Items.Item> list) {
            this.f11291a = list;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return this.f11291a.get(i).getItemType().ordinal();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ViewHolders.AbstractViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Items.ItemType itemType = Items.ItemType.values()[i];
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(itemType.getLayoutId(), viewGroup, false);
            switch (itemType) {
                case subheader:
                    return new ViewHolders.SubheaderViewHolder(viewInflate);
                case suspended_loop:
                    return new ViewHolders.SuspendedJiboViewHolder(viewInflate);
                case setup_jibo:
                    ViewHolders.SimpleViewHolder simpleViewHolder = new ViewHolders.SimpleViewHolder(viewInflate);
                    simpleViewHolder.text.setTextColor(-16777216);
                    return simpleViewHolder;
                case footer:
                    return new ViewHolders.FooterViewHolder(viewInflate);
                case text_button:
                    return new ViewHolders.SimpleViewHolder(viewInflate);
                default:
                    return null;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(ViewHolders.AbstractViewHolder abstractViewHolder, int i) {
            abstractViewHolder.setData(this.f11291a.get(i));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(ViewHolders.AbstractViewHolder abstractViewHolder, int i, List<Object> list) {
            switch (Items.ItemType.values()[getItemViewType(i)]) {
                case suspended_loop:
                    if (list != null && !list.isEmpty()) {
                        if (list.get(0) instanceof Robot) {
                            ((ViewHolders.SuspendedJiboViewHolder) abstractViewHolder).m11240a(this.f11292b.get(i, 0));
                        }
                    } else {
                        onBindViewHolder(abstractViewHolder, i);
                    }
                    break;
                default:
                    onBindViewHolder(abstractViewHolder, i);
                    break;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f11291a.size();
        }

        /* JADX INFO: renamed from: a */
        public void m11147a(String str, Robot robot) {
            int iIndexOf;
            Iterator<Items.Item> it = this.f11291a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    iIndexOf = -1;
                    break;
                }
                Items.Item next = it.next();
                if ((next instanceof Items.SuspendedLoopItem) && ((Items.SuspendedLoopItem) next).m11217a().getRobotFriendlyId() != null && ((Items.SuspendedLoopItem) next).m11217a().getRobotFriendlyId().equals(str)) {
                    iIndexOf = this.f11291a.indexOf(next);
                    break;
                }
            }
            if (iIndexOf != -1) {
                this.f11292b.put(iIndexOf, RobotHelper.getAvatar(robot));
                notifyItemChanged(iIndexOf, robot);
            }
        }

        public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {

            /* JADX INFO: renamed from: a */
            private int f11293a;

            /* JADX INFO: renamed from: b */
            private int f11294b;

            public SpacesItemDecoration(Context context, int i, int i2) {
                this.f11293a = i != -1 ? context.getResources().getDimensionPixelOffset(i) : 0;
                this.f11294b = i2 != -1 ? context.getResources().getDimensionPixelOffset(i2) : 0;
            }

            @Override // android.support.v7.widget.RecyclerView.ItemDecoration
            /* JADX INFO: renamed from: a */
            public void mo4460a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                if (recyclerView.findContainingViewHolder(view) instanceof ViewHolders.SuspendedJiboViewHolder) {
                    rect.bottom = this.f11294b;
                }
                if (recyclerView.getAdapter().getItemCount() == 3 && recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() - 2) {
                    rect.top = this.f11293a;
                } else if (recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() - 1) {
                    rect.bottom = this.f11293a;
                }
            }
        }
    }
}

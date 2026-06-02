package com.jibo.p019ui.fragment.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.ShareCompat;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.FileProvider;
import android.support.v4.content.Loader;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.crashlytics.android.Crashlytics;
import com.facebook.share.internal.ShareConstants;
import com.jibo.JiboAnalytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.media.model.Media;
import com.jibo.aws.integration.helpers.MediaHelper;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.p018db.DatabaseContract;
import com.jibo.p018db.DatabaseHelper;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.activity.PhotoViewerActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.fragment.dialog.DialogUtils;
import com.jibo.p019ui.fragment.dialog.DownloadProgressFragment;
import com.jibo.p019ui.fragment.dialog.passphrase.LoopPassphraseRestoreDialog;
import com.jibo.p019ui.fragment.dialog.passphrase.LoopPassphraseUtils;
import com.jibo.p019ui.helpers.RecyclerCursorAdapter;
import com.jibo.service.MediaDeletingService;
import com.jibo.service.SyncHelper;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.SharedPreferencesUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MediaFragment extends BaseFragment implements LoaderManager.LoaderCallbacks<Cursor>, SwipeRefreshLayout.OnRefreshListener, LoopPassphraseRestoreDialog.BackupKeyRestoredListener {

    /* JADX INFO: renamed from: c */
    private MomentsAdapter f10334c;

    @BindView
    View emptyView;

    /* JADX INFO: renamed from: l */
    private boolean f10337l;

    @BindView
    RecyclerView list;

    /* JADX INFO: renamed from: o */
    private ActionMode f10340o;

    @BindView
    View progressView;

    @BindView
    SwipeRefreshLayout swipeRefreshLayout;

    /* JADX INFO: renamed from: t */
    private PaginationAsyncTask f10345t;

    @BindView
    View viewNoKey;

    /* JADX INFO: renamed from: d */
    private Map<Integer, HeaderItem> f10335d = new HashMap();

    /* JADX INFO: renamed from: e */
    private Map<String, Loop> f10336e = new HashMap();

    /* JADX INFO: renamed from: m */
    private Runnable f10338m = new Runnable() { // from class: com.jibo.ui.fragment.home.MediaFragment.1
        @Override // java.lang.Runnable
        public void run() {
            if (MediaFragment.this.m10354p().m10303r() != null && MediaFragment.this.f10339n.m10655a() == 0) {
                MediaFragment.this.m10354p().m10303r().mo3409c();
            }
        }
    };

    /* JADX INFO: renamed from: n */
    private PhotoSelector f10339n = new PhotoSelector();

    /* JADX INFO: renamed from: p */
    private ActionMode.Callback f10341p = new ActionMode.Callback() { // from class: com.jibo.ui.fragment.home.MediaFragment.2
        @Override // android.support.v7.view.ActionMode.Callback
        /* JADX INFO: renamed from: a */
        public boolean mo3330a(ActionMode actionMode, Menu menu) {
            actionMode.mo3401a().inflate(R.menu.menu_media_action_mode, menu);
            ImageUtils.m11393a(MediaFragment.this.getActivity(), menu);
            return true;
        }

        @Override // android.support.v7.view.ActionMode.Callback
        /* JADX INFO: renamed from: b */
        public boolean mo3332b(ActionMode actionMode, Menu menu) {
            int iM10655a = MediaFragment.this.f10339n.m10655a();
            if (iM10655a > 0) {
                actionMode.mo3408b(MediaFragment.this.getString(R.string.text_count_selected, Integer.valueOf(iM10655a)));
            }
            MediaFragment.this.m10341c().postDelayed(MediaFragment.this.f10338m, 50L);
            return false;
        }

        @Override // android.support.v7.view.ActionMode.Callback
        /* JADX INFO: renamed from: a */
        public boolean mo3331a(ActionMode actionMode, MenuItem menuItem) {
            MediaFragment.this.f10340o = actionMode;
            switch (menuItem.getItemId()) {
                case R.id.action_delete /* 2131296292 */:
                    DialogUtils.m10513a(MediaFragment.this, 117, MediaFragment.this.getString(R.string.remove_medias_confirm), MediaFragment.this.getString(R.string.remove));
                    return true;
                case R.id.action_share /* 2131296307 */:
                    MediaFragment.this.m10620s();
                    return true;
                default:
                    actionMode.mo3409c();
                    return false;
            }
        }

        @Override // android.support.v7.view.ActionMode.Callback
        /* JADX INFO: renamed from: a */
        public void mo3329a(ActionMode actionMode) {
            MediaFragment.this.m10354p().m10300a((ActionMode) null);
            MediaFragment.this.f10339n.m10658b();
            MediaFragment.this.f10334c.notifyItemRangeChanged(0, MediaFragment.this.f10334c.getItemCount(), MediaFragment.this.f10341p);
        }
    };

    /* JADX INFO: renamed from: q */
    private BroadcastReceiver f10342q = new BroadcastReceiver() { // from class: com.jibo.ui.fragment.home.MediaFragment.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("ACTION_KEY_SAVED".equals(intent.getAction())) {
                MediaFragment.this.getLoaderManager().mo1688b(R.id.loader_loops, null, MediaFragment.this);
            }
        }
    };

    /* JADX INFO: renamed from: r */
    private boolean f10343r = false;

    /* JADX INFO: renamed from: s */
    private boolean f10344s = true;

    /* JADX INFO: renamed from: u */
    private RecyclerView.OnScrollListener f10346u = new RecyclerView.OnScrollListener() { // from class: com.jibo.ui.fragment.home.MediaFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        /* JADX INFO: renamed from: a */
        public void mo4164a(RecyclerView recyclerView, int i, int i2) {
            int childAdapterPosition = MediaFragment.this.list.getChildAdapterPosition(MediaFragment.this.list.getChildAt(MediaFragment.this.list.getChildCount() - 1));
            if (!MediaFragment.this.f10343r && MediaFragment.this.f10334c.getItemCount() <= childAdapterPosition + 2 && MediaFragment.this.f10344s && i2 > 0) {
                MediaFragment.this.f10343r = true;
                if (MediaFragment.this.f10345t != null) {
                    MediaFragment.this.f10345t.cancel(true);
                }
                MediaFragment.this.f10345t = MediaFragment.this.new PaginationAsyncTask();
                MediaFragment.this.f10345t.execute(new Void[0]);
            }
        }
    };

    /* JADX INFO: renamed from: v */
    private Handler f10347v = new Handler() { // from class: com.jibo.ui.fragment.home.MediaFragment.7
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (MediaFragment.this.m10342d() && !LoopPassphraseUtils.m10585a(MediaFragment.this.getFragmentManager())) {
                if (message.what == 1) {
                    MediaFragment.this.m10622t();
                } else if (message.what == 2) {
                    MediaFragment.this.m10624u();
                }
            }
        }
    };

    /* JADX INFO: renamed from: a */
    final int f10332a = 1;

    /* JADX INFO: renamed from: b */
    final int f10333b = 2;

    enum ViewType {
        header,
        media,
        pagination
    }

    public class HeaderViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private HeaderViewHolder f10364b;

        public HeaderViewHolder_ViewBinding(HeaderViewHolder headerViewHolder, View view) {
            this.f10364b = headerViewHolder;
            headerViewHolder.text1 = (TextView) Utils.m5161b(view, android.R.id.text1, "field 'text1'", TextView.class);
            headerViewHolder.selectAll = (TextView) Utils.m5161b(view, R.id.btnSelectAll, "field 'selectAll'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            HeaderViewHolder headerViewHolder = this.f10364b;
            if (headerViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f10364b = null;
            headerViewHolder.text1 = null;
            headerViewHolder.selectAll = null;
        }
    }

    public class PhotoItemViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private PhotoItemViewHolder f10391b;

        public PhotoItemViewHolder_ViewBinding(PhotoItemViewHolder photoItemViewHolder, View view) {
            this.f10391b = photoItemViewHolder;
            photoItemViewHolder.photo = (ImageView) Utils.m5161b(view, R.id.photo, "field 'photo'", ImageView.class);
            photoItemViewHolder.checkbox = (TextView) Utils.m5159a(view, R.id.checkbox, "field 'checkbox'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            PhotoItemViewHolder photoItemViewHolder = this.f10391b;
            if (photoItemViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f10391b = null;
            photoItemViewHolder.photo = null;
            photoItemViewHolder.checkbox = null;
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, com.jibo.ui.fragment.dialog.DialogUtils.DialogFragmentWrapperClickListener
    /* JADX INFO: renamed from: a */
    public void mo10186a(int i, int i2, Object obj) {
        super.mo10186a(i, i2, obj);
        switch (i) {
            case 117:
                JiboAnalytics.m9859j(getActivity());
                m10618r();
                break;
            case 118:
                if (obj != null) {
                    try {
                        ArrayList arrayList = (ArrayList) obj;
                        if (arrayList.isEmpty()) {
                            throw new Exception(getString(R.string.dialog_message_sharing_error));
                        }
                        ShareCompat.IntentBuilder intentBuilderM1790a = ShareCompat.IntentBuilder.m1790a(getActivity());
                        Uri uriM1848a = null;
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            uriM1848a = FileProvider.m1848a(getActivity(), "com.jibo.fileprovider", new File((String) it.next()));
                            intentBuilderM1790a.m1798b(uriM1848a);
                        }
                        if (uriM1848a != null) {
                            intentBuilderM1790a.m1796a(getActivity().getContentResolver().getType(uriM1848a));
                        }
                        Intent intentM1797b = intentBuilderM1790a.m1793a(R.string.text_sharre_with).m1797b();
                        intentM1797b.addFlags(1);
                        if (intentM1797b.resolveActivity(getActivity().getPackageManager()) != null) {
                            startActivity(intentM1797b);
                            JiboAnalytics.m9850e(getActivity());
                        } else {
                            throw new Exception(getString(R.string.dialog_message_sharing_error));
                        }
                    } catch (Exception e) {
                        DialogUtils.m10526d(this, 104, getString(R.string.title_Error), getString(R.string.dialog_message_sharing_error));
                    }
                }
                break;
        }
        if (this.f10340o != null) {
            this.f10340o.mo3409c();
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_media, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m10598b();
        ((BaseActivity) getActivity()).m10189a(false);
        this.swipeRefreshLayout.setOnRefreshListener(this);
        this.swipeRefreshLayout.setColorSchemeResources(R.color.jibo_blue, R.color.accent_blue, R.color.accent_blue, R.color.accent_blue);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        LocalBroadcastManager localBroadcastManagerM1878a = LocalBroadcastManager.m1878a(getActivity());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_KEY_SAVED");
        localBroadcastManagerM1878a.m1882a(this.f10342q, intentFilter);
        this.swipeRefreshLayout.setEnabled(ModesHelper.m10636a());
        SyncHelper.m10177a(getActivity(), null, true);
        getLoaderManager().mo1683a(R.id.loader_loops, null, this);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f10345t != null) {
            this.f10345t.cancel(true);
            this.f10345t = null;
        }
        LocalBroadcastManager.m1878a(getActivity()).m1881a(this.f10342q);
        m10616q();
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
    /* JADX INFO: renamed from: n_ */
    public void mo3115n_() {
        this.swipeRefreshLayout.setRefreshing(true);
        SyncHelper.m10177a(getActivity(), null, true);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: a */
    public Loader<Cursor> mo1689a(int i, Bundle bundle) {
        switch (i) {
            case R.id.loader_loops /* 2131296709 */:
                return new CursorLoader(getActivity(), DatabaseContract.EntityEntry.m10079a(8), DatabaseContract.EntityEntry.f9694a, null, null, null);
            case R.id.loader_loops_filtered /* 2131296710 */:
            default:
                return null;
            case R.id.loader_media /* 2131296711 */:
                return new MediaCursor(getActivity(), this.f10335d, this.f10336e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00be  */
    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mo1691a(android.support.v4.content.Loader<android.database.Cursor> r12, android.database.Cursor r13) {
        /*
            Method dump skipped, instruction units count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.p019ui.fragment.home.MediaFragment.mo1691a(android.support.v4.content.Loader, android.database.Cursor):void");
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: a */
    public void mo1690a(Loader<Cursor> loader) {
        this.f10334c.m11228b((Cursor) null);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    public String mo10353o() {
        return getString(R.string.title_media);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_gridview || menuItem.getItemId() == R.id.action_timeline) {
            ModesHelper.m10635a(getActivity(), menuItem.getItemId() == R.id.action_gridview ? ModesHelper.Mode.Gridview : ModesHelper.Mode.Timeline);
            getActivity().invalidateOptionsMenu();
            getLoaderManager().mo1684a(R.id.loader_media);
            m10598b();
            getLoaderManager().mo1683a(R.id.loader_media, null, this);
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseRestoreDialog.BackupKeyRestoredListener
    /* JADX INFO: renamed from: a */
    public void mo10576a(Loop loop) {
        getLoaderManager().mo1688b(R.id.loader_loops, null, this);
    }

    /* JADX INFO: renamed from: b */
    private void m10598b() {
        if (this.list != null) {
            CustomGridLayoutManager customGridLayoutManager = new CustomGridLayoutManager(getActivity(), ModesHelper.m10637b(), 1, false);
            this.list.removeAllViewsInLayout();
            this.list.setHasFixedSize(true);
            this.list.removeOnScrollListener(this.f10346u);
            this.list.addOnScrollListener(this.f10346u);
            try {
                Field declaredField = this.list.getClass().getDeclaredField("mItemDecorations");
                declaredField.setAccessible(true);
                ((ArrayList) declaredField.get(this.list)).clear();
            } catch (Exception e) {
                Crashlytics.m5597a((Throwable) e);
            }
            this.list.addItemDecoration(ModesHelper.m10634a(getActivity()));
            this.list.setItemAnimator(new DefaultItemAnimator());
            this.list.setLayoutManager(customGridLayoutManager);
            this.list.setHapticFeedbackEnabled(!ModesHelper.m10636a());
            customGridLayoutManager.m4213a(new GridLayoutManager.SpanSizeLookup() { // from class: com.jibo.ui.fragment.home.MediaFragment.5
                @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
                /* JADX INFO: renamed from: a */
                public int mo4230a(int i) {
                    if (MediaFragment.this.list == null || MediaFragment.this.list.getAdapter() == null) {
                        return 0;
                    }
                    switch (MediaFragment.this.list.getAdapter().getItemViewType(i)) {
                        case 1:
                            if (MediaFragment.this.list != null && MediaFragment.this.list.getAdapter() != null) {
                                break;
                            }
                            break;
                    }
                    return 0;
                }
            });
            this.f10334c = new MomentsAdapter(this, null, this.f10339n);
            this.list.setAdapter(this.f10334c);
            this.swipeRefreshLayout.setEnabled(ModesHelper.m10636a());
        }
    }

    /* JADX INFO: renamed from: q */
    private void m10616q() {
        mo10345g();
        this.swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: renamed from: r */
    private void m10618r() {
        SparseBooleanArray sparseBooleanArrayM10659c = this.f10339n.m10659c();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < sparseBooleanArrayM10659c.size(); i++) {
            try {
                int iKeyAt = sparseBooleanArrayM10659c.keyAt(i);
                if (sparseBooleanArrayM10659c.get(iKeyAt, false)) {
                    int iM10645a = this.f10334c.m10645a(iKeyAt);
                    if (this.f10334c.m11226a() != null && iM10645a >= 0) {
                        this.f10334c.m11226a().moveToPosition(iM10645a);
                        arrayList.add(this.f10334c.m11226a().getString(this.f10334c.m11226a().getColumnIndex("_id")));
                    }
                }
            } catch (Exception e) {
                Crashlytics.m5597a((Throwable) e);
            }
        }
        if (arrayList.size() > 0) {
            String[] strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
            MediaDeletingService.m10171a(getActivity(), strArr, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: s */
    public void m10620s() {
        SparseBooleanArray sparseBooleanArrayM10659c = this.f10339n.m10659c();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < sparseBooleanArrayM10659c.size(); i++) {
            try {
                int iKeyAt = sparseBooleanArrayM10659c.keyAt(i);
                if (sparseBooleanArrayM10659c.get(iKeyAt, false)) {
                    int iM10645a = this.f10334c.m10645a(iKeyAt);
                    if (this.f10334c.m11226a() != null && iM10645a >= 0) {
                        this.f10334c.m11226a().moveToPosition(iM10645a);
                        String string = this.f10334c.m11226a().getString(this.f10334c.m11226a().getColumnIndex("reference"));
                        if (!TextUtils.isEmpty(string)) {
                            arrayList.add(string);
                        }
                    }
                }
            } catch (Exception e) {
                Crashlytics.m5597a((Throwable) e);
            }
        }
        if (arrayList.size() > 0) {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ARG_IDS", arrayList);
            DownloadProgressFragment downloadProgressFragment = new DownloadProgressFragment();
            downloadProgressFragment.setArguments(bundle);
            downloadProgressFragment.setTargetFragment(this, 118);
            downloadProgressFragment.show(getFragmentManager(), DownloadProgressFragment.class.getSimpleName());
        }
    }

    static class CustomGridLayoutManager extends GridLayoutManager {

        /* JADX INFO: renamed from: z */
        private boolean f10357z;

        public CustomGridLayoutManager(Context context, int i, int i2, boolean z) {
            super(context, i, i2, z);
            this.f10357z = true;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        /* JADX INFO: renamed from: f */
        public boolean mo4316f() {
            return this.f10357z && super.mo4316f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: t */
    public void m10622t() {
        if (m10342d()) {
            LoopPassphraseUtils.DialogType dialogTypeM10579a = LoopPassphraseUtils.m10579a(getContext(), SharedPreferencesUtil.m11443f(getContext()).getId(), !this.f10337l);
            if (dialogTypeM10579a != null && !LoopPassphraseUtils.m10585a(getFragmentManager()) && m10342d()) {
                LoopPassphraseUtils.m10581a(this, dialogTypeM10579a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: u */
    public void m10624u() {
        if (m10342d()) {
            final Loop loopM11443f = SharedPreferencesUtil.m11443f(getContext());
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, SharedPreferencesUtil.m11453m(getActivity()));
            if (arrayList.indexOf(loopM11443f.getId()) >= 0 && !LoopPassphraseUtils.m10585a(getFragmentManager()) && m10342d() && !m10599b(loopM11443f)) {
                SharedPreferencesUtil.m11442e(getActivity(), loopM11443f.getId());
                LoopPassphraseUtils.m10584a(loopM11443f.getId(), this, new LoopPassphraseUtils.KeyBackupCheckListener() { // from class: com.jibo.ui.fragment.home.MediaFragment.6
                    @Override // com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseUtils.KeyBackupCheckListener
                    /* JADX INFO: renamed from: a */
                    public void mo10588a() {
                        if (!LoopPassphraseUtils.m10585a(MediaFragment.this.getFragmentManager()) && MediaFragment.this.m10342d()) {
                            LoopPassphraseUtils.m10582a(MediaFragment.this, LoopPassphraseUtils.DialogType.RESTORE_BY_TIMEOUT, loopM11443f);
                        }
                    }

                    @Override // com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseUtils.KeyBackupCheckListener
                    /* JADX INFO: renamed from: b */
                    public void mo10589b() {
                        if (!LoopPassphraseUtils.m10585a(MediaFragment.this.getFragmentManager()) && MediaFragment.this.m10342d()) {
                            LoopPassphraseUtils.m10583a(MediaFragment.this, LoopPassphraseUtils.DialogType.NO_BACKUP_BY_TIMEOUT, (String) null);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m10599b(Loop loop) {
        KeyManager.SymmetricKeyHolder symmetricKeyHolderObtainKeyHolder;
        try {
            symmetricKeyHolderObtainKeyHolder = KeyManager.getInstance(getContext(), EntityData.m10089a(getActivity()).m10134i().getId()).obtainKeyHolder(getContext(), loop.getId());
        } catch (Exception e) {
            symmetricKeyHolderObtainKeyHolder = null;
        }
        return symmetricKeyHolderObtainKeyHolder != null;
    }

    private static class HeaderItem {

        /* JADX INFO: renamed from: a */
        public int f10358a;

        /* JADX INFO: renamed from: b */
        public String f10359b;

        /* JADX INFO: renamed from: c */
        public String f10360c;

        /* JADX INFO: renamed from: d */
        public int f10361d;

        /* JADX INFO: renamed from: e */
        public int f10362e;

        public HeaderItem(int i, String str, int i2, int i3, String str2) {
            this.f10358a = i;
            this.f10359b = str;
            this.f10361d = i2;
            this.f10362e = i3;
            this.f10360c = str2;
        }
    }

    private static class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(View view) {
            super(view);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        @BindView
        public TextView selectAll;

        @BindView
        public TextView text1;

        public HeaderViewHolder(View view, View.OnClickListener onClickListener) {
            super(view);
            ButterKnife.m5154a(this, view);
            this.selectAll.setOnClickListener(onClickListener);
        }

        /* JADX INFO: renamed from: a */
        public void m10628a(HeaderItem headerItem) {
            this.text1.setText(headerItem.f10359b);
            this.selectAll.setTag(headerItem);
            m10627a();
        }

        /* JADX INFO: renamed from: a */
        public void m10627a() {
            boolean z;
            HeaderItem headerItem = (HeaderItem) this.selectAll.getTag();
            int i = headerItem.f10361d;
            while (true) {
                if (i > headerItem.f10362e) {
                    z = false;
                    break;
                } else if (MediaFragment.this.f10339n.m10657a(i)) {
                    i++;
                } else {
                    z = true;
                    break;
                }
            }
            this.selectAll.setVisibility(z ? 0 : 4);
        }
    }

    static class PhotoItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        private MediaFragment f10382a;

        /* JADX INFO: renamed from: b */
        private PhotoSelector f10383b;

        /* JADX INFO: renamed from: c */
        private boolean f10384c;

        @BindView
        public TextView checkbox;

        /* JADX INFO: renamed from: d */
        private Media f10385d;

        /* JADX INFO: renamed from: e */
        private int f10386e;

        /* JADX INFO: renamed from: f */
        private float f10387f;

        /* JADX INFO: renamed from: g */
        private float f10388g;

        @BindView
        public ImageView photo;

        public PhotoItemViewHolder(MediaFragment mediaFragment, View view, PhotoSelector photoSelector, boolean z) {
            super(view);
            this.f10382a = mediaFragment;
            this.f10383b = photoSelector;
            this.f10384c = z;
            ButterKnife.m5154a(this, view);
            if (this.f10384c) {
                int width = (this.f10382a.list.getWidth() / ModesHelper.m10637b()) / 15;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.checkbox.getLayoutParams();
                layoutParams.setMargins(width, width, 0, 0);
                this.checkbox.setLayoutParams(layoutParams);
            }
        }

        /* JADX INFO: renamed from: a */
        public void m10653a(int i, Media media, boolean z) {
            this.f10385d = media;
            this.itemView.setTag(this.f10385d);
            int iM10637b = ModesHelper.m10637b() / this.f10386e;
            int dimensionPixelOffset = (i - (((iM10637b + 1) * 2) * this.itemView.getResources().getDimensionPixelOffset(R.dimen.moment_grid_item_padding))) / iM10637b;
            int iM10638c = (int) (dimensionPixelOffset / ModesHelper.m10638c());
            this.f10387f = (dimensionPixelOffset - this.itemView.getContext().getResources().getDimension(R.dimen.activity_horizontal_margin)) / dimensionPixelOffset;
            this.f10388g = (iM10638c - this.itemView.getContext().getResources().getDimension(R.dimen.activity_vertical_margin)) / iM10638c;
            this.photo.setLayoutParams(new RelativeLayout.LayoutParams(dimensionPixelOffset, iM10638c));
            this.photo.requestLayout();
            m10654a(false);
            Glide.m5254b(this.itemView.getContext()).m5279a(MediaHelper.getUrl(z, this.f10385d)).mo5224b(new RequestListener<String, GlideDrawable>() { // from class: com.jibo.ui.fragment.home.MediaFragment.PhotoItemViewHolder.1
                @Override // com.bumptech.glide.request.RequestListener
                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public boolean mo5532a(Exception exc, String str, Target<GlideDrawable> target, boolean z2) {
                    PhotoItemViewHolder.this.f10382a.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.home.MediaFragment.PhotoItemViewHolder.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PhotoItemViewHolder.this.photo.setImageBitmap(null);
                        }
                    });
                    return false;
                }

                @Override // com.bumptech.glide.request.RequestListener
                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public boolean mo5533a(GlideDrawable glideDrawable, String str, Target<GlideDrawable> target, boolean z2, boolean z3) {
                    return false;
                }
            }).m5205a().mo5239j().mo5223b(DiskCacheStrategy.ALL).mo5216a(this.photo);
        }

        /* JADX INFO: renamed from: a */
        public void m10652a(int i) {
            this.f10386e = i;
        }

        /* JADX INFO: renamed from: a */
        public void m10654a(boolean z) {
            if (this.f10384c) {
                if (this.f10382a.m10354p().m10303r() != null) {
                    this.checkbox.setSelected(this.f10383b.m10657a(getAdapterPosition()));
                    this.checkbox.setVisibility(0);
                    this.photo.animate().setDuration(z ? 200L : 0L).scaleX(this.checkbox.isSelected() ? this.f10387f : 1.0f).scaleY(this.checkbox.isSelected() ? this.f10388g : 1.0f).start();
                } else {
                    this.checkbox.setVisibility(4);
                    this.photo.animate().setDuration(z ? 200L : 0L).scaleX(1.0f).scaleY(1.0f).start();
                }
            }
        }

        /* JADX INFO: renamed from: a */
        public void m10651a() {
            if (this.f10384c) {
                if (this.f10383b.m10657a(getAdapterPosition()) != this.checkbox.isSelected()) {
                    this.photo.animate().setDuration(200L).scaleX(this.f10383b.m10657a(getAdapterPosition()) ? this.f10387f : 1.0f).scaleY(this.f10383b.m10657a(getAdapterPosition()) ? this.f10388g : 1.0f).start();
                }
                this.checkbox.setSelected(this.f10383b.m10657a(getAdapterPosition()));
            }
        }
    }

    public class MomentsAdapter extends RecyclerCursorAdapter<RecyclerView.ViewHolder> {

        /* JADX INFO: renamed from: d */
        private final boolean f10371d;

        /* JADX INFO: renamed from: e */
        private MediaFragment f10372e;

        /* JADX INFO: renamed from: f */
        private PhotoSelector f10373f;

        /* JADX INFO: renamed from: g */
        private Map<Integer, HeaderItem> f10374g;

        /* JADX INFO: renamed from: h */
        private View.OnClickListener f10375h;

        /* JADX INFO: renamed from: i */
        private View.OnClickListener f10376i;

        /* JADX INFO: renamed from: j */
        private View.OnLongClickListener f10377j;

        public MomentsAdapter(MediaFragment mediaFragment, Cursor cursor, PhotoSelector photoSelector) {
            super(cursor);
            this.f10374g = new HashMap();
            this.f10375h = new View.OnClickListener() { // from class: com.jibo.ui.fragment.home.MediaFragment.MomentsAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HeaderItem headerItem = (HeaderItem) view.getTag();
                    for (int i = headerItem.f10361d; i <= headerItem.f10362e; i++) {
                        MomentsAdapter.this.f10373f.m10656a(i, true);
                    }
                    if (MediaFragment.this.m10354p().m10303r() == null) {
                        MediaFragment.this.m10354p().m10300a(((AppCompatActivity) MediaFragment.this.getActivity()).startSupportActionMode(MediaFragment.this.f10341p));
                        MomentsAdapter.this.notifyItemRangeChanged(MomentsAdapter.this.m10639a(MediaFragment.this.list.getChildAt(0)), MediaFragment.this.list.getChildCount(), MediaFragment.this.f10341p);
                    } else {
                        MomentsAdapter.this.notifyItemChanged(headerItem.f10361d - 1);
                        MomentsAdapter.this.notifyItemRangeChanged(headerItem.f10361d, (headerItem.f10362e - headerItem.f10361d) + 1, MomentsAdapter.this.f10373f);
                    }
                    MediaFragment.this.m10354p().m10304s();
                }
            };
            this.f10376i = new View.OnClickListener() { // from class: com.jibo.ui.fragment.home.MediaFragment.MomentsAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int iM10639a = MomentsAdapter.this.m10639a(view);
                    if (iM10639a != -1 && (MediaFragment.this.list.getChildViewHolder(view) instanceof PhotoItemViewHolder)) {
                        if (MediaFragment.this.m10354p().m10303r() != null) {
                            MomentsAdapter.this.f10373f.m10656a(iM10639a, MomentsAdapter.this.f10373f.m10657a(iM10639a) ? false : true);
                            MomentsAdapter.this.notifyItemChanged(iM10639a, MomentsAdapter.this.f10373f);
                            MediaFragment.this.m10354p().m10304s();
                        } else {
                            Intent intent = new Intent(MediaFragment.this.getActivity(), (Class<?>) PhotoViewerActivity.class);
                            intent.putExtra("media_indx", MomentsAdapter.this.m10645a(iM10639a));
                            intent.setData(DatabaseContract.MediaEntry.f9699b);
                            intent.putExtra("where", "url IS NOT NULL AND type = ? AND loopId IN (" + MediaCursor.m10633b((Map<String, Loop>) MediaFragment.this.f10336e) + ")");
                            intent.putExtra("where_args", new String[]{Media.TYPE_IMAGE});
                            intent.putExtra("projection", DatabaseContract.MediaEntry.f9698a);
                            intent.putExtra("order", "created DESC");
                            MediaFragment.this.startActivity(intent);
                        }
                        MediaFragment.this.m10594a(iM10639a);
                    }
                }
            };
            this.f10377j = new View.OnLongClickListener() { // from class: com.jibo.ui.fragment.home.MediaFragment.MomentsAdapter.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    int iM10639a = MomentsAdapter.this.m10639a(view);
                    if (iM10639a != -1 && (MediaFragment.this.list.findContainingViewHolder(view) instanceof PhotoItemViewHolder)) {
                        MediaFragment.this.list.performHapticFeedback(0);
                        MomentsAdapter.this.f10373f.m10656a(iM10639a, true);
                        if (MediaFragment.this.m10354p().m10303r() != null) {
                            MomentsAdapter.this.notifyItemChanged(iM10639a, MomentsAdapter.this.f10373f);
                        } else {
                            MediaFragment.this.m10354p().m10300a(((AppCompatActivity) MediaFragment.this.getActivity()).startSupportActionMode(MediaFragment.this.f10341p));
                            MomentsAdapter.this.notifyItemRangeChanged(0, MediaFragment.this.f10334c.getItemCount(), MediaFragment.this.f10341p);
                        }
                        MediaFragment.this.m10354p().m10304s();
                    }
                    MediaFragment.this.m10594a(iM10639a);
                    return true;
                }
            };
            this.f10372e = mediaFragment;
            this.f10373f = photoSelector;
            this.f10371d = SharedPreferencesUtil.m11446g(mediaFragment.getActivity().getApplicationContext());
        }

        /* JADX INFO: renamed from: d */
        private boolean m10644d() {
            return (this.f10374g == null || this.f10374g.size() == 0 || !m11230c()) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: b */
        public int m10643b(int i) {
            int i2;
            if (!ModesHelper.m10636a()) {
                return 1;
            }
            int iM10637b = ModesHelper.m10637b();
            if (!m10644d() || !ModesHelper.m10636a()) {
                return iM10637b;
            }
            Iterator<Map.Entry<Integer, HeaderItem>> it = this.f10374g.entrySet().iterator();
            while (it.hasNext()) {
                HeaderItem value = it.next().getValue();
                if (value.f10361d <= i && i <= value.f10362e) {
                    int i3 = i - value.f10361d;
                    int i4 = (value.f10362e - value.f10361d) + 1;
                    int i5 = i4 / 3;
                    int i6 = i4 % 3;
                    if (i6 == 2) {
                        i2 = 3;
                    } else if (i4 < 5) {
                        i2 = i4;
                    } else if (i6 == 1) {
                        i2 = 5;
                    } else {
                        i2 = (i6 == 0 && i5 == 2) ? 4 : 0;
                    }
                    int i7 = i2 - 1;
                    if (i3 >= i7 && i4 > 4) {
                        return iM10637b / 3;
                    }
                    if (i4 <= 4) {
                        i7 = i4;
                    }
                    return i3 >= (i7 % 2 != 0 ? 1 : 0) ? iM10637b / 2 : iM10637b;
                }
            }
            return iM10637b;
        }

        /* JADX INFO: renamed from: a */
        public int m10645a(int i) {
            if (!m10644d()) {
                return -1;
            }
            Iterator<Map.Entry<Integer, HeaderItem>> it = this.f10374g.entrySet().iterator();
            while (it.hasNext()) {
                HeaderItem value = it.next().getValue();
                if (value.f10361d <= i && i <= value.f10362e) {
                    return i - value.f10358a;
                }
            }
            return -1;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (!m10644d()) {
                return -1;
            }
            for (Map.Entry<Integer, HeaderItem> entry : this.f10374g.entrySet()) {
                HeaderItem value = entry.getValue();
                if (entry.getKey().intValue() == i) {
                    return ViewType.header.ordinal();
                }
                if (value.f10361d <= i && i <= value.f10362e) {
                    return ViewType.media.ordinal();
                }
            }
            return -1;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (!m10644d() || i == -1) {
                return new EmptyViewHolder(new View(viewGroup.getContext()));
            }
            switch (ViewType.values()[i]) {
                case header:
                    return MediaFragment.this.new HeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(ModesHelper.m10636a() ? R.layout.item_timeline_dateheader : R.layout.item_gridview_dateheader, viewGroup, false), this.f10375h);
                case media:
                    View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_photo_moment_selectable, viewGroup, false);
                    PhotoItemViewHolder photoItemViewHolder = new PhotoItemViewHolder(this.f10372e, viewInflate, this.f10373f, true);
                    viewInflate.setOnClickListener(this.f10376i);
                    viewInflate.setOnLongClickListener(this.f10377j);
                    return photoItemViewHolder;
                default:
                    return null;
            }
        }

        @Override // com.jibo.p019ui.helpers.RecyclerCursorAdapter, android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (m10644d() && getItemViewType(i) != -1) {
                switch (ViewType.values()[getItemViewType(i)]) {
                    case header:
                        ((HeaderViewHolder) viewHolder).m10628a(this.f10374g.get(Integer.valueOf(i)));
                        break;
                    case media:
                        int iM10645a = m10645a(i);
                        int iM10643b = m10643b(i);
                        if (iM10645a != -1) {
                            ((PhotoItemViewHolder) viewHolder).m10652a(iM10643b);
                            super.onBindViewHolder(viewHolder, iM10645a);
                        }
                        break;
                }
            }
        }

        @Override // com.jibo.p019ui.helpers.RecyclerCursorAdapter
        /* JADX INFO: renamed from: a */
        public void mo10646a(RecyclerView.ViewHolder viewHolder, Cursor cursor) {
            if (viewHolder instanceof PhotoItemViewHolder) {
                EntityData.m10089a(viewHolder.itemView.getContext());
                ((PhotoItemViewHolder) viewHolder).m10653a(this.f10372e.list.getWidth(), EntityData.m10097c(cursor), this.f10371d);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
            if (m10644d() && getItemViewType(i) != -1) {
                if (list == null || list.isEmpty()) {
                    onBindViewHolder(viewHolder, i);
                    return;
                }
                switch (ViewType.values()[getItemViewType(i)]) {
                    case header:
                        if (list.get(0) instanceof ActionMode.Callback) {
                            ((HeaderViewHolder) viewHolder).m10627a();
                        }
                        break;
                    case media:
                        if (list.get(0) instanceof PhotoSelector) {
                            ((PhotoItemViewHolder) viewHolder).m10651a();
                        }
                        if (list.get(0) instanceof ActionMode.Callback) {
                            ((PhotoItemViewHolder) viewHolder).m10654a(true);
                            ((PhotoItemViewHolder) viewHolder).m10651a();
                        }
                        break;
                }
            }
        }

        @Override // com.jibo.p019ui.helpers.RecyclerCursorAdapter, android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (m10644d()) {
                return super.getItemCount() + this.f10374g.size();
            }
            return 0;
        }

        /* JADX INFO: renamed from: a */
        public void m10647a(Map<Integer, HeaderItem> map) {
            this.f10374g.clear();
            this.f10374g.putAll(map);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public int m10639a(View view) {
            if (view == null) {
                return -1;
            }
            int childAdapterPosition = MediaFragment.this.list.getChildAdapterPosition(view);
            if (childAdapterPosition == -1) {
                try {
                    return MediaFragment.this.list.getChildViewHolder(view).getAdapterPosition();
                } catch (Exception e) {
                    Crashlytics.m5597a((Throwable) e);
                    return childAdapterPosition;
                }
            }
            return childAdapterPosition;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m10594a(int i) {
        for (HeaderItem headerItem : this.f10335d.values()) {
            if (i >= headerItem.f10361d && i <= headerItem.f10362e) {
                this.f10334c.notifyItemRangeChanged(headerItem.f10361d - 1, 1);
                return;
            }
        }
    }

    private static class MediaCursor extends CursorLoader {

        /* JADX INFO: renamed from: w */
        private Map<Integer, HeaderItem> f10365w;

        /* JADX INFO: renamed from: x */
        private Map<String, Loop> f10366x;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: b */
        public static String m10633b(Map<String, Loop> map) {
            return "'" + TextUtils.join("','", map.keySet()) + "'";
        }

        public MediaCursor(Context context, Map<Integer, HeaderItem> map, Map<String, Loop> map2) {
            super(context, DatabaseContract.MediaEntry.f9699b, DatabaseContract.MediaEntry.f9698a, "reference IS NOT NULL AND url IS NOT NULL AND type = ? AND loopId IN (" + m10633b(map2) + ")", new String[]{Media.TYPE_THUMBNAIL}, "created DESC");
            this.f10365w = map;
            this.f10366x = map2;
        }

        @Override // android.support.v4.content.CursorLoader, android.support.v4.content.AsyncTaskLoader
        /* JADX INFO: renamed from: h */
        public Cursor mo1824d() {
            if (ModesHelper.m10636a()) {
                this.f10365w.clear();
                this.f10365w.putAll(m10629C());
            } else {
                this.f10365w.clear();
                this.f10365w.putAll(m10630D());
            }
            return super.mo1824d();
        }

        @Override // android.support.v4.content.CursorLoader, android.support.v4.content.AsyncTaskLoader
        /* JADX INFO: renamed from: f */
        public void mo1826f() {
            super.mo1826f();
        }

        /* JADX INFO: renamed from: C */
        private Map<Integer, HeaderItem> m10629C() {
            Cursor cursorQuery;
            String formattedDate;
            int i = 0;
            HashMap map = new HashMap();
            try {
                cursorQuery = DatabaseHelper.m10084a(m1863m()).getReadableDatabase().query(ShareConstants.WEB_DIALOG_PARAM_MEDIA, new String[]{"count(*) AS _count", "created", "loopId"}, "reference IS NOT NULL AND url IS NOT NULL AND type = ? AND loopId IN (" + m10633b(this.f10366x) + ")", new String[]{Media.TYPE_THUMBNAIL}, "date(substr(created, 0, length(created) - 2), 'unixepoch') ", null, "created DESC", null);
            } catch (Exception e) {
                Crashlytics.m5597a((Throwable) e);
                cursorQuery = null;
            }
            if (cursorQuery == null || cursorQuery.isClosed()) {
                return map;
            }
            Calendar calendar = Calendar.getInstance();
            int i2 = (calendar.get(1) * 100) + calendar.get(6);
            calendar.add(6, -1);
            int i3 = (calendar.get(1) * 100) + calendar.get(6);
            calendar.add(6, 1);
            try {
                cursorQuery.moveToFirst();
                int i4 = 0;
                while (!cursorQuery.isAfterLast()) {
                    calendar.setTimeInMillis(cursorQuery.getLong(1));
                    i++;
                    if (i2 == (calendar.get(1) * 100) + calendar.get(6)) {
                        formattedDate = m1863m().getString(R.string.text_today);
                    } else if (i3 == (calendar.get(1) * 100) + calendar.get(6)) {
                        formattedDate = m1863m().getString(R.string.text_yesterday);
                    } else {
                        formattedDate = DateTimeUtils.getFormattedDate(calendar.getTimeInMillis(), "EEE M/dd/yy");
                    }
                    map.put(Integer.valueOf((i4 + i) - 1), new HeaderItem(map.size() + 1, formattedDate, i + i4, ((i + i4) + cursorQuery.getInt(0)) - 1, m10631a(cursorQuery.getString(cursorQuery.getColumnIndex("loopId")))));
                    int i5 = cursorQuery.getInt(0) + i4;
                    cursorQuery.moveToNext();
                    i4 = i5;
                }
            } catch (Exception e2) {
                Crashlytics.m5597a((Throwable) e2);
            } finally {
                cursorQuery.close();
            }
            return map;
        }

        /* JADX INFO: renamed from: D */
        private Map<Integer, HeaderItem> m10630D() {
            Cursor cursorQuery;
            int i = 0;
            HashMap map = new HashMap();
            try {
                cursorQuery = DatabaseHelper.m10084a(m1863m()).getReadableDatabase().query(ShareConstants.WEB_DIALOG_PARAM_MEDIA, new String[]{"count(*) AS _count", "created", "loopId"}, "type = ? AND loopId IN (" + m10633b(this.f10366x) + ")", new String[]{Media.TYPE_THUMBNAIL}, "strftime('%Y%m', substr(created, 0, length(created) - 2), 'unixepoch', 'localtime')", null, "created DESC", null);
            } catch (Exception e) {
                Crashlytics.m5597a((Throwable) e);
                cursorQuery = null;
            }
            if (cursorQuery == null || cursorQuery.isClosed()) {
                return map;
            }
            Calendar calendar = Calendar.getInstance();
            try {
                cursorQuery.moveToFirst();
                int i2 = 0;
                while (!cursorQuery.isAfterLast()) {
                    calendar.setTimeInMillis(cursorQuery.getLong(1));
                    i++;
                    map.put(Integer.valueOf((i2 + i) - 1), new HeaderItem(map.size() + 1, calendar.getDisplayName(2, 2, Locale.getDefault()), i + i2, ((i + i2) + cursorQuery.getInt(0)) - 1, ""));
                    int i3 = cursorQuery.getInt(0) + i2;
                    cursorQuery.moveToNext();
                    i2 = i3;
                }
            } catch (Exception e2) {
                Crashlytics.m5597a((Throwable) e2);
            } finally {
                cursorQuery.close();
            }
            return map;
        }

        /* JADX INFO: renamed from: a */
        private String m10631a(String str) {
            Loop loop = this.f10366x.get(str);
            if (loop != null) {
                return loop.getName();
            }
            return str;
        }
    }

    public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a */
        private int f10393a;

        public SpacesItemDecoration(int i) {
            this.f10393a = i;
        }

        public SpacesItemDecoration(Context context, int i) {
            this(context.getResources().getDimensionPixelSize(i));
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        /* JADX INFO: renamed from: a */
        public void mo4460a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.mo4460a(rect, view, recyclerView, state);
            rect.set(this.f10393a, this.f10393a, this.f10393a, this.f10393a);
        }
    }

    public static class ModesHelper {

        /* JADX INFO: renamed from: a */
        private static final int[] f10367a = {6, 4};

        /* JADX INFO: renamed from: b */
        private static final float[] f10368b = {1.7777777f, 1.0f};

        /* JADX INFO: renamed from: c */
        private static Mode f10369c = Mode.Timeline;

        public enum Mode {
            Timeline,
            Gridview
        }

        /* JADX INFO: renamed from: a */
        public static void m10635a(Context context, Mode mode) {
            f10369c = Mode.values()[mode.ordinal()];
            context.getSharedPreferences(context.getString(R.string.app_name), 0).edit().putInt("PREF_MEDIA_TAB_MODE", mode.ordinal()).apply();
        }

        /* JADX INFO: renamed from: a */
        public static boolean m10636a() {
            return f10369c == Mode.Timeline;
        }

        /* JADX INFO: renamed from: b */
        public static int m10637b() {
            return f10367a[f10369c.ordinal()];
        }

        /* JADX INFO: renamed from: c */
        public static float m10638c() {
            return f10368b[f10369c.ordinal()];
        }

        /* JADX INFO: renamed from: a */
        public static RecyclerView.ItemDecoration m10634a(Context context) {
            return new SpacesItemDecoration(context, R.dimen.moment_grid_item_padding);
        }
    }

    private static class PhotoSelector {

        /* JADX INFO: renamed from: a */
        private SparseBooleanArray f10392a;

        private PhotoSelector() {
            this.f10392a = new SparseBooleanArray();
        }

        /* JADX INFO: renamed from: a */
        public void m10656a(int i, boolean z) {
            this.f10392a.put(i, z);
        }

        /* JADX INFO: renamed from: a */
        public boolean m10657a(int i) {
            return this.f10392a.get(i, false);
        }

        /* JADX INFO: renamed from: a */
        public int m10655a() {
            int i = 0;
            for (int i2 = 0; i2 < this.f10392a.size(); i2++) {
                if (this.f10392a.valueAt(i2)) {
                    i++;
                }
            }
            return i;
        }

        /* JADX INFO: renamed from: b */
        public void m10658b() {
            this.f10392a.clear();
        }

        /* JADX INFO: renamed from: c */
        public SparseBooleanArray m10659c() {
            return this.f10392a;
        }
    }

    class PaginationAsyncTask extends AsyncTask<Void, Void, Void> {
        PaginationAsyncTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0098, code lost:
        
            r1.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x009b, code lost:
        
            if (r1 == null) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x009d, code lost:
        
            r1.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00bc, code lost:
        
            r1.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00bf, code lost:
        
            if (r1 == null) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00c1, code lost:
        
            r1.close();
         */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Void doInBackground(java.lang.Void... r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 316
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jibo.ui.fragment.home.MediaFragment.PaginationAsyncTask.doInBackground(java.lang.Void[]):java.lang.Void");
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            if (!isCancelled() && MediaFragment.this.m10342d()) {
                MediaFragment.this.progressView.setVisibility(0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r3) {
            if (!isCancelled() && MediaFragment.this.m10342d()) {
                MediaFragment.this.f10343r = false;
                MediaFragment.this.progressView.setVisibility(4);
            }
        }
    }
}

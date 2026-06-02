package com.jibo.p019ui.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ShareCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseBooleanArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.crashlytics.android.Crashlytics;
import com.facebook.share.widget.ShareDialog;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.jibo.JiboAnalytics;
import com.jibo.JiboGlideModule;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.media.model.Media;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.helpers.MediaHelper;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.fragment.dialog.DialogUtils;
import com.jibo.p019ui.helpers.FragmentStateCursorPagerAdapter;
import com.jibo.p019ui.view.TouchImageView;
import com.jibo.service.MediaDeletingService;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import com.jibo.utils.NetworkStateReceiver;
import com.jibo.utils.OriginalKey;
import com.jibo.utils.SharedPreferencesUtil;
import com.yalantis.ucrop.view.CropImageView;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class PhotoViewerActivity extends AppCompatActivity implements DialogUtils.DialogFragmentWrapperClickListener {

    /* JADX INFO: renamed from: a */
    public static final String f9827a = LogUtils.m11405a(PhotoViewerActivity.class);

    /* JADX INFO: renamed from: f */
    private static SparseBooleanArray f9828f = new SparseBooleanArray();

    /* JADX INFO: renamed from: b */
    Unbinder f9829b;

    /* JADX INFO: renamed from: c */
    int f9830c;

    @BindView
    View footer;

    /* JADX INFO: renamed from: h */
    private MediaAdapter f9834h;

    /* JADX INFO: renamed from: i */
    private Media f9835i;

    /* JADX INFO: renamed from: j */
    private Cursor f9836j;

    /* JADX INFO: renamed from: m */
    private Account f9839m;

    @BindView
    ViewPager pager;

    @BindView
    TextView photoDateText;

    @BindView
    Toolbar toolbar;

    @BindView
    ImageView transitionImage;

    @BindView
    View viewNetworkDown;

    /* JADX INFO: renamed from: g */
    private int f9833g = 0;

    /* JADX INFO: renamed from: k */
    private int f9837k = 1536;

    /* JADX INFO: renamed from: d */
    boolean f9831d = true;

    /* JADX INFO: renamed from: e */
    int f9832e = 0;

    /* JADX INFO: renamed from: l */
    private ContentObserver f9838l = new ContentObserver(new Handler()) { // from class: com.jibo.ui.activity.PhotoViewerActivity.1
        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            PhotoViewerActivity.this.m10252c();
            PhotoViewerActivity.this.pager.setCurrentItem(PhotoViewerActivity.this.f9833g);
            PhotoViewerActivity.this.m10263i();
        }
    };

    /* JADX INFO: renamed from: n */
    private boolean f9840n = true;

    /* JADX INFO: renamed from: o */
    private NetworkStateReceiver f9841o = new NetworkStateReceiver() { // from class: com.jibo.ui.activity.PhotoViewerActivity.2
        @Override // com.jibo.utils.NetworkStateReceiver
        /* JADX INFO: renamed from: a */
        public void mo10207a(boolean z) {
            PhotoViewerActivity.this.f9840n = z;
            PhotoViewerActivity.this.runOnUiThread(new Runnable() { // from class: com.jibo.ui.activity.PhotoViewerActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    PhotoViewerActivity.this.viewNetworkDown.setVisibility(!PhotoViewerActivity.this.f9840n ? 0 : 8);
                    PhotoViewerActivity.this.invalidateOptionsMenu();
                }
            });
        }
    };

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        AppStartTrace.setLauncherActivityOnStartTime("com.jibo.ui.activity.PhotoViewerActivity");
        super.onStart();
    }

    public class PhotoFragment_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private PhotoFragment f9856b;

        /* JADX INFO: renamed from: c */
        private View f9857c;

        public PhotoFragment_ViewBinding(final PhotoFragment photoFragment, View view) {
            this.f9856b = photoFragment;
            photoFragment.image = (TouchImageView) Utils.m5161b(view, R.id.image, "field 'image'", TouchImageView.class);
            View viewM5158a = Utils.m5158a(view, android.R.id.progress, "field 'progress' and method 'onContentClick'");
            photoFragment.progress = viewM5158a;
            this.f9857c = viewM5158a;
            viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.activity.PhotoViewerActivity.PhotoFragment_ViewBinding.1
                @Override // butterknife.internal.DebouncingOnClickListener
                /* JADX INFO: renamed from: a */
                public void mo5157a(View view2) {
                    photoFragment.onContentClick(view2);
                }
            });
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            PhotoFragment photoFragment = this.f9856b;
            if (photoFragment == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f9856b = null;
            photoFragment.image = null;
            photoFragment.progress = null;
            this.f9857c.setOnClickListener(null);
            this.f9857c = null;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        AppStartTrace.setLauncherActivityOnCreateTime("com.jibo.ui.activity.PhotoViewerActivity");
        super.onCreate(bundle);
        setContentView(R.layout.activity_photoviewer);
        this.f9830c = m10254d();
        this.f9832e = m10256e();
        this.f9829b = ButterKnife.m5152a(this);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.jibo.ui.activity.PhotoViewerActivity.3
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if (PhotoViewerActivity.this.getResources().getConfiguration().orientation == 1) {
                    if ((i & 4) == 0) {
                        PhotoViewerActivity.this.toolbar.animate().alpha(1.0f).setDuration(300L).start();
                        PhotoViewerActivity.this.footer.animate().alpha(1.0f).setDuration(300L).start();
                        PhotoViewerActivity.this.viewNetworkDown.animate().alpha(1.0f).setDuration(300L).start();
                        return;
                    } else {
                        PhotoViewerActivity.this.toolbar.animate().alpha(CropImageView.DEFAULT_ASPECT_RATIO).setDuration(300L).start();
                        PhotoViewerActivity.this.footer.animate().alpha(CropImageView.DEFAULT_ASPECT_RATIO).setDuration(300L).start();
                        PhotoViewerActivity.this.viewNetworkDown.animate().alpha(CropImageView.DEFAULT_ASPECT_RATIO).setDuration(300L).start();
                        return;
                    }
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) PhotoViewerActivity.this.viewNetworkDown.getLayoutParams();
                if ((i & 4) == 0) {
                    layoutParams.setMargins(0, PhotoViewerActivity.this.f9830c, 0, 0);
                } else {
                    layoutParams.setMargins(0, 0, 0, 0);
                }
                PhotoViewerActivity.this.viewNetworkDown.setLayoutParams(layoutParams);
                PhotoViewerActivity.this.viewNetworkDown.animate().alpha(1.0f).setDuration(300L).start();
            }
        });
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setFlags(67108864, 67108864);
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        PhotoFragment.f9848a = point.y;
        getResources().getDisplayMetrics();
        m10260g();
        m10262h();
        if (getIntent().getStringExtra("media_id") == null || Build.VERSION.SDK_INT < 21) {
            this.transitionImage.setVisibility(8);
        }
        this.f9839m = EntityData.m10089a(this).m10134i();
        if (bundle == null) {
            if (getIntent() != null && getIntent().getExtras() != null) {
                this.f9833g = getIntent().getIntExtra("media_indx", 0);
            }
        } else {
            this.f9833g = bundle.getInt("media_indx", 0);
        }
        m10252c();
        this.pager.setCurrentItem(this.f9833g);
        m10263i();
        this.pager.m2715a(new ViewPager.OnPageChangeListener() { // from class: com.jibo.ui.activity.PhotoViewerActivity.4
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            /* JADX INFO: renamed from: a */
            public void mo907a(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            /* JADX INFO: renamed from: b */
            public void mo908b(int i) {
                PhotoViewerActivity.this.f9833g = i;
                if (PhotoViewerActivity.this.f9834h.m11195f() && PhotoViewerActivity.this.f9833g < PhotoViewerActivity.this.f9834h.mo2555b()) {
                    PhotoViewerActivity.this.f9834h.m11193d().moveToPosition(PhotoViewerActivity.this.f9833g);
                    PhotoViewerActivity.this.m10263i();
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            /* JADX INFO: renamed from: a */
            public void mo906a(int i) {
                if (PhotoViewerActivity.this.getResources().getConfiguration().orientation == 2) {
                    PhotoViewerActivity.this.m10260g();
                }
            }
        });
        this.pager.m2716a(false, (ViewPager.PageTransformer) new ZoomOutPageTransformer());
        m10265a();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        int i = R.color.white;
        getMenuInflater().inflate(R.menu.menu_photoviewer, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.action_share);
        MenuItem menuItemFindItem2 = menu.findItem(R.id.action_delete);
        ImageUtils.m11393a(this, menu);
        menuItemFindItem.setEnabled(this.f9840n && f9828f.get(this.pager.getCurrentItem(), false));
        ImageUtils.m11394a(this, menuItemFindItem, menuItemFindItem.isEnabled() ? R.color.white : R.color.light_grey);
        menuItemFindItem2.setEnabled(this.f9840n && f9828f.get(this.pager.getCurrentItem(), false));
        if (!menuItemFindItem2.isEnabled()) {
            i = R.color.light_grey;
        }
        ImageUtils.m11394a(this, menuItemFindItem2, i);
        if (this.f9835i != null && this.f9835i.getAccountId() != null) {
            if (LoopHelper.isOwner(EntityData.m10089a(this).m10125c(this.f9835i.getLoopId()), this.f9839m.getId()) || this.f9835i.getAccountId().equals(this.f9839m.getId())) {
                menuItemFindItem2.setVisible(true);
            } else {
                menuItemFindItem2.setVisible(false);
            }
        } else {
            menuItemFindItem2.setVisible(false);
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_delete /* 2131296292 */:
                DialogUtils.m10516a((Fragment) null, getSupportFragmentManager(), 117, getString(R.string.remove_media_confirm), getString(R.string.remove));
                return true;
            case R.id.action_share /* 2131296307 */:
                m10264j();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override // com.jibo.ui.fragment.dialog.DialogUtils.DialogFragmentWrapperClickListener
    /* JADX INFO: renamed from: a */
    public void mo10186a(int i, int i2, Object obj) {
        if (100 == i) {
            setResult(BaseActivity.f9762d);
            finish();
        } else if (117 == i) {
            JiboAnalytics.m9859j(this);
            MediaDeletingService.m10170a(this, this.f9835i);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("media_indx", this.f9833g);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        AppStartTrace.setLauncherActivityOnResumeTime("com.jibo.ui.activity.PhotoViewerActivity");
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        registerReceiver(this.f9841o, intentFilter);
        getContentResolver().registerContentObserver(getIntent().getData(), true, this.f9838l);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        unregisterReceiver(this.f9841o);
        getContentResolver().unregisterContentObserver(this.f9838l);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f9836j != null && !this.f9836j.isClosed()) {
            this.f9836j.close();
        }
        f9828f.clear();
        this.f9829b.unbind();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m10252c() {
        try {
            if (this.f9834h != null) {
                this.f9834h.m11190a((Cursor) null);
            }
            if (this.f9836j != null && !this.f9836j.isClosed()) {
                this.f9836j.close();
            }
            this.f9836j = null;
            this.f9836j = getContentResolver().query(getIntent().getData(), null, getIntent().getStringExtra("where"), getIntent().getStringArrayExtra("where_args"), getIntent().getStringExtra("order"));
            this.f9834h = new MediaAdapter(getSupportFragmentManager(), null);
            if (this.f9836j != null && !this.f9836j.isClosed() && this.f9836j.getCount() > 0 && this.f9836j.moveToFirst()) {
                this.f9833g = this.f9833g >= 0 ? this.f9833g : 0;
                this.f9833g = this.f9833g >= this.f9836j.getCount() ? this.f9836j.getCount() - 1 : this.f9833g;
                if (this.f9833g < this.f9836j.getCount() && this.f9833g >= 0) {
                    this.f9836j.moveToPosition(this.f9833g);
                    this.pager.setAdapter(this.f9834h);
                    this.f9834h.m11190a(this.f9836j);
                    return;
                }
                finish();
                return;
            }
            finish();
        } catch (Exception e) {
            Crashlytics.m5597a((Throwable) e);
        }
    }

    /* JADX INFO: renamed from: d */
    private int m10254d() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            return 0;
        }
        return getResources().getDimensionPixelSize(identifier);
    }

    /* JADX INFO: renamed from: e */
    private int m10256e() {
        boolean zHasPermanentMenuKey = ViewConfiguration.get(this).hasPermanentMenuKey();
        int identifier = getResources().getIdentifier(getResources().getConfiguration().orientation == 1 ? "navigation_bar_height" : "navigation_bar_height_landscape", "dimen", "android");
        if (identifier > 0 && !zHasPermanentMenuKey) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public void m10258f() {
        if ((this.f9837k & 4) == 0 && (this.f9837k & 2) == 0) {
            m10260g();
        } else {
            m10262h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public void m10260g() {
        this.f9837k = this.f9837k | 4 | 2048 | 2;
        getWindow().getDecorView().setSystemUiVisibility(this.f9837k);
    }

    /* JADX INFO: renamed from: h */
    private void m10262h() {
        this.f9837k = this.f9837k & (-5) & (-3);
        getWindow().getDecorView().setSystemUiVisibility(this.f9837k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i */
    public void m10263i() {
        EntityData.m10089a(this);
        this.f9835i = EntityData.m10097c(this.f9834h.m11193d());
        if (this.f9835i != null && this.f9834h.m11193d() != null && !this.f9834h.m11193d().isClosed() && this.f9834h.m11193d().getCount() != 0) {
            invalidateOptionsMenu();
            try {
                String[] dateTimeParts = DateTimeUtils.getDateTimeParts(this.f9835i.getCreated().longValue(), "M/d/yy", "hh:mm a", false, getString(R.string.text_yesterday), getString(R.string.text_today), getString(R.string.text_tomorrow));
                this.photoDateText.setText(getString(R.string.media_created_at, new Object[]{dateTimeParts[0], dateTimeParts[1]}));
            } catch (Exception e) {
                this.photoDateText.setText("");
            }
        }
    }

    /* JADX INFO: renamed from: j */
    private void m10264j() {
        File file = new File(getExternalCacheDir(), OriginalKey.m11418a(MediaHelper.getUrl(SharedPreferencesUtil.m11446g(getApplicationContext()), this.f9835i)));
        File shareableFile = MediaHelper.getShareableFile(getExternalCacheDir() + "/" + ShareDialog.WEB_SHARE_DIALOG, this.f9835i);
        try {
            JiboGlideModule.m9866b(this);
            if (!shareableFile.exists()) {
                ImageUtils.m11396a(file, shareableFile);
            }
            Uri uriM1848a = FileProvider.m1848a(this, "com.jibo.fileprovider", shareableFile);
            Intent intentM1797b = ShareCompat.IntentBuilder.m1790a(this).m1796a(getContentResolver().getType(uriM1848a)).m1794a(uriM1848a).m1793a(R.string.text_sharre_with).m1797b();
            intentM1797b.addFlags(1);
            if (intentM1797b.resolveActivity(getPackageManager()) != null) {
                startActivity(intentM1797b);
                JiboAnalytics.m9850e(this);
                return;
            }
            throw new Exception(getString(R.string.dialog_message_sharing_error));
        } catch (Exception e) {
            Crashlytics.m5597a((Throwable) e);
            DialogUtils.m10525c((Fragment) null, getSupportFragmentManager(), 104, getString(R.string.title_Error), getString(R.string.dialog_message_sharing_error));
        }
    }

    public class MediaAdapter extends FragmentStateCursorPagerAdapter {
        public MediaAdapter(FragmentManager fragmentManager, Cursor cursor) {
            super(fragmentManager, cursor);
        }

        @Override // com.jibo.p019ui.helpers.FragmentStateCursorPagerAdapter
        /* JADX INFO: renamed from: a */
        public Fragment mo10266a(int i) {
            return Fragment.instantiate(PhotoViewerActivity.this, PhotoFragment.class.getName(), null);
        }

        @Override // com.jibo.p019ui.helpers.FragmentStateCursorPagerAdapter
        /* JADX INFO: renamed from: a */
        public void mo10267a(Fragment fragment, Cursor cursor, int i) {
            if (!fragment.isAdded()) {
                Bundle bundle = new Bundle();
                bundle.putInt("media_indx", i);
                EntityData.m10089a(fragment.getActivity());
                Media mediaM10097c = EntityData.m10097c(cursor);
                if (mediaM10097c != null) {
                    bundle.putParcelable("entity", mediaM10097c);
                }
                fragment.setArguments(bundle);
            }
        }
    }

    public static class PhotoFragment extends Fragment {

        /* JADX INFO: renamed from: a */
        public static int f9848a = 0;

        /* JADX INFO: renamed from: b */
        Unbinder f9849b;

        @BindView
        TouchImageView image;

        @BindView
        View progress;

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewInflate = layoutInflater.inflate(R.layout.fragment_snap_photo, viewGroup, false);
            this.f9849b = ButterKnife.m5154a(this, viewInflate);
            final int i = getArguments().getInt("media_indx");
            Media media = (Media) getArguments().getParcelable("entity");
            this.image.setLayoutParams(new RelativeLayout.LayoutParams(-1, f9848a));
            this.progress.setVisibility(0);
            this.image.setEnabled(false);
            Glide.m5254b(this.image.getContext()).m5279a(MediaHelper.getUrl(SharedPreferencesUtil.m11446g(getActivity().getApplicationContext()), media)).mo5239j().mo5240k().mo5223b(DiskCacheStrategy.ALL).mo5224b(new RequestListener<String, GlideDrawable>() { // from class: com.jibo.ui.activity.PhotoViewerActivity.PhotoFragment.1
                @Override // com.bumptech.glide.request.RequestListener
                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public boolean mo5532a(Exception exc, String str, Target<GlideDrawable> target, boolean z) {
                    if (!PhotoFragment.this.isDetached() && !PhotoFragment.this.isRemoving() && PhotoFragment.this.progress != null) {
                        PhotoFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.jibo.ui.activity.PhotoViewerActivity.PhotoFragment.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PhotoViewerActivity.f9828f.put(i, false);
                                PhotoFragment.this.getActivity().invalidateOptionsMenu();
                                PhotoFragment.this.progress.setVisibility(8);
                                PhotoFragment.this.image.setImageBitmap(null);
                            }
                        });
                        return false;
                    }
                    return false;
                }

                @Override // com.bumptech.glide.request.RequestListener
                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public boolean mo5533a(GlideDrawable glideDrawable, String str, Target<GlideDrawable> target, boolean z, boolean z2) {
                    if (!PhotoFragment.this.isDetached() && !PhotoFragment.this.isRemoving() && PhotoFragment.this.progress != null) {
                        PhotoFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.jibo.ui.activity.PhotoViewerActivity.PhotoFragment.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                PhotoViewerActivity.f9828f.put(i, true);
                                PhotoFragment.this.getActivity().invalidateOptionsMenu();
                                PhotoFragment.this.progress.setVisibility(8);
                                PhotoFragment.this.image.setEnabled(true);
                            }
                        });
                        return false;
                    }
                    return false;
                }
            }).mo5216a(this.image);
            this.image.setOnClickListener(new View.OnClickListener() { // from class: com.jibo.ui.activity.PhotoViewerActivity.PhotoFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoFragment.this.getResources().getConfiguration().orientation == 1) {
                        ((PhotoViewerActivity) PhotoFragment.this.getActivity()).m10258f();
                    }
                }
            });
            this.image.setOnTouchListener(new View.OnTouchListener() { // from class: com.jibo.ui.activity.PhotoViewerActivity.PhotoFragment.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (PhotoFragment.this.getResources().getConfiguration().orientation == 2 && motionEvent.getActionMasked() == 0) {
                        ((PhotoViewerActivity) PhotoFragment.this.getActivity()).m10260g();
                        return false;
                    }
                    return false;
                }
            });
            return viewInflate;
        }

        @OnClick
        public void onContentClick(View view) {
            this.image.performClick();
        }

        @Override // android.support.v4.app.Fragment
        public void onDestroyView() {
            super.onDestroyView();
            this.f9849b.unbind();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10265a() {
        this.viewNetworkDown.setVisibility(!this.f9840n ? 0 : 8);
        if (getResources().getConfiguration().orientation == 2) {
            this.toolbar.setVisibility(8);
            this.footer.setVisibility(8);
            m10260g();
            return;
        }
        this.toolbar.setVisibility(0);
        this.footer.setVisibility(0);
        if (this.f9831d) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.toolbar.getLayoutParams();
            layoutParams.setMargins(0, this.f9830c, 0, 0);
            this.toolbar.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.footer.getLayoutParams();
            layoutParams2.setMargins(0, 0, 0, this.f9832e);
            this.footer.setLayoutParams(layoutParams2);
            return;
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.toolbar.getLayoutParams();
        layoutParams3.setMargins(0, this.f9830c, 0, 0);
        this.toolbar.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.footer.getLayoutParams();
        layoutParams4.setMargins(0, 0, 0, 0);
        this.footer.setLayoutParams(layoutParams4);
    }

    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        public ZoomOutPageTransformer() {
        }

        @Override // android.support.v4.view.ViewPager.PageTransformer
        /* JADX INFO: renamed from: a */
        public void mo2732a(View view, float f) {
            int width = view.getWidth();
            int height = view.getHeight();
            if (f < -1.0f) {
                view.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
                return;
            }
            if (f <= 1.0f) {
                float fMax = Math.max(0.95f, 1.0f - Math.abs(f));
                float f2 = (height * (1.0f - fMax)) / 2.0f;
                float f3 = (width * (1.0f - fMax)) / 2.0f;
                if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
                    view.setTranslationX(f3 - (f2 / 2.0f));
                } else {
                    view.setTranslationX((-f3) + (f2 / 2.0f));
                }
                view.setScaleX(fMax);
                view.setScaleY(fMax);
                view.setAlpha((((fMax - 0.95f) / 0.050000012f) * 0.050000012f) + 0.95f);
                return;
            }
            view.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
        }
    }
}

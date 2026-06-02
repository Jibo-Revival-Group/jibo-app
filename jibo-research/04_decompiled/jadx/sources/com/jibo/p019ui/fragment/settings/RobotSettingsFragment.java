package com.jibo.p019ui.fragment.settings;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.key.model.Backup;
import com.jibo.aws.integration.aws.services.key.model.RestoreRequest;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.UpdateRequest;
import com.jibo.aws.integration.aws.services.notification.JiboNotificationAsyncClient;
import com.jibo.aws.integration.aws.services.notification.model.GetStatusRequest;
import com.jibo.aws.integration.aws.services.notification.model.StatusContainer;
import com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient;
import com.jibo.aws.integration.aws.services.robotProperties.model.CreateRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.activity.WifiActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.fragment.dialog.ChangeLoopNameDialog;
import com.jibo.p019ui.fragment.dialog.CircleProgressFragment;
import com.jibo.p019ui.fragment.dialog.passphrase.LoopPassphraseUtils;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.SharedPreferencesUtil;

/* JADX INFO: loaded from: classes.dex */
public class RobotSettingsFragment extends BaseFragment implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a */
    public static final String f11073a = RobotSettingsFragment.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    private JiboRobotPropertiesAsyncClient f11074b;

    @BindView
    View btnAbout;

    @BindView
    View btnPassphrase;

    /* JADX INFO: renamed from: c */
    private JiboNotificationAsyncClient f11075c;

    /* JADX INFO: renamed from: d */
    private Robot f11076d;

    /* JADX INFO: renamed from: e */
    private CircleProgressFragment f11077e;

    @BindView
    ImageView iconPassphrase;

    @BindView
    ImageView imgJiboAvatar;

    /* JADX INFO: renamed from: l */
    private String f11078l;

    /* JADX INFO: renamed from: m */
    private String f11079m;

    @BindView
    Switch mRemoteSwitch;

    /* JADX INFO: renamed from: n */
    private View.OnClickListener f11080n = new View.OnClickListener() { // from class: com.jibo.ui.fragment.settings.RobotSettingsFragment.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoopPassphraseUtils.m10581a(RobotSettingsFragment.this, LoopPassphraseUtils.DialogType.FROM_SETTINGS);
        }
    };

    /* JADX INFO: renamed from: o */
    private View.OnClickListener f11081o = new View.OnClickListener() { // from class: com.jibo.ui.fragment.settings.RobotSettingsFragment.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoopPassphraseUtils.m10582a(RobotSettingsFragment.this, LoopPassphraseUtils.DialogType.RESTORE, RobotSettingsFragment.this.f9934k);
        }
    };

    @BindView
    TextView passphraseText;

    @BindView
    TextView txtJiboLocation;

    @BindView
    TextView txtJiboName;

    @BindView
    TextView txtJiboWifi;

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f11076d = (Robot) bundle.getParcelable(Robot.class.getSimpleName());
        } else if (getArguments() != null) {
            this.f11076d = (Robot) getArguments().getParcelable(Robot.class.getSimpleName());
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_robot_settings, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.f9934k == null) {
            this.f9934k = SharedPreferencesUtil.m11443f(getActivity());
        }
        Account accountM10134i = EntityData.m10089a(getActivity()).m10134i();
        if (accountM10134i != null && LoopHelper.isOwner(this.f9934k, accountM10134i.getId())) {
            this.f11074b = EntityData.m10089a(getActivity()).m10132g();
            JiboNotificationAsyncClient jiboNotificationAsyncClient = new JiboNotificationAsyncClient(new BasicAWSCredentials(accountM10134i.getAccessKeyId(), accountM10134i.getSecretAccessKey()));
            this.f11075c = jiboNotificationAsyncClient;
            m10336a(jiboNotificationAsyncClient);
        }
        m11051a();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f9934k == null) {
            m10341c().postDelayed(new Runnable() { // from class: com.jibo.ui.fragment.settings.RobotSettingsFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    RobotSettingsFragment.this.getActivity().onBackPressed();
                }
            }, 100L);
            return;
        }
        this.txtJiboName.setText(this.f9934k.getName());
        if (this.f11076d != null) {
            this.imgJiboAvatar.setImageLevel(RobotHelper.getAvatar(this.f11076d));
        }
        m11058b();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(Robot.class.getSimpleName(), this.f11076d);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_robot_settings);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, com.jibo.ui.fragment.dialog.DialogUtils.DialogFragmentWrapperClickListener
    /* JADX INFO: renamed from: a */
    public void mo10186a(int i, int i2, Object obj) {
        super.mo10186a(i, i2, obj);
        if (i == 111 && i2 == R.id.set_action) {
            this.f9934k.setName((String) obj);
            this.txtJiboName.setText(this.f9934k.getName());
            m11071r();
        }
    }

    @OnClick
    public void showAbout(View view) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Loop.class.getSimpleName(), this.f9934k);
        bundle.putParcelable(Robot.class.getSimpleName(), this.f11076d);
        ((BaseActivity) getActivity()).m10187a(RobotAboutFragment.class, bundle);
    }

    @OnClick
    public void changeName(View view) {
        ChangeLoopNameDialog changeLoopNameDialog = new ChangeLoopNameDialog();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Loop.class.getSimpleName(), this.f9934k);
        changeLoopNameDialog.setTargetFragment(this, 111);
        changeLoopNameDialog.setArguments(bundle);
        changeLoopNameDialog.show(getActivity().getSupportFragmentManager(), ChangeLoopNameDialog.class.getSimpleName());
    }

    @OnClick
    public void btnJiboAvatarClick() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Loop.class.getSimpleName(), this.f9934k);
        bundle.putParcelable(Robot.class.getSimpleName(), this.f11076d);
        ((BaseActivity) getActivity()).m10187a(AvatarSelectionFragment.class, bundle);
        ((SingleFragmentActivity) getActivity()).m10268q().setAction(AvatarSelectionFragment.class.getSimpleName());
    }

    @OnClick
    public void btnWiFiSettingsClick() {
        WifiActivity.m10315a(getActivity(), this.f9934k);
    }

    @OnClick
    public void btnLocationClick() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Loop.class.getSimpleName(), this.f9934k);
        bundle.putString("ARGS_LOCATION", this.f11078l);
        bundle.putString(RobotHelper.FIELD_TIMEZONE, this.f11079m);
        ((BaseActivity) getActivity()).m10187a(LocationFragment.class, bundle);
    }

    @OnClick
    public void btnEnableRemoteClick() {
        this.mRemoteSwitch.toggle();
    }

    @OnClick
    public void btnHolidaysClick() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Loop.class.getSimpleName(), this.f9934k);
        ((BaseActivity) getActivity()).m10187a(HolidaySettingsFragment.class, bundle);
    }

    /* JADX INFO: renamed from: a */
    private void m11051a() {
        KeyManager.SymmetricKeyHolder symmetricKeyHolderObtainKeyHolder;
        try {
            symmetricKeyHolderObtainKeyHolder = KeyManager.getInstance(getContext(), EntityData.m10089a(getActivity()).m10134i().getId()).obtainKeyHolder(getContext(), this.f9934k.getId());
        } catch (Exception e) {
            symmetricKeyHolderObtainKeyHolder = null;
        }
        final boolean z = symmetricKeyHolderObtainKeyHolder != null;
        EntityData.m10089a(getContext()).m10126d().restoreEncryptedKey(this.f9934k.getId(), null, new AsyncHandler<RestoreRequest, Backup>() { // from class: com.jibo.ui.fragment.settings.RobotSettingsFragment.2
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                RobotSettingsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.settings.RobotSettingsFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RobotSettingsFragment.this.btnPassphrase.setVisibility(0);
                        if (z) {
                            RobotSettingsFragment.this.passphraseText.setText(R.string.content_passphrase);
                            RobotSettingsFragment.this.iconPassphrase.setImageResource(R.drawable.ic_no_passphrase);
                            RobotSettingsFragment.this.btnPassphrase.setOnClickListener(RobotSettingsFragment.this.f11080n);
                        } else {
                            RobotSettingsFragment.this.passphraseText.setText(R.string.restore_content_disabled);
                            RobotSettingsFragment.this.iconPassphrase.setImageResource(R.drawable.restore_disabled);
                            RobotSettingsFragment.this.btnPassphrase.setOnClickListener(null);
                            RobotSettingsFragment.this.passphraseText.setTextColor(RobotSettingsFragment.this.getResources().getColor(R.color.steel));
                        }
                    }
                });
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(RestoreRequest restoreRequest, Backup backup) {
                RobotSettingsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.settings.RobotSettingsFragment.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        RobotSettingsFragment.this.btnPassphrase.setVisibility(0);
                        if (z) {
                            RobotSettingsFragment.this.passphraseText.setText(R.string.reset_passphrase);
                            RobotSettingsFragment.this.iconPassphrase.setImageResource(R.drawable.ic_restore_content);
                            RobotSettingsFragment.this.btnPassphrase.setOnClickListener(RobotSettingsFragment.this.f11080n);
                        } else {
                            RobotSettingsFragment.this.passphraseText.setText(R.string.restore_content);
                            RobotSettingsFragment.this.iconPassphrase.setImageResource(R.drawable.ic_restore_content);
                            RobotSettingsFragment.this.btnPassphrase.setOnClickListener(RobotSettingsFragment.this.f11081o);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: renamed from: b */
    private void m11058b() {
        try {
            m10344f();
            if (this.f9934k != null && this.f11074b != null && this.f11075c != null) {
                this.f11075c.getStatus(this.f9934k.getRobot(), new AsyncHandler<GetStatusRequest, StatusContainer>() { // from class: com.jibo.ui.fragment.settings.RobotSettingsFragment.3
                    @Override // com.amazonaws.handlers.AsyncHandler
                    public void onError(Exception exc) {
                        RobotSettingsFragment.this.m10338a((Throwable) exc, "notification get status", false);
                        if (!ErrorHelper.m11385b((AmazonServiceException) exc) && !ErrorHelper.m11384a((AmazonServiceException) exc)) {
                            RobotSettingsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.settings.RobotSettingsFragment.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    RobotSettingsFragment.this.m10344f();
                                }
                            });
                            RobotSettingsFragment.this.m11052a((StatusContainer) null);
                        }
                    }

                    @Override // com.amazonaws.handlers.AsyncHandler
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(GetStatusRequest getStatusRequest, StatusContainer statusContainer) {
                        RobotSettingsFragment.this.m11052a(statusContainer);
                    }
                });
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q */
    public void m11070q() {
        if (this.f11076d != null && this.f11076d.getPayload() != null && this.f11076d.getPayload().m9406b(RobotHelper.FIELD_REMOTE_ENABLED)) {
            try {
                this.mRemoteSwitch.setChecked(this.f11076d.getPayload().m9407c(RobotHelper.FIELD_REMOTE_ENABLED).mo9389g());
            } catch (UnsupportedOperationException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m11060b(final boolean z) {
        this.f11076d.getPayload().m9400a(RobotHelper.FIELD_REMOTE_ENABLED);
        this.f11076d.getPayload().m9403a(RobotHelper.FIELD_REMOTE_ENABLED, Boolean.valueOf(z));
        if (this.f11077e != null) {
            this.f11077e.m10502a();
            this.f11077e = null;
        }
        this.f11077e = new CircleProgressFragment();
        this.f11077e.m10509c(getString(z ? R.string.remote_enable_progress : R.string.remote_disable_progress));
        this.f11077e.show(getActivity().getSupportFragmentManager(), "CircleFragment");
        this.f11074b.updateRobot(this.f11076d, new AsyncHandler<CreateRobotRequest, CommandResponse>() { // from class: com.jibo.ui.fragment.settings.RobotSettingsFragment.4
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                RobotSettingsFragment.this.f11076d.getPayload().m9400a(RobotHelper.FIELD_REMOTE_ENABLED);
                RobotSettingsFragment.this.f11076d.getPayload().m9403a(RobotHelper.FIELD_REMOTE_ENABLED, Boolean.valueOf(!z));
                RobotSettingsFragment.this.f11077e.m10507b(RobotSettingsFragment.this.getString(R.string.remote_toggle_failure));
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(CreateRobotRequest createRobotRequest, CommandResponse commandResponse) {
                RobotSettingsFragment.this.f11077e.m10505a(RobotSettingsFragment.this.getString(z ? R.string.remote_enable_success : R.string.remote_disable_success));
            }
        });
    }

    /* JADX INFO: renamed from: com.jibo.ui.fragment.settings.RobotSettingsFragment$5 */
    class C13385 implements AsyncHandler<GetRobotRequest, Robot> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ StatusContainer f11091a;

        C13385(StatusContainer statusContainer) {
            this.f11091a = statusContainer;
        }

        @Override // com.amazonaws.handlers.AsyncHandler
        public void onError(Exception exc) {
            RobotSettingsFragment.this.m10338a((Throwable) exc, "get robot", false);
            if (!ErrorHelper.m11385b((AmazonServiceException) exc) && !ErrorHelper.m11384a((AmazonServiceException) exc)) {
                RobotSettingsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.settings.RobotSettingsFragment.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RobotSettingsFragment.this.txtJiboWifi.setText(R.string.jibo_status_no_connection);
                        RobotSettingsFragment.this.txtJiboWifi.setTextColor(ImageUtils.m11399b(RobotSettingsFragment.this.getActivity(), R.color.firecracker));
                        RobotSettingsFragment.this.txtJiboLocation.setText(R.string.text_location_not_set);
                    }
                });
            }
        }

        @Override // com.amazonaws.handlers.AsyncHandler
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(GetRobotRequest getRobotRequest, Robot robot) {
            RobotSettingsFragment.this.f11076d = robot;
            RobotSettingsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.settings.RobotSettingsFragment.5.2
                @Override // java.lang.Runnable
                public void run() {
                    String string;
                    String string2;
                    RobotSettingsFragment.this.mo10345g();
                    RobotSettingsFragment.this.f11078l = RobotHelper.getLocation(RobotSettingsFragment.this.f11076d);
                    RobotSettingsFragment.this.f11079m = RobotHelper.getTimeZone(RobotSettingsFragment.this.f11076d);
                    RobotSettingsFragment.this.imgJiboAvatar.setImageLevel(RobotHelper.getAvatar(RobotSettingsFragment.this.f11076d));
                    TextView textView = RobotSettingsFragment.this.txtJiboWifi;
                    if (C13385.this.f11091a != null && C13385.this.f11091a.getConnected().booleanValue()) {
                        string = RobotHelper.getWifiName(RobotSettingsFragment.this.f11076d);
                    } else {
                        string = RobotSettingsFragment.this.getString(R.string.jibo_status_no_connection);
                    }
                    textView.setText(string);
                    RobotSettingsFragment.this.txtJiboWifi.setTextColor(ImageUtils.m11399b(RobotSettingsFragment.this.getActivity(), (C13385.this.f11091a == null || !C13385.this.f11091a.getConnected().booleanValue()) ? R.color.firecracker : R.color.steel));
                    TextView textView2 = RobotSettingsFragment.this.txtJiboLocation;
                    if (!TextUtils.isEmpty(RobotSettingsFragment.this.f11078l) && !TextUtils.isEmpty(RobotSettingsFragment.this.f11079m)) {
                        string2 = RobotSettingsFragment.this.f11078l;
                    } else {
                        string2 = RobotSettingsFragment.this.getString(R.string.text_location_not_set);
                    }
                    textView2.setText(string2);
                    RobotSettingsFragment.this.m11070q();
                    RobotSettingsFragment.this.mRemoteSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.jibo.ui.fragment.settings.RobotSettingsFragment.5.2.1
                        @Override // android.widget.CompoundButton.OnCheckedChangeListener
                        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            RobotSettingsFragment.this.m11060b(z);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m11052a(StatusContainer statusContainer) {
        this.f11074b.getRobot(this.f9934k.getRobotFriendlyId(), new C13385(statusContainer));
    }

    /* JADX INFO: renamed from: r */
    private void m11071r() {
        m11072s();
        EntityData.m10089a(getActivity()).m10122b().updateLoop(this.f9934k.getId(), this.f9934k.getName(), new AsyncHandler<UpdateRequest, CommandResponse>() { // from class: com.jibo.ui.fragment.settings.RobotSettingsFragment.6
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                RobotSettingsFragment.this.f11077e.m10507b(RobotSettingsFragment.this.getString(R.string.message_status_saving_failed));
                RobotSettingsFragment.this.m10338a((Throwable) exc, "update loop", false);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(UpdateRequest updateRequest, CommandResponse commandResponse) {
                RobotSettingsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.settings.RobotSettingsFragment.6.1
                    @Override // java.lang.Runnable
                    public void run() throws Throwable {
                        EntityData.m10089a(RobotSettingsFragment.this.getActivity()).m10118a(RobotSettingsFragment.this.f9934k, false);
                        RobotSettingsFragment.this.f11077e.m10505a(RobotSettingsFragment.this.getString(R.string.message_status_saving_ok));
                        RobotSettingsFragment.this.txtJiboName.setText(RobotSettingsFragment.this.f9934k.getName());
                    }
                });
            }
        });
    }

    /* JADX INFO: renamed from: s */
    private void m11072s() {
        mo10345g();
        this.f11077e = new CircleProgressFragment();
        this.f11077e.m10509c(getString(R.string.message_status_saving));
        this.f11077e.show(getActivity().getSupportFragmentManager(), "CircleFragment");
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        m11051a();
    }
}

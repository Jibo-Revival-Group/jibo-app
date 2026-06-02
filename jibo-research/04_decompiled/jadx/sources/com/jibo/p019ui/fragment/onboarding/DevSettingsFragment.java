package com.jibo.p019ui.fragment.onboarding;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnLongClick;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.crashlytics.android.Crashlytics;
import com.jibo.JiboApplication;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.gqa.JiboGQAAsyncClient;
import com.jibo.aws.integration.aws.services.gqa.model.AttributionListResponse;
import com.jibo.aws.integration.aws.services.gqa.model.GQAAttribution;
import com.jibo.aws.integration.aws.services.gqa.model.QuestionRequest;
import com.jibo.aws.integration.aws.services.loop.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.RobotAccount;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.Commons;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.OnBoardingActivity;
import com.jibo.p019ui.activity.TabbedActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.service.KeyRequestingSharingService;
import com.jibo.utils.LogUtils;
import com.jibo.utils.ServiceUtils;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DevSettingsFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f10676a = DevSettingsFragment.class.getSimpleName();

    @BindView
    Button buttonSetEndpoint;

    /* JADX INFO: renamed from: c */
    private GestureDetectorCompat f10678c;

    @BindView
    TextView current_endpoint;

    @BindView
    EditText endpointEdit;

    @BindView
    Spinner endpointSpinner;

    @BindView
    Spinner gqaLoopsSpinner;

    @BindView
    Spinner loops1Spinner;

    @BindView
    Spinner loopsSpinner;

    @BindView
    EditText questionEdit;

    @BindView
    TextView responseText;

    @BindView
    Spinner suspensionLoopSpinner;

    @BindView
    Switch switchEncryption;

    @BindView
    TextView textVersion;

    @BindView
    TextView ugcKeyText;

    @BindView
    Spinner ugcLoopSpinner;

    /* JADX INFO: renamed from: b */
    private int f10677b = 0;

    /* JADX INFO: renamed from: d */
    private List<Loop> f10679d = new ArrayList();

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_dev_settings, viewGroup, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x017b  */
    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onViewCreated(android.view.View r11, android.os.Bundle r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jibo.p019ui.fragment.onboarding.DevSettingsFragment.onViewCreated(android.view.View, android.os.Bundle):void");
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
        return "Debug Screen";
    }

    @OnClick
    public void logout(View view) {
        if (getActivity() instanceof OnBoardingActivity) {
            ((JiboApplication) getActivity().getApplication()).mo9832b();
            ((OnBoardingActivity) getActivity()).m10243q();
        } else {
            getActivity().setResult(TabbedActivity.f9761c);
            getActivity().finish();
        }
    }

    @OnClick
    public void onBtnRequestKeyClick(View view) {
        Intent intent = new Intent(getActivity(), (Class<?>) KeyRequestingSharingService.class);
        intent.setAction("ACTION_REQUEST_KEY");
        intent.putExtra("loopId", this.f10679d.get(this.loopsSpinner.getSelectedItemPosition()).getId());
        ServiceUtils.m11427a(getActivity(), intent);
    }

    @OnLongClick
    public boolean showDevSettings(View view) {
        return true;
    }

    @OnClick
    public void onBtnListAttributions(View view) {
        new ListAttributionsAsyncTask().execute(new Void[0]);
    }

    @OnClick
    public void onBtnSendQuestion(View view) {
        String string = this.questionEdit.getText().toString();
        EntityData.m10089a(getContext()).m10122b().getRobot(this.f10679d.get(this.gqaLoopsSpinner.getSelectedItemPosition()).getId(), new C12315(string));
    }

    /* JADX INFO: renamed from: com.jibo.ui.fragment.onboarding.DevSettingsFragment$5 */
    class C12315 implements AsyncHandler<GetRobotRequest, RobotAccount> {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ String f10685a;

        C12315(String str) {
            this.f10685a = str;
        }

        @Override // com.amazonaws.handlers.AsyncHandler
        public void onError(final Exception exc) {
            DevSettingsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.onboarding.DevSettingsFragment.5.1
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(DevSettingsFragment.this.getContext(), exc.getMessage(), 1).show();
                }
            });
        }

        @Override // com.amazonaws.handlers.AsyncHandler
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(GetRobotRequest getRobotRequest, RobotAccount robotAccount) {
            JiboGQAAsyncClient jiboGQAAsyncClient = new JiboGQAAsyncClient(new BasicAWSCredentials(robotAccount.getAccessKeyId(), robotAccount.getSecretAccessKey()));
            jiboGQAAsyncClient.setEndpoint(Commons.DEV_ENDPOINT);
            jiboGQAAsyncClient.sendQuestion(this.f10685a, new AsyncHandler<QuestionRequest, GQAAttribution>() { // from class: com.jibo.ui.fragment.onboarding.DevSettingsFragment.5.2
                @Override // com.amazonaws.handlers.AsyncHandler
                public void onError(final Exception exc) {
                    DevSettingsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.onboarding.DevSettingsFragment.5.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(DevSettingsFragment.this.getContext(), exc.getMessage(), 1).show();
                        }
                    });
                }

                @Override // com.amazonaws.handlers.AsyncHandler
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(QuestionRequest questionRequest, final GQAAttribution gQAAttribution) {
                    DevSettingsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.onboarding.DevSettingsFragment.5.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DevSettingsFragment.this.responseText.setText(gQAAttribution.toString());
                            DevSettingsFragment.this.responseText.startAnimation(AnimationUtils.loadAnimation(DevSettingsFragment.this.getActivity(), R.anim.blink));
                        }
                    });
                }
            });
        }
    }

    @OnClick
    public void onBtnGenerateKeyClick(View view) {
        try {
            KeyManager.getInstance(getActivity(), EntityData.m10089a(getActivity()).m10134i().getId()).generateSymmetricKey(getActivity(), this.f10679d.get(this.loops1Spinner.getSelectedItemPosition()).getId(), true);
        } catch (Exception e) {
            LogUtils.m11410b(f10676a, "Could not generate key", e);
            Crashlytics.m5597a((Throwable) e);
        }
    }

    @OnClick
    public void setEndpoint(View view) {
        String string = this.endpointEdit.getText().toString();
        if (TextUtils.isEmpty(string)) {
            Toast.makeText(getContext(), "Endpoint must not be empty", 1).show();
            return;
        }
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(getString(R.string.app_name), 0);
        Commons.setRootEndpoint(string);
        sharedPreferences.edit().putString("PREF_END_POINT", string).apply();
        logout(null);
    }

    @OnClick
    public void onBtnSuspendLoopClick(View view) {
        LoopHelper.suspendLoop(this.f10679d.get(this.suspensionLoopSpinner.getSelectedItemPosition()).getId(), new Commons.AsyncCallback<Object>() { // from class: com.jibo.ui.fragment.onboarding.DevSettingsFragment.6
            @Override // com.jibo.aws.integration.util.Commons.AsyncCallback
            public void onError(final Exception exc) {
                DevSettingsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.onboarding.DevSettingsFragment.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(DevSettingsFragment.this.getContext(), exc.getMessage(), 1).show();
                    }
                });
            }

            @Override // com.jibo.aws.integration.util.Commons.AsyncCallback
            public void onSuccess(Object obj) {
                Toast.makeText(DevSettingsFragment.this.getContext(), "Loop has been suspended", 1).show();
            }
        });
    }

    public class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a */
        int f10699a = -14000;

        /* JADX INFO: renamed from: b */
        float f10700b = CropImageView.DEFAULT_ASPECT_RATIO;

        /* JADX INFO: renamed from: c */
        int f10701c = 0;

        public MyGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.f10700b += f2;
            this.f10701c++;
            if (motionEvent != null && motionEvent2 != null && f2 <= this.f10699a) {
                DevSettingsFragment.this.showDevSettings(null);
                return true;
            }
            return true;
        }
    }

    private class ListAttributionsAsyncTask extends AsyncTask<Void, Void, AttributionListResponse> {

        /* JADX INFO: renamed from: a */
        Loop f10697a;

        private ListAttributionsAsyncTask() {
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            this.f10697a = (Loop) DevSettingsFragment.this.f10679d.get(DevSettingsFragment.this.gqaLoopsSpinner.getSelectedItemPosition());
            super.onPreExecute();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AttributionListResponse doInBackground(Void... voidArr) {
            return EntityData.m10089a(DevSettingsFragment.this.getContext()).m10124c().listAttributions(this.f10697a.getRobotFriendlyId(), 0L);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(AttributionListResponse attributionListResponse) {
            super.onPostExecute(attributionListResponse);
            DevSettingsFragment.this.responseText.setText(attributionListResponse.toString());
            DevSettingsFragment.this.responseText.startAnimation(AnimationUtils.loadAnimation(DevSettingsFragment.this.getActivity(), R.anim.blink));
        }
    }
}

package com.jibo.p019ui.fragment.account.skills;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import butterknife.BindView;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.google.gson.Gson;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.skills.JiboSkillsAsyncClient;
import com.jibo.aws.integration.aws.services.skills.model.UpdateSettingsRequest;
import com.jibo.aws.integration.util.Commons;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.OnBoardingActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.fragment.account.skills.SkillSettingsFragment;
import com.jibo.p019ui.helpers.skills.DataItems;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;
import com.jibo.utils.SharedPreferencesUtil;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class OauthFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    private DataItems.ConnectableDataItem f10058a;

    /* JADX INFO: renamed from: b */
    private DataItems.ConnectableDataValue f10059b;

    /* JADX INFO: renamed from: c */
    private DataItems.OauthDataItem f10060c;

    /* JADX INFO: renamed from: d */
    private JiboSkillsAsyncClient f10061d;

    /* JADX INFO: renamed from: e */
    private Type f10062e = null;

    /* JADX INFO: renamed from: l */
    private boolean f10063l = false;

    /* JADX INFO: renamed from: m */
    private SkillSettingsFragment.DataPublisher f10064m = new C10691();

    @BindView
    WebView webview;

    private enum Type {
        Google,
        Other
    }

    /* JADX INFO: renamed from: com.jibo.ui.fragment.account.skills.OauthFragment$1 */
    class C10691 implements SkillSettingsFragment.DataPublisher {
        C10691() {
        }

        @Override // com.jibo.ui.fragment.account.skills.SkillSettingsFragment.DataPublisher
        /* JADX INFO: renamed from: a */
        public void mo10406a(final DataItems.DataItem dataItem, DataItems.DataValue dataValue, Commons.AsyncCallback<DataItems.DataValue> asyncCallback) {
            if (dataItem != null && dataValue != null) {
                OauthFragment.this.m10344f();
                OauthFragment.this.f10061d.updateSkill(SharedPreferencesUtil.m11443f(OauthFragment.this.getActivity()).getId(), new UpdateSettingsRequest.UpdateSettingData(dataItem.getValueDefinition().getKey(), new UpdateSettingsRequest.UpdateSettingData.UpdateSettingValue(SkillsJsonParser.getInstance().getCurrentSkill().getSkillId(), dataItem.getValueDefinition().getTarget(), new Gson().m9343a(dataValue))), new AsyncHandler<UpdateSettingsRequest, UpdateSettingsRequest.UpdateSettingData>() { // from class: com.jibo.ui.fragment.account.skills.OauthFragment.1.1
                    @Override // com.amazonaws.handlers.AsyncHandler
                    public void onError(Exception exc) {
                        OauthFragment.this.m10338a((Throwable) exc, "skills update skill", true);
                    }

                    @Override // com.amazonaws.handlers.AsyncHandler
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(UpdateSettingsRequest updateSettingsRequest, UpdateSettingsRequest.UpdateSettingData updateSettingData) {
                        if (updateSettingData != null && updateSettingData.value != null && updateSettingData.value.value != null && updateSettingData.value.value.m9395l().m9407c("credentialExists").mo9389g()) {
                            SkillsJsonParser.getInstance().updateData(dataItem.getValueDefinition().getKey(), updateSettingData.value.value);
                            OauthFragment.this.f10059b.setValue(true);
                            SkillsJsonParser.getInstance().updateData(OauthFragment.this.f10058a.getValueDefinition().getKey(), OauthFragment.this.f10059b);
                        }
                        SkillsJsonParser.getInstance().setItemDataValue(dataItem);
                        OauthFragment.this.mo10345g();
                        OauthFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.account.skills.OauthFragment.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Snackbar.m803a(OauthFragment.this.getView(), R.string.success, -1).m490c();
                                int iMo1481e = OauthFragment.this.getActivity().getSupportFragmentManager().mo1481e();
                                if (iMo1481e - 2 > 0) {
                                    OauthFragment.this.getActivity().getSupportFragmentManager().mo1478b(OauthFragment.this.getActivity().getSupportFragmentManager().mo1476b(iMo1481e - 2).mo1359a(), 1);
                                } else {
                                    OauthFragment.this.getActivity().onBackPressed();
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f10062e == Type.Google ? new View(getActivity()) : layoutInflater.inflate(R.layout.fragment_webview, (ViewGroup) null);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String str;
        super.onViewCreated(view, bundle);
        if (SkillsJsonParser.isCreated()) {
            if (this.f10062e == Type.Google) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.m3231b(R.string.open_in_app_prompt);
                builder.m3221a(R.string.okay, (DialogInterface.OnClickListener) null);
                builder.m3222a(new DialogInterface.OnDismissListener() { // from class: com.jibo.ui.fragment.account.skills.OauthFragment.2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        OauthFragment.this.m10398a();
                    }
                });
                builder.m3236b().show();
            } else {
                this.webview = (WebView) view.findViewById(R.id.webview);
                this.webview.getSettings().setJavaScriptEnabled(true);
                this.webview.setWebViewClient(new SignInViewClient(this));
                if (this.f10060c.getOauthParams().getScopes()[0] == null || this.f10060c.getOauthParams().getAuthorizationUri() == null || this.f10060c.getOauthParams().getIosClientId() == null || this.f10060c.getOauthParams().getIosCallbackUri() == null || this.f10060c.getValueDefinition() == null || this.f10060c.getValueDefinition().getKey() == null) {
                    str = null;
                } else {
                    String str2 = this.f10060c.getOauthParams().getAuthorizationUri() + "?client_id=" + this.f10060c.getOauthParams().getIosClientId() + "&redirect_uri=" + this.f10060c.getOauthParams().getIosCallbackUri() + "&response_type=code&scope=";
                    for (int i = 0; i < this.f10060c.getOauthParams().getScopes().length; i++) {
                        str2 = str2 + this.f10060c.getOauthParams().getScopes()[i] + "%20";
                    }
                    str = str2.substring(0, str2.length() - 3) + "&response_mode=query";
                }
                this.webview.loadUrl(str);
            }
            Account accountM10134i = EntityData.m10089a(getActivity()).m10134i();
            if (accountM10134i != null) {
                JiboSkillsAsyncClient jiboSkillsAsyncClient = new JiboSkillsAsyncClient(new BasicAWSCredentials(accountM10134i.getAccessKeyId(), accountM10134i.getSecretAccessKey()));
                this.f10061d = jiboSkillsAsyncClient;
                m10336a(jiboSkillsAsyncClient);
            }
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        if (this.f10062e != Type.Google) {
            super.mo10334a(actionBar);
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return this.f10060c == null ? "" : this.f10060c.getTitle();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f10060c == null) {
            getView().postDelayed(new Runnable() { // from class: com.jibo.ui.fragment.account.skills.OauthFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    OauthFragment.this.getActivity().onBackPressed();
                }
            }, 50L);
        }
        if (OnBoardingActivity.f9824n != null) {
            this.f10063l = false;
            String str = OnBoardingActivity.f9824n;
            OnBoardingActivity.f9824n = null;
            if (str.contains("https://www.jibo.com/google-oauth-callback")) {
                this.f10064m.mo10406a(this.f10060c, new DataItems.OauthDataValue.OauthValue(this.f10060c.getOauthParams().getServiceAccountName(), this.f10060c.getOauthParams().getServiceName(), Uri.parse(str).getQueryParameter("code"), this.f10060c.getOauthParams().getServerClientId(), this.f10060c.getOauthParams().getScopes()), null);
                return;
            }
            return;
        }
        if (this.f10063l) {
            this.f10063l = false;
            getView().postDelayed(new Runnable() { // from class: com.jibo.ui.fragment.account.skills.OauthFragment.4
                @Override // java.lang.Runnable
                public void run() {
                    OauthFragment.this.getActivity().onBackPressed();
                }
            }, 50L);
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(DataItems.ConnectableDataItem.class.getSimpleName(), new Gson().m9362b(this.f10058a));
        bundle.putString(DataItems.OauthDataItem.class.getSimpleName(), new Gson().m9362b(this.f10060c));
        bundle.putBoolean("ARGS_SKILL_FRAGMENT", true);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        if (SkillsJsonParser.isCreated()) {
            this.f10058a = (DataItems.ConnectableDataItem) new Gson().m9355a(bundle.getString(DataItems.ConnectableDataItem.class.getSimpleName()), DataItems.ConnectableDataItem.class);
            SkillsJsonParser.getInstance().setItemDataValue(this.f10058a);
            this.f10059b = (DataItems.ConnectableDataValue) this.f10058a.getDataValue();
            this.f10060c = (DataItems.OauthDataItem) new Gson().m9355a(bundle.getString(DataItems.OauthDataItem.class.getSimpleName()), DataItems.OauthDataItem.class);
            SkillsJsonParser.getInstance().setItemDataValue(this.f10060c);
            if (this.f10060c.getValueDefinition().getKey().contains("google")) {
                this.f10062e = Type.Google;
            } else {
                this.f10062e = Type.Other;
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m10398a() {
        this.f10063l = true;
        startActivity(new Intent("android.intent.action.VIEW", m10400b()));
    }

    /* JADX INFO: renamed from: b */
    private Uri m10400b() {
        String str = "";
        if (this.f10060c.getOauthParams().getScopes()[0] != null && this.f10060c.getOauthParams().getAuthorizationUri() != null && this.f10060c.getOauthParams().getIosClientId() != null && this.f10060c.getOauthParams().getIosCallbackUri() != null && this.f10060c.getValueDefinition() != null && this.f10060c.getValueDefinition().getKey() != null) {
            String str2 = this.f10060c.getOauthParams().getAuthorizationUri() + "?client_id=" + this.f10060c.getOauthParams().getServerClientId() + "&redirect_uri=https://www.jibo.com/google-oauth-callback&response_type=code&scope=";
            for (int i = 0; i < this.f10060c.getOauthParams().getScopes().length; i++) {
                str2 = str2 + this.f10060c.getOauthParams().getScopes()[i] + " ";
            }
            str = str2.substring(0, str2.length() - 1) + "&response_mode=query&prompt=select_account consent&access_type=offline";
        }
        return Uri.parse(str);
    }

    private class SignInViewClient extends WebViewClient {

        /* JADX INFO: renamed from: b */
        private final WeakReference<OauthFragment> f10073b;

        public SignInViewClient(OauthFragment oauthFragment) {
            this.f10073b = new WeakReference<>(oauthFragment);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri uri = Uri.parse(str);
            OauthFragment oauthFragment = this.f10073b.get();
            if (oauthFragment == null || !oauthFragment.m10342d()) {
                return true;
            }
            if (str.contains(OauthFragment.this.f10060c.getOauthParams().getIosCallbackUri())) {
                OauthFragment.this.f10064m.mo10406a(OauthFragment.this.f10060c, new DataItems.OauthDataValue.OauthValue(OauthFragment.this.f10060c.getOauthParams().getServiceAccountName(), OauthFragment.this.f10060c.getOauthParams().getServiceName(), uri.getQueryParameter("code"), OauthFragment.this.f10060c.getOauthParams().getIosClientId(), OauthFragment.this.f10060c.getOauthParams().getScopes()), null);
                return true;
            }
            return false;
        }
    }
}

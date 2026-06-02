package com.salesforce.androidsdk.p025ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.security.KeyChain;
import android.security.KeyChainAliasCallback;
import android.security.KeyChainException;
import android.text.TextUtils;
import android.webkit.ClientCertRequest;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.facebook.internal.NativeProtocol;
import com.salesforce.androidsdk.R;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.accounts.UserAccountManager;
import com.salesforce.androidsdk.analytics.EventBuilderHelper;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.auth.HttpAccess;
import com.salesforce.androidsdk.auth.OAuth2;
import com.salesforce.androidsdk.config.BootConfig;
import com.salesforce.androidsdk.config.LoginServerManager;
import com.salesforce.androidsdk.config.RuntimeConfig;
import com.salesforce.androidsdk.push.PushMessaging;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.security.PasscodeManager;
import com.salesforce.androidsdk.util.EventsObservable;
import com.salesforce.androidsdk.util.MapUtil;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import com.salesforce.androidsdk.util.UriFragmentParser;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class OAuthWebviewHelper implements KeyChainAliasCallback {

    /* JADX INFO: renamed from: b */
    static final /* synthetic */ boolean f14375b;

    /* JADX INFO: renamed from: a */
    protected final ClientManager.LoginOptions f14376a;

    /* JADX INFO: renamed from: c */
    private final ExecutorService f14377c = Executors.newFixedThreadPool(1);

    /* JADX INFO: renamed from: d */
    private final OAuthWebviewHelperEvents f14378d;

    /* JADX INFO: renamed from: e */
    private final WebView f14379e;

    /* JADX INFO: renamed from: f */
    private AccountOptions f14380f;

    /* JADX INFO: renamed from: g */
    private Activity f14381g;

    /* JADX INFO: renamed from: h */
    private PrivateKey f14382h;

    /* JADX INFO: renamed from: i */
    private X509Certificate[] f14383i;

    public interface OAuthWebviewHelperEvents {
        /* JADX INFO: renamed from: a */
        void mo14847a(Bundle bundle);

        /* JADX INFO: renamed from: a */
        void mo14848a(String str);

        /* JADX INFO: renamed from: a */
        void mo14849a(boolean z);

        /* JADX INFO: renamed from: b */
        void mo14852b(int i);

        void finish();
    }

    static {
        f14375b = !OAuthWebviewHelper.class.desiredAssertionStatus();
    }

    public OAuthWebviewHelper(Activity activity, OAuthWebviewHelperEvents oAuthWebviewHelperEvents, ClientManager.LoginOptions loginOptions, WebView webView, Bundle bundle) {
        if (!f14375b && (loginOptions == null || oAuthWebviewHelperEvents == null || webView == null || activity == null)) {
            throw new AssertionError();
        }
        this.f14381g = activity;
        this.f14378d = oAuthWebviewHelperEvents;
        this.f14376a = loginOptions;
        this.f14379e = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUserAgentString(SalesforceSDKManager.m14403a().m14460y());
        webView.setWebViewClient(m14873d());
        webView.setWebChromeClient(m14874e());
        if (bundle != null) {
            webView.restoreState(bundle);
            this.f14380f = AccountOptions.m14881a(bundle.getBundle("accountOptions"));
        } else {
            m14866a();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m14867a(Bundle bundle) {
        this.f14379e.saveState(bundle);
        if (this.f14380f != null) {
            bundle.putBundle("accountOptions", this.f14380f.m14883a());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m14866a() {
        SalesforceSDKManager.m14403a().m14424F();
    }

    /* JADX INFO: renamed from: b */
    public void m14871b() {
        this.f14379e.loadUrl("about:blank");
    }

    /* JADX INFO: renamed from: c */
    public void m14872c() {
        if (this.f14380f != null) {
            this.f14376a.m14584d(SalesforceSDKManager.m14403a().m14455t());
            m14880k();
            this.f14378d.finish();
        }
    }

    /* JADX INFO: renamed from: d */
    protected WebViewClient m14873d() {
        return new AuthWebViewClient();
    }

    /* JADX INFO: renamed from: e */
    protected WebChromeClient m14874e() {
        return new AuthWebChromeClient();
    }

    /* JADX INFO: renamed from: f */
    protected Context m14875f() {
        return this.f14379e.getContext();
    }

    /* JADX INFO: renamed from: a */
    protected void m14870a(String str, String str2, Exception exc) {
        SalesforceSDKLogger.m15018b("OAuthWebViewHelper", str + ": " + str2, exc);
        if ("access_denied".equals(str) && "end-user denied authorization".equals(str2)) {
            this.f14379e.post(new Runnable() { // from class: com.salesforce.androidsdk.ui.OAuthWebviewHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    OAuthWebviewHelper.this.m14866a();
                    OAuthWebviewHelper.this.m14876g();
                }
            });
        } else {
            Toast toastMakeText = Toast.makeText(this.f14379e.getContext(), str + " : " + str2, 1);
            this.f14379e.postDelayed(new Runnable() { // from class: com.salesforce.androidsdk.ui.OAuthWebviewHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    OAuthWebviewHelper.this.f14378d.finish();
                }
            }, toastMakeText.getDuration());
            toastMakeText.show();
        }
        Intent intent = new Intent("com.salesforce.auth.intent.AUTHENTICATION_ERROR");
        if (exc != null && (exc instanceof OAuth2.OAuthFailedException)) {
            OAuth2.OAuthFailedException oAuthFailedException = (OAuth2.OAuthFailedException) exc;
            intent.putExtra("com.salesforce.auth.intent.HTTP_RESPONSE_CODE", oAuthFailedException.m14492c());
            OAuth2.TokenErrorResponse tokenErrorResponseM14491b = oAuthFailedException.m14491b();
            if (tokenErrorResponseM14491b != null) {
                String str3 = tokenErrorResponseM14491b.f14171a;
                String str4 = tokenErrorResponseM14491b.f14172b;
                intent.putExtra("com.salesforce.auth.intent.RESPONSE_ERROR", str3);
                intent.putExtra("com.salesforce.auth.intent.RESPONSE_ERROR_DESCRIPTION", str4);
            }
        }
        SalesforceSDKManager.m14403a().m14446k().sendBroadcast(intent);
    }

    /* JADX INFO: renamed from: a */
    protected void m14869a(Exception exc) {
        Toast.makeText(m14875f(), m14875f().getString(SalesforceSDKManager.m14403a().m14438e().m14976d(), exc.toString()), 1).show();
    }

    /* JADX INFO: renamed from: g */
    public void m14876g() {
        if (TextUtils.isEmpty(this.f14376a.m14587g())) {
            this.f14376a.m14582c(m14879j());
            m14860a(false);
        } else {
            new SwapJWTForAccessTokenTask().execute(new ClientManager.LoginOptions[]{this.f14376a});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m14860a(boolean z) {
        try {
            URI uriM14865a = m14865a(Boolean.valueOf(z));
            this.f14378d.mo14848a(this.f14376a.m14577a());
            this.f14379e.loadUrl(uriM14865a.toString());
        } catch (URISyntaxException e) {
            m14869a(e);
        }
    }

    /* JADX INFO: renamed from: h */
    protected String m14877h() {
        return this.f14376a.m14583d();
    }

    /* JADX INFO: renamed from: a */
    protected URI m14865a(Boolean bool) throws URISyntaxException {
        if (bool.booleanValue()) {
            return OAuth2.m14484a(new URI(this.f14376a.m14577a()), m14877h(), this.f14376a.m14581c(), this.f14376a.m14585e(), null, m14878i(), this.f14376a.m14587g(), this.f14376a.m14577a(), this.f14376a.m14588h());
        }
        return OAuth2.m14485a(new URI(this.f14376a.m14577a()), m14877h(), this.f14376a.m14581c(), this.f14376a.m14585e(), null, m14878i(), this.f14376a.m14588h());
    }

    /* JADX INFO: renamed from: i */
    protected String m14878i() {
        return m14875f().getString(R.string.oauth_display_type);
    }

    /* JADX INFO: renamed from: j */
    protected String m14879j() {
        return SalesforceSDKManager.m14403a().m14447l().m14517a().f14190b.trim();
    }

    protected class AuthWebViewClient extends WebViewClient {
        protected AuthWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            EventsObservable.m15006a().m15009a(EventsObservable.EventType.AuthWebViewPageFinished, str);
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            boolean zStartsWith = str.replace("///", "/").toLowerCase(Locale.US).startsWith(OAuthWebviewHelper.this.f14376a.m14581c().replace("///", "/").toLowerCase(Locale.US));
            if (zStartsWith) {
                Map<String, String> mapM15021a = UriFragmentParser.m15021a(Uri.parse(str));
                String str2 = mapM15021a.get("error");
                if (str2 != null) {
                    OAuthWebviewHelper.this.m14870a(str2, mapM15021a.get(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION), null);
                } else {
                    OAuthWebviewHelper.this.m14868a(new OAuth2.TokenEndpointResponse(mapM15021a));
                }
            }
            return zStartsWith;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            int primaryError = sslError.getPrimaryError();
            SalesforceR salesforceRM14438e = SalesforceSDKManager.m14403a().m14438e();
            int iM14969ah = salesforceRM14438e.m14969ah();
            switch (primaryError) {
                case 0:
                    iM14969ah = salesforceRM14438e.m14967af();
                    break;
                case 1:
                    iM14969ah = salesforceRM14438e.m14965ad();
                    break;
                case 2:
                    iM14969ah = salesforceRM14438e.m14966ae();
                    break;
                case 3:
                    iM14969ah = salesforceRM14438e.m14968ag();
                    break;
            }
            Toast.makeText(OAuthWebviewHelper.this.m14875f(), OAuthWebviewHelper.this.m14875f().getString(salesforceRM14438e.m14964ac(), OAuthWebviewHelper.this.m14875f().getString(iM14969ah)), 1).show();
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(21)
        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            clientCertRequest.proceed(OAuthWebviewHelper.this.f14382h, OAuthWebviewHelper.this.f14383i);
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m14868a(OAuth2.TokenEndpointResponse tokenEndpointResponse) {
        new FinishAuthTask().execute(new OAuth2.TokenEndpointResponse[]{tokenEndpointResponse});
    }

    private class SwapJWTForAccessTokenTask extends BaseFinishAuthFlowTask<ClientManager.LoginOptions> {
        private SwapJWTForAccessTokenTask() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.androidsdk.ui.OAuthWebviewHelper.BaseFinishAuthFlowTask
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public OAuth2.TokenEndpointResponse mo14884a(ClientManager.LoginOptions loginOptions) {
            try {
                return OAuth2.m14489b(HttpAccess.f14141a, new URI(loginOptions.m14577a()), loginOptions.m14587g());
            } catch (Exception e) {
                this.f14408a = e;
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.androidsdk.ui.OAuthWebviewHelper.BaseFinishAuthFlowTask, android.os.AsyncTask
        /* JADX INFO: renamed from: a */
        public void onPostExecute(OAuth2.TokenEndpointResponse tokenEndpointResponse) {
            if (this.f14408a != null) {
                m14890a();
                OAuthWebviewHelper.this.f14376a.m14578a((String) null);
                return;
            }
            if (tokenEndpointResponse == null || tokenEndpointResponse.f14160a == null) {
                OAuthWebviewHelper.this.m14860a(false);
                m14890a();
            } else {
                OAuthWebviewHelper.this.f14376a.m14578a(tokenEndpointResponse.f14160a);
                OAuthWebviewHelper.this.m14860a(true);
            }
            OAuthWebviewHelper.this.f14376a.m14578a((String) null);
        }

        /* JADX INFO: renamed from: a */
        private void m14890a() {
            SalesforceSDKManager salesforceSDKManagerM14403a = SalesforceSDKManager.m14403a();
            OAuthWebviewHelper.this.m14870a(OAuthWebviewHelper.this.m14875f().getString(salesforceSDKManagerM14403a.m14438e().m14977e()), OAuthWebviewHelper.this.m14875f().getString(salesforceSDKManagerM14403a.m14438e().m14979g()), this.f14408a);
        }
    }

    protected abstract class BaseFinishAuthFlowTask<RequestType> extends AsyncTask<RequestType, Boolean, OAuth2.TokenEndpointResponse> {

        /* JADX INFO: renamed from: a */
        protected volatile Exception f14408a;

        /* JADX INFO: renamed from: b */
        protected volatile OAuth2.IdServiceResponse f14409b = null;

        /* JADX INFO: renamed from: a */
        protected abstract OAuth2.TokenEndpointResponse mo14884a(RequestType requesttype) throws Exception;

        public BaseFinishAuthFlowTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        @SafeVarargs
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final OAuth2.TokenEndpointResponse doInBackground(RequestType... requesttypeArr) {
            try {
                publishProgress(true);
                return mo14884a(requesttypeArr[0]);
            } catch (Exception e) {
                m14887a(e);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(OAuth2.TokenEndpointResponse tokenEndpointResponse) {
            SalesforceSDKManager salesforceSDKManagerM14403a = SalesforceSDKManager.m14403a();
            if (this.f14408a != null) {
                SalesforceSDKLogger.m15018b("OAuthWebViewHelper", "Exception thrown while retrieving token response", this.f14408a);
                OAuthWebviewHelper.this.m14870a(OAuthWebviewHelper.this.m14875f().getString(salesforceSDKManagerM14403a.m14438e().m14977e()), OAuthWebviewHelper.this.m14875f().getString(salesforceSDKManagerM14403a.m14438e().m14978f()), this.f14408a);
                OAuthWebviewHelper.this.f14378d.finish();
                return;
            }
            if (this.f14409b.f14157k != null && this.f14409b.f14157k.optBoolean("must_be_managed_app") && !RuntimeConfig.m14524a(OAuthWebviewHelper.this.m14875f()).m14530a()) {
                OAuthWebviewHelper.this.m14870a(OAuthWebviewHelper.this.m14875f().getString(salesforceSDKManagerM14403a.m14438e().m14977e()), OAuthWebviewHelper.this.m14875f().getString(salesforceSDKManagerM14403a.m14438e().m14980h()), this.f14408a);
                OAuthWebviewHelper.this.f14378d.finish();
                return;
            }
            OAuthWebviewHelper.this.f14380f = new AccountOptions(this.f14409b.f14147a, tokenEndpointResponse.f14161b, tokenEndpointResponse.f14160a, tokenEndpointResponse.f14163d, tokenEndpointResponse.f14162c, tokenEndpointResponse.f14165f, tokenEndpointResponse.f14166g, tokenEndpointResponse.f14168i, tokenEndpointResponse.f14169j, this.f14409b.f14149c, this.f14409b.f14150d, this.f14409b.f14151e, this.f14409b.f14148b, this.f14409b.f14152f, this.f14409b.f14153g, tokenEndpointResponse.f14170k);
            UserAccount userAccount = new UserAccount(OAuthWebviewHelper.this.f14380f.f14391c, OAuthWebviewHelper.this.f14380f.f14390b, OAuthWebviewHelper.this.f14376a.m14577a(), OAuthWebviewHelper.this.f14380f.f14392d, OAuthWebviewHelper.this.f14380f.f14393e, OAuthWebviewHelper.this.f14380f.f14394f, OAuthWebviewHelper.this.f14380f.f14395g, OAuthWebviewHelper.this.f14380f.f14389a, OAuthWebviewHelper.this.m14864a(OAuthWebviewHelper.this.f14380f.f14389a, OAuthWebviewHelper.this.f14380f.f14393e), OAuthWebviewHelper.this.f14376a.m14586f(), OAuthWebviewHelper.this.f14380f.f14396h, OAuthWebviewHelper.this.f14380f.f14397i, OAuthWebviewHelper.this.f14380f.f14398j, OAuthWebviewHelper.this.f14380f.f14399k, OAuthWebviewHelper.this.f14380f.f14400l, OAuthWebviewHelper.this.f14380f.f14401m, OAuthWebviewHelper.this.f14380f.f14402n, OAuthWebviewHelper.this.f14380f.f14403o, OAuthWebviewHelper.this.f14380f.f14404p);
            if (this.f14409b.f14156j != null) {
                salesforceSDKManagerM14403a.m14451p().m14499a(this.f14409b.f14156j, userAccount);
            }
            if (this.f14409b.f14157k != null) {
                salesforceSDKManagerM14403a.m14452q().m14499a(this.f14409b.f14157k, userAccount);
            }
            if (this.f14409b.f14155i > 0) {
                PasscodeManager passcodeManagerM14449n = salesforceSDKManagerM14403a.m14449n();
                passcodeManagerM14449n.m14638a(userAccount, this.f14409b.f14155i * 1000 * 60, this.f14409b.f14154h);
                passcodeManagerM14449n.m14634a(this.f14409b.f14155i * 1000 * 60);
                boolean zM14643a = passcodeManagerM14449n.m14643a((Activity) OAuthWebviewHelper.this.m14875f(), this.f14409b.f14154h);
                if (!passcodeManagerM14449n.m14649b(salesforceSDKManagerM14403a.m14446k())) {
                    passcodeManagerM14449n.m14640a(true);
                    passcodeManagerM14449n.m14642a((Activity) OAuthWebviewHelper.this.m14875f(), true);
                    return;
                } else {
                    if (!zM14643a) {
                        OAuthWebviewHelper.this.f14376a.m14584d(salesforceSDKManagerM14403a.m14455t());
                        OAuthWebviewHelper.this.m14880k();
                        OAuthWebviewHelper.this.f14378d.finish();
                        return;
                    }
                    return;
                }
            }
            salesforceSDKManagerM14403a.m14449n().m14638a(userAccount, 0, 4);
            OAuthWebviewHelper.this.f14376a.m14584d(salesforceSDKManagerM14403a.m14455t());
            OAuthWebviewHelper.this.m14880k();
            OAuthWebviewHelper.this.f14378d.finish();
        }

        /* JADX INFO: renamed from: a */
        protected void m14887a(Exception exc) {
            if (exc.getMessage() != null) {
                SalesforceSDKLogger.m15018b("OAuthWebViewHelper", "Exception thrown", exc);
            }
            this.f14408a = exc;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Boolean... boolArr) {
            OAuthWebviewHelper.this.f14378d.mo14849a(boolArr[0].booleanValue());
        }
    }

    private class FinishAuthTask extends BaseFinishAuthFlowTask<OAuth2.TokenEndpointResponse> {
        private FinishAuthTask() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.salesforce.androidsdk.ui.OAuthWebviewHelper.BaseFinishAuthFlowTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public OAuth2.TokenEndpointResponse mo14884a(OAuth2.TokenEndpointResponse tokenEndpointResponse) throws Exception {
            try {
                this.f14409b = OAuth2.m14478a(HttpAccess.f14141a, tokenEndpointResponse.f14164e, tokenEndpointResponse.f14160a);
            } catch (Exception e) {
                this.f14408a = e;
            }
            return tokenEndpointResponse;
        }
    }

    /* JADX INFO: renamed from: k */
    protected void m14880k() {
        ClientManager clientManager = new ClientManager(m14875f(), SalesforceSDKManager.m14403a().m14420B(), this.f14376a, SalesforceSDKManager.m14403a().m14445j());
        String strM14864a = m14864a(this.f14380f.f14389a, this.f14380f.f14393e);
        Bundle bundleM14558a = clientManager.m14558a(strM14864a, this.f14380f.f14389a, this.f14380f.f14390b, this.f14380f.f14391c, this.f14380f.f14393e, this.f14376a.m14577a(), this.f14380f.f14392d, m14877h(), this.f14380f.f14394f, this.f14380f.f14395g, this.f14376a.m14579b(), this.f14376a.m14586f(), this.f14380f.f14396h, this.f14380f.f14397i, this.f14380f.f14398j, this.f14380f.f14399k, this.f14380f.f14400l, this.f14380f.f14401m, this.f14380f.f14402n, this.f14380f.f14403o, this.f14380f.f14404p);
        Context contextM14446k = SalesforceSDKManager.m14403a().m14446k();
        String strM14511d = BootConfig.m14502a(contextM14446k).m14511d();
        final UserAccount userAccount = new UserAccount(this.f14380f.f14391c, this.f14380f.f14390b, this.f14376a.m14577a(), this.f14380f.f14392d, this.f14380f.f14393e, this.f14380f.f14394f, this.f14380f.f14395g, this.f14380f.f14389a, strM14864a, this.f14376a.m14586f(), this.f14380f.f14396h, this.f14380f.f14397i, this.f14380f.f14398j, this.f14380f.f14399k, this.f14380f.f14400l, this.f14380f.f14401m, this.f14380f.f14402n, this.f14380f.f14403o, this.f14380f.f14404p);
        if (!TextUtils.isEmpty(strM14511d)) {
            PushMessaging.m14534a(contextM14446k, userAccount);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            List<UserAccount> listM14277d = UserAccountManager.m14264a().m14277d();
            jSONObject.put("numUsers", listM14277d == null ? 0 : listM14277d.size());
        } catch (JSONException e) {
            SalesforceSDKLogger.m15016a("OAuthWebViewHelper", "Exception thrown while creating JSON", e);
        }
        this.f14378d.mo14847a(bundleM14558a);
        if (SalesforceSDKManager.m14403a().m14421C()) {
            m14857a(userAccount);
        } else {
            this.f14377c.execute(new Runnable() { // from class: com.salesforce.androidsdk.ui.OAuthWebviewHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    OAuthWebviewHelper.this.m14857a(userAccount);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m14857a(UserAccount userAccount) {
        JSONObject jSONObject = new JSONObject();
        try {
            List<LoginServerManager.LoginServer> listM14521c = SalesforceSDKManager.m14403a().m14447l().m14521c();
            jSONObject.put("numLoginServers", listM14521c == null ? 0 : listM14521c.size());
            if (listM14521c != null) {
                JSONArray jSONArray = new JSONArray();
                for (LoginServerManager.LoginServer loginServer : listM14521c) {
                    if (loginServer != null) {
                        jSONArray.put(loginServer.f14190b);
                    }
                }
                jSONObject.put("loginServers", jSONArray);
            }
            EventBuilderHelper.m14289b("addUser", userAccount, "OAuthWebViewHelper", jSONObject);
        } catch (JSONException e) {
            SalesforceSDKLogger.m15016a("OAuthWebViewHelper", "Exception thrown while creating JSON", e);
        }
    }

    /* JADX INFO: renamed from: a */
    protected String m14864a(String str, String str2) {
        return String.format("%s (%s) (%s)", str, str2, SalesforceSDKManager.m14403a().m14456u());
    }

    protected class AuthWebChromeClient extends WebChromeClient {
        protected AuthWebChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            OAuthWebviewHelper.this.f14378d.mo14852b(i * 100);
        }
    }

    public static class AccountOptions {

        /* JADX INFO: renamed from: a */
        public final String f14389a;

        /* JADX INFO: renamed from: b */
        public final String f14390b;

        /* JADX INFO: renamed from: c */
        public final String f14391c;

        /* JADX INFO: renamed from: d */
        public final String f14392d;

        /* JADX INFO: renamed from: e */
        public final String f14393e;

        /* JADX INFO: renamed from: f */
        public final String f14394f;

        /* JADX INFO: renamed from: g */
        public final String f14395g;

        /* JADX INFO: renamed from: h */
        public final String f14396h;

        /* JADX INFO: renamed from: i */
        public final String f14397i;

        /* JADX INFO: renamed from: j */
        public final String f14398j;

        /* JADX INFO: renamed from: k */
        public final String f14399k;

        /* JADX INFO: renamed from: l */
        public final String f14400l;

        /* JADX INFO: renamed from: m */
        public final String f14401m;

        /* JADX INFO: renamed from: n */
        public final String f14402n;

        /* JADX INFO: renamed from: o */
        public final String f14403o;

        /* JADX INFO: renamed from: p */
        public final Map<String, String> f14404p;

        /* JADX INFO: renamed from: q */
        private Bundle f14405q;

        public AccountOptions(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, Map<String, String> map) {
            this.f14389a = str;
            this.f14390b = str2;
            this.f14391c = str3;
            this.f14392d = str4;
            this.f14393e = str5;
            this.f14394f = str6;
            this.f14395g = str7;
            this.f14396h = str8;
            this.f14397i = str9;
            this.f14398j = str10;
            this.f14399k = str11;
            this.f14400l = str12;
            this.f14401m = str13;
            this.f14402n = str14;
            this.f14403o = str15;
            this.f14404p = map;
            this.f14405q = new Bundle();
            this.f14405q.putString("username", str);
            this.f14405q.putString("refreshToken", str2);
            this.f14405q.putString("authToken", str3);
            this.f14405q.putString("identityUrl", str4);
            this.f14405q.putString("instanceUrl", str5);
            this.f14405q.putString("orgId", str6);
            this.f14405q.putString("userId", str7);
            this.f14405q.putString("communityId", str8);
            this.f14405q.putString("communityUrl", str9);
            this.f14405q.putString("firstName", str10);
            this.f14405q.putString("lastName", str11);
            this.f14405q.putString("displayName", str12);
            this.f14405q.putString("email", str13);
            this.f14405q.putString("photoUrl", str14);
            this.f14405q.putString("thumbnailUrl", str15);
            this.f14405q = MapUtil.m15012a(map, SalesforceSDKManager.m14403a().m14457v(), this.f14405q);
        }

        /* JADX INFO: renamed from: a */
        public Bundle m14883a() {
            return this.f14405q;
        }

        /* JADX INFO: renamed from: a */
        public static AccountOptions m14881a(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            return new AccountOptions(bundle.getString("username"), bundle.getString("refreshToken"), bundle.getString("authToken"), bundle.getString("identityUrl"), bundle.getString("instanceUrl"), bundle.getString("orgId"), bundle.getString("userId"), bundle.getString("communityId"), bundle.getString("communityUrl"), bundle.getString("firstName"), bundle.getString("lastName"), bundle.getString("displayName"), bundle.getString("email"), bundle.getString("photoUrl"), bundle.getString("thumbnailUrl"), m14882b(bundle));
        }

        /* JADX INFO: renamed from: b */
        private static Map<String, String> m14882b(Bundle bundle) {
            return MapUtil.m15013a(bundle, SalesforceSDKManager.m14403a().m14457v(), (Map<String, String>) null);
        }
    }

    @Override // android.security.KeyChainAliasCallback
    public void alias(String str) {
        try {
            this.f14383i = KeyChain.getCertificateChain(this.f14381g, str);
            this.f14382h = KeyChain.getPrivateKey(this.f14381g, str);
            this.f14381g.runOnUiThread(new Runnable() { // from class: com.salesforce.androidsdk.ui.OAuthWebviewHelper.4
                @Override // java.lang.Runnable
                public void run() {
                    OAuthWebviewHelper.this.m14876g();
                }
            });
        } catch (KeyChainException e) {
            SalesforceSDKLogger.m15016a("OAuthWebViewHelper", "Exception thrown while retrieving X.509 certificate", e);
        } catch (InterruptedException e2) {
            SalesforceSDKLogger.m15016a("OAuthWebViewHelper", "Exception thrown while retrieving X.509 certificate", e2);
        }
    }
}

package com.salesforce.androidsdk.p025ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.accounts.UserAccountManager;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.security.PasscodeManager;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PasscodeActivity extends Activity implements View.OnClickListener, TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a */
    private final int f14413a = 11;

    /* JADX INFO: renamed from: b */
    private PasscodeMode f14414b;

    /* JADX INFO: renamed from: c */
    private TextView f14415c;

    /* JADX INFO: renamed from: d */
    private TextView f14416d;

    /* JADX INFO: renamed from: e */
    private TextView f14417e;

    /* JADX INFO: renamed from: f */
    private EditText f14418f;

    /* JADX INFO: renamed from: g */
    private PasscodeManager f14419g;

    /* JADX INFO: renamed from: h */
    private String f14420h;

    /* JADX INFO: renamed from: i */
    private SalesforceR f14421i;

    /* JADX INFO: renamed from: j */
    private boolean f14422j;

    /* JADX INFO: renamed from: k */
    private AlertDialog f14423k;

    /* JADX INFO: renamed from: l */
    private boolean f14424l;

    /* JADX INFO: renamed from: m */
    private FingerprintManager f14425m;

    /* JADX INFO: renamed from: n */
    private FingerprintAuthDialogFragment f14426n;

    public enum PasscodeMode {
        Create,
        CreateConfirm,
        Check,
        Change
    }

    @Override // android.app.Activity
    protected void onResume() {
        AppStartTrace.setLauncherActivityOnResumeTime("com.salesforce.androidsdk.ui.PasscodeActivity");
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStart() {
        AppStartTrace.setLauncherActivityOnStartTime("com.salesforce.androidsdk.ui.PasscodeActivity");
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        AppStartTrace.setLauncherActivityOnCreateTime("com.salesforce.androidsdk.ui.PasscodeActivity");
        super.onCreate(bundle);
        this.f14421i = SalesforceSDKManager.m14403a().m14438e();
        getWindow().setFlags(Utility.DEFAULT_STREAM_BUFFER_SIZE, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        setContentView(m14901c());
        TextView textViewM14903e = m14903e();
        if (textViewM14903e != null) {
            textViewM14903e.setText(Html.fromHtml(m14911m()));
        }
        textViewM14903e.setOnClickListener(this);
        this.f14423k = m14893y();
        this.f14415c = m14902d();
        this.f14417e = m14904f();
        this.f14416d = m14905g();
        this.f14418f = m14906h();
        this.f14418f.setOnEditorActionListener(this);
        this.f14419g = SalesforceSDKManager.m14403a().m14449n();
        Intent intent = getIntent();
        if (intent != null ? intent.getBooleanExtra("change_passcode", false) : false) {
            m14897a(PasscodeMode.Change);
        } else {
            m14897a(this.f14419g.m14649b((Context) this) ? PasscodeMode.Check : PasscodeMode.Create);
            m14894z();
        }
        this.f14422j = true;
        if (bundle != null) {
            String string = bundle.getString("input_text");
            if (this.f14418f != null && string != null) {
                this.f14418f.setText(string.trim());
            }
            this.f14424l = bundle.getBoolean("logout_key");
            if (this.f14424l) {
                this.f14423k.show();
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        moveTaskToBack(true);
        return true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.f14418f != null && this.f14418f.getText() != null) {
            bundle.putString("input_text", this.f14418f.getText().toString());
        }
        if (this.f14424l) {
            this.f14423k.dismiss();
            bundle.putBoolean("logout_key", true);
            this.f14424l = false;
        }
    }

    /* JADX INFO: renamed from: a */
    public PasscodeMode m14895a() {
        return this.f14414b;
    }

    /* JADX INFO: renamed from: a */
    public void m14897a(PasscodeMode passcodeMode) {
        if (passcodeMode != this.f14414b) {
            switch (passcodeMode) {
                case Check:
                    this.f14415c.setText(m14908j());
                    this.f14416d.setText(m14910l());
                    m14903e().setVisibility(0);
                    break;
                case Create:
                    this.f14415c.setText(m14907i());
                    this.f14416d.setText(m14915q());
                    m14903e().setVisibility(4);
                    break;
                case CreateConfirm:
                    this.f14415c.setText(m14909k());
                    this.f14416d.setText(m14917s());
                    m14903e().setVisibility(4);
                    break;
                case Change:
                    this.f14415c.setText(m14907i());
                    this.f14416d.setText(m14916r());
                    m14903e().setVisibility(4);
                    break;
            }
            this.f14418f.setText("");
            this.f14417e.setText("");
            this.f14414b = passcodeMode;
            this.f14418f.requestFocus();
        }
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 2 && (keyEvent == null || keyEvent.getAction() != 1)) {
            return true;
        }
        String string = this.f14418f.getText().toString();
        if (string.length() >= 0 && string.length() < m14920v()) {
            this.f14417e.setText(m14896a(m14920v()));
            return true;
        }
        if (string.length() > 0) {
            return m14898a(string);
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    protected boolean m14898a(String str) {
        switch (m14895a()) {
            case Check:
                if (this.f14419g.m14644a(this, str)) {
                    this.f14419g.m14639a(str);
                    m14900b();
                } else {
                    int iM14645b = this.f14419g.m14645b();
                    this.f14418f.setText("");
                    int iM14921w = m14921w();
                    if (iM14645b < iM14921w - 1) {
                        this.f14417e.setText(m14899b(iM14921w - iM14645b));
                    } else if (iM14645b < iM14921w) {
                        this.f14417e.setText(m14918t());
                    } else {
                        this.f14419g.m14636a((Context) this);
                        if (this.f14422j) {
                            SalesforceSDKManager.m14403a().m14428a((Activity) this);
                        }
                    }
                }
                break;
            case Create:
                this.f14420h = str;
                m14897a(PasscodeMode.CreateConfirm);
                break;
            case CreateConfirm:
                if (str.equals(this.f14420h)) {
                    String strM14653d = this.f14419g.m14653d();
                    this.f14419g.m14647b(this, str);
                    SalesforceSDKManager.m14403a().mo14433b(strM14653d, this.f14419g.m14651c(str));
                    this.f14419g.m14639a(str);
                    m14900b();
                } else {
                    this.f14417e.setText(m14919u());
                }
                break;
            case Change:
                this.f14420h = str;
                m14897a(PasscodeMode.CreateConfirm);
                break;
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    protected void m14900b() {
        setResult(-1);
        finish();
    }

    /* JADX INFO: renamed from: c */
    protected int m14901c() {
        return this.f14421i.m14985m();
    }

    /* JADX INFO: renamed from: d */
    protected TextView m14902d() {
        return (TextView) findViewById(this.f14421i.m14986n());
    }

    /* JADX INFO: renamed from: e */
    protected TextView m14903e() {
        return (TextView) findViewById(this.f14421i.m14990r());
    }

    /* JADX INFO: renamed from: f */
    protected TextView m14904f() {
        return (TextView) findViewById(this.f14421i.m14987o());
    }

    /* JADX INFO: renamed from: g */
    protected TextView m14905g() {
        return (TextView) findViewById(this.f14421i.m14988p());
    }

    /* JADX INFO: renamed from: h */
    protected EditText m14906h() {
        return (EditText) findViewById(this.f14421i.m14989q());
    }

    /* JADX INFO: renamed from: i */
    protected String m14907i() {
        return String.format(getString(this.f14421i.m14991s()), SalesforceSDKManager.m14403a().m14454s());
    }

    /* JADX INFO: renamed from: j */
    protected String m14908j() {
        return String.format(getString(this.f14421i.m14992t()), SalesforceSDKManager.m14403a().m14454s());
    }

    /* JADX INFO: renamed from: k */
    protected String m14909k() {
        return String.format(getString(this.f14421i.m14993u()), SalesforceSDKManager.m14403a().m14454s());
    }

    /* JADX INFO: renamed from: l */
    protected String m14910l() {
        return String.format(getString(this.f14421i.m14994v()), SalesforceSDKManager.m14403a().m14454s());
    }

    /* JADX INFO: renamed from: m */
    protected String m14911m() {
        return getString(this.f14421i.m14938D());
    }

    /* JADX INFO: renamed from: n */
    protected String m14912n() {
        return getString(this.f14421i.m14939E());
    }

    /* JADX INFO: renamed from: o */
    protected String m14913o() {
        return getString(this.f14421i.m14940F());
    }

    /* JADX INFO: renamed from: p */
    protected String m14914p() {
        return getString(this.f14421i.m14941G());
    }

    /* JADX INFO: renamed from: q */
    protected String m14915q() {
        return String.format(getString(this.f14421i.m14995w()), SalesforceSDKManager.m14403a().m14454s());
    }

    /* JADX INFO: renamed from: r */
    protected String m14916r() {
        return getString(this.f14421i.m14996x());
    }

    /* JADX INFO: renamed from: s */
    protected String m14917s() {
        return String.format(getString(this.f14421i.m14997y()), SalesforceSDKManager.m14403a().m14454s());
    }

    /* JADX INFO: renamed from: a */
    protected String m14896a(int i) {
        return getString(this.f14421i.m14998z(), new Object[]{Integer.valueOf(i)});
    }

    /* JADX INFO: renamed from: b */
    protected String m14899b(int i) {
        return getString(this.f14421i.m14935A(), new Object[]{Integer.valueOf(i)});
    }

    /* JADX INFO: renamed from: t */
    protected String m14918t() {
        return getString(this.f14421i.m14936B());
    }

    /* JADX INFO: renamed from: u */
    protected String m14919u() {
        return getString(this.f14421i.m14937C());
    }

    /* JADX INFO: renamed from: v */
    protected int m14920v() {
        return this.f14419g.m14657h();
    }

    /* JADX INFO: renamed from: w */
    protected int m14921w() {
        return 10;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(m14903e())) {
            this.f14423k.show();
            this.f14424l = true;
        }
    }

    /* JADX INFO: renamed from: y */
    private AlertDialog m14893y() {
        return new AlertDialog.Builder(this).setMessage(m14912n()).setPositiveButton(m14913o(), new DialogInterface.OnClickListener() { // from class: com.salesforce.androidsdk.ui.PasscodeActivity.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                UserAccountManager userAccountManagerM14450o = SalesforceSDKManager.m14403a().m14450o();
                List<UserAccount> listM14277d = userAccountManagerM14450o.m14277d();
                if (listM14277d != null) {
                    int size = listM14277d.size();
                    if (size > 0) {
                        for (int i2 = 0; i2 < size - 1; i2++) {
                            userAccountManagerM14450o.m14271a(listM14277d.get(i2), (Activity) null, false);
                        }
                        userAccountManagerM14450o.m14270a(listM14277d.get(size - 1), PasscodeActivity.this);
                        return;
                    }
                    return;
                }
                userAccountManagerM14450o.m14268a(PasscodeActivity.this);
            }
        }).setNegativeButton(m14914p(), new DialogInterface.OnClickListener() { // from class: com.salesforce.androidsdk.ui.PasscodeActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PasscodeActivity.this.f14424l = false;
            }
        }).create();
    }

    /* JADX INFO: renamed from: z */
    private void m14894z() {
        if (this.f14419g != null && this.f14419g.m14653d() != null && m14891A()) {
            this.f14426n = new FingerprintAuthDialogFragment();
            this.f14426n.m14843a(this);
            this.f14426n.show(getFragmentManager(), "fingerprintDialog");
        }
    }

    @TargetApi(23)
    /* JADX INFO: renamed from: A */
    private boolean m14891A() {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f14425m = (FingerprintManager) getSystemService("fingerprint");
            if (checkSelfPermission("android.permission.USE_FINGERPRINT") == 0) {
                return this.f14425m != null && this.f14425m.isHardwareDetected() && this.f14425m.hasEnrolledFingerprints();
            }
            requestPermissions(new String[]{"android.permission.USE_FINGERPRINT"}, 11);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 11 && iArr[0] == 0) {
            m14894z();
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: renamed from: x */
    public void m14922x() {
        this.f14419g.m14659j();
        m14900b();
    }
}

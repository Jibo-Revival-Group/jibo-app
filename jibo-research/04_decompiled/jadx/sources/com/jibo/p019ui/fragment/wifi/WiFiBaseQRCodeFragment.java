package com.jibo.p019ui.fragment.wifi;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient;
import com.jibo.aws.integration.aws.services.oobe.JiboOobeAsyncClient;
import com.jibo.aws.integration.aws.services.oobe.model.GetStatusRequest;
import com.jibo.aws.integration.aws.services.oobe.model.PrepareRobotRequest;
import com.jibo.aws.integration.aws.services.oobe.model.StatusContainer;
import com.jibo.aws.integration.aws.services.oobe.model.TokenContainer;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.fragment.dialog.CircleProgressFragment;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.LogUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class WiFiBaseQRCodeFragment extends WiFiBaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f11321a = LogUtils.m11405a(WiFiBaseQRCodeFragment.class);

    /* JADX INFO: renamed from: b */
    protected JiboLoopAsyncClient f11322b;

    /* JADX INFO: renamed from: c */
    protected JiboOobeAsyncClient f11323c;

    /* JADX INFO: renamed from: n */
    protected TokenContainer f11326n;

    /* JADX INFO: renamed from: o */
    protected CircleProgressFragment f11327o;

    /* JADX INFO: renamed from: p */
    private String f11328p;

    /* JADX INFO: renamed from: l */
    protected int f11324l = 0;

    /* JADX INFO: renamed from: m */
    protected List<String> f11325m = new ArrayList();

    /* JADX INFO: renamed from: q */
    private final Runnable f11329q = new RunnableC13961();

    /* JADX INFO: renamed from: r */
    private Runnable f11330r = new RunnableC13972();

    /* JADX INFO: renamed from: s */
    protected abstract void mo11177s();

    /* JADX INFO: renamed from: com.jibo.ui.fragment.wifi.WiFiBaseQRCodeFragment$1 */
    class RunnableC13961 implements Runnable {
        RunnableC13961() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WiFiBaseQRCodeFragment.this.m10342d() && WiFiBaseQRCodeFragment.this.f11322b != null) {
                LogUtils.m11407a(WiFiBaseQRCodeFragment.f11321a, "checkForNewRobotRunnable");
                if (WiFiBaseQRCodeFragment.this.f11326n == null) {
                    WiFiBaseQRCodeFragment.this.m10341c().postDelayed(WiFiBaseQRCodeFragment.this.f11329q, 4000L);
                } else {
                    WiFiBaseQRCodeFragment.this.f11323c.getStatus(WiFiBaseQRCodeFragment.this.f11326n.getToken(), new AsyncHandler<GetStatusRequest, StatusContainer>() { // from class: com.jibo.ui.fragment.wifi.WiFiBaseQRCodeFragment.1.1
                        @Override // com.amazonaws.handlers.AsyncHandler
                        public void onError(Exception exc) {
                            WiFiBaseQRCodeFragment.this.m10338a((Throwable) exc, "get status", false);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:34:0x01d8  */
                        @Override // com.amazonaws.handlers.AsyncHandler
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public void onSuccess(com.jibo.aws.integration.aws.services.oobe.model.GetStatusRequest r9, com.jibo.aws.integration.aws.services.oobe.model.StatusContainer r10) throws java.lang.Throwable {
                            /*
                                Method dump skipped, instruction units count: 475
                                To view this dump add '--comments-level debug' option
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.jibo.p019ui.fragment.wifi.WiFiBaseQRCodeFragment.RunnableC13961.AnonymousClass1.onSuccess(com.jibo.aws.integration.aws.services.oobe.model.GetStatusRequest, com.jibo.aws.integration.aws.services.oobe.model.StatusContainer):void");
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.jibo.ui.fragment.wifi.WiFiBaseQRCodeFragment$2 */
    class RunnableC13972 implements Runnable {

        /* JADX INFO: renamed from: b */
        private final long f11339b = 10000;

        RunnableC13972() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String id = null;
            if (WiFiBaseQRCodeFragment.this.m10342d()) {
                WiFiBaseQRCodeFragment.this.m10341c().removeCallbacks(this);
                if (WiFiBaseQRCodeFragment.this.f11326n != null && WiFiBaseQRCodeFragment.this.f11326n.getExpires().longValue() - 30000 > Calendar.getInstance().getTimeInMillis()) {
                    LogUtils.m11407a("TOKEN", "TOKEN IS ALIVE");
                    if (WiFiBaseQRCodeFragment.this.f11328p == null || !WiFiBaseQRCodeFragment.this.f11328p.equals(WiFiBaseQRCodeFragment.this.m11172u())) {
                        WiFiBaseQRCodeFragment.this.m11173v();
                    }
                    WiFiBaseQRCodeFragment.this.mo11177s();
                    if (WiFiBaseQRCodeFragment.this.f11327o != null) {
                        WiFiBaseQRCodeFragment.this.f11327o.m10502a();
                        WiFiBaseQRCodeFragment.this.f11327o = null;
                    }
                    WiFiBaseQRCodeFragment.this.m10341c().postDelayed(this, 10000L);
                    return;
                }
                LogUtils.m11407a("TOKEN", "TOKEN EXPIRED");
                if (WiFiBaseQRCodeFragment.this.f11327o == null) {
                    WiFiBaseQRCodeFragment.this.f11327o = new CircleProgressFragment();
                    WiFiBaseQRCodeFragment.this.f11327o.m10509c("");
                    WiFiBaseQRCodeFragment.this.f11327o.show(WiFiBaseQRCodeFragment.this.getActivity().getSupportFragmentManager(), "CircleFragment");
                }
                if (WiFiBaseQRCodeFragment.this.f9934k != null && WiFiBaseQRCodeFragment.this.f9934k.getId() != null) {
                    id = WiFiBaseQRCodeFragment.this.f9934k.getId();
                }
                WiFiBaseQRCodeFragment.this.f11323c.prepareRobot(id, new AnonymousClass1());
            }
        }

        /* JADX INFO: renamed from: com.jibo.ui.fragment.wifi.WiFiBaseQRCodeFragment$2$1, reason: invalid class name */
        class AnonymousClass1 implements AsyncHandler<PrepareRobotRequest, TokenContainer> {
            AnonymousClass1() {
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                WiFiBaseQRCodeFragment.this.f11327o.m10507b("");
                WiFiBaseQRCodeFragment.this.f11327o = null;
                WiFiBaseQRCodeFragment.this.m10338a((Throwable) exc, "prepareRobot", false);
                if (!ErrorHelper.m11385b((AmazonServiceException) exc) && !ErrorHelper.m11384a((AmazonServiceException) exc)) {
                    WiFiBaseQRCodeFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.wifi.WiFiBaseQRCodeFragment.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((BaseActivity) WiFiBaseQRCodeFragment.this.getActivity()).m10193c(WiFiHelpFragment.class, null);
                        }
                    });
                }
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(PrepareRobotRequest prepareRobotRequest, TokenContainer tokenContainer) {
                if (WiFiBaseQRCodeFragment.this.m10342d()) {
                    WiFiBaseQRCodeFragment.this.f11326n = tokenContainer;
                    LogUtils.m11407a("TOKEN", "NEW TOKEN:" + WiFiBaseQRCodeFragment.this.f11326n.toString());
                    WiFiBaseQRCodeFragment.this.m10341c().postDelayed(WiFiBaseQRCodeFragment.this.f11330r, 10000L);
                    WiFiBaseQRCodeFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.wifi.WiFiBaseQRCodeFragment.2.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            WiFiBaseQRCodeFragment.this.m11173v();
                            WiFiBaseQRCodeFragment.this.mo11177s();
                            WiFiBaseQRCodeFragment.this.m10341c().postDelayed(new Runnable() { // from class: com.jibo.ui.fragment.wifi.WiFiBaseQRCodeFragment.2.1.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (WiFiBaseQRCodeFragment.this.m10342d() && WiFiBaseQRCodeFragment.this.f11327o != null) {
                                        WiFiBaseQRCodeFragment.this.f11327o.m10502a();
                                        WiFiBaseQRCodeFragment.this.f11327o = null;
                                    }
                                }
                            }, 500L);
                        }
                    });
                }
            }
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m11171t();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        m11176r();
        mo10345g();
        if (this.f11327o != null) {
            this.f11327o.m10502a();
            this.f11327o = null;
        }
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(TokenContainer.class.getSimpleName(), this.f11326n);
        bundle.putInt("ARG_QR_CODE_IND", this.f11324l);
        bundle.putStringArrayList("ARG_QR_CODES", (ArrayList) this.f11325m);
        bundle.putString("ARG_QR_CODE_CONTENT", this.f11328p);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f11323c != null) {
            this.f11323c.shutdown();
            this.f11323c = null;
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        this.f11326n = bundle.containsKey(TokenContainer.class.getSimpleName()) ? (TokenContainer) bundle.getSerializable(TokenContainer.class.getSimpleName()) : this.f11326n;
        this.f11324l = bundle.containsKey("ARG_QR_CODE_IND") ? bundle.getInt("ARG_QR_CODE_IND", 0) : this.f11324l;
        this.f11325m = bundle.containsKey("ARG_QR_CODES") ? bundle.getStringArrayList("ARG_QR_CODES") : this.f11325m;
        this.f11328p = bundle.containsKey("ARG_QR_CODE_CONTENT") ? bundle.getString("ARG_QR_CODE_CONTENT") : this.f11328p;
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, com.jibo.p019ui.fragment.IBaseFragment
    /* JADX INFO: renamed from: h */
    public boolean mo10346h() {
        getActivity().getSupportFragmentManager().mo1475a(WaitForTapFragment.class.getSimpleName(), 1);
        return true;
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        m10349k();
    }

    /* JADX INFO: renamed from: a */
    protected void m11174a() {
        m10341c().post(this.f11330r);
    }

    /* JADX INFO: renamed from: q */
    protected void m11175q() {
        m10341c().postDelayed(this.f11329q, 4000L);
    }

    /* JADX INFO: renamed from: r */
    protected void m11176r() {
        m10341c().removeCallbacks(this.f11330r);
        m10341c().removeCallbacks(this.f11329q);
    }

    /* JADX INFO: renamed from: t */
    private void m11171t() {
        this.f11322b = EntityData.m10089a(getActivity()).m10122b();
        if (this.f11323c == null || this.f11323c.isTerminated()) {
            this.f11323c = new JiboOobeAsyncClient(new BasicAWSCredentials(EntityData.m10089a(getActivity()).m10134i().getAccessKeyId(), EntityData.m10089a(getActivity()).m10134i().getSecretAccessKey()));
        }
    }

    /* JADX INFO: renamed from: a */
    private String m11159a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(String.valueOf((char) (str2.charAt(i % str2.length()) ^ str.charAt(i))));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: u */
    public String m11172u() {
        StringBuilder sb = new StringBuilder();
        sb.append(f11313e.getString("ARG_SSID", "")).append("\n").append(f11313e.getString("ARG_PASSWORD", "")).append("\n");
        if (!f11313e.getString("ARG_IPADDRESS", "").isEmpty() || !f11313e.getString("ARG_SUBNETMASK", "").isEmpty() || !f11313e.getString("ARG_ROUTER", "").isEmpty() || !f11313e.getString("ARG_DNS1", "").isEmpty() || !f11313e.getString("ARG_DNS2", "").isEmpty()) {
            sb.append(f11313e.getString("ARG_IPADDRESS", "")).append("\n").append(f11313e.getString("ARG_SUBNETMASK", "")).append("\n").append(f11313e.getString("ARG_ROUTER", "")).append("\n").append(f11313e.getString("ARG_DNS1", "")).append("\n").append(f11313e.getString("ARG_DNS2", "")).append("\n");
        }
        sb.append(this.f11326n.getToken());
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: v */
    public void m11173v() {
        try {
            if (m10342d()) {
                this.f11328p = m11172u();
                String strM11159a = m11159a(this.f11328p, "Wow, you cracked our secret code. Impressive. Maybe you should check out jibo.com/jobs.");
                LogUtils.m11407a(f11321a, "codeContent: " + strM11159a);
                int iCeil = (int) Math.ceil(strM11159a.length() / 50.0f);
                int iFloor = (int) Math.floor(strM11159a.length() / iCeil);
                StringBuilder sb = new StringBuilder();
                this.f11325m.clear();
                int i = 1;
                int i2 = 0;
                while (i <= iCeil) {
                    sb.delete(0, sb.length());
                    sb.append(i).append("/").append(iCeil).append("\n");
                    sb.append(strM11159a.substring(i2, (i2 + iFloor >= strM11159a.length() || i == iCeil) ? strM11159a.length() : i2 + iFloor));
                    i2 += iFloor;
                    this.f11325m.add(sb.toString());
                    i++;
                }
                for (int i3 = 0; i3 < iCeil; i3++) {
                    LogUtils.m11407a(f11321a, "code #" + i3 + ": " + this.f11325m.get(i3));
                }
            }
        } catch (Exception e) {
            LogUtils.m11408a(f11321a, "generateQRCodes", e);
        }
    }
}

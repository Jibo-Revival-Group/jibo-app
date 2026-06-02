package com.salesforce.android.service.common.utilities.logging;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class ServiceLoggerImpl implements ServiceLogger {

    /* JADX INFO: renamed from: a */
    private final String f13913a;

    /* JADX INFO: renamed from: b */
    private final String f13914b;

    /* JADX INFO: renamed from: a */
    static ServiceLoggerImpl m14196a(String str, String str2) {
        return new ServiceLoggerImpl(str, str2);
    }

    private ServiceLoggerImpl(String str, String str2) {
        this.f13913a = str;
        this.f13914b = str2;
    }

    @Override // com.salesforce.android.service.common.utilities.logging.ServiceLogger
    /* JADX INFO: renamed from: a */
    public void mo14186a(String str) {
        m14197a(1, str);
    }

    @Override // com.salesforce.android.service.common.utilities.logging.ServiceLogger
    /* JADX INFO: renamed from: a */
    public void mo14187a(String str, Object... objArr) {
        m14198a(1, str, objArr);
    }

    @Override // com.salesforce.android.service.common.utilities.logging.ServiceLogger
    /* JADX INFO: renamed from: b */
    public void mo14188b(String str) {
        m14197a(2, str);
    }

    @Override // com.salesforce.android.service.common.utilities.logging.ServiceLogger
    /* JADX INFO: renamed from: b */
    public void mo14189b(String str, Object... objArr) {
        m14198a(2, str, objArr);
    }

    @Override // com.salesforce.android.service.common.utilities.logging.ServiceLogger
    /* JADX INFO: renamed from: c */
    public void mo14190c(String str) {
        m14197a(3, str);
    }

    @Override // com.salesforce.android.service.common.utilities.logging.ServiceLogger
    /* JADX INFO: renamed from: c */
    public void mo14191c(String str, Object... objArr) {
        m14198a(3, str, objArr);
    }

    @Override // com.salesforce.android.service.common.utilities.logging.ServiceLogger
    /* JADX INFO: renamed from: d */
    public void mo14192d(String str) {
        m14197a(4, str);
    }

    @Override // com.salesforce.android.service.common.utilities.logging.ServiceLogger
    /* JADX INFO: renamed from: d */
    public void mo14193d(String str, Object... objArr) {
        m14198a(4, str, objArr);
    }

    @Override // com.salesforce.android.service.common.utilities.logging.ServiceLogger
    /* JADX INFO: renamed from: e */
    public void mo14194e(String str) {
        m14197a(5, str);
    }

    @Override // com.salesforce.android.service.common.utilities.logging.ServiceLogger
    /* JADX INFO: renamed from: e */
    public void mo14195e(String str, Object... objArr) {
        m14198a(5, str, objArr);
    }

    /* JADX INFO: renamed from: a */
    private void m14197a(int i, String str) {
        if (m14199a(i)) {
            m14200b(i, str);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m14198a(int i, String str, Object[] objArr) {
        if (m14199a(i)) {
            m14200b(i, m14201f(str, objArr));
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m14199a(int i) {
        return ServiceLogging.m14202a() <= i && !ServiceLogging.m14206b().isEmpty() && (this.f13914b == null || ServiceLogging.m14205a(this.f13914b));
    }

    /* JADX INFO: renamed from: f */
    private String m14201f(String str, Object[] objArr) {
        if (objArr != null) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (Object obj : objArr) {
                int iIndexOf = str.indexOf("{}", i);
                if (iIndexOf < 0) {
                    break;
                }
                sb.append((CharSequence) str, i, iIndexOf);
                sb.append(obj);
                i = iIndexOf + 2;
            }
            sb.append((CharSequence) str, i, str.length());
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: renamed from: b */
    private void m14200b(int i, String str) {
        Iterator<ServiceLoggingSink> it = ServiceLogging.m14206b().iterator();
        while (it.hasNext()) {
            it.next().mo14207a(i, this.f13913a, str);
        }
    }
}

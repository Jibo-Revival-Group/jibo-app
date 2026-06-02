package com.jibo.aws.integration.aws.services.common.model.p005a;

import android.text.TextUtils;
import com.jibo.aws.integration.aws.services.common.model.IdRequestAbstract;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;

/* JADX INFO: renamed from: com.jibo.aws.integration.aws.services.common.model.a.c */
/* JADX INFO: loaded from: classes.dex */
public class C0853c extends C0855e {
    @Override // com.jibo.aws.integration.aws.services.common.model.p005a.C0855e
    /* JADX INFO: renamed from: b */
    protected String mo9961b(JiboRequestAbstract jiboRequestAbstract) {
        return !TextUtils.isEmpty(((IdRequestAbstract) jiboRequestAbstract).getId()) ? super.mo9961b(jiboRequestAbstract) : "{}";
    }
}

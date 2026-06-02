package com.salesforce.androidsdk.smartstore.store;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class LongOperation {
    /* JADX INFO: renamed from: a */
    public abstract void mo14679a();

    /* JADX INFO: renamed from: a */
    protected abstract void mo14681a(SmartStore smartStore, long j, JSONObject jSONObject, String str) throws JSONException;

    public enum LongOperationType {
        alterSoup(AlterSoupLongOperation.class);

        private Class<? extends LongOperation> operationClass;

        LongOperationType(Class cls) {
            this.operationClass = cls;
        }

        public LongOperation getOperation(SmartStore smartStore, long j, JSONObject jSONObject, String str) throws IllegalAccessException, JSONException, InstantiationException {
            LongOperation longOperationNewInstance = this.operationClass.newInstance();
            longOperationNewInstance.mo14681a(smartStore, j, jSONObject, str);
            return longOperationNewInstance;
        }
    }
}

package com.salesforce.androidsdk.smartstore.store;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class LongOperation {
   public abstract void a();

   protected abstract void a(SmartStore var1, long var2, JSONObject var4, String var5) throws JSONException;

   public enum LongOperationType {
      alterSoup(AlterSoupLongOperation.class);

      private static final LongOperation.LongOperationType[] $VALUES = new LongOperation.LongOperationType[]{LongOperation.LongOperationType.alterSoup};
      private Class<? extends LongOperation> operationClass;

      LongOperationType(Class<? extends LongOperation> var3) {
         this.operationClass = var3;
      }

      public LongOperation getOperation(SmartStore var1, long var2, JSONObject var4, String var5) throws IllegalAccessException, InstantiationException, JSONException {
         LongOperation var6 = this.operationClass.newInstance();
         var6.a(var1, var2, var4, var5);
         return var6;
      }
   }
}

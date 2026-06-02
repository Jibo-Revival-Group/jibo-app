package com.salesforce.android.knowledge.core.internal.db;

import com.salesforce.androidsdk.smartstore.store.IndexSpec;
import com.salesforce.androidsdk.smartstore.store.SmartStore;

final class DbContract {
   static final class DbMeta {
      public static final IndexSpec[] a = new IndexSpec[]{new IndexSpec("InstalledVersion", SmartStore.Type.integer, "InstalledVersion")};
   }
}

package com.crashlytics.android.beta;

import android.content.Context;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.settings.BetaSettingsData;

interface UpdatesController {
   void a(
      Context var1,
      Beta var2,
      IdManager var3,
      BetaSettingsData var4,
      BuildProperties var5,
      PreferenceStore var6,
      CurrentTimeProvider var7,
      HttpRequestFactory var8
   );
}

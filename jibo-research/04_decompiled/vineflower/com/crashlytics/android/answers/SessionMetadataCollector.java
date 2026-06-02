package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import java.util.Map;
import java.util.UUID;

class SessionMetadataCollector {
   private final Context a;
   private final IdManager b;
   private final String c;
   private final String d;

   public SessionMetadataCollector(Context var1, IdManager var2, String var3, String var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public SessionEventMetadata a() {
      Map var6 = this.b.i();
      String var5 = this.b.c();
      String var1 = this.b.b();
      String var4 = (String)var6.get(IdManager.DeviceIdentifierType.ANDROID_ID);
      String var2 = (String)var6.get(IdManager.DeviceIdentifierType.ANDROID_ADVERTISING_ID);
      Boolean var3 = this.b.l();
      String var9 = (String)var6.get(IdManager.DeviceIdentifierType.FONT_TOKEN);
      String var8 = CommonUtils.m(this.a);
      String var7 = this.b.d();
      String var10 = this.b.g();
      return new SessionEventMetadata(var5, UUID.randomUUID().toString(), var1, var4, var2, var3, var9, var8, var7, var10, this.c, this.d);
   }
}

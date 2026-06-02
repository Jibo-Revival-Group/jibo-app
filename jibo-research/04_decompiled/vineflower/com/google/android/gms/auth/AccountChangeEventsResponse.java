package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.List;

public class AccountChangeEventsResponse extends zzbfm {
   public static final Creator<AccountChangeEventsResponse> CREATOR = new zzc();
   private int a;
   private List<AccountChangeEvent> b;

   AccountChangeEventsResponse(int var1, List<AccountChangeEvent> var2) {
      this.a = var1;
      this.b = zzbq.a(var2);
   }

   public void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a);
      zzbfp.c(var1, 2, this.b, false);
      zzbfp.a(var1, var2);
   }
}

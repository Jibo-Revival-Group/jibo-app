package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.mixpanel.android.util.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniInAppNotification extends InAppNotification {
   public static final Creator<MiniInAppNotification> CREATOR = new Creator<MiniInAppNotification>() {
      public MiniInAppNotification a(Parcel var1) {
         return new MiniInAppNotification(var1);
      }

      public MiniInAppNotification[] a(int var1) {
         return new MiniInAppNotification[var1];
      }
   };
   private final String e;
   private final int f;
   private final int g;

   public MiniInAppNotification(Parcel var1) {
      super(var1);
      this.e = var1.readString();
      this.f = var1.readInt();
      this.g = var1.readInt();
   }

   MiniInAppNotification(JSONObject var1) throws BadDecideObjectException {
      super(var1);

      try {
         this.e = JSONUtils.a(var1, "cta_url");
         this.f = var1.getInt("image_tint_color");
         this.g = var1.getInt("border_color");
      } catch (JSONException var2) {
         throw new BadDecideObjectException("Notification JSON was unexpected or bad", var2);
      }
   }

   @Override
   public InAppNotification.Type d() {
      return InAppNotification.Type.MINI;
   }

   public String n() {
      return this.e;
   }

   public int o() {
      return this.f;
   }

   public int p() {
      return this.g;
   }

   @Override
   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeString(this.e);
      var1.writeInt(this.f);
      var1.writeInt(this.g);
   }
}

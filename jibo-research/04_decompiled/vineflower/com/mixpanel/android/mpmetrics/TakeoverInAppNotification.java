package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.mixpanel.android.util.JSONUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TakeoverInAppNotification extends InAppNotification {
   public static final Creator<TakeoverInAppNotification> CREATOR = new Creator<TakeoverInAppNotification>() {
      public TakeoverInAppNotification a(Parcel var1) {
         return new TakeoverInAppNotification(var1);
      }

      public TakeoverInAppNotification[] a(int var1) {
         return new TakeoverInAppNotification[var1];
      }
   };
   private final ArrayList<InAppButton> e;
   private final int f;
   private final String g;
   private final int h;
   private final boolean i;

   public TakeoverInAppNotification(Parcel var1) {
      super(var1);
      this.e = var1.createTypedArrayList(InAppButton.CREATOR);
      this.f = var1.readInt();
      this.g = var1.readString();
      this.h = var1.readInt();
      boolean var2;
      if (var1.readByte() != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.i = var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   TakeoverInAppNotification(JSONObject var1) throws BadDecideObjectException {
      super(var1);

      JSONArray var3;
      try {
         var3 = var1.getJSONArray("buttons");
         ArrayList var4 = new ArrayList();
         this.e = var4;
      } catch (JSONException var8) {
         throw new BadDecideObjectException("Notification JSON was unexpected or bad", var8);
      }

      int var2 = 0;

      while (true) {
         try {
            if (var2 >= var3.length()) {
               break;
            }

            JSONObject var6 = (JSONObject)var3.get(var2);
            ArrayList var5 = this.e;
            InAppButton var10 = new InAppButton(var6);
            var5.add(var10);
         } catch (JSONException var9) {
            throw new BadDecideObjectException("Notification JSON was unexpected or bad", var9);
         }

         var2++;
      }

      try {
         this.f = var1.getInt("close_color");
         this.g = JSONUtils.a(var1, "title");
         this.h = var1.optInt("title_color");
         this.i = this.m().getBoolean("image_fade");
      } catch (JSONException var7) {
         throw new BadDecideObjectException("Notification JSON was unexpected or bad", var7);
      }
   }

   public InAppButton a(int var1) {
      InAppButton var2;
      if (this.e.size() > var1) {
         var2 = this.e.get(var1);
      } else {
         var2 = null;
      }

      return var2;
   }

   @Override
   public InAppNotification.Type d() {
      return InAppNotification.Type.TAKEOVER;
   }

   public boolean n() {
      boolean var1;
      if (this.g != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public String o() {
      return this.g;
   }

   public int p() {
      return this.h;
   }

   public int q() {
      return this.f;
   }

   public int r() {
      return this.e.size();
   }

   public boolean s() {
      return this.i;
   }

   @Override
   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeTypedList(this.e);
      var1.writeInt(this.f);
      var1.writeString(this.g);
      var1.writeInt(this.h);
      byte var3;
      if (this.i) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      var1.writeByte((byte)var3);
   }
}

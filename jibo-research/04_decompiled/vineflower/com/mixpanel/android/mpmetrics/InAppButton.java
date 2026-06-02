package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppButton implements Parcelable {
   public static final Creator<InAppButton> CREATOR = new Creator<InAppButton>() {
      public InAppButton a(Parcel var1) {
         return new InAppButton(var1);
      }

      public InAppButton[] a(int var1) {
         return new InAppButton[var1];
      }
   };
   private JSONObject a;
   private String b;
   private int c;
   private int d;
   private int e;
   private String f;

   public InAppButton(Parcel var1) {
      JSONObject var2 = new JSONObject();

      label13: {
         JSONObject var3;
         try {
            var3 = new JSONObject(var1.readString());
         } catch (JSONException var4) {
            Log.e("MixpanelAPI.InAppButton", "Error reading JSON when creating InAppButton from Parcel");
            break label13;
         }

         var2 = var3;
      }

      this.a = var2;
      this.b = var1.readString();
      this.c = var1.readInt();
      this.d = var1.readInt();
      this.e = var1.readInt();
      this.f = var1.readString();
   }

   InAppButton(JSONObject var1) throws JSONException {
      this.a = var1;
      this.b = var1.getString("text");
      this.c = var1.getInt("text_color");
      this.d = var1.getInt("bg_color");
      this.e = var1.getInt("border_color");
      this.f = var1.getString("cta_url");
   }

   public String a() {
      return this.b;
   }

   public int b() {
      return this.c;
   }

   public int c() {
      return this.d;
   }

   public int d() {
      return this.e;
   }

   public int describeContents() {
      return 0;
   }

   public String e() {
      return this.f;
   }

   @Override
   public String toString() {
      return this.a.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.a.toString());
      var1.writeString(this.b);
      var1.writeInt(this.c);
      var1.writeInt(this.d);
      var1.writeInt(this.e);
      var1.writeString(this.f);
   }
}

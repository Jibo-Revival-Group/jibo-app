package com.mixpanel.android.mpmetrics;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.util.JSONUtils;
import com.mixpanel.android.util.MPLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class InAppNotification implements Parcelable {
   private static final Pattern e = Pattern.compile("(\\.[^./]+$)");
   protected final JSONObject a;
   protected final JSONObject b;
   protected final int c;
   protected final int d;
   private final int f;
   private final String g;
   private final int h;
   private final String i;
   private Bitmap j;

   public InAppNotification() {
      this.a = null;
      this.b = null;
      this.c = 0;
      this.d = 0;
      this.f = 0;
      this.g = null;
      this.h = 0;
      this.i = null;
   }

   public InAppNotification(Parcel var1) {
      JSONObject var4 = new JSONObject();
      JSONObject var3 = new JSONObject();

      JSONObject var2;
      label23: {
         label22: {
            label21: {
               try {
                  var2 = new JSONObject(var1.readString());
               } catch (JSONException var6) {
                  var2 = var4;
                  break label21;
               }

               try {
                  var4 = new JSONObject(var1.readString());
                  break label22;
               } catch (JSONException var5) {
               }
            }

            MPLog.e("MixpanelAPI.InAppNotif", "Error reading JSON when creating InAppNotification from Parcel");
            break label23;
         }

         var3 = var4;
      }

      this.a = var2;
      this.b = var3;
      this.c = var1.readInt();
      this.d = var1.readInt();
      this.f = var1.readInt();
      this.g = var1.readString();
      this.h = var1.readInt();
      this.i = var1.readString();
      this.j = (Bitmap)var1.readParcelable(Bitmap.class.getClassLoader());
   }

   InAppNotification(JSONObject var1) throws BadDecideObjectException {
      try {
         this.a = var1;
         this.b = var1.getJSONObject("extras");
         this.c = var1.getInt("id");
         this.d = var1.getInt("message_id");
         this.f = var1.getInt("bg_color");
         this.g = JSONUtils.a(var1, "body");
         this.h = var1.optInt("body_color");
         this.i = var1.getString("image_url");
         this.j = Bitmap.createBitmap(500, 500, Config.ARGB_8888);
      } catch (JSONException var2) {
         throw new BadDecideObjectException("Notification JSON was unexpected or bad", var2);
      }
   }

   static String a(String var0, String var1) {
      Matcher var2 = e.matcher(var0);
      if (var2.find()) {
         var0 = var2.replaceFirst(var1 + "$1");
      }

      return var0;
   }

   JSONObject a() {
      JSONObject var2 = new JSONObject();

      try {
         var2.put("campaign_id", this.b());
         var2.put("message_id", this.c());
         var2.put("message_type", "inapp");
         var2.put("message_subtype", this.d().toString());
      } catch (JSONException var3) {
         MPLog.e("MixpanelAPI.InAppNotif", "Impossible JSON Exception", var3);
      }

      return var2;
   }

   void a(Bitmap var1) {
      this.j = var1;
   }

   public int b() {
      return this.c;
   }

   public int c() {
      return this.d;
   }

   public abstract InAppNotification.Type d();

   public int describeContents() {
      return 0;
   }

   public int e() {
      return this.f;
   }

   public boolean f() {
      boolean var1;
      if (this.g != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public String g() {
      return this.g;
   }

   public int h() {
      return this.h;
   }

   public String i() {
      return this.i;
   }

   public String j() {
      return a(this.i, "@2x");
   }

   public String k() {
      return a(this.i, "@4x");
   }

   public Bitmap l() {
      return this.j;
   }

   protected JSONObject m() {
      return this.b;
   }

   @Override
   public String toString() {
      return this.a.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.a.toString());
      var1.writeString(this.b.toString());
      var1.writeInt(this.c);
      var1.writeInt(this.d);
      var1.writeInt(this.f);
      var1.writeString(this.g);
      var1.writeInt(this.h);
      var1.writeString(this.i);
      var1.writeParcelable(this.j, var2);
   }

   public enum Type {
      MINI {
         @Override
         public String toString() {
            return "mini";
         }
      },
      TAKEOVER {
         @Override
         public String toString() {
            return "takeover";
         }
      },
      UNKNOWN {
         @Override
         public String toString() {
            return "*unknown_type*";
         }
      };

      private static final InAppNotification.Type[] $VALUES = new InAppNotification.Type[]{
         InAppNotification.Type.UNKNOWN, InAppNotification.Type.MINI, InAppNotification.Type.TAKEOVER
      };

      Type() {
      }
   }
}

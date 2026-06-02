package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount extends zzbfm implements ReflectedParcelable {
   public static final Creator<GoogleSignInAccount> CREATOR = new zzb();
   private static com.google.android.gms.common.util.zzd a = zzh.d();
   private int b;
   private String c;
   private String d;
   private String e;
   private String f;
   private Uri g;
   private String h;
   private long i;
   private String j;
   private List<Scope> k;
   private String l;
   private String m;
   private Set<Scope> n = new HashSet<>();

   GoogleSignInAccount(
      int var1,
      String var2,
      String var3,
      String var4,
      String var5,
      Uri var6,
      String var7,
      long var8,
      String var10,
      List<Scope> var11,
      String var12,
      String var13
   ) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
      this.f = var5;
      this.g = var6;
      this.h = var7;
      this.i = var8;
      this.j = var10;
      this.k = var11;
      this.l = var12;
      this.m = var13;
   }

   public static GoogleSignInAccount a(String var0) throws JSONException {
      JSONObject var5 = null;
      GoogleSignInAccount var8;
      if (TextUtils.isEmpty(var0)) {
         var8 = var5;
      } else {
         var5 = new JSONObject(var0);
         var0 = var5.optString("photoUrl", null);
         Uri var10;
         if (!TextUtils.isEmpty(var0)) {
            var10 = Uri.parse(var0);
         } else {
            var10 = null;
         }

         long var3 = Long.parseLong(var5.getString("expirationTime"));
         HashSet var7 = new HashSet();
         JSONArray var6 = var5.getJSONArray("grantedScopes");
         int var2 = var6.length();

         for (int var1 = 0; var1 < var2; var1++) {
            var7.add(new Scope(var6.getString(var1)));
         }

         var8 = a(
            var5.optString("id"),
            var5.optString("tokenId", null),
            var5.optString("email", null),
            var5.optString("displayName", null),
            var5.optString("givenName", null),
            var5.optString("familyName", null),
            var10,
            var3,
            var5.getString("obfuscatedIdentifier"),
            var7
         );
         var8.h = var5.optString("serverAuthCode", null);
      }

      return var8;
   }

   private static GoogleSignInAccount a(
      String var0, String var1, String var2, String var3, String var4, String var5, Uri var6, Long var7, String var8, Set<Scope> var9
   ) {
      Long var10 = var7;
      if (var7 == null) {
         var10 = a.a() / 1000L;
      }

      return new GoogleSignInAccount(3, var0, var1, var2, var3, var6, null, var10, zzbq.a(var8), new ArrayList<>(zzbq.a(var9)), var4, var5);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final JSONObject m() {
      JSONObject var3 = new JSONObject();

      try {
         if (this.a() != null) {
            var3.put("id", this.a());
         }
      } catch (JSONException var12) {
         throw new RuntimeException(var12);
      }

      try {
         if (this.b() != null) {
            var3.put("tokenId", this.b());
         }
      } catch (JSONException var16) {
         throw new RuntimeException(var16);
      }

      try {
         if (this.c() != null) {
            var3.put("email", this.c());
         }
      } catch (JSONException var11) {
         throw new RuntimeException(var11);
      }

      try {
         if (this.e() != null) {
            var3.put("displayName", this.e());
         }
      } catch (JSONException var15) {
         throw new RuntimeException(var15);
      }

      try {
         if (this.f() != null) {
            var3.put("givenName", this.f());
         }
      } catch (JSONException var10) {
         throw new RuntimeException(var10);
      }

      try {
         if (this.g() != null) {
            var3.put("familyName", this.g());
         }
      } catch (JSONException var14) {
         throw new RuntimeException(var14);
      }

      try {
         if (this.h() != null) {
            var3.put("photoUrl", this.h().toString());
         }
      } catch (JSONException var9) {
         throw new RuntimeException(var9);
      }

      try {
         if (this.i() != null) {
            var3.put("serverAuthCode", this.i());
         }
      } catch (JSONException var13) {
         throw new RuntimeException(var13);
      }

      int var2;
      JSONArray var4;
      Scope[] var5;
      try {
         var3.put("expirationTime", this.i);
         var3.put("obfuscatedIdentifier", this.j);
         var4 = new JSONArray();
         var5 = this.k.toArray(new Scope[this.k.size()]);
         Arrays.sort(var5, zza.a);
         var2 = var5.length;
      } catch (JSONException var8) {
         throw new RuntimeException(var8);
      }

      for (int var1 = 0; var1 < var2; var1++) {
         try {
            var4.put(var5[var1].a());
         } catch (JSONException var7) {
            throw new RuntimeException(var7);
         }
      }

      try {
         var3.put("grantedScopes", var4);
         return var3;
      } catch (JSONException var6) {
         throw new RuntimeException(var6);
      }
   }

   public String a() {
      return this.c;
   }

   public String b() {
      return this.d;
   }

   public String c() {
      return this.e;
   }

   public Account d() {
      Account var1;
      if (this.e == null) {
         var1 = null;
      } else {
         var1 = new Account(this.e, "com.google");
      }

      return var1;
   }

   public String e() {
      return this.f;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (var1 != this) {
         if (!(var1 instanceof GoogleSignInAccount)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!var1.j.equals(this.j) || !var1.k().equals(this.k())) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   public String f() {
      return this.l;
   }

   public String g() {
      return this.m;
   }

   public Uri h() {
      return this.g;
   }

   @Override
   public int hashCode() {
      return (this.j.hashCode() + 527) * 31 + this.k().hashCode();
   }

   public String i() {
      return this.h;
   }

   public final String j() {
      return this.j;
   }

   public final Set<Scope> k() {
      HashSet var1 = new HashSet<>(this.k);
      var1.addAll(this.n);
      return var1;
   }

   public final String l() {
      JSONObject var1 = this.m();
      var1.remove("serverAuthCode");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.b);
      zzbfp.a(var1, 2, this.a(), false);
      zzbfp.a(var1, 3, this.b(), false);
      zzbfp.a(var1, 4, this.c(), false);
      zzbfp.a(var1, 5, this.e(), false);
      zzbfp.a(var1, 6, this.h(), var2, false);
      zzbfp.a(var1, 7, this.i(), false);
      zzbfp.a(var1, 8, this.i);
      zzbfp.a(var1, 9, this.j, false);
      zzbfp.c(var1, 10, this.k, false);
      zzbfp.a(var1, 11, this.f(), false);
      zzbfp.a(var1, 12, this.g(), false);
      zzbfp.a(var1, var3);
   }
}

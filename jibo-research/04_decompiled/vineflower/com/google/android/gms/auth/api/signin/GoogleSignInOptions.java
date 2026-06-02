package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.auth.api.signin.internal.zzp;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions extends zzbfm implements Api.ApiOptions.Optional, ReflectedParcelable {
   public static final Creator<GoogleSignInOptions> CREATOR = new zze();
   public static final Scope a = new Scope("profile");
   public static final Scope b = new Scope("email");
   public static final Scope c = new Scope("openid");
   public static final Scope d = new Scope("https://www.googleapis.com/auth/games_lite");
   public static final Scope e = new Scope("https://www.googleapis.com/auth/games");
   public static final GoogleSignInOptions f = new GoogleSignInOptions.Builder().a().b().c();
   public static final GoogleSignInOptions g = new GoogleSignInOptions.Builder().a(d).c();
   private static Comparator<Scope> r = new zzd();
   private int h;
   private final ArrayList<Scope> i;
   private Account j;
   private boolean k;
   private final boolean l;
   private final boolean m;
   private String n;
   private String o;
   private ArrayList<zzn> p;
   private Map<Integer, zzn> q;

   GoogleSignInOptions(int var1, ArrayList<Scope> var2, Account var3, boolean var4, boolean var5, boolean var6, String var7, String var8, ArrayList<zzn> var9) {
      this(var1, var2, var3, var4, var5, var6, var7, var8, b(var9));
   }

   private GoogleSignInOptions(
      int var1, ArrayList<Scope> var2, Account var3, boolean var4, boolean var5, boolean var6, String var7, String var8, Map<Integer, zzn> var9
   ) {
      this.h = var1;
      this.i = var2;
      this.j = var3;
      this.k = var4;
      this.l = var5;
      this.m = var6;
      this.n = var7;
      this.o = var8;
      this.p = new ArrayList<>(var9.values());
      this.q = var9;
   }

   public static GoogleSignInOptions a(String var0) throws JSONException {
      JSONObject var3 = null;
      GoogleSignInOptions var5;
      if (TextUtils.isEmpty(var0)) {
         var5 = var3;
      } else {
         var3 = new JSONObject(var0);
         HashSet var4 = new HashSet();
         JSONArray var6 = var3.getJSONArray("scopes");
         int var2 = var6.length();

         for (int var1 = 0; var1 < var2; var1++) {
            var4.add(new Scope(var6.getString(var1)));
         }

         var0 = var3.optString("accountName", null);
         Account var8;
         if (!TextUtils.isEmpty(var0)) {
            var8 = new Account(var0, "com.google");
         } else {
            var8 = null;
         }

         var5 = new GoogleSignInOptions(
            3,
            new ArrayList<>(var4),
            var8,
            var3.getBoolean("idTokenRequested"),
            var3.getBoolean("serverAuthRequested"),
            var3.getBoolean("forceCodeForRefreshToken"),
            var3.optString("serverClientId", null),
            var3.optString("hostedDomain", null),
            new HashMap<>()
         );
      }

      return var5;
   }

   private static Map<Integer, zzn> b(List<zzn> var0) {
      HashMap var1 = new HashMap();
      if (var0 != null) {
         for (zzn var3 : var0) {
            var1.put(var3.a(), var3);
         }
      }

      return var1;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private final JSONObject c() {
      JSONObject var5 = new JSONObject();

      int var2;
      JSONArray var3;
      ArrayList var4;
      try {
         var3 = new JSONArray();
         Collections.sort(this.i, r);
         var4 = this.i;
         var2 = var4.size();
      } catch (JSONException var11) {
         throw new RuntimeException(var11);
      }

      int var1 = 0;

      while (var1 < var2) {
         Object var6;
         try {
            var6 = var4.get(var1);
         } catch (JSONException var10) {
            throw new RuntimeException(var10);
         }

         var1++;

         try {
            var3.put(((Scope)var6).a());
         } catch (JSONException var9) {
            throw new RuntimeException(var9);
         }
      }

      try {
         var5.put("scopes", var3);
         if (this.j != null) {
            var5.put("accountName", this.j.name);
         }
      } catch (JSONException var8) {
         throw new RuntimeException(var8);
      }

      try {
         var5.put("idTokenRequested", this.k);
         var5.put("forceCodeForRefreshToken", this.m);
         var5.put("serverAuthRequested", this.l);
         if (!TextUtils.isEmpty(this.n)) {
            var5.put("serverClientId", this.n);
         }
      } catch (JSONException var12) {
         throw new RuntimeException(var12);
      }

      try {
         if (!TextUtils.isEmpty(this.o)) {
            var5.put("hostedDomain", this.o);
         }

         return var5;
      } catch (JSONException var7) {
         throw new RuntimeException(var7);
      }
   }

   public final ArrayList<Scope> a() {
      return new ArrayList<>(this.i);
   }

   public final String b() {
      return this.c().toString();
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if (var1 == null) {
         var2 = var3;
      } else {
         try {
            var1 = var1;
         } catch (ClassCastException var17) {
            var2 = var3;
            return var2;
         }

         var2 = var3;

         try {
            if (this.p.size() > 0) {
               return var2;
            }
         } catch (ClassCastException var16) {
            var2 = var3;
            return var2;
         }

         var2 = var3;

         try {
            if (var1.p.size() > 0) {
               return var2;
            }
         } catch (ClassCastException var15) {
            var2 = var3;
            return var2;
         }

         var2 = var3;

         try {
            if (this.i.size() != var1.a().size()) {
               return var2;
            }
         } catch (ClassCastException var14) {
            var2 = var3;
            return var2;
         }

         var2 = var3;

         label130: {
            label131: {
               try {
                  if (!this.i.containsAll(var1.a())) {
                     return var2;
                  }

                  if (this.j != null) {
                     break label131;
                  }
               } catch (ClassCastException var13) {
                  var2 = var3;
                  return var2;
               }

               var2 = var3;

               try {
                  if (var1.j != null) {
                     return var2;
                  }
                  break label130;
               } catch (ClassCastException var12) {
                  var2 = var3;
                  return var2;
               }
            }

            var2 = var3;

            try {
               if (!this.j.equals(var1.j)) {
                  return var2;
               }
            } catch (ClassCastException var11) {
               var2 = var3;
               return var2;
            }
         }

         label132: {
            label133: {
               try {
                  if (!TextUtils.isEmpty(this.n)) {
                     break label133;
                  }
               } catch (ClassCastException var10) {
                  var2 = var3;
                  return var2;
               }

               var2 = var3;

               try {
                  if (!TextUtils.isEmpty(var1.n)) {
                     return var2;
                  }
                  break label132;
               } catch (ClassCastException var9) {
                  var2 = var3;
                  return var2;
               }
            }

            boolean var4;
            try {
               var4 = this.n.equals(var1.n);
            } catch (ClassCastException var8) {
               var2 = var3;
               return var2;
            }

            var2 = var3;
            if (!var4) {
               return var2;
            }
         }

         var2 = var3;

         try {
            if (this.m != var1.m) {
               return var2;
            }
         } catch (ClassCastException var7) {
            var2 = var3;
            return var2;
         }

         var2 = var3;

         try {
            if (this.k != var1.k) {
               return var2;
            }
         } catch (ClassCastException var6) {
            var2 = var3;
            return var2;
         }

         var2 = var3;

         try {
            if (this.l != var1.l) {
               return var2;
            }
         } catch (ClassCastException var5) {
            var2 = var3;
            return var2;
         }

         var2 = true;
      }

      return var2;
   }

   @Override
   public int hashCode() {
      ArrayList var4 = new ArrayList();
      ArrayList var5 = this.i;
      int var2 = var5.size();
      int var1 = 0;

      while (var1 < var2) {
         Object var3 = var5.get(var1);
         var1++;
         var4.add(((Scope)var3).a());
      }

      Collections.sort(var4);
      return new zzp().a(var4).a(this.j).a(this.n).a(this.m).a(this.k).a(this.l).a();
   }

   public void writeToParcel(Parcel var1, int var2) {
      int var3 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.h);
      zzbfp.c(var1, 2, this.a(), false);
      zzbfp.a(var1, 3, this.j, var2, false);
      zzbfp.a(var1, 4, this.k);
      zzbfp.a(var1, 5, this.l);
      zzbfp.a(var1, 6, this.m);
      zzbfp.a(var1, 7, this.n, false);
      zzbfp.a(var1, 8, this.o, false);
      zzbfp.c(var1, 9, this.p, false);
      zzbfp.a(var1, var3);
   }

   public static final class Builder {
      private Set<Scope> a = new HashSet<>();
      private boolean b;
      private boolean c;
      private boolean d;
      private String e;
      private Account f;
      private String g;
      private Map<Integer, zzn> h = new HashMap<>();

      public Builder() {
      }

      public Builder(GoogleSignInOptions var1) {
         zzbq.a(var1);
         this.a = new HashSet<>(var1.i);
         this.b = var1.l;
         this.c = var1.m;
         this.d = var1.k;
         this.e = var1.n;
         this.f = var1.j;
         this.g = var1.o;
         this.h = GoogleSignInOptions.b(var1.p);
      }

      public final GoogleSignInOptions.Builder a() {
         this.a.add(GoogleSignInOptions.c);
         return this;
      }

      public final GoogleSignInOptions.Builder a(Scope var1, Scope... var2) {
         this.a.add(var1);
         this.a.addAll(Arrays.asList(var2));
         return this;
      }

      public final GoogleSignInOptions.Builder b() {
         this.a.add(GoogleSignInOptions.a);
         return this;
      }

      public final GoogleSignInOptions c() {
         if (this.a.contains(GoogleSignInOptions.e) && this.a.contains(GoogleSignInOptions.d)) {
            this.a.remove(GoogleSignInOptions.d);
         }

         if (this.d && (this.f == null || !this.a.isEmpty())) {
            this.a();
         }

         return new GoogleSignInOptions(3, new ArrayList<>(this.a), this.f, this.d, this.b, this.c, this.e, this.g, this.h, null);
      }
   }
}

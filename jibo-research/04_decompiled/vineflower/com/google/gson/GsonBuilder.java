package com.google.gson;

import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GsonBuilder {
   private Excluder a;
   private LongSerializationPolicy b;
   private FieldNamingStrategy c;
   private final Map<Type, InstanceCreator<?>> d;
   private final List<TypeAdapterFactory> e;
   private final List<TypeAdapterFactory> f;
   private boolean g;
   private String h;
   private int i;
   private int j;
   private boolean k;
   private boolean l;
   private boolean m;
   private boolean n;
   private boolean o;
   private boolean p;

   public GsonBuilder() {
      this.a = Excluder.a;
      this.b = LongSerializationPolicy.DEFAULT;
      this.c = FieldNamingPolicy.IDENTITY;
      this.d = new HashMap<>();
      this.e = new ArrayList<>();
      this.f = new ArrayList<>();
      this.g = false;
      this.i = 2;
      this.j = 2;
      this.k = false;
      this.l = false;
      this.m = true;
      this.n = false;
      this.o = false;
      this.p = false;
   }

   private void a(String var1, int var2, int var3, List<TypeAdapterFactory> var4) {
      DefaultDateTypeAdapter var5;
      DefaultDateTypeAdapter var6;
      DefaultDateTypeAdapter var8;
      if (var1 != null && !"".equals(var1.trim())) {
         DefaultDateTypeAdapter var7 = new DefaultDateTypeAdapter(Date.class, var1);
         var5 = new DefaultDateTypeAdapter(Timestamp.class, var1);
         var6 = new DefaultDateTypeAdapter(java.sql.Date.class, var1);
         var8 = var7;
      } else {
         if (var2 == 2 || var3 == 2) {
            return;
         }

         var8 = new DefaultDateTypeAdapter(Date.class, var2, var3);
         var5 = new DefaultDateTypeAdapter(Timestamp.class, var2, var3);
         var6 = new DefaultDateTypeAdapter(java.sql.Date.class, var2, var3);
      }

      var4.add(TypeAdapters.a(Date.class, var8));
      var4.add(TypeAdapters.a(Timestamp.class, var5));
      var4.add(TypeAdapters.a(java.sql.Date.class, var6));
   }

   public Gson a() {
      ArrayList var2 = new ArrayList(this.e.size() + this.f.size() + 3);
      var2.addAll(this.e);
      Collections.reverse(var2);
      ArrayList var1 = new ArrayList<>(this.f);
      Collections.reverse(var1);
      var2.addAll(var1);
      this.a(this.h, this.i, this.j, var2);
      return new Gson(this.a, this.c, this.d, this.g, this.k, this.o, this.m, this.n, this.p, this.l, this.b, var2);
   }

   public GsonBuilder a(FieldNamingPolicy var1) {
      this.c = var1;
      return this;
   }

   public GsonBuilder a(Class<?> var1, Object var2) {
      boolean var3;
      if (!(var2 instanceof JsonSerializer) && !(var2 instanceof JsonDeserializer) && !(var2 instanceof TypeAdapter)) {
         var3 = false;
      } else {
         var3 = true;
      }

      $Gson$Preconditions.a(var3);
      if (var2 instanceof JsonDeserializer || var2 instanceof JsonSerializer) {
         this.f.add(TreeTypeAdapter.a(var1, var2));
      }

      if (var2 instanceof TypeAdapter) {
         this.e.add(TypeAdapters.b(var1, (TypeAdapter)var2));
      }

      return this;
   }

   public GsonBuilder a(String var1) {
      this.h = var1;
      return this;
   }

   public GsonBuilder a(Type var1, Object var2) {
      boolean var3;
      if (!(var2 instanceof JsonSerializer) && !(var2 instanceof JsonDeserializer) && !(var2 instanceof InstanceCreator) && !(var2 instanceof TypeAdapter)) {
         var3 = false;
      } else {
         var3 = true;
      }

      $Gson$Preconditions.a(var3);
      if (var2 instanceof InstanceCreator) {
         this.d.put(var1, (InstanceCreator<?>)var2);
      }

      if (var2 instanceof JsonSerializer || var2 instanceof JsonDeserializer) {
         TypeToken var4 = TypeToken.get(var1);
         this.e.add(TreeTypeAdapter.a(var4, var2));
      }

      if (var2 instanceof TypeAdapter) {
         this.e.add(TypeAdapters.a(TypeToken.get(var1), (TypeAdapter<?>)var2));
      }

      return this;
   }
}

package com.mixpanel.android.viewcrawler;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import com.mixpanel.android.mpmetrics.ResourceIds;
import com.mixpanel.android.util.ImageStore;
import com.mixpanel.android.util.JSONUtils;
import com.mixpanel.android.util.MPLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class EditProtocol {
   private static final Class<?>[] e = new Class[0];
   private static final List<Pathfinder.PathElement> f = Collections.emptyList();
   private final Context a;
   private final ResourceIds b;
   private final ImageStore c;
   private final ViewVisitor.OnLayoutErrorListener d;

   public EditProtocol(Context var1, ResourceIds var2, ImageStore var3, ViewVisitor.OnLayoutErrorListener var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   private Drawable a(JSONObject param1, List<String> param2) throws EditProtocol.BadInstructionsException, EditProtocol.CantGetEditAssetsException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 7
      // 03: aload 1
      // 04: ldc "url"
      // 06: invokevirtual org/json/JSONObject.isNull (Ljava/lang/String;)Z
      // 09: ifeq 24
      // 0c: new com/mixpanel/android/viewcrawler/EditProtocol$BadInstructionsException
      // 0f: astore 1
      // 10: aload 1
      // 11: ldc "Can't construct a BitmapDrawable with a null url"
      // 13: invokespecial com/mixpanel/android/viewcrawler/EditProtocol$BadInstructionsException.<init> (Ljava/lang/String;)V
      // 16: aload 1
      // 17: athrow
      // 18: astore 1
      // 19: new com/mixpanel/android/viewcrawler/EditProtocol$BadInstructionsException
      // 1c: dup
      // 1d: ldc "Couldn't read drawable description"
      // 1f: aload 1
      // 20: invokespecial com/mixpanel/android/viewcrawler/EditProtocol$BadInstructionsException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 23: athrow
      // 24: aload 1
      // 25: ldc "url"
      // 27: invokevirtual org/json/JSONObject.getString (Ljava/lang/String;)Ljava/lang/String;
      // 2a: astore 9
      // 2c: aload 1
      // 2d: ldc "dimensions"
      // 2f: invokevirtual org/json/JSONObject.isNull (Ljava/lang/String;)Z
      // 32: istore 8
      // 34: iload 8
      // 36: ifeq 75
      // 39: bipush 0
      // 3a: istore 5
      // 3c: bipush 0
      // 3d: istore 6
      // 3f: bipush 0
      // 40: istore 4
      // 42: bipush 0
      // 43: istore 3
      // 44: aload 0
      // 45: getfield com/mixpanel/android/viewcrawler/EditProtocol.c Lcom/mixpanel/android/util/ImageStore;
      // 48: aload 9
      // 4a: invokevirtual com/mixpanel/android/util/ImageStore.b (Ljava/lang/String;)Landroid/graphics/Bitmap;
      // 4d: astore 1
      // 4e: aload 2
      // 4f: aload 9
      // 51: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 56: pop
      // 57: new android/graphics/drawable/BitmapDrawable
      // 5a: astore 2
      // 5b: aload 2
      // 5c: invokestatic android/content/res/Resources.getSystem ()Landroid/content/res/Resources;
      // 5f: aload 1
      // 60: invokespecial android/graphics/drawable/BitmapDrawable.<init> (Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
      // 63: iload 7
      // 65: ifeq 73
      // 68: aload 2
      // 69: iload 5
      // 6b: iload 4
      // 6d: iload 6
      // 6f: iload 3
      // 70: invokevirtual android/graphics/drawable/Drawable.setBounds (IIII)V
      // 73: aload 2
      // 74: areturn
      // 75: aload 1
      // 76: ldc "dimensions"
      // 78: invokevirtual org/json/JSONObject.getJSONObject (Ljava/lang/String;)Lorg/json/JSONObject;
      // 7b: astore 1
      // 7c: aload 1
      // 7d: ldc "left"
      // 7f: invokevirtual org/json/JSONObject.getInt (Ljava/lang/String;)I
      // 82: istore 5
      // 84: aload 1
      // 85: ldc "right"
      // 87: invokevirtual org/json/JSONObject.getInt (Ljava/lang/String;)I
      // 8a: istore 6
      // 8c: aload 1
      // 8d: ldc "top"
      // 8f: invokevirtual org/json/JSONObject.getInt (Ljava/lang/String;)I
      // 92: istore 4
      // 94: aload 1
      // 95: ldc "bottom"
      // 97: invokevirtual org/json/JSONObject.getInt (Ljava/lang/String;)I
      // 9a: istore 3
      // 9b: bipush 1
      // 9c: istore 7
      // 9e: goto 44
      // a1: astore 1
      // a2: new com/mixpanel/android/viewcrawler/EditProtocol$CantGetEditAssetsException
      // a5: astore 2
      // a6: aload 2
      // a7: aload 1
      // a8: invokevirtual com/mixpanel/android/util/ImageStore$CantGetImageException.getMessage ()Ljava/lang/String;
      // ab: aload 1
      // ac: invokevirtual com/mixpanel/android/util/ImageStore$CantGetImageException.getCause ()Ljava/lang/Throwable;
      // af: invokespecial com/mixpanel/android/viewcrawler/EditProtocol$CantGetEditAssetsException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // b2: aload 2
      // b3: athrow
      // try (2 -> 13): 13 org/json/JSONException
      // try (20 -> 28): 13 org/json/JSONException
      // try (38 -> 47): 86 com/mixpanel/android/util/ImageStore$CantGetImageException
      // try (38 -> 47): 13 org/json/JSONException
      // try (47 -> 53): 13 org/json/JSONException
      // try (55 -> 61): 13 org/json/JSONException
      // try (63 -> 83): 13 org/json/JSONException
      // try (87 -> 97): 13 org/json/JSONException
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private PropertyDescription a(Class<?> var1, JSONObject var2) throws EditProtocol.BadInstructionsException {
      String var4 = null;

      Caller var3;
      String var5;
      label42: {
         try {
            var5 = var2.getString("name");
            if (var2.has("get")) {
               JSONObject var17 = var2.getJSONObject("get");
               String var6 = var17.getString("selector");
               Class var7 = Class.forName(var17.getJSONObject("result").getString("type"));
               var3 = new Caller(var1, var6, e, var7);
               break label42;
            }
         } catch (NoSuchMethodException var14) {
            throw new EditProtocol.BadInstructionsException("Can't create property reader", var14);
         } catch (JSONException var15) {
            throw new EditProtocol.BadInstructionsException("Can't read property JSON", var15);
         } catch (ClassNotFoundException var16) {
            throw new EditProtocol.BadInstructionsException("Can't read property JSON, relevant arg/return class not found", var16);
         }

         var3 = null;
      }

      try {
         if (var2.has("set")) {
            var4 = var2.getJSONObject("set").getString("selector");
         }
      } catch (NoSuchMethodException var11) {
         throw new EditProtocol.BadInstructionsException("Can't create property reader", var11);
      } catch (JSONException var12) {
         throw new EditProtocol.BadInstructionsException("Can't read property JSON", var12);
      } catch (ClassNotFoundException var13) {
         throw new EditProtocol.BadInstructionsException("Can't read property JSON, relevant arg/return class not found", var13);
      }

      try {
         return new PropertyDescription(var5, var1, var3, var4);
      } catch (NoSuchMethodException var8) {
         throw new EditProtocol.BadInstructionsException("Can't create property reader", var8);
      } catch (JSONException var9) {
         throw new EditProtocol.BadInstructionsException("Can't read property JSON", var9);
      } catch (ClassNotFoundException var10) {
         throw new EditProtocol.BadInstructionsException("Can't read property JSON, relevant arg/return class not found", var10);
      }
   }

   private Integer a(int var1, String var2, ResourceIds var3) {
      Object var5 = null;
      int var4;
      if (var2 != null) {
         if (!var3.a(var2)) {
            MPLog.d(
               "MixpanelAPI.EProtocol",
               "Path element contains an id name not known to the system. No views will be matched.\nMake sure that you're not stripping your packages R class out with proguard.\nid name was \""
                  + var2
                  + "\""
            );
            return (Integer)var5;
         }

         var4 = var3.b(var2);
      } else {
         var4 = -1;
      }

      Integer var6;
      if (-1 != var4 && -1 != var1 && var4 != var1) {
         MPLog.e("MixpanelAPI.EProtocol", "Path contains both a named and an explicit id, and they don't match. No views will be matched.");
         var6 = (Integer)var5;
      } else if (-1 != var4) {
         var6 = var4;
      } else {
         var6 = var1;
      }

      return var6;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private Object a(Object var1, String var2, List<String> var3) throws EditProtocol.BadInstructionsException, EditProtocol.CantGetEditAssetsException {
      try {
         if ("java.lang.CharSequence".equals(var2)) {
            return var1;
         }
      } catch (ClassCastException var14) {
         throw new EditProtocol.BadInstructionsException("Couldn't interpret <" + var1 + "> as " + var2);
      }

      EditProtocol.BadInstructionsException var4 = (EditProtocol.BadInstructionsException)var1;

      try {
         if ("boolean".equals(var2)) {
            return var4;
         }
      } catch (ClassCastException var9) {
         throw new EditProtocol.BadInstructionsException("Couldn't interpret <" + var1 + "> as " + var2);
      }

      var4 = var1;

      label99: {
         try {
            if ("java.lang.Boolean".equals(var2)) {
               return var4;
            }

            if ("int".equals(var2) || "java.lang.Integer".equals(var2)) {
               break label99;
            }
         } catch (ClassCastException var13) {
            throw new EditProtocol.BadInstructionsException("Couldn't interpret <" + var1 + "> as " + var2);
         }

         label101: {
            try {
               if ("float".equals(var2) || "java.lang.Float".equals(var2)) {
                  break label101;
               }
            } catch (ClassCastException var12) {
               throw new EditProtocol.BadInstructionsException("Couldn't interpret <" + var1 + "> as " + var2);
            }

            try {
               if ("android.graphics.drawable.Drawable".equals(var2)) {
                  return this.a((JSONObject)var1, var3);
               }
            } catch (ClassCastException var11) {
               throw new EditProtocol.BadInstructionsException("Couldn't interpret <" + var1 + "> as " + var2);
            }

            try {
               if ("android.graphics.drawable.BitmapDrawable".equals(var2)) {
                  return this.a((JSONObject)var1, var3);
               }
            } catch (ClassCastException var8) {
               throw new EditProtocol.BadInstructionsException("Couldn't interpret <" + var1 + "> as " + var2);
            }

            try {
               if ("android.graphics.drawable.ColorDrawable".equals(var2)) {
                  return new ColorDrawable(((Number)var1).intValue());
               }
            } catch (ClassCastException var10) {
               throw new EditProtocol.BadInstructionsException("Couldn't interpret <" + var1 + "> as " + var2);
            }

            try {
               StringBuilder var15 = new StringBuilder();
               var4 = new EditProtocol.BadInstructionsException(
                  var15.append("Don't know how to interpret type ").append(var2).append(" (arg was ").append(var1).append(")").toString()
               );
               throw var4;
            } catch (ClassCastException var5) {
               throw new EditProtocol.BadInstructionsException("Couldn't interpret <" + var1 + "> as " + var2);
            }
         }

         try {
            return ((Number)var1).floatValue();
         } catch (ClassCastException var6) {
            throw new EditProtocol.BadInstructionsException("Couldn't interpret <" + var1 + "> as " + var2);
         }
      }

      try {
         return ((Number)var1).intValue();
      } catch (ClassCastException var7) {
         throw new EditProtocol.BadInstructionsException("Couldn't interpret <" + var1 + "> as " + var2);
      }
   }

   public EditProtocol.Edit a(JSONObject param1) throws EditProtocol.BadInstructionsException, EditProtocol.CantGetEditAssetsException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: bipush 0
      // 001: istore 2
      // 002: new java/util/ArrayList
      // 005: dup
      // 006: invokespecial java/util/ArrayList.<init> ()V
      // 009: astore 5
      // 00b: aload 0
      // 00c: aload 1
      // 00d: ldc_w "path"
      // 010: invokevirtual org/json/JSONObject.getJSONArray (Ljava/lang/String;)Lorg/json/JSONArray;
      // 013: aload 0
      // 014: getfield com/mixpanel/android/viewcrawler/EditProtocol.b Lcom/mixpanel/android/mpmetrics/ResourceIds;
      // 017: invokevirtual com/mixpanel/android/viewcrawler/EditProtocol.a (Lorg/json/JSONArray;Lcom/mixpanel/android/mpmetrics/ResourceIds;)Ljava/util/List;
      // 01a: astore 6
      // 01c: aload 6
      // 01e: invokeinterface java/util/List.size ()I 1
      // 023: ifne 040
      // 026: new com/mixpanel/android/viewcrawler/EditProtocol$InapplicableInstructionsException
      // 029: astore 1
      // 02a: aload 1
      // 02b: ldc_w "Edit will not be bound to any element in the UI."
      // 02e: invokespecial com/mixpanel/android/viewcrawler/EditProtocol$InapplicableInstructionsException.<init> (Ljava/lang/String;)V
      // 031: aload 1
      // 032: athrow
      // 033: astore 1
      // 034: new com/mixpanel/android/viewcrawler/EditProtocol$BadInstructionsException
      // 037: dup
      // 038: ldc_w "Can't create property mutator"
      // 03b: aload 1
      // 03c: invokespecial com/mixpanel/android/viewcrawler/EditProtocol$BadInstructionsException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 03f: athrow
      // 040: aload 1
      // 041: ldc_w "change_type"
      // 044: invokevirtual org/json/JSONObject.getString (Ljava/lang/String;)Ljava/lang/String;
      // 047: ldc_w "property"
      // 04a: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 04d: ifeq 14d
      // 050: aload 1
      // 051: ldc_w "property"
      // 054: invokevirtual org/json/JSONObject.getJSONObject (Ljava/lang/String;)Lorg/json/JSONObject;
      // 057: ldc_w "classname"
      // 05a: invokevirtual org/json/JSONObject.getString (Ljava/lang/String;)Ljava/lang/String;
      // 05d: astore 4
      // 05f: aload 4
      // 061: ifnonnull 07e
      // 064: new com/mixpanel/android/viewcrawler/EditProtocol$BadInstructionsException
      // 067: astore 1
      // 068: aload 1
      // 069: ldc_w "Can't bind an edit property without a target class"
      // 06c: invokespecial com/mixpanel/android/viewcrawler/EditProtocol$BadInstructionsException.<init> (Ljava/lang/String;)V
      // 06f: aload 1
      // 070: athrow
      // 071: astore 1
      // 072: new com/mixpanel/android/viewcrawler/EditProtocol$BadInstructionsException
      // 075: dup
      // 076: ldc_w "Can't interpret instructions due to JSONException"
      // 079: aload 1
      // 07a: invokespecial com/mixpanel/android/viewcrawler/EditProtocol$BadInstructionsException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 07d: athrow
      // 07e: aload 4
      // 080: invokestatic java/lang/Class.forName (Ljava/lang/String;)Ljava/lang/Class;
      // 083: astore 7
      // 085: aload 0
      // 086: aload 7
      // 088: aload 1
      // 089: ldc_w "property"
      // 08c: invokevirtual org/json/JSONObject.getJSONObject (Ljava/lang/String;)Lorg/json/JSONObject;
      // 08f: invokespecial com/mixpanel/android/viewcrawler/EditProtocol.a (Ljava/lang/Class;Lorg/json/JSONObject;)Lcom/mixpanel/android/viewcrawler/PropertyDescription;
      // 092: astore 4
      // 094: aload 1
      // 095: ldc_w "args"
      // 098: invokevirtual org/json/JSONObject.getJSONArray (Ljava/lang/String;)Lorg/json/JSONArray;
      // 09b: astore 1
      // 09c: aload 1
      // 09d: invokevirtual org/json/JSONArray.length ()I
      // 0a0: anewarray 4
      // 0a3: astore 8
      // 0a5: iload 2
      // 0a6: aload 1
      // 0a7: invokevirtual org/json/JSONArray.length ()I
      // 0aa: if_icmpge 0f8
      // 0ad: aload 1
      // 0ae: iload 2
      // 0af: invokevirtual org/json/JSONArray.getJSONArray (I)Lorg/json/JSONArray;
      // 0b2: astore 7
      // 0b4: aload 8
      // 0b6: iload 2
      // 0b7: aload 0
      // 0b8: aload 7
      // 0ba: bipush 0
      // 0bb: invokevirtual org/json/JSONArray.get (I)Ljava/lang/Object;
      // 0be: aload 7
      // 0c0: bipush 1
      // 0c1: invokevirtual org/json/JSONArray.getString (I)Ljava/lang/String;
      // 0c4: aload 5
      // 0c6: invokespecial com/mixpanel/android/viewcrawler/EditProtocol.a (Ljava/lang/Object;Ljava/lang/String;Ljava/util/List;)Ljava/lang/Object;
      // 0c9: aastore
      // 0ca: iinc 2 1
      // 0cd: goto 0a5
      // 0d0: astore 5
      // 0d2: new com/mixpanel/android/viewcrawler/EditProtocol$BadInstructionsException
      // 0d5: astore 6
      // 0d7: new java/lang/StringBuilder
      // 0da: astore 1
      // 0db: aload 1
      // 0dc: invokespecial java/lang/StringBuilder.<init> ()V
      // 0df: aload 6
      // 0e1: aload 1
      // 0e2: ldc_w "Can't find class for visit path: "
      // 0e5: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e8: aload 4
      // 0ea: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0ed: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0f0: aload 5
      // 0f2: invokespecial com/mixpanel/android/viewcrawler/EditProtocol$BadInstructionsException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 0f5: aload 6
      // 0f7: athrow
      // 0f8: aload 4
      // 0fa: aload 8
      // 0fc: invokevirtual com/mixpanel/android/viewcrawler/PropertyDescription.a ([Ljava/lang/Object;)Lcom/mixpanel/android/viewcrawler/Caller;
      // 0ff: astore 1
      // 100: aload 1
      // 101: ifnonnull 131
      // 104: new com/mixpanel/android/viewcrawler/EditProtocol$BadInstructionsException
      // 107: astore 5
      // 109: new java/lang/StringBuilder
      // 10c: astore 1
      // 10d: aload 1
      // 10e: invokespecial java/lang/StringBuilder.<init> ()V
      // 111: aload 5
      // 113: aload 1
      // 114: ldc_w "Can't update a read-only property "
      // 117: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 11a: aload 4
      // 11c: getfield com/mixpanel/android/viewcrawler/PropertyDescription.a Ljava/lang/String;
      // 11f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 122: ldc_w " (add a mutator to make this work)"
      // 125: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 128: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 12b: invokespecial com/mixpanel/android/viewcrawler/EditProtocol$BadInstructionsException.<init> (Ljava/lang/String;)V
      // 12e: aload 5
      // 130: athrow
      // 131: new com/mixpanel/android/viewcrawler/ViewVisitor$PropertySetVisitor
      // 134: dup
      // 135: aload 6
      // 137: aload 1
      // 138: aload 4
      // 13a: getfield com/mixpanel/android/viewcrawler/PropertyDescription.c Lcom/mixpanel/android/viewcrawler/Caller;
      // 13d: invokespecial com/mixpanel/android/viewcrawler/ViewVisitor$PropertySetVisitor.<init> (Ljava/util/List;Lcom/mixpanel/android/viewcrawler/Caller;Lcom/mixpanel/android/viewcrawler/Caller;)V
      // 140: astore 1
      // 141: new com/mixpanel/android/viewcrawler/EditProtocol$Edit
      // 144: dup
      // 145: aload 1
      // 146: aload 5
      // 148: aconst_null
      // 149: invokespecial com/mixpanel/android/viewcrawler/EditProtocol$Edit.<init> (Lcom/mixpanel/android/viewcrawler/ViewVisitor;Ljava/util/List;Lcom/mixpanel/android/viewcrawler/EditProtocol$1;)V
      // 14c: areturn
      // 14d: aload 1
      // 14e: ldc_w "change_type"
      // 151: invokevirtual org/json/JSONObject.getString (Ljava/lang/String;)Ljava/lang/String;
      // 154: ldc_w "layout"
      // 157: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 15a: ifeq 25b
      // 15d: aload 1
      // 15e: ldc_w "args"
      // 161: invokevirtual org/json/JSONObject.getJSONArray (Ljava/lang/String;)Lorg/json/JSONArray;
      // 164: astore 8
      // 166: new java/util/ArrayList
      // 169: astore 7
      // 16b: aload 7
      // 16d: invokespecial java/util/ArrayList.<init> ()V
      // 170: aload 8
      // 172: invokevirtual org/json/JSONArray.length ()I
      // 175: istore 3
      // 176: bipush 0
      // 177: istore 2
      // 178: iload 2
      // 179: iload 3
      // 17a: if_icmpge 242
      // 17d: aload 8
      // 17f: iload 2
      // 180: invokevirtual org/json/JSONArray.optJSONObject (I)Lorg/json/JSONObject;
      // 183: astore 11
      // 185: aload 11
      // 187: ldc_w "view_id_name"
      // 18a: invokevirtual org/json/JSONObject.getString (Ljava/lang/String;)Ljava/lang/String;
      // 18d: astore 9
      // 18f: aload 11
      // 191: ldc_w "anchor_id_name"
      // 194: invokevirtual org/json/JSONObject.getString (Ljava/lang/String;)Ljava/lang/String;
      // 197: astore 12
      // 199: aload 0
      // 19a: bipush -1
      // 19b: aload 9
      // 19d: aload 0
      // 19e: getfield com/mixpanel/android/viewcrawler/EditProtocol.b Lcom/mixpanel/android/mpmetrics/ResourceIds;
      // 1a1: invokespecial com/mixpanel/android/viewcrawler/EditProtocol.a (ILjava/lang/String;Lcom/mixpanel/android/mpmetrics/ResourceIds;)Ljava/lang/Integer;
      // 1a4: astore 10
      // 1a6: aload 12
      // 1a8: ldc_w "0"
      // 1ab: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 1ae: ifeq 1f7
      // 1b1: bipush 0
      // 1b2: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 1b5: astore 4
      // 1b7: aload 10
      // 1b9: ifnull 1c1
      // 1bc: aload 4
      // 1be: ifnonnull 21b
      // 1c1: new java/lang/StringBuilder
      // 1c4: astore 4
      // 1c6: aload 4
      // 1c8: invokespecial java/lang/StringBuilder.<init> ()V
      // 1cb: ldc "MixpanelAPI.EProtocol"
      // 1cd: aload 4
      // 1cf: ldc_w "View ("
      // 1d2: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1d5: aload 9
      // 1d7: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1da: ldc_w ") or anchor ("
      // 1dd: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1e0: aload 12
      // 1e2: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1e5: ldc_w ") not found."
      // 1e8: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1eb: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1ee: invokestatic com/mixpanel/android/util/MPLog.d (Ljava/lang/String;Ljava/lang/String;)V
      // 1f1: iinc 2 1
      // 1f4: goto 178
      // 1f7: aload 12
      // 1f9: ldc_w "-1"
      // 1fc: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 1ff: ifeq 20b
      // 202: bipush -1
      // 203: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 206: astore 4
      // 208: goto 1b7
      // 20b: aload 0
      // 20c: bipush -1
      // 20d: aload 12
      // 20f: aload 0
      // 210: getfield com/mixpanel/android/viewcrawler/EditProtocol.b Lcom/mixpanel/android/mpmetrics/ResourceIds;
      // 213: invokespecial com/mixpanel/android/viewcrawler/EditProtocol.a (ILjava/lang/String;Lcom/mixpanel/android/mpmetrics/ResourceIds;)Ljava/lang/Integer;
      // 216: astore 4
      // 218: goto 1b7
      // 21b: new com/mixpanel/android/viewcrawler/ViewVisitor$LayoutRule
      // 21e: astore 9
      // 220: aload 9
      // 222: aload 10
      // 224: invokevirtual java/lang/Integer.intValue ()I
      // 227: aload 11
      // 229: ldc_w "verb"
      // 22c: invokevirtual org/json/JSONObject.getInt (Ljava/lang/String;)I
      // 22f: aload 4
      // 231: invokevirtual java/lang/Integer.intValue ()I
      // 234: invokespecial com/mixpanel/android/viewcrawler/ViewVisitor$LayoutRule.<init> (III)V
      // 237: aload 7
      // 239: aload 9
      // 23b: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 23e: pop
      // 23f: goto 1f1
      // 242: new com/mixpanel/android/viewcrawler/ViewVisitor$LayoutUpdateVisitor
      // 245: dup
      // 246: aload 6
      // 248: aload 7
      // 24a: aload 1
      // 24b: ldc "name"
      // 24d: invokevirtual org/json/JSONObject.getString (Ljava/lang/String;)Ljava/lang/String;
      // 250: aload 0
      // 251: getfield com/mixpanel/android/viewcrawler/EditProtocol.d Lcom/mixpanel/android/viewcrawler/ViewVisitor$OnLayoutErrorListener;
      // 254: invokespecial com/mixpanel/android/viewcrawler/ViewVisitor$LayoutUpdateVisitor.<init> (Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/mixpanel/android/viewcrawler/ViewVisitor$OnLayoutErrorListener;)V
      // 257: astore 1
      // 258: goto 141
      // 25b: new com/mixpanel/android/viewcrawler/EditProtocol$BadInstructionsException
      // 25e: astore 1
      // 25f: aload 1
      // 260: ldc_w "Can't figure out the edit type"
      // 263: invokespecial com/mixpanel/android/viewcrawler/EditProtocol$BadInstructionsException.<init> (Ljava/lang/String;)V
      // 266: aload 1
      // 267: athrow
      // try (6 -> 24): 24 java/lang/NoSuchMethodException
      // try (6 -> 24): 52 org/json/JSONException
      // try (31 -> 43): 24 java/lang/NoSuchMethodException
      // try (31 -> 43): 52 org/json/JSONException
      // try (45 -> 52): 24 java/lang/NoSuchMethodException
      // try (45 -> 52): 52 org/json/JSONException
      // try (59 -> 62): 99 java/lang/ClassNotFoundException
      // try (59 -> 62): 24 java/lang/NoSuchMethodException
      // try (59 -> 62): 52 org/json/JSONException
      // try (62 -> 77): 24 java/lang/NoSuchMethodException
      // try (62 -> 77): 52 org/json/JSONException
      // try (77 -> 97): 24 java/lang/NoSuchMethodException
      // try (77 -> 97): 52 org/json/JSONException
      // try (100 -> 117): 24 java/lang/NoSuchMethodException
      // try (100 -> 117): 52 org/json/JSONException
      // try (117 -> 121): 24 java/lang/NoSuchMethodException
      // try (117 -> 121): 52 org/json/JSONException
      // try (123 -> 142): 24 java/lang/NoSuchMethodException
      // try (123 -> 142): 52 org/json/JSONException
      // try (142 -> 150): 24 java/lang/NoSuchMethodException
      // try (142 -> 150): 52 org/json/JSONException
      // try (157 -> 174): 24 java/lang/NoSuchMethodException
      // try (157 -> 174): 52 org/json/JSONException
      // try (179 -> 205): 24 java/lang/NoSuchMethodException
      // try (179 -> 205): 52 org/json/JSONException
      // try (209 -> 227): 24 java/lang/NoSuchMethodException
      // try (209 -> 227): 52 org/json/JSONException
      // try (229 -> 236): 24 java/lang/NoSuchMethodException
      // try (229 -> 236): 52 org/json/JSONException
      // try (237 -> 244): 24 java/lang/NoSuchMethodException
      // try (237 -> 244): 52 org/json/JSONException
      // try (245 -> 260): 24 java/lang/NoSuchMethodException
      // try (245 -> 260): 52 org/json/JSONException
      // try (261 -> 272): 24 java/lang/NoSuchMethodException
      // try (261 -> 272): 52 org/json/JSONException
      // try (273 -> 280): 24 java/lang/NoSuchMethodException
      // try (273 -> 280): 52 org/json/JSONException
   }

   public ViewVisitor a(JSONObject var1, ViewVisitor.OnEventListener var2) throws EditProtocol.BadInstructionsException {
      try {
         String var3 = var1.getString("event_name");
         String var4 = var1.getString("event_type");
         List var6 = this.a(var1.getJSONArray("path"), this.b);
         if (var6.size() == 0) {
            StringBuilder var11 = new StringBuilder();
            EditProtocol.InapplicableInstructionsException var9 = new EditProtocol.InapplicableInstructionsException(
               var11.append("event '").append(var3).append("' will not be bound to any element in the UI.").toString()
            );
            throw var9;
         }

         ViewVisitor.EventTriggeringVisitor var7;
         if ("click".equals(var4)) {
            var7 = new ViewVisitor.AddAccessibilityEventVisitor(var6, 1, var3, var2);
         } else if ("selected".equals(var4)) {
            var7 = new ViewVisitor.AddAccessibilityEventVisitor(var6, 4, var3, var2);
         } else if ("text_changed".equals(var4)) {
            var7 = new ViewVisitor.AddTextChangeListener(var6, var3, var2);
         } else {
            if (!"detected".equals(var4)) {
               StringBuilder var8 = new StringBuilder();
               EditProtocol.BadInstructionsException var10 = new EditProtocol.BadInstructionsException(
                  var8.append("Mixpanel can't track event type \"").append(var4).append("\"").toString()
               );
               throw var10;
            }

            var7 = new ViewVisitor.ViewDetectorVisitor(var6, var3, var2);
         }

         return var7;
      } catch (JSONException var5) {
         throw new EditProtocol.BadInstructionsException("Can't interpret instructions due to JSONException", var5);
      }
   }

   List<Pathfinder.PathElement> a(JSONArray var1, ResourceIds var2) throws JSONException {
      ArrayList var7 = new ArrayList();
      int var3 = 0;

      while (true) {
         if (var3 >= var1.length()) {
            var13 = var7;
            break;
         }

         JSONObject var11 = var1.getJSONObject(var3);
         String var10 = JSONUtils.a(var11, "prefix");
         String var9 = JSONUtils.a(var11, "view_class");
         int var6 = var11.optInt("index", -1);
         String var8 = JSONUtils.a(var11, "contentDescription");
         int var5 = var11.optInt("id", -1);
         String var12 = JSONUtils.a(var11, "mp_id_name");
         String var15 = JSONUtils.a(var11, "tag");
         byte var4;
         if ("shortest".equals(var10)) {
            var4 = 1;
         } else {
            if (var10 != null) {
               MPLog.d("MixpanelAPI.EProtocol", "Unrecognized prefix type \"" + var10 + "\". No views will be matched");
               var13 = f;
               break;
            }

            var4 = 0;
         }

         Integer var14 = this.a(var5, var12, var2);
         if (var14 == null) {
            var13 = f;
            break;
         }

         var7.add(new Pathfinder.PathElement(var4, var9, var6, var14, var8, var15));
         var3++;
      }

      return var13;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public ViewSnapshot b(JSONObject var1) throws EditProtocol.BadInstructionsException {
      ArrayList var4 = new ArrayList();

      try {
         var15 = var1.getJSONObject("config").getJSONArray("classes");
      } catch (JSONException var9) {
         throw new EditProtocol.BadInstructionsException("Can't read snapshot configuration", var9);
      } catch (ClassNotFoundException var10) {
         throw new EditProtocol.BadInstructionsException("Can't resolve types for snapshot configuration", var10);
      }

      int var2 = 0;

      while (true) {
         Class var5;
         JSONArray var16;
         try {
            if (var2 >= var15.length()) {
               break;
            }

            JSONObject var6 = var15.getJSONObject(var2);
            var5 = Class.forName(var6.getString("name"));
            var16 = var6.getJSONArray("properties");
         } catch (JSONException var11) {
            throw new EditProtocol.BadInstructionsException("Can't read snapshot configuration", var11);
         } catch (ClassNotFoundException var12) {
            throw new EditProtocol.BadInstructionsException("Can't resolve types for snapshot configuration", var12);
         }

         int var3 = 0;

         while (true) {
            label48: {
               try {
                  if (var3 < var16.length()) {
                     var4.add(this.a(var5, var16.getJSONObject(var3)));
                     break label48;
                  }
               } catch (JSONException var13) {
                  throw new EditProtocol.BadInstructionsException("Can't read snapshot configuration", var13);
               } catch (ClassNotFoundException var14) {
                  throw new EditProtocol.BadInstructionsException("Can't resolve types for snapshot configuration", var14);
               }

               var2++;
               break;
            }

            var3++;
         }
      }

      try {
         return new ViewSnapshot(this.a, var4, this.b);
      } catch (JSONException var7) {
         throw new EditProtocol.BadInstructionsException("Can't read snapshot configuration", var7);
      } catch (ClassNotFoundException var8) {
         throw new EditProtocol.BadInstructionsException("Can't resolve types for snapshot configuration", var8);
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public Pair<String, Object> c(JSONObject var1) throws EditProtocol.BadInstructionsException {
      label68: {
         String var2;
         label70: {
            String var15;
            label74: {
               try {
                  var2 = var1.getString("name");
                  var15 = var1.getString("type");
                  if ("number".equals(var15)) {
                     var15 = var1.getString("encoding");
                     if (!"d".equals(var15)) {
                        break label74;
                     }

                     var12 = var1.getDouble("value");
                     break label70;
                  }
               } catch (JSONException var11) {
                  throw new EditProtocol.BadInstructionsException("Can't read tweak update", var11);
               }

               try {
                  if ("boolean".equals(var15)) {
                     var12 = var1.getBoolean("value");
                     break label70;
                  }
               } catch (JSONException var10) {
                  throw new EditProtocol.BadInstructionsException("Can't read tweak update", var10);
               }

               try {
                  if ("string".equals(var15)) {
                     var12 = var1.getString("value");
                     break label70;
                  }
               } catch (JSONException var9) {
                  throw new EditProtocol.BadInstructionsException("Can't read tweak update", var9);
               }

               try {
                  StringBuilder var4 = new StringBuilder();
                  EditProtocol.BadInstructionsException var13 = new EditProtocol.BadInstructionsException(
                     var4.append("Unrecognized tweak type ").append(var15).append(" in: ").append(var1).toString()
                  );
                  throw var13;
               } catch (JSONException var7) {
                  throw new EditProtocol.BadInstructionsException("Can't read tweak update", var7);
               }
            }

            try {
               if (!"l".equals(var15)) {
                  break label68;
               }

               var12 = var1.getLong("value");
            } catch (JSONException var8) {
               throw new EditProtocol.BadInstructionsException("Can't read tweak update", var8);
            }
         }

         try {
            return new Pair(var2, var12);
         } catch (JSONException var6) {
            throw new EditProtocol.BadInstructionsException("Can't read tweak update", var6);
         }
      }

      try {
         StringBuilder var14 = new StringBuilder();
         EditProtocol.BadInstructionsException var16 = new EditProtocol.BadInstructionsException(
            var14.append("number must have encoding of type \"l\" for long or \"d\" for double in: ").append(var1).toString()
         );
         throw var16;
      } catch (JSONException var5) {
         throw new EditProtocol.BadInstructionsException("Can't read tweak update", var5);
      }
   }

   public static class BadInstructionsException extends Exception {
      public BadInstructionsException(String var1) {
         super(var1);
      }

      public BadInstructionsException(String var1, Throwable var2) {
         super(var1, var2);
      }
   }

   public static class CantGetEditAssetsException extends Exception {
      public CantGetEditAssetsException(String var1, Throwable var2) {
         super(var1, var2);
      }
   }

   public static class Edit {
      public final ViewVisitor a;
      public final List<String> b;

      private Edit(ViewVisitor var1, List<String> var2) {
         this.a = var1;
         this.b = var2;
      }
   }

   public static class InapplicableInstructionsException extends EditProtocol.BadInstructionsException {
      public InapplicableInstructionsException(String var1) {
         super(var1);
      }
   }
}

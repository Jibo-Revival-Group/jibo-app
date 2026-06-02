package com.mixpanel.android.mpmetrics;

import android.content.Context;
import com.mixpanel.android.viewcrawler.UpdatesFromMixpanel;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

class DecideMessages {
   private static final Set<Integer> h = new HashSet<>();
   private String a;
   private final String b;
   private final Set<Integer> c;
   private final List<InAppNotification> d;
   private final DecideMessages.OnNewResultsListener e;
   private final UpdatesFromMixpanel f;
   private JSONArray g;
   private Boolean i;
   private Context j;

   public DecideMessages(Context var1, String var2, DecideMessages.OnNewResultsListener var3, UpdatesFromMixpanel var4, HashSet<Integer> var5) {
      this.j = var1;
      this.b = var2;
      this.e = var3;
      this.f = var4;
      this.a = null;
      this.d = new LinkedList<>();
      this.c = new HashSet<>(var5);
      this.g = null;
   }

   public InAppNotification a(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/mixpanel/android/mpmetrics/DecideMessages.d Ljava/util/List;
      // 06: invokeinterface java/util/List.isEmpty ()Z 1
      // 0b: ifeq 1b
      // 0e: ldc "MixpanelAPI.DecideUpdts"
      // 10: ldc "No unseen notifications exist, none will be returned."
      // 12: invokestatic com/mixpanel/android/util/MPLog.a (Ljava/lang/String;Ljava/lang/String;)V
      // 15: aconst_null
      // 16: astore 2
      // 17: aload 0
      // 18: monitorexit
      // 19: aload 2
      // 1a: areturn
      // 1b: aload 0
      // 1c: getfield com/mixpanel/android/mpmetrics/DecideMessages.d Ljava/util/List;
      // 1f: bipush 0
      // 20: invokeinterface java/util/List.remove (I)Ljava/lang/Object; 2
      // 25: checkcast com/mixpanel/android/mpmetrics/InAppNotification
      // 28: astore 2
      // 29: iload 1
      // 2a: ifeq 40
      // 2d: aload 0
      // 2e: getfield com/mixpanel/android/mpmetrics/DecideMessages.d Ljava/util/List;
      // 31: aload 2
      // 32: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 37: pop
      // 38: goto 17
      // 3b: astore 2
      // 3c: aload 0
      // 3d: monitorexit
      // 3e: aload 2
      // 3f: athrow
      // 40: new java/lang/StringBuilder
      // 43: astore 3
      // 44: aload 3
      // 45: invokespecial java/lang/StringBuilder.<init> ()V
      // 48: ldc "MixpanelAPI.DecideUpdts"
      // 4a: aload 3
      // 4b: ldc "Recording notification "
      // 4d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 50: aload 2
      // 51: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 54: ldc " as seen."
      // 56: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 59: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 5c: invokestatic com/mixpanel/android/util/MPLog.a (Ljava/lang/String;Ljava/lang/String;)V
      // 5f: goto 17
      // try (2 -> 9): 29 null
      // try (15 -> 21): 29 null
      // try (23 -> 28): 29 null
      // try (34 -> 48): 29 null
   }

   public String a() {
      return this.b;
   }

   public void a(InAppNotification var1) {
      synchronized (this) {
         if (!MPConfig.a) {
            this.d.add(var1);
         }
      }
   }

   public void a(String var1) {
      synchronized (this) {
         if (this.a == null || !this.a.equals(var1)) {
            this.d.clear();
         }

         this.a = var1;
      }
   }

   public void a(List<InAppNotification> param1, JSONArray param2, JSONArray param3, boolean param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: bipush 1
      // 001: istore 7
      // 003: bipush 0
      // 004: istore 8
      // 006: aload 0
      // 007: monitorenter
      // 008: aload 3
      // 009: invokevirtual org/json/JSONArray.length ()I
      // 00c: istore 9
      // 00e: aload 0
      // 00f: getfield com/mixpanel/android/mpmetrics/DecideMessages.f Lcom/mixpanel/android/viewcrawler/UpdatesFromMixpanel;
      // 012: aload 2
      // 013: invokeinterface com/mixpanel/android/viewcrawler/UpdatesFromMixpanel.b (Lorg/json/JSONArray;)V 2
      // 018: aload 1
      // 019: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 01e: astore 11
      // 020: bipush 0
      // 021: istore 5
      // 023: aload 11
      // 025: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 02a: ifeq 06f
      // 02d: aload 11
      // 02f: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 034: checkcast com/mixpanel/android/mpmetrics/InAppNotification
      // 037: astore 2
      // 038: aload 2
      // 039: invokevirtual com/mixpanel/android/mpmetrics/InAppNotification.b ()I
      // 03c: istore 6
      // 03e: aload 0
      // 03f: getfield com/mixpanel/android/mpmetrics/DecideMessages.c Ljava/util/Set;
      // 042: iload 6
      // 044: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 047: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 04c: ifne 1e5
      // 04f: aload 0
      // 050: getfield com/mixpanel/android/mpmetrics/DecideMessages.c Ljava/util/Set;
      // 053: iload 6
      // 055: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 058: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 05d: pop
      // 05e: aload 0
      // 05f: getfield com/mixpanel/android/mpmetrics/DecideMessages.d Ljava/util/List;
      // 062: aload 2
      // 063: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 068: pop
      // 069: bipush 1
      // 06a: istore 5
      // 06c: goto 023
      // 06f: aload 0
      // 070: aload 3
      // 071: putfield com/mixpanel/android/mpmetrics/DecideMessages.g Lorg/json/JSONArray;
      // 074: bipush 0
      // 075: istore 6
      // 077: iload 6
      // 079: iload 9
      // 07b: if_icmpge 1df
      // 07e: aload 3
      // 07f: iload 6
      // 081: invokevirtual org/json/JSONArray.getJSONObject (I)Lorg/json/JSONObject;
      // 084: astore 2
      // 085: getstatic com/mixpanel/android/mpmetrics/DecideMessages.h Ljava/util/Set;
      // 088: aload 2
      // 089: ldc "id"
      // 08b: invokevirtual org/json/JSONObject.getInt (Ljava/lang/String;)I
      // 08e: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 091: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 096: istore 10
      // 098: iload 10
      // 09a: ifne 109
      // 09d: bipush 1
      // 09e: istore 6
      // 0a0: bipush 1
      // 0a1: istore 5
      // 0a3: iload 6
      // 0a5: ifeq 13b
      // 0a8: aload 0
      // 0a9: getfield com/mixpanel/android/mpmetrics/DecideMessages.g Lorg/json/JSONArray;
      // 0ac: ifnull 13b
      // 0af: getstatic com/mixpanel/android/mpmetrics/DecideMessages.h Ljava/util/Set;
      // 0b2: invokeinterface java/util/Set.clear ()V 1
      // 0b7: iload 8
      // 0b9: istore 6
      // 0bb: iload 6
      // 0bd: iload 9
      // 0bf: if_icmpge 13b
      // 0c2: aload 0
      // 0c3: getfield com/mixpanel/android/mpmetrics/DecideMessages.g Lorg/json/JSONArray;
      // 0c6: iload 6
      // 0c8: invokevirtual org/json/JSONArray.getJSONObject (I)Lorg/json/JSONObject;
      // 0cb: astore 2
      // 0cc: getstatic com/mixpanel/android/mpmetrics/DecideMessages.h Ljava/util/Set;
      // 0cf: aload 2
      // 0d0: ldc "id"
      // 0d2: invokevirtual org/json/JSONObject.getInt (Ljava/lang/String;)I
      // 0d5: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 0d8: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 0dd: pop
      // 0de: iinc 6 1
      // 0e1: goto 0bb
      // 0e4: astore 2
      // 0e5: new java/lang/StringBuilder
      // 0e8: astore 11
      // 0ea: aload 11
      // 0ec: invokespecial java/lang/StringBuilder.<init> ()V
      // 0ef: ldc "MixpanelAPI.DecideUpdts"
      // 0f1: aload 11
      // 0f3: ldc "Could not convert variants["
      // 0f5: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0f8: iload 6
      // 0fa: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 0fd: ldc "] into a JSONObject while comparing the new variants"
      // 0ff: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 102: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 105: aload 2
      // 106: invokestatic com/mixpanel/android/util/MPLog.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 109: iinc 6 1
      // 10c: goto 077
      // 10f: astore 11
      // 111: new java/lang/StringBuilder
      // 114: astore 2
      // 115: aload 2
      // 116: invokespecial java/lang/StringBuilder.<init> ()V
      // 119: ldc "MixpanelAPI.DecideUpdts"
      // 11b: aload 2
      // 11c: ldc "Could not convert variants["
      // 11e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 121: iload 6
      // 123: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 126: ldc "] into a JSONObject while updating the map"
      // 128: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 12b: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 12e: aload 11
      // 130: invokestatic com/mixpanel/android/util/MPLog.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 133: goto 0de
      // 136: astore 1
      // 137: aload 0
      // 138: monitorexit
      // 139: aload 1
      // 13a: athrow
      // 13b: iload 9
      // 13d: ifne 1dc
      // 140: new org/json/JSONArray
      // 143: astore 2
      // 144: aload 2
      // 145: invokespecial org/json/JSONArray.<init> ()V
      // 148: aload 0
      // 149: aload 2
      // 14a: putfield com/mixpanel/android/mpmetrics/DecideMessages.g Lorg/json/JSONArray;
      // 14d: getstatic com/mixpanel/android/mpmetrics/DecideMessages.h Ljava/util/Set;
      // 150: invokeinterface java/util/Set.size ()I 1
      // 155: ifle 1dc
      // 158: getstatic com/mixpanel/android/mpmetrics/DecideMessages.h Ljava/util/Set;
      // 15b: invokeinterface java/util/Set.clear ()V 1
      // 160: iload 7
      // 162: istore 5
      // 164: aload 0
      // 165: getfield com/mixpanel/android/mpmetrics/DecideMessages.f Lcom/mixpanel/android/viewcrawler/UpdatesFromMixpanel;
      // 168: aload 0
      // 169: getfield com/mixpanel/android/mpmetrics/DecideMessages.g Lorg/json/JSONArray;
      // 16c: invokeinterface com/mixpanel/android/viewcrawler/UpdatesFromMixpanel.a (Lorg/json/JSONArray;)V 2
      // 171: aload 0
      // 172: getfield com/mixpanel/android/mpmetrics/DecideMessages.i Ljava/lang/Boolean;
      // 175: ifnonnull 18b
      // 178: iload 4
      // 17a: ifne 18b
      // 17d: aload 0
      // 17e: getfield com/mixpanel/android/mpmetrics/DecideMessages.j Landroid/content/Context;
      // 181: invokestatic com/mixpanel/android/mpmetrics/MPDbAdapter.a (Landroid/content/Context;)Lcom/mixpanel/android/mpmetrics/MPDbAdapter;
      // 184: aload 0
      // 185: getfield com/mixpanel/android/mpmetrics/DecideMessages.b Ljava/lang/String;
      // 188: invokevirtual com/mixpanel/android/mpmetrics/MPDbAdapter.a (Ljava/lang/String;)V
      // 18b: aload 0
      // 18c: iload 4
      // 18e: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 191: putfield com/mixpanel/android/mpmetrics/DecideMessages.i Ljava/lang/Boolean;
      // 194: new java/lang/StringBuilder
      // 197: astore 2
      // 198: aload 2
      // 199: invokespecial java/lang/StringBuilder.<init> ()V
      // 19c: ldc "MixpanelAPI.DecideUpdts"
      // 19e: aload 2
      // 19f: ldc "New Decide content has become available. "
      // 1a1: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1a4: aload 1
      // 1a5: invokeinterface java/util/List.size ()I 1
      // 1aa: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 1ad: ldc " notifications and "
      // 1af: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1b2: aload 3
      // 1b3: invokevirtual org/json/JSONArray.length ()I
      // 1b6: invokevirtual java/lang/StringBuilder.append (I)Ljava/lang/StringBuilder;
      // 1b9: ldc " experiments have been added."
      // 1bb: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1be: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1c1: invokestatic com/mixpanel/android/util/MPLog.a (Ljava/lang/String;Ljava/lang/String;)V
      // 1c4: iload 5
      // 1c6: ifeq 1d9
      // 1c9: aload 0
      // 1ca: getfield com/mixpanel/android/mpmetrics/DecideMessages.e Lcom/mixpanel/android/mpmetrics/DecideMessages$OnNewResultsListener;
      // 1cd: ifnull 1d9
      // 1d0: aload 0
      // 1d1: getfield com/mixpanel/android/mpmetrics/DecideMessages.e Lcom/mixpanel/android/mpmetrics/DecideMessages$OnNewResultsListener;
      // 1d4: invokeinterface com/mixpanel/android/mpmetrics/DecideMessages$OnNewResultsListener.a ()V 1
      // 1d9: aload 0
      // 1da: monitorexit
      // 1db: return
      // 1dc: goto 164
      // 1df: bipush 0
      // 1e0: istore 6
      // 1e2: goto 0a3
      // 1e5: goto 06c
      // try (6 -> 16): 134 null
      // try (18 -> 45): 134 null
      // try (48 -> 51): 134 null
      // try (56 -> 67): 99 org/json/JSONException
      // try (56 -> 67): 134 null
      // try (75 -> 80): 134 null
      // try (85 -> 97): 117 org/json/JSONException
      // try (85 -> 97): 134 null
      // try (100 -> 115): 134 null
      // try (118 -> 133): 134 null
      // try (141 -> 153): 134 null
      // try (155 -> 163): 134 null
      // try (165 -> 171): 134 null
      // try (171 -> 195): 134 null
      // try (197 -> 203): 134 null
   }

   public String b() {
      synchronized (this) {
         return this.a;
      }
   }

   public JSONArray c() {
      synchronized (this) {
         return this.g;
      }
   }

   public Boolean d() {
      return this.i;
   }

   public boolean e() {
      boolean var1;
      if (this.d() == null) {
         var1 = true;
      } else {
         var1 = this.d();
      }

      return var1;
   }

   public interface OnNewResultsListener {
      void a();
   }
}

package com.mixpanel.android.viewcrawler;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class DynamicEventTracker implements ViewVisitor.OnEventListener {
   private static String e = "MixpanelAPI.DynamicEventTracker";
   private final MixpanelAPI a;
   private final Handler b;
   private final Runnable c;
   private final Map<DynamicEventTracker.Signature, DynamicEventTracker.UnsentEvent> d;

   public DynamicEventTracker(MixpanelAPI var1, Handler var2) {
      this.a = var1;
      this.d = new HashMap<>();
      this.c = new DynamicEventTracker.SendDebouncedTask(this);
      this.b = var2;
   }

   private static String a(View var0) {
      Object var6 = null;
      String var5;
      if (var0 instanceof TextView) {
         CharSequence var8 = ((TextView)var0).getText();
         var5 = (String)var6;
         if (var8 != null) {
            var5 = var8.toString();
         }
      } else {
         var5 = (String)var6;
         if (var0 instanceof ViewGroup) {
            StringBuilder var7 = new StringBuilder();
            ViewGroup var9 = (ViewGroup)var0;
            int var4 = var9.getChildCount();
            int var1 = 0;
            boolean var3 = false;

            while (var1 < var4 && var7.length() < 128) {
               var5 = a(var9.getChildAt(var1));
               boolean var2 = var3;
               if (var5 != null) {
                  var2 = var3;
                  if (var5.length() > 0) {
                     if (var3) {
                        var7.append(", ");
                     }

                     var7.append(var5);
                     var2 = true;
                  }
               }

               var1++;
               var3 = var2;
            }

            if (var7.length() > 128) {
               var5 = var7.substring(0, 128);
            } else {
               var5 = (String)var6;
               if (var3) {
                  var5 = var7.toString();
               }
            }
         }
      }

      return var5;
   }

   @Override
   public void a(View param1, String param2, boolean param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: invokestatic java/lang/System.currentTimeMillis ()J
      // 03: lstore 4
      // 05: new org/json/JSONObject
      // 08: dup
      // 09: invokespecial org/json/JSONObject.<init> ()V
      // 0c: astore 6
      // 0e: aload 6
      // 10: ldc "$text"
      // 12: aload 1
      // 13: invokestatic com/mixpanel/android/viewcrawler/DynamicEventTracker.a (Landroid/view/View;)Ljava/lang/String;
      // 16: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      // 19: pop
      // 1a: aload 6
      // 1c: ldc "$from_binding"
      // 1e: bipush 1
      // 1f: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Z)Lorg/json/JSONObject;
      // 22: pop
      // 23: aload 6
      // 25: ldc "time"
      // 27: lload 4
      // 29: ldc2_w 1000
      // 2c: ldiv
      // 2d: invokevirtual org/json/JSONObject.put (Ljava/lang/String;J)Lorg/json/JSONObject;
      // 30: pop
      // 31: iload 3
      // 32: ifeq 95
      // 35: new com/mixpanel/android/viewcrawler/DynamicEventTracker$Signature
      // 38: dup
      // 39: aload 1
      // 3a: aload 2
      // 3b: invokespecial com/mixpanel/android/viewcrawler/DynamicEventTracker$Signature.<init> (Landroid/view/View;Ljava/lang/String;)V
      // 3e: astore 1
      // 3f: new com/mixpanel/android/viewcrawler/DynamicEventTracker$UnsentEvent
      // 42: dup
      // 43: aload 2
      // 44: aload 6
      // 46: lload 4
      // 48: invokespecial com/mixpanel/android/viewcrawler/DynamicEventTracker$UnsentEvent.<init> (Ljava/lang/String;Lorg/json/JSONObject;J)V
      // 4b: astore 6
      // 4d: aload 0
      // 4e: getfield com/mixpanel/android/viewcrawler/DynamicEventTracker.d Ljava/util/Map;
      // 51: astore 2
      // 52: aload 2
      // 53: monitorenter
      // 54: aload 0
      // 55: getfield com/mixpanel/android/viewcrawler/DynamicEventTracker.d Ljava/util/Map;
      // 58: invokeinterface java/util/Map.isEmpty ()Z 1
      // 5d: istore 3
      // 5e: aload 0
      // 5f: getfield com/mixpanel/android/viewcrawler/DynamicEventTracker.d Ljava/util/Map;
      // 62: aload 1
      // 63: aload 6
      // 65: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 6a: pop
      // 6b: iload 3
      // 6c: ifeq 7e
      // 6f: aload 0
      // 70: getfield com/mixpanel/android/viewcrawler/DynamicEventTracker.b Landroid/os/Handler;
      // 73: aload 0
      // 74: getfield com/mixpanel/android/viewcrawler/DynamicEventTracker.c Ljava/lang/Runnable;
      // 77: ldc2_w 1000
      // 7a: invokevirtual android/os/Handler.postDelayed (Ljava/lang/Runnable;J)Z
      // 7d: pop
      // 7e: aload 2
      // 7f: monitorexit
      // 80: return
      // 81: astore 7
      // 83: getstatic com/mixpanel/android/viewcrawler/DynamicEventTracker.e Ljava/lang/String;
      // 86: ldc "Can't format properties from view due to JSON issue"
      // 88: aload 7
      // 8a: invokestatic com/mixpanel/android/util/MPLog.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 8d: goto 31
      // 90: astore 1
      // 91: aload 2
      // 92: monitorexit
      // 93: aload 1
      // 94: athrow
      // 95: aload 0
      // 96: getfield com/mixpanel/android/viewcrawler/DynamicEventTracker.a Lcom/mixpanel/android/mpmetrics/MixpanelAPI;
      // 99: aload 2
      // 9a: aload 6
      // 9c: invokevirtual com/mixpanel/android/mpmetrics/MixpanelAPI.a (Ljava/lang/String;Lorg/json/JSONObject;)V
      // 9f: goto 80
      // try (6 -> 24): 66 org/json/JSONException
      // try (44 -> 54): 72 null
      // try (56 -> 63): 72 null
      // try (63 -> 65): 72 null
      // try (73 -> 75): 72 null
   }

   private final class SendDebouncedTask implements Runnable {
      final DynamicEventTracker a;

      private SendDebouncedTask(DynamicEventTracker var1) {
         this.a = var1;
      }

      @Override
      public void run() {
         // $VF: Couldn't be decompiled
         // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
         // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
         //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
         //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
         //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
         //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
         //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
         //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
         //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
         //
         // Bytecode:
         // 00: invokestatic java/lang/System.currentTimeMillis ()J
         // 03: lstore 1
         // 04: aload 0
         // 05: getfield com/mixpanel/android/viewcrawler/DynamicEventTracker$SendDebouncedTask.a Lcom/mixpanel/android/viewcrawler/DynamicEventTracker;
         // 08: invokestatic com/mixpanel/android/viewcrawler/DynamicEventTracker.a (Lcom/mixpanel/android/viewcrawler/DynamicEventTracker;)Ljava/util/Map;
         // 0b: astore 3
         // 0c: aload 3
         // 0d: monitorenter
         // 0e: aload 0
         // 0f: getfield com/mixpanel/android/viewcrawler/DynamicEventTracker$SendDebouncedTask.a Lcom/mixpanel/android/viewcrawler/DynamicEventTracker;
         // 12: invokestatic com/mixpanel/android/viewcrawler/DynamicEventTracker.a (Lcom/mixpanel/android/viewcrawler/DynamicEventTracker;)Ljava/util/Map;
         // 15: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
         // 1a: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
         // 1f: astore 5
         // 21: aload 5
         // 23: invokeinterface java/util/Iterator.hasNext ()Z 1
         // 28: ifeq 72
         // 2b: aload 5
         // 2d: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
         // 32: checkcast java/util/Map$Entry
         // 35: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
         // 3a: checkcast com/mixpanel/android/viewcrawler/DynamicEventTracker$UnsentEvent
         // 3d: astore 4
         // 3f: lload 1
         // 40: aload 4
         // 42: getfield com/mixpanel/android/viewcrawler/DynamicEventTracker$UnsentEvent.a J
         // 45: lsub
         // 46: ldc2_w 1000
         // 49: lcmp
         // 4a: ifle 21
         // 4d: aload 0
         // 4e: getfield com/mixpanel/android/viewcrawler/DynamicEventTracker$SendDebouncedTask.a Lcom/mixpanel/android/viewcrawler/DynamicEventTracker;
         // 51: invokestatic com/mixpanel/android/viewcrawler/DynamicEventTracker.b (Lcom/mixpanel/android/viewcrawler/DynamicEventTracker;)Lcom/mixpanel/android/mpmetrics/MixpanelAPI;
         // 54: aload 4
         // 56: getfield com/mixpanel/android/viewcrawler/DynamicEventTracker$UnsentEvent.b Ljava/lang/String;
         // 59: aload 4
         // 5b: getfield com/mixpanel/android/viewcrawler/DynamicEventTracker$UnsentEvent.c Lorg/json/JSONObject;
         // 5e: invokevirtual com/mixpanel/android/mpmetrics/MixpanelAPI.a (Ljava/lang/String;Lorg/json/JSONObject;)V
         // 61: aload 5
         // 63: invokeinterface java/util/Iterator.remove ()V 1
         // 68: goto 21
         // 6b: astore 4
         // 6d: aload 3
         // 6e: monitorexit
         // 6f: aload 4
         // 71: athrow
         // 72: aload 0
         // 73: getfield com/mixpanel/android/viewcrawler/DynamicEventTracker$SendDebouncedTask.a Lcom/mixpanel/android/viewcrawler/DynamicEventTracker;
         // 76: invokestatic com/mixpanel/android/viewcrawler/DynamicEventTracker.a (Lcom/mixpanel/android/viewcrawler/DynamicEventTracker;)Ljava/util/Map;
         // 79: invokeinterface java/util/Map.isEmpty ()Z 1
         // 7e: ifne 90
         // 81: aload 0
         // 82: getfield com/mixpanel/android/viewcrawler/DynamicEventTracker$SendDebouncedTask.a Lcom/mixpanel/android/viewcrawler/DynamicEventTracker;
         // 85: invokestatic com/mixpanel/android/viewcrawler/DynamicEventTracker.c (Lcom/mixpanel/android/viewcrawler/DynamicEventTracker;)Landroid/os/Handler;
         // 88: aload 0
         // 89: ldc2_w 500
         // 8c: invokevirtual android/os/Handler.postDelayed (Ljava/lang/Runnable;J)Z
         // 8f: pop
         // 90: aload 3
         // 91: monitorexit
         // 92: return
         // try (8 -> 14): 41 null
         // try (14 -> 40): 41 null
         // try (42 -> 44): 41 null
         // try (46 -> 58): 41 null
         // try (58 -> 60): 41 null
      }
   }

   private static class Signature {
      private final int a;

      public Signature(View var1, String var2) {
         this.a = var1.hashCode() ^ var2.hashCode();
      }

      @Override
      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2 = var3;
         if (var1 instanceof DynamicEventTracker.Signature) {
            var2 = var3;
            if (this.a == var1.hashCode()) {
               var2 = true;
            }
         }

         return var2;
      }

      @Override
      public int hashCode() {
         return this.a;
      }
   }

   private static class UnsentEvent {
      public final long a;
      public final String b;
      public final JSONObject c;

      public UnsentEvent(String var1, JSONObject var2, long var3) {
         this.b = var1;
         this.c = var2;
         this.a = var3;
      }
   }
}

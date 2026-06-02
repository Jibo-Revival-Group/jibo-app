package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.internal.AppEventsLoggerUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class SessionEventsState {
   private final int MAX_ACCUMULATED_LOG_EVENTS;
   private List<AppEvent> accumulatedEvents = new ArrayList<>();
   private String anonymousAppDeviceGUID;
   private AttributionIdentifiers attributionIdentifiers;
   private List<AppEvent> inFlightEvents = new ArrayList<>();
   private int numSkippedEventsDueToFullBuffer;

   public SessionEventsState(AttributionIdentifiers var1, String var2) {
      this.MAX_ACCUMULATED_LOG_EVENTS = 1000;
      this.attributionIdentifiers = var1;
      this.anonymousAppDeviceGUID = var2;
   }

   private byte[] getStringAsByteArray(String var1) {
      Object var2 = null;

      try {
         var4 = var1.getBytes("UTF-8");
      } catch (UnsupportedEncodingException var3) {
         Utility.logd("Encoding exception: ", var3);
         var4 = (byte[])var2;
      }

      return var4;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void populateRequest(GraphRequest var1, Context var2, int var3, JSONArray var4, boolean var5) {
      label34: {
         JSONObject var6;
         try {
            var6 = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(
               AppEventsLoggerUtility.GraphAPIActivityType.CUSTOM_APP_EVENTS, this.attributionIdentifiers, this.anonymousAppDeviceGUID, var5, var2
            );
         } catch (JSONException var8) {
            var9 = new JSONObject();
            break label34;
         }

         var9 = var6;

         try {
            if (this.numSkippedEventsDueToFullBuffer <= 0) {
               break label34;
            }

            var6.put("num_skipped_events", var3);
         } catch (JSONException var7) {
            var9 = new JSONObject();
            break label34;
         }

         var9 = var6;
      }

      var1.setGraphObject(var9);
      Bundle var12 = var1.getParameters();
      Bundle var10 = var12;
      if (var12 == null) {
         var10 = new Bundle();
      }

      String var11 = var4.toString();
      if (var11 != null) {
         var10.putByteArray("custom_events_file", this.getStringAsByteArray(var11));
         var1.setTag(var11);
      }

      var1.setParameters(var10);
   }

   public void accumulatePersistedEvents(List<AppEvent> var1) {
      synchronized (this) {
         this.accumulatedEvents.addAll(var1);
      }
   }

   public void addEvent(AppEvent var1) {
      synchronized (this) {
         if (this.accumulatedEvents.size() + this.inFlightEvents.size() >= 1000) {
            this.numSkippedEventsDueToFullBuffer++;
         } else {
            this.accumulatedEvents.add(var1);
         }
      }
   }

   public void clearInFlightAndStats(boolean param1) {
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
      // 02: iload 1
      // 03: ifeq 14
      // 06: aload 0
      // 07: getfield com/facebook/appevents/SessionEventsState.accumulatedEvents Ljava/util/List;
      // 0a: aload 0
      // 0b: getfield com/facebook/appevents/SessionEventsState.inFlightEvents Ljava/util/List;
      // 0e: invokeinterface java/util/List.addAll (Ljava/util/Collection;)Z 2
      // 13: pop
      // 14: aload 0
      // 15: getfield com/facebook/appevents/SessionEventsState.inFlightEvents Ljava/util/List;
      // 18: invokeinterface java/util/List.clear ()V 1
      // 1d: aload 0
      // 1e: bipush 0
      // 1f: putfield com/facebook/appevents/SessionEventsState.numSkippedEventsDueToFullBuffer I
      // 22: aload 0
      // 23: monitorexit
      // 24: return
      // 25: astore 2
      // 26: aload 0
      // 27: monitorexit
      // 28: aload 2
      // 29: athrow
      // try (4 -> 10): 19 null
      // try (10 -> 16): 19 null
   }

   public int getAccumulatedEventCount() {
      synchronized (this) {
         return this.accumulatedEvents.size();
      }
   }

   public List<AppEvent> getEventsToPersist() {
      List var1;
      synchronized (this) {
         var1 = this.accumulatedEvents;
         ArrayList var2 = new ArrayList();
         this.accumulatedEvents = var2;
      }

      return var1;
   }

   public int populateRequest(GraphRequest param1, Context param2, boolean param3, boolean param4) {
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
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/facebook/appevents/SessionEventsState.numSkippedEventsDueToFullBuffer I
      // 06: istore 5
      // 08: aload 0
      // 09: getfield com/facebook/appevents/SessionEventsState.inFlightEvents Ljava/util/List;
      // 0c: aload 0
      // 0d: getfield com/facebook/appevents/SessionEventsState.accumulatedEvents Ljava/util/List;
      // 10: invokeinterface java/util/List.addAll (Ljava/util/Collection;)Z 2
      // 15: pop
      // 16: aload 0
      // 17: getfield com/facebook/appevents/SessionEventsState.accumulatedEvents Ljava/util/List;
      // 1a: invokeinterface java/util/List.clear ()V 1
      // 1f: new org/json/JSONArray
      // 22: astore 6
      // 24: aload 6
      // 26: invokespecial org/json/JSONArray.<init> ()V
      // 29: aload 0
      // 2a: getfield com/facebook/appevents/SessionEventsState.inFlightEvents Ljava/util/List;
      // 2d: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 32: astore 8
      // 34: aload 8
      // 36: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 3b: ifeq 7e
      // 3e: aload 8
      // 40: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 45: checkcast com/facebook/appevents/AppEvent
      // 48: astore 7
      // 4a: aload 7
      // 4c: invokevirtual com/facebook/appevents/AppEvent.isChecksumValid ()Z
      // 4f: ifeq 71
      // 52: iload 3
      // 53: ifne 5e
      // 56: aload 7
      // 58: invokevirtual com/facebook/appevents/AppEvent.getIsImplicit ()Z
      // 5b: ifne 34
      // 5e: aload 6
      // 60: aload 7
      // 62: invokevirtual com/facebook/appevents/AppEvent.getJSONObject ()Lorg/json/JSONObject;
      // 65: invokevirtual org/json/JSONArray.put (Ljava/lang/Object;)Lorg/json/JSONArray;
      // 68: pop
      // 69: goto 34
      // 6c: astore 1
      // 6d: aload 0
      // 6e: monitorexit
      // 6f: aload 1
      // 70: athrow
      // 71: ldc "Event with invalid checksum: %s"
      // 73: aload 7
      // 75: invokevirtual com/facebook/appevents/AppEvent.toString ()Ljava/lang/String;
      // 78: invokestatic com/facebook/internal/Utility.logd (Ljava/lang/String;Ljava/lang/String;)V
      // 7b: goto 34
      // 7e: aload 6
      // 80: invokevirtual org/json/JSONArray.length ()I
      // 83: ifne 8e
      // 86: bipush 0
      // 87: istore 5
      // 89: aload 0
      // 8a: monitorexit
      // 8b: iload 5
      // 8d: ireturn
      // 8e: aload 0
      // 8f: monitorexit
      // 90: aload 0
      // 91: aload 1
      // 92: aload 2
      // 93: iload 5
      // 95: aload 6
      // 97: iload 4
      // 99: invokespecial com/facebook/appevents/SessionEventsState.populateRequest (Lcom/facebook/GraphRequest;Landroid/content/Context;ILorg/json/JSONArray;Z)V
      // 9c: aload 6
      // 9e: invokevirtual org/json/JSONArray.length ()I
      // a1: istore 5
      // a3: goto 8b
      // try (2 -> 22): 43 null
      // try (22 -> 32): 43 null
      // try (34 -> 37): 43 null
      // try (37 -> 42): 43 null
      // try (44 -> 46): 43 null
      // try (48 -> 52): 43 null
      // try (53 -> 56): 43 null
      // try (58 -> 60): 43 null
      // try (62 -> 64): 43 null
   }
}

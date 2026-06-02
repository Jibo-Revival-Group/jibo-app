package com.crashlytics.android.core;

import com.crashlytics.android.core.internal.models.BinaryImageData;
import com.crashlytics.android.core.internal.models.CustomAttributeData;
import com.crashlytics.android.core.internal.models.DeviceData;
import com.crashlytics.android.core.internal.models.SessionEventData;
import com.crashlytics.android.core.internal.models.SignalData;
import com.crashlytics.android.core.internal.models.ThreadData;
import io.fabric.sdk.android.Fabric;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

class NativeCrashWriter {
   private static final SignalData a = new SignalData("", "", 0L);
   private static final NativeCrashWriter.ProtobufMessage[] b = new NativeCrashWriter.ProtobufMessage[0];
   private static final NativeCrashWriter.ThreadMessage[] c = new NativeCrashWriter.ThreadMessage[0];
   private static final NativeCrashWriter.FrameMessage[] d = new NativeCrashWriter.FrameMessage[0];
   private static final NativeCrashWriter.BinaryImageMessage[] e = new NativeCrashWriter.BinaryImageMessage[0];
   private static final NativeCrashWriter.CustomAttributeMessage[] f = new NativeCrashWriter.CustomAttributeMessage[0];

   private static NativeCrashWriter.EventMessage a(SessionEventData var0, LogFileManager var1, Map<String, String> var2) throws IOException {
      SignalData var3;
      if (var0.b != null) {
         var3 = var0.b;
      } else {
         var3 = a;
      }

      NativeCrashWriter.ApplicationMessage var6 = new NativeCrashWriter.ApplicationMessage(
         new NativeCrashWriter.ExecutionMessage(new NativeCrashWriter.SignalMessage(var3), a(var0.c), a(var0.d)), a(a(var0.e, var2))
      );
      NativeCrashWriter.ProtobufMessage var7 = a(var0.f);
      ByteString var4 = var1.a();
      if (var4 == null) {
         Fabric.h().a("CrashlyticsCore", "No log data to include with this event.");
      }

      var1.b();
      NativeCrashWriter.ProtobufMessage var5;
      if (var4 != null) {
         var5 = new NativeCrashWriter.LogMessage(var4);
      } else {
         var5 = new NativeCrashWriter.NullMessage();
      }

      return new NativeCrashWriter.EventMessage(var0.a, "ndk-crash", var6, var7, var5);
   }

   private static NativeCrashWriter.ProtobufMessage a(DeviceData var0) {
      NativeCrashWriter.ProtobufMessage var1;
      if (var0 == null) {
         var1 = new NativeCrashWriter.NullMessage();
      } else {
         var1 = new NativeCrashWriter.DeviceMessage(var0.f / 100.0F, var0.g, var0.h, var0.a, var0.b - var0.d, var0.c - var0.e);
      }

      return var1;
   }

   private static NativeCrashWriter.RepeatedMessage a(BinaryImageData[] var0) {
      NativeCrashWriter.BinaryImageMessage[] var2;
      if (var0 != null) {
         var2 = new NativeCrashWriter.BinaryImageMessage[var0.length];
      } else {
         var2 = e;
      }

      for (int var1 = 0; var1 < var2.length; var1++) {
         var2[var1] = new NativeCrashWriter.BinaryImageMessage(var0[var1]);
      }

      return new NativeCrashWriter.RepeatedMessage(var2);
   }

   private static NativeCrashWriter.RepeatedMessage a(CustomAttributeData[] var0) {
      NativeCrashWriter.CustomAttributeMessage[] var2;
      if (var0 != null) {
         var2 = new NativeCrashWriter.CustomAttributeMessage[var0.length];
      } else {
         var2 = f;
      }

      for (int var1 = 0; var1 < var2.length; var1++) {
         var2[var1] = new NativeCrashWriter.CustomAttributeMessage(var0[var1]);
      }

      return new NativeCrashWriter.RepeatedMessage(var2);
   }

   private static NativeCrashWriter.RepeatedMessage a(ThreadData.FrameData[] var0) {
      NativeCrashWriter.FrameMessage[] var2;
      if (var0 != null) {
         var2 = new NativeCrashWriter.FrameMessage[var0.length];
      } else {
         var2 = d;
      }

      for (int var1 = 0; var1 < var2.length; var1++) {
         var2[var1] = new NativeCrashWriter.FrameMessage(var0[var1]);
      }

      return new NativeCrashWriter.RepeatedMessage(var2);
   }

   private static NativeCrashWriter.RepeatedMessage a(ThreadData[] var0) {
      NativeCrashWriter.ThreadMessage[] var2;
      if (var0 != null) {
         var2 = new NativeCrashWriter.ThreadMessage[var0.length];
      } else {
         var2 = c;
      }

      for (int var1 = 0; var1 < var2.length; var1++) {
         ThreadData var3 = var0[var1];
         var2[var1] = new NativeCrashWriter.ThreadMessage(var3, a(var3.c));
      }

      return new NativeCrashWriter.RepeatedMessage(var2);
   }

   public static void a(SessionEventData var0, LogFileManager var1, Map<String, String> var2, CodedOutputStream var3) throws IOException {
      a(var0, var1, var2).b(var3);
   }

   private static CustomAttributeData[] a(CustomAttributeData[] var0, Map<String, String> var1) {
      TreeMap var4 = new TreeMap(var1);
      if (var0 != null) {
         for (CustomAttributeData var6 : var0) {
            var4.put(var6.a, var6.b);
         }
      }

      Entry[] var7 = var4.entrySet().toArray(new Entry[var4.size()]);
      var0 = new CustomAttributeData[var7.length];

      for (int var8 = 0; var8 < var0.length; var8++) {
         var0[var8] = new CustomAttributeData((String)var7[var8].getKey(), (String)var7[var8].getValue());
      }

      return var0;
   }

   private static final class ApplicationMessage extends NativeCrashWriter.ProtobufMessage {
      public ApplicationMessage(NativeCrashWriter.ExecutionMessage var1, NativeCrashWriter.RepeatedMessage var2) {
         super(3, var1, var2);
      }
   }

   private static final class BinaryImageMessage extends NativeCrashWriter.ProtobufMessage {
      private final long a;
      private final long b;
      private final String c;
      private final String d;

      public BinaryImageMessage(BinaryImageData var1) {
         super(4);
         this.a = var1.a;
         this.b = var1.b;
         this.c = var1.c;
         this.d = var1.d;
      }

      @Override
      public int a() {
         int var1 = CodedOutputStream.b(1, this.a);
         int var2 = CodedOutputStream.b(2, this.b);
         return var1 + CodedOutputStream.b(3, ByteString.a(this.c)) + var2 + CodedOutputStream.b(4, ByteString.a(this.d));
      }

      @Override
      public void a(CodedOutputStream var1) throws IOException {
         var1.a(1, this.a);
         var1.a(2, this.b);
         var1.a(3, ByteString.a(this.c));
         var1.a(4, ByteString.a(this.d));
      }
   }

   private static final class CustomAttributeMessage extends NativeCrashWriter.ProtobufMessage {
      private final String a;
      private final String b;

      public CustomAttributeMessage(CustomAttributeData var1) {
         super(2);
         this.a = var1.a;
         this.b = var1.b;
      }

      @Override
      public int a() {
         int var1 = CodedOutputStream.b(1, ByteString.a(this.a));
         String var2;
         if (this.b == null) {
            var2 = "";
         } else {
            var2 = this.b;
         }

         return CodedOutputStream.b(2, ByteString.a(var2)) + var1;
      }

      @Override
      public void a(CodedOutputStream var1) throws IOException {
         var1.a(1, ByteString.a(this.a));
         String var2;
         if (this.b == null) {
            var2 = "";
         } else {
            var2 = this.b;
         }

         var1.a(2, ByteString.a(var2));
      }
   }

   private static final class DeviceMessage extends NativeCrashWriter.ProtobufMessage {
      private final float a;
      private final int b;
      private final boolean c;
      private final int d;
      private final long e;
      private final long f;

      public DeviceMessage(float var1, int var2, boolean var3, int var4, long var5, long var7) {
         super(5);
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
         this.f = var7;
      }

      @Override
      public int a() {
         return 0
            + CodedOutputStream.b(1, this.a)
            + CodedOutputStream.f(2, this.b)
            + CodedOutputStream.b(3, this.c)
            + CodedOutputStream.d(4, this.d)
            + CodedOutputStream.b(5, this.e)
            + CodedOutputStream.b(6, this.f);
      }

      @Override
      public void a(CodedOutputStream var1) throws IOException {
         var1.a(1, this.a);
         var1.c(2, this.b);
         var1.a(3, this.c);
         var1.a(4, this.d);
         var1.a(5, this.e);
         var1.a(6, this.f);
      }
   }

   private static final class EventMessage extends NativeCrashWriter.ProtobufMessage {
      private final long a;
      private final String b;

      public EventMessage(long var1, String var3, NativeCrashWriter.ProtobufMessage... var4) {
         super(10, var4);
         this.a = var1;
         this.b = var3;
      }

      @Override
      public int a() {
         return CodedOutputStream.b(1, this.a) + CodedOutputStream.b(2, ByteString.a(this.b));
      }

      @Override
      public void a(CodedOutputStream var1) throws IOException {
         var1.a(1, this.a);
         var1.a(2, ByteString.a(this.b));
      }
   }

   private static final class ExecutionMessage extends NativeCrashWriter.ProtobufMessage {
      public ExecutionMessage(NativeCrashWriter.SignalMessage var1, NativeCrashWriter.RepeatedMessage var2, NativeCrashWriter.RepeatedMessage var3) {
         super(1, var2, var1, var3);
      }
   }

   private static final class FrameMessage extends NativeCrashWriter.ProtobufMessage {
      private final long a;
      private final String b;
      private final String c;
      private final long d;
      private final int e;

      public FrameMessage(ThreadData.FrameData var1) {
         super(3);
         this.a = var1.a;
         this.b = var1.b;
         this.c = var1.c;
         this.d = var1.d;
         this.e = var1.e;
      }

      @Override
      public int a() {
         return CodedOutputStream.b(1, this.a)
            + CodedOutputStream.b(2, ByteString.a(this.b))
            + CodedOutputStream.b(3, ByteString.a(this.c))
            + CodedOutputStream.b(4, this.d)
            + CodedOutputStream.d(5, this.e);
      }

      @Override
      public void a(CodedOutputStream var1) throws IOException {
         var1.a(1, this.a);
         var1.a(2, ByteString.a(this.b));
         var1.a(3, ByteString.a(this.c));
         var1.a(4, this.d);
         var1.a(5, this.e);
      }
   }

   private static final class LogMessage extends NativeCrashWriter.ProtobufMessage {
      ByteString a;

      public LogMessage(ByteString var1) {
         super(6);
         this.a = var1;
      }

      @Override
      public int a() {
         return CodedOutputStream.b(1, this.a);
      }

      @Override
      public void a(CodedOutputStream var1) throws IOException {
         var1.a(1, this.a);
      }
   }

   private static final class NullMessage extends NativeCrashWriter.ProtobufMessage {
      public NullMessage() {
         super(0);
      }

      @Override
      public int b() {
         return 0;
      }

      @Override
      public void b(CodedOutputStream var1) throws IOException {
      }
   }

   private abstract static class ProtobufMessage {
      private final int a;
      private final NativeCrashWriter.ProtobufMessage[] b;

      public ProtobufMessage(int var1, NativeCrashWriter.ProtobufMessage... var2) {
         this.a = var1;
         if (var2 == null) {
            var2 = NativeCrashWriter.b;
         }

         this.b = var2;
      }

      public int a() {
         return 0;
      }

      public void a(CodedOutputStream var1) throws IOException {
      }

      public int b() {
         int var1 = this.c();
         return var1 + CodedOutputStream.l(var1) + CodedOutputStream.j(this.a);
      }

      public void b(CodedOutputStream var1) throws IOException {
         var1.g(this.a, 2);
         var1.k(this.c());
         this.a(var1);
         NativeCrashWriter.ProtobufMessage[] var4 = this.b;
         int var3 = var4.length;

         for (int var2 = 0; var2 < var3; var2++) {
            var4[var2].b(var1);
         }
      }

      public int c() {
         int var1 = this.a();
         NativeCrashWriter.ProtobufMessage[] var4 = this.b;
         int var3 = var4.length;

         for (int var2 = 0; var2 < var3; var2++) {
            var1 += var4[var2].b();
         }

         return var1;
      }
   }

   private static final class RepeatedMessage extends NativeCrashWriter.ProtobufMessage {
      private final NativeCrashWriter.ProtobufMessage[] a;

      public RepeatedMessage(NativeCrashWriter.ProtobufMessage... var1) {
         super(0);
         this.a = var1;
      }

      @Override
      public int b() {
         int var1 = 0;
         NativeCrashWriter.ProtobufMessage[] var4 = this.a;
         int var3 = var4.length;
         int var2 = 0;

         while (var1 < var3) {
            var2 += var4[var1].b();
            var1++;
         }

         return var2;
      }

      @Override
      public void b(CodedOutputStream var1) throws IOException {
         NativeCrashWriter.ProtobufMessage[] var4 = this.a;
         int var3 = var4.length;

         for (int var2 = 0; var2 < var3; var2++) {
            var4[var2].b(var1);
         }
      }
   }

   private static final class SignalMessage extends NativeCrashWriter.ProtobufMessage {
      private final String a;
      private final String b;
      private final long c;

      public SignalMessage(SignalData var1) {
         super(3);
         this.a = var1.a;
         this.b = var1.b;
         this.c = var1.c;
      }

      @Override
      public int a() {
         return CodedOutputStream.b(1, ByteString.a(this.a)) + CodedOutputStream.b(2, ByteString.a(this.b)) + CodedOutputStream.b(3, this.c);
      }

      @Override
      public void a(CodedOutputStream var1) throws IOException {
         var1.a(1, ByteString.a(this.a));
         var1.a(2, ByteString.a(this.b));
         var1.a(3, this.c);
      }
   }

   private static final class ThreadMessage extends NativeCrashWriter.ProtobufMessage {
      private final String a;
      private final int b;

      public ThreadMessage(ThreadData var1, NativeCrashWriter.RepeatedMessage var2) {
         super(1, var2);
         this.a = var1.a;
         this.b = var1.b;
      }

      private boolean d() {
         boolean var1;
         if (this.a != null && this.a.length() > 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      @Override
      public int a() {
         int var1;
         if (this.d()) {
            var1 = CodedOutputStream.b(1, ByteString.a(this.a));
         } else {
            var1 = 0;
         }

         return var1 + CodedOutputStream.d(2, this.b);
      }

      @Override
      public void a(CodedOutputStream var1) throws IOException {
         if (this.d()) {
            var1.a(1, ByteString.a(this.a));
         }

         var1.a(2, this.b);
      }
   }
}

package com.salesforce.android.cases.core.internal.http.serializer;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public final class DateTypeAdapter extends TypeAdapter<Date> {
   private final Class<? extends Date> a;
   private final DateFormat b;
   private final DateFormat c;

   public DateTypeAdapter(Class<? extends Date> var1) {
      this(var1, DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
   }

   private DateTypeAdapter(Class<? extends Date> var1, DateFormat var2, DateFormat var3) {
      if (var1 != Date.class && var1 != java.sql.Date.class && var1 != Timestamp.class) {
         throw new IllegalArgumentException(
            "Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + var1
         );
      }

      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   private Date a(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/salesforce/android/cases/core/internal/http/serializer/DateTypeAdapter.c Ljava/text/DateFormat;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/salesforce/android/cases/core/internal/http/serializer/DateTypeAdapter.c Ljava/text/DateFormat;
      // 0b: aload 1
      // 0c: invokevirtual java/text/DateFormat.parse (Ljava/lang/String;)Ljava/util/Date;
      // 0f: astore 2
      // 10: aload 2
      // 11: astore 1
      // 12: aload 3
      // 13: monitorexit
      // 14: aload 1
      // 15: areturn
      // 16: astore 2
      // 17: aload 0
      // 18: getfield com/salesforce/android/cases/core/internal/http/serializer/DateTypeAdapter.b Ljava/text/DateFormat;
      // 1b: aload 1
      // 1c: invokevirtual java/text/DateFormat.parse (Ljava/lang/String;)Ljava/util/Date;
      // 1f: astore 2
      // 20: aload 2
      // 21: astore 1
      // 22: aload 3
      // 23: monitorexit
      // 24: goto 14
      // 27: astore 1
      // 28: aload 3
      // 29: monitorexit
      // 2a: aload 1
      // 2b: athrow
      // 2c: astore 2
      // 2d: new java/text/ParsePosition
      // 30: astore 2
      // 31: aload 2
      // 32: bipush 0
      // 33: invokespecial java/text/ParsePosition.<init> (I)V
      // 36: aload 1
      // 37: aload 2
      // 38: invokestatic com/google/gson/internal/bind/util/ISO8601Utils.a (Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/util/Date;
      // 3b: astore 2
      // 3c: aload 2
      // 3d: astore 1
      // 3e: aload 3
      // 3f: monitorexit
      // 40: goto 14
      // 43: astore 4
      // 45: new com/google/gson/JsonSyntaxException
      // 48: astore 2
      // 49: aload 2
      // 4a: aload 1
      // 4b: aload 4
      // 4d: invokespecial com/google/gson/JsonSyntaxException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 50: aload 2
      // 51: athrow
      // try (5 -> 10): 16 java/text/ParseException
      // try (5 -> 10): 27 null
      // try (12 -> 14): 27 null
      // try (17 -> 22): 32 java/text/ParseException
      // try (17 -> 22): 27 null
      // try (24 -> 26): 27 null
      // try (28 -> 30): 27 null
      // try (33 -> 42): 47 java/text/ParseException
      // try (33 -> 42): 27 null
      // try (44 -> 46): 27 null
      // try (48 -> 56): 27 null
   }

   public Date a(JsonReader var1) throws IOException {
      Date var3;
      if (var1.f() == JsonToken.NULL) {
         var1.j();
         var3 = null;
      } else {
         Date var2 = this.a(var1.h());
         var3 = var2;
         if (this.a != Date.class) {
            if (this.a == Timestamp.class) {
               var3 = new Timestamp(var2.getTime());
            } else {
               if (this.a != java.sql.Date.class) {
                  throw new AssertionError();
               }

               var3 = new java.sql.Date(var2.getTime());
            }
         }
      }

      return var3;
   }

   public void a(JsonWriter param1, Date param2) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 2
      // 01: ifnonnull 0a
      // 04: aload 1
      // 05: invokevirtual com/google/gson/stream/JsonWriter.f ()Lcom/google/gson/stream/JsonWriter;
      // 08: pop
      // 09: return
      // 0a: aload 0
      // 0b: getfield com/salesforce/android/cases/core/internal/http/serializer/DateTypeAdapter.c Ljava/text/DateFormat;
      // 0e: astore 3
      // 0f: aload 3
      // 10: monitorenter
      // 11: aload 1
      // 12: aload 0
      // 13: getfield com/salesforce/android/cases/core/internal/http/serializer/DateTypeAdapter.b Ljava/text/DateFormat;
      // 16: aload 2
      // 17: invokevirtual java/text/DateFormat.format (Ljava/util/Date;)Ljava/lang/String;
      // 1a: invokevirtual com/google/gson/stream/JsonWriter.b (Ljava/lang/String;)Lcom/google/gson/stream/JsonWriter;
      // 1d: pop
      // 1e: aload 3
      // 1f: monitorexit
      // 20: goto 09
      // 23: astore 1
      // 24: aload 3
      // 25: monitorexit
      // 26: aload 1
      // 27: athrow
      // try (11 -> 20): 21 null
      // try (22 -> 24): 21 null
   }

   @Override
   public String toString() {
      return "DateTypeAdapter(" + this.c.getClass().getSimpleName() + ')';
   }
}

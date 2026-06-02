package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class TimeTypeAdapter extends TypeAdapter<Time> {
   public static final TypeAdapterFactory a = new TypeAdapterFactory() {
      @Override
      public <T> TypeAdapter<T> a(Gson var1, TypeToken<T> var2) {
         TimeTypeAdapter var3;
         if (var2.getRawType() == Time.class) {
            var3 = new TimeTypeAdapter();
         } else {
            var3 = null;
         }

         return var3;
      }
   };
   private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

   public Time a(JsonReader var1) throws IOException {
      synchronized (this) {
         if (var1.f() != JsonToken.NULL) {
            try {
               return new Time(this.b.parse(var1.h()).getTime());
            } catch (ParseException var3) {
               JsonSyntaxException var2 = new JsonSyntaxException(var3);
               throw var2;
            }
         }

         var1.j();
      }

      return null;
   }

   public void a(JsonWriter param1, Time param2) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 2
      // 03: ifnonnull 11
      // 06: aconst_null
      // 07: astore 2
      // 08: aload 1
      // 09: aload 2
      // 0a: invokevirtual com/google/gson/stream/JsonWriter.b (Ljava/lang/String;)Lcom/google/gson/stream/JsonWriter;
      // 0d: pop
      // 0e: aload 0
      // 0f: monitorexit
      // 10: return
      // 11: aload 0
      // 12: getfield com/google/gson/internal/bind/TimeTypeAdapter.b Ljava/text/DateFormat;
      // 15: aload 2
      // 16: invokevirtual java/text/DateFormat.format (Ljava/util/Date;)Ljava/lang/String;
      // 19: astore 2
      // 1a: goto 08
      // 1d: astore 1
      // 1e: aload 0
      // 1f: monitorexit
      // 20: aload 1
      // 21: athrow
      // try (6 -> 10): 19 null
      // try (13 -> 18): 19 null
   }
}

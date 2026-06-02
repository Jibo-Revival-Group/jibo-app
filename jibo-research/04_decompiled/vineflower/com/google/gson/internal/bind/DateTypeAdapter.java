package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;

public final class DateTypeAdapter extends TypeAdapter<Date> {
   public static final TypeAdapterFactory a = new TypeAdapterFactory() {
      @Override
      public <T> TypeAdapter<T> a(Gson var1, TypeToken<T> var2) {
         DateTypeAdapter var3;
         if (var2.getRawType() == Date.class) {
            var3 = new DateTypeAdapter();
         } else {
            var3 = null;
         }

         return var3;
      }
   };
   private final DateFormat b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
   private final DateFormat c = DateFormat.getDateTimeInstance(2, 2);

   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private Date a(String var1) {
      label39: {
         Date var11;
         label38: {
            label37: {
               synchronized (this) {
                  try {
                     var11 = this.c.parse(var1);
                     break label38;
                  } catch (ParseException var5) {
                  }

                  try {
                     var11 = this.b.parse(var1);
                     break label37;
                  } catch (ParseException var6) {
                     try {
                        ParsePosition var2 = new ParsePosition(0);
                        var11 = ISO8601Utils.a(var1, var2);
                     } catch (ParseException var4) {
                        JsonSyntaxException var3 = new JsonSyntaxException(var1, var4);
                        throw var3;
                     }
                  }
               }

               var8 = var11;
               break label39;
            }

            var8 = var11;
            break label39;
         }

         var8 = var11;
      }

      // $VF: monitorexit
      return var8;
   }

   public Date a(JsonReader var1) throws IOException {
      Date var2;
      if (var1.f() == JsonToken.NULL) {
         var1.j();
         var2 = null;
      } else {
         var2 = this.a(var1.h());
      }

      return var2;
   }

   public void a(JsonWriter param1, Date param2) throws IOException {
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
      // 02: aload 2
      // 03: ifnonnull 0e
      // 06: aload 1
      // 07: invokevirtual com/google/gson/stream/JsonWriter.f ()Lcom/google/gson/stream/JsonWriter;
      // 0a: pop
      // 0b: aload 0
      // 0c: monitorexit
      // 0d: return
      // 0e: aload 1
      // 0f: aload 0
      // 10: getfield com/google/gson/internal/bind/DateTypeAdapter.b Ljava/text/DateFormat;
      // 13: aload 2
      // 14: invokevirtual java/text/DateFormat.format (Ljava/util/Date;)Ljava/lang/String;
      // 17: invokevirtual com/google/gson/stream/JsonWriter.b (Ljava/lang/String;)Lcom/google/gson/stream/JsonWriter;
      // 1a: pop
      // 1b: goto 0b
      // 1e: astore 1
      // 1f: aload 0
      // 20: monitorexit
      // 21: aload 1
      // 22: athrow
      // try (4 -> 7): 18 null
      // try (10 -> 17): 18 null
   }
}

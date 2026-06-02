package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import java.util.HashSet;

public class DupDetector {
   protected final Object a;
   protected String b;
   protected String c;
   protected HashSet<String> d;

   private DupDetector(Object var1) {
      this.a = var1;
   }

   public static DupDetector a(JsonGenerator var0) {
      return new DupDetector(var0);
   }

   public static DupDetector a(JsonParser var0) {
      return new DupDetector(var0);
   }

   public DupDetector a() {
      return new DupDetector(this.a);
   }

   public boolean a(String var1) throws JsonParseException {
      boolean var3 = true;
      boolean var2;
      if (this.b == null) {
         this.b = var1;
         var2 = false;
      } else {
         var2 = var3;
         if (!var1.equals(this.b)) {
            if (this.c == null) {
               this.c = var1;
               var2 = false;
            } else {
               var2 = var3;
               if (!var1.equals(this.c)) {
                  if (this.d == null) {
                     this.d = new HashSet<>(16);
                     this.d.add(this.b);
                     this.d.add(this.c);
                  }

                  var2 = var3;
                  if (this.d.add(var1)) {
                     var2 = false;
                  }
               }
            }
         }
      }

      return var2;
   }

   public void b() {
      this.b = null;
      this.c = null;
      this.d = null;
   }

   public JsonLocation c() {
      JsonLocation var1;
      if (this.a instanceof JsonParser) {
         var1 = ((JsonParser)this.a).e();
      } else {
         var1 = null;
      }

      return var1;
   }
}

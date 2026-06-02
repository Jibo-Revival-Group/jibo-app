package org.joda.time;

import java.io.Serializable;
import org.joda.time.base.BaseDateTime;

public final class DateTime extends BaseDateTime implements Serializable, ReadableDateTime {
   public DateTime() {
   }

   public DateTime(int var1, int var2, int var3, int var4, int var5, int var6, int var7, Chronology var8) {
      super(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public DateTime(long var1, Chronology var3) {
      super(var1, var3);
   }

   public DateTime(long var1, DateTimeZone var3) {
      super(var1, var3);
   }

   public DateTime(Object var1) {
      super(var1, (Chronology)null);
   }

   @Override
   public DateTime a() {
      return this;
   }
}

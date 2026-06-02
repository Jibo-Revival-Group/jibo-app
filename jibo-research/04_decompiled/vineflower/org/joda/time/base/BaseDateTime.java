package org.joda.time.base;

import java.io.Serializable;
import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableDateTime;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.convert.ConverterManager;
import org.joda.time.convert.InstantConverter;

public abstract class BaseDateTime extends AbstractDateTime implements Serializable, ReadableDateTime {
   private volatile long a;
   private volatile Chronology b;

   public BaseDateTime() {
      this(DateTimeUtils.a(), ISOChronology.O());
   }

   public BaseDateTime(int var1, int var2, int var3, int var4, int var5, int var6, int var7, Chronology var8) {
      this.b = this.b(var8);
      this.a = this.a(this.b.a(var1, var2, var3, var4, var5, var6, var7), this.b);
      this.i();
   }

   public BaseDateTime(long var1, Chronology var3) {
      this.b = this.b(var3);
      this.a = this.a(var1, this.b);
      this.i();
   }

   public BaseDateTime(long var1, DateTimeZone var3) {
      this(var1, ISOChronology.b(var3));
   }

   public BaseDateTime(Object var1, Chronology var2) {
      InstantConverter var3 = ConverterManager.a().a(var1);
      this.b = this.b(var3.b(var1, var2));
      this.a = this.a(var3.a(var1, var2), this.b);
      this.i();
   }

   private void i() {
      if (this.a == Long.MIN_VALUE || this.a == Long.MAX_VALUE) {
         this.b = this.b.b();
      }
   }

   protected long a(long var1, Chronology var3) {
      return var1;
   }

   protected void a(long var1) {
      this.a = this.a(var1, this.b);
   }

   protected void a(Chronology var1) {
      this.b = this.b(var1);
   }

   protected Chronology b(Chronology var1) {
      return DateTimeUtils.a(var1);
   }

   @Override
   public long c() {
      return this.a;
   }

   @Override
   public Chronology d() {
      return this.b;
   }
}

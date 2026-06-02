package org.joda.time;

import java.io.Serializable;
import org.joda.time.base.AbstractInstant;
import org.joda.time.chrono.ISOChronology;

public final class Instant extends AbstractInstant implements Serializable, ReadableInstant {
   private final long a;

   public Instant() {
      this.a = DateTimeUtils.a();
   }

   public Instant(long var1) {
      this.a = var1;
   }

   @Override
   public DateTime a() {
      return new DateTime(this.c(), ISOChronology.O());
   }

   @Override
   public Instant b() {
      return this;
   }

   @Override
   public long c() {
      return this.a;
   }

   @Override
   public Chronology d() {
      return ISOChronology.N();
   }

   @Override
   public MutableDateTime e() {
      return new MutableDateTime(this.c(), ISOChronology.O());
   }
}

package org.joda.time.base;

import org.joda.convert.ToString;
import org.joda.time.ReadableDateTime;

public abstract class AbstractDateTime extends AbstractInstant implements ReadableDateTime {
   protected AbstractDateTime() {
   }

   public int f() {
      return this.d().E().a(this.c());
   }

   public int g() {
      return this.d().z().a(this.c());
   }

   @ToString
   @Override
   public String toString() {
      return super.toString();
   }
}

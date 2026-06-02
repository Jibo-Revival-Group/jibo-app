package org.joda.time.field;

import org.joda.time.Chronology;
import org.joda.time.DateTimeField;

public final class SkipUndoDateTimeField extends DelegatedDateTimeField {
   private final Chronology a;
   private final int b;
   private transient int c;

   public SkipUndoDateTimeField(Chronology var1, DateTimeField var2) {
      this(var1, var2, 0);
   }

   public SkipUndoDateTimeField(Chronology var1, DateTimeField var2, int var3) {
      super(var2);
      this.a = var1;
      int var4 = super.g();
      if (var4 < var3) {
         this.c = var4 + 1;
      } else if (var4 == var3 + 1) {
         this.c = var3;
      } else {
         this.c = var4;
      }

      this.b = var3;
   }

   private Object readResolve() {
      return this.a().a(this.a);
   }

   @Override
   public int a(long var1) {
      int var4 = super.a(var1);
      int var3 = var4;
      if (var4 < this.b) {
         var3 = var4 + 1;
      }

      return var3;
   }

   @Override
   public long b(long var1, int var3) {
      FieldUtils.a(this, var3, this.c, this.h());
      int var4 = var3;
      if (var3 <= this.b) {
         var4 = var3 - 1;
      }

      return super.b(var1, var4);
   }

   @Override
   public int g() {
      return this.c;
   }
}

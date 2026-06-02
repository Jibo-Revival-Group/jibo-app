package org.joda.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.joda.time.base.BaseDateTime;
import org.joda.time.field.AbstractReadableInstantFieldProperty;

public class MutableDateTime extends BaseDateTime implements Serializable, Cloneable, ReadWritableDateTime {
   private DateTimeField a;
   private int b;

   public MutableDateTime() {
   }

   public MutableDateTime(long var1, Chronology var3) {
      super(var1, var3);
   }

   public MutableDateTime(long var1, DateTimeZone var3) {
      super(var1, var3);
   }

   public MutableDateTime.Property a(DateTimeFieldType var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("The DateTimeFieldType must not be null");
      } else {
         DateTimeField var2 = var1.a(this.d());
         if (!var2.c()) {
            throw new IllegalArgumentException("Field '" + var1 + "' is not supported");
         } else {
            return new MutableDateTime.Property(this, var2);
         }
      }
   }

   @Override
   public void a(long var1) {
      long var3 = var1;
      switch (this.b) {
         case 0:
            break;
         case 1:
            var3 = this.a.d(var1);
            break;
         case 2:
            var3 = this.a.e(var1);
            break;
         case 3:
            var3 = this.a.f(var1);
            break;
         case 4:
            var3 = this.a.g(var1);
            break;
         case 5:
            var3 = this.a.h(var1);
            break;
         default:
            var3 = var1;
      }

      super.a(var3);
   }

   @Override
   public void a(Chronology var1) {
      super.a(var1);
   }

   public void a(DateTimeZone var1) {
      DateTimeZone var4 = DateTimeUtils.a(var1);
      var1 = DateTimeUtils.a(this.h());
      if (var4 != var1) {
         long var2 = var1.a(var4, this.c());
         this.a(this.d().a(var4));
         this.a(var2);
      }
   }

   @Override
   public Object clone() {
      try {
         return super.clone();
      } catch (CloneNotSupportedException var2) {
         throw new InternalError("Clone error");
      }
   }

   public static final class Property extends AbstractReadableInstantFieldProperty {
      private MutableDateTime a;
      private DateTimeField b;

      Property(MutableDateTime var1, DateTimeField var2) {
         this.a = var1;
         this.b = var2;
      }

      private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
         this.a = (MutableDateTime)var1.readObject();
         this.b = ((DateTimeFieldType)var1.readObject()).a(this.a.d());
      }

      private void writeObject(ObjectOutputStream var1) throws IOException {
         var1.writeObject(this.a);
         var1.writeObject(this.b.a());
      }

      @Override
      public DateTimeField a() {
         return this.b;
      }

      public MutableDateTime a(int var1) {
         this.a.a(this.a().b(this.a.c(), var1));
         return this.a;
      }

      @Override
      protected long b() {
         return this.a.c();
      }

      @Override
      protected Chronology c() {
         return this.a.d();
      }
   }
}

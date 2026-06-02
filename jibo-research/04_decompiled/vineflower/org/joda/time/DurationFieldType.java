package org.joda.time;

import java.io.Serializable;

public abstract class DurationFieldType implements Serializable {
   static final DurationFieldType a = new DurationFieldType.StandardDurationFieldType("eras", (byte)1);
   static final DurationFieldType b = new DurationFieldType.StandardDurationFieldType("centuries", (byte)2);
   static final DurationFieldType c = new DurationFieldType.StandardDurationFieldType("weekyears", (byte)3);
   static final DurationFieldType d = new DurationFieldType.StandardDurationFieldType("years", (byte)4);
   static final DurationFieldType e = new DurationFieldType.StandardDurationFieldType("months", (byte)5);
   static final DurationFieldType f = new DurationFieldType.StandardDurationFieldType("weeks", (byte)6);
   static final DurationFieldType g = new DurationFieldType.StandardDurationFieldType("days", (byte)7);
   static final DurationFieldType h = new DurationFieldType.StandardDurationFieldType("halfdays", (byte)8);
   static final DurationFieldType i = new DurationFieldType.StandardDurationFieldType("hours", (byte)9);
   static final DurationFieldType j = new DurationFieldType.StandardDurationFieldType("minutes", (byte)10);
   static final DurationFieldType k = new DurationFieldType.StandardDurationFieldType("seconds", (byte)11);
   static final DurationFieldType l = new DurationFieldType.StandardDurationFieldType("millis", (byte)12);
   private final String m;

   protected DurationFieldType(String var1) {
      this.m = var1;
   }

   public static DurationFieldType a() {
      return l;
   }

   public static DurationFieldType b() {
      return k;
   }

   public static DurationFieldType c() {
      return j;
   }

   public static DurationFieldType d() {
      return i;
   }

   public static DurationFieldType e() {
      return h;
   }

   public static DurationFieldType f() {
      return g;
   }

   public static DurationFieldType g() {
      return f;
   }

   public static DurationFieldType h() {
      return c;
   }

   public static DurationFieldType i() {
      return e;
   }

   public static DurationFieldType j() {
      return d;
   }

   public static DurationFieldType k() {
      return b;
   }

   public static DurationFieldType l() {
      return a;
   }

   public abstract DurationField a(Chronology var1);

   public String m() {
      return this.m;
   }

   @Override
   public String toString() {
      return this.m();
   }

   private static class StandardDurationFieldType extends DurationFieldType {
      private final byte m;

      StandardDurationFieldType(String var1, byte var2) {
         super(var1);
         this.m = var2;
      }

      private Object readResolve() {
         DurationFieldType var1;
         switch (this.m) {
            case 1:
               var1 = a;
               break;
            case 2:
               var1 = b;
               break;
            case 3:
               var1 = c;
               break;
            case 4:
               var1 = d;
               break;
            case 5:
               var1 = e;
               break;
            case 6:
               var1 = f;
               break;
            case 7:
               var1 = g;
               break;
            case 8:
               var1 = h;
               break;
            case 9:
               var1 = i;
               break;
            case 10:
               var1 = j;
               break;
            case 11:
               var1 = k;
               break;
            case 12:
               var1 = l;
               break;
            default:
               var1 = this;
         }

         return var1;
      }

      @Override
      public DurationField a(Chronology var1) {
         var1 = DateTimeUtils.a(var1);
         DurationField var3;
         switch (this.m) {
            case 1:
               var3 = var1.J();
               break;
            case 2:
               var3 = var1.H();
               break;
            case 3:
               var3 = var1.y();
               break;
            case 4:
               var3 = var1.D();
               break;
            case 5:
               var3 = var1.B();
               break;
            case 6:
               var3 = var1.w();
               break;
            case 7:
               var3 = var1.s();
               break;
            case 8:
               var3 = var1.o();
               break;
            case 9:
               var3 = var1.l();
               break;
            case 10:
               var3 = var1.i();
               break;
            case 11:
               var3 = var1.f();
               break;
            case 12:
               var3 = var1.c();
               break;
            default:
               throw new InternalError();
         }

         return var3;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2 = true;
         if (this != var1) {
            if (var1 instanceof DurationFieldType.StandardDurationFieldType) {
               if (this.m != ((DurationFieldType.StandardDurationFieldType)var1).m) {
                  var2 = false;
               }
            } else {
               var2 = false;
            }
         }

         return var2;
      }

      @Override
      public int hashCode() {
         return 1 << this.m;
      }
   }
}

package com.google.api.client.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DateTime implements Serializable {
   private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
   private static final Pattern RFC3339_PATTERN = Pattern.compile(
      "^(\\d{4})-(\\d{2})-(\\d{2})([Tt](\\d{2}):(\\d{2}):(\\d{2})(\\.\\d+)?)?([Zz]|([+-])(\\d{2}):(\\d{2}))?"
   );
   private static final long serialVersionUID = 1L;
   private final boolean dateOnly;
   private final int tzShift;
   private final long value;

   public DateTime(long var1) {
      this(false, var1, null);
   }

   public DateTime(long var1, int var3) {
      this(false, var1, var3);
   }

   public DateTime(String var1) {
      DateTime var2 = parseRfc3339(var1);
      this.dateOnly = var2.dateOnly;
      this.value = var2.value;
      this.tzShift = var2.tzShift;
   }

   public DateTime(Date var1) {
      this(var1.getTime());
   }

   public DateTime(Date var1, TimeZone var2) {
      long var3 = var1.getTime();
      Integer var5;
      if (var2 == null) {
         var5 = null;
      } else {
         var5 = var2.getOffset(var1.getTime()) / 60000;
      }

      this(false, var3, var5);
   }

   public DateTime(boolean var1, long var2, Integer var4) {
      this.dateOnly = var1;
      this.value = var2;
      int var5;
      if (var1) {
         var5 = 0;
      } else if (var4 == null) {
         var5 = TimeZone.getDefault().getOffset(var2) / 60000;
      } else {
         var5 = var4;
      }

      this.tzShift = var5;
   }

   private static void appendInt(StringBuilder var0, int var1, int var2) {
      int var3 = var1;
      if (var1 < 0) {
         var0.append('-');
         var3 = -var1;
      }

      var1 = var3;

      while (var1 > 0) {
         var1 /= 10;
         var2--;
      }

      for (int var5 = 0; var5 < var2; var5++) {
         var0.append('0');
      }

      if (var3 != 0) {
         var0.append(var3);
      }
   }

   public static DateTime parseRfc3339(String var0) throws NumberFormatException {
      Matcher var15 = RFC3339_PATTERN.matcher(var0);
      if (!var15.matches()) {
         var0 = String.valueOf(var0);
         if (var0.length() != 0) {
            var0 = "Invalid date/time format: ".concat(var0);
         } else {
            var0 = new String("Invalid date/time format: ");
         }

         throw new NumberFormatException(var0);
      } else {
         int var11 = Integer.parseInt(var15.group(1));
         int var9 = Integer.parseInt(var15.group(2));
         int var10 = Integer.parseInt(var15.group(3));
         boolean var4;
         if (var15.group(4) != null) {
            var4 = true;
         } else {
            var4 = false;
         }

         String var16 = var15.group(9);
         boolean var5;
         if (var16 != null) {
            var5 = true;
         } else {
            var5 = false;
         }

         int var1 = 0;
         int var3 = 0;
         int var2 = 0;
         if (var5 && !var4) {
            String var29 = String.valueOf("Invalid date/time format, cannot specify time zone shift without specifying time: ");
            var0 = String.valueOf(var0);
            if (var0.length() != 0) {
               var0 = var29.concat(var0);
            } else {
               var0 = new String(var29);
            }

            throw new NumberFormatException(var0);
         } else {
            int var8;
            label62: {
               if (var4) {
                  int var6 = Integer.parseInt(var15.group(5));
                  int var7 = Integer.parseInt(var15.group(6));
                  var8 = Integer.parseInt(var15.group(7));
                  var1 = var6;
                  var3 = var7;
                  var2 = var8;
                  if (var15.group(8) != null) {
                     var1 = Integer.parseInt(var15.group(8).substring(1));
                     var2 = var15.group(8).substring(1).length();
                     var2 = (int)(var1 / Math.pow(10.0, var2 - 3));
                     var3 = var7;
                     var1 = var6;
                     break label62;
                  }
               }

               byte var28 = 0;
               var8 = var2;
               var2 = var28;
            }

            GregorianCalendar var17 = new GregorianCalendar(GMT);
            var17.set(var11, var9 - 1, var10, var1, var3, var8);
            var17.set(14, var2);
            long var12 = var17.getTimeInMillis();
            Integer var18;
            if (var4 && var5) {
               if (Character.toUpperCase(var16.charAt(0)) == 'Z') {
                  var1 = 0;
               } else {
                  var2 = Integer.parseInt(var15.group(11)) * 60 + Integer.parseInt(var15.group(12));
                  var1 = var2;
                  if (var15.group(10).charAt(0) == '-') {
                     var1 = -var2;
                  }

                  var12 -= var1 * 60000L;
               }

               var18 = var1;
            } else {
               var18 = null;
            }

            boolean var14;
            if (!var4) {
               var14 = true;
            } else {
               var14 = false;
            }

            return new DateTime(var14, var12, var18);
         }
      }
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (var1 != this) {
         if (!(var1 instanceof DateTime)) {
            var2 = false;
         } else {
            var1 = var1;
            if (this.dateOnly != var1.dateOnly || this.value != var1.value || this.tzShift != var1.tzShift) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   public int getTimeZoneShift() {
      return this.tzShift;
   }

   public long getValue() {
      return this.value;
   }

   @Override
   public int hashCode() {
      long var3 = this.value;
      long var1;
      if (this.dateOnly) {
         var1 = 1L;
      } else {
         var1 = 0L;
      }

      return Arrays.hashCode(new long[]{var3, var1, this.tzShift});
   }

   public boolean isDateOnly() {
      return this.dateOnly;
   }

   @Override
   public String toString() {
      return this.toStringRfc3339();
   }

   public String toStringRfc3339() {
      StringBuilder var3 = new StringBuilder();
      GregorianCalendar var2 = new GregorianCalendar(GMT);
      var2.setTimeInMillis(this.value + this.tzShift * 60000L);
      appendInt(var3, var2.get(1), 4);
      var3.append('-');
      appendInt(var3, var2.get(2) + 1, 2);
      var3.append('-');
      appendInt(var3, var2.get(5), 2);
      if (!this.dateOnly) {
         var3.append('T');
         appendInt(var3, var2.get(11), 2);
         var3.append(':');
         appendInt(var3, var2.get(12), 2);
         var3.append(':');
         appendInt(var3, var2.get(13), 2);
         if (var2.isSet(14)) {
            var3.append('.');
            appendInt(var3, var2.get(14), 3);
         }

         if (this.tzShift == 0) {
            var3.append('Z');
         } else {
            int var1 = this.tzShift;
            if (this.tzShift > 0) {
               var3.append('+');
            } else {
               var3.append('-');
               var1 = -var1;
            }

            appendInt(var3, var1 / 60, 2);
            var3.append(':');
            appendInt(var3, var1 % 60, 2);
         }
      }

      return var3.toString();
   }
}

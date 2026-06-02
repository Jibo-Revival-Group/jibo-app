package org.joda.time.convert;

class ConverterSet {
   private final Converter[] a;
   private ConverterSet.Entry[] b;

   ConverterSet(Converter[] var1) {
      this.a = var1;
      this.b = new ConverterSet.Entry[16];
   }

   private static Converter a(ConverterSet var0, Class<?> var1) {
      Object var9 = null;
      Converter[] var7 = var0.a;
      int var2 = var7.length;
      int var4 = var2;
      ConverterSet var6 = var0;

      while (true) {
         if (--var4 < 0) {
            var11 = (Converter)var9;
            if (var1 != null) {
               var11 = (Converter)var9;
               if (var2 != 0) {
                  if (var2 == 1) {
                     var11 = var7[0];
                  } else {
                     var0 = var6;
                     int var18 = var2;
                     Converter[] var20 = var7;

                     while (--var2 >= 0) {
                        Class var21 = var20[var2].a();
                        var4 = var18;

                        while (true) {
                           int var5 = var4 - 1;
                           if (var5 < 0) {
                              break;
                           }

                           var4 = var5;
                           if (var5 != var2) {
                              var4 = var5;
                              if (var20[var5].a().isAssignableFrom(var21)) {
                                 var0 = var0.a(var5, null);
                                 var20 = var0.a;
                                 var18 = var20.length;
                                 var2 = var18 - 1;
                                 var4 = var5;
                              }
                           }
                        }
                     }

                     if (var18 != 1) {
                        StringBuilder var22 = new StringBuilder();
                        var22.append("Unable to find best converter for type \"");
                        var22.append(var1.getName());
                        var22.append("\" from remaining set: ");

                        for (int var17 = 0; var17 < var18; var17++) {
                           Converter var16 = var20[var17];
                           Class var14 = var16.a();
                           var22.append(var16.getClass().getName());
                           var22.append('[');
                           String var15;
                           if (var14 == null) {
                              var15 = null;
                           } else {
                              var15 = var14.getName();
                           }

                           var22.append(var15);
                           var22.append("], ");
                        }

                        throw new IllegalStateException(var22.toString());
                     }

                     var11 = var20[0];
                  }
               }
            }
            break;
         }

         var11 = var7[var4];
         Class var10 = var11.a();
         if (var10 == var1) {
            break;
         }

         int var3;
         Converter[] var8;
         label65: {
            if (var10 != null) {
               var3 = var2;
               var8 = var7;
               var0 = var6;
               if (var1 == null) {
                  break label65;
               }

               var3 = var2;
               var8 = var7;
               var0 = var6;
               if (var10.isAssignableFrom(var1)) {
                  break label65;
               }
            }

            var0 = var6.a(var4, null);
            var8 = var0.a;
            var3 = var8.length;
         }

         var2 = var3;
         var7 = var8;
         var6 = var0;
      }

      return var11;
   }

   int a() {
      return this.a.length;
   }

   Converter a(Class<?> var1) throws IllegalStateException {
      ConverterSet.Entry[] var8 = this.b;
      int var5 = var8.length;
      int var2;
      if (var1 == null) {
         var2 = 0;
      } else {
         var2 = var1.hashCode() & var5 - 1;
      }

      while (true) {
         ConverterSet.Entry var7 = var8[var2];
         if (var7 == null) {
            Converter var15 = a(this, var1);
            ConverterSet.Entry var9 = new ConverterSet.Entry(var1, var15);
            ConverterSet.Entry[] var12 = (ConverterSet.Entry[])var8.clone();
            var12[var2] = var9;

            for (int var13 = 0; var13 < var5; var13++) {
               if (var12[var13] == null) {
                  this.b = var12;
                  Converter var18 = var15;
                  return var18;
               }
            }

            int var6 = var5 << 1;
            ConverterSet.Entry[] var17 = new ConverterSet.Entry[var6];

            for (int var3 = 0; var3 < var5; var3++) {
               ConverterSet.Entry var16 = var12[var3];
               Class var10 = var16.a;
               if (var10 == null) {
                  var2 = 0;
               } else {
                  var2 = var10.hashCode() & var6 - 1;
               }

               while (var17[var2] != null) {
                  int var4 = var2 + 1;
                  var2 = var4;
                  if (var4 >= var6) {
                     var2 = 0;
                  }
               }

               var17[var2] = var16;
            }

            this.b = var17;
            var11 = var15;
            break;
         }

         if (var7.a == var1) {
            var11 = var7.b;
            break;
         }

         if (++var2 >= var5) {
            var2 = 0;
         }
      }

      return var11;
   }

   ConverterSet a(int var1, Converter[] var2) {
      Converter[] var7 = this.a;
      int var6 = var7.length;
      if (var1 >= var6) {
         throw new IndexOutOfBoundsException();
      }

      if (var2 != null) {
         var2[0] = var7[var1];
      }

      var2 = new Converter[var6 - 1];
      int var4 = 0;
      int var3 = 0;

      while (var4 < var6) {
         if (var4 != var1) {
            int var5 = var3 + 1;
            var2[var3] = var7[var4];
            var3 = var5;
         }

         var4++;
      }

      return new ConverterSet(var2);
   }

   static class Entry {
      final Class<?> a;
      final Converter b;

      Entry(Class<?> var1, Converter var2) {
         this.a = var1;
         this.b = var2;
      }
   }
}

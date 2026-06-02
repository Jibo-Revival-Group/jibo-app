package com.yalantis.ucrop.model;

public class ExifInfo {
   private int mExifDegrees;
   private int mExifOrientation;
   private int mExifTranslation;

   public ExifInfo(int var1, int var2, int var3) {
      this.mExifOrientation = var1;
      this.mExifDegrees = var2;
      this.mExifTranslation = var3;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var3 = true;
      boolean var4 = false;
      boolean var2;
      if (this == var1) {
         var2 = true;
      } else {
         var2 = var4;
         if (var1 != null) {
            var2 = var4;
            if (this.getClass() == var1.getClass()) {
               var1 = var1;
               var2 = var4;
               if (this.mExifOrientation == var1.mExifOrientation) {
                  var2 = var4;
                  if (this.mExifDegrees == var1.mExifDegrees) {
                     if (this.mExifTranslation == var1.mExifTranslation) {
                        var2 = var3;
                     } else {
                        var2 = false;
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   public int getExifDegrees() {
      return this.mExifDegrees;
   }

   public int getExifOrientation() {
      return this.mExifOrientation;
   }

   public int getExifTranslation() {
      return this.mExifTranslation;
   }

   @Override
   public int hashCode() {
      return (this.mExifOrientation * 31 + this.mExifDegrees) * 31 + this.mExifTranslation;
   }

   public void setExifDegrees(int var1) {
      this.mExifDegrees = var1;
   }

   public void setExifOrientation(int var1) {
      this.mExifOrientation = var1;
   }

   public void setExifTranslation(int var1) {
      this.mExifTranslation = var1;
   }
}

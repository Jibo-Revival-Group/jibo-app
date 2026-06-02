package org.apache.http.message;

import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class ParserCursor {
   private final int lowerBound;
   private int pos;
   private final int upperBound;

   public ParserCursor(int var1, int var2) {
      if (var1 < 0) {
         throw new IndexOutOfBoundsException("Lower bound cannot be negative");
      }

      if (var1 > var2) {
         throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
      }

      this.lowerBound = var1;
      this.upperBound = var2;
      this.pos = var1;
   }

   public boolean atEnd() {
      boolean var1;
      if (this.pos >= this.upperBound) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public int getLowerBound() {
      return this.lowerBound;
   }

   public int getPos() {
      return this.pos;
   }

   public int getUpperBound() {
      return this.upperBound;
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append('[');
      var1.append(Integer.toString(this.lowerBound));
      var1.append('>');
      var1.append(Integer.toString(this.pos));
      var1.append('>');
      var1.append(Integer.toString(this.upperBound));
      var1.append(']');
      return var1.toString();
   }

   public void updatePos(int var1) {
      if (var1 < this.lowerBound) {
         throw new IndexOutOfBoundsException("pos: " + var1 + " < lowerBound: " + this.lowerBound);
      }

      if (var1 > this.upperBound) {
         throw new IndexOutOfBoundsException("pos: " + var1 + " > upperBound: " + this.upperBound);
      }

      this.pos = var1;
   }
}

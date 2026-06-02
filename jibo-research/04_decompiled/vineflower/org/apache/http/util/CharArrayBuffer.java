package org.apache.http.util;

import java.io.Serializable;
import java.nio.CharBuffer;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.protocol.HTTP;

@NotThreadSafe
public final class CharArrayBuffer implements Serializable, CharSequence {
   private static final long serialVersionUID = -6208952725094867135L;
   private char[] buffer;
   private int len;

   public CharArrayBuffer(int var1) {
      Args.notNegative(var1, "Buffer capacity");
      this.buffer = new char[var1];
   }

   private void expand(int var1) {
      char[] var2 = new char[Math.max(this.buffer.length << 1, var1)];
      System.arraycopy(this.buffer, 0, var2, 0, this.len);
      this.buffer = var2;
   }

   public void append(char var1) {
      int var2 = this.len + 1;
      if (var2 > this.buffer.length) {
         this.expand(var2);
      }

      this.buffer[this.len] = var1;
      this.len = var2;
   }

   public void append(Object var1) {
      this.append(String.valueOf(var1));
   }

   public void append(String var1) {
      if (var1 == null) {
         var1 = "null";
      }

      int var3 = var1.length();
      int var2 = this.len + var3;
      if (var2 > this.buffer.length) {
         this.expand(var2);
      }

      var1.getChars(0, var3, this.buffer, this.len);
      this.len = var2;
   }

   public void append(ByteArrayBuffer var1, int var2, int var3) {
      if (var1 != null) {
         this.append(var1.buffer(), var2, var3);
      }
   }

   public void append(CharArrayBuffer var1) {
      if (var1 != null) {
         this.append(var1.buffer, 0, var1.len);
      }
   }

   public void append(CharArrayBuffer var1, int var2, int var3) {
      if (var1 != null) {
         this.append(var1.buffer, var2, var3);
      }
   }

   public void append(byte[] var1, int var2, int var3) {
      if (var1 != null) {
         if (var2 < 0 || var2 > var1.length || var3 < 0 || var2 + var3 < 0 || var2 + var3 > var1.length) {
            throw new IndexOutOfBoundsException("off: " + var2 + " len: " + var3 + " b.length: " + var1.length);
         }

         if (var3 != 0) {
            int var5 = this.len;
            int var6 = var5 + var3;
            var3 = var5;
            int var4 = var2;
            if (var6 > this.buffer.length) {
               this.expand(var6);
               var4 = var2;
               var3 = var5;
            }

            while (var3 < var6) {
               this.buffer[var3] = (char)(var1[var4] & 0xFF);
               var4++;
               var3++;
            }

            this.len = var6;
         }
      }
   }

   public void append(char[] var1, int var2, int var3) {
      if (var1 != null) {
         if (var2 < 0 || var2 > var1.length || var3 < 0 || var2 + var3 < 0 || var2 + var3 > var1.length) {
            throw new IndexOutOfBoundsException("off: " + var2 + " len: " + var3 + " b.length: " + var1.length);
         }

         if (var3 != 0) {
            int var4 = this.len + var3;
            if (var4 > this.buffer.length) {
               this.expand(var4);
            }

            System.arraycopy(var1, var2, this.buffer, this.len, var3);
            this.len = var4;
         }
      }
   }

   public char[] buffer() {
      return this.buffer;
   }

   public int capacity() {
      return this.buffer.length;
   }

   @Override
   public char charAt(int var1) {
      return this.buffer[var1];
   }

   public void clear() {
      this.len = 0;
   }

   public void ensureCapacity(int var1) {
      if (var1 > 0 && var1 > this.buffer.length - this.len) {
         this.expand(this.len + var1);
      }
   }

   public int indexOf(int var1) {
      return this.indexOf(var1, 0, this.len);
   }

   public int indexOf(int var1, int var2, int var3) {
      byte var6 = -1;
      int var4 = var2;
      if (var2 < 0) {
         var4 = 0;
      }

      int var5 = var3;
      if (var3 > this.len) {
         var5 = this.len;
      }

      if (var4 > var5) {
         var3 = var6;
      } else {
         var2 = var4;

         while (true) {
            var3 = var6;
            if (var2 >= var5) {
               break;
            }

            if (this.buffer[var2] == var1) {
               var3 = var2;
               break;
            }

            var2++;
         }
      }

      return var3;
   }

   @Override
   public boolean isEmpty() {
      boolean var1;
      if (this.len == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean isFull() {
      boolean var1;
      if (this.len == this.buffer.length) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public int length() {
      return this.len;
   }

   public void setLength(int var1) {
      if (var1 >= 0 && var1 <= this.buffer.length) {
         this.len = var1;
      } else {
         throw new IndexOutOfBoundsException("len: " + var1 + " < 0 or > buffer len: " + this.buffer.length);
      }
   }

   @Override
   public CharSequence subSequence(int var1, int var2) {
      if (var1 < 0) {
         throw new IndexOutOfBoundsException("Negative beginIndex: " + var1);
      } else if (var2 > this.len) {
         throw new IndexOutOfBoundsException("endIndex: " + var2 + " > length: " + this.len);
      } else if (var1 > var2) {
         throw new IndexOutOfBoundsException("beginIndex: " + var1 + " > endIndex: " + var2);
      } else {
         return CharBuffer.wrap(this.buffer, var1, var2);
      }
   }

   public String substring(int var1, int var2) {
      if (var1 < 0) {
         throw new IndexOutOfBoundsException("Negative beginIndex: " + var1);
      } else if (var2 > this.len) {
         throw new IndexOutOfBoundsException("endIndex: " + var2 + " > length: " + this.len);
      } else if (var1 > var2) {
         throw new IndexOutOfBoundsException("beginIndex: " + var1 + " > endIndex: " + var2);
      } else {
         return new String(this.buffer, var1, var2 - var1);
      }
   }

   public String substringTrimmed(int var1, int var2) {
      if (var1 < 0) {
         throw new IndexOutOfBoundsException("Negative beginIndex: " + var1);
      }

      if (var2 > this.len) {
         throw new IndexOutOfBoundsException("endIndex: " + var2 + " > length: " + this.len);
      }

      int var3 = var1;
      if (var1 > var2) {
         throw new IndexOutOfBoundsException("beginIndex: " + var1 + " > endIndex: " + var2);
      }

      while (true) {
         var1 = var2;
         if (var3 >= var2) {
            break;
         }

         var1 = var2;
         if (!HTTP.isWhitespace(this.buffer[var3])) {
            break;
         }

         var3++;
      }

      while (var1 > var3 && HTTP.isWhitespace(this.buffer[var1 - 1])) {
         var1--;
      }

      return new String(this.buffer, var3, var1 - var3);
   }

   public char[] toCharArray() {
      char[] var1 = new char[this.len];
      if (this.len > 0) {
         System.arraycopy(this.buffer, 0, var1, 0, this.len);
      }

      return var1;
   }

   @Override
   public String toString() {
      return new String(this.buffer, 0, this.len);
   }
}

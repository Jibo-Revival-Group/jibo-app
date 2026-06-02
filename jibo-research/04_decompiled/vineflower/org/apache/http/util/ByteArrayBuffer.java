package org.apache.http.util;

import java.io.Serializable;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public final class ByteArrayBuffer implements Serializable {
   private static final long serialVersionUID = 4359112959524048036L;
   private byte[] buffer;
   private int len;

   public ByteArrayBuffer(int var1) {
      Args.notNegative(var1, "Buffer capacity");
      this.buffer = new byte[var1];
   }

   private void expand(int var1) {
      byte[] var2 = new byte[Math.max(this.buffer.length << 1, var1)];
      System.arraycopy(this.buffer, 0, var2, 0, this.len);
      this.buffer = var2;
   }

   public void append(int var1) {
      int var2 = this.len + 1;
      if (var2 > this.buffer.length) {
         this.expand(var2);
      }

      this.buffer[this.len] = (byte)var1;
      this.len = var2;
   }

   public void append(CharArrayBuffer var1, int var2, int var3) {
      if (var1 != null) {
         this.append(var1.buffer(), var2, var3);
      }
   }

   public void append(byte[] var1, int var2, int var3) {
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

   public void append(char[] var1, int var2, int var3) {
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
               this.buffer[var3] = (byte)var1[var4];
               var4++;
               var3++;
            }

            this.len = var6;
         }
      }
   }

   public byte[] buffer() {
      return this.buffer;
   }

   public int byteAt(int var1) {
      return this.buffer[var1];
   }

   public int capacity() {
      return this.buffer.length;
   }

   public void clear() {
      this.len = 0;
   }

   public void ensureCapacity(int var1) {
      if (var1 > 0 && var1 > this.buffer.length - this.len) {
         this.expand(this.len + var1);
      }
   }

   public int indexOf(byte var1) {
      return this.indexOf(var1, 0, this.len);
   }

   public int indexOf(byte var1, int var2, int var3) {
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

   public byte[] toByteArray() {
      byte[] var1 = new byte[this.len];
      if (this.len > 0) {
         System.arraycopy(this.buffer, 0, var1, 0, this.len);
      }

      return var1;
   }
}

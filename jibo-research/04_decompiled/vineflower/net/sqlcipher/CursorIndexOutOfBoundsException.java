package net.sqlcipher;

public class CursorIndexOutOfBoundsException extends IndexOutOfBoundsException {
   public CursorIndexOutOfBoundsException(int var1, int var2) {
      super("Index " + var1 + " requested, with a size of " + var2);
   }

   public CursorIndexOutOfBoundsException(String var1) {
      super(var1);
   }
}

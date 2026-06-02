package net.sqlcipher;

import java.util.ArrayList;

public class MatrixCursor extends AbstractCursor {
   private final int columnCount;
   private final String[] columnNames;
   private Object[] data;
   private int rowCount = 0;

   public MatrixCursor(String[] var1) {
      this(var1, 16);
   }

   public MatrixCursor(String[] var1, int var2) {
      this.columnNames = var1;
      this.columnCount = var1.length;
      int var3 = var2;
      if (var2 < 1) {
         var3 = 1;
      }

      this.data = new Object[this.columnCount * var3];
   }

   private void addRow(ArrayList<?> var1, int var2) {
      int var4 = var1.size();
      if (var4 != this.columnCount) {
         throw new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.size() = " + var4);
      }

      this.rowCount++;
      Object[] var5 = this.data;

      for (int var3 = 0; var3 < var4; var3++) {
         var5[var2 + var3] = var1.get(var3);
      }
   }

   private void ensureCapacity(int var1) {
      if (var1 > this.data.length) {
         Object[] var3 = this.data;
         int var2 = this.data.length * 2;
         if (var2 >= var1) {
            var1 = var2;
         }

         this.data = new Object[var1];
         System.arraycopy(var3, 0, this.data, 0, var3.length);
      }
   }

   private Object get(int var1) {
      if (var1 < 0 || var1 >= this.columnCount) {
         throw new CursorIndexOutOfBoundsException("Requested column: " + var1 + ", # of columns: " + this.columnCount);
      } else if (this.mPos < 0) {
         throw new CursorIndexOutOfBoundsException("Before first row.");
      } else if (this.mPos >= this.rowCount) {
         throw new CursorIndexOutOfBoundsException("After last row.");
      } else {
         return this.data[this.mPos * this.columnCount + var1];
      }
   }

   public void addRow(Iterable<?> var1) {
      int var2 = this.rowCount * this.columnCount;
      int var3 = var2 + this.columnCount;
      this.ensureCapacity(var3);
      if (var1 instanceof ArrayList) {
         this.addRow((ArrayList<?>)var1, var2);
      } else {
         Object[] var4 = this.data;

         for (Object var6 : var1) {
            if (var2 == var3) {
               throw new IllegalArgumentException("columnValues.size() > columnNames.length");
            }

            var4[var2] = var6;
            var2++;
         }

         if (var2 != var3) {
            throw new IllegalArgumentException("columnValues.size() < columnNames.length");
         }

         this.rowCount++;
      }
   }

   public void addRow(Object[] var1) {
      if (var1.length != this.columnCount) {
         throw new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.length = " + var1.length);
      }

      int var2 = this.rowCount++;
      var2 *= this.columnCount;
      this.ensureCapacity(this.columnCount + var2);
      System.arraycopy(var1, 0, this.data, var2, this.columnCount);
   }

   @Override
   public String[] getColumnNames() {
      return this.columnNames;
   }

   @Override
   public int getCount() {
      return this.rowCount;
   }

   @Override
   public double getDouble(int var1) {
      Object var4 = this.get(var1);
      double var2;
      if (var4 == null) {
         var2 = 0.0;
      } else if (var4 instanceof Number) {
         var2 = ((Number)var4).doubleValue();
      } else {
         var2 = Double.parseDouble(var4.toString());
      }

      return var2;
   }

   @Override
   public float getFloat(int var1) {
      Object var3 = this.get(var1);
      float var2;
      if (var3 == null) {
         var2 = 0.0F;
      } else if (var3 instanceof Number) {
         var2 = ((Number)var3).floatValue();
      } else {
         var2 = Float.parseFloat(var3.toString());
      }

      return var2;
   }

   @Override
   public int getInt(int var1) {
      Object var2 = this.get(var1);
      if (var2 == null) {
         var1 = 0;
      } else if (var2 instanceof Number) {
         var1 = ((Number)var2).intValue();
      } else {
         var1 = Integer.parseInt(var2.toString());
      }

      return var1;
   }

   @Override
   public long getLong(int var1) {
      Object var4 = this.get(var1);
      long var2;
      if (var4 == null) {
         var2 = 0L;
      } else if (var4 instanceof Number) {
         var2 = ((Number)var4).longValue();
      } else {
         var2 = Long.parseLong(var4.toString());
      }

      return var2;
   }

   @Override
   public short getShort(int var1) {
      Object var3 = this.get(var1);
      short var2;
      if (var3 == null) {
         var2 = 0;
      } else if (var3 instanceof Number) {
         var2 = ((Number)var3).shortValue();
      } else {
         var2 = Short.parseShort(var3.toString());
      }

      return var2;
   }

   @Override
   public String getString(int var1) {
      String var2 = (String)this.get(var1);
      if (var2 == null) {
         var2 = null;
      } else {
         var2 = var2.toString();
      }

      return var2;
   }

   @Override
   public int getType(int var1) {
      return DatabaseUtils.getTypeOfObject(this.get(var1));
   }

   @Override
   public boolean isNull(int var1) {
      boolean var2;
      if (this.get(var1) == null) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public MatrixCursor.RowBuilder newRow() {
      this.rowCount++;
      int var1 = this.rowCount * this.columnCount;
      this.ensureCapacity(var1);
      return new MatrixCursor.RowBuilder(this, var1 - this.columnCount, var1);
   }

   public class RowBuilder {
      private final int endIndex;
      private int index;
      final MatrixCursor this$0;

      RowBuilder(MatrixCursor var1, int var2, int var3) {
         this.this$0 = var1;
         this.index = var2;
         this.endIndex = var3;
      }

      public MatrixCursor.RowBuilder add(Object var1) {
         if (this.index == this.endIndex) {
            throw new CursorIndexOutOfBoundsException("No more columns left.");
         }

         Object[] var3 = this.this$0.data;
         int var2 = this.index++;
         var3[var2] = var1;
         return this;
      }
   }
}

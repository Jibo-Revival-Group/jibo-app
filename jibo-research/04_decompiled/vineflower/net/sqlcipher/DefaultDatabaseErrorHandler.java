package net.sqlcipher;

import android.util.Log;
import java.io.File;
import net.sqlcipher.database.SQLiteDatabase;

public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
   private final String TAG = this.getClass().getSimpleName();

   private void deleteDatabaseFile(String var1) {
      if (!var1.equalsIgnoreCase(":memory:") && var1.trim().length() != 0) {
         Log.e(this.TAG, "deleting the database file: " + var1);

         try {
            File var2 = new File(var1);
            var2.delete();
         } catch (Exception var3) {
            Log.w(this.TAG, "delete failed: " + var3.getMessage());
         }
      }
   }

   @Override
   public void onCorruption(SQLiteDatabase var1) {
      Log.e(this.TAG, "Corruption reported by sqlite on database, deleting: " + var1.getPath());
      if (var1.isOpen()) {
         Log.e(this.TAG, "Database object for corrupted database is already open, closing");

         try {
            var1.close();
         } catch (Exception var3) {
            Log.e(this.TAG, "Exception closing Database object for corrupted database, ignored", var3);
         }
      }

      this.deleteDatabaseFile(var1.getPath());
   }
}

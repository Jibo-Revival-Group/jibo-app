package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class LoaderManager {
   public abstract <D> Loader<D> a(int var1, Bundle var2, LoaderManager.LoaderCallbacks<D> var3);

   public abstract void a(int var1);

   public abstract void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4);

   public boolean a() {
      return false;
   }

   public abstract <D> Loader<D> b(int var1);

   public abstract <D> Loader<D> b(int var1, Bundle var2, LoaderManager.LoaderCallbacks<D> var3);

   public interface LoaderCallbacks<D> {
      Loader<D> a(int var1, Bundle var2);

      void a(Loader<D> var1);

      void a(Loader<D> var1, D var2);
   }
}

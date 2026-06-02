package com.google.api.client.util.store;

import com.google.api.client.util.IOUtils;
import com.google.api.client.util.Maps;
import com.google.api.client.util.Throwables;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class FileDataStoreFactory extends AbstractDataStoreFactory {
   private static final Logger LOGGER = Logger.getLogger(FileDataStoreFactory.class.getName());
   private final File dataDirectory;

   public FileDataStoreFactory(File var1) throws IOException {
      var1 = var1.getCanonicalFile();
      this.dataDirectory = var1;
      if (IOUtils.isSymbolicLink(var1)) {
         String var4 = String.valueOf(String.valueOf(var1));
         throw new IOException(new StringBuilder(var4.length() + 31).append("unable to use a symbolic link: ").append(var4).toString());
      }

      if (!var1.exists() && !var1.mkdirs()) {
         String var3 = String.valueOf(String.valueOf(var1));
         throw new IOException(new StringBuilder(var3.length() + 28).append("unable to create directory: ").append(var3).toString());
      }

      setPermissionsToOwnerOnly(var1);
   }

   static void setPermissionsToOwnerOnly(File var0) throws IOException {
      try {
         Method var2 = File.class.getMethod("setReadable", boolean.class, boolean.class);
         Method var3 = File.class.getMethod("setWritable", boolean.class, boolean.class);
         Method var14 = File.class.getMethod("setExecutable", boolean.class, boolean.class);
         if (!(Boolean)var2.invoke(var0, false, false) || !(Boolean)var3.invoke(var0, false, false) || !(Boolean)var14.invoke(var0, false, false)) {
            Logger var5 = LOGGER;
            String var4 = String.valueOf(String.valueOf(var0));
            StringBuilder var6 = new StringBuilder(var4.length() + 44);
            var5.warning(var6.append("unable to change permissions for everybody: ").append(var4).toString());
         }

         if (!(Boolean)var2.invoke(var0, true, true) || !(Boolean)var3.invoke(var0, true, true) || !(Boolean)var14.invoke(var0, true, true)) {
            Logger var17 = LOGGER;
            String var16 = String.valueOf(String.valueOf(var0));
            StringBuilder var15 = new StringBuilder(var16.length() + 40);
            var17.warning(var15.append("unable to change permissions for owner: ").append(var16).toString());
         }
      } catch (InvocationTargetException var7) {
         Throwable var13 = var7.getCause();
         Throwables.propagateIfPossible(var13, IOException.class);
         throw new RuntimeException(var13);
      } catch (NoSuchMethodException var8) {
         Logger var1 = LOGGER;
         String var12 = String.valueOf(String.valueOf(var0));
         var1.warning(
            new StringBuilder(var12.length() + 93)
               .append("Unable to set permissions for ")
               .append(var12)
               .append(", likely because you are running a version of Java prior to 1.6")
               .toString()
         );
      } catch (SecurityException var9) {
      } catch (IllegalAccessException var10) {
      } catch (IllegalArgumentException var11) {
      }
   }

   @Override
   protected <V extends Serializable> DataStore<V> createDataStore(String var1) throws IOException {
      return new FileDataStoreFactory.FileDataStore<>(this, this.dataDirectory, var1);
   }

   public final File getDataDirectory() {
      return this.dataDirectory;
   }

   static class FileDataStore<V extends Serializable> extends AbstractMemoryDataStore<V> {
      private final File dataFile;

      FileDataStore(FileDataStoreFactory var1, File var2, String var3) throws IOException {
         super(var1, var3);
         this.dataFile = new File(var2, var3);
         if (IOUtils.isSymbolicLink(this.dataFile)) {
            String var4 = String.valueOf(String.valueOf(this.dataFile));
            throw new IOException(new StringBuilder(var4.length() + 31).append("unable to use a symbolic link: ").append(var4).toString());
         }

         if (this.dataFile.createNewFile()) {
            this.keyValueMap = Maps.newHashMap();
            this.save();
         } else {
            this.keyValueMap = IOUtils.deserialize(new FileInputStream(this.dataFile));
         }
      }

      public FileDataStoreFactory getDataStoreFactory() {
         return (FileDataStoreFactory)super.getDataStoreFactory();
      }

      @Override
      void save() throws IOException {
         IOUtils.serialize(this.keyValueMap, new FileOutputStream(this.dataFile));
      }
   }
}

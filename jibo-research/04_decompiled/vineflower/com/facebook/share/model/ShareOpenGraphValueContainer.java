package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Set;

public abstract class ShareOpenGraphValueContainer<P extends ShareOpenGraphValueContainer, E extends ShareOpenGraphValueContainer.Builder> implements ShareModel {
   private final Bundle bundle;

   ShareOpenGraphValueContainer(Parcel var1) {
      this.bundle = var1.readBundle(ShareOpenGraphValueContainer.Builder.class.getClassLoader());
   }

   protected ShareOpenGraphValueContainer(ShareOpenGraphValueContainer.Builder<P, E> var1) {
      this.bundle = (Bundle)var1.bundle.clone();
   }

   public int describeContents() {
      return 0;
   }

   public Object get(String var1) {
      return this.bundle.get(var1);
   }

   public boolean getBoolean(String var1, boolean var2) {
      return this.bundle.getBoolean(var1, var2);
   }

   public boolean[] getBooleanArray(String var1) {
      return this.bundle.getBooleanArray(var1);
   }

   public Bundle getBundle() {
      return (Bundle)this.bundle.clone();
   }

   public double getDouble(String var1, double var2) {
      return this.bundle.getDouble(var1, var2);
   }

   public double[] getDoubleArray(String var1) {
      return this.bundle.getDoubleArray(var1);
   }

   public int getInt(String var1, int var2) {
      return this.bundle.getInt(var1, var2);
   }

   public int[] getIntArray(String var1) {
      return this.bundle.getIntArray(var1);
   }

   public long getLong(String var1, long var2) {
      return this.bundle.getLong(var1, var2);
   }

   public long[] getLongArray(String var1) {
      return this.bundle.getLongArray(var1);
   }

   public ShareOpenGraphObject getObject(String var1) {
      ShareOpenGraphObject var2 = (ShareOpenGraphObject)this.bundle.get(var1);
      if (var2 instanceof ShareOpenGraphObject) {
         var2 = var2;
      } else {
         var2 = null;
      }

      return var2;
   }

   public ArrayList<ShareOpenGraphObject> getObjectArrayList(String var1) {
      ArrayList var2 = this.bundle.getParcelableArrayList(var1);
      ArrayList var4;
      if (var2 == null) {
         var4 = null;
      } else {
         var4 = new ArrayList();

         for (Parcelable var3 : var2) {
            if (var3 instanceof ShareOpenGraphObject) {
               var4.add((ShareOpenGraphObject)var3);
            }
         }
      }

      return var4;
   }

   public SharePhoto getPhoto(String var1) {
      Parcelable var2 = this.bundle.getParcelable(var1);
      SharePhoto var3;
      if (var2 instanceof SharePhoto) {
         var3 = (SharePhoto)var2;
      } else {
         var3 = null;
      }

      return var3;
   }

   public ArrayList<SharePhoto> getPhotoArrayList(String var1) {
      ArrayList var2 = this.bundle.getParcelableArrayList(var1);
      ArrayList var4;
      if (var2 == null) {
         var4 = null;
      } else {
         var4 = new ArrayList();

         for (Parcelable var5 : var2) {
            if (var5 instanceof SharePhoto) {
               var4.add((SharePhoto)var5);
            }
         }
      }

      return var4;
   }

   public String getString(String var1) {
      return this.bundle.getString(var1);
   }

   public ArrayList<String> getStringArrayList(String var1) {
      return this.bundle.getStringArrayList(var1);
   }

   public Set<String> keySet() {
      return this.bundle.keySet();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeBundle(this.bundle);
   }

   public abstract static class Builder<P extends ShareOpenGraphValueContainer, E extends ShareOpenGraphValueContainer.Builder>
      implements ShareModelBuilder<P, E> {
      private Bundle bundle = new Bundle();

      public E putBoolean(String var1, boolean var2) {
         this.bundle.putBoolean(var1, var2);
         return (E)this;
      }

      public E putBooleanArray(String var1, boolean[] var2) {
         this.bundle.putBooleanArray(var1, var2);
         return (E)this;
      }

      public E putDouble(String var1, double var2) {
         this.bundle.putDouble(var1, var2);
         return (E)this;
      }

      public E putDoubleArray(String var1, double[] var2) {
         this.bundle.putDoubleArray(var1, var2);
         return (E)this;
      }

      public E putInt(String var1, int var2) {
         this.bundle.putInt(var1, var2);
         return (E)this;
      }

      public E putIntArray(String var1, int[] var2) {
         this.bundle.putIntArray(var1, var2);
         return (E)this;
      }

      public E putLong(String var1, long var2) {
         this.bundle.putLong(var1, var2);
         return (E)this;
      }

      public E putLongArray(String var1, long[] var2) {
         this.bundle.putLongArray(var1, var2);
         return (E)this;
      }

      public E putObject(String var1, ShareOpenGraphObject var2) {
         this.bundle.putParcelable(var1, var2);
         return (E)this;
      }

      public E putObjectArrayList(String var1, ArrayList<ShareOpenGraphObject> var2) {
         this.bundle.putParcelableArrayList(var1, var2);
         return (E)this;
      }

      public E putPhoto(String var1, SharePhoto var2) {
         this.bundle.putParcelable(var1, var2);
         return (E)this;
      }

      public E putPhotoArrayList(String var1, ArrayList<SharePhoto> var2) {
         this.bundle.putParcelableArrayList(var1, var2);
         return (E)this;
      }

      public E putString(String var1, String var2) {
         this.bundle.putString(var1, var2);
         return (E)this;
      }

      public E putStringArrayList(String var1, ArrayList<String> var2) {
         this.bundle.putStringArrayList(var1, var2);
         return (E)this;
      }

      public E readFrom(P var1) {
         if (var1 != null) {
            this.bundle.putAll(var1.getBundle());
         }

         return (E)this;
      }
   }
}

package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public abstract class ShareMedia implements ShareModel {
   private final Bundle params;

   ShareMedia(Parcel var1) {
      this.params = var1.readBundle();
   }

   protected ShareMedia(ShareMedia.Builder var1) {
      this.params = new Bundle(var1.params);
   }

   public int describeContents() {
      return 0;
   }

   public abstract ShareMedia.Type getMediaType();

   @Deprecated
   public Bundle getParameters() {
      return new Bundle(this.params);
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeBundle(this.params);
   }

   public abstract static class Builder<M extends ShareMedia, B extends ShareMedia.Builder> implements ShareModelBuilder<M, B> {
      private Bundle params = new Bundle();

      static List<ShareMedia> readListFrom(Parcel var0) {
         Parcelable[] var3 = var0.readParcelableArray(ShareMedia.class.getClassLoader());
         ArrayList var4 = new ArrayList(var3.length);
         int var2 = var3.length;

         for (int var1 = 0; var1 < var2; var1++) {
            var4.add((ShareMedia)var3[var1]);
         }

         return var4;
      }

      static void writeListTo(Parcel var0, int var1, List<ShareMedia> var2) {
         var0.writeParcelableArray((ShareMedia[])var2.toArray(), var1);
      }

      public B readFrom(M var1) {
         ShareMedia.Builder var2;
         if (var1 == null) {
            var2 = this;
         } else {
            var2 = this.setParameters(var1.getParameters());
         }

         return (B)var2;
      }

      @Deprecated
      public B setParameter(String var1, String var2) {
         this.params.putString(var1, var2);
         return (B)this;
      }

      @Deprecated
      public B setParameters(Bundle var1) {
         this.params.putAll(var1);
         return (B)this;
      }
   }

   public enum Type {
      PHOTO,
      VIDEO;

      private static final ShareMedia.Type[] $VALUES = new ShareMedia.Type[]{ShareMedia.Type.PHOTO, ShareMedia.Type.VIDEO};
   }
}

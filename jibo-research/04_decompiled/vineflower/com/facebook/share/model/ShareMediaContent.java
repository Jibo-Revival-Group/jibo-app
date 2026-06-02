package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ShareMediaContent extends ShareContent<ShareMediaContent, ShareMediaContent.Builder> {
   public static final Creator<ShareMediaContent> CREATOR = new Creator<ShareMediaContent>() {
      public ShareMediaContent createFromParcel(Parcel var1) {
         return new ShareMediaContent(var1);
      }

      public ShareMediaContent[] newArray(int var1) {
         return new ShareMediaContent[var1];
      }
   };
   private final List<ShareMedia> media;

   ShareMediaContent(Parcel var1) {
      super(var1);
      this.media = Arrays.asList((ShareMedia[])var1.readParcelableArray(ShareMedia.class.getClassLoader()));
   }

   private ShareMediaContent(ShareMediaContent.Builder var1) {
      super(var1);
      this.media = Collections.unmodifiableList(var1.media);
   }

   @Override
   public int describeContents() {
      return 0;
   }

   public List<ShareMedia> getMedia() {
      return this.media;
   }

   @Override
   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeParcelableArray((ShareMedia[])this.media.toArray(), var2);
   }

   public static class Builder extends ShareContent.Builder<ShareMediaContent, ShareMediaContent.Builder> {
      private final List<ShareMedia> media = new ArrayList<>();

      public ShareMediaContent.Builder addMedia(List<ShareMedia> var1) {
         if (var1 != null) {
            Iterator var2 = var1.iterator();

            while (var2.hasNext()) {
               this.addMedium((ShareMedia)var2.next());
            }
         }

         return this;
      }

      public ShareMediaContent.Builder addMedium(ShareMedia var1) {
         if (var1 != null) {
            if (var1 instanceof SharePhoto) {
               var1 = new SharePhoto.Builder().readFrom((SharePhoto)var1).build();
            } else {
               if (!(var1 instanceof ShareVideo)) {
                  throw new IllegalArgumentException("medium must be either a SharePhoto or ShareVideo");
               }

               var1 = new ShareVideo.Builder().readFrom((ShareVideo)var1).build();
            }

            this.media.add(var1);
         }

         return this;
      }

      public ShareMediaContent build() {
         return new ShareMediaContent(this);
      }

      public ShareMediaContent.Builder readFrom(ShareMediaContent var1) {
         ShareMediaContent.Builder var2;
         if (var1 == null) {
            var2 = this;
         } else {
            var2 = ((ShareMediaContent.Builder)super.readFrom(var1)).addMedia(var1.getMedia());
         }

         return var2;
      }

      public ShareMediaContent.Builder setMedia(List<ShareMedia> var1) {
         this.media.clear();
         this.addMedia(var1);
         return this;
      }
   }
}

package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ShareContent<P extends ShareContent, E extends ShareContent.Builder> implements ShareModel {
   private final Uri contentUrl;
   private final ShareHashtag hashtag;
   private final List<String> peopleIds;
   private final String placeId;
   private final String ref;

   protected ShareContent(Parcel var1) {
      this.contentUrl = (Uri)var1.readParcelable(Uri.class.getClassLoader());
      this.peopleIds = this.readUnmodifiableStringList(var1);
      this.placeId = var1.readString();
      this.ref = var1.readString();
      this.hashtag = new ShareHashtag.Builder().readFrom(var1).build();
   }

   protected ShareContent(ShareContent.Builder var1) {
      this.contentUrl = var1.contentUrl;
      this.peopleIds = var1.peopleIds;
      this.placeId = var1.placeId;
      this.ref = var1.ref;
      this.hashtag = var1.hashtag;
   }

   private List<String> readUnmodifiableStringList(Parcel var1) {
      ArrayList var2 = new ArrayList();
      var1.readStringList(var2);
      List var3;
      if (var2.size() == 0) {
         var3 = null;
      } else {
         var3 = Collections.unmodifiableList(var2);
      }

      return var3;
   }

   public int describeContents() {
      return 0;
   }

   public Uri getContentUrl() {
      return this.contentUrl;
   }

   public List<String> getPeopleIds() {
      return this.peopleIds;
   }

   public String getPlaceId() {
      return this.placeId;
   }

   public String getRef() {
      return this.ref;
   }

   public ShareHashtag getShareHashtag() {
      return this.hashtag;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeParcelable(this.contentUrl, 0);
      var1.writeStringList(this.peopleIds);
      var1.writeString(this.placeId);
      var1.writeString(this.ref);
      var1.writeParcelable(this.hashtag, 0);
   }

   public abstract static class Builder<P extends ShareContent, E extends ShareContent.Builder> implements ShareModelBuilder<P, E> {
      private Uri contentUrl;
      private ShareHashtag hashtag;
      private List<String> peopleIds;
      private String placeId;
      private String ref;

      public E readFrom(P var1) {
         ShareContent.Builder var2;
         if (var1 == null) {
            var2 = this;
         } else {
            var2 = this.setContentUrl(var1.getContentUrl()).setPeopleIds(var1.getPeopleIds()).setPlaceId(var1.getPlaceId()).setRef(var1.getRef());
         }

         return (E)var2;
      }

      public E setContentUrl(Uri var1) {
         this.contentUrl = var1;
         return (E)this;
      }

      public E setPeopleIds(List<String> var1) {
         if (var1 == null) {
            var1 = null;
         } else {
            var1 = Collections.unmodifiableList(var1);
         }

         this.peopleIds = var1;
         return (E)this;
      }

      public E setPlaceId(String var1) {
         this.placeId = var1;
         return (E)this;
      }

      public E setRef(String var1) {
         this.ref = var1;
         return (E)this;
      }

      public E setShareHashtag(ShareHashtag var1) {
         this.hashtag = var1;
         return (E)this;
      }
   }
}

package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

public final class VideoRecordingDetails extends GenericJson {
   @Key
   private GeoPoint location;
   @Key
   private String locationDescription;
   @Key
   private DateTime recordingDate;

   public VideoRecordingDetails clone() {
      return (VideoRecordingDetails)super.clone();
   }

   public GeoPoint getLocation() {
      return this.location;
   }

   public String getLocationDescription() {
      return this.locationDescription;
   }

   public DateTime getRecordingDate() {
      return this.recordingDate;
   }

   public VideoRecordingDetails set(String var1, Object var2) {
      return (VideoRecordingDetails)super.set(var1, var2);
   }

   public VideoRecordingDetails setLocation(GeoPoint var1) {
      this.location = var1;
      return this;
   }

   public VideoRecordingDetails setLocationDescription(String var1) {
      this.locationDescription = var1;
      return this;
   }

   public VideoRecordingDetails setRecordingDate(DateTime var1) {
      this.recordingDate = var1;
      return this;
   }
}

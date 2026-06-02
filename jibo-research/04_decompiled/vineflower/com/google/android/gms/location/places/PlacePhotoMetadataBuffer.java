package com.google.android.gms.location.places;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzar;

public class PlacePhotoMetadataBuffer extends AbstractDataBuffer<PlacePhotoMetadata> {
   public PlacePhotoMetadataBuffer(DataHolder var1) {
      super(var1);
   }

   public PlacePhotoMetadata b(int var1) {
      return new zzar(this.a, var1);
   }
}

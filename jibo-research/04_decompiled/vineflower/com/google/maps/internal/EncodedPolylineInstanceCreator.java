package com.google.maps.internal;

import com.google.gson.InstanceCreator;
import com.google.maps.model.EncodedPolyline;
import java.lang.reflect.Type;

public class EncodedPolylineInstanceCreator implements InstanceCreator<EncodedPolyline> {
   private String points;

   public EncodedPolylineInstanceCreator(String var1) {
      this.points = var1;
   }

   public EncodedPolyline createInstance(Type var1) {
      return new EncodedPolyline(this.points);
   }
}

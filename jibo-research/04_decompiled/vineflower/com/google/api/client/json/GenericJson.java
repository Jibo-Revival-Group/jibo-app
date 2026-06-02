package com.google.api.client.json;

import com.google.api.client.util.GenericData;
import com.google.api.client.util.Throwables;
import java.io.IOException;

public class GenericJson extends GenericData implements Cloneable {
   private JsonFactory jsonFactory;

   public GenericJson clone() {
      return (GenericJson)super.clone();
   }

   public final JsonFactory getFactory() {
      return this.jsonFactory;
   }

   public GenericJson set(String var1, Object var2) {
      return (GenericJson)super.set(var1, var2);
   }

   public final void setFactory(JsonFactory var1) {
      this.jsonFactory = var1;
   }

   public String toPrettyString() throws IOException {
      String var1;
      if (this.jsonFactory != null) {
         var1 = this.jsonFactory.toPrettyString(this);
      } else {
         var1 = super.toString();
      }

      return var1;
   }

   @Override
   public String toString() {
      String var1;
      if (this.jsonFactory != null) {
         try {
            var1 = this.jsonFactory.toString(this);
         } catch (IOException var2) {
            throw Throwables.propagate(var2);
         }
      } else {
         var1 = super.toString();
      }

      return var1;
   }
}

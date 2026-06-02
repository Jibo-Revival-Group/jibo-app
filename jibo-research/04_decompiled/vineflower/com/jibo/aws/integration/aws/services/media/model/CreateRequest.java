package com.jibo.aws.integration.aws.services.media.model;

import com.google.gson.annotations.Expose;
import com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest;
import java.io.File;

public class CreateRequest extends CreateBinaryRequest {
   @Expose
   private Boolean isEncrypted;
   @Expose
   private String loopId;
   @Expose
   private String reference;
   @Expose
   private String type;

   public CreateRequest(String var1, String var2, String var3, String var4, File var5, Boolean var6) {
      super(var4, var5, null);
      this.loopId = var1;
      this.type = var2;
      this.reference = var3;
      this.isEncrypted = var6;
   }

   public String getLoopId() {
      return this.loopId;
   }

   public String getReference() {
      return this.reference;
   }

   @Override
   public String getServiceAbbr() {
      return "media";
   }

   @Override
   public String getServicePrefix() {
      return "Media_20160725.";
   }

   public String getType() {
      return this.type;
   }

   @Override
   public int hashCode() {
      int var4 = 0;
      int var1;
      if (this.getLoopId() == null) {
         var1 = 0;
      } else {
         var1 = this.getLoopId().hashCode();
      }

      int var2;
      if (this.getType() == null) {
         var2 = 0;
      } else {
         var2 = this.getType().hashCode();
      }

      int var3;
      if (this.getReference() == null) {
         var3 = 0;
      } else {
         var3 = this.getReference().hashCode();
      }

      if (this.isEncrypted() != null) {
         var4 = this.isEncrypted().hashCode();
      }

      return (var3 + (var2 + (var1 + 31) * 31) * 31) * 31 + var4;
   }

   public Boolean isEncrypted() {
      return this.isEncrypted;
   }

   public void setEncrypted(Boolean var1) {
      this.isEncrypted = var1;
   }

   public void setLoopId(String var1) {
      this.loopId = var1;
   }

   public void setReference(String var1) {
      this.reference = var1;
   }

   public void setType(String var1) {
      this.type = var1;
   }
}

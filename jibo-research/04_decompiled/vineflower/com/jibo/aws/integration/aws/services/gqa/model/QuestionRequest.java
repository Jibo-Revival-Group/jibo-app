package com.jibo.aws.integration.aws.services.gqa.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionRequest extends GQABaseRequest {
   @Expose
   @SerializedName(a = "Input")
   private String input;

   public QuestionRequest(String var1) {
      this.input = var1;
   }

   public String getInput() {
      return this.input;
   }

   public void setInput(String var1) {
      this.input = var1;
   }
}

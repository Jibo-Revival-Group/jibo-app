package com.salesforce.android.cases.core.requests;

public class CommentPostRequest extends FetchSaveRequest {
   private final String a;
   private final String b;
   private final String c;

   CommentPostRequest(CommentPostRequest.CommentPostRequestBuilder var1) {
      super(var1);
      this.a = var1.a;
      this.c = var1.b;
      this.b = var1.c;
   }

   public String a() {
      return this.a;
   }

   public String b() {
      return this.c;
   }

   public String c() {
      return this.b;
   }

   public static class CommentPostRequestBuilder extends NoCacheRequestBuilder<CommentPostRequest.CommentPostRequestBuilder> {
      private final String a;
      private final String b;
      private final String c;

      public CommentPostRequestBuilder(String var1, String var2, String var3) {
         this.c = var1;
         this.a = var2;
         this.b = var3;
      }

      protected CommentPostRequest.CommentPostRequestBuilder a() {
         return this;
      }

      public CommentPostRequest b() {
         return new CommentPostRequest(this);
      }
   }
}

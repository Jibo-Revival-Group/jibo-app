package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.ActorResponse;
import com.salesforce.android.cases.core.internal.http.response.BodyResponse;
import com.salesforce.android.cases.core.internal.http.response.CommentPostResponse;
import com.salesforce.android.cases.core.internal.http.response.PhotoResponse;
import com.salesforce.android.cases.core.internal.util.DateUtils;
import com.salesforce.android.cases.core.model.Actor;
import com.salesforce.android.cases.core.model.Body;
import com.salesforce.android.cases.core.model.CommentPost;
import java.util.Date;

public class CommentPostModel implements CommentPost {
   private CommentPostModel.ActorModel a;
   private CommentPostModel.BodyModel b;
   private Date c;
   private String d;
   private Date e;
   private String f;
   private String g;
   private String h;
   private String i;

   public CommentPostModel(CommentPostResponse var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("CommentPostResponse cannot be null");
      }

      if (var1.a() != null) {
         this.a = new CommentPostModel.ActorModel(this, var1.a());
      }

      if (var1.b() != null) {
         this.b = new CommentPostModel.BodyModel(this, var1.b());
      }

      this.c = DateUtils.a(var1.c());
      this.d = var1.d();
      this.e = DateUtils.a(var1.e());
      this.f = var1.f();
      this.g = var1.g();
      this.h = var1.h();
      this.i = var1.i();
   }

   public static CommentPostModel a(CommentPostResponse var0) {
      return new CommentPostModel(var0);
   }

   @Override
   public Body a() {
      return this.b;
   }

   @Override
   public Date b() {
      return this.c;
   }

   public class ActorModel implements Actor {
      final CommentPostModel a;
      private String b;
      private String c;
      private String d;
      private String e;
      private boolean f;
      private boolean g;
      private String h;
      private CommentPostModel.PhotoModel i;
      private String j;
      private String k;

      private ActorModel(CommentPostModel var1, ActorResponse var2) {
         this.a = var1;
         this.b = var2.a();
         this.c = var2.b();
         this.d = var2.c();
         this.e = var2.d();
         this.f = var2.e();
         this.g = var2.f();
         this.h = var2.g();
         if (var2.h() != null) {
            this.i = var1.new PhotoModel(var1, var2.h());
         }

         this.j = var2.i();
         this.k = var2.j();
      }

      @Override
      public String a() {
         return this.c;
      }

      @Override
      public String b() {
         return this.e;
      }
   }

   public class BodyModel implements Body {
      final CommentPostModel a;
      private boolean b;
      private String c;

      private BodyModel(CommentPostModel var1, BodyResponse var2) {
         this.a = var1;
         this.b = var2.a();
         this.c = var2.b();
      }

      @Override
      public String a() {
         return this.c;
      }
   }

   public class PhotoModel {
      final CommentPostModel a;
      private String b;
      private String c;
      private String d;
      private String e;
      private String f;
      private String g;

      private PhotoModel(CommentPostModel var1, PhotoResponse var2) {
         this.a = var1;
         this.b = var2.a();
         this.c = var2.b();
         this.d = var2.c();
         this.e = var2.d();
         this.f = var2.e();
         this.g = var2.f();
      }
   }
}

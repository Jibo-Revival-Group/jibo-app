package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class CommentThreadReplies extends GenericJson {
   @Key
   private List<Comment> comments;

   static {
      Data.nullOf(Comment.class);
   }

   public CommentThreadReplies clone() {
      return (CommentThreadReplies)super.clone();
   }

   public List<Comment> getComments() {
      return this.comments;
   }

   public CommentThreadReplies set(String var1, Object var2) {
      return (CommentThreadReplies)super.set(var1, var2);
   }

   public CommentThreadReplies setComments(List<Comment> var1) {
      this.comments = var1;
      return this;
   }
}

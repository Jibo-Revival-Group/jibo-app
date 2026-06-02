package com.google.api.client.googleapis.notifications;

import com.google.api.client.util.Beta;

@Beta
public class TypedNotification<T> extends AbstractNotification {
   private T content;

   public TypedNotification(long var1, String var3, String var4, String var5, String var6) {
      super(var1, var3, var4, var5, var6);
   }

   public TypedNotification(UnparsedNotification var1) {
      super(var1);
   }

   public final T getContent() {
      return this.content;
   }

   public TypedNotification<T> setChanged(String var1) {
      return (TypedNotification<T>)super.setChanged(var1);
   }

   public TypedNotification<T> setChannelExpiration(String var1) {
      return (TypedNotification<T>)super.setChannelExpiration(var1);
   }

   public TypedNotification<T> setChannelId(String var1) {
      return (TypedNotification<T>)super.setChannelId(var1);
   }

   public TypedNotification<T> setChannelToken(String var1) {
      return (TypedNotification<T>)super.setChannelToken(var1);
   }

   public TypedNotification<T> setContent(T var1) {
      this.content = (T)var1;
      return this;
   }

   public TypedNotification<T> setMessageNumber(long var1) {
      return (TypedNotification<T>)super.setMessageNumber(var1);
   }

   public TypedNotification<T> setResourceId(String var1) {
      return (TypedNotification<T>)super.setResourceId(var1);
   }

   public TypedNotification<T> setResourceState(String var1) {
      return (TypedNotification<T>)super.setResourceState(var1);
   }

   public TypedNotification<T> setResourceUri(String var1) {
      return (TypedNotification<T>)super.setResourceUri(var1);
   }

   @Override
   public String toString() {
      return super.toStringHelper().add("content", this.content).toString();
   }
}

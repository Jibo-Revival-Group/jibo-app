package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.SerializableString;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializedString implements SerializableString, Serializable {
   protected final String a;
   protected byte[] b;
   protected transient String c;

   public SerializedString(String var1) {
      if (var1 == null) {
         throw new IllegalStateException("Null String illegal for SerializedString");
      }

      this.a = var1;
   }

   private void readObject(ObjectInputStream var1) throws IOException {
      this.c = var1.readUTF();
   }

   private void writeObject(ObjectOutputStream var1) throws IOException {
      var1.writeUTF(this.a);
   }

   @Override
   public final String a() {
      return this.a;
   }

   @Override
   public final byte[] b() {
      byte[] var2 = this.b;
      byte[] var1 = var2;
      if (var2 == null) {
         var1 = JsonStringEncoder.a().a(this.a);
         this.b = var1;
      }

      return var1;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2;
      if (var1 == this) {
         var2 = true;
      } else if (var1 != null && var1.getClass() == this.getClass()) {
         var1 = var1;
         var2 = this.a.equals(var1.a);
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return this.a.hashCode();
   }

   protected Object readResolve() {
      return new SerializedString(this.c);
   }

   @Override
   public final String toString() {
      return this.a;
   }
}

package com.mixpanel.android.java_websocket.handshake;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class HandshakedataImpl1 implements HandshakeBuilder {
   private byte[] a;
   private TreeMap<String, String> b = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

   @Override
   public void a(String var1, String var2) {
      this.b.put(var1, var2);
   }

   @Override
   public void a(byte[] var1) {
      this.a = var1;
   }

   @Override
   public String b(String var1) {
      String var2 = this.b.get(var1);
      var1 = var2;
      if (var2 == null) {
         var1 = "";
      }

      return var1;
   }

   @Override
   public Iterator<String> b() {
      return Collections.unmodifiableSet(this.b.keySet()).iterator();
   }

   @Override
   public boolean c(String var1) {
      return this.b.containsKey(var1);
   }

   @Override
   public byte[] c() {
      return this.a;
   }
}

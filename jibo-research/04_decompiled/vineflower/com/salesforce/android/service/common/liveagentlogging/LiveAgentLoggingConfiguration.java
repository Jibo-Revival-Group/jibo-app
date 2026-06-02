package com.salesforce.android.service.common.liveagentlogging;

import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LiveAgentLoggingConfiguration implements Serializable {
   protected static final String[] a = new String[]{
      "la1-c1-dfw.salesforceliveagent.com",
      "la1-c2-dfw.salesforceliveagent.com",
      "la2-c1-dfw.salesforceliveagent.com",
      "la2-c2-dfw.salesforceliveagent.com",
      "la1-c1-phx.salesforceliveagent.com",
      "la1-c2-phx.salesforceliveagent.com",
      "la2-c1-phx.salesforceliveagent.com",
      "la2-c2-phx.salesforceliveagent.com"
   };
   private final String[] b;
   private final int c;
   private final int d;
   private final long e;

   protected LiveAgentLoggingConfiguration(LiveAgentLoggingConfiguration.Builder var1) {
      this.b = var1.a.toArray(new String[0]);
      this.c = var1.b;
      this.d = var1.c;
      this.e = var1.d;
   }

   public String[] a() {
      return this.b;
   }

   public int b() {
      return this.c;
   }

   public int c() {
      return this.d;
   }

   public long d() {
      return this.e;
   }

   public static class Builder {
      protected List<String> a = new ArrayList<>();
      protected int b = 20000;
      protected int c = 10;
      protected long d = 15000L;

      public LiveAgentLoggingConfiguration a() {
         if (this.a.isEmpty()) {
            this.a.addAll(Arrays.asList(LiveAgentLoggingConfiguration.a));
         }

         Iterator var1 = this.a.iterator();

         while (var1.hasNext()) {
            Arguments.a((String)var1.next());
         }

         return new LiveAgentLoggingConfiguration(this);
      }
   }
}

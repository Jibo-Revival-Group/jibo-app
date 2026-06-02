package org.apache.http;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Locale;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

@Immutable
public final class HttpHost implements Serializable, Cloneable {
   public static final String DEFAULT_SCHEME_NAME = "http";
   private static final long serialVersionUID = -7529410654042457626L;
   protected final InetAddress address;
   protected final String hostname;
   protected final String lcHostname;
   protected final int port;
   protected final String schemeName;

   public HttpHost(String var1) {
      this(var1, -1, null);
   }

   public HttpHost(String var1, int var2) {
      this(var1, var2, null);
   }

   public HttpHost(String var1, int var2, String var3) {
      this.hostname = Args.containsNoBlanks(var1, "Host name");
      this.lcHostname = var1.toLowerCase(Locale.ROOT);
      if (var3 != null) {
         this.schemeName = var3.toLowerCase(Locale.ROOT);
      } else {
         this.schemeName = "http";
      }

      this.port = var2;
      this.address = null;
   }

   public HttpHost(InetAddress var1) {
      this(var1, -1, null);
   }

   public HttpHost(InetAddress var1, int var2) {
      this(var1, var2, null);
   }

   public HttpHost(InetAddress var1, int var2, String var3) {
      this(Args.notNull(var1, "Inet address"), var1.getHostName(), var2, var3);
   }

   public HttpHost(InetAddress var1, String var2, int var3, String var4) {
      this.address = Args.notNull(var1, "Inet address");
      this.hostname = Args.notNull(var2, "Hostname");
      this.lcHostname = this.hostname.toLowerCase(Locale.ROOT);
      if (var4 != null) {
         this.schemeName = var4.toLowerCase(Locale.ROOT);
      } else {
         this.schemeName = "http";
      }

      this.port = var3;
   }

   public HttpHost(HttpHost var1) {
      Args.notNull(var1, "HTTP host");
      this.hostname = var1.hostname;
      this.lcHostname = var1.lcHostname;
      this.schemeName = var1.schemeName;
      this.port = var1.port;
      this.address = var1.address;
   }

   public static HttpHost create(String var0) {
      Args.containsNoBlanks(var0, "HTTP Host");
      String var4 = null;
      int var1 = var0.indexOf("://");
      String var3 = var0;
      if (var1 > 0) {
         var4 = var0.substring(0, var1);
         var3 = var0.substring(var1 + 3);
      }

      var1 = -1;
      int var2 = var3.lastIndexOf(":");
      var0 = var3;
      if (var2 > 0) {
         try {
            var1 = Integer.parseInt(var3.substring(var2 + 1));
         } catch (NumberFormatException var5) {
            throw new IllegalArgumentException("Invalid HTTP host: " + var3);
         }

         var0 = var3.substring(0, var2);
      }

      return new HttpHost(var0, var1, var4);
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 instanceof HttpHost) {
            var1 = var1;
            if (!this.lcHostname.equals(var1.lcHostname)
               || this.port != var1.port
               || !this.schemeName.equals(var1.schemeName)
               || (this.address == null ? var1.address != null : !this.address.equals(var1.address))) {
               var2 = false;
            }
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   public InetAddress getAddress() {
      return this.address;
   }

   public String getHostName() {
      return this.hostname;
   }

   public int getPort() {
      return this.port;
   }

   public String getSchemeName() {
      return this.schemeName;
   }

   @Override
   public int hashCode() {
      int var2 = LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, this.lcHostname), this.port), this.schemeName);
      int var1 = var2;
      if (this.address != null) {
         var1 = LangUtils.hashCode(var2, this.address);
      }

      return var1;
   }

   public String toHostString() {
      String var2;
      if (this.port != -1) {
         StringBuilder var1 = new StringBuilder(this.hostname.length() + 6);
         var1.append(this.hostname);
         var1.append(":");
         var1.append(Integer.toString(this.port));
         var2 = var1.toString();
      } else {
         var2 = this.hostname;
      }

      return var2;
   }

   @Override
   public String toString() {
      return this.toURI();
   }

   public String toURI() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.schemeName);
      var1.append("://");
      var1.append(this.hostname);
      if (this.port != -1) {
         var1.append(':');
         var1.append(Integer.toString(this.port));
      }

      return var1.toString();
   }
}

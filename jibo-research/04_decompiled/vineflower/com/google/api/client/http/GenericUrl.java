package com.google.api.client.http;

import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.escape.CharEscapers;
import com.google.api.client.util.escape.Escaper;
import com.google.api.client.util.escape.PercentEscaper;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

public class GenericUrl extends GenericData {
   private static final Escaper URI_FRAGMENT_ESCAPER = new PercentEscaper("=&-_.!~*'()@:$,;/?:", false);
   private String fragment;
   private String host;
   private List<String> pathParts;
   private int port = -1;
   private String scheme;
   private String userInfo;

   public GenericUrl() {
   }

   public GenericUrl(String var1) {
      this(parseURL(var1));
   }

   private GenericUrl(String var1, String var2, int var3, String var4, String var5, String var6, String var7) {
      Object var8 = null;
      super();
      this.port = -1;
      this.scheme = var1.toLowerCase();
      this.host = var2;
      this.port = var3;
      this.pathParts = toPathParts(var4);
      if (var5 != null) {
         var1 = CharEscapers.decodeUri(var5);
      } else {
         var1 = null;
      }

      this.fragment = var1;
      if (var6 != null) {
         UrlEncodedParser.parse(var6, this);
      }

      var1 = (String)var8;
      if (var7 != null) {
         var1 = CharEscapers.decodeUri(var7);
      }

      this.userInfo = var1;
   }

   public GenericUrl(URI var1) {
      this(var1.getScheme(), var1.getHost(), var1.getPort(), var1.getRawPath(), var1.getRawFragment(), var1.getRawQuery(), var1.getRawUserInfo());
   }

   public GenericUrl(URL var1) {
      this(var1.getProtocol(), var1.getHost(), var1.getPort(), var1.getPath(), var1.getRef(), var1.getQuery(), var1.getUserInfo());
   }

   static void addQueryParams(Set<Entry<String, Object>> var0, StringBuilder var1) {
      Iterator var5 = var0.iterator();
      boolean var2 = true;

      while (var5.hasNext()) {
         Entry var4 = (Entry)var5.next();
         Object var3 = var4.getValue();
         if (var3 != null) {
            String var7 = CharEscapers.escapeUriQuery((String)var4.getKey());
            if (var3 instanceof Collection) {
               Iterator var6 = ((Collection)var3).iterator();

               while (var6.hasNext()) {
                  var2 = appendParam(var2, var1, var7, var6.next());
               }
            } else {
               var2 = appendParam(var2, var1, var7, var3);
            }
         }
      }
   }

   private static boolean appendParam(boolean var0, StringBuilder var1, String var2, Object var3) {
      if (var0) {
         var0 = false;
         var1.append('?');
      } else {
         var1.append('&');
      }

      var1.append(var2);
      var2 = CharEscapers.escapeUriQuery(var3.toString());
      if (var2.length() != 0) {
         var1.append('=').append(var2);
      }

      return var0;
   }

   private void appendRawPathFromParts(StringBuilder var1) {
      int var3 = this.pathParts.size();

      for (int var2 = 0; var2 < var3; var2++) {
         String var4 = this.pathParts.get(var2);
         if (var2 != 0) {
            var1.append('/');
         }

         if (var4.length() != 0) {
            var1.append(CharEscapers.escapeUriPath(var4));
         }
      }
   }

   private static URL parseURL(String var0) {
      try {
         return new URL(var0);
      } catch (MalformedURLException var1) {
         throw new IllegalArgumentException(var1);
      }
   }

   public static List<String> toPathParts(String var0) {
      ArrayList var6;
      if (var0 != null && var0.length() != 0) {
         ArrayList var5 = new ArrayList();
         boolean var1 = true;
         int var2 = 0;

         while (var1) {
            int var3 = var0.indexOf(47, var2);
            if (var3 != -1) {
               var1 = true;
            } else {
               var1 = false;
            }

            String var4;
            if (var1) {
               var4 = var0.substring(var2, var3);
            } else {
               var4 = var0.substring(var2);
            }

            var5.add(CharEscapers.decodeUri(var4));
            var2 = var3 + 1;
         }

         var6 = var5;
      } else {
         var6 = null;
      }

      return var6;
   }

   private static URI toURI(String var0) {
      try {
         return new URI(var0);
      } catch (URISyntaxException var1) {
         throw new IllegalArgumentException(var1);
      }
   }

   public void appendRawPath(String var1) {
      if (var1 != null && var1.length() != 0) {
         List var4 = toPathParts(var1);
         if (this.pathParts != null && !this.pathParts.isEmpty()) {
            int var2 = this.pathParts.size();
            List var3 = this.pathParts;
            var1 = String.valueOf(this.pathParts.get(var2 - 1));
            String var5 = String.valueOf((String)var4.get(0));
            if (var5.length() != 0) {
               var1 = var1.concat(var5);
            } else {
               var1 = new String(var1);
            }

            var3.set(var2 - 1, var1);
            this.pathParts.addAll(var4.subList(1, var4.size()));
         } else {
            this.pathParts = var4;
         }
      }
   }

   public final String build() {
      String var1 = String.valueOf(this.buildAuthority());
      String var2 = String.valueOf(this.buildRelativeUrl());
      if (var2.length() != 0) {
         var1 = var1.concat(var2);
      } else {
         var1 = new String(var1);
      }

      return var1;
   }

   public final String buildAuthority() {
      StringBuilder var2 = new StringBuilder();
      var2.append(Preconditions.checkNotNull(this.scheme));
      var2.append("://");
      if (this.userInfo != null) {
         var2.append(CharEscapers.escapeUriUserInfo(this.userInfo)).append('@');
      }

      var2.append(Preconditions.checkNotNull(this.host));
      int var1 = this.port;
      if (var1 != -1) {
         var2.append(':').append(var1);
      }

      return var2.toString();
   }

   public final String buildRelativeUrl() {
      StringBuilder var1 = new StringBuilder();
      if (this.pathParts != null) {
         this.appendRawPathFromParts(var1);
      }

      addQueryParams(this.entrySet(), var1);
      String var2 = this.fragment;
      if (var2 != null) {
         var1.append('#').append(URI_FRAGMENT_ESCAPER.escape(var2));
      }

      return var1.toString();
   }

   public GenericUrl clone() {
      GenericUrl var1 = (GenericUrl)super.clone();
      if (this.pathParts != null) {
         var1.pathParts = new ArrayList<>(this.pathParts);
      }

      return var1;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (this == var1) {
         var2 = true;
      } else if (super.equals(var1) && var1 instanceof GenericUrl) {
         var1 = var1;
         var2 = this.build().equals(var1.toString());
      } else {
         var2 = false;
      }

      return var2;
   }

   public Collection<Object> getAll(String var1) {
      Collection var2 = (Collection)this.get(var1);
      if (var2 == null) {
         var2 = Collections.emptySet();
      } else if (var2 instanceof Collection) {
         var2 = Collections.unmodifiableCollection(var2);
      } else {
         var2 = Collections.singleton(var2);
      }

      return var2;
   }

   public Object getFirst(String var1) {
      Object var2 = this.get(var1);
      Iterator var3 = (Iterator)var2;
      if (var2 instanceof Collection) {
         var3 = ((Collection)var2).iterator();
         if (var3.hasNext()) {
            var3 = (Iterator)var3.next();
         } else {
            var3 = null;
         }
      }

      return var3;
   }

   public String getFragment() {
      return this.fragment;
   }

   public String getHost() {
      return this.host;
   }

   public List<String> getPathParts() {
      return this.pathParts;
   }

   public int getPort() {
      return this.port;
   }

   public String getRawPath() {
      String var1;
      if (this.pathParts == null) {
         var1 = null;
      } else {
         StringBuilder var2 = new StringBuilder();
         this.appendRawPathFromParts(var2);
         var1 = var2.toString();
      }

      return var1;
   }

   public final String getScheme() {
      return this.scheme;
   }

   public final String getUserInfo() {
      return this.userInfo;
   }

   @Override
   public int hashCode() {
      return this.build().hashCode();
   }

   public GenericUrl set(String var1, Object var2) {
      return (GenericUrl)super.set(var1, var2);
   }

   public final void setFragment(String var1) {
      this.fragment = var1;
   }

   public final void setHost(String var1) {
      this.host = Preconditions.checkNotNull(var1);
   }

   public void setPathParts(List<String> var1) {
      this.pathParts = var1;
   }

   public final void setPort(int var1) {
      boolean var2;
      if (var1 >= -1) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2, "expected port >= -1");
      this.port = var1;
   }

   public void setRawPath(String var1) {
      this.pathParts = toPathParts(var1);
   }

   public final void setScheme(String var1) {
      this.scheme = Preconditions.checkNotNull(var1);
   }

   public final void setUserInfo(String var1) {
      this.userInfo = var1;
   }

   @Override
   public String toString() {
      return this.build();
   }

   public final URI toURI() {
      return toURI(this.build());
   }

   public final URL toURL() {
      return parseURL(this.build());
   }

   public final URL toURL(String var1) {
      try {
         return new URL(this.toURL(), var1);
      } catch (MalformedURLException var2) {
         throw new IllegalArgumentException(var2);
      }
   }
}

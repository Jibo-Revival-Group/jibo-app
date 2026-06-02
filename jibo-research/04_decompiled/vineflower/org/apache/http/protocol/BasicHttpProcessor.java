package org.apache.http.protocol;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@Deprecated
@NotThreadSafe
public final class BasicHttpProcessor implements Cloneable, HttpProcessor, HttpRequestInterceptorList, HttpResponseInterceptorList {
   protected final List<HttpRequestInterceptor> requestInterceptors = new ArrayList<>();
   protected final List<HttpResponseInterceptor> responseInterceptors = new ArrayList<>();

   public final void addInterceptor(HttpRequestInterceptor var1) {
      this.addRequestInterceptor(var1);
   }

   public final void addInterceptor(HttpRequestInterceptor var1, int var2) {
      this.addRequestInterceptor(var1, var2);
   }

   public final void addInterceptor(HttpResponseInterceptor var1) {
      this.addResponseInterceptor(var1);
   }

   public final void addInterceptor(HttpResponseInterceptor var1, int var2) {
      this.addResponseInterceptor(var1, var2);
   }

   @Override
   public void addRequestInterceptor(HttpRequestInterceptor var1) {
      if (var1 != null) {
         this.requestInterceptors.add(var1);
      }
   }

   @Override
   public void addRequestInterceptor(HttpRequestInterceptor var1, int var2) {
      if (var1 != null) {
         this.requestInterceptors.add(var2, var1);
      }
   }

   @Override
   public void addResponseInterceptor(HttpResponseInterceptor var1) {
      if (var1 != null) {
         this.responseInterceptors.add(var1);
      }
   }

   @Override
   public void addResponseInterceptor(HttpResponseInterceptor var1, int var2) {
      if (var1 != null) {
         this.responseInterceptors.add(var2, var1);
      }
   }

   public void clearInterceptors() {
      this.clearRequestInterceptors();
      this.clearResponseInterceptors();
   }

   @Override
   public void clearRequestInterceptors() {
      this.requestInterceptors.clear();
   }

   @Override
   public void clearResponseInterceptors() {
      this.responseInterceptors.clear();
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      BasicHttpProcessor var1 = (BasicHttpProcessor)super.clone();
      this.copyInterceptors(var1);
      return var1;
   }

   public BasicHttpProcessor copy() {
      BasicHttpProcessor var1 = new BasicHttpProcessor();
      this.copyInterceptors(var1);
      return var1;
   }

   protected void copyInterceptors(BasicHttpProcessor var1) {
      var1.requestInterceptors.clear();
      var1.requestInterceptors.addAll(this.requestInterceptors);
      var1.responseInterceptors.clear();
      var1.responseInterceptors.addAll(this.responseInterceptors);
   }

   @Override
   public HttpRequestInterceptor getRequestInterceptor(int var1) {
      HttpRequestInterceptor var2;
      if (var1 >= 0 && var1 < this.requestInterceptors.size()) {
         var2 = this.requestInterceptors.get(var1);
      } else {
         var2 = null;
      }

      return var2;
   }

   @Override
   public int getRequestInterceptorCount() {
      return this.requestInterceptors.size();
   }

   @Override
   public HttpResponseInterceptor getResponseInterceptor(int var1) {
      HttpResponseInterceptor var2;
      if (var1 >= 0 && var1 < this.responseInterceptors.size()) {
         var2 = this.responseInterceptors.get(var1);
      } else {
         var2 = null;
      }

      return var2;
   }

   @Override
   public int getResponseInterceptorCount() {
      return this.responseInterceptors.size();
   }

   @Override
   public void process(HttpRequest var1, HttpContext var2) throws IOException, HttpException {
      Iterator var3 = this.requestInterceptors.iterator();

      while (var3.hasNext()) {
         ((HttpRequestInterceptor)var3.next()).process(var1, var2);
      }
   }

   @Override
   public void process(HttpResponse var1, HttpContext var2) throws IOException, HttpException {
      Iterator var3 = this.responseInterceptors.iterator();

      while (var3.hasNext()) {
         ((HttpResponseInterceptor)var3.next()).process(var1, var2);
      }
   }

   @Override
   public void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> var1) {
      Iterator var2 = this.requestInterceptors.iterator();

      while (var2.hasNext()) {
         if (var2.next().getClass().equals(var1)) {
            var2.remove();
         }
      }
   }

   @Override
   public void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> var1) {
      Iterator var2 = this.responseInterceptors.iterator();

      while (var2.hasNext()) {
         if (var2.next().getClass().equals(var1)) {
            var2.remove();
         }
      }
   }

   @Override
   public void setInterceptors(List<?> var1) {
      Args.notNull(var1, "Inteceptor list");
      this.requestInterceptors.clear();
      this.responseInterceptors.clear();

      for (Object var2 : var1) {
         if (var2 instanceof HttpRequestInterceptor) {
            this.addInterceptor((HttpRequestInterceptor)var2);
         }

         if (var2 instanceof HttpResponseInterceptor) {
            this.addInterceptor((HttpResponseInterceptor)var2);
         }
      }
   }
}

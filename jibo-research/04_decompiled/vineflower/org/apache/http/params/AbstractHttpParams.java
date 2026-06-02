package org.apache.http.params;

import java.util.Set;

@Deprecated
public abstract class AbstractHttpParams implements HttpParams, HttpParamsNames {
   protected AbstractHttpParams() {
   }

   @Override
   public boolean getBooleanParameter(String var1, boolean var2) {
      Object var3 = this.getParameter(var1);
      if (var3 != null) {
         var2 = (Boolean)var3;
      }

      return var2;
   }

   @Override
   public double getDoubleParameter(String var1, double var2) {
      Object var4 = this.getParameter(var1);
      if (var4 != null) {
         var2 = (Double)var4;
      }

      return var2;
   }

   @Override
   public int getIntParameter(String var1, int var2) {
      Object var3 = this.getParameter(var1);
      if (var3 != null) {
         var2 = (Integer)var3;
      }

      return var2;
   }

   @Override
   public long getLongParameter(String var1, long var2) {
      Object var4 = this.getParameter(var1);
      if (var4 != null) {
         var2 = (Long)var4;
      }

      return var2;
   }

   @Override
   public Set<String> getNames() {
      throw new UnsupportedOperationException();
   }

   @Override
   public boolean isParameterFalse(String var1) {
      boolean var2 = false;
      if (!this.getBooleanParameter(var1, false)) {
         var2 = true;
      }

      return var2;
   }

   @Override
   public boolean isParameterTrue(String var1) {
      return this.getBooleanParameter(var1, false);
   }

   @Override
   public HttpParams setBooleanParameter(String var1, boolean var2) {
      Boolean var3;
      if (var2) {
         var3 = Boolean.TRUE;
      } else {
         var3 = Boolean.FALSE;
      }

      this.setParameter(var1, var3);
      return this;
   }

   @Override
   public HttpParams setDoubleParameter(String var1, double var2) {
      this.setParameter(var1, var2);
      return this;
   }

   @Override
   public HttpParams setIntParameter(String var1, int var2) {
      this.setParameter(var1, var2);
      return this;
   }

   @Override
   public HttpParams setLongParameter(String var1, long var2) {
      this.setParameter(var1, var2);
      return this;
   }
}

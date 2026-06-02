package org.apache.http.params;

import org.apache.http.annotation.ThreadSafe;

@Deprecated
@ThreadSafe
public class SyncBasicHttpParams extends BasicHttpParams {
   private static final long serialVersionUID = 5387834869062660642L;

   @Override
   public void clear() {
      synchronized (this) {
         super.clear();
      }
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      synchronized (this) {
         return super.clone();
      }
   }

   @Override
   public Object getParameter(String var1) {
      synchronized (this) {
         return super.getParameter(var1);
      }
   }

   @Override
   public boolean isParameterSet(String var1) {
      synchronized (this) {
         return super.isParameterSet(var1);
      }
   }

   @Override
   public boolean isParameterSetLocally(String var1) {
      synchronized (this) {
         return super.isParameterSetLocally(var1);
      }
   }

   @Override
   public boolean removeParameter(String var1) {
      synchronized (this) {
         return super.removeParameter(var1);
      }
   }

   @Override
   public HttpParams setParameter(String var1, Object var2) {
      synchronized (this) {
         return super.setParameter(var1, var2);
      }
   }

   @Override
   public void setParameters(String[] var1, Object var2) {
      synchronized (this) {
         super.setParameters(var1, var2);
      }
   }
}

package org.apache.http.protocol;

@Deprecated
public class SyncBasicHttpContext extends BasicHttpContext {
   public SyncBasicHttpContext() {
   }

   public SyncBasicHttpContext(HttpContext var1) {
      super(var1);
   }

   @Override
   public void clear() {
      synchronized (this) {
         super.clear();
      }
   }

   @Override
   public Object getAttribute(String var1) {
      synchronized (this) {
         return super.getAttribute(var1);
      }
   }

   @Override
   public Object removeAttribute(String var1) {
      synchronized (this) {
         return super.removeAttribute(var1);
      }
   }

   @Override
   public void setAttribute(String var1, Object var2) {
      synchronized (this) {
         super.setAttribute(var1, var2);
      }
   }
}

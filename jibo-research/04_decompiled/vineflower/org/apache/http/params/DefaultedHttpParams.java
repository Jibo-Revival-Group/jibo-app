package org.apache.http.params;

import java.util.HashSet;
import java.util.Set;
import org.apache.http.util.Args;

@Deprecated
public final class DefaultedHttpParams extends AbstractHttpParams {
   private final HttpParams defaults;
   private final HttpParams local;

   public DefaultedHttpParams(HttpParams var1, HttpParams var2) {
      this.local = Args.notNull(var1, "Local HTTP parameters");
      this.defaults = var2;
   }

   private Set<String> getNames(HttpParams var1) {
      if (var1 instanceof HttpParamsNames) {
         return ((HttpParamsNames)var1).getNames();
      } else {
         throw new UnsupportedOperationException("HttpParams instance does not implement HttpParamsNames");
      }
   }

   @Override
   public HttpParams copy() {
      return new DefaultedHttpParams(this.local.copy(), this.defaults);
   }

   public Set<String> getDefaultNames() {
      return new HashSet<>(this.getNames(this.defaults));
   }

   public HttpParams getDefaults() {
      return this.defaults;
   }

   public Set<String> getLocalNames() {
      return new HashSet<>(this.getNames(this.local));
   }

   @Override
   public Set<String> getNames() {
      HashSet var1 = new HashSet<>(this.getNames(this.defaults));
      var1.addAll(this.getNames(this.local));
      return var1;
   }

   @Override
   public Object getParameter(String var1) {
      Object var3 = this.local.getParameter(var1);
      Object var2 = var3;
      if (var3 == null) {
         var2 = var3;
         if (this.defaults != null) {
            var2 = this.defaults.getParameter(var1);
         }
      }

      return var2;
   }

   @Override
   public boolean removeParameter(String var1) {
      return this.local.removeParameter(var1);
   }

   @Override
   public HttpParams setParameter(String var1, Object var2) {
      return this.local.setParameter(var1, var2);
   }
}

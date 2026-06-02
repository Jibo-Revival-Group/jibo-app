package org.apache.http.params;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;

@Deprecated
@ThreadSafe
public class BasicHttpParams extends AbstractHttpParams implements Serializable, Cloneable {
   private static final long serialVersionUID = -7086398485908701455L;
   private final Map<String, Object> parameters = new ConcurrentHashMap<>();

   public void clear() {
      this.parameters.clear();
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      BasicHttpParams var1 = (BasicHttpParams)super.clone();
      this.copyParams(var1);
      return var1;
   }

   @Override
   public HttpParams copy() {
      try {
         return (HttpParams)this.clone();
      } catch (CloneNotSupportedException var2) {
         throw new UnsupportedOperationException("Cloning not supported");
      }
   }

   public void copyParams(HttpParams var1) {
      for (Entry var2 : this.parameters.entrySet()) {
         var1.setParameter((String)var2.getKey(), var2.getValue());
      }
   }

   @Override
   public Set<String> getNames() {
      return new HashSet<>(this.parameters.keySet());
   }

   @Override
   public Object getParameter(String var1) {
      return this.parameters.get(var1);
   }

   public boolean isParameterSet(String var1) {
      boolean var2;
      if (this.getParameter(var1) != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public boolean isParameterSetLocally(String var1) {
      boolean var2;
      if (this.parameters.get(var1) != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public boolean removeParameter(String var1) {
      boolean var2;
      if (this.parameters.containsKey(var1)) {
         this.parameters.remove(var1);
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public HttpParams setParameter(String var1, Object var2) {
      if (var1 != null) {
         if (var2 != null) {
            this.parameters.put(var1, var2);
         } else {
            this.parameters.remove(var1);
         }
      }

      return this;
   }

   public void setParameters(String[] var1, Object var2) {
      int var4 = var1.length;

      for (int var3 = 0; var3 < var4; var3++) {
         this.setParameter(var1[var3], var2);
      }
   }
}

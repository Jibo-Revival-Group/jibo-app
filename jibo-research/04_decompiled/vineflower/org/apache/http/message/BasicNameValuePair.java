package org.apache.http.message;

import java.io.Serializable;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

@Immutable
public class BasicNameValuePair implements Serializable, Cloneable, NameValuePair {
   private static final long serialVersionUID = -6437800749411518984L;
   private final String name;
   private final String value;

   public BasicNameValuePair(String var1, String var2) {
      this.name = Args.notNull(var1, "Name");
      this.value = var2;
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 instanceof NameValuePair) {
            var1 = var1;
            if (!this.name.equals(var1.name) || !LangUtils.equals(this.value, var1.value)) {
               var2 = false;
            }
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   @Override
   public String getName() {
      return this.name;
   }

   @Override
   public String getValue() {
      return this.value;
   }

   @Override
   public int hashCode() {
      return LangUtils.hashCode(LangUtils.hashCode(17, this.name), this.value);
   }

   @Override
   public String toString() {
      String var1;
      if (this.value == null) {
         var1 = this.name;
      } else {
         StringBuilder var2 = new StringBuilder(this.name.length() + 1 + this.value.length());
         var2.append(this.name);
         var2.append("=");
         var2.append(this.value);
         var1 = var2.toString();
      }

      return var1;
   }
}

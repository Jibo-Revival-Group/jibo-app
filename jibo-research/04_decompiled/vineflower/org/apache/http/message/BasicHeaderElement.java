package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

@NotThreadSafe
public class BasicHeaderElement implements Cloneable, HeaderElement {
   private final String name;
   private final NameValuePair[] parameters;
   private final String value;

   public BasicHeaderElement(String var1, String var2) {
      this(var1, var2, null);
   }

   public BasicHeaderElement(String var1, String var2, NameValuePair[] var3) {
      this.name = Args.notNull(var1, "Name");
      this.value = var2;
      if (var3 != null) {
         this.parameters = var3;
      } else {
         this.parameters = new NameValuePair[0];
      }
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 instanceof HeaderElement) {
            var1 = var1;
            if (!this.name.equals(var1.name) || !LangUtils.equals(this.value, var1.value) || !LangUtils.equals(this.parameters, var1.parameters)) {
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
   public NameValuePair getParameter(int var1) {
      return this.parameters[var1];
   }

   @Override
   public NameValuePair getParameterByName(String var1) {
      Args.notNull(var1, "Name");
      NameValuePair[] var5 = this.parameters;
      int var3 = var5.length;
      int var2 = 0;

      while (true) {
         if (var2 >= var3) {
            var6 = null;
            break;
         }

         NameValuePair var4 = var5[var2];
         if (var4.getName().equalsIgnoreCase(var1)) {
            var6 = var4;
            break;
         }

         var2++;
      }

      return var6;
   }

   @Override
   public int getParameterCount() {
      return this.parameters.length;
   }

   @Override
   public NameValuePair[] getParameters() {
      return (NameValuePair[])this.parameters.clone();
   }

   @Override
   public String getValue() {
      return this.value;
   }

   @Override
   public int hashCode() {
      int var1 = LangUtils.hashCode(LangUtils.hashCode(17, this.name), this.value);
      NameValuePair[] var4 = this.parameters;
      int var3 = var4.length;

      for (int var2 = 0; var2 < var3; var2++) {
         var1 = LangUtils.hashCode(var1, var4[var2]);
      }

      return var1;
   }

   @Override
   public String toString() {
      StringBuilder var3 = new StringBuilder();
      var3.append(this.name);
      if (this.value != null) {
         var3.append("=");
         var3.append(this.value);
      }

      for (NameValuePair var4 : this.parameters) {
         var3.append("; ");
         var3.append(var4);
      }

      return var3.toString();
   }
}

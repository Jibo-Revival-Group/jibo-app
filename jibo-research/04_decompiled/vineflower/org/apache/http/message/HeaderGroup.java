package org.apache.http.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class HeaderGroup implements Serializable, Cloneable {
   private static final long serialVersionUID = 2608834160639271617L;
   private final List<Header> headers = new ArrayList<>(16);

   public void addHeader(Header var1) {
      if (var1 != null) {
         this.headers.add(var1);
      }
   }

   public void clear() {
      this.headers.clear();
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

   public boolean containsHeader(String var1) {
      boolean var4 = false;
      int var2 = 0;

      boolean var3;
      while (true) {
         var3 = var4;
         if (var2 >= this.headers.size()) {
            break;
         }

         if (this.headers.get(var2).getName().equalsIgnoreCase(var1)) {
            var3 = true;
            break;
         }

         var2++;
      }

      return var3;
   }

   public HeaderGroup copy() {
      HeaderGroup var1 = new HeaderGroup();
      var1.headers.addAll(this.headers);
      return var1;
   }

   public Header[] getAllHeaders() {
      return this.headers.toArray(new Header[this.headers.size()]);
   }

   public Header getCondensedHeader(String var1) {
      int var2 = 1;
      Header[] var3 = this.getHeaders(var1);
      Header var5;
      if (var3.length == 0) {
         var5 = null;
      } else if (var3.length == 1) {
         var5 = var3[0];
      } else {
         CharArrayBuffer var4 = new CharArrayBuffer(128);
         var4.append(var3[0].getValue());

         while (var2 < var3.length) {
            var4.append(", ");
            var4.append(var3[var2].getValue());
            var2++;
         }

         var5 = new BasicHeader(var1.toLowerCase(Locale.ROOT), var4.toString());
      }

      return var5;
   }

   public Header getFirstHeader(String var1) {
      int var2 = 0;

      while (true) {
         if (var2 >= this.headers.size()) {
            var4 = null;
            break;
         }

         Header var3 = this.headers.get(var2);
         if (var3.getName().equalsIgnoreCase(var1)) {
            var4 = var3;
            break;
         }

         var2++;
      }

      return var4;
   }

   public Header[] getHeaders(String var1) {
      ArrayList var3 = new ArrayList();

      for (int var2 = 0; var2 < this.headers.size(); var2++) {
         Header var4 = this.headers.get(var2);
         if (var4.getName().equalsIgnoreCase(var1)) {
            var3.add(var4);
         }
      }

      return var3.toArray(new Header[var3.size()]);
   }

   public Header getLastHeader(String var1) {
      int var2 = this.headers.size() - 1;

      while (true) {
         if (var2 < 0) {
            var4 = null;
            break;
         }

         Header var3 = this.headers.get(var2);
         if (var3.getName().equalsIgnoreCase(var1)) {
            var4 = var3;
            break;
         }

         var2--;
      }

      return var4;
   }

   public HeaderIterator iterator() {
      return new BasicListHeaderIterator(this.headers, null);
   }

   public HeaderIterator iterator(String var1) {
      return new BasicListHeaderIterator(this.headers, var1);
   }

   public void removeHeader(Header var1) {
      if (var1 != null) {
         this.headers.remove(var1);
      }
   }

   public void setHeaders(Header[] var1) {
      this.clear();
      if (var1 != null) {
         Collections.addAll(this.headers, var1);
      }
   }

   @Override
   public String toString() {
      return this.headers.toString();
   }

   public void updateHeader(Header var1) {
      if (var1 != null) {
         int var2 = 0;

         while (true) {
            if (var2 >= this.headers.size()) {
               this.headers.add(var1);
               break;
            }

            if (this.headers.get(var2).getName().equalsIgnoreCase(var1.getName())) {
               this.headers.set(var2, var1);
               break;
            }

            var2++;
         }
      }
   }
}

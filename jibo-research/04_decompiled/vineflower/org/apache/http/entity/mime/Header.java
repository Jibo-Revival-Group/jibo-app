package org.apache.http.entity.mime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Header implements Iterable<MinimalField> {
   private final Map<String, List<MinimalField>> fieldMap;
   private final List<MinimalField> fields = new LinkedList<>();

   public Header() {
      this.fieldMap = new HashMap<>();
   }

   public void addField(MinimalField var1) {
      if (var1 != null) {
         String var4 = var1.getName().toLowerCase(Locale.US);
         List var3 = this.fieldMap.get(var4);
         List var2 = var3;
         if (var3 == null) {
            var2 = new LinkedList();
            this.fieldMap.put(var4, var2);
         }

         var2.add(var1);
         this.fields.add(var1);
      }
   }

   public MinimalField getField(String var1) {
      MinimalField var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var1 = var1.toLowerCase(Locale.US);
         List var4 = this.fieldMap.get(var1);
         if (var4 != null && !var4.isEmpty()) {
            var2 = (MinimalField)var4.get(0);
         } else {
            var2 = null;
         }
      }

      return var2;
   }

   public List<MinimalField> getFields() {
      return new ArrayList<>(this.fields);
   }

   public List<MinimalField> getFields(String var1) {
      List var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var1 = var1.toLowerCase(Locale.US);
         List var4 = this.fieldMap.get(var1);
         if (var4 != null && !var4.isEmpty()) {
            var2 = new ArrayList(var4);
         } else {
            var2 = Collections.emptyList();
         }
      }

      return var2;
   }

   @Override
   public Iterator<MinimalField> iterator() {
      return Collections.unmodifiableList(this.fields).iterator();
   }

   public int removeFields(String var1) {
      int var2;
      if (var1 == null) {
         var2 = 0;
      } else {
         var1 = var1.toLowerCase(Locale.US);
         List var4 = this.fieldMap.remove(var1);
         if (var4 != null && !var4.isEmpty()) {
            this.fields.removeAll(var4);
            var2 = var4.size();
         } else {
            var2 = 0;
         }
      }

      return var2;
   }

   public void setField(MinimalField var1) {
      if (var1 != null) {
         String var5 = var1.getName().toLowerCase(Locale.US);
         List var6 = this.fieldMap.get(var5);
         if (var6 != null && !var6.isEmpty()) {
            var6.clear();
            var6.add(var1);
            Iterator var7 = this.fields.iterator();
            int var2 = 0;
            int var3 = -1;

            while (var7.hasNext()) {
               int var4 = var3;
               if (((MinimalField)var7.next()).getName().equalsIgnoreCase(var1.getName())) {
                  var7.remove();
                  var4 = var3;
                  if (var3 == -1) {
                     var4 = var2;
                  }
               }

               var2++;
               var3 = var4;
            }

            this.fields.add(var3, var1);
         } else {
            this.addField(var1);
         }
      }
   }

   @Override
   public String toString() {
      return this.fields.toString();
   }
}

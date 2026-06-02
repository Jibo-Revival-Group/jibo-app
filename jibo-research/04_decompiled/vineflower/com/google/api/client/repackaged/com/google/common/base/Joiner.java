package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

@GwtCompatible
public class Joiner {
   private final String separator;

   private Joiner(Joiner var1) {
      this.separator = var1.separator;
   }

   private Joiner(String var1) {
      this.separator = Preconditions.checkNotNull(var1);
   }

   private static Iterable<Object> iterable(Object var0, Object var1, Object[] var2) {
      Preconditions.checkNotNull(var2);
      return new AbstractList<Object>(var2, var0, var1) {
         final Object val$first;
         final Object[] val$rest;
         final Object val$second;

         {
            this.val$rest = var1;
            this.val$first = var2x;
            this.val$second = var3;
         }

         @Override
         public Object get(int var1) {
            Object var2x;
            switch (var1) {
               case 0:
                  var2x = this.val$first;
                  break;
               case 1:
                  var2x = this.val$second;
                  break;
               default:
                  var2x = this.val$rest[var1 - 2];
            }

            return var2x;
         }

         @Override
         public int size() {
            return this.val$rest.length + 2;
         }
      };
   }

   public static Joiner on(char var0) {
      return new Joiner(String.valueOf(var0));
   }

   public static Joiner on(String var0) {
      return new Joiner(var0);
   }

   public <A extends Appendable> A appendTo(A var1, Iterable<?> var2) throws IOException {
      return this.appendTo((A)var1, var2.iterator());
   }

   public final <A extends Appendable> A appendTo(A var1, Object var2, Object var3, Object... var4) throws IOException {
      return this.appendTo((A)var1, iterable(var2, var3, var4));
   }

   public <A extends Appendable> A appendTo(A var1, Iterator<?> var2) throws IOException {
      Preconditions.checkNotNull(var1);
      if (var2.hasNext()) {
         var1.append(this.toString(var2.next()));

         while (var2.hasNext()) {
            var1.append(this.separator);
            var1.append(this.toString(var2.next()));
         }
      }

      return (A)var1;
   }

   public final <A extends Appendable> A appendTo(A var1, Object[] var2) throws IOException {
      return this.appendTo((A)var1, Arrays.asList(var2));
   }

   public final StringBuilder appendTo(StringBuilder var1, Iterable<?> var2) {
      return this.appendTo(var1, var2.iterator());
   }

   public final StringBuilder appendTo(StringBuilder var1, Object var2, Object var3, Object... var4) {
      return this.appendTo(var1, iterable(var2, var3, var4));
   }

   public final StringBuilder appendTo(StringBuilder var1, Iterator<?> var2) {
      try {
         this.appendTo((StringBuilder)var1, var2);
         return var1;
      } catch (IOException var3) {
         throw new AssertionError(var3);
      }
   }

   public final StringBuilder appendTo(StringBuilder var1, Object[] var2) {
      return this.appendTo(var1, Arrays.asList(var2));
   }

   public final String join(Iterable<?> var1) {
      return this.join(var1.iterator());
   }

   public final String join(Object var1, Object var2, Object... var3) {
      return this.join(iterable(var1, var2, var3));
   }

   public final String join(Iterator<?> var1) {
      return this.appendTo(new StringBuilder(), var1).toString();
   }

   public final String join(Object[] var1) {
      return this.join(Arrays.asList(var1));
   }

   public Joiner skipNulls() {
      return new Joiner(this, this) {
         final Joiner this$0;

         {
            this.this$0 = var1;
         }

         @Override
         public <A extends Appendable> A appendTo(A var1, Iterator<?> var2) throws IOException {
            Preconditions.checkNotNull(var1, "appendable");
            Preconditions.checkNotNull(var2, "parts");

            while (var2.hasNext()) {
               Object var3 = var2.next();
               if (var3 != null) {
                  var1.append(this.this$0.toString(var3));
                  break;
               }
            }

            while (var2.hasNext()) {
               Object var4 = var2.next();
               if (var4 != null) {
                  var1.append(this.this$0.separator);
                  var1.append(this.this$0.toString(var4));
               }
            }

            return (A)var1;
         }

         @Override
         public Joiner useForNull(String var1) {
            throw new UnsupportedOperationException("already specified skipNulls");
         }

         @Override
         public Joiner.MapJoiner withKeyValueSeparator(String var1) {
            throw new UnsupportedOperationException("can't use .skipNulls() with maps");
         }
      };
   }

   CharSequence toString(Object var1) {
      Preconditions.checkNotNull(var1);
      if (var1 instanceof CharSequence) {
         var1 = var1;
      } else {
         var1 = var1.toString();
      }

      return var1;
   }

   public Joiner useForNull(String var1) {
      Preconditions.checkNotNull(var1);
      return new Joiner(this, this, var1) {
         final Joiner this$0;
         final String val$nullText;

         {
            this.this$0 = var1;
            this.val$nullText = var3;
         }

         @Override
         public Joiner skipNulls() {
            throw new UnsupportedOperationException("already specified useForNull");
         }

         @Override
         CharSequence toString(Object var1) {
            if (var1 == null) {
               var1 = this.val$nullText;
            } else {
               var1 = this.this$0.toString(var1);
            }

            return var1;
         }

         @Override
         public Joiner useForNull(String var1) {
            throw new UnsupportedOperationException("already specified useForNull");
         }
      };
   }

   public Joiner.MapJoiner withKeyValueSeparator(String var1) {
      return new Joiner.MapJoiner(this, var1);
   }

   public static final class MapJoiner {
      private final Joiner joiner;
      private final String keyValueSeparator;

      private MapJoiner(Joiner var1, String var2) {
         this.joiner = var1;
         this.keyValueSeparator = Preconditions.checkNotNull(var2);
      }

      @Beta
      public <A extends Appendable> A appendTo(A var1, Iterable<? extends Entry<?, ?>> var2) throws IOException {
         return this.appendTo((A)var1, var2.iterator());
      }

      @Beta
      public <A extends Appendable> A appendTo(A var1, Iterator<? extends Entry<?, ?>> var2) throws IOException {
         Preconditions.checkNotNull(var1);
         if (var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            var1.append(this.joiner.toString(var3.getKey()));
            var1.append(this.keyValueSeparator);
            var1.append(this.joiner.toString(var3.getValue()));

            while (var2.hasNext()) {
               var1.append(this.joiner.separator);
               var3 = (Entry)var2.next();
               var1.append(this.joiner.toString(var3.getKey()));
               var1.append(this.keyValueSeparator);
               var1.append(this.joiner.toString(var3.getValue()));
            }
         }

         return (A)var1;
      }

      public <A extends Appendable> A appendTo(A var1, Map<?, ?> var2) throws IOException {
         return this.appendTo((A)var1, var2.entrySet());
      }

      @Beta
      public StringBuilder appendTo(StringBuilder var1, Iterable<? extends Entry<?, ?>> var2) {
         return this.appendTo(var1, var2.iterator());
      }

      @Beta
      public StringBuilder appendTo(StringBuilder var1, Iterator<? extends Entry<?, ?>> var2) {
         try {
            this.appendTo((StringBuilder)var1, var2);
            return var1;
         } catch (IOException var3) {
            throw new AssertionError(var3);
         }
      }

      public StringBuilder appendTo(StringBuilder var1, Map<?, ?> var2) {
         return this.appendTo(var1, var2.entrySet());
      }

      @Beta
      public String join(Iterable<? extends Entry<?, ?>> var1) {
         return this.join(var1.iterator());
      }

      @Beta
      public String join(Iterator<? extends Entry<?, ?>> var1) {
         return this.appendTo(new StringBuilder(), var1).toString();
      }

      public String join(Map<?, ?> var1) {
         return this.join(var1.entrySet());
      }

      public Joiner.MapJoiner useForNull(String var1) {
         return new Joiner.MapJoiner(this.joiner.useForNull(var1), this.keyValueSeparator);
      }
   }
}

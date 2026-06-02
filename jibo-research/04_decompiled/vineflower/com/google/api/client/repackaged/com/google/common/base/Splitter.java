package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@GwtCompatible(emulated = true)
public final class Splitter {
   private final int limit;
   private final boolean omitEmptyStrings;
   private final Splitter.Strategy strategy;
   private final CharMatcher trimmer;

   private Splitter(Splitter.Strategy var1) {
      this(var1, false, CharMatcher.NONE, Integer.MAX_VALUE);
   }

   private Splitter(Splitter.Strategy var1, boolean var2, CharMatcher var3, int var4) {
      this.strategy = var1;
      this.omitEmptyStrings = var2;
      this.trimmer = var3;
      this.limit = var4;
   }

   public static Splitter fixedLength(int var0) {
      boolean var1;
      if (var0 > 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      Preconditions.checkArgument(var1, "The length may not be less than 1");
      return new Splitter(new Splitter.Strategy(var0) {
         final int val$length;

         {
            this.val$length = var1;
         }

         public Splitter.SplittingIterator iterator(Splitter var1, CharSequence var2) {
            return new Splitter.SplittingIterator(this, var1, var2) {
               final <unrepresentable> this$0;

               {
                  this.this$0 = var1;
               }

               @Override
               public int separatorEnd(int var1) {
                  return var1;
               }

               @Override
               public int separatorStart(int var1) {
                  var1 = this.this$0.val$length + var1;
                  if (var1 >= this.toSplit.length()) {
                     var1 = -1;
                  }

                  return var1;
               }
            };
         }
      });
   }

   public static Splitter on(char var0) {
      return on(CharMatcher.is(var0));
   }

   public static Splitter on(CharMatcher var0) {
      Preconditions.checkNotNull(var0);
      return new Splitter(new Splitter.Strategy(var0) {
         final CharMatcher val$separatorMatcher;

         {
            this.val$separatorMatcher = var1;
         }

         public Splitter.SplittingIterator iterator(Splitter var1, CharSequence var2) {
            return new Splitter.SplittingIterator(this, var1, var2) {
               final <unrepresentable> this$0;

               {
                  this.this$0 = var1;
               }

               @Override
               int separatorEnd(int var1) {
                  return var1 + 1;
               }

               @Override
               int separatorStart(int var1) {
                  return this.this$0.val$separatorMatcher.indexIn(this.toSplit, var1);
               }
            };
         }
      });
   }

   public static Splitter on(String var0) {
      boolean var1;
      if (var0.length() != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      Preconditions.checkArgument(var1, "The separator may not be the empty string.");
      return new Splitter(new Splitter.Strategy(var0) {
         final String val$separator;

         {
            this.val$separator = var1;
         }

         public Splitter.SplittingIterator iterator(Splitter var1, CharSequence var2) {
            return new Splitter.SplittingIterator(this, var1, var2) {
               final <unrepresentable> this$0;

               {
                  this.this$0 = var1;
               }

               @Override
               public int separatorEnd(int var1) {
                  return this.this$0.val$separator.length() + var1;
               }

               @Override
               public int separatorStart(int var1) {
                  int var4 = this.this$0.val$separator.length();
                  int var5 = this.toSplit.length();

                  while (var1 <= var5 - var4) {
                     int var3 = 0;

                     while (true) {
                        int var2x = var1;
                        if (var3 >= var4) {
                           return var2x;
                        }

                        if (this.toSplit.charAt(var3 + var1) != this.this$0.val$separator.charAt(var3)) {
                           var1++;
                           break;
                        }

                        var3++;
                     }
                  }

                  return -1;
               }
            };
         }
      });
   }

   @GwtIncompatible("java.util.regex")
   public static Splitter on(Pattern var0) {
      Preconditions.checkNotNull(var0);
      boolean var1;
      if (!var0.matcher("").matches()) {
         var1 = true;
      } else {
         var1 = false;
      }

      Preconditions.checkArgument(var1, "The pattern may not match the empty string: %s", var0);
      return new Splitter(new Splitter.Strategy(var0) {
         final Pattern val$separatorPattern;

         {
            this.val$separatorPattern = var1;
         }

         public Splitter.SplittingIterator iterator(Splitter var1, CharSequence var2) {
            return new Splitter.SplittingIterator(this, var1, var2, this.val$separatorPattern.matcher(var2)) {
               final <unrepresentable> this$0;
               final Matcher val$matcher;

               {
                  this.this$0 = var1;
                  this.val$matcher = var4;
               }

               @Override
               public int separatorEnd(int var1) {
                  return this.val$matcher.end();
               }

               @Override
               public int separatorStart(int var1) {
                  if (this.val$matcher.find(var1)) {
                     var1 = this.val$matcher.start();
                  } else {
                     var1 = -1;
                  }

                  return var1;
               }
            };
         }
      });
   }

   @GwtIncompatible("java.util.regex")
   public static Splitter onPattern(String var0) {
      return on(Pattern.compile(var0));
   }

   private Iterator<String> splittingIterator(CharSequence var1) {
      return this.strategy.iterator(this, var1);
   }

   public Splitter limit(int var1) {
      boolean var2;
      if (var1 > 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2, "must be greater than zero: %s", var1);
      return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, var1);
   }

   public Splitter omitEmptyStrings() {
      return new Splitter(this.strategy, true, this.trimmer, this.limit);
   }

   public Iterable<String> split(CharSequence var1) {
      Preconditions.checkNotNull(var1);
      return new Iterable<String>(this, var1) {
         final Splitter this$0;
         final CharSequence val$sequence;

         {
            this.this$0 = var1;
            this.val$sequence = var2;
         }

         @Override
         public Iterator<String> iterator() {
            return this.this$0.splittingIterator(this.val$sequence);
         }

         @Override
         public String toString() {
            return Joiner.on(", ").appendTo(new StringBuilder().append('['), this).append(']').toString();
         }
      };
   }

   @Beta
   public List<String> splitToList(CharSequence var1) {
      Preconditions.checkNotNull(var1);
      Iterator var3 = this.splittingIterator(var1);
      ArrayList var2 = new ArrayList();

      while (var3.hasNext()) {
         var2.add(var3.next());
      }

      return Collections.unmodifiableList(var2);
   }

   public Splitter trimResults() {
      return this.trimResults(CharMatcher.WHITESPACE);
   }

   public Splitter trimResults(CharMatcher var1) {
      Preconditions.checkNotNull(var1);
      return new Splitter(this.strategy, this.omitEmptyStrings, var1, this.limit);
   }

   @Beta
   public Splitter.MapSplitter withKeyValueSeparator(char var1) {
      return this.withKeyValueSeparator(on(var1));
   }

   @Beta
   public Splitter.MapSplitter withKeyValueSeparator(Splitter var1) {
      return new Splitter.MapSplitter(this, var1);
   }

   @Beta
   public Splitter.MapSplitter withKeyValueSeparator(String var1) {
      return this.withKeyValueSeparator(on(var1));
   }

   @Beta
   public static final class MapSplitter {
      private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
      private final Splitter entrySplitter;
      private final Splitter outerSplitter;

      private MapSplitter(Splitter var1, Splitter var2) {
         this.outerSplitter = var1;
         this.entrySplitter = Preconditions.checkNotNull(var2);
      }

      public Map<String, String> split(CharSequence var1) {
         LinkedHashMap var3 = new LinkedHashMap();

         for (String var5 : this.outerSplitter.split(var1)) {
            Iterator var6 = this.entrySplitter.splittingIterator(var5);
            Preconditions.checkArgument(var6.hasNext(), "Chunk [%s] is not a valid entry", var5);
            String var4 = (String)var6.next();
            boolean var2;
            if (!var3.containsKey(var4)) {
               var2 = true;
            } else {
               var2 = false;
            }

            Preconditions.checkArgument(var2, "Duplicate key [%s] found.", var4);
            Preconditions.checkArgument(var6.hasNext(), "Chunk [%s] is not a valid entry", var5);
            var3.put(var4, (String)var6.next());
            if (!var6.hasNext()) {
               var2 = true;
            } else {
               var2 = false;
            }

            Preconditions.checkArgument(var2, "Chunk [%s] is not a valid entry", var5);
         }

         return Collections.unmodifiableMap(var3);
      }
   }

   private abstract static class SplittingIterator extends AbstractIterator<String> {
      int limit;
      int offset = 0;
      final boolean omitEmptyStrings;
      final CharSequence toSplit;
      final CharMatcher trimmer;

      protected SplittingIterator(Splitter var1, CharSequence var2) {
         this.trimmer = var1.trimmer;
         this.omitEmptyStrings = var1.omitEmptyStrings;
         this.limit = var1.limit;
         this.toSplit = var2;
      }

      protected String computeNext() {
         int var2 = this.offset;

         String var4;
         while (true) {
            if (this.offset == -1) {
               var4 = this.endOfData();
               break;
            }

            int var1 = this.separatorStart(this.offset);
            if (var1 == -1) {
               var1 = this.toSplit.length();
               this.offset = -1;
            } else {
               this.offset = this.separatorEnd(var1);
            }

            if (this.offset == var2) {
               this.offset++;
               if (this.offset >= this.toSplit.length()) {
                  this.offset = -1;
               }
            } else {
               while (var2 < var1 && this.trimmer.matches(this.toSplit.charAt(var2))) {
                  var2++;
               }

               while (var1 > var2 && this.trimmer.matches(this.toSplit.charAt(var1 - 1))) {
                  var1--;
               }

               if (!this.omitEmptyStrings || var2 != var1) {
                  int var3;
                  if (this.limit == 1) {
                     var1 = this.toSplit.length();
                     this.offset = -1;

                     while (true) {
                        var3 = var1;
                        if (var1 <= var2) {
                           break;
                        }

                        var3 = var1;
                        if (!this.trimmer.matches(this.toSplit.charAt(var1 - 1))) {
                           break;
                        }

                        var1--;
                     }
                  } else {
                     this.limit--;
                     var3 = var1;
                  }

                  var4 = this.toSplit.subSequence(var2, var3).toString();
                  break;
               }

               var2 = this.offset;
            }
         }

         return var4;
      }

      abstract int separatorEnd(int var1);

      abstract int separatorStart(int var1);
   }

   private interface Strategy {
      Iterator<String> iterator(Splitter var1, CharSequence var2);
   }
}

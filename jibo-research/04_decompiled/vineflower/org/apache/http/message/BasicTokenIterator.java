package org.apache.http.message;

import java.util.NoSuchElementException;
import org.apache.http.HeaderIterator;
import org.apache.http.ParseException;
import org.apache.http.TokenIterator;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
public class BasicTokenIterator implements TokenIterator {
   public static final String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
   protected String currentHeader;
   protected String currentToken;
   protected final HeaderIterator headerIt;
   protected int searchPos;

   public BasicTokenIterator(HeaderIterator var1) {
      this.headerIt = Args.notNull(var1, "Header iterator");
      this.searchPos = this.findNext(-1);
   }

   protected String createToken(String var1, int var2, int var3) {
      return var1.substring(var2, var3);
   }

   protected int findNext(int var1) throws ParseException {
      if (var1 < 0) {
         if (!this.headerIt.hasNext()) {
            return -1;
         }

         this.currentHeader = this.headerIt.nextHeader().getValue();
         var1 = 0;
      } else {
         var1 = this.findTokenSeparator(var1);
      }

      int var2 = this.findTokenStart(var1);
      if (var2 < 0) {
         this.currentToken = null;
         var1 = -1;
      } else {
         var1 = this.findTokenEnd(var2);
         this.currentToken = this.createToken(this.currentHeader, var2, var1);
      }

      return var1;
   }

   protected int findTokenEnd(int var1) {
      Args.notNegative(var1, "Search position");
      int var2 = this.currentHeader.length();
      var1++;

      while (var1 < var2 && this.isTokenChar(this.currentHeader.charAt(var1))) {
         var1++;
      }

      return var1;
   }

   protected int findTokenSeparator(int var1) {
      var1 = Args.notNegative(var1, "Search position");
      boolean var3 = false;
      int var4 = this.currentHeader.length();

      while (!var3 && var1 < var4) {
         char var2 = this.currentHeader.charAt(var1);
         if (this.isTokenSeparator(var2)) {
            var3 = true;
         } else {
            if (!this.isWhitespace(var2)) {
               if (this.isTokenChar(var2)) {
                  throw new ParseException("Tokens without separator (pos " + var1 + "): " + this.currentHeader);
               }

               throw new ParseException("Invalid character after token (pos " + var1 + "): " + this.currentHeader);
            }

            var1++;
         }
      }

      return var1;
   }

   protected int findTokenStart(int var1) {
      var1 = Args.notNegative(var1, "Search position");
      int var3 = 0;

      while (!var3 && this.currentHeader != null) {
         int var5 = this.currentHeader.length();
         int var4 = var3;
         var3 = var1;
         boolean var7 = (boolean)var4;

         while (!var7 && var3 < var5) {
            char var2 = this.currentHeader.charAt(var3);
            if (!this.isTokenSeparator(var2) && !this.isWhitespace(var2)) {
               if (!this.isTokenChar(this.currentHeader.charAt(var3))) {
                  throw new ParseException("Invalid character before token (pos " + var3 + "): " + this.currentHeader);
               }

               var7 = true;
            } else {
               var3++;
            }
         }

         var4 = var3;
         if (!var7) {
            if (this.headerIt.hasNext()) {
               this.currentHeader = this.headerIt.nextHeader().getValue();
               var4 = 0;
            } else {
               this.currentHeader = null;
               var4 = var3;
            }
         }

         var3 = var7;
         var1 = var4;
      }

      if (!var3) {
         var1 = -1;
      }

      return var1;
   }

   @Override
   public boolean hasNext() {
      boolean var1;
      if (this.currentToken != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   protected boolean isHttpSeparator(char var1) {
      boolean var2;
      if (" ,;=()<>@:\\\"/[]?{}\t".indexOf(var1) >= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   protected boolean isTokenChar(char var1) {
      boolean var2 = true;
      if (!Character.isLetterOrDigit(var1)) {
         if (Character.isISOControl(var1)) {
            var2 = false;
         } else if (this.isHttpSeparator(var1)) {
            var2 = false;
         }
      }

      return var2;
   }

   protected boolean isTokenSeparator(char var1) {
      boolean var2;
      if (var1 == ',') {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   protected boolean isWhitespace(char var1) {
      boolean var2;
      if (var1 != '\t' && !Character.isSpaceChar(var1)) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Override
   public final Object next() throws NoSuchElementException, ParseException {
      return this.nextToken();
   }

   @Override
   public String nextToken() throws NoSuchElementException, ParseException {
      if (this.currentToken == null) {
         throw new NoSuchElementException("Iteration already finished.");
      }

      String var1 = this.currentToken;
      this.searchPos = this.findNext(this.searchPos);
      return var1;
   }

   @Override
   public final void remove() throws UnsupportedOperationException {
      throw new UnsupportedOperationException("Removing tokens is not supported.");
   }
}

package com.google.api.client.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Beta
public final class PemReader {
   private static final Pattern BEGIN_PATTERN = Pattern.compile("-----BEGIN ([A-Z ]+)-----");
   private static final Pattern END_PATTERN = Pattern.compile("-----END ([A-Z ]+)-----");
   private BufferedReader reader;

   public PemReader(Reader var1) {
      this.reader = new BufferedReader(var1);
   }

   public static PemReader.Section readFirstSectionAndClose(Reader var0) throws IOException {
      return readFirstSectionAndClose(var0, null);
   }

   public static PemReader.Section readFirstSectionAndClose(Reader var0, String var1) throws IOException {
      PemReader var4 = new PemReader(var0);

      try {
         return var4.readNextSection(var1);
      } finally {
         var4.close();
      }
   }

   public void close() throws IOException {
      this.reader.close();
   }

   public PemReader.Section readNextSection() throws IOException {
      return this.readNextSection(null);
   }

   public PemReader.Section readNextSection(String var1) throws IOException {
      Object var5 = null;
      StringBuilder var3 = null;
      String var4 = null;

      while (true) {
         String var6 = this.reader.readLine();
         if (var6 == null) {
            boolean var2;
            if (var4 == null) {
               var2 = true;
            } else {
               var2 = false;
            }

            Preconditions.checkArgument(var2, "missing end tag (%s)", var4);
            var9 = (PemReader.Section)var5;
            break;
         }

         if (var3 == null) {
            Matcher var10 = BEGIN_PATTERN.matcher(var6);
            if (var10.matches()) {
               var6 = var10.group(1);
               if (var1 == null || var6.equals(var1)) {
                  var3 = new StringBuilder();
                  var4 = var6;
               }
            }
         } else {
            Matcher var7 = END_PATTERN.matcher(var6);
            if (var7.matches()) {
               var1 = var7.group(1);
               Preconditions.checkArgument(var1.equals(var4), "end tag (%s) doesn't match begin tag (%s)", var1, var4);
               var9 = new PemReader.Section(var4, Base64.decodeBase64(var3.toString()));
               break;
            }

            var3.append(var6);
         }
      }

      return var9;
   }

   public static final class Section {
      private final byte[] base64decodedBytes;
      private final String title;

      Section(String var1, byte[] var2) {
         this.title = Preconditions.checkNotNull(var1);
         this.base64decodedBytes = Preconditions.checkNotNull(var2);
      }

      public byte[] getBase64DecodedBytes() {
         return this.base64decodedBytes;
      }

      public String getTitle() {
         return this.title;
      }
   }
}

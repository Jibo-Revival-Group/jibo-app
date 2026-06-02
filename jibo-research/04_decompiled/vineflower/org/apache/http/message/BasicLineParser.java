package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.annotation.Immutable;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Immutable
public class BasicLineParser implements LineParser {
   @Deprecated
   public static final BasicLineParser DEFAULT = new BasicLineParser();
   public static final BasicLineParser INSTANCE = new BasicLineParser();
   protected final ProtocolVersion protocol;

   public BasicLineParser() {
      this(null);
   }

   public BasicLineParser(ProtocolVersion var1) {
      if (var1 == null) {
         var1 = HttpVersion.HTTP_1_1;
      }

      this.protocol = var1;
   }

   public static Header parseHeader(String var0, LineParser var1) throws ParseException {
      Args.notNull(var0, "Value");
      CharArrayBuffer var2 = new CharArrayBuffer(var0.length());
      var2.append(var0);
      if (var1 == null) {
         var1 = INSTANCE;
      }

      return var1.parseHeader(var2);
   }

   public static ProtocolVersion parseProtocolVersion(String var0, LineParser var1) throws ParseException {
      Args.notNull(var0, "Value");
      CharArrayBuffer var2 = new CharArrayBuffer(var0.length());
      var2.append(var0);
      ParserCursor var3 = new ParserCursor(0, var0.length());
      if (var1 == null) {
         var1 = INSTANCE;
      }

      return var1.parseProtocolVersion(var2, var3);
   }

   public static RequestLine parseRequestLine(String var0, LineParser var1) throws ParseException {
      Args.notNull(var0, "Value");
      CharArrayBuffer var2 = new CharArrayBuffer(var0.length());
      var2.append(var0);
      ParserCursor var3 = new ParserCursor(0, var0.length());
      if (var1 == null) {
         var1 = INSTANCE;
      }

      return var1.parseRequestLine(var2, var3);
   }

   public static StatusLine parseStatusLine(String var0, LineParser var1) throws ParseException {
      Args.notNull(var0, "Value");
      CharArrayBuffer var2 = new CharArrayBuffer(var0.length());
      var2.append(var0);
      ParserCursor var3 = new ParserCursor(0, var0.length());
      if (var1 == null) {
         var1 = INSTANCE;
      }

      return var1.parseStatusLine(var2, var3);
   }

   protected ProtocolVersion createProtocolVersion(int var1, int var2) {
      return this.protocol.forVersion(var1, var2);
   }

   protected RequestLine createRequestLine(String var1, String var2, ProtocolVersion var3) {
      return new BasicRequestLine(var1, var2, var3);
   }

   protected StatusLine createStatusLine(ProtocolVersion var1, int var2, String var3) {
      return new BasicStatusLine(var1, var2, var3);
   }

   @Override
   public boolean hasProtocolVersion(CharArrayBuffer var1, ParserCursor var2) {
      boolean var7 = true;
      boolean var6 = false;
      Args.notNull(var1, "Char array buffer");
      Args.notNull(var2, "Parser cursor");
      int var4 = var2.getPos();
      String var8 = this.protocol.getProtocol();
      int var5 = var8.length();
      if (var1.length() >= var5 + 4) {
         int var3;
         if (var4 < 0) {
            var3 = var1.length() - 4 - var5;
         } else {
            var3 = var4;
            if (var4 == 0) {
               while (true) {
                  var3 = var4;
                  if (var4 >= var1.length()) {
                     break;
                  }

                  var3 = var4;
                  if (!HTTP.isWhitespace(var1.charAt(var4))) {
                     break;
                  }

                  var4++;
               }
            }
         }

         if (var3 + var5 + 4 <= var1.length()) {
            var4 = 0;

            for (var6 = true; var6 && var4 < var5; var4++) {
               if (var1.charAt(var3 + var4) == var8.charAt(var4)) {
                  var6 = true;
               } else {
                  var6 = false;
               }
            }

            if (var6) {
               if (var1.charAt(var3 + var5) == '/') {
                  var6 = var7;
               } else {
                  var6 = false;
               }
            }
         }
      }

      return var6;
   }

   @Override
   public Header parseHeader(CharArrayBuffer var1) throws ParseException {
      return new BufferedHeader(var1);
   }

   @Override
   public ProtocolVersion parseProtocolVersion(CharArrayBuffer var1, ParserCursor var2) throws ParseException {
      int var6 = 1;
      Args.notNull(var1, "Char array buffer");
      Args.notNull(var2, "Parser cursor");
      String var10 = this.protocol.getProtocol();
      int var8 = var10.length();
      int var7 = var2.getPos();
      int var5 = var2.getUpperBound();
      this.skipWhitespace(var1, var2);
      int var9 = var2.getPos();
      if (var9 + var8 + 4 > var5) {
         throw new ParseException("Not a valid protocol version: " + var1.substring(var7, var5));
      }

      int var4 = 0;

      boolean var3;
      for (var3 = 1; var3 && var4 < var8; var4++) {
         if (var1.charAt(var9 + var4) == var10.charAt(var4)) {
            var3 = 1;
         } else {
            var3 = 0;
         }
      }

      if (var3) {
         if (var1.charAt(var9 + var8) == '/') {
            var3 = var6;
         } else {
            var3 = 0;
         }
      }

      if (!var3) {
         throw new ParseException("Not a valid protocol version: " + var1.substring(var7, var5));
      }

      var4 = var8 + 1 + var9;
      var3 = var1.indexOf(46, var4, var5);
      if (var3 == -1) {
         throw new ParseException("Invalid protocol version number: " + var1.substring(var7, var5));
      }

      try {
         var6 = Integer.parseInt(var1.substringTrimmed(var4, var3));
      } catch (NumberFormatException var12) {
         throw new ParseException("Invalid protocol major version number: " + var1.substring(var7, var5));
      }

      var8 = var3 + 1;
      var4 = var1.indexOf(32, var8, var5);
      var3 = var4;
      if (var4 == -1) {
         var3 = var5;
      }

      try {
         var4 = Integer.parseInt(var1.substringTrimmed(var8, var3));
      } catch (NumberFormatException var11) {
         throw new ParseException("Invalid protocol minor version number: " + var1.substring(var7, var5));
      }

      var2.updatePos(var3);
      return this.createProtocolVersion(var6, var4);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public RequestLine parseRequestLine(CharArrayBuffer var1, ParserCursor var2) throws ParseException {
      Args.notNull(var1, "Char array buffer");
      Args.notNull(var2, "Parser cursor");
      int var4 = var2.getPos();
      int var3 = var2.getUpperBound();

      int var5;
      int var6;
      try {
         this.skipWhitespace(var1, var2);
         var5 = var2.getPos();
         var6 = var1.indexOf(32, var5, var3);
      } catch (IndexOutOfBoundsException var14) {
         throw new ParseException("Invalid request line: " + var1.substring(var4, var3));
      }

      if (var6 < 0) {
         try {
            StringBuilder var18 = new StringBuilder();
            ParseException var23 = new ParseException(var18.append("Invalid request line: ").append(var1.substring(var4, var3)).toString());
            throw var23;
         } catch (IndexOutOfBoundsException var10) {
            throw new ParseException("Invalid request line: " + var1.substring(var4, var3));
         }
      } else {
         String var9;
         try {
            var9 = var1.substringTrimmed(var5, var6);
            var2.updatePos(var6);
            this.skipWhitespace(var1, var2);
            var5 = var2.getPos();
            var6 = var1.indexOf(32, var5, var3);
         } catch (IndexOutOfBoundsException var13) {
            throw new ParseException("Invalid request line: " + var1.substring(var4, var3));
         }

         if (var6 < 0) {
            try {
               StringBuilder var22 = new StringBuilder();
               ParseException var17 = new ParseException(var22.append("Invalid request line: ").append(var1.substring(var4, var3)).toString());
               throw var17;
            } catch (IndexOutOfBoundsException var11) {
               throw new ParseException("Invalid request line: " + var1.substring(var4, var3));
            }
         } else {
            String var7;
            ProtocolVersion var8;
            try {
               var7 = var1.substringTrimmed(var5, var6);
               var2.updatePos(var6);
               var8 = this.parseProtocolVersion(var1, var2);
               this.skipWhitespace(var1, var2);
               if (!var2.atEnd()) {
                  StringBuilder var21 = new StringBuilder();
                  ParseException var16 = new ParseException(var21.append("Invalid request line: ").append(var1.substring(var4, var3)).toString());
                  throw var16;
               }
            } catch (IndexOutOfBoundsException var15) {
               throw new ParseException("Invalid request line: " + var1.substring(var4, var3));
            }

            try {
               return this.createRequestLine(var9, var7, var8);
            } catch (IndexOutOfBoundsException var12) {
               throw new ParseException("Invalid request line: " + var1.substring(var4, var3));
            }
         }
      }
   }

   @Override
   public StatusLine parseStatusLine(CharArrayBuffer param1, ParserCursor param2) throws ParseException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 1
      // 001: ldc "Char array buffer"
      // 003: invokestatic org/apache/http/util/Args.notNull (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      // 006: pop
      // 007: aload 2
      // 008: ldc "Parser cursor"
      // 00a: invokestatic org/apache/http/util/Args.notNull (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      // 00d: pop
      // 00e: aload 2
      // 00f: invokevirtual org/apache/http/message/ParserCursor.getPos ()I
      // 012: istore 6
      // 014: aload 2
      // 015: invokevirtual org/apache/http/message/ParserCursor.getUpperBound ()I
      // 018: istore 5
      // 01a: aload 0
      // 01b: aload 1
      // 01c: aload 2
      // 01d: invokevirtual org/apache/http/message/BasicLineParser.parseProtocolVersion (Lorg/apache/http/util/CharArrayBuffer;Lorg/apache/http/message/ParserCursor;)Lorg/apache/http/ProtocolVersion;
      // 020: astore 7
      // 022: aload 0
      // 023: aload 1
      // 024: aload 2
      // 025: invokevirtual org/apache/http/message/BasicLineParser.skipWhitespace (Lorg/apache/http/util/CharArrayBuffer;Lorg/apache/http/message/ParserCursor;)V
      // 028: aload 2
      // 029: invokevirtual org/apache/http/message/ParserCursor.getPos ()I
      // 02c: istore 4
      // 02e: aload 1
      // 02f: bipush 32
      // 031: iload 4
      // 033: iload 5
      // 035: invokevirtual org/apache/http/util/CharArrayBuffer.indexOf (III)I
      // 038: istore 3
      // 039: iload 3
      // 03a: ifge 100
      // 03d: iload 5
      // 03f: istore 3
      // 040: aload 1
      // 041: iload 4
      // 043: iload 3
      // 044: invokevirtual org/apache/http/util/CharArrayBuffer.substringTrimmed (II)Ljava/lang/String;
      // 047: astore 2
      // 048: bipush 0
      // 049: istore 4
      // 04b: iload 4
      // 04d: aload 2
      // 04e: invokevirtual java/lang/String.length ()I
      // 051: if_icmpge 0b2
      // 054: aload 2
      // 055: iload 4
      // 057: invokevirtual java/lang/String.charAt (I)C
      // 05a: invokestatic java/lang/Character.isDigit (C)Z
      // 05d: ifne 0ac
      // 060: new org/apache/http/ParseException
      // 063: astore 7
      // 065: new java/lang/StringBuilder
      // 068: astore 2
      // 069: aload 2
      // 06a: invokespecial java/lang/StringBuilder.<init> ()V
      // 06d: aload 7
      // 06f: aload 2
      // 070: ldc "Status line contains invalid status code: "
      // 072: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 075: aload 1
      // 076: iload 6
      // 078: iload 5
      // 07a: invokevirtual org/apache/http/util/CharArrayBuffer.substring (II)Ljava/lang/String;
      // 07d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 080: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 083: invokespecial org/apache/http/ParseException.<init> (Ljava/lang/String;)V
      // 086: aload 7
      // 088: athrow
      // 089: astore 2
      // 08a: new org/apache/http/ParseException
      // 08d: dup
      // 08e: new java/lang/StringBuilder
      // 091: dup
      // 092: invokespecial java/lang/StringBuilder.<init> ()V
      // 095: ldc "Invalid status line: "
      // 097: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 09a: aload 1
      // 09b: iload 6
      // 09d: iload 5
      // 09f: invokevirtual org/apache/http/util/CharArrayBuffer.substring (II)Ljava/lang/String;
      // 0a2: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a5: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0a8: invokespecial org/apache/http/ParseException.<init> (Ljava/lang/String;)V
      // 0ab: athrow
      // 0ac: iinc 4 1
      // 0af: goto 04b
      // 0b2: aload 2
      // 0b3: invokestatic java/lang/Integer.parseInt (Ljava/lang/String;)I
      // 0b6: istore 4
      // 0b8: iload 3
      // 0b9: iload 5
      // 0bb: if_icmpge 0fa
      // 0be: aload 1
      // 0bf: iload 3
      // 0c0: iload 5
      // 0c2: invokevirtual org/apache/http/util/CharArrayBuffer.substringTrimmed (II)Ljava/lang/String;
      // 0c5: astore 2
      // 0c6: aload 0
      // 0c7: aload 7
      // 0c9: iload 4
      // 0cb: aload 2
      // 0cc: invokevirtual org/apache/http/message/BasicLineParser.createStatusLine (Lorg/apache/http/ProtocolVersion;ILjava/lang/String;)Lorg/apache/http/StatusLine;
      // 0cf: areturn
      // 0d0: astore 2
      // 0d1: new org/apache/http/ParseException
      // 0d4: astore 2
      // 0d5: new java/lang/StringBuilder
      // 0d8: astore 7
      // 0da: aload 7
      // 0dc: invokespecial java/lang/StringBuilder.<init> ()V
      // 0df: aload 2
      // 0e0: aload 7
      // 0e2: ldc "Status line contains invalid status code: "
      // 0e4: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e7: aload 1
      // 0e8: iload 6
      // 0ea: iload 5
      // 0ec: invokevirtual org/apache/http/util/CharArrayBuffer.substring (II)Ljava/lang/String;
      // 0ef: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0f2: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0f5: invokespecial org/apache/http/ParseException.<init> (Ljava/lang/String;)V
      // 0f8: aload 2
      // 0f9: athrow
      // 0fa: ldc ""
      // 0fc: astore 2
      // 0fd: goto 0c6
      // 100: goto 040
      // try (14 -> 32): 71 java/lang/IndexOutOfBoundsException
      // try (36 -> 41): 71 java/lang/IndexOutOfBoundsException
      // try (43 -> 71): 71 java/lang/IndexOutOfBoundsException
      // try (89 -> 92): 106 java/lang/NumberFormatException
      // try (89 -> 92): 71 java/lang/IndexOutOfBoundsException
      // try (95 -> 100): 71 java/lang/IndexOutOfBoundsException
      // try (100 -> 106): 71 java/lang/IndexOutOfBoundsException
      // try (107 -> 126): 71 java/lang/IndexOutOfBoundsException
   }

   protected void skipWhitespace(CharArrayBuffer var1, ParserCursor var2) {
      int var3 = var2.getPos();
      int var4 = var2.getUpperBound();

      while (var3 < var4 && HTTP.isWhitespace(var1.charAt(var3))) {
         var3++;
      }

      var2.updatePos(var3);
   }
}

package org.apache.http.impl.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.MessageConstraintException;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.params.HttpParamConfig;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public abstract class AbstractMessageParser<T extends HttpMessage> implements HttpMessageParser<T> {
   private static final int HEADERS = 1;
   private static final int HEAD_LINE = 0;
   private final List<CharArrayBuffer> headerLines;
   protected final LineParser lineParser;
   private T message;
   private final MessageConstraints messageConstraints;
   private final SessionInputBuffer sessionBuffer;
   private int state;

   public AbstractMessageParser(SessionInputBuffer var1, LineParser var2, MessageConstraints var3) {
      this.sessionBuffer = Args.notNull(var1, "Session input buffer");
      if (var2 == null) {
         var2 = BasicLineParser.INSTANCE;
      }

      this.lineParser = var2;
      if (var3 == null) {
         var3 = MessageConstraints.DEFAULT;
      }

      this.messageConstraints = var3;
      this.headerLines = new ArrayList<>();
      this.state = 0;
   }

   @Deprecated
   public AbstractMessageParser(SessionInputBuffer var1, LineParser var2, HttpParams var3) {
      Args.notNull(var1, "Session input buffer");
      Args.notNull(var3, "HTTP parameters");
      this.sessionBuffer = var1;
      this.messageConstraints = HttpParamConfig.getMessageConstraints(var3);
      if (var2 == null) {
         var2 = BasicLineParser.INSTANCE;
      }

      this.lineParser = var2;
      this.headerLines = new ArrayList<>();
      this.state = 0;
   }

   public static Header[] parseHeaders(SessionInputBuffer var0, int var1, int var2, LineParser var3) throws HttpException, IOException {
      ArrayList var4 = new ArrayList();
      if (var3 == null) {
         var3 = BasicLineParser.INSTANCE;
      }

      return parseHeaders(var0, var1, var2, var3, var4);
   }

   public static Header[] parseHeaders(SessionInputBuffer var0, int var1, int var2, LineParser var3, List<CharArrayBuffer> var4) throws HttpException, IOException {
      byte var6 = 0;
      Args.notNull(var0, "Session input buffer");
      Args.notNull(var3, "Line parser");
      Args.notNull(var4, "Header line list");
      CharArrayBuffer var9 = null;
      CharArrayBuffer var8 = null;

      do {
         if (var8 == null) {
            var8 = new CharArrayBuffer(64);
         } else {
            var8.clear();
         }

         if (var0.readLine(var8) == -1 || var8.length() < 1) {
            Header[] var12 = new Header[var4.size()];

            for (int var13 = var6; var13 < var4.size(); var13++) {
               var8 = (CharArrayBuffer)var4.get(var13);

               try {
                  var12[var13] = var3.parseHeader(var8);
               } catch (ParseException var11) {
                  throw new ProtocolException(var11.getMessage());
               }
            }

            return var12;
         }

         if ((var8.charAt(0) == ' ' || var8.charAt(0) == '\t') && var9 != null) {
            int var5;
            for (var5 = 0; var5 < var8.length(); var5++) {
               char var7 = var8.charAt(var5);
               if (var7 != ' ' && var7 != '\t') {
                  break;
               }
            }

            if (var2 > 0 && var9.length() + 1 + var8.length() - var5 > var2) {
               throw new MessageConstraintException("Maximum line length limit exceeded");
            }

            var9.append(' ');
            var9.append(var8, var5, var8.length() - var5);
         } else {
            var4.add(var8);
            Object var10 = null;
            var9 = var8;
            var8 = (CharArrayBuffer)var10;
         }
      } while (var1 <= 0 || var4.size() < var1);

      throw new MessageConstraintException("Maximum header count exceeded");
   }

   @Override
   public T parse() throws IOException, HttpException {
      switch (this.state) {
         case 0:
            try {
               this.message = this.parseHead(this.sessionBuffer);
            } catch (ParseException var2) {
               throw new ProtocolException(var2.getMessage(), var2);
            }

            this.state = 1;
         case 1:
            Header[] var1 = parseHeaders(
               this.sessionBuffer, this.messageConstraints.getMaxHeaderCount(), this.messageConstraints.getMaxLineLength(), this.lineParser, this.headerLines
            );
            this.message.setHeaders(var1);
            HttpMessage var3 = this.message;
            this.message = null;
            this.headerLines.clear();
            this.state = 0;
            return (T)var3;
         default:
            throw new IllegalStateException("Inconsistent parser state");
      }
   }

   protected abstract T parseHead(SessionInputBuffer var1) throws IOException, HttpException, ParseException;
}

package org.apache.http.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.entity.ContentType;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public final class EntityUtils {
    private EntityUtils() {
    }

    public static void consumeQuietly(HttpEntity httpEntity) {
        try {
            consume(httpEntity);
        } catch (IOException e) {
        }
    }

    public static void consume(HttpEntity httpEntity) throws IOException {
        InputStream content;
        if (httpEntity != null && httpEntity.isStreaming() && (content = httpEntity.getContent()) != null) {
            content.close();
        }
    }

    public static void updateEntity(HttpResponse httpResponse, HttpEntity httpEntity) throws IOException {
        Args.notNull(httpResponse, "Response");
        consume(httpResponse.getEntity());
        httpResponse.setEntity(httpEntity);
    }

    public static byte[] toByteArray(HttpEntity httpEntity) throws IOException {
        Args.notNull(httpEntity, "Entity");
        InputStream content = httpEntity.getContent();
        if (content == null) {
            return null;
        }
        try {
            Args.check(httpEntity.getContentLength() <= 2147483647L, "HTTP entity too large to be buffered in memory");
            int contentLength = (int) httpEntity.getContentLength();
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(contentLength >= 0 ? contentLength : 4096);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = content.read(bArr);
                if (i != -1) {
                    byteArrayBuffer.append(bArr, 0, i);
                } else {
                    return byteArrayBuffer.toByteArray();
                }
            }
        } finally {
            content.close();
        }
    }

    @Deprecated
    public static String getContentCharSet(HttpEntity httpEntity) throws ParseException {
        NameValuePair parameterByName;
        Args.notNull(httpEntity, "Entity");
        if (httpEntity.getContentType() == null) {
            return null;
        }
        HeaderElement[] elements = httpEntity.getContentType().getElements();
        if (elements.length <= 0 || (parameterByName = elements[0].getParameterByName("charset")) == null) {
            return null;
        }
        return parameterByName.getValue();
    }

    @Deprecated
    public static String getContentMimeType(HttpEntity httpEntity) throws ParseException {
        Args.notNull(httpEntity, "Entity");
        if (httpEntity.getContentType() == null) {
            return null;
        }
        HeaderElement[] elements = httpEntity.getContentType().getElements();
        if (elements.length <= 0) {
            return null;
        }
        return elements[0].getName();
    }

    public static String toString(HttpEntity httpEntity, Charset charset) throws ParseException, IOException {
        String string = null;
        charset = null;
        Charset charset2 = null;
        Args.notNull(httpEntity, "Entity");
        InputStream content = httpEntity.getContent();
        if (content != null) {
            try {
                Args.check(httpEntity.getContentLength() <= 2147483647L, "HTTP entity too large to be buffered in memory");
                int contentLength = (int) httpEntity.getContentLength();
                if (contentLength < 0) {
                    contentLength = 4096;
                }
                try {
                    ContentType contentType = ContentType.get(httpEntity);
                    if (contentType != null) {
                        charset2 = contentType.getCharset();
                    }
                } catch (UnsupportedCharsetException e) {
                    if (charset == null) {
                        throw new UnsupportedEncodingException(e.getMessage());
                    }
                }
                if (charset2 == null) {
                    charset2 = charset;
                }
                if (charset2 == null) {
                    charset2 = HTTP.DEF_CONTENT_CHARSET;
                }
                InputStreamReader inputStreamReader = new InputStreamReader(content, charset2);
                CharArrayBuffer charArrayBuffer = new CharArrayBuffer(contentLength);
                char[] cArr = new char[1024];
                while (true) {
                    int i = inputStreamReader.read(cArr);
                    if (i == -1) {
                        break;
                    }
                    charArrayBuffer.append(cArr, 0, i);
                }
                string = charArrayBuffer.toString();
            } finally {
                content.close();
            }
        }
        return string;
    }

    public static String toString(HttpEntity httpEntity, String str) throws ParseException, IOException {
        return toString(httpEntity, str != null ? Charset.forName(str) : null);
    }

    public static String toString(HttpEntity httpEntity) throws ParseException, IOException {
        return toString(httpEntity, (Charset) null);
    }
}

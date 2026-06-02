package org.apache.http.impl.p027io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.p028io.HttpMessageParser;
import org.apache.http.p028io.SessionInputBuffer;
import org.apache.http.params.HttpParamConfig;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes.dex */
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

    protected abstract T parseHead(SessionInputBuffer sessionInputBuffer) throws HttpException, ParseException, IOException;

    @Deprecated
    public AbstractMessageParser(SessionInputBuffer sessionInputBuffer, LineParser lineParser, HttpParams httpParams) {
        Args.notNull(sessionInputBuffer, "Session input buffer");
        Args.notNull(httpParams, "HTTP parameters");
        this.sessionBuffer = sessionInputBuffer;
        this.messageConstraints = HttpParamConfig.getMessageConstraints(httpParams);
        this.lineParser = lineParser == null ? BasicLineParser.INSTANCE : lineParser;
        this.headerLines = new ArrayList();
        this.state = 0;
    }

    public AbstractMessageParser(SessionInputBuffer sessionInputBuffer, LineParser lineParser, MessageConstraints messageConstraints) {
        this.sessionBuffer = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
        this.lineParser = lineParser == null ? BasicLineParser.INSTANCE : lineParser;
        this.messageConstraints = messageConstraints == null ? MessageConstraints.DEFAULT : messageConstraints;
        this.headerLines = new ArrayList();
        this.state = 0;
    }

    public static Header[] parseHeaders(SessionInputBuffer sessionInputBuffer, int i, int i2, LineParser lineParser) throws HttpException, IOException {
        ArrayList arrayList = new ArrayList();
        if (lineParser == null) {
            lineParser = BasicLineParser.INSTANCE;
        }
        return parseHeaders(sessionInputBuffer, i, i2, lineParser, arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
    
        if (r2 >= r13.size()) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
    
        r1[r2] = r12.parseHeader(r13.get(r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0046, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ab, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b5, code lost:
    
        throw new org.apache.http.ProtocolException(r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b6, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002e, code lost:
    
        r1 = new org.apache.http.Header[r13.size()];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.apache.http.Header[] parseHeaders(org.apache.http.p028io.SessionInputBuffer r9, int r10, int r11, org.apache.http.message.LineParser r12, java.util.List<org.apache.http.util.CharArrayBuffer> r13) throws org.apache.http.HttpException, java.io.IOException {
        /*
            r8 = 9
            r4 = 0
            r7 = 32
            r2 = 0
            java.lang.String r0 = "Session input buffer"
            org.apache.http.util.Args.notNull(r9, r0)
            java.lang.String r0 = "Line parser"
            org.apache.http.util.Args.notNull(r12, r0)
            java.lang.String r0 = "Header line list"
            org.apache.http.util.Args.notNull(r13, r0)
            r3 = r4
            r0 = r4
        L17:
            if (r0 != 0) goto L49
            org.apache.http.util.CharArrayBuffer r0 = new org.apache.http.util.CharArrayBuffer
            r1 = 64
            r0.<init>(r1)
        L20:
            int r1 = r9.readLine(r0)
            r5 = -1
            if (r1 == r5) goto L2e
            int r1 = r0.length()
            r5 = 1
            if (r1 >= r5) goto L4d
        L2e:
            int r0 = r13.size()
            org.apache.http.Header[] r1 = new org.apache.http.Header[r0]
        L34:
            int r0 = r13.size()
            if (r2 >= r0) goto Lb6
            java.lang.Object r0 = r13.get(r2)
            org.apache.http.util.CharArrayBuffer r0 = (org.apache.http.util.CharArrayBuffer) r0
            org.apache.http.Header r0 = r12.parseHeader(r0)     // Catch: org.apache.http.ParseException -> Lab
            r1[r2] = r0     // Catch: org.apache.http.ParseException -> Lab
            int r2 = r2 + 1
            goto L34
        L49:
            r0.clear()
            goto L20
        L4d:
            char r1 = r0.charAt(r2)
            if (r1 == r7) goto L59
            char r1 = r0.charAt(r2)
            if (r1 != r8) goto La2
        L59:
            if (r3 == 0) goto La2
            r1 = r2
        L5c:
            int r5 = r0.length()
            if (r1 >= r5) goto L6a
            char r5 = r0.charAt(r1)
            if (r5 == r7) goto L82
            if (r5 == r8) goto L82
        L6a:
            if (r11 <= 0) goto L85
            int r5 = r3.length()
            int r5 = r5 + 1
            int r6 = r0.length()
            int r5 = r5 + r6
            int r5 = r5 - r1
            if (r5 <= r11) goto L85
            org.apache.http.MessageConstraintException r0 = new org.apache.http.MessageConstraintException
            java.lang.String r1 = "Maximum line length limit exceeded"
            r0.<init>(r1)
            throw r0
        L82:
            int r1 = r1 + 1
            goto L5c
        L85:
            r3.append(r7)
            int r5 = r0.length()
            int r5 = r5 - r1
            r3.append(r0, r1, r5)
            r1 = r0
            r0 = r3
        L92:
            if (r10 <= 0) goto La7
            int r3 = r13.size()
            if (r3 < r10) goto La7
            org.apache.http.MessageConstraintException r0 = new org.apache.http.MessageConstraintException
            java.lang.String r1 = "Maximum header count exceeded"
            r0.<init>(r1)
            throw r0
        La2:
            r13.add(r0)
            r1 = r4
            goto L92
        La7:
            r3 = r0
            r0 = r1
            goto L17
        Lab:
            r0 = move-exception
            org.apache.http.ProtocolException r1 = new org.apache.http.ProtocolException
            java.lang.String r0 = r0.getMessage()
            r1.<init>(r0)
            throw r1
        Lb6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.p027io.AbstractMessageParser.parseHeaders(org.apache.http.io.SessionInputBuffer, int, int, org.apache.http.message.LineParser, java.util.List):org.apache.http.Header[]");
    }

    @Override // org.apache.http.p028io.HttpMessageParser
    public T parse() throws HttpException, IOException {
        switch (this.state) {
            case 0:
                try {
                    this.message = (T) parseHead(this.sessionBuffer);
                    this.state = 1;
                } catch (ParseException e) {
                    throw new ProtocolException(e.getMessage(), e);
                }
                break;
            case 1:
                break;
            default:
                throw new IllegalStateException("Inconsistent parser state");
        }
        this.message.setHeaders(parseHeaders(this.sessionBuffer, this.messageConstraints.getMaxHeaderCount(), this.messageConstraints.getMaxLineLength(), this.lineParser, this.headerLines));
        T t = this.message;
        this.message = null;
        this.headerLines.clear();
        this.state = 0;
        return t;
    }
}

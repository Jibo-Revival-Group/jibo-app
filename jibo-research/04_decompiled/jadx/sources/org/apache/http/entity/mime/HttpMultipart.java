package org.apache.http.entity.mime;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class HttpMultipart extends AbstractMultipartForm {
    private final HttpMultipartMode mode;
    private final List<FormBodyPart> parts;

    @Override // org.apache.http.entity.mime.AbstractMultipartForm
    public /* bridge */ /* synthetic */ String getBoundary() {
        return super.getBoundary();
    }

    @Override // org.apache.http.entity.mime.AbstractMultipartForm
    public /* bridge */ /* synthetic */ Charset getCharset() {
        return super.getCharset();
    }

    @Override // org.apache.http.entity.mime.AbstractMultipartForm
    public /* bridge */ /* synthetic */ String getSubType() {
        return super.getSubType();
    }

    @Override // org.apache.http.entity.mime.AbstractMultipartForm
    public /* bridge */ /* synthetic */ long getTotalLength() {
        return super.getTotalLength();
    }

    @Override // org.apache.http.entity.mime.AbstractMultipartForm
    public /* bridge */ /* synthetic */ void writeTo(OutputStream outputStream) throws IOException {
        super.writeTo(outputStream);
    }

    public HttpMultipart(String str, Charset charset, String str2, HttpMultipartMode httpMultipartMode) {
        super(str, charset, str2);
        this.mode = httpMultipartMode;
        this.parts = new ArrayList();
    }

    public HttpMultipart(String str, Charset charset, String str2) {
        this(str, charset, str2, HttpMultipartMode.STRICT);
    }

    public HttpMultipart(String str, String str2) {
        this(str, null, str2);
    }

    public HttpMultipartMode getMode() {
        return this.mode;
    }

    @Override // org.apache.http.entity.mime.AbstractMultipartForm
    protected void formatMultipartHeader(FormBodyPart formBodyPart, OutputStream outputStream) throws IOException {
        Header header = formBodyPart.getHeader();
        switch (this.mode) {
            case BROWSER_COMPATIBLE:
                writeField(header.getField(MIME.CONTENT_DISPOSITION), this.charset, outputStream);
                if (formBodyPart.getBody().getFilename() != null) {
                    writeField(header.getField("Content-Type"), this.charset, outputStream);
                }
                break;
            default:
                Iterator<MinimalField> it = header.iterator();
                while (it.hasNext()) {
                    writeField(it.next(), outputStream);
                }
                break;
        }
    }

    @Override // org.apache.http.entity.mime.AbstractMultipartForm
    public List<FormBodyPart> getBodyParts() {
        return this.parts;
    }

    public void addBodyPart(FormBodyPart formBodyPart) {
        if (formBodyPart != null) {
            this.parts.add(formBodyPart);
        }
    }
}

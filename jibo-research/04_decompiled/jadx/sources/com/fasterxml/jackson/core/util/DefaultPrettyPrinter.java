package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.p000io.SerializedString;
import java.io.IOException;
import java.io.Serializable;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public class DefaultPrettyPrinter implements PrettyPrinter, Serializable {

    /* JADX INFO: renamed from: a */
    public static final SerializedString f5668a = new SerializedString(" ");

    /* JADX INFO: renamed from: b */
    protected Indenter f5669b;

    /* JADX INFO: renamed from: c */
    protected Indenter f5670c;

    /* JADX INFO: renamed from: d */
    protected final SerializableString f5671d;

    /* JADX INFO: renamed from: e */
    protected boolean f5672e;

    /* JADX INFO: renamed from: f */
    protected transient int f5673f;

    public interface Indenter {
        /* JADX INFO: renamed from: a */
        void mo6465a(JsonGenerator jsonGenerator, int i) throws IOException;

        /* JADX INFO: renamed from: a */
        boolean mo6466a();
    }

    public DefaultPrettyPrinter() {
        this(f5668a);
    }

    public DefaultPrettyPrinter(SerializableString serializableString) {
        this.f5669b = FixedSpaceIndenter.f5674a;
        this.f5670c = DefaultIndenter.f5664b;
        this.f5672e = true;
        this.f5673f = 0;
        this.f5671d = serializableString;
    }

    @Override // com.fasterxml.jackson.core.PrettyPrinter
    /* JADX INFO: renamed from: a */
    public void mo6085a(JsonGenerator jsonGenerator) throws IOException {
        if (this.f5671d != null) {
            jsonGenerator.mo6048b(this.f5671d);
        }
    }

    @Override // com.fasterxml.jackson.core.PrettyPrinter
    /* JADX INFO: renamed from: b */
    public void mo6087b(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.mo6037a('{');
        if (!this.f5670c.mo6466a()) {
            this.f5673f++;
        }
    }

    @Override // com.fasterxml.jackson.core.PrettyPrinter
    /* JADX INFO: renamed from: h */
    public void mo6094h(JsonGenerator jsonGenerator) throws IOException {
        this.f5670c.mo6465a(jsonGenerator, this.f5673f);
    }

    @Override // com.fasterxml.jackson.core.PrettyPrinter
    /* JADX INFO: renamed from: d */
    public void mo6090d(JsonGenerator jsonGenerator) throws IOException {
        if (this.f5672e) {
            jsonGenerator.mo6051c(" : ");
        } else {
            jsonGenerator.mo6037a(':');
        }
    }

    @Override // com.fasterxml.jackson.core.PrettyPrinter
    /* JADX INFO: renamed from: c */
    public void mo6089c(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.mo6037a(',');
        this.f5670c.mo6465a(jsonGenerator, this.f5673f);
    }

    @Override // com.fasterxml.jackson.core.PrettyPrinter
    /* JADX INFO: renamed from: a */
    public void mo6086a(JsonGenerator jsonGenerator, int i) throws IOException {
        if (!this.f5670c.mo6466a()) {
            this.f5673f--;
        }
        if (i > 0) {
            this.f5670c.mo6465a(jsonGenerator, this.f5673f);
        } else {
            jsonGenerator.mo6037a(TokenParser.f15715SP);
        }
        jsonGenerator.mo6037a('}');
    }

    @Override // com.fasterxml.jackson.core.PrettyPrinter
    /* JADX INFO: renamed from: e */
    public void mo6091e(JsonGenerator jsonGenerator) throws IOException {
        if (!this.f5669b.mo6466a()) {
            this.f5673f++;
        }
        jsonGenerator.mo6037a('[');
    }

    @Override // com.fasterxml.jackson.core.PrettyPrinter
    /* JADX INFO: renamed from: g */
    public void mo6093g(JsonGenerator jsonGenerator) throws IOException {
        this.f5669b.mo6465a(jsonGenerator, this.f5673f);
    }

    @Override // com.fasterxml.jackson.core.PrettyPrinter
    /* JADX INFO: renamed from: f */
    public void mo6092f(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.mo6037a(',');
        this.f5669b.mo6465a(jsonGenerator, this.f5673f);
    }

    @Override // com.fasterxml.jackson.core.PrettyPrinter
    /* JADX INFO: renamed from: b */
    public void mo6088b(JsonGenerator jsonGenerator, int i) throws IOException {
        if (!this.f5669b.mo6466a()) {
            this.f5673f--;
        }
        if (i > 0) {
            this.f5669b.mo6465a(jsonGenerator, this.f5673f);
        } else {
            jsonGenerator.mo6037a(TokenParser.f15715SP);
        }
        jsonGenerator.mo6037a(']');
    }

    public static class NopIndenter implements Indenter, Serializable {

        /* JADX INFO: renamed from: c */
        public static final NopIndenter f5675c = new NopIndenter();

        @Override // com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter
        /* JADX INFO: renamed from: a */
        public void mo6465a(JsonGenerator jsonGenerator, int i) throws IOException {
        }

        @Override // com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter
        /* JADX INFO: renamed from: a */
        public boolean mo6466a() {
            return true;
        }
    }

    public static class FixedSpaceIndenter extends NopIndenter {

        /* JADX INFO: renamed from: a */
        public static final FixedSpaceIndenter f5674a = new FixedSpaceIndenter();

        @Override // com.fasterxml.jackson.core.util.DefaultPrettyPrinter.NopIndenter, com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter
        /* JADX INFO: renamed from: a */
        public void mo6465a(JsonGenerator jsonGenerator, int i) throws IOException {
            jsonGenerator.mo6037a(TokenParser.f15715SP);
        }

        @Override // com.fasterxml.jackson.core.util.DefaultPrettyPrinter.NopIndenter, com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter
        /* JADX INFO: renamed from: a */
        public boolean mo6466a() {
            return true;
        }
    }
}

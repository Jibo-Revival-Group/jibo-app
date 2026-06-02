package com.google.api.client.json.jackson2;

import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
final class JacksonParser extends JsonParser {
    private final JacksonFactory factory;
    private final com.fasterxml.jackson.core.JsonParser parser;

    @Override // com.google.api.client.json.JsonParser
    public JacksonFactory getFactory() {
        return this.factory;
    }

    JacksonParser(JacksonFactory jacksonFactory, com.fasterxml.jackson.core.JsonParser jsonParser) {
        this.factory = jacksonFactory;
        this.parser = jsonParser;
    }

    @Override // com.google.api.client.json.JsonParser
    public void close() throws IOException {
        this.parser.close();
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken nextToken() throws IOException {
        return JacksonFactory.convert(this.parser.mo6061a());
    }

    @Override // com.google.api.client.json.JsonParser
    public String getCurrentName() throws IOException {
        return this.parser.mo6065d();
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonToken getCurrentToken() {
        return JacksonFactory.convert(this.parser.mo6064c());
    }

    @Override // com.google.api.client.json.JsonParser
    public JsonParser skipChildren() throws IOException {
        this.parser.mo6063b();
        return this;
    }

    @Override // com.google.api.client.json.JsonParser
    public String getText() throws IOException {
        return this.parser.mo6067f();
    }

    @Override // com.google.api.client.json.JsonParser
    public byte getByteValue() throws IOException {
        return this.parser.m6068g();
    }

    @Override // com.google.api.client.json.JsonParser
    public float getFloatValue() throws IOException {
        return this.parser.mo6073l();
    }

    @Override // com.google.api.client.json.JsonParser
    public int getIntValue() throws IOException {
        return this.parser.mo6070i();
    }

    @Override // com.google.api.client.json.JsonParser
    public short getShortValue() throws IOException {
        return this.parser.m6069h();
    }

    @Override // com.google.api.client.json.JsonParser
    public BigInteger getBigIntegerValue() throws IOException {
        return this.parser.mo6072k();
    }

    @Override // com.google.api.client.json.JsonParser
    public BigDecimal getDecimalValue() throws IOException {
        return this.parser.mo6075n();
    }

    @Override // com.google.api.client.json.JsonParser
    public double getDoubleValue() throws IOException {
        return this.parser.mo6074m();
    }

    @Override // com.google.api.client.json.JsonParser
    public long getLongValue() throws IOException {
        return this.parser.mo6071j();
    }
}

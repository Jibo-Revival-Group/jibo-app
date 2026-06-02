package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.p000io.CharTypes;
import com.fasterxml.jackson.core.p000io.CharacterEscapes;
import com.fasterxml.jackson.core.p000io.IOContext;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

/* JADX INFO: loaded from: classes.dex */
public abstract class JsonGeneratorImpl extends GeneratorBase {

    /* JADX INFO: renamed from: n */
    protected static final int[] f5541n = CharTypes.m6149f();

    /* JADX INFO: renamed from: o */
    protected final IOContext f5542o;

    /* JADX INFO: renamed from: p */
    protected int[] f5543p;

    /* JADX INFO: renamed from: q */
    protected int f5544q;

    /* JADX INFO: renamed from: r */
    protected CharacterEscapes f5545r;

    /* JADX INFO: renamed from: s */
    protected SerializableString f5546s;

    public JsonGeneratorImpl(IOContext iOContext, int i, ObjectCodec objectCodec) {
        super(i, objectCodec);
        this.f5543p = f5541n;
        this.f5546s = DefaultPrettyPrinter.f5668a;
        this.f5542o = iOContext;
        if (m6098a(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
            mo6032a(127);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: a */
    public JsonGenerator mo6032a(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f5544q = i;
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: a */
    public JsonGenerator mo6035a(CharacterEscapes characterEscapes) {
        this.f5545r = characterEscapes;
        if (characterEscapes == null) {
            this.f5543p = f5541n;
        } else {
            this.f5543p = characterEscapes.m6153a();
        }
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: a */
    public JsonGenerator mo6034a(SerializableString serializableString) {
        this.f5546s = serializableString;
        return this;
    }
}

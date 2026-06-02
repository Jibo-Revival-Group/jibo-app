package com.amazonaws.util.json;

import com.facebook.internal.ServerProtocol;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* JADX INFO: loaded from: classes.dex */
final class GsonFactory implements AwsJsonFactory {

    private static final class GsonReader implements AwsJsonReader {

        /* JADX INFO: renamed from: in */
        private Reader f4646in;
        private final JsonReader reader;

        public GsonReader(Reader reader) {
            this.f4646in = reader;
            this.reader = new JsonReader(reader);
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public void beginObject() throws IOException {
            this.reader.mo9508c();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public void close() throws IOException {
            this.reader.close();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public void endObject() throws IOException {
            this.reader.mo9509d();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public Reader getReader() {
            return this.f4646in;
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public boolean hasNext() {
            return this.reader.mo9510e();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public boolean isContainer() throws IOException {
            JsonToken jsonTokenMo9511f = this.reader.mo9511f();
            return JsonToken.BEGIN_ARRAY.equals(jsonTokenMo9511f) || JsonToken.BEGIN_OBJECT.equals(jsonTokenMo9511f);
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public String nextName() {
            return this.reader.mo9512g();
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public String nextString() throws IOException {
            JsonToken jsonTokenMo9511f = this.reader.mo9511f();
            if (!JsonToken.NULL.equals(jsonTokenMo9511f)) {
                return JsonToken.BOOLEAN.equals(jsonTokenMo9511f) ? this.reader.mo9514i() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false" : this.reader.mo9513h();
            }
            this.reader.mo9515j();
            return null;
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public AwsJsonToken peek() {
            try {
                return GsonFactory.convert(this.reader.mo9511f());
            } catch (EOFException e) {
                return null;
            }
        }

        @Override // com.amazonaws.util.json.AwsJsonReader
        public void skipValue() throws IOException {
            this.reader.mo9519n();
        }
    }

    GsonFactory() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AwsJsonToken convert(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        switch (jsonToken) {
        }
        return null;
    }

    @Override // com.amazonaws.util.json.AwsJsonFactory
    public AwsJsonReader getJsonReader(Reader reader) {
        return new GsonReader(reader);
    }
}

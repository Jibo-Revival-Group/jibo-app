package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes.dex */
public final class JsonParser {
    /* JADX INFO: renamed from: a */
    public JsonElement m9413a(String str) throws JsonSyntaxException {
        return m9412a(new StringReader(str));
    }

    /* JADX INFO: renamed from: a */
    public JsonElement m9412a(Reader reader) throws JsonSyntaxException, JsonIOException {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            JsonElement jsonElementM9411a = m9411a(jsonReader);
            if (!jsonElementM9411a.m9394k() && jsonReader.mo9511f() != JsonToken.END_DOCUMENT) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
            return jsonElementM9411a;
        } catch (MalformedJsonException e) {
            throw new JsonSyntaxException(e);
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        } catch (NumberFormatException e3) {
            throw new JsonSyntaxException(e3);
        }
    }

    /* JADX INFO: renamed from: a */
    public JsonElement m9411a(JsonReader jsonReader) throws JsonSyntaxException, JsonIOException {
        boolean zM9642q = jsonReader.m9642q();
        jsonReader.m9641a(true);
        try {
            try {
                try {
                    return Streams.m9489a(jsonReader);
                } catch (OutOfMemoryError e) {
                    throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e);
                }
            } catch (StackOverflowError e2) {
                throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e2);
            }
        } finally {
            jsonReader.m9641a(zM9642q);
        }
    }
}

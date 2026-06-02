package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public final class Streams {
    /* JADX INFO: renamed from: a */
    public static JsonElement m9489a(JsonReader jsonReader) throws JsonParseException {
        boolean z = true;
        try {
            jsonReader.mo9511f();
            z = false;
            return TypeAdapters.f8994X.read(jsonReader);
        } catch (MalformedJsonException e) {
            throw new JsonSyntaxException(e);
        } catch (EOFException e2) {
            if (z) {
                return JsonNull.f8819a;
            }
            throw new JsonSyntaxException(e2);
        } catch (IOException e3) {
            throw new JsonIOException(e3);
        } catch (NumberFormatException e4) {
            throw new JsonSyntaxException(e4);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m9491a(JsonElement jsonElement, JsonWriter jsonWriter) throws IOException {
        TypeAdapters.f8994X.write(jsonWriter, jsonElement);
    }

    /* JADX INFO: renamed from: a */
    public static Writer m9490a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new AppendableWriter(appendable);
    }

    private static final class AppendableWriter extends Writer {

        /* JADX INFO: renamed from: a */
        private final Appendable f8897a;

        /* JADX INFO: renamed from: b */
        private final CurrentWrite f8898b = new CurrentWrite();

        AppendableWriter(Appendable appendable) {
            this.f8897a = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            this.f8898b.f8899a = cArr;
            this.f8897a.append(this.f8898b, i, i + i2);
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.f8897a.append((char) i);
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        static class CurrentWrite implements CharSequence {

            /* JADX INFO: renamed from: a */
            char[] f8899a;

            CurrentWrite() {
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f8899a.length;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.f8899a[i];
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.f8899a, i, i2 - i);
            }
        }
    }
}

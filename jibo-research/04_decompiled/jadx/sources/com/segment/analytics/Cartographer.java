package com.segment.analytics;

import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Cartographer {
    static final Cartographer INSTANCE = new Builder().lenient(true).prettyPrint(false).build();
    private final boolean isLenient;
    private final boolean prettyPrint;

    Cartographer(boolean z, boolean z2) {
        this.isLenient = z;
        this.prettyPrint = z2;
    }

    public Map<String, Object> fromJson(String str) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("json == null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("json empty");
        }
        return fromJson(new StringReader(str));
    }

    public Map<String, Object> fromJson(Reader reader) throws IOException {
        if (reader == null) {
            throw new IllegalArgumentException("reader == null");
        }
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(this.isLenient);
        try {
            return readerToMap(jsonReader);
        } finally {
            reader.close();
        }
    }

    public String toJson(Map<?, ?> map) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(map, stringWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public void toJson(Map<?, ?> map, Writer writer) throws IOException {
        if (map == null) {
            throw new IllegalArgumentException("map == null");
        }
        if (writer == null) {
            throw new IllegalArgumentException("writer == null");
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        jsonWriter.setLenient(this.isLenient);
        if (this.prettyPrint) {
            jsonWriter.setIndent("  ");
        }
        try {
            mapToWriter(map, jsonWriter);
        } finally {
            jsonWriter.close();
        }
    }

    private static Map<String, Object> readerToMap(JsonReader jsonReader) throws IOException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            linkedHashMap.put(jsonReader.nextName(), readValue(jsonReader));
        }
        jsonReader.endObject();
        return linkedHashMap;
    }

    private static List<Object> readerToList(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(readValue(jsonReader));
        }
        jsonReader.endArray();
        return arrayList;
    }

    /* JADX INFO: renamed from: com.segment.analytics.Cartographer$1 */
    static /* synthetic */ class C17101 {
        static final /* synthetic */ int[] $SwitchMap$android$util$JsonToken = new int[JsonToken.values().length];

        static {
            try {
                $SwitchMap$android$util$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$util$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$util$JsonToken[JsonToken.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$util$JsonToken[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$android$util$JsonToken[JsonToken.NUMBER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$android$util$JsonToken[JsonToken.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private static Object readValue(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        switch (C17101.$SwitchMap$android$util$JsonToken[jsonTokenPeek.ordinal()]) {
            case 1:
                return readerToMap(jsonReader);
            case 2:
                return readerToList(jsonReader);
            case 3:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 4:
                jsonReader.nextNull();
                return null;
            case 5:
                return Double.valueOf(jsonReader.nextDouble());
            case 6:
                return jsonReader.nextString();
            default:
                throw new IllegalStateException("Invalid token " + jsonTokenPeek);
        }
    }

    private static void mapToWriter(Map<?, ?> map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginObject();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            jsonWriter.name(String.valueOf(entry.getKey()));
            writeValue(entry.getValue(), jsonWriter);
        }
        jsonWriter.endObject();
    }

    private static void listToWriter(List<?> list, JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginArray();
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            writeValue(it.next(), jsonWriter);
        }
        jsonWriter.endArray();
    }

    private static void arrayToWriter(Object obj, JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginArray();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            writeValue(Array.get(obj, i), jsonWriter);
        }
        jsonWriter.endArray();
    }

    private static void writeValue(Object obj, JsonWriter jsonWriter) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return;
        }
        if (obj instanceof Boolean) {
            jsonWriter.value(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof List) {
            listToWriter((List) obj, jsonWriter);
            return;
        }
        if (obj instanceof Map) {
            mapToWriter((Map) obj, jsonWriter);
        } else if (obj.getClass().isArray()) {
            arrayToWriter(obj, jsonWriter);
        } else {
            jsonWriter.value(String.valueOf(obj));
        }
    }

    public static class Builder {
        private boolean isLenient;
        private boolean prettyPrint;

        public Builder lenient(boolean z) {
            this.isLenient = z;
            return this;
        }

        public Builder prettyPrint(boolean z) {
            this.prettyPrint = z;
            return this;
        }

        public Cartographer build() {
            return new Cartographer(this.isLenient, this.prettyPrint);
        }
    }
}

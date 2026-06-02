package com.google.maps.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.maps.model.PriceLevel;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class PriceLevelAdapter extends TypeAdapter<PriceLevel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public PriceLevel read(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo9511f() == JsonToken.NULL) {
            jsonReader.mo9515j();
            return null;
        }
        if (jsonReader.mo9511f() == JsonToken.NUMBER) {
            switch (jsonReader.mo9518m()) {
                case 0:
                    return PriceLevel.FREE;
                case 1:
                    return PriceLevel.INEXPENSIVE;
                case 2:
                    return PriceLevel.MODERATE;
                case 3:
                    return PriceLevel.EXPENSIVE;
                case 4:
                    return PriceLevel.VERY_EXPENSIVE;
            }
        }
        return PriceLevel.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, PriceLevel priceLevel) throws IOException {
        throw new UnsupportedOperationException("Unimplemented method");
    }
}

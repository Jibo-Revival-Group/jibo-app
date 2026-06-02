package com.google.maps.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.maps.model.Fare;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Currency;

/* JADX INFO: loaded from: classes.dex */
public class FareAdapter extends TypeAdapter<Fare> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public Fare read(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo9511f() == JsonToken.NULL) {
            jsonReader.mo9515j();
            return null;
        }
        Fare fare = new Fare();
        jsonReader.mo9508c();
        while (jsonReader.mo9510e()) {
            String strMo9512g = jsonReader.mo9512g();
            if ("currency".equals(strMo9512g)) {
                fare.currency = Currency.getInstance(jsonReader.mo9513h());
            } else if ("value".equals(strMo9512g)) {
                fare.value = new BigDecimal(jsonReader.mo9513h());
            } else {
                jsonReader.mo9519n();
            }
        }
        jsonReader.mo9509d();
        return fare;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Fare fare) throws IOException {
        throw new UnsupportedOperationException("Unimplemented method");
    }
}

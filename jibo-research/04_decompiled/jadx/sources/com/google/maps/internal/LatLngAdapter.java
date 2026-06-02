package com.google.maps.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.maps.model.LatLng;
import com.jibo.aws.integration.helpers.RobotHelper;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class LatLngAdapter extends TypeAdapter<LatLng> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public LatLng read(JsonReader jsonReader) throws IOException {
        boolean z = false;
        double dMo9516k = 0.0d;
        if (jsonReader.mo9511f() == JsonToken.NULL) {
            jsonReader.mo9515j();
            return null;
        }
        jsonReader.mo9508c();
        boolean z2 = false;
        double dMo9516k2 = 0.0d;
        while (jsonReader.mo9510e()) {
            String strMo9512g = jsonReader.mo9512g();
            if (RobotHelper.FIELD_LATITUDE.equals(strMo9512g) || "latitude".equals(strMo9512g)) {
                dMo9516k2 = jsonReader.mo9516k();
                z2 = true;
            } else if (RobotHelper.FIELD_LONGITUDE.equals(strMo9512g) || "longitude".equals(strMo9512g)) {
                dMo9516k = jsonReader.mo9516k();
                z = true;
            }
        }
        jsonReader.mo9509d();
        if (z2 && z) {
            return new LatLng(dMo9516k2, dMo9516k);
        }
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, LatLng latLng) throws IOException {
        throw new UnsupportedOperationException("Unimplemented method.");
    }
}

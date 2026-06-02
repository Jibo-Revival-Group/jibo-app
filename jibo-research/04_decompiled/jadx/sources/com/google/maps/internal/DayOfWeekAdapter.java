package com.google.maps.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.maps.model.OpeningHours;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class DayOfWeekAdapter extends TypeAdapter<OpeningHours.Period.OpenClose.DayOfWeek> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public OpeningHours.Period.OpenClose.DayOfWeek read(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo9511f() == JsonToken.NULL) {
            jsonReader.mo9515j();
            return null;
        }
        if (jsonReader.mo9511f() == JsonToken.NUMBER) {
            switch (jsonReader.mo9518m()) {
                case 0:
                    return OpeningHours.Period.OpenClose.DayOfWeek.SUNDAY;
                case 1:
                    return OpeningHours.Period.OpenClose.DayOfWeek.MONDAY;
                case 2:
                    return OpeningHours.Period.OpenClose.DayOfWeek.TUESDAY;
                case 3:
                    return OpeningHours.Period.OpenClose.DayOfWeek.WEDNESDAY;
                case 4:
                    return OpeningHours.Period.OpenClose.DayOfWeek.THURSDAY;
                case 5:
                    return OpeningHours.Period.OpenClose.DayOfWeek.FRIDAY;
                case 6:
                    return OpeningHours.Period.OpenClose.DayOfWeek.SATURDAY;
            }
        }
        return OpeningHours.Period.OpenClose.DayOfWeek.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, OpeningHours.Period.OpenClose.DayOfWeek dayOfWeek) throws IOException {
        throw new UnsupportedOperationException("Unimplemented method");
    }
}

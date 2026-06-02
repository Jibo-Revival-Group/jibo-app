package com.google.maps.internal;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.maps.GeolocationApi;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;
import java.io.IOException;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class GeolocationResponseAdapter extends TypeAdapter<GeolocationApi.Response> {
    private static final Logger LOG = Logger.getLogger(GeolocationApi.Response.class.getName());

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public GeolocationApi.Response read(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo9511f() == JsonToken.NULL) {
            jsonReader.mo9515j();
            return null;
        }
        GeolocationApi.Response response = new GeolocationApi.Response();
        LatLngAdapter latLngAdapter = new LatLngAdapter();
        jsonReader.mo9508c();
        while (jsonReader.mo9510e()) {
            String strMo9512g = jsonReader.mo9512g();
            if (strMo9512g.equals(SkillsJsonParser.TYPE_LOCATION)) {
                response.location = latLngAdapter.read(jsonReader);
            } else if (strMo9512g.equals("accuracy")) {
                response.accuracy = jsonReader.mo9516k();
            } else if (strMo9512g.equals("error")) {
                jsonReader.mo9508c();
                while (jsonReader.mo9510e()) {
                    String strMo9512g2 = jsonReader.mo9512g();
                    if (strMo9512g2.equals("code")) {
                        response.code = jsonReader.mo9518m();
                    } else if (strMo9512g2.equals(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)) {
                        response.message = jsonReader.mo9513h();
                    } else if (strMo9512g2.equals("errors")) {
                        jsonReader.mo9506a();
                        while (jsonReader.mo9510e()) {
                            jsonReader.mo9508c();
                            while (jsonReader.mo9510e()) {
                                String strMo9512g3 = jsonReader.mo9512g();
                                if (strMo9512g3.equals("reason")) {
                                    response.reason = jsonReader.mo9513h();
                                } else if (strMo9512g3.equals("domain")) {
                                    response.domain = jsonReader.mo9513h();
                                } else if (strMo9512g3.equals("debugInfo")) {
                                    response.debugInfo = jsonReader.mo9513h();
                                } else if (strMo9512g3.equals(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)) {
                                    jsonReader.mo9513h();
                                } else if (strMo9512g3.equals(SkillsJsonParser.TYPE_LOCATION)) {
                                    jsonReader.mo9513h();
                                } else if (strMo9512g3.equals("locationType")) {
                                    jsonReader.mo9513h();
                                }
                            }
                            jsonReader.mo9509d();
                        }
                        jsonReader.mo9507b();
                    }
                }
                jsonReader.mo9509d();
            }
        }
        jsonReader.mo9509d();
        return response;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GeolocationApi.Response response) throws IOException {
        throw new UnsupportedOperationException("Unimplemented method.");
    }
}

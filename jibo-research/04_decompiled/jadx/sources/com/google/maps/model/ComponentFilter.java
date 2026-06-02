package com.google.maps.model;

import com.google.maps.internal.StringJoin;
import com.jibo.aws.integration.helpers.RobotHelper;

/* JADX INFO: loaded from: classes.dex */
public class ComponentFilter implements StringJoin.UrlValue {
    public final String component;
    public final String value;

    ComponentFilter(String str, String str2) {
        this.component = str;
        this.value = str2;
    }

    public String toString() {
        return toUrlValue();
    }

    @Override // com.google.maps.internal.StringJoin.UrlValue
    public String toUrlValue() {
        return StringJoin.join(':', this.component, this.value);
    }

    public static ComponentFilter route(String str) {
        return new ComponentFilter("route", str);
    }

    public static ComponentFilter locality(String str) {
        return new ComponentFilter("locality", str);
    }

    public static ComponentFilter administrativeArea(String str) {
        return new ComponentFilter("administrative_area", str);
    }

    public static ComponentFilter postalCode(String str) {
        return new ComponentFilter("postal_code", str);
    }

    public static ComponentFilter country(String str) {
        return new ComponentFilter(RobotHelper.FIELD_COUNTRY, str);
    }
}

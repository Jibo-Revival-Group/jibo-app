.class public Lcom/google/android/gms/location/places/PlacesStatusCodes;
.super Lcom/google/android/gms/common/api/CommonStatusCodes;


# direct methods
.method public static b(I)Ljava/lang/String;
    .locals 1

    sparse-switch p0, :sswitch_data_0

    invoke-static {p0}, Lcom/google/android/gms/common/api/CommonStatusCodes;->a(I)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :sswitch_0
    const-string v0, "PLACES_API_QUOTA_FAILED"

    goto :goto_0

    :sswitch_1
    const-string v0, "PLACES_API_USAGE_LIMIT_EXCEEDED"

    goto :goto_0

    :sswitch_2
    const-string v0, "PLACES_API_KEY_INVALID"

    goto :goto_0

    :sswitch_3
    const-string v0, "PLACES_API_ACCESS_NOT_CONFIGURED"

    goto :goto_0

    :sswitch_4
    const-string v0, "PLACES_API_INVALID_ARGUMENT"

    goto :goto_0

    :sswitch_5
    const-string v0, "PLACES_API_RATE_LIMIT_EXCEEDED"

    goto :goto_0

    :sswitch_6
    const-string v0, "PLACES_API_DEVICE_RATE_LIMIT_EXCEEDED"

    goto :goto_0

    :sswitch_7
    const-string v0, "PLACES_API_KEY_EXPIRED"

    goto :goto_0

    :sswitch_8
    const-string v0, "PLACE_ALIAS_NOT_FOUND"

    goto :goto_0

    :sswitch_9
    const-string v0, "PLACE_PROXIMITY_UNKNOWN"

    goto :goto_0

    :sswitch_a
    const-string v0, "NEARBY_ALERTS_NOT_AVAILABLE"

    goto :goto_0

    :sswitch_b
    const-string v0, "PLACES_API_INVALID_APP"

    goto :goto_0

    :sswitch_c
    const-string v0, "PLACEFENCING_NOT_AVAILABLE"

    goto :goto_0

    :sswitch_d
    const-string v0, "PLACES_API_PERSONALIZED_DATA_ACCESS_APPROVED"

    goto :goto_0

    :sswitch_e
    const-string v0, "PLACES_API_PERSONALIZED_DATA_ACCESS_REJECTED"

    goto :goto_0

    nop

    :sswitch_data_0
    .sparse-switch
        0x2328 -> :sswitch_0
        0x2329 -> :sswitch_1
        0x232a -> :sswitch_2
        0x232b -> :sswitch_3
        0x232c -> :sswitch_4
        0x232d -> :sswitch_5
        0x232e -> :sswitch_6
        0x232f -> :sswitch_7
        0x2330 -> :sswitch_b
        0x235b -> :sswitch_8
        0x238d -> :sswitch_9
        0x238e -> :sswitch_a
        0x23be -> :sswitch_c
        0x23f1 -> :sswitch_d
        0x23f2 -> :sswitch_e
    .end sparse-switch
.end method

.method public static c(I)Lcom/google/android/gms/common/api/Status;
    .locals 2

    invoke-static {p0}, Lcom/google/android/gms/location/places/PlacesStatusCodes;->b(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/common/internal/zzbq;->a(Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v1, Lcom/google/android/gms/common/api/Status;

    invoke-direct {v1, p0, v0}, Lcom/google/android/gms/common/api/Status;-><init>(ILjava/lang/String;)V

    return-object v1
.end method

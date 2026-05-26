.class public Lcom/jibo/aws/integration/helpers/RobotHelper;
.super Ljava/lang/Object;


# static fields
.field public static final FIELD_ADDRESS_LINE:Ljava/lang/String; = "addressLine"

.field public static final FIELD_AVATAR:Ljava/lang/String; = "avatar"

.field public static final FIELD_CITY:Ljava/lang/String; = "city"

.field public static final FIELD_CONNECTED_AT:Ljava/lang/String; = "connectedAt"

.field public static final FIELD_COUNTRY:Ljava/lang/String; = "country"

.field public static final FIELD_COUNTRY_CODE:Ljava/lang/String; = "countryCode"

.field public static final FIELD_LATITUDE:Ljava/lang/String; = "lat"

.field public static final FIELD_LOCATION_OVERRIDE_OBJECT:Ljava/lang/String; = "locationOverride"

.field public static final FIELD_LONGITUDE:Ljava/lang/String; = "lng"

.field public static final FIELD_PLATFORM:Ljava/lang/String; = "platform"

.field public static final FIELD_REMOTE_ENABLED:Ljava/lang/String; = "remoteEnabled"

.field public static final FIELD_SERIAL_NUMBER:Ljava/lang/String; = "serialNumber"

.field public static final FIELD_SSID:Ljava/lang/String; = "SSID"

.field public static final FIELD_STATE:Ljava/lang/String; = "state"

.field public static final FIELD_STATE_ABBR:Ljava/lang/String; = "stateAbbr"

.field public static final FIELD_TIMEZONE:Ljava/lang/String; = "timezone"

.field public static final FIELD_ZIPCODE:Ljava/lang/String; = "zipcode"


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getAddressLine(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;
    .locals 3

    const/4 v0, 0x0

    if-eqz p0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v1

    const-string v2, "locationOverride"

    invoke-virtual {v1, v2}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v1

    const-string v2, "locationOverride"

    invoke-virtual {v1, v2}, Lcom/google/gson/JsonObject;->e(Ljava/lang/String;)Lcom/google/gson/JsonObject;

    move-result-object v1

    if-eqz v1, :cond_0

    const-string v2, "addressLine"

    invoke-virtual {v1, v2}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    const-string v2, "addressLine"

    invoke-virtual {v1, v2}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/gson/JsonElement;->c()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :cond_0
    :goto_0
    return-object v0

    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public static getAvatar(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)I
    .locals 3

    const/4 v0, 0x0

    if-nez p0, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v1

    const-string v2, "avatar"

    invoke-virtual {v1, v2}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v1

    const-string v2, "avatar"

    invoke-virtual {v1, v2}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/gson/JsonElement;->f()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    goto :goto_0

    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public static getCountryCode(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;
    .locals 3

    const/4 v0, 0x0

    if-eqz p0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v1

    const-string v2, "locationOverride"

    invoke-virtual {v1, v2}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v1

    const-string v2, "locationOverride"

    invoke-virtual {v1, v2}, Lcom/google/gson/JsonObject;->e(Ljava/lang/String;)Lcom/google/gson/JsonObject;

    move-result-object v1

    if-eqz v1, :cond_0

    const-string v2, "countryCode"

    invoke-virtual {v1, v2}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    const-string v2, "countryCode"

    invoke-virtual {v1, v2}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/gson/JsonElement;->c()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :cond_0
    :goto_0
    return-object v0

    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public static getLatLon(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Landroid/location/Location;
    .locals 6

    const/4 v1, 0x0

    if-eqz p0, :cond_2

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v2, "locationOverride"

    invoke-virtual {v0, v2}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    new-instance v0, Landroid/location/Location;

    const-string v2, "JIBO_LOCATION"

    invoke-direct {v0, v2}, Landroid/location/Location;-><init>(Ljava/lang/String;)V

    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v2

    const-string v3, "locationOverride"

    invoke-virtual {v2, v3}, Lcom/google/gson/JsonObject;->e(Ljava/lang/String;)Lcom/google/gson/JsonObject;

    move-result-object v2

    if-eqz v2, :cond_0

    const-string v3, "lat"

    invoke-virtual {v2, v3}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    const-string v3, "lat"

    invoke-virtual {v2, v3}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/gson/JsonElement;->d()D

    move-result-wide v4

    invoke-virtual {v0, v4, v5}, Landroid/location/Location;->setLatitude(D)V

    :cond_0
    if-eqz v2, :cond_1

    const-string v3, "lng"

    invoke-virtual {v2, v3}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    const-string v3, "lng"

    invoke-virtual {v2, v3}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/gson/JsonElement;->d()D

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Landroid/location/Location;->setLongitude(D)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :cond_1
    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    move-object v0, v1

    goto :goto_0

    :cond_2
    move-object v0, v1

    goto :goto_0

    :cond_3
    move-object v0, v1

    goto :goto_0
.end method

.method public static getLocation(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;
    .locals 4

    if-nez p0, :cond_0

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v0, 0x0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v2

    const-string v3, "locationOverride"

    invoke-virtual {v2, v3}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v2, "locationOverride"

    invoke-virtual {v0, v2}, Lcom/google/gson/JsonObject;->e(Ljava/lang/String;)Lcom/google/gson/JsonObject;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :cond_1
    if-nez v0, :cond_2

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_2
    const-string v2, "city"

    invoke-virtual {v0, v2}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    const-string v2, "city"

    invoke-virtual {v0, v2}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/gson/JsonElement;->c()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_3
    const-string v2, "state"

    invoke-virtual {v0, v2}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "state"

    invoke-virtual {v0, v3}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/gson/JsonElement;->c()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_4
    const-string v2, "country"

    invoke-virtual {v0, v2}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "country"

    invoke-virtual {v0, v3}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/gson/JsonElement;->c()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_5
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getRobotOS(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;
    .locals 2

    if-nez p0, :cond_0

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v1, "platform"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v1, "platform"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/gson/JsonElement;->c()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getRobotSerialName(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;
    .locals 2

    if-nez p0, :cond_0

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v1, "serialNumber"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v1, "serialNumber"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/gson/JsonElement;->c()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getTimeZone(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;
    .locals 2

    if-nez p0, :cond_0

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v1, "timezone"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v1, "timezone"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/gson/JsonElement;->c()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getTimeZoneFriendly(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/util/TimeZone;->getDisplayName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " (GMT "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/util/TimeZone;->getRawOffset()I

    move-result v0

    invoke-static {v0}, Lcom/jibo/aws/integration/util/DateTimeUtils;->getHourOffset(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ")"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :goto_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    invoke-static {p0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    goto :goto_0

    :cond_1
    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1
.end method

.method public static getWifiName(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;
    .locals 2

    if-nez p0, :cond_0

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v1, "SSID"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v1, "SSID"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/gson/JsonElement;->c()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_1
    const-string v0, ""

    goto :goto_0
.end method

.method public static getZipcode(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;
    .locals 3

    const/4 v0, 0x0

    if-eqz p0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v1

    const-string v2, "locationOverride"

    invoke-virtual {v1, v2}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v1

    const-string v2, "locationOverride"

    invoke-virtual {v1, v2}, Lcom/google/gson/JsonObject;->e(Ljava/lang/String;)Lcom/google/gson/JsonObject;

    move-result-object v1

    if-eqz v1, :cond_0

    const-string v2, "zipcode"

    invoke-virtual {v1, v2}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    const-string v2, "zipcode"

    invoke-virtual {v1, v2}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/gson/JsonElement;->c()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :cond_0
    :goto_0
    return-object v0

    :catch_0
    move-exception v1

    goto :goto_0
.end method

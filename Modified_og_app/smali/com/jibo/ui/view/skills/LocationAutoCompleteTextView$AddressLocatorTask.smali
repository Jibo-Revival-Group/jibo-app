.class Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;
.super Landroid/os/AsyncTask;
.source "LocationAutoCompleteTextView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AddressLocatorTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Landroid/location/Location;",
        "Ljava/lang/Void;",
        "Landroid/os/Bundle;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Lcom/jibo/ui/fragment/settings/LocationFragment$AsyncGeocoderTaskProcessor;

.field private b:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/jibo/ui/fragment/settings/LocationFragment$AsyncGeocoderTaskProcessor;)V
    .locals 1

    .prologue
    .line 349
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 350
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;->b:Landroid/content/Context;

    .line 351
    iput-object p2, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;->a:Lcom/jibo/ui/fragment/settings/LocationFragment$AsyncGeocoderTaskProcessor;

    .line 352
    return-void
.end method


# virtual methods
.method protected varargs a([Landroid/location/Location;)Landroid/os/Bundle;
    .locals 10

    .prologue
    .line 364
    new-instance v7, Landroid/os/Bundle;

    invoke-direct {v7}, Landroid/os/Bundle;-><init>()V

    .line 366
    new-instance v1, Landroid/location/Geocoder;

    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;->b:Landroid/content/Context;

    invoke-direct {v1, v0}, Landroid/location/Geocoder;-><init>(Landroid/content/Context;)V

    .line 369
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;->isCancelled()Z

    move-result v0

    if-eqz v0, :cond_0

    move-object v0, v7

    .line 411
    :goto_0
    return-object v0

    .line 372
    :cond_0
    new-instance v0, Lcom/google/maps/GeoApiContext$Builder;

    invoke-direct {v0}, Lcom/google/maps/GeoApiContext$Builder;-><init>()V

    iget-object v2, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;->b:Landroid/content/Context;

    const v3, 0x7f100144

    .line 373
    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/google/maps/GeoApiContext$Builder;->apiKey(Ljava/lang/String;)Lcom/google/maps/GeoApiContext$Builder;

    move-result-object v0

    .line 374
    invoke-virtual {v0}, Lcom/google/maps/GeoApiContext$Builder;->build()Lcom/google/maps/GeoApiContext;

    move-result-object v0

    .line 375
    new-instance v2, Lcom/google/maps/model/LatLng;

    const/4 v3, 0x0

    aget-object v3, p1, v3

    .line 376
    invoke-virtual {v3}, Landroid/location/Location;->getLatitude()D

    move-result-wide v4

    const/4 v3, 0x0

    aget-object v3, p1, v3

    invoke-virtual {v3}, Landroid/location/Location;->getLongitude()D

    move-result-wide v8

    invoke-direct {v2, v4, v5, v8, v9}, Lcom/google/maps/model/LatLng;-><init>(DD)V

    .line 375
    invoke-static {v0, v2}, Lcom/google/maps/TimeZoneApi;->getTimeZone(Lcom/google/maps/GeoApiContext;Lcom/google/maps/model/LatLng;)Lcom/google/maps/PendingResult;

    move-result-object v0

    .line 377
    invoke-interface {v0}, Lcom/google/maps/PendingResult;->awaitIgnoreError()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/TimeZone;

    .line 378
    invoke-virtual {v0}, Ljava/util/TimeZone;->getID()Ljava/lang/String;

    move-result-object v0

    const-string v2, "/"

    const-string v3, "\\/"

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 379
    const-string v2, "timezone"

    invoke-virtual {v7, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 381
    invoke-virtual {p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;->isCancelled()Z

    move-result v0

    if-eqz v0, :cond_1

    move-object v0, v7

    goto :goto_0

    .line 384
    :cond_1
    const/4 v0, 0x0

    aget-object v0, p1, v0

    invoke-virtual {v0}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    const/4 v0, 0x0

    aget-object v0, p1, v0

    invoke-virtual {v0}, Landroid/location/Location;->getLongitude()D

    move-result-wide v4

    const/4 v6, 0x1

    invoke-virtual/range {v1 .. v6}, Landroid/location/Geocoder;->getFromLocation(DDI)Ljava/util/List;

    move-result-object v0

    .line 386
    invoke-virtual {p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;->isCancelled()Z

    move-result v1

    if-eqz v1, :cond_2

    move-object v0, v7

    goto :goto_0

    .line 389
    :cond_2
    if-eqz v0, :cond_4

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_4

    .line 390
    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/Address;

    .line 393
    invoke-virtual {v0}, Landroid/location/Address;->getLocality()Ljava/lang/String;

    move-result-object v1

    .line 394
    if-eqz v1, :cond_5

    .line 397
    :goto_1
    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 398
    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 399
    const/4 v2, 0x0

    aget-object v1, v1, v2

    .line 401
    :cond_3
    const-string v2, "city"

    invoke-virtual {v7, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 402
    const-string v1, "state"

    invoke-virtual {v0}, Landroid/location/Address;->getAdminArea()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v7, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 403
    const-string v1, "country"

    invoke-virtual {v0}, Landroid/location/Address;->getCountryName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v7, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 404
    const-string v1, "lat"

    const/4 v2, 0x0

    aget-object v2, p1, v2

    invoke-virtual {v2}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-virtual {v7, v1, v2, v3}, Landroid/os/Bundle;->putDouble(Ljava/lang/String;D)V

    .line 405
    const-string v1, "lng"

    const/4 v2, 0x0

    aget-object v2, p1, v2

    invoke-virtual {v2}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    invoke-virtual {v7, v1, v2, v3}, Landroid/os/Bundle;->putDouble(Ljava/lang/String;D)V

    .line 406
    const-string v1, "addressLine"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Landroid/location/Address;->getFeatureName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Landroid/location/Address;->getThoroughfare()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v7, v1, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :cond_4
    :goto_2
    move-object v0, v7

    .line 411
    goto/16 :goto_0

    .line 395
    :cond_5
    invoke-virtual {v0}, Landroid/location/Address;->getMaxAddressLineIndex()I

    move-result v1

    const/4 v2, 0x2

    if-lt v1, v2, :cond_6

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/location/Address;->getAddressLine(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    :cond_6
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/location/Address;->getAddressLine(I)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    goto :goto_1

    .line 408
    :catch_0
    move-exception v0

    goto :goto_2
.end method

.method protected a(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 356
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;->b:Landroid/content/Context;

    .line 357
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;->a:Lcom/jibo/ui/fragment/settings/LocationFragment$AsyncGeocoderTaskProcessor;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 358
    iget-object v0, p0, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;->a:Lcom/jibo/ui/fragment/settings/LocationFragment$AsyncGeocoderTaskProcessor;

    invoke-interface {v0, p1}, Lcom/jibo/ui/fragment/settings/LocationFragment$AsyncGeocoderTaskProcessor;->a(Landroid/os/Bundle;)V

    .line 360
    :cond_0
    return-void
.end method

.method protected synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 345
    check-cast p1, [Landroid/location/Location;

    invoke-virtual {p0, p1}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;->a([Landroid/location/Location;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method protected synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 345
    check-cast p1, Landroid/os/Bundle;

    invoke-virtual {p0, p1}, Lcom/jibo/ui/view/skills/LocationAutoCompleteTextView$AddressLocatorTask;->a(Landroid/os/Bundle;)V

    return-void
.end method

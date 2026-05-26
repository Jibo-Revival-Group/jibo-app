.class Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$3;
.super Ljava/lang/Object;
.source "StationGenresFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->r()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazonaws/handlers/AsyncHandler",
        "<",
        "Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;",
        "Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)V
    .locals 0

    .prologue
    .line 309
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$3;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
    .locals 10

    .prologue
    const/4 v9, 0x0

    const/4 v8, 0x0

    .line 324
    invoke-static {p2}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getLatLon(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Landroid/location/Location;

    move-result-object v0

    .line 325
    if-eqz v0, :cond_3

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$3;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->d()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 328
    :try_start_0
    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v1

    const-string v2, "locationOverride"

    .line 329
    invoke-virtual {v1, v2}, Lcom/google/gson/JsonObject;->e(Ljava/lang/String;)Lcom/google/gson/JsonObject;

    move-result-object v7

    .line 330
    new-instance v1, Landroid/location/Geocoder;

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$3;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-virtual {v2}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/location/Geocoder;-><init>(Landroid/content/Context;)V

    .line 331
    invoke-virtual {v0}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-virtual {v0}, Landroid/location/Location;->getLongitude()D

    move-result-wide v4

    const/4 v6, 0x1

    invoke-virtual/range {v1 .. v6}, Landroid/location/Geocoder;->getFromLocation(DDI)Ljava/util/List;

    move-result-object v0

    .line 332
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$3;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->d()Z

    move-result v1

    if-eqz v1, :cond_0

    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 333
    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/Address;

    .line 335
    const-string v1, "zipcode"

    invoke-virtual {v0}, Landroid/location/Address;->getPostalCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v7, v1, v2}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 336
    const-string v1, "countryCode"

    invoke-virtual {v0}, Landroid/location/Address;->getCountryCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v7, v1, v2}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 339
    invoke-virtual {v0}, Landroid/location/Address;->getMaxAddressLineIndex()I

    move-result v1

    const/4 v2, 0x2

    if-lt v1, v2, :cond_2

    const/4 v1, 0x1

    .line 340
    invoke-virtual {v0, v1}, Landroid/location/Address;->getAddressLine(I)Ljava/lang/String;

    move-result-object v1

    .line 344
    :goto_0
    const-string v2, "addressLine"

    invoke-virtual {v7, v2, v1}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 346
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$3;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v1, p2}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    .line 347
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$3;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    new-instance v2, Lcom/jibo/api/iheart/model/LocationConfig;

    invoke-virtual {v0}, Landroid/location/Address;->getCountryCode()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/jibo/api/iheart/model/LocationConfig$Config;

    .line 348
    invoke-virtual {v0}, Landroid/location/Address;->getCountryCode()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/api/iheart/IHeartApiServiceGenerator;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v4, v0}, Lcom/jibo/api/iheart/model/LocationConfig$Config;-><init>(Ljava/lang/String;)V

    invoke-direct {v2, v3, v4}, Lcom/jibo/api/iheart/model/LocationConfig;-><init>(Ljava/lang/String;Lcom/jibo/api/iheart/model/LocationConfig$Config;)V

    .line 347
    invoke-static {v1, v2}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Lcom/jibo/api/iheart/model/LocationConfig;)Lcom/jibo/api/iheart/model/LocationConfig;

    .line 351
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$3;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 352
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$3;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->d(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)V

    .line 364
    :cond_1
    :goto_1
    return-void

    .line 340
    :cond_2
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "city"

    .line 341
    invoke-virtual {v7, v2}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/gson/JsonElement;->c()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "state"

    .line 342
    invoke-virtual {v7, v2}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/gson/JsonElement;->c()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 343
    invoke-virtual {v0}, Landroid/location/Address;->getPostalCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    goto :goto_0

    .line 354
    :catch_0
    move-exception v0

    .line 355
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$3;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v1, v9}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    .line 356
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$3;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v1, v9}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->a(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Lcom/jibo/api/iheart/model/LocationConfig;)Lcom/jibo/api/iheart/model/LocationConfig;

    .line 357
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$3;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    const-string v2, "error during geocoding"

    invoke-static {v1, v0, v2, v8}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->f(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 359
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$3;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->b(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)V

    goto :goto_1

    .line 362
    :cond_3
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$3;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->b(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)V

    goto :goto_1
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 312
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$3;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    const-string v1, "get robot"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->e(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    move-object v0, p1

    .line 314
    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    invoke-static {v0}, Lcom/jibo/utils/ErrorHelper;->b(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    check-cast p1, Lcom/amazonaws/AmazonServiceException;

    .line 315
    invoke-static {p1}, Lcom/jibo/utils/ErrorHelper;->a(Lcom/amazonaws/AmazonServiceException;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 317
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$3;->a:Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;->b(Lcom/jibo/ui/fragment/account/skills/StationGenresFragment;)V

    .line 319
    :cond_0
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 309
    check-cast p1, Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/account/skills/StationGenresFragment$3;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V

    return-void
.end method

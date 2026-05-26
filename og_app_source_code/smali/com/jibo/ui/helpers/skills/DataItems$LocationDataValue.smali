.class public Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;
.super Lcom/jibo/ui/helpers/skills/DataItems$DataValue;
.source "DataItems.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/DataItems;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LocationDataValue"
.end annotation


# instance fields
.field private city:Ljava/lang/String;

.field private country:Ljava/lang/String;

.field private lat:Ljava/lang/Double;

.field private lng:Ljava/lang/Double;

.field private route:Ljava/lang/String;

.field private state:Ljava/lang/String;

.field private street_number:Ljava/lang/String;

.field private timezone:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 329
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/DataItems$DataValue;-><init>()V

    .line 330
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->lat:Ljava/lang/Double;

    .line 331
    iput-object p2, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->lng:Ljava/lang/Double;

    .line 332
    iput-object p3, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->city:Ljava/lang/String;

    .line 333
    iput-object p4, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->state:Ljava/lang/String;

    .line 334
    iput-object p5, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->country:Ljava/lang/String;

    .line 335
    iput-object p6, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->timezone:Ljava/lang/String;

    .line 336
    iput-object p7, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->route:Ljava/lang/String;

    .line 337
    iput-object p8, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->street_number:Ljava/lang/String;

    .line 338
    return-void
.end method


# virtual methods
.method public getCity()Ljava/lang/String;
    .locals 1

    .prologue
    .line 379
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->city:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->city:Ljava/lang/String;

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getCountry()Ljava/lang/String;
    .locals 1

    .prologue
    .line 387
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->country:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->country:Ljava/lang/String;

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getFriendlyLocation()Ljava/lang/String;
    .locals 3

    .prologue
    .line 341
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 342
    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->route:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 343
    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->street_number:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_4

    .line 344
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->street_number:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->route:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 349
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->city:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 350
    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->city:Ljava/lang/String;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 352
    :cond_1
    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->state:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 353
    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->state:Ljava/lang/String;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 355
    :cond_2
    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->country:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 356
    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->country:Ljava/lang/String;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 358
    :cond_3
    const-string v1, ", "

    invoke-static {v1, v0}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 346
    :cond_4
    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->route:Ljava/lang/String;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public getFriendlyTimezone()Ljava/lang/String;
    .locals 4

    .prologue
    .line 362
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->timezone:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x0

    .line 363
    :goto_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 364
    if-eqz v0, :cond_0

    .line 365
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

    .line 367
    :cond_0
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 362
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->timezone:Ljava/lang/String;

    const-string v1, "\\/"

    const-string v2, "/"

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    goto :goto_0
.end method

.method public getLat()Ljava/lang/Double;
    .locals 1

    .prologue
    .line 371
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->lat:Ljava/lang/Double;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->lat:Ljava/lang/Double;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getLon()Ljava/lang/Double;
    .locals 1

    .prologue
    .line 375
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->lng:Ljava/lang/Double;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->lng:Ljava/lang/Double;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getRoute()Ljava/lang/String;
    .locals 1

    .prologue
    .line 395
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->route:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->route:Ljava/lang/String;

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getState()Ljava/lang/String;
    .locals 1

    .prologue
    .line 383
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->state:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->state:Ljava/lang/String;

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getStreetNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 399
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->street_number:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->street_number:Ljava/lang/String;

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getTimezone()Ljava/lang/String;
    .locals 1

    .prologue
    .line 391
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->timezone:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->timezone:Ljava/lang/String;

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.class public Lcom/jibo/ui/helpers/skills/Items$TimeItem;
.super Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TimeItem"
.end annotation


# direct methods
.method public constructor <init>(Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;)V
    .locals 1

    .prologue
    .line 275
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->skill_time:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1, p2}, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    .line 276
    return-void
.end method

.method private getTimeDataItem()Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;
    .locals 1

    .prologue
    .line 279
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$TimeItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;

    return-object v0
.end method


# virtual methods
.method public getTime()Ljava/lang/String;
    .locals 4

    .prologue
    .line 284
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/Items$TimeItem;->getTimeDataItem()Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 286
    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string v0, "h:mm a"

    invoke-direct {v1, v0}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 287
    const-string v0, "GMT"

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 288
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v2

    .line 289
    const-string v0, "GMT"

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/util/Calendar;->setTimeZone(Ljava/util/TimeZone;)V

    .line 290
    const/16 v3, 0xb

    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/Items$TimeItem;->getTimeDataItem()Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;->getHour()I

    move-result v0

    invoke-virtual {v2, v3, v0}, Ljava/util/Calendar;->set(II)V

    .line 291
    const/16 v3, 0xc

    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/Items$TimeItem;->getTimeDataItem()Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;->getMin()I

    move-result v0

    invoke-virtual {v2, v3, v0}, Ljava/util/Calendar;->set(II)V

    .line 292
    invoke-virtual {v2}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    .line 294
    invoke-virtual {v2}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    .line 297
    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

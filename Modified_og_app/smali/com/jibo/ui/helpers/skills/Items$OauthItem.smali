.class public Lcom/jibo/ui/helpers/skills/Items$OauthItem;
.super Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OauthItem"
.end annotation


# direct methods
.method public constructor <init>(Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;)V
    .locals 1

    .prologue
    .line 323
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->skill_oauth:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1, p2}, Lcom/jibo/ui/helpers/skills/Items$SkillSimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    .line 324
    return-void
.end method

.method private getOauthDataItem()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;
    .locals 1

    .prologue
    .line 327
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/Items$OauthItem;->mDataItem:Lcom/jibo/ui/helpers/skills/DataItems$DataItem;

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    return-object v0
.end method


# virtual methods
.method public getCallbackUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 349
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/Items$OauthItem;->getOauthDataItem()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 350
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/Items$OauthItem;->getOauthDataItem()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->getIosCallbackUri()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getIcon()Ljava/lang/String;
    .locals 1

    .prologue
    .line 337
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/Items$OauthItem;->getOauthDataItem()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 338
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/Items$OauthItem;->getOauthDataItem()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getIcon()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getOauthUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 343
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/Items$OauthItem;->getOauthDataItem()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 344
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/Items$OauthItem;->getOauthDataItem()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->getAuthorizationUri()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 320
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/Items$OauthItem;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 331
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/Items$OauthItem;->getOauthDataItem()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 332
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/Items$OauthItem;->getOauthDataItem()Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataItem;->getTitle()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

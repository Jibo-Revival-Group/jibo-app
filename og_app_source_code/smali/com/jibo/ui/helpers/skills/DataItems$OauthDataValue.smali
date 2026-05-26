.class public Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;
.super Lcom/jibo/ui/helpers/skills/DataItems$DataValue;
.source "DataItems.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/DataItems;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OauthDataValue"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;
    }
.end annotation


# instance fields
.field private value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;)V
    .locals 0

    .prologue
    .line 450
    invoke-direct {p0}, Lcom/jibo/ui/helpers/skills/DataItems$DataValue;-><init>()V

    .line 451
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    .line 452
    return-void
.end method


# virtual methods
.method public getAuthCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 491
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getAuthCode()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getAuthorizationUri()Ljava/lang/String;
    .locals 1

    .prologue
    .line 475
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    invoke-static {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->access$200(Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;)Ljava/lang/String;

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
    .line 459
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    invoke-static {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->access$000(Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getIosCallbackUri()Ljava/lang/String;
    .locals 1

    .prologue
    .line 479
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    invoke-static {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->access$300(Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getIosClientId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 483
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    invoke-static {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->access$400(Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getScopes()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 487
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    invoke-static {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->access$500(Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;)[Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/String;

    goto :goto_0
.end method

.method public getServerClientId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 495
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->getServerClientId()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getServiceAccountName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 471
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    invoke-static {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->access$100(Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getServiceName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 467
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    invoke-static {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->access$100(Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 463
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    invoke-static {v0}, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;->access$100(Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public setValue(Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;)V
    .locals 0

    .prologue
    .line 455
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue;->value:Lcom/jibo/ui/helpers/skills/DataItems$OauthDataValue$OauthValue;

    .line 456
    return-void
.end method

.class public Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;
.super Ljava/lang/Exception;
.source "OAuth2.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/auth/OAuth2;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OAuthFailedException"
.end annotation


# instance fields
.field final a:Lcom/salesforce/androidsdk/auth/OAuth2$TokenErrorResponse;

.field final b:I


# direct methods
.method constructor <init>(Lcom/salesforce/androidsdk/auth/OAuth2$TokenErrorResponse;I)V
    .locals 1

    .prologue
    .line 522
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/auth/OAuth2$TokenErrorResponse;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 523
    iput-object p1, p0, Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;->a:Lcom/salesforce/androidsdk/auth/OAuth2$TokenErrorResponse;

    .line 524
    iput p2, p0, Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;->b:I

    .line 525
    return-void
.end method


# virtual methods
.method public a()Z
    .locals 2

    .prologue
    .line 531
    iget v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;->b:I

    const/16 v1, 0x191

    if-eq v0, v1, :cond_0

    iget v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;->b:I

    const/16 v1, 0x193

    if-eq v0, v1, :cond_0

    iget v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;->b:I

    const/16 v1, 0x190

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public b()Lcom/salesforce/androidsdk/auth/OAuth2$TokenErrorResponse;
    .locals 1

    .prologue
    .line 542
    iget-object v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;->a:Lcom/salesforce/androidsdk/auth/OAuth2$TokenErrorResponse;

    return-object v0
.end method

.method public c()I
    .locals 1

    .prologue
    .line 551
    iget v0, p0, Lcom/salesforce/androidsdk/auth/OAuth2$OAuthFailedException;->b:I

    return v0
.end method

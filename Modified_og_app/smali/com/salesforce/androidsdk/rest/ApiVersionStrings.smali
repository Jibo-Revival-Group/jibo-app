.class public Lcom/salesforce/androidsdk/rest/ApiVersionStrings;
.super Ljava/lang/Object;
.source "ApiVersionStrings.java"


# direct methods
.method public static a(Landroid/content/Context;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    const-string v0, "v39.0"

    .line 67
    if-eqz p0, :cond_0

    .line 68
    sget v0, Lcom/salesforce/androidsdk/R$string;->api_version:I

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 70
    :cond_0
    return-object v0
.end method

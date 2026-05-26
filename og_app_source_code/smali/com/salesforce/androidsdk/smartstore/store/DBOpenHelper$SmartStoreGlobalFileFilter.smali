.class Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreGlobalFileFilter;
.super Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreFileFilter;
.source "DBOpenHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SmartStoreGlobalFileFilter"
.end annotation


# instance fields
.field a:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 462
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreFileFilter;-><init>(Ljava/lang/String;)V

    .line 463
    iput-object p2, p0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreGlobalFileFilter;->a:Ljava/lang/String;

    .line 464
    return-void
.end method


# virtual methods
.method public accept(Ljava/io/File;Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 471
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreGlobalFileFilter;->a()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-super {p0, p1, p2}, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreFileFilter;->accept(Ljava/io/File;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreGlobalFileFilter;->a:Ljava/lang/String;

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

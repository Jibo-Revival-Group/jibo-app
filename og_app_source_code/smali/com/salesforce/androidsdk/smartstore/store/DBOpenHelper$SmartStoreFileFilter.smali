.class Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreFileFilter;
.super Ljava/lang/Object;
.source "DBOpenHelper.java"

# interfaces
.implements Ljava/io/FilenameFilter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SmartStoreFileFilter"
.end annotation


# instance fields
.field private a:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 440
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 441
    iput-object p1, p0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreFileFilter;->a:Ljava/lang/String;

    .line 442
    return-void
.end method


# virtual methods
.method a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 453
    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreFileFilter;->a:Ljava/lang/String;

    return-object v0
.end method

.method public accept(Ljava/io/File;Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 446
    if-eqz p2, :cond_0

    iget-object v0, p0, Lcom/salesforce/androidsdk/smartstore/store/DBOpenHelper$SmartStoreFileFilter;->a:Ljava/lang/String;

    invoke-virtual {p2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 447
    const/4 v0, 0x1

    .line 449
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.class public Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper$SmartSqlException;
.super Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;
.source "SmartSqlHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SmartSqlException"
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 184
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;-><init>(Ljava/lang/String;)V

    .line 185
    return-void
.end method

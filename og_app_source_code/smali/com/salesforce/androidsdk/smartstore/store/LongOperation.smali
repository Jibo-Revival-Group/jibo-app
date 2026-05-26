.class public abstract Lcom/salesforce/androidsdk/smartstore/store/LongOperation;
.super Ljava/lang/Object;
.source "LongOperation.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/smartstore/store/LongOperation$LongOperationType;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract a()V
.end method

.method protected abstract a(Lcom/salesforce/androidsdk/smartstore/store/SmartStore;JLorg/json/JSONObject;Ljava/lang/String;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation
.end method

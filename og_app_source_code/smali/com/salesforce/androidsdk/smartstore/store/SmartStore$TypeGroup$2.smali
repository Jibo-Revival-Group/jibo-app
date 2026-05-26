.class final enum Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup$2;
.super Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;
.source "SmartStore.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4008
    name = null
.end annotation


# direct methods
.method constructor <init>(Ljava/lang/String;I)V
    .locals 1

    .prologue
    .line 1535
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$TypeGroup;-><init>(Ljava/lang/String;ILcom/salesforce/androidsdk/smartstore/store/SmartStore$1;)V

    return-void
.end method


# virtual methods
.method public isMember(Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;)Z
    .locals 1

    .prologue
    .line 1538
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->full_text:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    if-ne p1, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

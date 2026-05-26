.class final Lcom/salesforce/android/knowledge/core/internal/db/DbContract$DbMeta;
.super Ljava/lang/Object;
.source "DbContract.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/internal/db/DbContract;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "DbMeta"
.end annotation


# static fields
.field public static final a:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    .line 197
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    const/4 v1, 0x0

    new-instance v2, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    const-string v3, "InstalledVersion"

    sget-object v4, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;->integer:Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;

    const-string v5, "InstalledVersion"

    invoke-direct {v2, v3, v4, v5}, Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;-><init>(Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/SmartStore$Type;Ljava/lang/String;)V

    aput-object v2, v0, v1

    sput-object v0, Lcom/salesforce/android/knowledge/core/internal/db/DbContract$DbMeta;->a:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    return-void
.end method

.class public Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordModel;
.super Ljava/lang/Object;
.source "CreateCaseRecordModel.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/model/CreateCaseRecord;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordModel$Builder;
    }
.end annotation


# instance fields
.field private record:Ljava/util/Map;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "record"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordModel$Builder;)V
    .locals 2

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    if-nez p1, :cond_0

    .line 42
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "CaseRecordModel.Builder cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 45
    :cond_0
    invoke-static {p1}, Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordModel$Builder;->a(Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordModel$Builder;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordModel;->record:Ljava/util/Map;

    .line 46
    return-void
.end method

.class Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$WriteCaseListFunction$1;
.super Lcom/google/gson/reflect/TypeToken;
.source "SmartStoreRepository.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$WriteCaseListFunction;->a(Lorg/json/JSONArray;)Lcom/salesforce/android/service/common/utilities/control/Async;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/gson/reflect/TypeToken",
        "<",
        "Ljava/util/ArrayList",
        "<",
        "Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$WriteCaseListFunction;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$WriteCaseListFunction;)V
    .locals 0

    .prologue
    .line 605
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$WriteCaseListFunction$1;->a:Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$WriteCaseListFunction;

    invoke-direct {p0}, Lcom/google/gson/reflect/TypeToken;-><init>()V

    return-void
.end method

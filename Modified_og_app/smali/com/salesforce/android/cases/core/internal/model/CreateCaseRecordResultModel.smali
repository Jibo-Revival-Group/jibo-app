.class public Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordResultModel;
.super Ljava/lang/Object;
.source "CreateCaseRecordResultModel.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/model/CreateCaseRecordResult;


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private c:Z

.field private d:Z


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/core/internal/http/response/CreateCaseRecordResponse;)V
    .locals 2

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    if-nez p1, :cond_0

    .line 42
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "CaseRecordResponse cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 45
    :cond_0
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CreateCaseRecordResponse;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordResultModel;->a:Ljava/lang/String;

    .line 46
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CreateCaseRecordResponse;->b()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordResultModel;->b:Ljava/util/List;

    .line 47
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CreateCaseRecordResponse;->c()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordResultModel;->c:Z

    .line 48
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CreateCaseRecordResponse;->d()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordResultModel;->d:Z

    .line 49
    return-void
.end method

.method public static a(Lcom/salesforce/android/cases/core/internal/http/response/CreateCaseRecordResponse;)Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordResultModel;
    .locals 1

    .prologue
    .line 37
    new-instance v0, Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordResultModel;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordResultModel;-><init>(Lcom/salesforce/android/cases/core/internal/http/response/CreateCaseRecordResponse;)V

    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CreateCaseRecordResultModel;->a:Ljava/lang/String;

    return-object v0
.end method

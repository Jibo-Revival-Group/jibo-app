.class public Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;
.super Ljava/lang/Object;
.source "CompleteCaseFeedModel.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/model/CompleteCaseFeed;


# instance fields
.field private a:Ljava/lang/String;

.field private b:Lcom/salesforce/android/cases/core/model/CaseFeed;

.field private c:Lcom/salesforce/android/cases/core/model/CaseDetailRecord;

.field private d:Lcom/salesforce/android/cases/core/model/CaseLayoutData;

.field private e:Lcom/salesforce/android/cases/core/model/DefaultValues;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/cases/core/model/CaseDetailRecord;)Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;
    .locals 0

    .prologue
    .line 72
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->c:Lcom/salesforce/android/cases/core/model/CaseDetailRecord;

    .line 73
    return-object p0
.end method

.method public a(Lcom/salesforce/android/cases/core/model/CaseFeed;)Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;
    .locals 0

    .prologue
    .line 63
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->b:Lcom/salesforce/android/cases/core/model/CaseFeed;

    .line 64
    return-object p0
.end method

.method public a(Lcom/salesforce/android/cases/core/model/CaseLayoutData;)Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;
    .locals 0

    .prologue
    .line 81
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->d:Lcom/salesforce/android/cases/core/model/CaseLayoutData;

    .line 82
    return-object p0
.end method

.method public a(Lcom/salesforce/android/cases/core/model/DefaultValues;)Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;
    .locals 0

    .prologue
    .line 90
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->e:Lcom/salesforce/android/cases/core/model/DefaultValues;

    .line 91
    return-object p0
.end method

.method public a(Ljava/lang/String;)Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->a:Ljava/lang/String;

    .line 55
    return-object p0
.end method

.method public a()Z
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->a:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->b:Lcom/salesforce/android/cases/core/model/CaseFeed;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->c:Lcom/salesforce/android/cases/core/model/CaseDetailRecord;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->d:Lcom/salesforce/android/cases/core/model/CaseLayoutData;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->e:Lcom/salesforce/android/cases/core/model/DefaultValues;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public b()Lcom/salesforce/android/cases/core/model/CompleteCaseFeed;
    .locals 2

    .prologue
    .line 46
    new-instance v0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    invoke-direct {v0}, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;-><init>()V

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->a(Ljava/lang/String;)Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->b:Lcom/salesforce/android/cases/core/model/CaseFeed;

    .line 47
    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->a(Lcom/salesforce/android/cases/core/model/CaseFeed;)Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->c:Lcom/salesforce/android/cases/core/model/CaseDetailRecord;

    .line 48
    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->a(Lcom/salesforce/android/cases/core/model/CaseDetailRecord;)Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->d:Lcom/salesforce/android/cases/core/model/CaseLayoutData;

    .line 49
    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->a(Lcom/salesforce/android/cases/core/model/CaseLayoutData;)Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->e:Lcom/salesforce/android/cases/core/model/DefaultValues;

    .line 50
    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->a(Lcom/salesforce/android/cases/core/model/DefaultValues;)Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    move-result-object v0

    .line 46
    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->a:Ljava/lang/String;

    return-object v0
.end method

.method public d()Lcom/salesforce/android/cases/core/model/CaseFeed;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->b:Lcom/salesforce/android/cases/core/model/CaseFeed;

    return-object v0
.end method

.method public e()Lcom/salesforce/android/cases/core/model/CaseDetailRecord;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->c:Lcom/salesforce/android/cases/core/model/CaseDetailRecord;

    return-object v0
.end method

.method public f()Lcom/salesforce/android/cases/core/model/CaseLayoutData;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->d:Lcom/salesforce/android/cases/core/model/CaseLayoutData;

    return-object v0
.end method

.method public g()Lcom/salesforce/android/cases/core/model/DefaultValues;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->e:Lcom/salesforce/android/cases/core/model/DefaultValues;

    return-object v0
.end method

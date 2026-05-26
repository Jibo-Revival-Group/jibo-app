.class public Lcom/salesforce/android/cases/core/internal/model/ListViewModel;
.super Ljava/lang/Object;
.source "ListViewModel.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/model/ListView;


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse$ListView;)V
    .locals 1

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse$ListView;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/ListViewModel;->a:Ljava/lang/String;

    .line 39
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse$ListView;->b()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/ListViewModel;->b:Ljava/lang/String;

    .line 40
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse$ListView;->c()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/ListViewModel;->c:Ljava/lang/String;

    .line 41
    return-void
.end method

.method public static a(Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse$ListView;)Lcom/salesforce/android/cases/core/internal/model/ListViewModel;
    .locals 1

    .prologue
    .line 44
    new-instance v0, Lcom/salesforce/android/cases/core/internal/model/ListViewModel;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/internal/model/ListViewModel;-><init>(Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse$ListView;)V

    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/ListViewModel;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/ListViewModel;->b:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/ListViewModel;->c:Ljava/lang/String;

    return-object v0
.end method

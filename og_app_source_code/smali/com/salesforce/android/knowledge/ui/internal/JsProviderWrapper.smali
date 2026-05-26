.class public Lcom/salesforce/android/knowledge/ui/internal/JsProviderWrapper;
.super Ljava/lang/Object;
.source "JsProviderWrapper.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;)V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/JsProviderWrapper;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

    .line 43
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;)Lcom/salesforce/android/knowledge/ui/internal/JsProviderWrapper;
    .locals 1

    .prologue
    .line 46
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/JsProviderWrapper;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/ui/internal/JsProviderWrapper;-><init>(Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;)V

    return-object v0
.end method


# virtual methods
.method public a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/JsProviderWrapper;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

    if-eqz v0, :cond_0

    .line 55
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/JsProviderWrapper;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;

    invoke-interface {v0, p1}, Lcom/salesforce/android/knowledge/ui/KnowledgeJsProvider;->a(Lcom/salesforce/android/knowledge/core/model/ArticleSummary;)Ljava/lang/String;

    move-result-object v0

    .line 56
    if-eqz v0, :cond_0

    .line 61
    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

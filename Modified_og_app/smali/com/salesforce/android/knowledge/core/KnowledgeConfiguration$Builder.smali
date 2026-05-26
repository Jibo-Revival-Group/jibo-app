.class public Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration$Builder;
.super Ljava/lang/Object;
.source "KnowledgeConfiguration.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field final a:Ljava/lang/String;

.field b:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

.field c:Ljava/lang/String;

.field d:Ljava/lang/String;

.field e:Lcom/salesforce/androidsdk/accounts/UserAccount;


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 160
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 156
    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-static {v0}, Lcom/salesforce/android/knowledge/core/util/LanguageManager;->a(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration$Builder;->c:Ljava/lang/String;

    .line 161
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration$Builder;->a:Ljava/lang/String;

    .line 162
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/knowledge/core/util/LanguageManager;->b(Ljava/util/Locale;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/knowledge/core/util/LanguageManager;->a(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration$Builder;->d:Ljava/lang/String;

    .line 163
    return-void

    .line 162
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration$Builder;->c:Ljava/lang/String;

    goto :goto_0
.end method


# virtual methods
.method public a()Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;
    .locals 1

    .prologue
    .line 253
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration$Builder;->b:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

    if-nez v0, :cond_0

    .line 254
    invoke-static {}, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;->a()Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration$Builder;->b:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

    .line 256
    :cond_0
    new-instance v0, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;-><init>(Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration$Builder;)V

    return-object v0
.end method

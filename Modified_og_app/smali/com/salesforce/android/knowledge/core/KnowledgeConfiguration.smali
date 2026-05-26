.class public Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;
.super Ljava/lang/Object;
.source "KnowledgeConfiguration.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration$Builder;
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

.field private final c:Ljava/lang/String;

.field private final d:Ljava/lang/String;

.field private final e:Lcom/salesforce/androidsdk/accounts/UserAccount;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration$Builder;)V
    .locals 1

    .prologue
    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 80
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration$Builder;->a:Ljava/lang/String;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;->a:Ljava/lang/String;

    .line 81
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration$Builder;->b:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;->b:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

    .line 82
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration$Builder;->c:Ljava/lang/String;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;->c:Ljava/lang/String;

    .line 83
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration$Builder;->d:Ljava/lang/String;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;->d:Ljava/lang/String;

    .line 84
    iget-object v0, p1, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration$Builder;->e:Lcom/salesforce/androidsdk/accounts/UserAccount;

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;->e:Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 85
    return-void
.end method

.method public static a(Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;
    .locals 1

    .prologue
    .line 63
    invoke-static {p0}, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;->b(Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration$Builder;->a()Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;

    move-result-object v0

    return-object v0
.end method

.method public static b(Ljava/lang/String;)Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration$Builder;
    .locals 1

    .prologue
    .line 76
    new-instance v0, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration$Builder;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration$Builder;-><init>(Ljava/lang/String;)V

    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;->b:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceConfig;

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;->c:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;->d:Ljava/lang/String;

    return-object v0
.end method

.method public e()Lcom/salesforce/androidsdk/accounts/UserAccount;
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/KnowledgeConfiguration;->e:Lcom/salesforce/androidsdk/accounts/UserAccount;

    return-object v0
.end method

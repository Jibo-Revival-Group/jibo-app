.class Lcom/salesforce/android/knowledge/core/KnowledgeCore$1;
.super Ljava/lang/Object;
.source "KnowledgeCore.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Function;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/core/KnowledgeCore;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/control/Async;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/functional/Function",
        "<",
        "Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;",
        "Lcom/salesforce/android/knowledge/core/KnowledgeClient;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/core/KnowledgeClient;

.field final synthetic b:Lcom/salesforce/android/knowledge/core/KnowledgeCore;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/core/KnowledgeCore;Lcom/salesforce/android/knowledge/core/KnowledgeClient;)V
    .locals 0

    .prologue
    .line 98
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/KnowledgeCore$1;->b:Lcom/salesforce/android/knowledge/core/KnowledgeCore;

    iput-object p2, p0, Lcom/salesforce/android/knowledge/core/KnowledgeCore$1;->a:Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;)Lcom/salesforce/android/knowledge/core/KnowledgeClient;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/KnowledgeCore$1;->a:Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    return-object v0
.end method

.method public bridge synthetic a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 98
    check-cast p1, Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/core/KnowledgeCore$1;->a(Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCache;)Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    move-result-object v0

    return-object v0
.end method

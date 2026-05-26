.class Lcom/salesforce/android/knowledge/ui/KnowledgeUI$1;
.super Ljava/lang/Object;
.source "KnowledgeUI.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Function;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/ui/KnowledgeUI;->a(Landroid/content/Context;)Lcom/salesforce/android/service/common/utilities/control/Async;
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
        "Lcom/salesforce/android/knowledge/core/KnowledgeClient;",
        "Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/ui/KnowledgeUI;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/KnowledgeUI;)V
    .locals 0

    .prologue
    .line 125
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUI$1;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeUI;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/knowledge/core/KnowledgeClient;)Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUI$1;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeUI;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUI;->a(Lcom/salesforce/android/knowledge/core/KnowledgeClient;)Lcom/salesforce/android/knowledge/ui/internal/client/KnowledgeUIClientImpl;

    move-result-object v0

    .line 128
    invoke-interface {p1, v0}, Lcom/salesforce/android/knowledge/core/KnowledgeClient;->a(Lcom/salesforce/android/knowledge/core/LogoutListener;)V

    .line 129
    return-object v0
.end method

.method public bridge synthetic a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 125
    check-cast p1, Lcom/salesforce/android/knowledge/core/KnowledgeClient;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/ui/KnowledgeUI$1;->a(Lcom/salesforce/android/knowledge/core/KnowledgeClient;)Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;

    move-result-object v0

    return-object v0
.end method

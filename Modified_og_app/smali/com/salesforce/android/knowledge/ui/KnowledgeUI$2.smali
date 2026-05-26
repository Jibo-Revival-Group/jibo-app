.class Lcom/salesforce/android/knowledge/ui/KnowledgeUI$2;
.super Ljava/lang/Object;
.source "KnowledgeUI.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;


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
        "Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler",
        "<",
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
    .line 134
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/KnowledgeUI$2;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeUI;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;",
            "Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;",
            ")V"
        }
    .end annotation

    .prologue
    .line 136
    invoke-static {}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;->b()V

    .line 137
    return-void
.end method

.method public bridge synthetic a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 134
    check-cast p2, Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/KnowledgeUI$2;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;)V

    return-void
.end method

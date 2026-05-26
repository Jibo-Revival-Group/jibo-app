.class final Lcom/jibo/JiboSupport$4;
.super Ljava/lang/Object;
.source "JiboSupport.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/JiboSupport;->a(Landroid/app/Activity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
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
.field final synthetic a:Landroid/app/Activity;


# direct methods
.method constructor <init>(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 121
    iput-object p1, p0, Lcom/jibo/JiboSupport$4;->a:Landroid/app/Activity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;)V
    .locals 1
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
    .line 127
    invoke-static {p2}, Lcom/jibo/JiboSupport;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;)Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;

    .line 130
    new-instance v0, Lcom/jibo/JiboSupport$4$1;

    invoke-direct {v0, p0}, Lcom/jibo/JiboSupport$4$1;-><init>(Lcom/jibo/JiboSupport$4;)V

    invoke-interface {p2, v0}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient$OnCloseListener;)V

    .line 140
    iget-object v0, p0, Lcom/jibo/JiboSupport$4;->a:Landroid/app/Activity;

    invoke-interface {p2, v0}, Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;->b(Landroid/app/Activity;)V

    .line 141
    return-void
.end method

.method public bridge synthetic a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 121
    check-cast p2, Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/JiboSupport$4;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Lcom/salesforce/android/knowledge/ui/KnowledgeUIClient;)V

    return-void
.end method

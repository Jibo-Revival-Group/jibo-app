.class Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;
.super Ljava/lang/Object;
.source "ViewAdditionController.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/internal/navigation/Navigator$Listener;


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;

.field private b:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/activity/ActivityReference",
            "<",
            "Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;",
            ">;"
        }
    .end annotation
.end field

.field private c:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private d:Landroid/animation/Animator;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;)V
    .locals 2

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->a()Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->b:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    .line 45
    new-instance v0, Ljava/lang/ref/WeakReference;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->c:Ljava/lang/ref/WeakReference;

    .line 53
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;

    .line 54
    return-void
.end method

.method private a(Landroid/animation/Animator;)V
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->d:Landroid/animation/Animator;

    if-eqz v0, :cond_0

    .line 111
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->d:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->cancel()V

    .line 113
    :cond_0
    if-eqz p1, :cond_1

    .line 114
    invoke-virtual {p1}, Landroid/animation/Animator;->start()V

    .line 116
    :cond_1
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->d:Landroid/animation/Animator;

    .line 117
    return-void
.end method

.method private c(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)V
    .locals 2

    .prologue
    .line 96
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->c:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    .line 98
    if-nez v0, :cond_1

    .line 107
    :cond_0
    :goto_0
    return-void

    .line 102
    :cond_1
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;

    invoke-interface {v1, p2}, Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)Z

    move-result v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;

    invoke-interface {v1, p1}, Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 103
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;

    invoke-interface {v1, v0}, Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;->a(Landroid/view/View;)Landroid/animation/Animator;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->a(Landroid/animation/Animator;)V

    goto :goto_0

    .line 104
    :cond_2
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;

    invoke-interface {v1, p2}, Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;

    invoke-interface {v1, p1}, Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 105
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;

    invoke-interface {v1, v0}, Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;->b(Landroid/view/View;)Landroid/animation/Animator;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->a(Landroid/animation/Animator;)V

    goto :goto_0
.end method


# virtual methods
.method public a(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)V
    .locals 0

    .prologue
    .line 83
    invoke-direct {p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->c(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)V

    .line 84
    return-void
.end method

.method a(Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)V
    .locals 3

    .prologue
    .line 62
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->b:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->a(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 75
    :goto_0
    return-void

    .line 66
    :cond_0
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 67
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;

    invoke-interface {v1, v0, p1}, Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;->a(Landroid/view/ViewGroup;Landroid/content/Context;)Landroid/view/View;

    move-result-object v0

    .line 69
    const-string v1, "View addition cannot be null"

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 71
    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;

    invoke-interface {v2, p2}, Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;->a(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)Z

    move-result v2

    invoke-interface {v1, v0, v2}, Lcom/salesforce/android/knowledge/ui/KnowledgeViewAddition;->a(Landroid/view/View;Z)V

    .line 72
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/activity/KnowledgeActivity;->addContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 73
    new-instance v1, Ljava/lang/ref/WeakReference;

    invoke-direct {v1, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->c:Ljava/lang/ref/WeakReference;

    .line 74
    invoke-static {p1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->a(Landroid/app/Activity;)Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->b:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    goto :goto_0
.end method

.method public b(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)V
    .locals 0

    .prologue
    .line 88
    invoke-direct {p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/client/ViewAdditionController;->c(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)V

    .line 89
    return-void
.end method

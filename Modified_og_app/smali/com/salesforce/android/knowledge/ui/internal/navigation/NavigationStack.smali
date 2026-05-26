.class Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;
.super Ljava/util/concurrent/LinkedBlockingDeque;
.source "NavigationStack.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/concurrent/LinkedBlockingDeque",
        "<",
        "Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/util/concurrent/LinkedBlockingDeque;-><init>()V

    return-void
.end method


# virtual methods
.method a()Lcom/salesforce/android/knowledge/ui/KnowledgeScene;
    .locals 1

    .prologue
    .line 60
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_NONE:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;->peek()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;->b()Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    move-result-object v0

    goto :goto_0
.end method

.method a(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)V
    .locals 3

    .prologue
    .line 46
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;->descendingIterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 47
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;

    .line 48
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;->b()Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    move-result-object v2

    if-ne v2, p1, :cond_0

    .line 49
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;->a()Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;->c()V

    .line 50
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    .line 54
    :cond_1
    return-void
.end method

.method public a(Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;)V
    .locals 1

    .prologue
    .line 79
    invoke-super {p0, p1}, Ljava/util/concurrent/LinkedBlockingDeque;->push(Ljava/lang/Object;)V

    .line 80
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;->a()Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;->b()V

    .line 81
    return-void
.end method

.method b()Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;
    .locals 2

    .prologue
    .line 67
    invoke-super {p0}, Ljava/util/concurrent/LinkedBlockingDeque;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 68
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 69
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 70
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 71
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;

    .line 75
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public c()Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;
    .locals 2

    .prologue
    .line 87
    invoke-super {p0}, Ljava/util/concurrent/LinkedBlockingDeque;->pop()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;

    .line 88
    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;->a()Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;

    move-result-object v1

    invoke-interface {v1}, Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;->c()V

    .line 89
    return-object v0
.end method

.method public synthetic pop()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 40
    invoke-virtual {p0}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;->c()Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;

    move-result-object v0

    return-object v0
.end method

.method public synthetic push(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 40
    check-cast p1, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;->a(Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;)V

    return-void
.end method

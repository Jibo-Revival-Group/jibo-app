.class public Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;
.super Ljava/lang/Object;
.source "PresenterManager.java"


# instance fields
.field private a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/ui/internal/features/shared/provider/PresenterProvider;",
            ">;"
        }
    .end annotation
.end field

.field private b:Landroid/support/v4/util/SparseArrayCompat;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/SparseArrayCompat",
            "<",
            "Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/ui/internal/features/shared/provider/PresenterProvider;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    invoke-static {p1}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;->a:Ljava/util/List;

    .line 44
    new-instance v0, Landroid/support/v4/util/SparseArrayCompat;

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v1

    invoke-direct {v0, v1}, Landroid/support/v4/util/SparseArrayCompat;-><init>(I)V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;->b:Landroid/support/v4/util/SparseArrayCompat;

    .line 45
    return-void
.end method

.method public static varargs a([Lcom/salesforce/android/cases/ui/internal/features/shared/provider/PresenterProvider;)Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;
    .locals 2

    .prologue
    .line 54
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;

    invoke-static {p0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;-><init>(Ljava/util/List;)V

    return-object v0
.end method

.method private b(Ljava/lang/Class;)Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;",
            ">;)",
            "Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;"
        }
    .end annotation

    .prologue
    .line 115
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;->b:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/util/SparseArrayCompat;->a(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/salesforce/android/cases/ui/CaseUIClient;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<P:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/salesforce/android/cases/ui/CaseUIClient;",
            "Ljava/lang/Class",
            "<+",
            "Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;",
            ">;)TP;"
        }
    .end annotation

    .prologue
    .line 70
    invoke-direct {p0, p2}, Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;->b(Ljava/lang/Class;)Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;

    move-result-object v1

    .line 73
    if-nez v1, :cond_2

    .line 76
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/shared/provider/PresenterProvider;

    .line 77
    invoke-interface {v0, p2}, Lcom/salesforce/android/cases/ui/internal/features/shared/provider/PresenterProvider;->a(Ljava/lang/Class;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 78
    invoke-interface {v0, p1}, Lcom/salesforce/android/cases/ui/internal/features/shared/provider/PresenterProvider;->b(Lcom/salesforce/android/cases/ui/CaseUIClient;)Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;

    move-result-object v0

    .line 79
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;->b:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {p2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    invoke-virtual {v1, v2, v0}, Landroid/support/v4/util/SparseArrayCompat;->b(ILjava/lang/Object;)V

    .line 86
    :goto_0
    if-nez v0, :cond_1

    .line 87
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Could not create a presenter for the class "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 88
    invoke-virtual {p2}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 92
    :cond_1
    return-object v0

    :cond_2
    move-object v0, v1

    goto :goto_0
.end method

.method public a(Ljava/lang/Class;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 103
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;->b:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/support/v4/util/SparseArrayCompat;->a(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;

    .line 106
    if-eqz v0, :cond_0

    .line 107
    invoke-interface {v0}, Lcom/salesforce/android/cases/ui/internal/features/shared/BasePresenter;->e()V

    .line 111
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/shared/manager/PresenterManager;->b:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/support/v4/util/SparseArrayCompat;->c(I)V

    .line 112
    return-void
.end method

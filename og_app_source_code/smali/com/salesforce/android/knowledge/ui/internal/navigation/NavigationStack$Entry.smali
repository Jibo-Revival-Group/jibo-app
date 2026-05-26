.class Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;
.super Ljava/lang/Object;
.source "NavigationStack.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Entry"
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

.field private final b:Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter",
            "<*>;"
        }
    .end annotation
.end field

.field private final c:Landroid/os/Bundle;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/ui/KnowledgeScene;",
            "Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 103
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 101
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;->c:Landroid/os/Bundle;

    .line 104
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    .line 105
    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;->b:Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;

    .line 106
    return-void
.end method


# virtual methods
.method a()Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 109
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;->b:Lcom/salesforce/android/knowledge/ui/internal/presenter/Presenter;

    return-object v0
.end method

.method b()Lcom/salesforce/android/knowledge/ui/KnowledgeScene;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;->a:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    return-object v0
.end method

.method c()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/navigation/NavigationStack$Entry;->c:Landroid/os/Bundle;

    return-object v0
.end method

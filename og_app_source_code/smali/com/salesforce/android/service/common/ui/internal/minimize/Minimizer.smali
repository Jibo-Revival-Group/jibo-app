.class public Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;
.super Ljava/lang/Object;
.source "Minimizer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;
    }
.end annotation


# static fields
.field static final a:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Class",
            "<+",
            "Landroid/app/Activity;",
            ">;>;"
        }
    .end annotation
.end field


# instance fields
.field private b:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;

.field private final c:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 49
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;->a:Ljava/util/Set;

    return-void
.end method

.method constructor <init>(Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;)V
    .locals 1

    .prologue
    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 84
    iget-object v0, p1, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;->a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;->c:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;

    .line 85
    iget-object v0, p1, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;->b:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;->b:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;

    .line 86
    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 120
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;->b:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;

    if-eqz v0, :cond_0

    .line 121
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;->b:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;

    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;->b(Landroid/content/Context;)V

    .line 123
    :cond_0
    return-void
.end method

.method public a()Z
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;->c:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->a()Z

    move-result v0

    return v0
.end method

.method public b()V
    .locals 1

    .prologue
    .line 113
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;->a()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;->b:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;

    if-eqz v0, :cond_0

    .line 114
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;->c:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->a(Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;)V

    .line 115
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;->b:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;->c()V

    .line 117
    :cond_0
    return-void
.end method

.method public c()V
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;->c:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->b()V

    .line 127
    return-void
.end method

.method public d()V
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;->c:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->c()V

    .line 131
    return-void
.end method

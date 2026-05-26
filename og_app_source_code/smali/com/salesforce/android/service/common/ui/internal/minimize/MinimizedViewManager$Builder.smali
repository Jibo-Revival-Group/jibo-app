.class Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;
.super Ljava/lang/Object;
.source "MinimizedViewManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Builder"
.end annotation


# instance fields
.field a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;

.field b:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

.field c:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Factory;

.field d:Ljava/util/Set;
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


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 291
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 294
    new-instance v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Factory;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Factory;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;->c:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Factory;

    .line 295
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;->d:Ljava/util/Set;

    return-void
.end method


# virtual methods
.method a(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;)Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;
    .locals 0

    .prologue
    .line 303
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;->a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;

    .line 304
    return-object p0
.end method

.method a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;)Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;
    .locals 0

    .prologue
    .line 298
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;->b:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    .line 299
    return-object p0
.end method

.method a(Ljava/util/Set;)Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Class",
            "<+",
            "Landroid/app/Activity;",
            ">;>;)",
            "Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;"
        }
    .end annotation

    .prologue
    .line 313
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;->d:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 314
    return-object p0
.end method

.method a()Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;
    .locals 2

    .prologue
    .line 318
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;->b:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    const-string v1, "ActivityTracker must be provided to the MinimizedViewManager"

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 320
    new-instance v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;-><init>(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;)V

    return-object v0
.end method

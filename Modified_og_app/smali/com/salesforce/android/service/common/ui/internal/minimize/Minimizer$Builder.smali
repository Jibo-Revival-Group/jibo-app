.class public Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;
.super Ljava/lang/Object;
.source "Minimizer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;

.field b:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;

.field c:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

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
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 137
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 141
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;->d:Ljava/util/Set;

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;)Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;
    .locals 0

    .prologue
    .line 154
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;->b:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;

    .line 155
    return-object p0
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;)Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;
    .locals 0

    .prologue
    .line 149
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;->c:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    .line 150
    return-object p0
.end method

.method public a()Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;
    .locals 2

    .prologue
    .line 165
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;->c:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    const-string v1, "Activity tracker must be provided to the Minimizer"

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 167
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;->a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;

    if-nez v0, :cond_0

    .line 168
    new-instance v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;-><init>()V

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;->c:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    .line 169
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;->a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;)Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;->b:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;

    .line 170
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;->a(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;)Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;->d:Ljava/util/Set;

    .line 171
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;->a(Ljava/util/Set;)Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;

    move-result-object v0

    .line 172
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;->a()Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;->a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;

    .line 175
    :cond_0
    new-instance v0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;-><init>(Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer$Builder;)V

    return-object v0
.end method

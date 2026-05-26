.class Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;
.super Ljava/lang/Object;
.source "MinimizedViewManager.java"

# interfaces
.implements Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Listener;
.implements Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnPauseListener;
.implements Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnResumeListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;
    }
.end annotation


# instance fields
.field a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;

.field final b:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

.field final c:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Factory;

.field final d:Ljava/util/Set;
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

.field e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

.field f:Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;

.field g:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

.field h:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/activity/ActivityReference",
            "<",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;)V
    .locals 1

    .prologue
    .line 73
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 67
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->a()Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->h:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    .line 74
    iget-object v0, p1, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;->b:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->b:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    .line 75
    iget-object v0, p1, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;->a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;

    .line 76
    iget-object v0, p1, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;->c:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Factory;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->c:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Factory;

    .line 77
    iget-object v0, p1, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$Builder;->d:Ljava/util/Set;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->d:Ljava/util/Set;

    .line 78
    return-void
.end method

.method static a(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;)Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;
    .locals 6

    .prologue
    const/4 v4, 0x0

    .line 263
    invoke-virtual {p1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->c()Landroid/view/ViewGroup;

    move-result-object v2

    .line 264
    invoke-virtual {p1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->d()Landroid/view/ViewGroup;

    move-result-object v3

    .line 266
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a()I

    move-result v0

    invoke-static {v0, v4}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 267
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->b()I

    move-result v1

    invoke-static {v1, v4}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 269
    invoke-virtual {v3}, Landroid/view/View;->getWidth()I

    move-result v4

    add-int/2addr v4, v0

    .line 270
    invoke-virtual {v2}, Landroid/view/ViewGroup;->getWidth()I

    move-result v5

    if-le v4, v5, :cond_0

    .line 271
    invoke-virtual {v2}, Landroid/view/ViewGroup;->getWidth()I

    move-result v0

    invoke-virtual {v3}, Landroid/view/View;->getWidth()I

    move-result v4

    sub-int/2addr v0, v4

    .line 274
    :cond_0
    invoke-virtual {v3}, Landroid/view/View;->getHeight()I

    move-result v4

    add-int/2addr v4, v1

    .line 275
    invoke-virtual {v2}, Landroid/view/ViewGroup;->getHeight()I

    move-result v5

    if-le v4, v5, :cond_1

    .line 276
    invoke-virtual {v2}, Landroid/view/ViewGroup;->getHeight()I

    move-result v1

    invoke-virtual {v3}, Landroid/view/View;->getHeight()I

    move-result v2

    sub-int/2addr v1, v2

    .line 279
    :cond_1
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a()I

    move-result v2

    if-ne v0, v2, :cond_2

    invoke-virtual {p0}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->b()I

    move-result v2

    if-ne v1, v2, :cond_2

    .line 283
    :goto_0
    return-object p0

    :cond_2
    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a(II)Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    move-result-object p0

    goto :goto_0
.end method

.method private a(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;)V
    .locals 1

    .prologue
    .line 243
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    if-eqz v0, :cond_0

    .line 244
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->b()V

    .line 247
    :cond_0
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    .line 248
    return-void
.end method

.method private d()V
    .locals 1

    .prologue
    .line 251
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->b:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->b(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnResumeListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    .line 252
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->b:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->b(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnPauseListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    .line 253
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->h:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->clear()V

    .line 254
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->f:Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;

    .line 255
    return-void
.end method


# virtual methods
.method a(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 111
    invoke-static {p1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->a(Landroid/app/Activity;)Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->h:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    .line 112
    return-void
.end method

.method public a(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 156
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;

    if-nez v0, :cond_0

    .line 170
    :goto_0
    return-void

    .line 161
    :cond_0
    check-cast p1, Landroid/view/ViewGroup;

    .line 162
    invoke-virtual {p1}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 164
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->h:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    new-instance v1, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$1;

    invoke-direct {v1, p0, p1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$1;-><init>(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;Landroid/view/ViewGroup;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->a(Lcom/salesforce/android/service/common/utilities/functional/Consumer;)V

    goto :goto_0
.end method

.method a(Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;)V
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->b:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnResumeListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    .line 90
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->b:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->a(Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker$OnPauseListener;)Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    .line 91
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->f:Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;

    .line 92
    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)V
    .locals 2

    .prologue
    .line 216
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    if-eqz v0, :cond_1

    .line 218
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    invoke-static {p1, v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->a(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;)Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->g:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    .line 221
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->g:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 222
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->g:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->b(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)V

    .line 225
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;

    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;->a(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)V

    .line 227
    :cond_1
    return-void
.end method

.method a()Z
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->h:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method b()V
    .locals 1

    .prologue
    .line 119
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->a(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;)V

    .line 120
    invoke-direct {p0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->d()V

    .line 121
    return-void
.end method

.method public b(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 132
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->a(Landroid/app/Activity;)V

    .line 135
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->d:Ljava/util/Set;

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;->a:Ljava/util/Set;

    .line 136
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 137
    invoke-virtual {p0, p1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->d(Landroid/app/Activity;)V

    .line 139
    :cond_0
    return-void
.end method

.method public b(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 174
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->f:Lcom/salesforce/android/service/common/ui/internal/minimize/Minimizer;

    if-nez v0, :cond_0

    .line 187
    :goto_0
    return-void

    .line 181
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->h:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    new-instance v1, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$2;

    invoke-direct {v1, p0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager$2;-><init>(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->a(Lcom/salesforce/android/service/common/utilities/functional/Consumer;)V

    goto :goto_0
.end method

.method c()V
    .locals 0

    .prologue
    .line 124
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->b()V

    .line 125
    return-void
.end method

.method public c(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 142
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->h:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->a(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    if-eqz v0, :cond_0

    .line 143
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->b()V

    .line 144
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    .line 147
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->h:Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityReference;->b(Ljava/lang/Object;)V

    .line 148
    return-void
.end method

.method public c(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 191
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;

    if-eqz v0, :cond_0

    .line 192
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->a:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeListener;->d()V

    .line 194
    :cond_0
    return-void
.end method

.method d(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 237
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->c:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Factory;

    invoke-virtual {v0, p1, p0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Factory;->a(Landroid/app/Activity;Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Listener;)Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    move-result-object v0

    .line 238
    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->g:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    invoke-virtual {v0, p1, v1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->a(Landroid/app/Activity;Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)V

    .line 239
    invoke-direct {p0, v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->a(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;)V

    .line 240
    return-void
.end method

.method public d(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 198
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->g:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    if-eqz v0, :cond_0

    .line 202
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->g:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->a(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;)Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    move-result-object v0

    .line 205
    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->g:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 206
    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->g:Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;

    .line 207
    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    if-eqz v1, :cond_0

    .line 208
    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewManager;->e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->a(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)V

    .line 212
    :cond_0
    return-void
.end method

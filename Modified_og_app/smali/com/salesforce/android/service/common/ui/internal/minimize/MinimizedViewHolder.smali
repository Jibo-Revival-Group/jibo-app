.class Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;
.super Ljava/lang/Object;
.source "MinimizedViewHolder.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Listener;,
        Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Factory;,
        Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;
    }
.end annotation


# static fields
.field private static final f:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field final a:Landroid/view/ViewGroup;

.field final b:Landroid/view/ViewGroup;

.field final c:Landroid/view/View;

.field final d:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Listener;

.field final e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 51
    const-class v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->f:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method constructor <init>(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;)V
    .locals 1

    .prologue
    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    iget-object v0, p1, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->a:Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->a:Landroid/view/ViewGroup;

    .line 69
    iget-object v0, p1, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->b:Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->b:Landroid/view/ViewGroup;

    .line 70
    iget-object v0, p1, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->d:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Listener;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->d:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Listener;

    .line 71
    iget-object v0, p1, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;

    .line 72
    iget-object v0, p1, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->c:Landroid/view/View;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->c:Landroid/view/View;

    .line 74
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->a()V

    .line 75
    return-void
.end method


# virtual methods
.method a()V
    .locals 2

    .prologue
    .line 83
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->b:Landroid/view/ViewGroup;

    new-instance v1, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$1;

    invoke-direct {v1, p0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$1;-><init>(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->addOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V

    .line 101
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->b:Landroid/view/ViewGroup;

    new-instance v1, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$2;

    invoke-direct {v1, p0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$2;-><init>(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 107
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->a:Landroid/view/ViewGroup;

    sget v1, Lcom/salesforce/android/service/common/ui/R$id;->common_minview_close:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 108
    new-instance v1, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$3;

    invoke-direct {v1, p0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$3;-><init>(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 113
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->d:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Listener;

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->c:Landroid/view/View;

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Listener;->a(Landroid/view/View;)V

    .line 114
    return-void
.end method

.method a(Landroid/app/Activity;Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 117
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->b()V

    .line 118
    const v0, 0x1020002

    invoke-virtual {p1, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 119
    if-eqz v0, :cond_1

    .line 120
    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->a:Landroid/view/ViewGroup;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 127
    :goto_0
    if-eqz p2, :cond_0

    .line 128
    sget-object v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->f:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Setting minimized location to {} {}"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {p2}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-virtual {p2}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->b()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 130
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->b:Landroid/view/ViewGroup;

    invoke-virtual {p2}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setX(F)V

    .line 131
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->b:Landroid/view/ViewGroup;

    invoke-virtual {p2}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->b()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setY(F)V

    .line 133
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->b:Landroid/view/ViewGroup;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout$LayoutParams;

    .line 134
    iput v4, v0, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 136
    :cond_0
    return-void

    .line 123
    :cond_1
    sget-object v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->f:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Couldn\'t find android.R.id.content in {}. Are you calling Activity.setContentView and AppCompatDelegate.setContentView?"

    new-array v2, v5, [Ljava/lang/Object;

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 124
    invoke-virtual {p1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->a:Landroid/view/ViewGroup;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    goto :goto_0
.end method

.method a(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)V
    .locals 5

    .prologue
    .line 176
    sget-object v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->f:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v1, "Setting minimized location to {} {}"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->b()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-interface {v0, v1, v2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 177
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->b:Landroid/view/ViewGroup;

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setX(F)V

    .line 178
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->b:Landroid/view/ViewGroup;

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->b()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setY(F)V

    .line 179
    return-void
.end method

.method b()V
    .locals 2

    .prologue
    .line 142
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->a:Landroid/view/ViewGroup;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 143
    if-eqz v0, :cond_0

    .line 144
    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->a:Landroid/view/ViewGroup;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 146
    :cond_0
    return-void
.end method

.method b(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)V
    .locals 4

    .prologue
    .line 187
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->b:Landroid/view/ViewGroup;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->a()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->x(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;->b()I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->y(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v2, 0xfa

    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 188
    return-void
.end method

.method c()Landroid/view/ViewGroup;
    .locals 1

    .prologue
    .line 191
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->a:Landroid/view/ViewGroup;

    return-object v0
.end method

.method d()Landroid/view/ViewGroup;
    .locals 1

    .prologue
    .line 195
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;->b:Landroid/view/ViewGroup;

    return-object v0
.end method

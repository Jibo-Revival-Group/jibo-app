.class Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;
.super Ljava/lang/Object;
.source "MinimizedViewHolder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Builder"
.end annotation


# instance fields
.field a:Landroid/view/ViewGroup;

.field b:Landroid/view/ViewGroup;

.field c:Landroid/view/View;

.field d:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Listener;

.field e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 206
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method a(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Listener;)Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;
    .locals 0

    .prologue
    .line 230
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->d:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Listener;

    .line 231
    return-object p0
.end method

.method a(Landroid/app/Activity;)Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 240
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->a:Landroid/view/ViewGroup;

    if-nez v0, :cond_0

    .line 241
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    sget v2, Lcom/salesforce/android/service/common/ui/R$layout;->minimized_container:I

    invoke-virtual {p1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-virtual {v1, v2, v0, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->a:Landroid/view/ViewGroup;

    .line 242
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->a:Landroid/view/ViewGroup;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout$LayoutParams;

    .line 243
    iput v3, v0, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 246
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->b:Landroid/view/ViewGroup;

    if-nez v0, :cond_1

    .line 247
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->a:Landroid/view/ViewGroup;

    sget v1, Lcom/salesforce/android/service/common/ui/R$id;->salesforce_minview_thumbnail:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->b:Landroid/view/ViewGroup;

    .line 250
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->c:Landroid/view/View;

    if-nez v0, :cond_2

    .line 251
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->b:Landroid/view/ViewGroup;

    sget v1, Lcom/salesforce/android/service/common/ui/R$id;->common_minview_content:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->c:Landroid/view/View;

    .line 254
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;

    if-nez v0, :cond_3

    .line 255
    new-instance v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;-><init>()V

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->a:Landroid/view/ViewGroup;

    .line 256
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;->a(Landroid/view/View;)Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->b:Landroid/view/ViewGroup;

    .line 257
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;->b(Landroid/view/View;)Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->d:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Listener;

    .line 258
    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;->a(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Listener;)Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;

    move-result-object v0

    .line 259
    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag$Builder;->a()Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;->e:Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizeViewDrag;

    .line 262
    :cond_3
    new-instance v0, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;

    invoke-direct {v0, p0}, Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder;-><init>(Lcom/salesforce/android/service/common/ui/internal/minimize/MinimizedViewHolder$Builder;)V

    return-object v0
.end method

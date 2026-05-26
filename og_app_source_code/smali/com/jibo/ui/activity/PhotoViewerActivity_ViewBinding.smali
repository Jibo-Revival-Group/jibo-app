.class public Lcom/jibo/ui/activity/PhotoViewerActivity_ViewBinding;
.super Ljava/lang/Object;
.source "PhotoViewerActivity_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/activity/PhotoViewerActivity;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/activity/PhotoViewerActivity;)V
    .locals 1

    .prologue
    .line 22
    invoke-virtual {p1}, Lcom/jibo/ui/activity/PhotoViewerActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/jibo/ui/activity/PhotoViewerActivity_ViewBinding;-><init>(Lcom/jibo/ui/activity/PhotoViewerActivity;Landroid/view/View;)V

    .line 23
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/activity/PhotoViewerActivity;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    iput-object p1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity_ViewBinding;->b:Lcom/jibo/ui/activity/PhotoViewerActivity;

    .line 29
    const v0, 0x7f0902fe

    const-string v1, "field \'toolbar\'"

    const-class v2, Landroid/support/v7/widget/Toolbar;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/Toolbar;

    iput-object v0, p1, Lcom/jibo/ui/activity/PhotoViewerActivity;->toolbar:Landroid/support/v7/widget/Toolbar;

    .line 30
    const v0, 0x7f0901fe

    const-string v1, "field \'pager\'"

    const-class v2, Landroid/support/v4/view/ViewPager;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/view/ViewPager;

    iput-object v0, p1, Lcom/jibo/ui/activity/PhotoViewerActivity;->pager:Landroid/support/v4/view/ViewPager;

    .line 31
    const v0, 0x7f090139

    const-string v1, "field \'footer\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/activity/PhotoViewerActivity;->footer:Landroid/view/View;

    .line 32
    const v0, 0x1020014

    const-string v1, "field \'photoDateText\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/activity/PhotoViewerActivity;->photoDateText:Landroid/widget/TextView;

    .line 33
    const v0, 0x7f090304

    const-string v1, "field \'transitionImage\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/activity/PhotoViewerActivity;->transitionImage:Landroid/widget/ImageView;

    .line 34
    const v0, 0x7f090327

    const-string v1, "field \'viewNetworkDown\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/activity/PhotoViewerActivity;->viewNetworkDown:Landroid/view/View;

    .line 35
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 40
    iget-object v0, p0, Lcom/jibo/ui/activity/PhotoViewerActivity_ViewBinding;->b:Lcom/jibo/ui/activity/PhotoViewerActivity;

    .line 41
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 42
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/activity/PhotoViewerActivity_ViewBinding;->b:Lcom/jibo/ui/activity/PhotoViewerActivity;

    .line 44
    iput-object v1, v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->toolbar:Landroid/support/v7/widget/Toolbar;

    .line 45
    iput-object v1, v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->pager:Landroid/support/v4/view/ViewPager;

    .line 46
    iput-object v1, v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->footer:Landroid/view/View;

    .line 47
    iput-object v1, v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->photoDateText:Landroid/widget/TextView;

    .line 48
    iput-object v1, v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->transitionImage:Landroid/widget/ImageView;

    .line 49
    iput-object v1, v0, Lcom/jibo/ui/activity/PhotoViewerActivity;->viewNetworkDown:Landroid/view/View;

    .line 50
    return-void
.end method

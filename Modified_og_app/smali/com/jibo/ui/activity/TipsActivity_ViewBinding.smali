.class public Lcom/jibo/ui/activity/TipsActivity_ViewBinding;
.super Lcom/jibo/ui/activity/BaseActivity_ViewBinding;
.source "TipsActivity_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/activity/TipsActivity;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/activity/TipsActivity;)V
    .locals 1

    .prologue
    .line 21
    invoke-virtual {p1}, Lcom/jibo/ui/activity/TipsActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/jibo/ui/activity/TipsActivity_ViewBinding;-><init>(Lcom/jibo/ui/activity/TipsActivity;Landroid/view/View;)V

    .line 22
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/activity/TipsActivity;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 26
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/activity/BaseActivity_ViewBinding;-><init>(Lcom/jibo/ui/activity/BaseActivity;Landroid/view/View;)V

    .line 28
    iput-object p1, p0, Lcom/jibo/ui/activity/TipsActivity_ViewBinding;->b:Lcom/jibo/ui/activity/TipsActivity;

    .line 30
    const v0, 0x7f0900d0

    const-string v1, "field \'collapsingToolbar\'"

    const-class v2, Landroid/support/design/widget/CollapsingToolbarLayout;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/CollapsingToolbarLayout;

    iput-object v0, p1, Lcom/jibo/ui/activity/TipsActivity;->collapsingToolbar:Landroid/support/design/widget/CollapsingToolbarLayout;

    .line 31
    const v0, 0x7f090042

    const-string v1, "field \'appBarLayout\'"

    const-class v2, Landroid/support/design/widget/AppBarLayout;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/AppBarLayout;

    iput-object v0, p1, Lcom/jibo/ui/activity/TipsActivity;->appBarLayout:Landroid/support/design/widget/AppBarLayout;

    .line 32
    const v0, 0x7f0902f4

    const-string v1, "field \'toolbarContainer\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/activity/TipsActivity;->toolbarContainer:Landroid/view/View;

    .line 33
    const v0, 0x7f0902fe

    const-string v1, "field \'toolbar\'"

    const-class v2, Landroid/support/v7/widget/Toolbar;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/Toolbar;

    iput-object v0, p1, Lcom/jibo/ui/activity/TipsActivity;->toolbar:Landroid/support/v7/widget/Toolbar;

    .line 34
    const v0, 0x7f090154

    const-string v1, "field \'image\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/activity/TipsActivity;->image:Landroid/widget/ImageView;

    .line 35
    const v0, 0x1020014

    const-string v1, "field \'text\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/activity/TipsActivity;->text:Landroid/widget/TextView;

    .line 36
    const v0, 0x1020016

    const-string v1, "field \'title\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/activity/TipsActivity;->title:Landroid/widget/TextView;

    .line 37
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 41
    iget-object v0, p0, Lcom/jibo/ui/activity/TipsActivity_ViewBinding;->b:Lcom/jibo/ui/activity/TipsActivity;

    .line 42
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 43
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/activity/TipsActivity_ViewBinding;->b:Lcom/jibo/ui/activity/TipsActivity;

    .line 45
    iput-object v1, v0, Lcom/jibo/ui/activity/TipsActivity;->collapsingToolbar:Landroid/support/design/widget/CollapsingToolbarLayout;

    .line 46
    iput-object v1, v0, Lcom/jibo/ui/activity/TipsActivity;->appBarLayout:Landroid/support/design/widget/AppBarLayout;

    .line 47
    iput-object v1, v0, Lcom/jibo/ui/activity/TipsActivity;->toolbarContainer:Landroid/view/View;

    .line 48
    iput-object v1, v0, Lcom/jibo/ui/activity/TipsActivity;->toolbar:Landroid/support/v7/widget/Toolbar;

    .line 49
    iput-object v1, v0, Lcom/jibo/ui/activity/TipsActivity;->image:Landroid/widget/ImageView;

    .line 50
    iput-object v1, v0, Lcom/jibo/ui/activity/TipsActivity;->text:Landroid/widget/TextView;

    .line 51
    iput-object v1, v0, Lcom/jibo/ui/activity/TipsActivity;->title:Landroid/widget/TextView;

    .line 53
    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity_ViewBinding;->unbind()V

    .line 54
    return-void
.end method

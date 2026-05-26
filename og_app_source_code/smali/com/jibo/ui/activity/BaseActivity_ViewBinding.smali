.class public Lcom/jibo/ui/activity/BaseActivity_ViewBinding;
.super Ljava/lang/Object;
.source "BaseActivity_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/activity/BaseActivity;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/activity/BaseActivity;)V
    .locals 1

    .prologue
    .line 19
    invoke-virtual {p1}, Lcom/jibo/ui/activity/BaseActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/jibo/ui/activity/BaseActivity_ViewBinding;-><init>(Lcom/jibo/ui/activity/BaseActivity;Landroid/view/View;)V

    .line 20
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/activity/BaseActivity;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    iput-object p1, p0, Lcom/jibo/ui/activity/BaseActivity_ViewBinding;->b:Lcom/jibo/ui/activity/BaseActivity;

    .line 26
    const v0, 0x7f090225

    const-string v1, "field \'mProgressBar\'"

    const-class v2, Landroid/widget/ProgressBar;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p1, Lcom/jibo/ui/activity/BaseActivity;->mProgressBar:Landroid/widget/ProgressBar;

    .line 27
    const v0, 0x7f090112

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/activity/BaseActivity;->mDimmer:Landroid/view/View;

    .line 28
    const v0, 0x7f090327

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/activity/BaseActivity;->viewNetworkDown:Landroid/view/View;

    .line 29
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 34
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity_ViewBinding;->b:Lcom/jibo/ui/activity/BaseActivity;

    .line 35
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 36
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/activity/BaseActivity_ViewBinding;->b:Lcom/jibo/ui/activity/BaseActivity;

    .line 38
    iput-object v1, v0, Lcom/jibo/ui/activity/BaseActivity;->mProgressBar:Landroid/widget/ProgressBar;

    .line 39
    iput-object v1, v0, Lcom/jibo/ui/activity/BaseActivity;->mDimmer:Landroid/view/View;

    .line 40
    iput-object v1, v0, Lcom/jibo/ui/activity/BaseActivity;->viewNetworkDown:Landroid/view/View;

    .line 41
    return-void
.end method

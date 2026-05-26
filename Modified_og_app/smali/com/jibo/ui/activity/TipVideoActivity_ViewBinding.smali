.class public final Lcom/jibo/ui/activity/TipVideoActivity_ViewBinding;
.super Lcom/jibo/ui/activity/BaseActivity_ViewBinding;
.source "TipVideoActivity_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/activity/TipVideoActivity;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/activity/TipVideoActivity;)V
    .locals 1

    .prologue
    .line 18
    invoke-virtual {p1}, Lcom/jibo/ui/activity/TipVideoActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/jibo/ui/activity/TipVideoActivity_ViewBinding;-><init>(Lcom/jibo/ui/activity/TipVideoActivity;Landroid/view/View;)V

    .line 19
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/activity/TipVideoActivity;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 23
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/activity/BaseActivity_ViewBinding;-><init>(Lcom/jibo/ui/activity/BaseActivity;Landroid/view/View;)V

    .line 25
    iput-object p1, p0, Lcom/jibo/ui/activity/TipVideoActivity_ViewBinding;->b:Lcom/jibo/ui/activity/TipVideoActivity;

    .line 27
    const v0, 0x7f090333

    const-string v1, "field \'wvWistia\'"

    const-class v2, Landroid/webkit/WebView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebView;

    iput-object v0, p1, Lcom/jibo/ui/activity/TipVideoActivity;->wvWistia:Landroid/webkit/WebView;

    .line 28
    const v0, 0x102000d

    const-string v1, "field \'pbLoader\'"

    const-class v2, Landroid/widget/ProgressBar;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p1, Lcom/jibo/ui/activity/TipVideoActivity;->pbLoader:Landroid/widget/ProgressBar;

    .line 29
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 33
    iget-object v0, p0, Lcom/jibo/ui/activity/TipVideoActivity_ViewBinding;->b:Lcom/jibo/ui/activity/TipVideoActivity;

    .line 34
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 35
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/activity/TipVideoActivity_ViewBinding;->b:Lcom/jibo/ui/activity/TipVideoActivity;

    .line 37
    iput-object v1, v0, Lcom/jibo/ui/activity/TipVideoActivity;->wvWistia:Landroid/webkit/WebView;

    .line 38
    iput-object v1, v0, Lcom/jibo/ui/activity/TipVideoActivity;->pbLoader:Landroid/widget/ProgressBar;

    .line 40
    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity_ViewBinding;->unbind()V

    .line 41
    return-void
.end method

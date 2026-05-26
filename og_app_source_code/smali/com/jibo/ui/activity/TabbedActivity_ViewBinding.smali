.class public Lcom/jibo/ui/activity/TabbedActivity_ViewBinding;
.super Lcom/jibo/ui/activity/BaseActivity_ViewBinding;
.source "TabbedActivity_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/activity/TabbedActivity;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/activity/TabbedActivity;)V
    .locals 1

    .prologue
    .line 18
    invoke-virtual {p1}, Lcom/jibo/ui/activity/TabbedActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/jibo/ui/activity/TabbedActivity_ViewBinding;-><init>(Lcom/jibo/ui/activity/TabbedActivity;Landroid/view/View;)V

    .line 19
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/activity/TabbedActivity;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 23
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/activity/BaseActivity_ViewBinding;-><init>(Lcom/jibo/ui/activity/BaseActivity;Landroid/view/View;)V

    .line 25
    iput-object p1, p0, Lcom/jibo/ui/activity/TabbedActivity_ViewBinding;->b:Lcom/jibo/ui/activity/TabbedActivity;

    .line 27
    const v0, 0x7f09016d

    const-string v1, "field \'jiboListContainer\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/activity/TabbedActivity;->jiboListContainer:Landroid/view/View;

    .line 28
    const v0, 0x7f09016c

    const-string v1, "field \'jiboList\'"

    const-class v2, Landroid/support/v7/widget/RecyclerView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/RecyclerView;

    iput-object v0, p1, Lcom/jibo/ui/activity/TabbedActivity;->jiboList:Landroid/support/v7/widget/RecyclerView;

    .line 29
    const v0, 0x1020013

    const-string v1, "field \'tabs\'"

    const-class v2, Landroid/widget/LinearLayout;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p1, Lcom/jibo/ui/activity/TabbedActivity;->tabs:Landroid/widget/LinearLayout;

    .line 30
    const v0, 0x7f090271

    const-string v1, "field \'mSelectorDimmer\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/activity/TabbedActivity;->mSelectorDimmer:Landroid/view/View;

    .line 31
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 35
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity_ViewBinding;->b:Lcom/jibo/ui/activity/TabbedActivity;

    .line 36
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 37
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/activity/TabbedActivity_ViewBinding;->b:Lcom/jibo/ui/activity/TabbedActivity;

    .line 39
    iput-object v1, v0, Lcom/jibo/ui/activity/TabbedActivity;->jiboListContainer:Landroid/view/View;

    .line 40
    iput-object v1, v0, Lcom/jibo/ui/activity/TabbedActivity;->jiboList:Landroid/support/v7/widget/RecyclerView;

    .line 41
    iput-object v1, v0, Lcom/jibo/ui/activity/TabbedActivity;->tabs:Landroid/widget/LinearLayout;

    .line 42
    iput-object v1, v0, Lcom/jibo/ui/activity/TabbedActivity;->mSelectorDimmer:Landroid/view/View;

    .line 44
    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity_ViewBinding;->unbind()V

    .line 45
    return-void
.end method

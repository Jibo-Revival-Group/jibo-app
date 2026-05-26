.class Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$3;
.super Ljava/lang/Object;
.source "NameBirthdayGenderFragment.java"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

.field private b:I


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;)V
    .locals 0

    .prologue
    .line 152
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$3;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGlobalLayout()V
    .locals 3

    .prologue
    .line 158
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$3;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$3;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 159
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$3;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    move-result v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$3;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getHeight()I

    move-result v1

    sub-int/2addr v0, v1

    .line 160
    iget v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$3;->b:I

    if-eq v1, v0, :cond_0

    .line 161
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$3;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v1, v1, Landroid/util/DisplayMetrics;->heightPixels:I

    div-int/lit8 v1, v1, 0x2

    if-le v0, v1, :cond_2

    .line 162
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$3;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->formNavigationPanel:Landroid/view/View;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 167
    :cond_0
    :goto_0
    iput v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$3;->b:I

    .line 169
    :cond_1
    return-void

    .line 164
    :cond_2
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$3;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->formNavigationPanel:Landroid/view/View;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

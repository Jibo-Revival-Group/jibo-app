.class public Lcom/jibo/ui/fragment/account/AccountDeletedFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "AccountDeletedFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field closeButton:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const-class v0, Lcom/jibo/ui/fragment/account/AccountDeletedFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/account/AccountDeletedFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    return-void
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 0

    .prologue
    .line 50
    return-void
.end method

.method public h()Z
    .locals 1

    .prologue
    .line 59
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeletedFragment;->onCloseButtonClick()V

    .line 60
    const/4 v0, 0x1

    return v0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    const-string v0, ""

    return-object v0
.end method

.method public onCloseButtonClick()V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 65
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeletedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    sget v1, Lcom/jibo/ui/activity/TabbedActivity;->c:I

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 66
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeletedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 67
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 30
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeletedFragment;->k()V

    .line 31
    const v0, 0x7f0b005d

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 36
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 38
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeletedFragment;->closeButton:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeletedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f080282

    const v3, 0x7f06007b

    invoke-static {v1, v2, v3}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;II)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 42
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeletedFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountDeletedFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    sget-object v1, Lcom/jibo/JiboAnalytics;->ak:Ljava/lang/String;

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 43
    :goto_0
    sget-object v1, Lcom/jibo/JiboAnalytics;->aG:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    sget-object v1, Lcom/jibo/JiboAnalytics;->aF:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 46
    :cond_0
    return-void

    .line 42
    :cond_1
    const-string v0, ""

    goto :goto_0
.end method

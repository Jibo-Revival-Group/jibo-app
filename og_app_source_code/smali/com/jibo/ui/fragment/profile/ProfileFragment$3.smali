.class Lcom/jibo/ui/fragment/profile/ProfileFragment$3;
.super Ljava/lang/Object;
.source "ProfileFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/profile/ProfileFragment;->b(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/widget/PopupWindow;

.field final synthetic b:Lcom/jibo/ui/fragment/profile/ProfileFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/profile/ProfileFragment;Landroid/widget/PopupWindow;)V
    .locals 0

    .prologue
    .line 356
    iput-object p1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$3;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$3;->a:Landroid/widget/PopupWindow;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 359
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$3;->a:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    .line 361
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$3;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    .line 362
    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 363
    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$3;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->a(Lcom/jibo/ui/fragment/profile/ProfileFragment;)Ljava/util/ArrayList;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 364
    const-string v1, "ARG_LOOPS"

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$3;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->a(Lcom/jibo/ui/fragment/profile/ProfileFragment;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Ljava/io/Serializable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 366
    :cond_0
    const/16 v1, 0x3e9

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 367
    return-void
.end method

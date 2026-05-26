.class Lcom/jibo/ui/fragment/profile/ProfileFragment$4;
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
    .line 372
    iput-object p1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$4;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$4;->a:Landroid/widget/PopupWindow;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 375
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$4;->a:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    .line 376
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$4;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$4;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->b(Lcom/jibo/ui/fragment/profile/ProfileFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$4;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->c(Lcom/jibo/ui/fragment/profile/ProfileFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/jibo/ui/fragment/invite/PreferredNameFragment;->a(Lcom/jibo/ui/fragment/BaseFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    .line 377
    return-void
.end method

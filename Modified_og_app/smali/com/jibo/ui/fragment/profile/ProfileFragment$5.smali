.class Lcom/jibo/ui/fragment/profile/ProfileFragment$5;
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
    .line 382
    iput-object p1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$5;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$5;->a:Landroid/widget/PopupWindow;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 385
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$5;->a:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    .line 386
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$5;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->d(Lcom/jibo/ui/fragment/profile/ProfileFragment;)V

    .line 387
    return-void
.end method

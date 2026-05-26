.class Lcom/jibo/ui/fragment/profile/ProfileFragment$1$1;
.super Ljava/lang/Object;
.source "ProfileFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/profile/ProfileFragment$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/view/MenuItem;

.field final synthetic b:Lcom/jibo/ui/fragment/profile/ProfileFragment$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/profile/ProfileFragment$1;Landroid/view/MenuItem;)V
    .locals 0

    .prologue
    .line 244
    iput-object p1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$1$1;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment$1;

    iput-object p2, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$1$1;->a:Landroid/view/MenuItem;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 247
    iget-object v0, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$1$1;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/profile/ProfileFragment$1;->b:Lcom/jibo/ui/fragment/profile/ProfileFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/profile/ProfileFragment$1$1;->a:Landroid/view/MenuItem;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/profile/ProfileFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    .line 248
    return-void
.end method

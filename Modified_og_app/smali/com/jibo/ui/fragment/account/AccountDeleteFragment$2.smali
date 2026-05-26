.class Lcom/jibo/ui/fragment/account/AccountDeleteFragment$2;
.super Ljava/lang/Object;
.source "AccountDeleteFragment.java"

# interfaces
.implements Landroid/widget/RadioGroup$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->a()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/account/AccountDeleteFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/account/AccountDeleteFragment;)V
    .locals 0

    .prologue
    .line 145
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountDeleteFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/RadioGroup;I)V
    .locals 2

    .prologue
    .line 148
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountDeleteFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->invalidateOptionsMenu()V

    .line 149
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment$2;->a:Lcom/jibo/ui/fragment/account/AccountDeleteFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;->btnDelete:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 150
    return-void
.end method

.class Lcom/jibo/ui/fragment/phone/PhoneFillFragment$2;
.super Ljava/lang/Object;
.source "PhoneFillFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->onPrepareOptionsMenu(Landroid/view/Menu;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/phone/PhoneFillFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/phone/PhoneFillFragment;)V
    .locals 0

    .prologue
    .line 96
    iput-object p1, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment$2;->a:Lcom/jibo/ui/fragment/phone/PhoneFillFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 8

    .prologue
    .line 99
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment$2;->a:Lcom/jibo/ui/fragment/phone/PhoneFillFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment$2;->a:Lcom/jibo/ui/fragment/phone/PhoneFillFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const/16 v2, 0x68

    iget-object v3, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment$2;->a:Lcom/jibo/ui/fragment/phone/PhoneFillFragment;

    const v4, 0x7f10010a

    .line 101
    invoke-virtual {v3, v4}, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment$2;->a:Lcom/jibo/ui/fragment/phone/PhoneFillFragment;

    const v5, 0x7f100100

    .line 102
    invoke-virtual {v4, v5}, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment$2;->a:Lcom/jibo/ui/fragment/phone/PhoneFillFragment;

    const v6, 0x7f10002d

    .line 103
    invoke-virtual {v5, v6}, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment$2;->a:Lcom/jibo/ui/fragment/phone/PhoneFillFragment;

    const v7, 0x7f10004b

    .line 104
    invoke-virtual {v6, v7}, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 99
    invoke-static/range {v0 .. v6}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 105
    return-void
.end method

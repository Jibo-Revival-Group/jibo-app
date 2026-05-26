.class Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$2;
.super Ljava/lang/Object;
.source "PhoneConfirmFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->onPrepareOptionsMenu(Landroid/view/Menu;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;)V
    .locals 0

    .prologue
    .line 113
    iput-object p1, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$2;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 8

    .prologue
    const v6, 0x7f10002d

    .line 117
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$2;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->c:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-virtual {v0}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$2;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    invoke-virtual {v1, v6}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 118
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$2;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$2;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const/16 v2, 0x68

    iget-object v3, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$2;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    const v4, 0x7f10010a

    .line 120
    invoke-virtual {v3, v4}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$2;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    const v5, 0x7f100100

    .line 121
    invoke-virtual {v4, v5}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$2;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    .line 122
    invoke-virtual {v5, v6}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$2;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    const v7, 0x7f10004b

    .line 123
    invoke-virtual {v6, v7}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 118
    invoke-static/range {v0 .. v6}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 129
    :goto_0
    return-void

    .line 126
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$2;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->a(Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;)V

    goto :goto_0
.end method

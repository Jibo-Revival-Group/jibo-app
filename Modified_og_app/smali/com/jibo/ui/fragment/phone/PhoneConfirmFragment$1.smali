.class Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$1;
.super Ljava/lang/Object;
.source "PhoneConfirmFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
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
    .line 70
    iput-object p1, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$1;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$1;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->a()V

    .line 84
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 74
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 79
    return-void
.end method

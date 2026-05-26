.class Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$1;
.super Ljava/lang/Object;
.source "PhoneConfirmFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->onError(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/Exception;

.field final synthetic b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 142
    iput-object p1, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$1;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;

    iput-object p2, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$1;->a:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    const/16 v4, 0x8

    const/4 v3, 0x0

    .line 145
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$1;->a:Ljava/lang/Exception;

    check-cast v0, Lcom/amazonaws/AmazonServiceException;

    .line 146
    const-string v1, "TOKEN_NOT_FOUND"

    invoke-virtual {v0}, Lcom/amazonaws/AmazonServiceException;->getErrorCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 147
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$1;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->footer_error:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 148
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$1;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->footer1:Landroid/widget/TextView;

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 149
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$1;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->footer_error:Landroid/widget/TextView;

    const v1, 0x7f100131

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 158
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$1;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$1;->a:Ljava/lang/Exception;

    const-string v2, "verify phone by code"

    invoke-static {v0, v1, v2, v3}, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->a(Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 159
    return-void

    .line 150
    :cond_0
    const-string v1, "PHONE_TOKEN_EXPIRED"

    invoke-virtual {v0}, Lcom/amazonaws/AmazonServiceException;->getErrorCode()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 151
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$1;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->footer_error:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 152
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$1;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->footer1:Landroid/widget/TextView;

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 153
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$1;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->footer_error:Landroid/widget/TextView;

    const v1, 0x7f100130

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    goto :goto_0

    .line 155
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$1;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->footer_error:Landroid/widget/TextView;

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 156
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3$1;->b:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment$3;->a:Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/phone/PhoneConfirmFragment;->footer1:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

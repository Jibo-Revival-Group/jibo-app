.class Lcom/jibo/ui/fragment/phone/PhoneFillFragment$1;
.super Landroid/telephony/PhoneNumberFormattingTextWatcher;
.source "PhoneFillFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
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
    .line 59
    iput-object p1, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment$1;->a:Lcom/jibo/ui/fragment/phone/PhoneFillFragment;

    invoke-direct {p0}, Landroid/telephony/PhoneNumberFormattingTextWatcher;-><init>()V

    return-void
.end method


# virtual methods
.method public declared-synchronized afterTextChanged(Landroid/text/Editable;)V
    .locals 1

    .prologue
    .line 63
    monitor-enter p0

    :try_start_0
    invoke-super {p0, p1}, Landroid/telephony/PhoneNumberFormattingTextWatcher;->afterTextChanged(Landroid/text/Editable;)V

    .line 64
    iget-object v0, p0, Lcom/jibo/ui/fragment/phone/PhoneFillFragment$1;->a:Lcom/jibo/ui/fragment/phone/PhoneFillFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/phone/PhoneFillFragment;->a()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 65
    monitor-exit p0

    return-void

    .line 63
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

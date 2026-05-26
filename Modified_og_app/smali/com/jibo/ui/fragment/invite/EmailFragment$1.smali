.class Lcom/jibo/ui/fragment/invite/EmailFragment$1;
.super Ljava/lang/Object;
.source "EmailFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/EmailFragment;->a()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/EmailFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/EmailFragment;)V
    .locals 0

    .prologue
    .line 136
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/EmailFragment$1;->a:Lcom/jibo/ui/fragment/invite/EmailFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0

    .prologue
    .line 150
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 140
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/EmailFragment$1;->a:Lcom/jibo/ui/fragment/invite/EmailFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/EmailFragment;->a(Lcom/jibo/ui/fragment/invite/EmailFragment;)V

    .line 145
    return-void
.end method

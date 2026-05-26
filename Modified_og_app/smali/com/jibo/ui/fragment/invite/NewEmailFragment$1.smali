.class Lcom/jibo/ui/fragment/invite/NewEmailFragment$1;
.super Ljava/lang/Object;
.source "NewEmailFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/invite/NewEmailFragment;->a()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/NewEmailFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/NewEmailFragment;)V
    .locals 0

    .prologue
    .line 130
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment$1;->a:Lcom/jibo/ui/fragment/invite/NewEmailFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0

    .prologue
    .line 144
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 134
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NewEmailFragment$1;->a:Lcom/jibo/ui/fragment/invite/NewEmailFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/NewEmailFragment;->a(Lcom/jibo/ui/fragment/invite/NewEmailFragment;)V

    .line 139
    return-void
.end method

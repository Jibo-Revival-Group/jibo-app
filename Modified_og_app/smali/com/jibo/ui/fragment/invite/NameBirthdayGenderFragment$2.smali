.class Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$2;
.super Ljava/lang/Object;
.source "NameBirthdayGenderFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;)V
    .locals 0

    .prologue
    .line 109
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$2;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 122
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$2;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->b(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;)V

    .line 123
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$2;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->a(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;)V

    .line 124
    invoke-interface {p1}, Landroid/text/Editable;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 125
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$2;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->genderTitle:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$2;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    const v2, 0x7f10040c

    new-array v3, v6, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$2;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    iget-object v4, v4, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->firstName:Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v4}, Landroid/widget/AutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-virtual {v1, v2, v3}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 126
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$2;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->birthdayTitle:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$2;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    const v2, 0x7f10040a

    new-array v3, v6, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$2;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    iget-object v4, v4, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->firstName:Landroid/widget/AutoCompleteTextView;

    invoke-virtual {v4}, Landroid/widget/AutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-virtual {v1, v2, v3}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 131
    :goto_0
    return-void

    .line 128
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$2;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->genderTitle:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$2;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    const v2, 0x7f1001d7

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 129
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$2;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->birthdayTitle:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$2;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    const v2, 0x7f1002f8

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 113
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 118
    return-void
.end method

.class public Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;
.super Ljava/lang/Object;
.source "CaseTextInputViewModel.java"

# interfaces
.implements Landroid/text/TextWatcher;
.implements Landroid/view/View$OnFocusChangeListener;
.implements Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/text/TextWatcher;",
        "Landroid/view/View$OnFocusChangeListener;",
        "Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel",
        "<",
        "Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;

.field private b:Landroid/widget/EditText;

.field private c:Lcom/salesforce/android/cases/core/model/CaseField;

.field private d:Ljava/lang/String;

.field private e:Z


# direct methods
.method public constructor <init>(Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;Lcom/salesforce/android/cases/core/model/CaseField;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    const-string v0, ""

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->d:Ljava/lang/String;

    .line 59
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseField;->f()Lcom/salesforce/android/cases/core/model/CaseFieldType;

    move-result-object v0

    .line 60
    sget-object v1, Lcom/salesforce/android/cases/core/model/CaseFieldType;->TEXT:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    if-eq v0, v1, :cond_0

    sget-object v1, Lcom/salesforce/android/cases/core/model/CaseFieldType;->EMAIL:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    if-eq v0, v1, :cond_0

    sget-object v1, Lcom/salesforce/android/cases/core/model/CaseFieldType;->TEXT_AREA:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    if-eq v0, v1, :cond_0

    .line 63
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "CaseField must be of type CaseFieldType.TEXT, CaseFieldType.EMAIL or CaseFieldType.TEXT_AREA."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 67
    :cond_0
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;

    .line 68
    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->c:Lcom/salesforce/android/cases/core/model/CaseField;

    .line 71
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseField;->b()Ljava/lang/String;

    move-result-object v0

    .line 72
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseField;->d()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 73
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "*"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 75
    :cond_1
    invoke-virtual {p1, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;->setHint(Ljava/lang/CharSequence;)V

    .line 78
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseField;->g()I

    move-result v0

    invoke-virtual {p1, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;->setCounterMaxLength(I)V

    .line 80
    invoke-virtual {p1}, Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;->getEditText()Landroid/widget/EditText;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->b:Landroid/widget/EditText;

    .line 84
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->b:Landroid/widget/EditText;

    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseField;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setId(I)V

    .line 87
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseField;->h()Ljava/lang/String;

    move-result-object v0

    .line 88
    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/util/StringUtils;->b(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 89
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->b:Landroid/widget/EditText;

    invoke-virtual {v1, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 90
    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->d:Ljava/lang/String;

    .line 94
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->b:Landroid/widget/EditText;

    invoke-virtual {v0, p0}, Landroid/widget/EditText;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 95
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->b:Landroid/widget/EditText;

    invoke-virtual {v0, p0}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 98
    sget-object v0, Lcom/salesforce/android/cases/core/model/CaseFieldType;->EMAIL:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseField;->f()Lcom/salesforce/android/cases/core/model/CaseFieldType;

    move-result-object v1

    if-ne v0, v1, :cond_3

    .line 99
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->b:Landroid/widget/EditText;

    const/16 v1, 0xd1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setInputType(I)V

    .line 101
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->b:Landroid/widget/EditText;

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setMaxLines(I)V

    .line 110
    :goto_0
    return-void

    .line 102
    :cond_3
    sget-object v0, Lcom/salesforce/android/cases/core/model/CaseFieldType;->TEXT_AREA:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseField;->f()Lcom/salesforce/android/cases/core/model/CaseFieldType;

    move-result-object v1

    if-ne v0, v1, :cond_4

    .line 103
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->b:Landroid/widget/EditText;

    const v1, 0x24001

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setInputType(I)V

    goto :goto_0

    .line 107
    :cond_4
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->b:Landroid/widget/EditText;

    const/16 v1, 0x4001

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setInputType(I)V

    .line 108
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->b:Landroid/widget/EditText;

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setMaxLines(I)V

    goto :goto_0
.end method


# virtual methods
.method public synthetic a()Landroid/view/View;
    .locals 1

    .prologue
    .line 45
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->h()Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;

    move-result-object v0

    return-object v0
.end method

.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 2

    .prologue
    .line 183
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;->getError()Ljava/lang/CharSequence;

    move-result-object v0

    .line 186
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/util/StringUtils;->a(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 187
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;->setError(Ljava/lang/CharSequence;)V

    .line 188
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;->setErrorEnabled(Z)V

    .line 191
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->d:Ljava/lang/String;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 192
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->e:Z

    .line 195
    :cond_1
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->d:Ljava/lang/String;

    .line 196
    return-void
.end method

.method public b()Z
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->b:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->isFocused()Z

    move-result v0

    return v0
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 177
    return-void
.end method

.method public c()V
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->b:Landroid/widget/EditText;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->d(Landroid/view/View;)V

    .line 122
    return-void
.end method

.method public d()Lcom/salesforce/android/cases/core/model/CaseField;
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->c:Lcom/salesforce/android/cases/core/model/CaseField;

    return-object v0
.end method

.method public e()Z
    .locals 6

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 129
    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->c:Lcom/salesforce/android/cases/core/model/CaseField;

    invoke-interface {v2}, Lcom/salesforce/android/cases/core/model/CaseField;->d()Z

    move-result v2

    .line 130
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->f()Ljava/lang/String;

    move-result-object v3

    .line 131
    iget-object v4, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->b:Landroid/widget/EditText;

    invoke-virtual {v4}, Landroid/widget/EditText;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    .line 134
    invoke-static {v3}, Lcom/salesforce/android/cases/core/internal/util/StringUtils;->a(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 137
    if-eqz v2, :cond_2

    .line 138
    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;

    sget v3, Lcom/salesforce/android/cases/R$string;->cases_validation_error_field_required_text:I

    new-array v1, v1, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->c:Lcom/salesforce/android/cases/core/model/CaseField;

    .line 140
    invoke-interface {v5}, Lcom/salesforce/android/cases/core/model/CaseField;->b()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v1, v0

    .line 139
    invoke-virtual {v4, v3, v1}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 138
    invoke-virtual {v2, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;->setError(Ljava/lang/CharSequence;)V

    .line 155
    :goto_0
    return v0

    .line 143
    :cond_0
    sget-object v2, Lcom/salesforce/android/cases/core/model/CaseFieldType;->EMAIL:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    iget-object v5, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->c:Lcom/salesforce/android/cases/core/model/CaseField;

    invoke-interface {v5}, Lcom/salesforce/android/cases/core/model/CaseField;->f()Lcom/salesforce/android/cases/core/model/CaseFieldType;

    move-result-object v5

    if-ne v2, v5, :cond_1

    sget-object v2, Landroid/util/Patterns;->EMAIL_ADDRESS:Ljava/util/regex/Pattern;

    invoke-virtual {v2, v3}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v2

    .line 144
    invoke-virtual {v2}, Ljava/util/regex/Matcher;->matches()Z

    move-result v2

    if-nez v2, :cond_1

    .line 145
    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;

    sget v3, Lcom/salesforce/android/cases/R$string;->cases_validation_error_invalid_field_text:I

    new-array v1, v1, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->c:Lcom/salesforce/android/cases/core/model/CaseField;

    .line 147
    invoke-interface {v5}, Lcom/salesforce/android/cases/core/model/CaseField;->b()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v1, v0

    .line 146
    invoke-virtual {v4, v3, v1}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 145
    invoke-virtual {v2, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;->setError(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 149
    :cond_1
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v2

    iget-object v3, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->c:Lcom/salesforce/android/cases/core/model/CaseField;

    invoke-interface {v3}, Lcom/salesforce/android/cases/core/model/CaseField;->g()I

    move-result v3

    if-le v2, v3, :cond_2

    .line 150
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;

    sget v2, Lcom/salesforce/android/cases/R$string;->cases_validation_error_length_invalid_text:I

    .line 151
    invoke-virtual {v4, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 150
    invoke-virtual {v1, v2}, Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;->setError(Ljava/lang/CharSequence;)V

    goto :goto_0

    :cond_2
    move v0, v1

    .line 155
    goto :goto_0
.end method

.method public f()Ljava/lang/String;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->b:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public g()Z
    .locals 1

    .prologue
    .line 199
    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->e:Z

    return v0
.end method

.method public h()Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;

    return-object v0
.end method

.method public onFocusChange(Landroid/view/View;Z)V
    .locals 1

    .prologue
    .line 173
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseTextInputViewModel;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;

    invoke-virtual {v0, p2}, Lcom/salesforce/android/service/common/ui/views/SalesforceTextInputLayout;->setCounterEnabled(Z)V

    .line 174
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 180
    return-void
.end method

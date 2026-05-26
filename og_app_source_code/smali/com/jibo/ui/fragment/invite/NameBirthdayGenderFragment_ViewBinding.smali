.class public Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;
.super Ljava/lang/Object;
.source "NameBirthdayGenderFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;

.field private e:Landroid/view/View;

.field private f:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;Landroid/view/View;)V
    .locals 6

    .prologue
    const v5, 0x7f090104

    const v4, 0x7f090080

    const v3, 0x7f090078

    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    .line 36
    const v0, 0x7f0902fb

    const-string v1, "field \'title\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->title:Landroid/widget/TextView;

    .line 37
    const v0, 0x7f090137

    const-string v1, "field \'firstName\'"

    const-class v2, Landroid/widget/AutoCompleteTextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/AutoCompleteTextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->firstName:Landroid/widget/AutoCompleteTextView;

    .line 38
    const v0, 0x7f0901ae

    const-string v1, "field \'lastName\'"

    const-class v2, Landroid/widget/AutoCompleteTextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/AutoCompleteTextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->lastName:Landroid/widget/AutoCompleteTextView;

    .line 39
    const-string v0, "field \'dateText\' and method \'selectBirthday\'"

    invoke-static {p2, v5, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 40
    const-string v0, "field \'dateText\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {v1, v5, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->dateText:Landroid/widget/TextView;

    .line 41
    iput-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;->c:Landroid/view/View;

    .line 42
    new-instance v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 48
    const v0, 0x7f09004f

    const-string v1, "field \'birthdayTitle\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->birthdayTitle:Landroid/widget/TextView;

    .line 49
    const v0, 0x7f090141

    const-string v1, "field \'genderGroup\'"

    const-class v2, Landroid/widget/RadioGroup;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioGroup;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->genderGroup:Landroid/widget/RadioGroup;

    .line 50
    const v0, 0x7f090142

    const-string v1, "field \'genderTitle\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->genderTitle:Landroid/widget/TextView;

    .line 51
    const v0, 0x7f090236

    const-string v1, "field \'radioMale\'"

    const-class v2, Landroid/widget/RadioButton;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioButton;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->radioMale:Landroid/widget/RadioButton;

    .line 52
    const v0, 0x7f090235

    const-string v1, "field \'radioFemale\'"

    const-class v2, Landroid/widget/RadioButton;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioButton;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->radioFemale:Landroid/widget/RadioButton;

    .line 53
    const v0, 0x7f090237

    const-string v1, "field \'radioOther\'"

    const-class v2, Landroid/widget/RadioButton;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioButton;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->radioOther:Landroid/widget/RadioButton;

    .line 54
    const v0, 0x7f09013d

    const-string v1, "field \'formNavigationPanel\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->formNavigationPanel:Landroid/view/View;

    .line 55
    const-string v0, "field \'btnPrev\' and method \'onBtnPrevClick\'"

    invoke-static {p2, v4, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 56
    const-string v0, "field \'btnPrev\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {v1, v4, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->btnPrev:Landroid/widget/ImageView;

    .line 57
    iput-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;->d:Landroid/view/View;

    .line 58
    new-instance v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding$2;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 64
    const-string v0, "field \'btnNext\' and method \'onBtnNextClick\'"

    invoke-static {p2, v3, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 65
    const-string v0, "field \'btnNext\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {v1, v3, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->btnNext:Landroid/widget/ImageView;

    .line 66
    iput-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;->e:Landroid/view/View;

    .line 67
    new-instance v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding$3;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding$3;-><init>(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 73
    const v0, 0x7f090061

    const-string v1, "method \'onBtnDoneClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 74
    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;->f:Landroid/view/View;

    .line 75
    new-instance v1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding$4;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding$4;-><init>(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 81
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 86
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    .line 87
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 88
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    .line 90
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->title:Landroid/widget/TextView;

    .line 91
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->firstName:Landroid/widget/AutoCompleteTextView;

    .line 92
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->lastName:Landroid/widget/AutoCompleteTextView;

    .line 93
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->dateText:Landroid/widget/TextView;

    .line 94
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->birthdayTitle:Landroid/widget/TextView;

    .line 95
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->genderGroup:Landroid/widget/RadioGroup;

    .line 96
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->genderTitle:Landroid/widget/TextView;

    .line 97
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->radioMale:Landroid/widget/RadioButton;

    .line 98
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->radioFemale:Landroid/widget/RadioButton;

    .line 99
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->radioOther:Landroid/widget/RadioButton;

    .line 100
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->formNavigationPanel:Landroid/view/View;

    .line 101
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->btnPrev:Landroid/widget/ImageView;

    .line 102
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->btnNext:Landroid/widget/ImageView;

    .line 104
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 105
    iput-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;->c:Landroid/view/View;

    .line 106
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 107
    iput-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;->d:Landroid/view/View;

    .line 108
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;->e:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 109
    iput-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;->e:Landroid/view/View;

    .line 110
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;->f:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 111
    iput-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment_ViewBinding;->f:Landroid/view/View;

    .line 112
    return-void
.end method

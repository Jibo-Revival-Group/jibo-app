.class Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$7;
.super Ljava/lang/Object;
.source "NameBirthdayGenderFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


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
    .line 440
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$7;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 443
    .line 445
    invoke-virtual {p1}, Landroid/widget/AdapterView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;

    invoke-virtual {v0, p3}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestionsListAdapter;->a(I)Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;

    move-result-object v0

    .line 446
    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;->b()Ljava/lang/String;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 447
    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$7;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    aget-object v3, v1, v4

    invoke-virtual {v2, v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setFirstName(Ljava/lang/String;)V

    .line 448
    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$7;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->firstName:Landroid/widget/AutoCompleteTextView;

    aget-object v3, v1, v4

    invoke-virtual {v2, v3}, Landroid/widget/AutoCompleteTextView;->setText(Ljava/lang/CharSequence;)V

    .line 449
    array-length v2, v1

    const/4 v3, 0x1

    if-le v2, v3, :cond_0

    .line 450
    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$7;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    array-length v3, v1

    add-int/lit8 v3, v3, -0x1

    aget-object v3, v1, v3

    invoke-virtual {v2, v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setLastName(Ljava/lang/String;)V

    .line 451
    iget-object v2, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$7;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->lastName:Landroid/widget/AutoCompleteTextView;

    array-length v3, v1

    add-int/lit8 v3, v3, -0x1

    aget-object v1, v1, v3

    invoke-virtual {v2, v1}, Landroid/widget/AutoCompleteTextView;->setText(Ljava/lang/CharSequence;)V

    .line 453
    :cond_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$7;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setEmail(Ljava/lang/String;)V

    .line 454
    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;->d()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 455
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$7;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;->e()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setBirthday(Ljava/lang/Long;)V

    .line 456
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$7;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->dateText:Landroid/widget/TextView;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/invite/BaseSuggestionFragment$EmailSuggestion;->e()J

    move-result-wide v2

    sget-object v0, Lcom/jibo/aws/integration/util/DateTimeUtils;->FULL_DATE_FORMAT:Ljava/lang/String;

    invoke-static {v2, v3, v0}, Lcom/jibo/aws/integration/util/DateTimeUtils;->getBirthdayString(JLjava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 462
    :goto_0
    return-void

    .line 458
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$7;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setBirthday(Ljava/lang/Long;)V

    .line 459
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$7;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->dateText:Landroid/widget/TextView;

    const v1, 0x7f1001f3

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    goto :goto_0
.end method

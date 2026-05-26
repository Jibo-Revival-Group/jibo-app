.class Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$1;
.super Ljava/lang/Object;
.source "NameBirthdayGenderFragment.java"

# interfaces
.implements Landroid/widget/RadioGroup$OnCheckedChangeListener;


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
    .line 88
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$1;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/RadioGroup;I)V
    .locals 3

    .prologue
    .line 91
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$1;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->genderGroup:Landroid/widget/RadioGroup;

    invoke-virtual {v0, p2}, Landroid/widget/RadioGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 92
    iget-object v1, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$1;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->c:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-static {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->valueOf(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->setGender(Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;)V

    .line 95
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    invoke-virtual {p1}, Landroid/widget/RadioGroup;->getChildCount()I

    move-result v0

    if-ge v1, v0, :cond_2

    .line 96
    invoke-virtual {p1, v1}, Landroid/widget/RadioGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    instance-of v0, v0, Landroid/widget/RadioButton;

    if-eqz v0, :cond_0

    .line 97
    invoke-virtual {p1, v1}, Landroid/widget/RadioGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioButton;

    .line 98
    invoke-virtual {v0}, Landroid/widget/RadioButton;->getId()I

    move-result v2

    if-ne v2, p2, :cond_1

    .line 99
    invoke-static {v0}, Lcom/jibo/ui/view/proxima/ProximaHelper;->b(Landroid/view/View;)V

    .line 95
    :cond_0
    :goto_1
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 101
    :cond_1
    invoke-static {v0}, Lcom/jibo/ui/view/proxima/ProximaHelper;->a(Landroid/view/View;)V

    goto :goto_1

    .line 105
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment$1;->a:Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;->a(Lcom/jibo/ui/fragment/invite/NameBirthdayGenderFragment;)V

    .line 106
    return-void
.end method

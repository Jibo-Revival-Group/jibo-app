.class public Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;
.super Ljava/lang/Object;
.source "CasePickListViewModel.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemSelectedListener;
.implements Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/widget/AdapterView$OnItemSelectedListener;",
        "Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CaseFieldViewModel",
        "<",
        "Lcom/salesforce/android/service/common/ui/views/SalesforcePickListView;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Lcom/salesforce/android/service/common/ui/views/SalesforcePickListView;

.field private b:Landroid/widget/ArrayAdapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/widget/ArrayAdapter",
            "<+",
            "Lcom/salesforce/android/cases/core/model/PickListOption;",
            ">;"
        }
    .end annotation
.end field

.field private c:Lcom/salesforce/android/cases/core/model/CaseField;

.field private d:I

.field private e:Z


# direct methods
.method public constructor <init>(Lcom/salesforce/android/service/common/ui/views/SalesforcePickListView;Lcom/salesforce/android/cases/core/model/CaseField;)V
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    iput v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;->d:I

    .line 54
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseField;->f()Lcom/salesforce/android/cases/core/model/CaseFieldType;

    move-result-object v0

    sget-object v2, Lcom/salesforce/android/cases/core/model/CaseFieldType;->PICK_LIST:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    if-eq v0, v2, :cond_0

    .line 55
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "CaseField must be of type CaseFieldType.PICK_LIST."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 58
    :cond_0
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;->a:Lcom/salesforce/android/service/common/ui/views/SalesforcePickListView;

    .line 59
    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;->c:Lcom/salesforce/android/cases/core/model/CaseField;

    .line 63
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseField;->a()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    invoke-virtual {p1, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforcePickListView;->setId(I)V

    .line 66
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseField;->b()Ljava/lang/String;

    move-result-object v0

    .line 67
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseField;->d()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 68
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "*"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 70
    :cond_1
    invoke-virtual {p1, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforcePickListView;->setLabel(Ljava/lang/CharSequence;)V

    .line 73
    new-instance v0, Landroid/widget/ArrayAdapter;

    invoke-virtual {p1}, Lcom/salesforce/android/service/common/ui/views/SalesforcePickListView;->getContext()Landroid/content/Context;

    move-result-object v2

    sget v3, Lcom/salesforce/android/cases/R$layout;->pick_list_item:I

    .line 74
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseField;->c()Ljava/util/List;

    move-result-object v4

    invoke-direct {v0, v2, v3, v4}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;->b:Landroid/widget/ArrayAdapter;

    .line 75
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;->b:Landroid/widget/ArrayAdapter;

    sget v2, Lcom/salesforce/android/cases/R$layout;->pick_list_drop_down_item:I

    invoke-virtual {v0, v2}, Landroid/widget/ArrayAdapter;->setDropDownViewResource(I)V

    .line 76
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;->b:Landroid/widget/ArrayAdapter;

    invoke-virtual {p1, v0}, Lcom/salesforce/android/service/common/ui/views/SalesforcePickListView;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 79
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseField;->h()Ljava/lang/String;

    move-result-object v2

    .line 80
    invoke-static {v2}, Lcom/salesforce/android/cases/core/internal/util/StringUtils;->b(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 81
    :goto_0
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseField;->c()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_2

    .line 82
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseField;->c()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/model/PickListOption;

    .line 83
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/PickListOption;->b()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 84
    invoke-virtual {p1, v1}, Lcom/salesforce/android/service/common/ui/views/SalesforcePickListView;->setSelection(I)V

    .line 85
    iput v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;->d:I

    .line 92
    :cond_2
    invoke-virtual {p1, p0}, Lcom/salesforce/android/service/common/ui/views/SalesforcePickListView;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    .line 93
    return-void

    .line 81
    :cond_3
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0
.end method


# virtual methods
.method public synthetic a()Landroid/view/View;
    .locals 1

    .prologue
    .line 41
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;->h()Lcom/salesforce/android/service/common/ui/views/SalesforcePickListView;

    move-result-object v0

    return-object v0
.end method

.method public b()Z
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;->a:Lcom/salesforce/android/service/common/ui/views/SalesforcePickListView;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/views/SalesforcePickListView;->isFocused()Z

    move-result v0

    return v0
.end method

.method public c()V
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;->a:Lcom/salesforce/android/service/common/ui/views/SalesforcePickListView;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/utils/ViewUtils;->d(Landroid/view/View;)V

    .line 105
    return-void
.end method

.method public d()Lcom/salesforce/android/cases/core/model/CaseField;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;->c:Lcom/salesforce/android/cases/core/model/CaseField;

    return-object v0
.end method

.method public e()Z
    .locals 1

    .prologue
    .line 114
    const/4 v0, 0x1

    return v0
.end method

.method public f()Ljava/lang/String;
    .locals 2

    .prologue
    .line 118
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;->b:Landroid/widget/ArrayAdapter;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;->a:Lcom/salesforce/android/service/common/ui/views/SalesforcePickListView;

    invoke-virtual {v1}, Lcom/salesforce/android/service/common/ui/views/SalesforcePickListView;->getSelectedItemPosition()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/ArrayAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/model/PickListOption;

    .line 119
    if-eqz v0, :cond_0

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/PickListOption;->b()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public g()Z
    .locals 1

    .prologue
    .line 140
    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;->e:Z

    return v0
.end method

.method public h()Lcom/salesforce/android/service/common/ui/views/SalesforcePickListView;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;->a:Lcom/salesforce/android/service/common/ui/views/SalesforcePickListView;

    return-object v0
.end method

.method public onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 1
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
    .line 131
    iget v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;->d:I

    if-eq v0, p3, :cond_0

    .line 132
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;->e:Z

    .line 134
    :cond_0
    iput p3, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/viewmodel/CasePickListViewModel;->d:I

    .line 135
    return-void
.end method

.method public onNothingSelected(Landroid/widget/AdapterView;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 137
    return-void
.end method

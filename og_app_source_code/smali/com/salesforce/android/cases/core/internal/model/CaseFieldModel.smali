.class public Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;
.super Ljava/lang/Object;
.source "CaseFieldModel.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/model/CaseField;


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;

.field private c:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/internal/model/PickListOptionModel;",
            ">;"
        }
    .end annotation
.end field

.field private d:Z

.field private e:Z

.field private f:Z

.field private g:Lcom/salesforce/android/cases/core/model/CaseFieldType;

.field private h:I

.field private i:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$LayoutItem;)V
    .locals 4

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$LayoutItem;->a()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 52
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "LayoutItem or its fields cannot be null or empty."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 55
    :cond_1
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$LayoutItem;->a()Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$Field;

    .line 56
    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$Field;->c()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->a:Ljava/lang/String;

    .line 57
    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$Field;->a()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->b:Ljava/lang/String;

    .line 58
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$LayoutItem;->c()Z

    move-result v1

    iput-boolean v1, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->d:Z

    .line 59
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$LayoutItem;->b()Z

    move-result v1

    iput-boolean v1, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->e:Z

    .line 60
    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$Field;->e()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/salesforce/android/cases/core/model/CaseFieldType;->fromString(Ljava/lang/String;)Lcom/salesforce/android/cases/core/model/CaseFieldType;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->g:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    .line 61
    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$Field;->b()I

    move-result v1

    iput v1, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->h:I

    .line 62
    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$Field;->f()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/salesforce/android/cases/core/internal/util/StringUtils;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->i:Ljava/lang/String;

    .line 65
    sget-object v1, Lcom/salesforce/android/cases/core/model/CaseFieldType;->PICK_LIST:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->g:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    if-ne v1, v2, :cond_2

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$Field;->d()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_2

    .line 66
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->c:Ljava/util/List;

    .line 67
    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$Field;->d()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$PickListOption;

    .line 68
    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->c:Ljava/util/List;

    new-instance v3, Lcom/salesforce/android/cases/core/internal/model/PickListOptionModel;

    invoke-direct {v3, v0}, Lcom/salesforce/android/cases/core/internal/model/PickListOptionModel;-><init>(Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$PickListOption;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 71
    :cond_2
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->a:Ljava/lang/String;

    return-object v0
.end method

.method public a(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 118
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->i:Ljava/lang/String;

    .line 119
    return-void
.end method

.method public a(Z)V
    .locals 0

    .prologue
    .line 114
    iput-boolean p1, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->f:Z

    .line 115
    return-void
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->b:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<+",
            "Lcom/salesforce/android/cases/core/model/PickListOption;",
            ">;"
        }
    .end annotation

    .prologue
    .line 82
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->c:Ljava/util/List;

    if-nez v0, :cond_0

    .line 83
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    .line 85
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->c:Ljava/util/List;

    goto :goto_0
.end method

.method public d()Z
    .locals 1

    .prologue
    .line 90
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->d:Z

    return v0
.end method

.method public e()Z
    .locals 1

    .prologue
    .line 94
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->e:Z

    return v0
.end method

.method public f()Lcom/salesforce/android/cases/core/model/CaseFieldType;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->g:Lcom/salesforce/android/cases/core/model/CaseFieldType;

    return-object v0
.end method

.method public g()I
    .locals 1

    .prologue
    .line 102
    iget v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->h:I

    return v0
.end method

.method public h()Ljava/lang/String;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->i:Ljava/lang/String;

    return-object v0
.end method

.method public i()Z
    .locals 1

    .prologue
    .line 110
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;->f:Z

    return v0
.end method

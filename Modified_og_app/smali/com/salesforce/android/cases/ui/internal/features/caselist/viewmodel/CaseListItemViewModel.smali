.class public Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;
.super Ljava/lang/Object;
.source "CaseListItemViewModel.java"


# instance fields
.field private a:Landroid/content/Context;

.field private b:Lcom/salesforce/android/cases/core/model/CaseListRecord;

.field private c:Z

.field private d:Ljava/lang/String;

.field private e:Ljava/lang/String;

.field private f:Ljava/lang/String;

.field private g:Ljava/util/Date;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/salesforce/android/cases/core/model/CaseListRecord;)V
    .locals 2

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    if-nez p1, :cond_0

    .line 48
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Context cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 51
    :cond_0
    if-nez p2, :cond_1

    .line 52
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "CaseListRecord cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 54
    :cond_1
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->a:Landroid/content/Context;

    .line 55
    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->b:Lcom/salesforce/android/cases/core/model/CaseListRecord;

    .line 56
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->e()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->c:Z

    .line 57
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->b()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->d:Ljava/lang/String;

    .line 58
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->a()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->a()Ljava/lang/String;

    move-result-object v0

    :goto_0
    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->e:Ljava/lang/String;

    .line 59
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->d()Ljava/util/Date;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->g:Ljava/util/Date;

    .line 60
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->g()Lcom/salesforce/android/cases/core/model/CaseListFeedRecord;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 61
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->g()Lcom/salesforce/android/cases/core/model/CaseListFeedRecord;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseListFeedRecord;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->f:Ljava/lang/String;

    .line 63
    :cond_2
    return-void

    .line 58
    :cond_3
    invoke-interface {p2}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->c()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public a()Lcom/salesforce/android/cases/core/model/CaseListRecord;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->b:Lcom/salesforce/android/cases/core/model/CaseListRecord;

    return-object v0
.end method

.method public a(Z)V
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->b:Lcom/salesforce/android/cases/core/model/CaseListRecord;

    invoke-interface {v0, p1}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->a(Z)V

    .line 75
    iput-boolean p1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->c:Z

    .line 76
    return-void
.end method

.method public b()Z
    .locals 1

    .prologue
    .line 70
    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->c:Z

    return v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->d:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .locals 8

    .prologue
    const-wide/32 v4, 0xea60

    .line 83
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->g:Ljava/util/Date;

    if-nez v0, :cond_0

    .line 84
    const/4 v0, 0x0

    .line 94
    :goto_0
    return-object v0

    .line 87
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->g:Ljava/util/Date;

    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    .line 88
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 91
    sub-long v6, v2, v0

    cmp-long v6, v6, v4

    if-gtz v6, :cond_1

    .line 92
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->a:Landroid/content/Context;

    sget v1, Lcom/salesforce/android/cases/R$string;->cases_timestamp_just_now_text:I

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 94
    :cond_1
    invoke-static/range {v0 .. v5}, Landroid/text/format/DateUtils;->getRelativeTimeSpanString(JJJ)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public e()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->e:Ljava/lang/String;

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 110
    if-ne p0, p1, :cond_1

    move v1, v0

    .line 124
    :cond_0
    :goto_0
    return v1

    .line 111
    :cond_1
    if-eqz p1, :cond_0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-ne v2, v3, :cond_0

    .line 113
    check-cast p1, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;

    .line 115
    iget-boolean v2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->c:Z

    iget-boolean v3, p1, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->c:Z

    if-ne v2, v3, :cond_0

    .line 116
    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->b:Lcom/salesforce/android/cases/core/model/CaseListRecord;

    if-eqz v2, :cond_7

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->b:Lcom/salesforce/android/cases/core/model/CaseListRecord;

    iget-object v3, p1, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->b:Lcom/salesforce/android/cases/core/model/CaseListRecord;

    invoke-virtual {v2, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 117
    :cond_2
    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->d:Ljava/lang/String;

    if-eqz v2, :cond_8

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->d:Ljava/lang/String;

    iget-object v3, p1, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->d:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 118
    :cond_3
    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->e:Ljava/lang/String;

    if-eqz v2, :cond_9

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->e:Ljava/lang/String;

    iget-object v3, p1, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->e:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 121
    :cond_4
    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->f:Ljava/lang/String;

    if-eqz v2, :cond_a

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->f:Ljava/lang/String;

    iget-object v3, p1, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->f:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 124
    :cond_5
    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->g:Ljava/util/Date;

    if-eqz v2, :cond_b

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->g:Ljava/util/Date;

    iget-object v1, p1, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->g:Ljava/util/Date;

    invoke-virtual {v0, v1}, Ljava/util/Date;->equals(Ljava/lang/Object;)Z

    move-result v0

    :cond_6
    :goto_1
    move v1, v0

    goto :goto_0

    .line 116
    :cond_7
    iget-object v2, p1, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->b:Lcom/salesforce/android/cases/core/model/CaseListRecord;

    if-eqz v2, :cond_2

    goto :goto_0

    .line 117
    :cond_8
    iget-object v2, p1, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->d:Ljava/lang/String;

    if-eqz v2, :cond_3

    goto :goto_0

    .line 118
    :cond_9
    iget-object v2, p1, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->e:Ljava/lang/String;

    if-eqz v2, :cond_4

    goto :goto_0

    .line 121
    :cond_a
    iget-object v2, p1, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->f:Ljava/lang/String;

    if-eqz v2, :cond_5

    goto :goto_0

    .line 124
    :cond_b
    iget-object v2, p1, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->g:Ljava/util/Date;

    if-eqz v2, :cond_6

    move v0, v1

    goto :goto_1
.end method

.method public f()Ljava/lang/String;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->f:Ljava/lang/String;

    return-object v0
.end method

.method public g()Ljava/util/Date;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->g:Ljava/util/Date;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 129
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->b:Lcom/salesforce/android/cases/core/model/CaseListRecord;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->b:Lcom/salesforce/android/cases/core/model/CaseListRecord;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    .line 130
    :goto_0
    mul-int/lit8 v2, v0, 0x1f

    iget-boolean v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->c:Z

    if-eqz v0, :cond_2

    const/4 v0, 0x1

    :goto_1
    add-int/2addr v0, v2

    .line 131
    mul-int/lit8 v2, v0, 0x1f

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->d:Ljava/lang/String;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->d:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    :goto_2
    add-int/2addr v0, v2

    .line 132
    mul-int/lit8 v2, v0, 0x1f

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->e:Ljava/lang/String;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->e:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    :goto_3
    add-int/2addr v0, v2

    .line 133
    mul-int/lit8 v2, v0, 0x1f

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->f:Ljava/lang/String;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->f:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    :goto_4
    add-int/2addr v0, v2

    .line 134
    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->g:Ljava/util/Date;

    if-eqz v2, :cond_0

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->g:Ljava/util/Date;

    invoke-virtual {v1}, Ljava/util/Date;->hashCode()I

    move-result v1

    :cond_0
    add-int/2addr v0, v1

    .line 135
    return v0

    :cond_1
    move v0, v1

    .line 129
    goto :goto_0

    :cond_2
    move v0, v1

    .line 130
    goto :goto_1

    :cond_3
    move v0, v1

    .line 131
    goto :goto_2

    :cond_4
    move v0, v1

    .line 132
    goto :goto_3

    :cond_5
    move v0, v1

    .line 133
    goto :goto_4
.end method

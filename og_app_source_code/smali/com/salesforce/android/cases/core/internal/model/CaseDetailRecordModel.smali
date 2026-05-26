.class public Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;
.super Ljava/lang/Object;
.source "CaseDetailRecordModel.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/model/CaseDetailRecord;


# instance fields
.field private A:Ljava/lang/String;

.field private B:Ljava/util/Date;

.field private C:Ljava/util/Date;

.field private D:Ljava/lang/String;

.field private E:Ljava/lang/String;

.field private F:Ljava/lang/String;

.field private G:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private a:Ljava/lang/String;

.field private b:Z

.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;

.field private e:Ljava/lang/String;

.field private f:Ljava/lang/String;

.field private g:Ljava/lang/String;

.field private h:Ljava/lang/String;

.field private i:Ljava/lang/String;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private l:Ljava/lang/String;

.field private m:Ljava/lang/String;

.field private n:Ljava/lang/String;

.field private o:Ljava/lang/String;

.field private p:Ljava/lang/String;

.field private q:Ljava/lang/String;

.field private r:Z

.field private s:Ljava/util/Date;

.field private t:Z

.field private u:Z

.field private v:Z

.field private w:Ljava/lang/String;

.field private x:Ljava/util/Date;

.field private y:Ljava/lang/String;

.field private z:Ljava/util/Date;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;)V
    .locals 2

    .prologue
    .line 70
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 71
    if-nez p1, :cond_0

    .line 72
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "CaseDetailResponse cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 75
    :cond_0
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->a:Ljava/lang/String;

    .line 76
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->b()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->b:Z

    .line 77
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->c()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->c:Ljava/lang/String;

    .line 78
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->d()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->d:Ljava/lang/String;

    .line 79
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->e()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->e:Ljava/lang/String;

    .line 80
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->f()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->f:Ljava/lang/String;

    .line 81
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->g()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->g:Ljava/lang/String;

    .line 82
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->h()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->h:Ljava/lang/String;

    .line 83
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->i()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->i:Ljava/lang/String;

    .line 84
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->j()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->j:Ljava/lang/String;

    .line 85
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->k()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->k:Ljava/lang/String;

    .line 86
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->l()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->l:Ljava/lang/String;

    .line 87
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->m()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->m:Ljava/lang/String;

    .line 88
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->n()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->n:Ljava/lang/String;

    .line 89
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->o()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->o:Ljava/lang/String;

    .line 90
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->p()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->p:Ljava/lang/String;

    .line 91
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->q()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->q:Ljava/lang/String;

    .line 92
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->r()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->r:Z

    .line 93
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->s()Ljava/util/Date;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->s:Ljava/util/Date;

    .line 94
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->t()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->t:Z

    .line 95
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->u()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->u:Z

    .line 96
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->v()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->v:Z

    .line 97
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->w()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->w:Ljava/lang/String;

    .line 98
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->x()Ljava/util/Date;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->x:Ljava/util/Date;

    .line 99
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->y()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->y:Ljava/lang/String;

    .line 100
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->z()Ljava/util/Date;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->z:Ljava/util/Date;

    .line 101
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->A()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->A:Ljava/lang/String;

    .line 102
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->B()Ljava/util/Date;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->B:Ljava/util/Date;

    .line 103
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->C()Ljava/util/Date;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->C:Ljava/util/Date;

    .line 104
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->D()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->D:Ljava/lang/String;

    .line 105
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->E()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->E:Ljava/lang/String;

    .line 106
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->F()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->F:Ljava/lang/String;

    .line 107
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->G()Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->G:Ljava/util/Map;

    .line 108
    return-void
.end method

.method public static a(Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;)Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;
    .locals 1

    .prologue
    .line 111
    new-instance v0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;-><init>(Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;)V

    return-object v0
.end method


# virtual methods
.method public A()Ljava/lang/String;
    .locals 1

    .prologue
    .line 239
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->F:Ljava/lang/String;

    return-object v0
.end method

.method public B()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 243
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->G:Ljava/util/Map;

    return-object v0
.end method

.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->c:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->d:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->e:Ljava/lang/String;

    return-object v0
.end method

.method public e()Ljava/lang/String;
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->f:Ljava/lang/String;

    return-object v0
.end method

.method public f()Ljava/lang/String;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->g:Ljava/lang/String;

    return-object v0
.end method

.method public g()Ljava/lang/String;
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->h:Ljava/lang/String;

    return-object v0
.end method

.method public h()Ljava/lang/String;
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->i:Ljava/lang/String;

    return-object v0
.end method

.method public i()Ljava/lang/String;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->j:Ljava/lang/String;

    return-object v0
.end method

.method public j()Ljava/lang/String;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->k:Ljava/lang/String;

    return-object v0
.end method

.method public k()Ljava/lang/String;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->l:Ljava/lang/String;

    return-object v0
.end method

.method public l()Ljava/lang/String;
    .locals 1

    .prologue
    .line 163
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->m:Ljava/lang/String;

    return-object v0
.end method

.method public m()Ljava/lang/String;
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->n:Ljava/lang/String;

    return-object v0
.end method

.method public n()Ljava/lang/String;
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->o:Ljava/lang/String;

    return-object v0
.end method

.method public o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->p:Ljava/lang/String;

    return-object v0
.end method

.method public p()Ljava/lang/String;
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->q:Ljava/lang/String;

    return-object v0
.end method

.method public q()Ljava/util/Date;
    .locals 1

    .prologue
    .line 187
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->s:Ljava/util/Date;

    return-object v0
.end method

.method public r()Ljava/lang/String;
    .locals 1

    .prologue
    .line 203
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->w:Ljava/lang/String;

    return-object v0
.end method

.method public s()Ljava/util/Date;
    .locals 1

    .prologue
    .line 207
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->x:Ljava/util/Date;

    return-object v0
.end method

.method public t()Ljava/lang/String;
    .locals 1

    .prologue
    .line 211
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->y:Ljava/lang/String;

    return-object v0
.end method

.method public u()Ljava/util/Date;
    .locals 1

    .prologue
    .line 215
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->z:Ljava/util/Date;

    return-object v0
.end method

.method public v()Ljava/lang/String;
    .locals 1

    .prologue
    .line 219
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->A:Ljava/lang/String;

    return-object v0
.end method

.method public w()Ljava/util/Date;
    .locals 1

    .prologue
    .line 223
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->B:Ljava/util/Date;

    return-object v0
.end method

.method public x()Ljava/util/Date;
    .locals 1

    .prologue
    .line 227
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->C:Ljava/util/Date;

    return-object v0
.end method

.method public y()Ljava/lang/String;
    .locals 1

    .prologue
    .line 231
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->D:Ljava/lang/String;

    return-object v0
.end method

.method public z()Ljava/lang/String;
    .locals 1

    .prologue
    .line 235
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->E:Ljava/lang/String;

    return-object v0
.end method

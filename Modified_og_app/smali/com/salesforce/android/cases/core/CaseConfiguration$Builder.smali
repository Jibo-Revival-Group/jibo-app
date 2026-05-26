.class public Lcom/salesforce/android/cases/core/CaseConfiguration$Builder;
.super Ljava/lang/Object;
.source "CaseConfiguration.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/CaseConfiguration;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:J

.field private e:Z

.field private f:Z

.field private g:I

.field private h:Lcom/salesforce/android/cases/core/CaseClientCallbacks;

.field private i:Lcom/salesforce/androidsdk/accounts/UserAccount;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 173
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 157
    sget-object v0, Ljava/util/concurrent/TimeUnit;->DAYS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v2, 0x1

    invoke-virtual {v0, v2, v3}, Ljava/util/concurrent/TimeUnit;->toSeconds(J)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/salesforce/android/cases/core/CaseConfiguration$Builder;->d:J

    .line 174
    iput-object p1, p0, Lcom/salesforce/android/cases/core/CaseConfiguration$Builder;->a:Ljava/lang/String;

    .line 175
    iput-object p2, p0, Lcom/salesforce/android/cases/core/CaseConfiguration$Builder;->b:Ljava/lang/String;

    .line 176
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/cases/core/CaseClientCallbacks;)Lcom/salesforce/android/cases/core/CaseConfiguration$Builder;
    .locals 0

    .prologue
    .line 235
    iput-object p1, p0, Lcom/salesforce/android/cases/core/CaseConfiguration$Builder;->h:Lcom/salesforce/android/cases/core/CaseClientCallbacks;

    .line 236
    return-object p0
.end method

.method public a()Lcom/salesforce/android/cases/core/CaseConfiguration;
    .locals 12

    .prologue
    .line 185
    new-instance v0, Lcom/salesforce/android/cases/core/CaseConfiguration;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/CaseConfiguration$Builder;->a:Ljava/lang/String;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/CaseConfiguration$Builder;->b:Ljava/lang/String;

    iget-object v3, p0, Lcom/salesforce/android/cases/core/CaseConfiguration$Builder;->c:Ljava/lang/String;

    iget-wide v4, p0, Lcom/salesforce/android/cases/core/CaseConfiguration$Builder;->d:J

    iget-boolean v6, p0, Lcom/salesforce/android/cases/core/CaseConfiguration$Builder;->e:Z

    iget-boolean v7, p0, Lcom/salesforce/android/cases/core/CaseConfiguration$Builder;->f:Z

    iget v8, p0, Lcom/salesforce/android/cases/core/CaseConfiguration$Builder;->g:I

    iget-object v9, p0, Lcom/salesforce/android/cases/core/CaseConfiguration$Builder;->h:Lcom/salesforce/android/cases/core/CaseClientCallbacks;

    iget-object v10, p0, Lcom/salesforce/android/cases/core/CaseConfiguration$Builder;->i:Lcom/salesforce/androidsdk/accounts/UserAccount;

    const/4 v11, 0x0

    invoke-direct/range {v0 .. v11}, Lcom/salesforce/android/cases/core/CaseConfiguration;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZZILcom/salesforce/android/cases/core/CaseClientCallbacks;Lcom/salesforce/androidsdk/accounts/UserAccount;Lcom/salesforce/android/cases/core/CaseConfiguration$1;)V

    return-object v0
.end method

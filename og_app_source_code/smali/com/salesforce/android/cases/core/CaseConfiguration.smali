.class public Lcom/salesforce/android/cases/core/CaseConfiguration;
.super Ljava/lang/Object;
.source "CaseConfiguration.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/CaseConfiguration$Builder;
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/String;

.field private final c:Ljava/lang/String;

.field private final d:J

.field private final e:Z

.field private final f:Z

.field private final g:I

.field private final h:Lcom/salesforce/android/cases/core/CaseClientCallbacks;

.field private final i:Lcom/salesforce/androidsdk/accounts/UserAccount;


# direct methods
.method private constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZZILcom/salesforce/android/cases/core/CaseClientCallbacks;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 0

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    iput-object p1, p0, Lcom/salesforce/android/cases/core/CaseConfiguration;->a:Ljava/lang/String;

    .line 52
    iput-object p2, p0, Lcom/salesforce/android/cases/core/CaseConfiguration;->b:Ljava/lang/String;

    .line 53
    iput-object p3, p0, Lcom/salesforce/android/cases/core/CaseConfiguration;->c:Ljava/lang/String;

    .line 54
    iput-wide p4, p0, Lcom/salesforce/android/cases/core/CaseConfiguration;->d:J

    .line 55
    iput-boolean p6, p0, Lcom/salesforce/android/cases/core/CaseConfiguration;->e:Z

    .line 56
    iput-boolean p7, p0, Lcom/salesforce/android/cases/core/CaseConfiguration;->f:Z

    .line 57
    iput p8, p0, Lcom/salesforce/android/cases/core/CaseConfiguration;->g:I

    .line 58
    iput-object p9, p0, Lcom/salesforce/android/cases/core/CaseConfiguration;->h:Lcom/salesforce/android/cases/core/CaseClientCallbacks;

    .line 59
    iput-object p10, p0, Lcom/salesforce/android/cases/core/CaseConfiguration;->i:Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 60
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZZILcom/salesforce/android/cases/core/CaseClientCallbacks;Lcom/salesforce/androidsdk/accounts/UserAccount;Lcom/salesforce/android/cases/core/CaseConfiguration$1;)V
    .locals 0

    .prologue
    .line 35
    invoke-direct/range {p0 .. p10}, Lcom/salesforce/android/cases/core/CaseConfiguration;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZZILcom/salesforce/android/cases/core/CaseClientCallbacks;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/salesforce/android/cases/core/CaseConfiguration;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/salesforce/android/cases/core/CaseConfiguration;->b:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/salesforce/android/cases/core/CaseConfiguration;->c:Ljava/lang/String;

    return-object v0
.end method

.method public d()Z
    .locals 1

    .prologue
    .line 102
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/CaseConfiguration;->e:Z

    return v0
.end method

.method public e()J
    .locals 2

    .prologue
    .line 111
    iget-wide v0, p0, Lcom/salesforce/android/cases/core/CaseConfiguration;->d:J

    return-wide v0
.end method

.method public f()Z
    .locals 1

    .prologue
    .line 120
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/CaseConfiguration;->f:Z

    return v0
.end method

.method public g()I
    .locals 1

    .prologue
    .line 129
    iget v0, p0, Lcom/salesforce/android/cases/core/CaseConfiguration;->g:I

    return v0
.end method

.method public h()Lcom/salesforce/android/cases/core/CaseClientCallbacks;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/salesforce/android/cases/core/CaseConfiguration;->h:Lcom/salesforce/android/cases/core/CaseClientCallbacks;

    return-object v0
.end method

.method public i()Lcom/salesforce/androidsdk/accounts/UserAccount;
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/salesforce/android/cases/core/CaseConfiguration;->i:Lcom/salesforce/androidsdk/accounts/UserAccount;

    return-object v0
.end method

.class public Lcom/salesforce/android/cases/ui/CaseUIConfiguration;
.super Ljava/lang/Object;
.source "CaseUIConfiguration.java"


# instance fields
.field private final a:Lcom/salesforce/android/cases/core/CaseConfiguration;

.field private final b:I


# direct methods
.method private constructor <init>(Lcom/salesforce/android/cases/core/CaseConfiguration;I)V
    .locals 0

    .prologue
    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/CaseUIConfiguration;->a:Lcom/salesforce/android/cases/core/CaseConfiguration;

    .line 67
    iput p2, p0, Lcom/salesforce/android/cases/ui/CaseUIConfiguration;->b:I

    .line 68
    return-void
.end method

.method private a(I)I
    .locals 1

    .prologue
    .line 117
    packed-switch p1, :pswitch_data_0

    .line 130
    :pswitch_0
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 119
    :pswitch_1
    const/4 v0, 0x1

    goto :goto_0

    .line 121
    :pswitch_2
    const/4 v0, 0x2

    goto :goto_0

    .line 123
    :pswitch_3
    const/4 v0, -0x1

    goto :goto_0

    .line 126
    :pswitch_4
    const/4 v0, -0x2

    goto :goto_0

    .line 117
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_4
        :pswitch_4
        :pswitch_3
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public static a(Lcom/salesforce/android/cases/core/CaseConfiguration;)Lcom/salesforce/android/cases/ui/CaseUIConfiguration;
    .locals 1

    .prologue
    .line 77
    const/4 v0, 0x4

    invoke-static {p0, v0}, Lcom/salesforce/android/cases/ui/CaseUIConfiguration;->a(Lcom/salesforce/android/cases/core/CaseConfiguration;I)Lcom/salesforce/android/cases/ui/CaseUIConfiguration;

    move-result-object v0

    return-object v0
.end method

.method public static a(Lcom/salesforce/android/cases/core/CaseConfiguration;I)Lcom/salesforce/android/cases/ui/CaseUIConfiguration;
    .locals 1

    .prologue
    .line 95
    new-instance v0, Lcom/salesforce/android/cases/ui/CaseUIConfiguration;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/cases/ui/CaseUIConfiguration;-><init>(Lcom/salesforce/android/cases/core/CaseConfiguration;I)V

    return-object v0
.end method


# virtual methods
.method public a()I
    .locals 1

    .prologue
    .line 105
    iget v0, p0, Lcom/salesforce/android/cases/ui/CaseUIConfiguration;->b:I

    return v0
.end method

.method public b()I
    .locals 1

    .prologue
    .line 113
    iget v0, p0, Lcom/salesforce/android/cases/ui/CaseUIConfiguration;->b:I

    invoke-direct {p0, v0}, Lcom/salesforce/android/cases/ui/CaseUIConfiguration;->a(I)I

    move-result v0

    return v0
.end method

.method public c()Lcom/salesforce/android/cases/core/CaseConfiguration;
    .locals 1

    .prologue
    .line 140
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/CaseUIConfiguration;->a:Lcom/salesforce/android/cases/core/CaseConfiguration;

    return-object v0
.end method

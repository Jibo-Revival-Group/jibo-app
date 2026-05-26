.class Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;
.super Ljava/lang/Object;
.source "ServiceLoggerImpl.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/String;


# direct methods
.method private constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    iput-object p1, p0, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;->a:Ljava/lang/String;

    .line 52
    iput-object p2, p0, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;->b:Ljava/lang/String;

    .line 53
    return-void
.end method

.method static a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;
    .locals 1

    .prologue
    .line 47
    new-instance v0, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method private a(ILjava/lang/String;)V
    .locals 1

    .prologue
    .line 114
    invoke-direct {p0, p1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;->a(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 115
    invoke-direct {p0, p1, p2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;->b(ILjava/lang/String;)V

    .line 117
    :cond_0
    return-void
.end method

.method private a(ILjava/lang/String;[Ljava/lang/Object;)V
    .locals 1

    .prologue
    .line 120
    invoke-direct {p0, p1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;->a(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 121
    invoke-direct {p0, p2, p3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;->f(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;->b(ILjava/lang/String;)V

    .line 123
    :cond_0
    return-void
.end method

.method private a(I)Z
    .locals 1

    .prologue
    .line 130
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a()I

    move-result v0

    if-gt v0, p1, :cond_1

    .line 131
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->b()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;->b:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;->b:Ljava/lang/String;

    .line 132
    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    .line 130
    :goto_0
    return v0

    .line 132
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private b(ILjava/lang/String;)V
    .locals 3

    .prologue
    .line 165
    invoke-static {}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->b()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggingSink;

    .line 166
    iget-object v2, p0, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;->a:Ljava/lang/String;

    invoke-interface {v0, p1, v2, p2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggingSink;->a(ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 168
    :cond_0
    return-void
.end method

.method private f(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v0, 0x0

    .line 137
    if-nez p2, :cond_0

    .line 161
    :goto_0
    return-object p1

    .line 141
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 144
    array-length v3, p2

    move v1, v0

    :goto_1
    if-ge v0, v3, :cond_1

    aget-object v4, p2, v0

    .line 145
    const-string v5, "{}"

    invoke-virtual {p1, v5, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v5

    .line 146
    if-ltz v5, :cond_1

    .line 148
    invoke-virtual {v2, p1, v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;II)Ljava/lang/StringBuilder;

    .line 150
    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 152
    add-int/lit8 v1, v5, 0x2

    .line 144
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 159
    :cond_1
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    invoke-virtual {v2, p1, v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;II)Ljava/lang/StringBuilder;

    .line 161
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_0
.end method


# virtual methods
.method public a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 61
    const/4 v0, 0x1

    invoke-direct {p0, v0, p1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;->a(ILjava/lang/String;)V

    .line 62
    return-void
.end method

.method public varargs a(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 1

    .prologue
    .line 66
    const/4 v0, 0x1

    invoke-direct {p0, v0, p1, p2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;->a(ILjava/lang/String;[Ljava/lang/Object;)V

    .line 67
    return-void
.end method

.method public b(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 71
    const/4 v0, 0x2

    invoke-direct {p0, v0, p1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;->a(ILjava/lang/String;)V

    .line 72
    return-void
.end method

.method public varargs b(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 1

    .prologue
    .line 76
    const/4 v0, 0x2

    invoke-direct {p0, v0, p1, p2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;->a(ILjava/lang/String;[Ljava/lang/Object;)V

    .line 77
    return-void
.end method

.method public c(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 81
    const/4 v0, 0x3

    invoke-direct {p0, v0, p1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;->a(ILjava/lang/String;)V

    .line 82
    return-void
.end method

.method public varargs c(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 1

    .prologue
    .line 86
    const/4 v0, 0x3

    invoke-direct {p0, v0, p1, p2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;->a(ILjava/lang/String;[Ljava/lang/Object;)V

    .line 87
    return-void
.end method

.method public d(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 91
    const/4 v0, 0x4

    invoke-direct {p0, v0, p1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;->a(ILjava/lang/String;)V

    .line 92
    return-void
.end method

.method public varargs d(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 1

    .prologue
    .line 96
    const/4 v0, 0x4

    invoke-direct {p0, v0, p1, p2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;->a(ILjava/lang/String;[Ljava/lang/Object;)V

    .line 97
    return-void
.end method

.method public e(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 101
    const/4 v0, 0x5

    invoke-direct {p0, v0, p1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;->a(ILjava/lang/String;)V

    .line 102
    return-void
.end method

.method public varargs e(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 1

    .prologue
    .line 106
    const/4 v0, 0x5

    invoke-direct {p0, v0, p1, p2}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;->a(ILjava/lang/String;[Ljava/lang/Object;)V

    .line 107
    return-void
.end method

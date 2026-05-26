.class public Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;
.super Ljava/lang/Object;
.source "ServiceLogging.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging$LogCatSink;
    }
.end annotation


# static fields
.field public static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggingSink;

.field private static b:I

.field private static final c:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggingSink;",
            ">;"
        }
    .end annotation
.end field

.field private static final d:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 54
    new-instance v0, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging$LogCatSink;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging$LogCatSink;-><init>()V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggingSink;

    .line 76
    const/4 v0, 0x6

    sput v0, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->b:I

    .line 77
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->c:Ljava/util/Set;

    .line 78
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->d:Ljava/util/Set;

    return-void
.end method

.method public static a()I
    .locals 1

    .prologue
    .line 124
    sget v0, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->b:I

    return v0
.end method

.method public static a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;"
        }
    .end annotation

    .prologue
    .line 96
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;Ljava/lang/String;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/Class;Ljava/lang/String;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;"
        }
    .end annotation

    .prologue
    .line 103
    invoke-virtual {p0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggerImpl;

    move-result-object v0

    return-object v0
.end method

.method static a(Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 147
    sget-object v0, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->d:Ljava/util/Set;

    invoke-interface {v0, p0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static b()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Lcom/salesforce/android/service/common/utilities/logging/ServiceLoggingSink;",
            ">;"
        }
    .end annotation

    .prologue
    .line 143
    sget-object v0, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->c:Ljava/util/Set;

    return-object v0
.end method

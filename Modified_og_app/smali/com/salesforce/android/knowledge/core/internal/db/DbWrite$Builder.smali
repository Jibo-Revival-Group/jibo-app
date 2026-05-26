.class Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;
.super Ljava/lang/Object;
.source "DbWrite.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/internal/db/DbWrite;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Builder"
.end annotation


# instance fields
.field final a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Operation;",
            ">;"
        }
    .end annotation
.end field

.field final b:Lnet/sqlcipher/database/SQLiteDatabase;


# direct methods
.method constructor <init>(Lnet/sqlcipher/database/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 93
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 90
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;->a:Ljava/util/List;

    .line 94
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;->b:Lnet/sqlcipher/database/SQLiteDatabase;

    .line 95
    return-void
.end method


# virtual methods
.method a(Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Operation;)Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 99
    return-object p0
.end method

.method a()Lcom/salesforce/android/knowledge/core/internal/db/DbWrite;
    .locals 1

    .prologue
    .line 103
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/core/internal/db/DbWrite;-><init>(Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Builder;)V

    return-object v0
.end method

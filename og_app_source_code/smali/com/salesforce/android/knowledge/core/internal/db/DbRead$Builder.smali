.class Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;
.super Ljava/lang/Object;
.source "DbRead.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/internal/db/DbRead;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field final a:Lnet/sqlcipher/database/SQLiteDatabase;

.field final b:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Operation",
            "<TT;>;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lnet/sqlcipher/database/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 95
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 93
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;->b:Ljava/util/List;

    .line 96
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;->a:Lnet/sqlcipher/database/SQLiteDatabase;

    .line 97
    return-void
.end method


# virtual methods
.method a(Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Operation;)Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Operation",
            "<TT;>;)",
            "Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 100
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;->b:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 101
    return-object p0
.end method

.method a()Lcom/salesforce/android/knowledge/core/internal/db/DbRead;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/salesforce/android/knowledge/core/internal/db/DbRead",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 105
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/db/DbRead;

    invoke-direct {v0, p0}, Lcom/salesforce/android/knowledge/core/internal/db/DbRead;-><init>(Lcom/salesforce/android/knowledge/core/internal/db/DbRead$Builder;)V

    return-object v0
.end method

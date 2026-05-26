.class public Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation$WriteList;
.super Ljava/lang/Object;
.source "DataCategoryGroupOperation.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/internal/db/DbWrite$Operation;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "WriteList"
.end annotation


# instance fields
.field private a:Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;)V
    .locals 0

    .prologue
    .line 74
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 75
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation$WriteList;->a:Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;

    .line 76
    return-void
.end method

.method private static a(Ljava/lang/StringBuilder;Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;)V
    .locals 4

    .prologue
    .line 110
    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;->c()Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;

    move-result-object v1

    .line 112
    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;->a()Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;

    move-result-object v0

    if-nez v0, :cond_2

    const/4 v0, 0x0

    .line 115
    :goto_0
    const-string v2, "(\'"

    invoke-virtual {p0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 116
    invoke-interface {v1}, Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;->a()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\', \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 117
    invoke-interface {v1}, Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;->b()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\', "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 120
    if-eqz v0, :cond_3

    .line 121
    const-string v1, "\'"

    invoke-virtual {p0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\', \'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 126
    :goto_1
    invoke-interface {p2}, Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;->a()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\')"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 128
    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;->b()Ljava/util/Set;

    move-result-object v2

    .line 131
    invoke-interface {v2}, Ljava/util/Set;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 132
    const-string v0, ", "

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 135
    :cond_0
    const/4 v0, 0x0

    .line 136
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    move v1, v0

    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;

    .line 137
    invoke-static {p0, v0, p2}, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation$WriteList;->a(Ljava/lang/StringBuilder;Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;)V

    .line 139
    add-int/lit8 v0, v1, 0x1

    invoke-interface {v2}, Ljava/util/Set;->size()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 140
    const-string v1, ", "

    invoke-virtual {p0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_1
    move v1, v0

    .line 142
    goto :goto_2

    .line 113
    :cond_2
    invoke-interface {p1}, Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;->a()Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;->c()Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/DataCategorySummary;->a()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 123
    :cond_3
    const-string v0, "null, \'"

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 143
    :cond_4
    return-void
.end method

.method private static a(Lnet/sqlcipher/database/SQLiteDatabase;Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;)V
    .locals 2

    .prologue
    .line 96
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "INSERT OR REPLACE INTO "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "DataCategorySummary"

    .line 97
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " ("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "name"

    .line 98
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "label"

    .line 99
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "parent"

    .line 100
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "data_category_group"

    .line 101
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ") VALUES "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 103
    invoke-static {v0, p1, p2}, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation$WriteList;->a(Ljava/lang/StringBuilder;Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;)V

    .line 105
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 106
    invoke-virtual {p0, v0}, Lnet/sqlcipher/database/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 107
    return-void
.end method


# virtual methods
.method public a(Lnet/sqlcipher/database/SQLiteDatabase;)V
    .locals 6

    .prologue
    .line 79
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 81
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation$WriteList;->a:Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/DataCategoryGroupList;->a()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;

    .line 82
    const-string v1, "name"

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;->a()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v1, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 83
    const-string v1, "label"

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;->b()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v1, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 85
    const-string v1, "DataCategoryGroup"

    const/4 v4, 0x0

    const/4 v5, 0x5

    invoke-virtual {p1, v1, v4, v2, v5}, Lnet/sqlcipher/database/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    .line 88
    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;->c()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;

    .line 89
    invoke-static {p1, v1, v0}, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation$WriteList;->a(Lnet/sqlcipher/database/SQLiteDatabase;Lcom/salesforce/android/knowledge/core/model/DataCategoryTree;Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;)V

    goto :goto_0

    .line 92
    :cond_1
    return-void
.end method

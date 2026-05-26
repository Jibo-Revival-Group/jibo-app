.class public Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;
.super Ljava/lang/Object;
.source "SmartSqlHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper$SmartSqlException;
    }
.end annotation


# static fields
.field public static final a:Ljava/util/regex/Pattern;

.field private static b:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lnet/sqlcipher/database/SQLiteDatabase;",
            "Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 46
    const-string v0, "\\{([^}]+)\\}"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;->a:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static declared-synchronized a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;
    .locals 3

    .prologue
    .line 56
    const-class v1, Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;->b:Ljava/util/Map;

    if-nez v0, :cond_0

    .line 57
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;->b:Ljava/util/Map;

    .line 59
    :cond_0
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;->b:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;

    .line 60
    if-nez v0, :cond_1

    .line 61
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;

    invoke-direct {v0}, Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;-><init>()V

    .line 62
    sget-object v2, Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;->b:Ljava/util/Map;

    invoke-interface {v2, p0, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 64
    :cond_1
    monitor-exit v1

    return-object v0

    .line 56
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;I)Ljava/lang/String;
    .locals 3

    .prologue
    .line 165
    invoke-static {p1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->h(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 166
    if-nez v0, :cond_0

    .line 167
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown soup "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1, p3}, Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;->a(Ljava/lang/String;I)V

    .line 169
    :cond_0
    return-object v0
.end method

.method private a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    .locals 2

    .prologue
    .line 155
    const/4 v0, 0x0

    .line 157
    :try_start_0
    invoke-static {p1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v1

    invoke-virtual {v1, p1, p2, p3}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 161
    :goto_0
    return-object v0

    .line 158
    :catch_0
    move-exception v1

    .line 159
    invoke-virtual {v1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore$SmartStoreException;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1, p4}, Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;->a(Ljava/lang/String;I)V

    goto :goto_0
.end method

.method private a(Ljava/lang/String;I)V
    .locals 3

    .prologue
    .line 173
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper$SmartSqlException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " at character "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper$SmartSqlException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;
    .locals 13

    .prologue
    const/4 v12, 0x2

    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 84
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 85
    const-string v3, "insert"

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    const-string v3, "update"

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    const-string v3, "delete"

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 86
    :cond_0
    new-instance v0, Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper$SmartSqlException;

    const-string v1, "Only SELECT are supported"

    invoke-direct {v0, v1}, Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper$SmartSqlException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 90
    :cond_1
    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3}, Ljava/lang/StringBuffer;-><init>()V

    .line 91
    sget-object v0, Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;->a:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p2}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v4

    .line 92
    :cond_2
    :goto_0
    invoke-virtual {v4}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    if-eqz v0, :cond_c

    .line 93
    invoke-virtual {v4}, Ljava/util/regex/Matcher;->group()Ljava/lang/String;

    move-result-object v5

    .line 94
    invoke-virtual {v4, v1}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v0

    .line 95
    invoke-virtual {v4}, Ljava/util/regex/Matcher;->start()I

    move-result v6

    .line 96
    const-string v7, ":"

    invoke-virtual {v0, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v7

    .line 97
    aget-object v8, v7, v2

    .line 98
    invoke-direct {p0, p1, v8, v6}, Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v9

    .line 99
    add-int/lit8 v0, v6, -0x1

    invoke-virtual {p2, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v10, 0x2e

    if-ne v0, v10, :cond_3

    move v0, v1

    .line 100
    :goto_1
    if-eqz v0, :cond_4

    const-string v0, ""

    .line 101
    :goto_2
    invoke-static {p1}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)Lcom/salesforce/androidsdk/smartstore/store/DBHelper;

    move-result-object v10

    invoke-virtual {v10, p1, v8}, Lcom/salesforce/androidsdk/smartstore/store/DBHelper;->f(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)Ljava/util/List;

    move-result-object v10

    const-string v11, "externalStorage"

    invoke-interface {v10, v11}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v10

    .line 104
    array-length v11, v7

    if-ne v11, v1, :cond_5

    .line 105
    invoke-virtual {v4, v3, v9}, Ljava/util/regex/Matcher;->appendReplacement(Ljava/lang/StringBuffer;Ljava/lang/String;)Ljava/util/regex/Matcher;

    goto :goto_0

    :cond_3
    move v0, v2

    .line 99
    goto :goto_1

    .line 100
    :cond_4
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v10, "."

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_2

    .line 106
    :cond_5
    array-length v11, v7

    if-ne v11, v12, :cond_b

    .line 107
    aget-object v5, v7, v1

    .line 110
    const-string v7, "_soup"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_7

    .line 111
    if-eqz v10, :cond_6

    .line 113
    const-string v5, "\'%s\' as \'%s\', %s%s as \'%s\'"

    const/4 v6, 0x5

    new-array v6, v6, [Ljava/lang/Object;

    aput-object v9, v6, v2

    const-string v7, "externalStorage"

    aput-object v7, v6, v1

    aput-object v0, v6, v12

    const/4 v0, 0x3

    const-string v7, "id"

    aput-object v7, v6, v0

    const/4 v0, 0x4

    const-string v7, "_soupEntryId"

    aput-object v7, v6, v0

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 114
    invoke-virtual {v4, v3, v0}, Ljava/util/regex/Matcher;->appendReplacement(Ljava/lang/StringBuffer;Ljava/lang/String;)Ljava/util/regex/Matcher;

    goto/16 :goto_0

    .line 116
    :cond_6
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, "soup"

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v3, v0}, Ljava/util/regex/Matcher;->appendReplacement(Ljava/lang/StringBuffer;Ljava/lang/String;)Ljava/util/regex/Matcher;

    goto/16 :goto_0

    .line 120
    :cond_7
    const-string v7, "_soupEntryId"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_8

    .line 121
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, "id"

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v3, v0}, Ljava/util/regex/Matcher;->appendReplacement(Ljava/lang/StringBuffer;Ljava/lang/String;)Ljava/util/regex/Matcher;

    goto/16 :goto_0

    .line 124
    :cond_8
    const-string v7, "_soupCreatedDate"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_9

    .line 125
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, "created"

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v3, v0}, Ljava/util/regex/Matcher;->appendReplacement(Ljava/lang/StringBuffer;Ljava/lang/String;)Ljava/util/regex/Matcher;

    goto/16 :goto_0

    .line 128
    :cond_9
    const-string v7, "_soupLastModifiedDate"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_a

    .line 129
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, "lastModified"

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v3, v0}, Ljava/util/regex/Matcher;->appendReplacement(Ljava/lang/StringBuffer;Ljava/lang/String;)Ljava/util/regex/Matcher;

    goto/16 :goto_0

    .line 133
    :cond_a
    invoke-direct {p0, p1, v8, v5, v6}, Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    .line 134
    const-string v5, "$"

    const-string v6, "\\$"

    invoke-virtual {v0, v5, v6}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v3, v0}, Ljava/util/regex/Matcher;->appendReplacement(Ljava/lang/StringBuffer;Ljava/lang/String;)Ljava/util/regex/Matcher;

    goto/16 :goto_0

    .line 136
    :cond_b
    array-length v0, v7

    if-le v0, v12, :cond_2

    .line 137
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Invalid soup/path reference "

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0, v6}, Lcom/salesforce/androidsdk/smartstore/store/SmartSqlHelper;->a(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 140
    :cond_c
    invoke-virtual {v4, v3}, Ljava/util/regex/Matcher;->appendTail(Ljava/lang/StringBuffer;)Ljava/lang/StringBuffer;

    .line 143
    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    .line 148
    const-string v1, "([^ ]+)\\.json_extract\\(soup"

    const-string v2, "json_extract($1.soup"

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 151
    return-object v0
.end method

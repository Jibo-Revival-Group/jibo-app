.class Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;
.super Ljava/lang/Object;
.source "DbHelper.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/LogoutListener;


# static fields
.field private static final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;


# instance fields
.field private final b:Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;

.field private final c:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 44
    const-class v0, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    sput-object v0, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    return-void
.end method

.method constructor <init>(Ljava/lang/String;Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;)V
    .locals 1

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    iput-object p2, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->b:Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;

    .line 50
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->b:Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;

    invoke-interface {v0, p0}, Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;->a(Lcom/salesforce/android/knowledge/core/LogoutListener;)V

    .line 51
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->c:Ljava/lang/String;

    .line 52
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->b:Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;->a()Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    move-result-object v0

    invoke-direct {p0, v0, p1}, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->a(Lcom/salesforce/androidsdk/smartstore/store/SmartStore;Ljava/lang/String;)V

    .line 53
    return-void
.end method

.method private a(ILjava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/SmartStore;)V
    .locals 5

    .prologue
    .line 151
    const-string v0, "DbVersionInfo"

    invoke-virtual {p3, v0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->b(Ljava/lang/String;)V

    .line 152
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 154
    :try_start_0
    const-string v1, "Locale"

    invoke-virtual {v0, v1, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 155
    const-string v1, "InstalledVersion"

    invoke-virtual {v0, v1, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 156
    const-string v1, "DbVersionInfo"

    const-string v2, "InstalledVersion"

    invoke-virtual {p3, v1, v0, v2}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 160
    :goto_0
    return-void

    .line 157
    :catch_0
    move-exception v0

    .line 158
    sget-object v1, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Error writing DB meta data. Upgrade/Downgrade of DB will not be supported, {}"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v0}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v3, v4

    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private a(Lcom/salesforce/androidsdk/smartstore/store/SmartStore;Ljava/lang/String;)V
    .locals 6

    .prologue
    const/4 v3, 0x1

    const/4 v5, 0x0

    const/16 v4, 0x9

    .line 112
    :try_start_0
    const-string v0, "DbVersionInfo"

    sget-object v1, Lcom/salesforce/android/knowledge/core/internal/db/DbContract$DbMeta;->a:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    invoke-virtual {p1, v0, v1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Ljava/lang/String;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 122
    :goto_0
    :try_start_1
    const-string v0, "DbVersionInfo"

    const-string v1, "InstalledVersion"

    sget-object v2, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;->ascending:Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;

    const/4 v3, 0x1

    invoke-static {v0, v1, v2, v3}, Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;->a(Ljava/lang/String;Ljava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/QuerySpec$Order;I)Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Lcom/salesforce/androidsdk/smartstore/store/QuerySpec;I)Lorg/json/JSONArray;

    move-result-object v0

    .line 124
    const/16 v1, 0x9

    invoke-direct {p0, v1, p2, p1}, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->a(ILjava/lang/String;Lcom/salesforce/androidsdk/smartstore/store/SmartStore;)V

    .line 127
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-nez v1, :cond_0

    .line 128
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 148
    :goto_1
    return-void

    .line 114
    :catch_0
    move-exception v0

    .line 116
    sget-object v1, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Error setting up db, deleting any cached data. {}"

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v3, v5

    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->e(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 117
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->b:Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;->c()V

    .line 118
    const-string v0, "DbVersionInfo"

    sget-object v1, Lcom/salesforce/android/knowledge/core/internal/db/DbContract$DbMeta;->a:[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;

    invoke-virtual {p1, v0, v1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a(Ljava/lang/String;[Lcom/salesforce/androidsdk/smartstore/store/IndexSpec;)V

    goto :goto_0

    .line 133
    :cond_0
    const/4 v1, 0x0

    :try_start_2
    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    .line 134
    const-string v1, "InstalledVersion"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v1

    .line 135
    const-string v2, "Locale"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 136
    if-lt v1, v4, :cond_1

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 138
    :cond_1
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v0

    const/16 v2, 0x9

    invoke-virtual {p0, v0, v1, v2}, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;II)V
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_1

    .line 144
    :catch_1
    move-exception v0

    .line 146
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v0

    invoke-virtual {p0, v0, v5, v4}, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;II)V

    goto :goto_1

    .line 139
    :cond_2
    if-le v1, v4, :cond_3

    .line 140
    :try_start_3
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v0

    const/16 v2, 0x9

    invoke-virtual {p0, v0, v1, v2}, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->b(Lnet/sqlcipher/database/SQLiteDatabase;II)V

    goto :goto_1

    .line 142
    :cond_3
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)V
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_1
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 163
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->b:Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;->a()Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->c:Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->a(Lcom/salesforce/androidsdk/smartstore/store/SmartStore;Ljava/lang/String;)V

    .line 164
    return-void
.end method

.method public a(Lnet/sqlcipher/database/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 56
    monitor-enter p1

    .line 57
    :try_start_0
    invoke-static {p1}, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation;->a(Lnet/sqlcipher/database/SQLiteDatabase;)V

    .line 58
    invoke-static {p1}, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryOperation;->a(Lnet/sqlcipher/database/SQLiteDatabase;)V

    .line 59
    invoke-static {p1}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->a(Lnet/sqlcipher/database/SQLiteDatabase;)V

    .line 60
    invoke-static {p1}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleMappingOperation;->a(Lnet/sqlcipher/database/SQLiteDatabase;)V

    .line 61
    monitor-exit p1

    .line 62
    return-void

    .line 61
    :catchall_0
    move-exception v0

    monitor-exit p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public a(Lnet/sqlcipher/database/SQLiteDatabase;II)V
    .locals 1

    .prologue
    .line 65
    monitor-enter p1

    .line 67
    :try_start_0
    invoke-static {p1}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleMappingOperation;->b(Lnet/sqlcipher/database/SQLiteDatabase;)V

    .line 68
    invoke-static {p1}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->b(Lnet/sqlcipher/database/SQLiteDatabase;)V

    .line 69
    invoke-static {p1}, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryOperation;->b(Lnet/sqlcipher/database/SQLiteDatabase;)V

    .line 70
    invoke-static {p1}, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation;->b(Lnet/sqlcipher/database/SQLiteDatabase;)V

    .line 71
    monitor-exit p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 73
    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)V

    .line 75
    return-void

    .line 71
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit p1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public b()Lnet/sqlcipher/database/SQLiteDatabase;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->b:Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;

    invoke-interface {v0}, Lcom/salesforce/android/knowledge/core/internal/utils/MobileSdkUserManager;->a()Lcom/salesforce/androidsdk/smartstore/store/SmartStore;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/smartstore/store/SmartStore;->a()Lnet/sqlcipher/database/SQLiteDatabase;

    move-result-object v0

    return-object v0
.end method

.method public b(Lnet/sqlcipher/database/SQLiteDatabase;II)V
    .locals 1

    .prologue
    .line 79
    monitor-enter p1

    .line 80
    :try_start_0
    invoke-static {p1}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleMappingOperation;->b(Lnet/sqlcipher/database/SQLiteDatabase;)V

    .line 81
    invoke-static {p1}, Lcom/salesforce/android/knowledge/core/internal/db/ArticleOperation;->b(Lnet/sqlcipher/database/SQLiteDatabase;)V

    .line 82
    invoke-static {p1}, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryOperation;->b(Lnet/sqlcipher/database/SQLiteDatabase;)V

    .line 83
    invoke-static {p1}, Lcom/salesforce/android/knowledge/core/internal/db/DataCategoryGroupOperation;->b(Lnet/sqlcipher/database/SQLiteDatabase;)V

    .line 84
    monitor-exit p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 86
    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/core/internal/db/DbHelper;->a(Lnet/sqlcipher/database/SQLiteDatabase;)V

    .line 87
    return-void

    .line 84
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit p1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.class public Lcom/jibo/service/KeyRequestingSharingService;
.super Landroid/app/IntentService;
.source "KeyRequestingSharingService.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private b:Lcom/jibo/aws/integration/aws/services/account/model/Account;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 43
    const-class v0, Lcom/jibo/service/KeyRequestingSharingService;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/service/KeyRequestingSharingService;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 57
    sget-object v0, Lcom/jibo/service/KeyRequestingSharingService;->a:Ljava/lang/String;

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 58
    return-void
.end method

.method private a()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 152
    .line 154
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/service/KeyRequestingSharingService;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/16 v1, 0x8

    invoke-static {v1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v1

    sget-object v2, Lcom/jibo/db/DatabaseContract$EntityEntry;->a:[Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 159
    if-eqz v0, :cond_2

    :try_start_1
    invoke-interface {v0}, Landroid/database/Cursor;->isClosed()Z

    move-result v1

    if-nez v1, :cond_2

    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 160
    :goto_0
    invoke-interface {v0}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v1

    if-nez v1, :cond_2

    .line 162
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    .line 164
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberAccepted(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 166
    invoke-virtual {p0}, Lcom/jibo/service/KeyRequestingSharingService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v2, v1}, Lcom/jibo/service/KeyRequestingSharingService;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 168
    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_0

    .line 171
    :catch_0
    move-exception v1

    .line 174
    :goto_1
    if-eqz v0, :cond_1

    .line 175
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 179
    :cond_1
    :goto_2
    return-void

    .line 174
    :cond_2
    if-eqz v0, :cond_1

    .line 175
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_2

    .line 174
    :catchall_0
    move-exception v0

    :goto_3
    if-eqz v6, :cond_3

    .line 175
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 177
    :cond_3
    throw v0

    .line 174
    :catchall_1
    move-exception v1

    move-object v6, v0

    move-object v0, v1

    goto :goto_3

    .line 171
    :catch_1
    move-exception v0

    move-object v0, v6

    goto :goto_1
.end method

.method public static a(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 61
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/jibo/service/KeyRequestingSharingService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 62
    const-string v1, "ACTION_CHECK_ALL_LOOPS"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 63
    invoke-static {p0, v0}, Lcom/jibo/utils/ServiceUtils;->a(Landroid/content/Context;Landroid/content/Intent;)V

    .line 64
    return-void
.end method

.method private a(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 137
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/service/KeyRequestingSharingService;->b:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 138
    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v1

    .line 137
    invoke-static {v0, v1}, Lcom/jibo/aws/integration/util/KeyManager;->getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;

    move-result-object v0

    .line 138
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1, p2}, Lcom/jibo/aws/integration/util/KeyManager;->obtainKeyHolder(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager$SymmetricKeyHolder;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 140
    if-eqz v0, :cond_0

    .line 149
    :goto_0
    return-void

    .line 141
    :catch_0
    move-exception v0

    .line 142
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    .line 145
    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/jibo/service/KeyRequestingSharingService;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 146
    const-string v1, "ACTION_REQUEST_KEY"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 147
    const-string v1, "loopId"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 148
    invoke-static {p1, v0}, Lcom/jibo/utils/ServiceUtils;->a(Landroid/content/Context;Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;Ljava/util/Map;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 73
    new-instance v1, Landroid/content/Intent;

    const-class v0, Lcom/jibo/service/KeyRequestingSharingService;

    invoke-direct {v1, p0, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 74
    const-string v0, "ACTION_KEY_REQUESTED"

    invoke-virtual {v1, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 75
    const-string v2, "loopId"

    const-string v0, "loopId"

    .line 76
    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 75
    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 77
    invoke-static {p0, v1}, Lcom/jibo/utils/ServiceUtils;->a(Landroid/content/Context;Landroid/content/Intent;)V

    .line 78
    return-void
.end method

.method private a(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 188
    const-string v0, "loopId"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 190
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 219
    :cond_0
    :goto_0
    return-void

    .line 193
    :cond_1
    const v1, 0x7f100037

    :try_start_0
    invoke-virtual {p0, v1}, Lcom/jibo/service/KeyRequestingSharingService;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Lcom/jibo/service/KeyRequestingSharingService;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 196
    const-string v2, "PREF_PUSH_SERVICE_TOKEN"

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 197
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 198
    const-wide/16 v2, 0x7d0

    invoke-static {v2, v3}, Ljava/lang/Thread;->sleep(J)V

    .line 201
    :cond_2
    const-string v2, "PREF_PUSH_SERVICE_TOKEN"

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 202
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 205
    invoke-virtual {p0}, Lcom/jibo/service/KeyRequestingSharingService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/service/KeyRequestingSharingService;->b:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/jibo/aws/integration/util/KeyManager;->getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;

    move-result-object v1

    .line 206
    invoke-virtual {p0}, Lcom/jibo/service/KeyRequestingSharingService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/db/EntityData;->d()Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;

    move-result-object v2

    .line 207
    invoke-virtual {v1}, Lcom/jibo/aws/integration/util/KeyManager;->getPublicKeyForSharing()Ljava/lang/String;

    move-result-object v3

    .line 206
    invoke-virtual {v2, v0, v3}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->createRequest(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/key/model/Request;

    move-result-object v2

    .line 212
    if-eqz v2, :cond_0

    .line 214
    invoke-direct {p0, v1, v2, v0}, Lcom/jibo/service/KeyRequestingSharingService;->a(Lcom/jibo/aws/integration/util/KeyManager;Lcom/jibo/aws/integration/aws/services/key/model/Request;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 216
    :catch_0
    move-exception v0

    .line 217
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private a(Lcom/jibo/aws/integration/util/KeyManager;Lcom/jibo/aws/integration/aws/services/key/model/Request;Ljava/lang/String;)V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/security/NoSuchAlgorithmException;,
            Ljava/security/InvalidKeyException;,
            Ljava/security/SignatureException;,
            Ljavax/crypto/NoSuchPaddingException;,
            Ljavax/crypto/BadPaddingException;,
            Ljava/security/KeyStoreException;,
            Ljava/security/NoSuchProviderException;,
            Ljavax/crypto/IllegalBlockSizeException;
        }
    .end annotation

    .prologue
    .line 291
    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/key/model/Request;->getEncryptedKey()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 293
    invoke-virtual {p0}, Lcom/jibo/service/KeyRequestingSharingService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/key/model/Request;->getEncryptedKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, p3, v1}, Lcom/jibo/aws/integration/util/KeyManager;->saveSymmetricKey(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 296
    invoke-virtual {p0}, Lcom/jibo/service/KeyRequestingSharingService;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const/16 v1, 0x8

    invoke-static {v1}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 298
    invoke-static {p0}, Landroid/support/v4/content/LocalBroadcastManager;->a(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v0

    .line 299
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 300
    const-string v2, "ACTION_KEY_SAVED"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 301
    const-string v2, "loopId"

    invoke-virtual {v1, v2, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 302
    invoke-virtual {v0, v1}, Landroid/support/v4/content/LocalBroadcastManager;->a(Landroid/content/Intent;)Z

    .line 304
    :cond_0
    return-void
.end method

.method public static b(Landroid/content/Context;Ljava/util/Map;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 87
    new-instance v1, Landroid/content/Intent;

    const-class v0, Lcom/jibo/service/KeyRequestingSharingService;

    invoke-direct {v1, p0, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 88
    const-string v0, "ACTION_KEY_SHARED"

    invoke-virtual {v1, v0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 89
    const-string v2, "loopId"

    const-string v0, "loopId"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 90
    const-string v2, "id"

    const-string v0, "id"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 91
    invoke-static {p0, v1}, Lcom/jibo/utils/ServiceUtils;->a(Landroid/content/Context;Landroid/content/Intent;)V

    .line 92
    return-void
.end method

.method private b(Landroid/os/Bundle;)V
    .locals 6

    .prologue
    .line 228
    const-string v0, "loopId"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 231
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 258
    :cond_0
    :goto_0
    return-void

    .line 235
    :cond_1
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/service/KeyRequestingSharingService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/service/KeyRequestingSharingService;->b:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 236
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v2

    .line 235
    invoke-static {v1, v2}, Lcom/jibo/aws/integration/util/KeyManager;->getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;

    move-result-object v1

    .line 236
    invoke-virtual {p0}, Lcom/jibo/service/KeyRequestingSharingService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lcom/jibo/aws/integration/util/KeyManager;->obtainKeyHolder(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager$SymmetricKeyHolder;

    move-result-object v1

    .line 238
    invoke-virtual {p0}, Lcom/jibo/service/KeyRequestingSharingService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    move-result-object v2

    .line 240
    :try_start_1
    invoke-virtual {v2}, Lcom/jibo/db/EntityData;->d()Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->listIncomingRequests(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 241
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/key/model/Request;

    .line 243
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/key/model/Request;->getPublicKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/jibo/aws/integration/util/KeyManager$SymmetricKeyHolder;->shareSymmetricKey(Ljava/lang/String;)Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v4

    .line 246
    :try_start_2
    invoke-virtual {v2}, Lcom/jibo/db/EntityData;->d()Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;

    move-result-object v5

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/key/model/Request;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v5, v0, v4}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->share(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/key/model/Request;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_1

    .line 247
    :catch_0
    move-exception v0

    .line 248
    :try_start_3
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_1

    .line 251
    :catch_1
    move-exception v0

    .line 252
    :try_start_4
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    goto :goto_0

    .line 255
    :catch_2
    move-exception v0

    .line 256
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private c(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 267
    if-nez p1, :cond_1

    .line 286
    :cond_0
    :goto_0
    return-void

    .line 269
    :cond_1
    const-string v0, "loopId"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 270
    const-string v1, "id"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 273
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 277
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/service/KeyRequestingSharingService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/db/EntityData;->d()Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->getRequest(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/key/model/Request;

    move-result-object v1

    .line 278
    if-eqz v1, :cond_0

    .line 281
    invoke-virtual {p0}, Lcom/jibo/service/KeyRequestingSharingService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/service/KeyRequestingSharingService;->b:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/jibo/aws/integration/util/KeyManager;->getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;

    move-result-object v2

    invoke-direct {p0, v2, v1, v0}, Lcom/jibo/service/KeyRequestingSharingService;->a(Lcom/jibo/aws/integration/util/KeyManager;Lcom/jibo/aws/integration/aws/services/key/model/Request;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 283
    :catch_0
    move-exception v0

    .line 284
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method


# virtual methods
.method public onCreate()V
    .locals 0

    .prologue
    .line 97
    invoke-super {p0}, Landroid/app/IntentService;->onCreate()V

    .line 98
    invoke-static {p0}, Lcom/jibo/utils/ServiceUtils;->a(Landroid/app/Service;)V

    .line 99
    return-void
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 104
    invoke-super {p0}, Landroid/app/IntentService;->onDestroy()V

    .line 105
    invoke-static {p0}, Lcom/jibo/utils/ServiceUtils;->b(Landroid/app/Service;)V

    .line 106
    return-void
.end method

.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 2

    .prologue
    .line 111
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/service/KeyRequestingSharingService;->b:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 113
    const-string v0, "ACTION_CHECK_ALL_LOOPS"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 114
    invoke-direct {p0}, Lcom/jibo/service/KeyRequestingSharingService;->a()V

    .line 122
    :cond_0
    :goto_0
    return-void

    .line 115
    :cond_1
    const-string v0, "ACTION_REQUEST_KEY"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 116
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/jibo/service/KeyRequestingSharingService;->a(Landroid/os/Bundle;)V

    goto :goto_0

    .line 117
    :cond_2
    const-string v0, "ACTION_KEY_REQUESTED"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 118
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/jibo/service/KeyRequestingSharingService;->b(Landroid/os/Bundle;)V

    goto :goto_0

    .line 119
    :cond_3
    const-string v0, "ACTION_KEY_SHARED"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 120
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/jibo/service/KeyRequestingSharingService;->c(Landroid/os/Bundle;)V

    goto :goto_0
.end method

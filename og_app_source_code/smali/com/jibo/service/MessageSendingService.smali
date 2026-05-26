.class public Lcom/jibo/service/MessageSendingService;
.super Landroid/app/IntentService;
.source "MessageSendingService.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private b:Lcom/jibo/aws/integration/aws/services/account/model/Account;

.field private c:Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 40
    const-class v0, Lcom/jibo/service/MessageSendingService;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/service/MessageSendingService;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 53
    sget-object v0, Lcom/jibo/service/MessageSendingService;->a:Ljava/lang/String;

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 50
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/service/MessageSendingService;->c:Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    .line 54
    return-void
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 180
    invoke-static {p1, p2, p4, p5}, Lcom/jibo/utils/ImageUtils;->a(Ljava/lang/String;Ljava/lang/String;II)V

    .line 183
    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 184
    const/4 v1, 0x1

    iput-boolean v1, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 185
    invoke-static {p2, v0}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 186
    new-instance v1, Lcom/google/gson/JsonObject;

    invoke-direct {v1}, Lcom/google/gson/JsonObject;-><init>()V

    .line 187
    const-string v2, "mime-type"

    iget-object v0, v0, Landroid/graphics/BitmapFactory$Options;->outMimeType:Ljava/lang/String;

    invoke-virtual {v1, v2, v0}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 189
    new-instance v0, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;

    invoke-direct {v0}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;-><init>()V

    .line 190
    invoke-virtual {v0, p3}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;->setType(Ljava/lang/String;)V

    .line 191
    invoke-virtual {v0, p2}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;->setUrl(Ljava/lang/String;)V

    .line 192
    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;->setMeta(Lcom/google/gson/JsonObject;)V

    .line 194
    return-object v0
.end method

.method private a(Ljava/io/File;Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Ljava/io/File;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljavax/crypto/NoSuchPaddingException;,
            Ljava/security/NoSuchAlgorithmException;,
            Ljava/io/IOException;,
            Ljavax/crypto/BadPaddingException;,
            Ljavax/crypto/IllegalBlockSizeException;,
            Ljava/security/InvalidKeyException;,
            Ljava/security/InvalidAlgorithmParameterException;,
            Lcom/jibo/aws/integration/util/KeyManager$NoKeyForLoopException;
        }
    .end annotation

    .prologue
    .line 249
    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->isEncrypted()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_0

    .line 256
    :goto_0
    return-object p1

    .line 251
    :cond_0
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 252
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 253
    invoke-virtual {p0}, Lcom/jibo/service/MessageSendingService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/service/MessageSendingService;->b:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 254
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v2

    .line 253
    invoke-static {v1, v2}, Lcom/jibo/aws/integration/util/KeyManager;->getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;

    move-result-object v1

    .line 254
    invoke-virtual {p0}, Lcom/jibo/service/MessageSendingService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getLoopId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/jibo/aws/integration/util/KeyManager;->obtainKeyHolder(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager$SymmetricKeyHolder;

    move-result-object v1

    .line 255
    invoke-virtual {v1, p1, v0}, Lcom/jibo/aws/integration/util/KeyManager$SymmetricKeyHolder;->encodeFile(Ljava/io/File;Ljava/io/File;)V

    .line 256
    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v1, v2, v4

    if-lez v1, :cond_1

    :goto_1
    move-object p1, v0

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private a(Lcom/jibo/aws/integration/aws/services/jot/model/Message;Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;)V
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljavax/crypto/NoSuchPaddingException;,
            Ljava/security/InvalidAlgorithmParameterException;,
            Ljava/security/NoSuchAlgorithmException;,
            Ljava/io/IOException;,
            Ljavax/crypto/BadPaddingException;,
            Ljavax/crypto/IllegalBlockSizeException;,
            Lcom/jibo/aws/integration/util/KeyManager$NoKeyForLoopException;,
            Ljava/security/InvalidKeyException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 218
    if-nez p2, :cond_0

    new-instance v0, Lcom/amazonaws/services/cognitoidentity/model/InvalidParameterException;

    const-string v1, "messagePart cant be null"

    invoke-direct {v0, v1}, Lcom/amazonaws/services/cognitoidentity/model/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 221
    :cond_0
    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;->getUrl()Ljava/lang/String;

    move-result-object v0

    const-string v1, "http"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 223
    new-instance v0, Ljava/io/File;

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, v0, p1}, Lcom/jibo/service/MessageSendingService;->a(Ljava/io/File;Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Ljava/io/File;

    move-result-object v5

    .line 224
    iget-object v0, p0, Lcom/jibo/service/MessageSendingService;->c:Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getLoopId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;->getType()Ljava/lang/String;

    move-result-object v2

    if-eqz p3, :cond_2

    .line 225
    invoke-virtual {p3}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;->getPath()Ljava/lang/String;

    move-result-object v3

    :goto_0
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->isEncrypted()Ljava/lang/Boolean;

    move-result-object v6

    .line 224
    invoke-virtual/range {v0 .. v6}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;->create(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/lang/Boolean;)Lcom/jibo/aws/integration/aws/services/media/model/Media;

    move-result-object v0

    .line 227
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;->setUrl(Ljava/lang/String;)V

    .line 228
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/model/Media;->getPath()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;->setPath(Ljava/lang/String;)V

    .line 230
    :cond_1
    return-void

    :cond_2
    move-object v3, v4

    .line 225
    goto :goto_0
.end method


# virtual methods
.method public onCreate()V
    .locals 0

    .prologue
    .line 92
    invoke-super {p0}, Landroid/app/IntentService;->onCreate()V

    .line 93
    invoke-static {p0}, Lcom/jibo/utils/ServiceUtils;->a(Landroid/app/Service;)V

    .line 94
    return-void
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 99
    invoke-super {p0}, Landroid/app/IntentService;->onDestroy()V

    .line 100
    invoke-static {p0}, Lcom/jibo/utils/ServiceUtils;->b(Landroid/app/Service;)V

    .line 101
    return-void
.end method

.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 11

    .prologue
    .line 105
    const-string v0, "EXTRA_MESSAGE"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    move-object v6, v0

    check-cast v6, Lcom/jibo/aws/integration/aws/services/jot/model/Message;

    .line 107
    if-nez v6, :cond_1

    .line 164
    :cond_0
    :goto_0
    return-void

    .line 109
    :cond_1
    invoke-virtual {v6}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getId()Ljava/lang/String;

    move-result-object v9

    .line 112
    :try_start_0
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/service/MessageSendingService;->b:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 114
    invoke-static {v6}, Lcom/jibo/aws/integration/helpers/JotHelper;->hasPhoto(Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 115
    new-instance v0, Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    new-instance v1, Lcom/amazonaws/auth/BasicAWSCredentials;

    iget-object v2, p0, Lcom/jibo/service/MessageSendingService;->b:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 116
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/service/MessageSendingService;->b:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v0, p0, Lcom/jibo/service/MessageSendingService;->c:Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    .line 118
    invoke-static {v6}, Lcom/jibo/aws/integration/helpers/JotHelper;->getPhoto(Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;

    move-result-object v10

    .line 119
    invoke-static {v6}, Lcom/jibo/aws/integration/helpers/JotHelper;->getThumbnail(Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;

    move-result-object v0

    .line 120
    invoke-static {v6}, Lcom/jibo/aws/integration/helpers/JotHelper;->getRobotThumbnail(Lcom/jibo/aws/integration/aws/services/jot/model/Message;)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;

    move-result-object v7

    .line 122
    if-eqz v10, :cond_3

    .line 123
    invoke-virtual {v10}, Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;->getUrl()Ljava/lang/String;

    move-result-object v1

    .line 126
    if-nez v0, :cond_2

    .line 127
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ".thumb"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "thumb"

    const/16 v4, 0x2d0

    const/16 v5, 0x195

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/jibo/service/MessageSendingService;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;

    move-result-object v0

    .line 130
    invoke-virtual {v6}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getParts()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_2
    move-object v8, v0

    .line 133
    if-nez v7, :cond_5

    .line 134
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ".robot_thumb"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "thumb_robot"

    const/16 v4, 0x14a

    const/16 v5, 0x14a

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/jibo/service/MessageSendingService;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;

    move-result-object v0

    .line 138
    invoke-virtual {v6}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->getParts()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 142
    :goto_1
    const/4 v1, 0x0

    invoke-direct {p0, v6, v10, v1}, Lcom/jibo/service/MessageSendingService;->a(Lcom/jibo/aws/integration/aws/services/jot/model/Message;Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;)V

    .line 144
    invoke-direct {p0, v6, v8, v10}, Lcom/jibo/service/MessageSendingService;->a(Lcom/jibo/aws/integration/aws/services/jot/model/Message;Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;)V

    .line 146
    invoke-direct {p0, v6, v0, v10}, Lcom/jibo/service/MessageSendingService;->a(Lcom/jibo/aws/integration/aws/services/jot/model/Message;Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 160
    :cond_3
    iget-object v0, p0, Lcom/jibo/service/MessageSendingService;->c:Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    if-eqz v0, :cond_0

    .line 161
    iget-object v0, p0, Lcom/jibo/service/MessageSendingService;->c:Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;->shutdown()V

    goto/16 :goto_0

    .line 153
    :catch_0
    move-exception v0

    .line 154
    :try_start_1
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    .line 157
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "TEMP_FAILED_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Lcom/jibo/aws/integration/aws/services/jot/model/Message;->setId(Ljava/lang/String;)V

    .line 158
    invoke-static {p0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0, v6, v9}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/aws/services/jot/model/Message;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 160
    iget-object v0, p0, Lcom/jibo/service/MessageSendingService;->c:Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    if-eqz v0, :cond_0

    .line 161
    iget-object v0, p0, Lcom/jibo/service/MessageSendingService;->c:Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;->shutdown()V

    goto/16 :goto_0

    .line 160
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/jibo/service/MessageSendingService;->c:Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    if-eqz v1, :cond_4

    .line 161
    iget-object v1, p0, Lcom/jibo/service/MessageSendingService;->c:Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;->shutdown()V

    :cond_4
    throw v0

    :cond_5
    move-object v0, v7

    goto :goto_1
.end method

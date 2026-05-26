.class public Lcom/jibo/aws/integration/util/Commons;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/aws/integration/util/Commons$AsyncCallback;
    }
.end annotation


# static fields
.field public static final ALLOWED_ENDPOINTS:[Ljava/lang/String;

.field public static final ALPHA_ENDPOINT:Ljava/lang/String; = "alpha-entrypoint.jibo.com"

.field public static final API_ENDPOINT:Ljava/lang/String; = "api.jibo.com"

.field public static final DEFAULT_DOMAIN:Ljava/lang/String; = "jibo.com"

.field public static final DEV_ENDPOINT:Ljava/lang/String; = "dev-entrypoint.jibo.com"

.field public static final EMAIL_ADDRESS_PATTERN:Ljava/util/regex/Pattern;

.field public static final MAX_LOOP_MEMBERS:I = 0x10

.field public static final NETPOSA_1_ENDPOINT:Ljava/lang/String; = "https://jibo-dev.ling.cn"

.field public static final NETPOSA_2_ENDPOINT:Ljava/lang/String; = "https://jibo.ling.cn"

.field public static final REAL_NUMBER_PATTERN:Ljava/util/regex/Pattern;

.field public static ROOT_ENDPOINT:Ljava/lang/String; = null

.field public static final STG_ENDPOINT:Ljava/lang/String; = "stg-entrypoint.jibo.com"

.field public static final TARGET_PREFIX_ACCOUNT:Ljava/lang/String; = "Account_20151111."

.field public static final TARGET_PREFIX_ACCOUNT_ADMIN:Ljava/lang/String; = "Account_20151111."

.field public static final TARGET_PREFIX_AUDIO:Ljava/lang/String; = "Audio_20151103."

.field public static final TARGET_PREFIX_BINARY:Ljava/lang/String; = "Binary_20151201."

.field public static final TARGET_PREFIX_COLLISION:Ljava/lang/String; = "Collision_20161126."

.field public static final TARGET_PREFIX_GQA:Ljava/lang/String; = "GQA_20160930s."

.field public static final TARGET_PREFIX_JOT:Ljava/lang/String; = "Jot_20160126."

.field public static final TARGET_PREFIX_KEY:Ljava/lang/String; = "Key_20160201."

.field public static final TARGET_PREFIX_LOOP:Ljava/lang/String; = "Loop_20160324."

.field public static final TARGET_PREFIX_MEDIA:Ljava/lang/String; = "Media_20160725."

.field public static final TARGET_PREFIX_NOTIFICATION:Ljava/lang/String; = "Notification_20150505."

.field public static final TARGET_PREFIX_OOBE:Ljava/lang/String; = "OOBE_20161026."

.field public static final TARGET_PREFIX_PERSON:Ljava/lang/String; = "Person_20160801."

.field public static final TARGET_PREFIX_PHOTO:Ljava/lang/String; = "Photo_20151103."

.field public static final TARGET_PREFIX_PLACEHOLDER:Ljava/lang/String; = "$TARGET$."

.field public static final TARGET_PREFIX_PUSH:Ljava/lang/String; = "Push_20160729."

.field public static final TARGET_PREFIX_RELATIONSHIPS:Ljava/lang/String; = "Relationships_20160118."

.field public static final TARGET_PREFIX_ROBOT_PROPS:Ljava/lang/String; = "RobotProperties_20160225."

.field public static final TARGET_PREFIX_SKILLS:Ljava/lang/String; = "Settings_20171219."

.field public static final TARGET_PREFIX_SNAP:Ljava/lang/String; = "Snap_20160103."

.field public static final TARGET_PREFIX_VOICE_TRAINING:Ljava/lang/String; = "VoiceTraining_20151103."

.field public static _DEBUG_LOG_OUTPUT:Z


# direct methods
.method static constructor <clinit>()V
    .locals 3

    const/4 v2, 0x0

    sput-boolean v2, Lcom/jibo/aws/integration/util/Commons;->_DEBUG_LOG_OUTPUT:Z

    const/4 v0, 0x6

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "stg-entrypoint.jibo.com"

    aput-object v1, v0, v2

    const/4 v1, 0x1

    const-string v2, "dev-entrypoint.jibo.com"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "api.jibo.com"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "alpha-entrypoint.jibo.com"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "https://jibo-dev.ling.cn"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "https://jibo.ling.cn"

    aput-object v2, v0, v1

    sput-object v0, Lcom/jibo/aws/integration/util/Commons;->ALLOWED_ENDPOINTS:[Ljava/lang/String;

    const-string v0, "stg-entrypoint.jibo.com"

    sput-object v0, Lcom/jibo/aws/integration/util/Commons;->ROOT_ENDPOINT:Ljava/lang/String;

    const-string v0, "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/jibo/aws/integration/util/Commons;->EMAIL_ADDRESS_PATTERN:Ljava/util/regex/Pattern;

    const-string v0, "[+-]?(?=\\d*[.eE])(?=\\.?\\d)\\d*\\.?\\d*(?:[eE][+-]?\\d+)?"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/jibo/aws/integration/util/Commons;->REAL_NUMBER_PATTERN:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static convertStreamToString(Ljava/io/InputStream;)Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/util/Scanner;

    invoke-direct {v0, p0}, Ljava/util/Scanner;-><init>(Ljava/io/InputStream;)V

    const-string v1, "\\A"

    invoke-virtual {v0, v1}, Ljava/util/Scanner;->useDelimiter(Ljava/lang/String;)Ljava/util/Scanner;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Scanner;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Ljava/util/Scanner;->next()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public static setRootEndpoint(Ljava/lang/String;)V
    .locals 0

    sput-object p0, Lcom/jibo/aws/integration/util/Commons;->ROOT_ENDPOINT:Ljava/lang/String;

    return-void
.end method

.method public static streamToString(Ljava/io/InputStream;I)Ljava/lang/String;
    .locals 6

    new-array v2, p1, [C

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v1, 0x0

    :try_start_0
    new-instance v0, Ljava/io/InputStreamReader;

    const-string v4, "UTF-8"

    invoke-direct {v0, p0, v4}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_7
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :goto_0
    const/4 v1, 0x0

    :try_start_1
    array-length v4, v2

    invoke-virtual {v0, v2, v1, v4}, Ljava/io/InputStreamReader;->read([CII)I
    :try_end_1
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_6
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v1

    if-gez v1, :cond_1

    if-eqz v0, :cond_0

    :try_start_2
    invoke-virtual {v0}, Ljava/io/InputStreamReader;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_4

    :cond_0
    :goto_1
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_1
    const/4 v4, 0x0

    :try_start_3
    invoke-virtual {v3, v2, v4, v1}, Ljava/lang/StringBuilder;->append([CII)Ljava/lang/StringBuilder;
    :try_end_3
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_6
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    goto :goto_0

    :catch_0
    move-exception v1

    :goto_2
    if-eqz v0, :cond_0

    :try_start_4
    invoke-virtual {v0}, Ljava/io/InputStreamReader;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1

    goto :goto_1

    :catch_1
    move-exception v0

    goto :goto_1

    :catch_2
    move-exception v0

    move-object v0, v1

    :goto_3
    if-eqz v0, :cond_0

    :try_start_5
    invoke-virtual {v0}, Ljava/io/InputStreamReader;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    goto :goto_1

    :catch_3
    move-exception v0

    goto :goto_1

    :catchall_0
    move-exception v0

    :goto_4
    if-eqz v1, :cond_2

    :try_start_6
    invoke-virtual {v1}, Ljava/io/InputStreamReader;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_5

    :cond_2
    :goto_5
    throw v0

    :catch_4
    move-exception v0

    goto :goto_1

    :catch_5
    move-exception v1

    goto :goto_5

    :catchall_1
    move-exception v1

    move-object v5, v1

    move-object v1, v0

    move-object v0, v5

    goto :goto_4

    :catch_6
    move-exception v1

    goto :goto_3

    :catch_7
    move-exception v0

    move-object v0, v1

    goto :goto_2
.end method

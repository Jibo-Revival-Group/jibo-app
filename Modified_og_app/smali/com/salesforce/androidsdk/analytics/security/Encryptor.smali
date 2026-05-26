.class public Lcom/salesforce/androidsdk/analytics/security/Encryptor;
.super Ljava/lang/Object;
.source "Encryptor.java"


# static fields
.field private static a:Ljava/lang/String;

.field private static b:Z


# direct methods
.method public static a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 134
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    if-nez p0, :cond_1

    .line 137
    :cond_0
    :goto_0
    return-object p0

    :cond_1
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    invoke-static {v0, p1}, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->a([BLjava/lang/String;)Ljava/lang/String;

    move-result-object p0

    goto :goto_0
.end method

.method public static a([BLjava/lang/String;)Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v0, 0x0

    .line 141
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 142
    if-eqz p0, :cond_0

    .line 143
    new-instance v0, Ljava/lang/String;

    const-string v1, "UTF-8"

    invoke-static {v1}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    .line 159
    :cond_0
    :goto_0
    return-object v0

    .line 150
    :cond_1
    const/4 v1, 0x0

    :try_start_0
    invoke-static {p1, v1}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v1

    .line 151
    const/4 v2, 0x0

    invoke-static {p0, v2}, Landroid/util/Base64;->decode([BI)[B

    move-result-object v2

    .line 154
    const/4 v3, 0x0

    array-length v4, v2

    invoke-static {v2, v3, v4, v1}, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->a([BII[B)[B

    move-result-object v2

    .line 155
    new-instance v1, Ljava/lang/String;

    const/4 v3, 0x0

    array-length v4, v2

    const-string v5, "UTF-8"

    invoke-direct {v1, v2, v3, v4, v5}, Ljava/lang/String;-><init>([BIILjava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-object v0, v1

    goto :goto_0

    .line 156
    :catch_0
    move-exception v1

    .line 157
    const-string v2, "Encryptor"

    const-string v3, "Error during decryption"

    invoke-static {v0, v2, v3, v1}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static a()Ljavax/crypto/Cipher;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 100
    sget-object v0, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->a:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 101
    sget-object v0, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->a:Ljava/lang/String;

    const-string v1, "BC"

    invoke-static {v0, v1}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v0

    .line 114
    :cond_0
    :goto_0
    return-object v0

    .line 104
    :cond_1
    :try_start_0
    const-string v0, "AES/CBC/PKCS5Padding"

    const-string v1, "BC"

    invoke-static {v0, v1}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;Ljava/lang/String;)Ljavax/crypto/Cipher;
    :try_end_0
    .catch Ljava/security/GeneralSecurityException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 105
    if-eqz v0, :cond_2

    .line 106
    :try_start_1
    const-string v1, "AES/CBC/PKCS5Padding"

    sput-object v1, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->a:Ljava/lang/String;
    :try_end_1
    .catch Ljava/security/GeneralSecurityException; {:try_start_1 .. :try_end_1} :catch_1

    .line 111
    :cond_2
    :goto_1
    sget-object v1, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->a:Ljava/lang/String;

    if-nez v1, :cond_0

    .line 112
    const-string v1, "Encryptor"

    const-string v3, "No cipher transformation available"

    invoke-static {v2, v1, v3}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 108
    :catch_0
    move-exception v0

    move-object v1, v0

    move-object v0, v2

    .line 109
    :goto_2
    const-string v3, "Encryptor"

    const-string v4, "Preferred combo not available"

    invoke-static {v2, v3, v4, v1}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 108
    :catch_1
    move-exception v1

    goto :goto_2
.end method

.method public static a(Landroid/content/Context;)Z
    .locals 5

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 70
    const-string v0, "device_policy"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/admin/DevicePolicyManager;

    .line 71
    invoke-virtual {v0}, Landroid/app/admin/DevicePolicyManager;->getStorageEncryptionStatus()I

    move-result v0

    const/4 v3, 0x3

    if-ne v0, v3, :cond_0

    move v0, v1

    :goto_0
    sput-boolean v0, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->b:Z

    .line 74
    const/4 v0, 0x0

    sput-object v0, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->a:Ljava/lang/String;

    .line 76
    :try_start_0
    invoke-static {}, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->a()Ljavax/crypto/Cipher;
    :try_end_0
    .catch Ljava/security/GeneralSecurityException; {:try_start_0 .. :try_end_0} :catch_0

    .line 80
    :goto_1
    sget-object v0, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->a:Ljava/lang/String;

    if-nez v0, :cond_1

    .line 89
    :goto_2
    return v2

    :cond_0
    move v0, v2

    .line 71
    goto :goto_0

    .line 77
    :catch_0
    move-exception v0

    .line 78
    const-string v3, "Encryptor"

    const-string v4, "Security exception thrown"

    invoke-static {p0, v3, v4, v0}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 84
    :cond_1
    :try_start_1
    const-string v0, "HmacSHA256"

    const-string v3, "BC"

    invoke-static {v0, v3}, Ljavax/crypto/Mac;->getInstance(Ljava/lang/String;Ljava/lang/String;)Ljavax/crypto/Mac;
    :try_end_1
    .catch Ljava/security/GeneralSecurityException; {:try_start_1 .. :try_end_1} :catch_1

    move v2, v1

    .line 89
    goto :goto_2

    .line 85
    :catch_1
    move-exception v0

    .line 86
    const-string v1, "Encryptor"

    const-string v3, "No MAC transformation available"

    invoke-static {p0, v1, v3, v0}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_2
.end method

.method private static a([BII[B)[B
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    .line 279
    const/16 v0, 0x10

    new-array v0, v0, [B

    .line 280
    array-length v1, v0

    invoke-static {p0, p1, v0, v6, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 283
    array-length v1, v0

    sub-int v1, p2, v1

    .line 284
    array-length v2, v0

    add-int/2addr v2, p1

    .line 285
    new-array v3, v1, [B

    .line 286
    invoke-static {p0, v2, v3, v6, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 287
    invoke-static {}, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->a()Ljavax/crypto/Cipher;

    move-result-object v2

    .line 288
    new-instance v4, Ljavax/crypto/spec/SecretKeySpec;

    invoke-virtual {v2}, Ljavax/crypto/Cipher;->getAlgorithm()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, p3, v5}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 289
    new-instance v5, Ljavax/crypto/spec/IvParameterSpec;

    invoke-direct {v5, v0}, Ljavax/crypto/spec/IvParameterSpec;-><init>([B)V

    .line 290
    const/4 v0, 0x2

    invoke-virtual {v2, v0, v4, v5}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V

    .line 291
    invoke-virtual {v2, v3, v6, v1}, Ljavax/crypto/Cipher;->doFinal([BII)[B

    move-result-object v0

    .line 292
    return-object v0
.end method

.method private static a([B[B)[B
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 260
    invoke-static {}, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->a()Ljavax/crypto/Cipher;

    move-result-object v0

    .line 261
    new-instance v1, Ljavax/crypto/spec/SecretKeySpec;

    invoke-virtual {v0}, Ljavax/crypto/Cipher;->getAlgorithm()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, p1, v2}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 264
    invoke-static {}, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->c()[B

    move-result-object v2

    .line 265
    new-instance v3, Ljavax/crypto/spec/IvParameterSpec;

    invoke-direct {v3, v2}, Ljavax/crypto/spec/IvParameterSpec;-><init>([B)V

    .line 266
    const/4 v4, 0x1

    invoke-virtual {v0, v4, v1, v3}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V

    .line 267
    invoke-virtual {v0, p0}, Ljavax/crypto/Cipher;->doFinal([B)[B

    move-result-object v0

    .line 270
    array-length v1, v2

    array-length v3, v0

    add-int/2addr v1, v3

    new-array v1, v1, [B

    .line 271
    array-length v3, v2

    invoke-static {v2, v5, v1, v5, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 272
    array-length v2, v2

    array-length v3, v0

    invoke-static {v0, v5, v1, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 273
    return-object v1
.end method

.method public static b(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 170
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    if-nez p0, :cond_1

    .line 183
    :cond_0
    :goto_0
    return-object p0

    .line 173
    :cond_1
    invoke-static {p0, p1}, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->c(Ljava/lang/String;Ljava/lang/String;)[B

    move-result-object v1

    .line 174
    if-nez v1, :cond_2

    move-object p0, v0

    .line 175
    goto :goto_0

    .line 179
    :cond_2
    :try_start_0
    new-instance p0, Ljava/lang/String;

    const-string v2, "US-ASCII"

    invoke-direct {p0, v1, v2}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 180
    :catch_0
    move-exception v1

    .line 181
    const-string v2, "Encryptor"

    const-string v3, "Error during encryption"

    invoke-static {v0, v2, v3, v1}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object p0, v0

    .line 183
    goto :goto_0
.end method

.method public static b()Z
    .locals 1

    .prologue
    .line 123
    sget-boolean v0, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->b:Z

    return v0
.end method

.method private static c()[B
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/NoSuchAlgorithmException;,
            Ljava/security/NoSuchProviderException;
        }
    .end annotation

    .prologue
    .line 253
    const-string v0, "SHA1PRNG"

    invoke-static {v0}, Ljava/security/SecureRandom;->getInstance(Ljava/lang/String;)Ljava/security/SecureRandom;

    move-result-object v0

    .line 254
    const/16 v1, 0x10

    new-array v1, v1, [B

    .line 255
    invoke-virtual {v0, v1}, Ljava/security/SecureRandom;->nextBytes([B)V

    .line 256
    return-object v1
.end method

.method public static c(Ljava/lang/String;Ljava/lang/String;)[B
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 193
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 194
    if-nez p0, :cond_0

    .line 208
    :goto_0
    return-object v0

    .line 197
    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    goto :goto_0

    .line 202
    :cond_1
    const/4 v1, 0x0

    :try_start_0
    invoke-static {p1, v1}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v1

    .line 203
    const-string v2, "UTF-8"

    invoke-virtual {p0, v2}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v2

    .line 204
    invoke-static {v2, v1}, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->a([B[B)[B

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v1, v2}, Landroid/util/Base64;->encode([BI)[B
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    .line 205
    :catch_0
    move-exception v1

    .line 206
    const-string v2, "Encryptor"

    const-string v3, "Error during encryption"

    invoke-static {v0, v2, v3, v1}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v0, 0x0

    .line 237
    :try_start_0
    const-string v1, "UTF-8"

    invoke-virtual {p1, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v1

    .line 238
    const-string v2, "UTF-8"

    invoke-virtual {p0, v2}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v2

    .line 239
    const-string v3, "HmacSHA256"

    const-string v4, "BC"

    invoke-static {v3, v4}, Ljavax/crypto/Mac;->getInstance(Ljava/lang/String;Ljava/lang/String;)Ljavax/crypto/Mac;

    move-result-object v3

    .line 240
    new-instance v4, Ljavax/crypto/spec/SecretKeySpec;

    invoke-virtual {v3}, Ljavax/crypto/Mac;->getAlgorithm()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v1, v5}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 241
    invoke-virtual {v3, v4}, Ljavax/crypto/Mac;->init(Ljava/security/Key;)V

    .line 242
    invoke-virtual {v3, v2}, Ljavax/crypto/Mac;->doFinal([B)[B

    move-result-object v1

    .line 245
    const/4 v2, 0x2

    invoke-static {v1, v2}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 248
    :goto_0
    return-object v0

    .line 246
    :catch_0
    move-exception v1

    .line 247
    const-string v2, "Encryptor"

    const-string v3, "Error during hashing"

    invoke-static {v0, v2, v3, v1}, Lcom/salesforce/androidsdk/analytics/util/SalesforceAnalyticsLogger;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

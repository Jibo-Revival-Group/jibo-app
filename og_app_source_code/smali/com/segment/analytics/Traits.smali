.class public Lcom/segment/analytics/Traits;
.super Lcom/segment/analytics/ValueMap;
.source "Traits.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/segment/analytics/Traits$Cache;,
        Lcom/segment/analytics/Traits$Address;
    }
.end annotation


# static fields
.field private static final ADDRESS_KEY:Ljava/lang/String; = "address"

.field private static final AGE_KEY:Ljava/lang/String; = "age"

.field private static final ANONYMOUS_ID_KEY:Ljava/lang/String; = "anonymousId"

.field private static final AVATAR_KEY:Ljava/lang/String; = "avatar"

.field private static final BIRTHDAY_KEY:Ljava/lang/String; = "birthday"

.field private static final CREATED_AT_KEY:Ljava/lang/String; = "createdAt"

.field private static final DESCRIPTION_KEY:Ljava/lang/String; = "description"

.field private static final EMAIL_KEY:Ljava/lang/String; = "email"

.field private static final EMPLOYEES_KEY:Ljava/lang/String; = "employees"

.field private static final FAX_KEY:Ljava/lang/String; = "fax"

.field private static final FIRST_NAME_KEY:Ljava/lang/String; = "firstName"

.field private static final GENDER_KEY:Ljava/lang/String; = "gender"

.field private static final INDUSTRY_KEY:Ljava/lang/String; = "industry"

.field private static final LAST_NAME_KEY:Ljava/lang/String; = "lastName"

.field private static final NAME_KEY:Ljava/lang/String; = "name"

.field private static final PHONE_KEY:Ljava/lang/String; = "phone"

.field private static final TITLE_KEY:Ljava/lang/String; = "title"

.field private static final USERNAME_KEY:Ljava/lang/String; = "username"

.field private static final USER_ID_KEY:Ljava/lang/String; = "userId"

.field private static final WEBSITE_KEY:Ljava/lang/String; = "website"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 93
    invoke-direct {p0}, Lcom/segment/analytics/ValueMap;-><init>()V

    return-void
.end method

.method public constructor <init>(I)V
    .locals 0

    .prologue
    .line 96
    invoke-direct {p0, p1}, Lcom/segment/analytics/ValueMap;-><init>(I)V

    .line 97
    return-void
.end method

.method constructor <init>(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 89
    invoke-direct {p0, p1}, Lcom/segment/analytics/ValueMap;-><init>(Ljava/util/Map;)V

    .line 90
    return-void
.end method

.method static create()Lcom/segment/analytics/Traits;
    .locals 2

    .prologue
    .line 81
    new-instance v0, Lcom/segment/analytics/Traits;

    new-instance v1, Lcom/segment/analytics/internal/Utils$NullableConcurrentHashMap;

    invoke-direct {v1}, Lcom/segment/analytics/internal/Utils$NullableConcurrentHashMap;-><init>()V

    invoke-direct {v0, v1}, Lcom/segment/analytics/Traits;-><init>(Ljava/util/Map;)V

    .line 82
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/segment/analytics/Traits;->putAnonymousId(Ljava/lang/String;)Lcom/segment/analytics/Traits;

    .line 83
    return-object v0
.end method


# virtual methods
.method public address()Lcom/segment/analytics/Traits$Address;
    .locals 2

    .prologue
    .line 139
    const-string v0, "address"

    const-class v1, Lcom/segment/analytics/Traits$Address;

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/Traits;->getValueMap(Ljava/lang/String;Ljava/lang/Class;)Lcom/segment/analytics/ValueMap;

    move-result-object v0

    check-cast v0, Lcom/segment/analytics/Traits$Address;

    return-object v0
.end method

.method public age()I
    .locals 2

    .prologue
    .line 148
    const-string v0, "age"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/Traits;->getInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public anonymousId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    const-string v0, "anonymousId"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Traits;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public avatar()Ljava/lang/String;
    .locals 1

    .prologue
    .line 157
    const-string v0, "avatar"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Traits;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public birthday()Ljava/util/Date;
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 167
    :try_start_0
    const-string v1, "birthday"

    invoke-virtual {p0, v1}, Lcom/segment/analytics/Traits;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 168
    invoke-static {v1}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 171
    :goto_0
    return-object v0

    .line 169
    :cond_0
    invoke-static {v1}, Lcom/segment/analytics/internal/Utils;->toISO8601Date(Ljava/lang/String;)Ljava/util/Date;
    :try_end_0
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    .line 170
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public createdAt()Ljava/lang/String;
    .locals 1

    .prologue
    .line 185
    const-string v0, "createdAt"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Traits;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public currentId()Ljava/lang/String;
    .locals 2

    .prologue
    .line 129
    invoke-virtual {p0}, Lcom/segment/analytics/Traits;->userId()Ljava/lang/String;

    move-result-object v0

    .line 130
    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lcom/segment/analytics/Traits;->anonymousId()Ljava/lang/String;

    move-result-object v0

    :cond_0
    return-object v0
.end method

.method public description()Ljava/lang/String;
    .locals 1

    .prologue
    .line 194
    const-string v0, "description"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Traits;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public email()Ljava/lang/String;
    .locals 1

    .prologue
    .line 203
    const-string v0, "email"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Traits;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public employees()J
    .locals 4

    .prologue
    .line 212
    const-string v0, "employees"

    const-wide/16 v2, 0x0

    invoke-virtual {p0, v0, v2, v3}, Lcom/segment/analytics/Traits;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method public fax()Ljava/lang/String;
    .locals 1

    .prologue
    .line 221
    const-string v0, "fax"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Traits;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public firstName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 230
    const-string v0, "firstName"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Traits;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public gender()Ljava/lang/String;
    .locals 1

    .prologue
    .line 239
    const-string v0, "gender"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Traits;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public industry()Ljava/lang/String;
    .locals 1

    .prologue
    .line 248
    const-string v0, "industry"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Traits;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public lastName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 257
    const-string v0, "lastName"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Traits;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public name()Ljava/lang/String;
    .locals 4

    .prologue
    .line 266
    const-string v0, "name"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Traits;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 267
    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {p0}, Lcom/segment/analytics/Traits;->firstName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {p0}, Lcom/segment/analytics/Traits;->lastName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 268
    const/4 v0, 0x0

    .line 287
    :cond_0
    :goto_0
    return-object v0

    .line 271
    :cond_1
    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 272
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 273
    invoke-virtual {p0}, Lcom/segment/analytics/Traits;->firstName()Ljava/lang/String;

    move-result-object v2

    .line 274
    const/4 v0, 0x0

    .line 275
    invoke-static {v2}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 276
    const/4 v0, 0x1

    .line 277
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 280
    :cond_2
    invoke-virtual {p0}, Lcom/segment/analytics/Traits;->lastName()Ljava/lang/String;

    move-result-object v2

    .line 281
    invoke-static {v2}, Lcom/segment/analytics/internal/Utils;->isNullOrEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_4

    .line 282
    if-eqz v0, :cond_3

    const/16 v0, 0x20

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 283
    :cond_3
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 285
    :cond_4
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public phone()Ljava/lang/String;
    .locals 1

    .prologue
    .line 297
    const-string v0, "phone"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Traits;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public putAddress(Lcom/segment/analytics/Traits$Address;)Lcom/segment/analytics/Traits;
    .locals 1

    .prologue
    .line 135
    const-string v0, "address"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Traits;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method

.method public putAge(I)Lcom/segment/analytics/Traits;
    .locals 2

    .prologue
    .line 144
    const-string v0, "age"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/Traits;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method

.method putAnonymousId(Ljava/lang/String;)Lcom/segment/analytics/Traits;
    .locals 1

    .prologue
    .line 117
    const-string v0, "anonymousId"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Traits;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method

.method public putAvatar(Ljava/lang/String;)Lcom/segment/analytics/Traits;
    .locals 1

    .prologue
    .line 153
    const-string v0, "avatar"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Traits;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method

.method public putBirthday(Ljava/util/Date;)Lcom/segment/analytics/Traits;
    .locals 2

    .prologue
    .line 162
    const-string v0, "birthday"

    invoke-static {p1}, Lcom/segment/analytics/internal/Utils;->toISO8601Date(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/Traits;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method

.method public putCreatedAt(Ljava/lang/String;)Lcom/segment/analytics/Traits;
    .locals 1

    .prologue
    .line 181
    const-string v0, "createdAt"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Traits;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method

.method public putDescription(Ljava/lang/String;)Lcom/segment/analytics/Traits;
    .locals 1

    .prologue
    .line 190
    const-string v0, "description"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Traits;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method

.method public putEmail(Ljava/lang/String;)Lcom/segment/analytics/Traits;
    .locals 1

    .prologue
    .line 199
    const-string v0, "email"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Traits;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method

.method public putEmployees(J)Lcom/segment/analytics/Traits;
    .locals 3

    .prologue
    .line 208
    const-string v0, "employees"

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/segment/analytics/Traits;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method

.method public putFax(Ljava/lang/String;)Lcom/segment/analytics/Traits;
    .locals 1

    .prologue
    .line 217
    const-string v0, "fax"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Traits;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method

.method public putFirstName(Ljava/lang/String;)Lcom/segment/analytics/Traits;
    .locals 1

    .prologue
    .line 226
    const-string v0, "firstName"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Traits;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method

.method public putGender(Ljava/lang/String;)Lcom/segment/analytics/Traits;
    .locals 1

    .prologue
    .line 235
    const-string v0, "gender"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Traits;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method

.method public putIndustry(Ljava/lang/String;)Lcom/segment/analytics/Traits;
    .locals 1

    .prologue
    .line 244
    const-string v0, "industry"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Traits;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method

.method public putLastName(Ljava/lang/String;)Lcom/segment/analytics/Traits;
    .locals 1

    .prologue
    .line 253
    const-string v0, "lastName"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Traits;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method

.method public putName(Ljava/lang/String;)Lcom/segment/analytics/Traits;
    .locals 1

    .prologue
    .line 262
    const-string v0, "name"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Traits;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method

.method public putPhone(Ljava/lang/String;)Lcom/segment/analytics/Traits;
    .locals 1

    .prologue
    .line 293
    const-string v0, "phone"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Traits;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method

.method public putTitle(Ljava/lang/String;)Lcom/segment/analytics/Traits;
    .locals 1

    .prologue
    .line 305
    const-string v0, "title"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Traits;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method

.method putUserId(Ljava/lang/String;)Lcom/segment/analytics/Traits;
    .locals 1

    .prologue
    .line 109
    const-string v0, "userId"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Traits;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method

.method public putUsername(Ljava/lang/String;)Lcom/segment/analytics/Traits;
    .locals 1

    .prologue
    .line 317
    const-string v0, "username"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Traits;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method

.method public putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;
    .locals 0

    .prologue
    .line 335
    invoke-super {p0, p1, p2}, Lcom/segment/analytics/ValueMap;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/ValueMap;

    .line 336
    return-object p0
.end method

.method public bridge synthetic putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/ValueMap;
    .locals 1

    .prologue
    .line 50
    invoke-virtual {p0, p1, p2}, Lcom/segment/analytics/Traits;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method

.method public putWebsite(Ljava/lang/String;)Lcom/segment/analytics/Traits;
    .locals 1

    .prologue
    .line 326
    const-string v0, "website"

    invoke-virtual {p0, v0, p1}, Lcom/segment/analytics/Traits;->putValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/segment/analytics/Traits;

    move-result-object v0

    return-object v0
.end method

.method public title()Ljava/lang/String;
    .locals 1

    .prologue
    .line 309
    const-string v0, "title"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Traits;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public unmodifiableCopy()Lcom/segment/analytics/Traits;
    .locals 2

    .prologue
    .line 100
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0, p0}, Ljava/util/LinkedHashMap;-><init>(Ljava/util/Map;)V

    .line 101
    new-instance v1, Lcom/segment/analytics/Traits;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/segment/analytics/Traits;-><init>(Ljava/util/Map;)V

    return-object v1
.end method

.method public userId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 113
    const-string v0, "userId"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Traits;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public username()Ljava/lang/String;
    .locals 1

    .prologue
    .line 321
    const-string v0, "username"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Traits;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public website()Ljava/lang/String;
    .locals 1

    .prologue
    .line 330
    const-string v0, "website"

    invoke-virtual {p0, v0}, Lcom/segment/analytics/Traits;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.class public Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;
.super Lcom/jibo/aws/integration/aws/services/account/model/JiboAccountRequest;


# instance fields
.field private birthdayMilliseconds:Ljava/lang/Long;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation

    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "birthday"
    .end annotation
.end field

.field private email:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private firstName:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private gender:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private invitationCode:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private lastName:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field

.field private transient operation:Ljava/lang/String;

.field private password:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/Expose;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/jibo/aws/integration/aws/services/account/model/Account;)V
    .locals 1

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/account/model/JiboAccountRequest;-><init>()V

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->email:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getLastName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->lastName:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->firstName:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->gender:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->birthdayMilliseconds:Ljava/lang/Long;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/account/model/JiboAccountRequest;-><init>()V

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->email:Ljava/lang/String;

    iput-object p2, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->password:Ljava/lang/String;

    iput-object p3, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->operation:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/account/model/JiboAccountRequest;-><init>()V

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->email:Ljava/lang/String;

    iput-object p2, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->password:Ljava/lang/String;

    iput-object p3, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->invitationCode:Ljava/lang/String;

    iput-object p4, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->operation:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;Ljava/lang/Long;)V
    .locals 0

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/account/model/JiboAccountRequest;-><init>()V

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->email:Ljava/lang/String;

    iput-object p2, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->password:Ljava/lang/String;

    iput-object p3, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->firstName:Ljava/lang/String;

    iput-object p4, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->lastName:Ljava/lang/String;

    iput-object p6, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->gender:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    iput-object p7, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->birthdayMilliseconds:Ljava/lang/Long;

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 4

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-ne p0, p1, :cond_1

    move v2, v1

    :cond_0
    :goto_0
    return v2

    :cond_1
    if-eqz p1, :cond_0

    instance-of v0, p1, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;

    if-eqz v0, :cond_0

    check-cast p1, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getEmail()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_9

    move v0, v1

    :goto_1
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getEmail()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_a

    move v3, v1

    :goto_2
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getEmail()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getEmail()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getEmail()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_2
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getInvitationCode()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_b

    move v0, v1

    :goto_3
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getInvitationCode()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_c

    move v3, v1

    :goto_4
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getInvitationCode()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getInvitationCode()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getInvitationCode()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_3
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getPassword()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_d

    move v0, v1

    :goto_5
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getPassword()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_e

    move v3, v1

    :goto_6
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getPassword()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_4

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getPassword()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getPassword()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_4
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getFirstName()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_f

    move v0, v1

    :goto_7
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getFirstName()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_10

    move v3, v1

    :goto_8
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getFirstName()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_5

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getFirstName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getFirstName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_5
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getLastName()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_11

    move v0, v1

    :goto_9
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getLastName()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_12

    move v3, v1

    :goto_a
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getLastName()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_6

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getLastName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getLastName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_6
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v0

    if-nez v0, :cond_13

    move v0, v1

    :goto_b
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v3

    if-nez v3, :cond_14

    move v3, v1

    :goto_c
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v0

    if-eqz v0, :cond_7

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_7
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getBirthdayMilliseconds()Ljava/lang/Long;

    move-result-object v0

    if-nez v0, :cond_15

    move v0, v1

    :goto_d
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getBirthdayMilliseconds()Ljava/lang/Long;

    move-result-object v3

    if-nez v3, :cond_16

    move v3, v1

    :goto_e
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getBirthdayMilliseconds()Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_8

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getBirthdayMilliseconds()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getBirthdayMilliseconds()Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/Long;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_8
    move v2, v1

    goto/16 :goto_0

    :cond_9
    move v0, v2

    goto/16 :goto_1

    :cond_a
    move v3, v2

    goto/16 :goto_2

    :cond_b
    move v0, v2

    goto/16 :goto_3

    :cond_c
    move v3, v2

    goto/16 :goto_4

    :cond_d
    move v0, v2

    goto/16 :goto_5

    :cond_e
    move v3, v2

    goto/16 :goto_6

    :cond_f
    move v0, v2

    goto/16 :goto_7

    :cond_10
    move v3, v2

    goto/16 :goto_8

    :cond_11
    move v0, v2

    goto/16 :goto_9

    :cond_12
    move v3, v2

    goto :goto_a

    :cond_13
    move v0, v2

    goto :goto_b

    :cond_14
    move v3, v2

    goto :goto_c

    :cond_15
    move v0, v2

    goto :goto_d

    :cond_16
    move v3, v2

    goto :goto_e
.end method

.method public getBirthdayMilliseconds()Ljava/lang/Long;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->birthdayMilliseconds:Ljava/lang/Long;

    return-object v0
.end method

.method public getEmail()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->email:Ljava/lang/String;

    return-object v0
.end method

.method public getFirstName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->firstName:Ljava/lang/String;

    return-object v0
.end method

.method public getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->gender:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    return-object v0
.end method

.method public getInvitationCode()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->invitationCode:Ljava/lang/String;

    return-object v0
.end method

.method public getLastName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->lastName:Ljava/lang/String;

    return-object v0
.end method

.method public getOperation()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->operation:Ljava/lang/String;

    return-object v0
.end method

.method public getPassword()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->password:Ljava/lang/String;

    return-object v0
.end method

.method public getServiceMethodName()Ljava/lang/String;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getOperation()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getEmail()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    add-int/lit8 v0, v0, 0x1f

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getInvitationCode()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    move v0, v1

    :goto_1
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getPassword()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_2

    move v0, v1

    :goto_2
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getFirstName()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_3

    move v0, v1

    :goto_3
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getLastName()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_4

    move v0, v1

    :goto_4
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v0

    if-nez v0, :cond_5

    move v0, v1

    :goto_5
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getBirthdayMilliseconds()Ljava/lang/Long;

    move-result-object v2

    if-nez v2, :cond_6

    :goto_6
    add-int/2addr v0, v1

    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getEmail()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getInvitationCode()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_1

    :cond_2
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getPassword()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_2

    :cond_3
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getFirstName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_3

    :cond_4
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getLastName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_4

    :cond_5
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;->hashCode()I

    move-result v0

    goto :goto_5

    :cond_6
    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->getBirthdayMilliseconds()Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Long;->hashCode()I

    move-result v1

    goto :goto_6
.end method

.method public setBirthdayMilliseconds(Ljava/lang/Long;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->birthdayMilliseconds:Ljava/lang/Long;

    return-void
.end method

.method public setEmail(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->email:Ljava/lang/String;

    return-void
.end method

.method public setFirstName(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->firstName:Ljava/lang/String;

    return-void
.end method

.method public setGender(Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->gender:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    return-void
.end method

.method public setInvitationCode(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->invitationCode:Ljava/lang/String;

    return-void
.end method

.method public setLastName(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->lastName:Ljava/lang/String;

    return-void
.end method

.method public setOperation(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->operation:Ljava/lang/String;

    return-void
.end method

.method public setPassword(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->password:Ljava/lang/String;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    const/16 v2, 0x27

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "AccountRequest {email=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->email:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "invitationCode=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->invitationCode:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", password=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "********"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", operation=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->operation:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", firstName=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->firstName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", lastName=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->lastName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", gender=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->gender:Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", birthdayMilliseconds=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;->birthdayMilliseconds:Ljava/lang/Long;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

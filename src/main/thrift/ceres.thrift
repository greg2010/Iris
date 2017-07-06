namespace java com.wemesh.ceres.iris

typedef string Timestamp

struct UserMini {
    1: required string name;
    2: required i32 id;
    3: required i64 characterId;
}

struct EveUserData {
    1: required i64 characterId,
    2: required string characterName,
    3: required i64 corporationId,
    4: required string corporationName,
    5: optional i64 allianceId,
    6: optional string allianceName,
}

struct User {
    1: required EveUserData eveUserData,
    2: required i32 userId,
    3: required string email,
    4: optional string password
    5: optional string salt,
    6: required bool isBanned,
    7: required Timestamp creationTime,
    8: required Timestamp lastLoggedIn,
    9: required string languageCode
}

service UserService {
    UserMini verifyUserLegacy(1: string nameOrEmail, 2: string password);
    UserMini verifyUserSSO(1: string ssoToken);
    User getUser(1: i32 userId);
    UserMini getUserMini(1: i32 userId);
    void triggerUserUpdate(1: i32 userId);
    void updateUserData(1: EveUserData eveUserData);
    void updatePassword(1: i32 userId, 2: string newPassword);
    void requestPasswordReset(1: string email);
    void completePasswordReset(1: string email, 2: string token, 3: string newPassword);
}
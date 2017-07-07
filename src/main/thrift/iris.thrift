namespace java org.red.iris

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

exception AccessRestrictedException {
    1: required string reason
}

exception AuthenticationException {
    1: required string reason
    2: required string sub
}

exception BadEveCredential {
    1: required string reason
    2: required i32 statusCode
}

exception CCPException {
    1: required string reason
}

exception ConflictingEntityException {
    1: required string reason
}


exception NoPasswordException {}


exception ResourceNotFoundException {
    1: required string reason
}
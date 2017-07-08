namespace java org.red.iris

typedef string Timestamp

struct PermissionBit {
    1: required string name
    2: required i32 bitPosition
    3: required string description
}

struct UserMini {
    1: required string name
    2: required i32 id
    3: required i64 characterId
    4: required list<PermissionBit> userPermissions
}

struct EveUserData {
    1: required i64 characterId
    2: required string characterName
    3: required i64 corporationId
    4: required string corporationName
    5: required string corporationTicker
    6: optional i64 allianceId
    7: optional string allianceName
    8: optional string allianceTicker
}

struct EveUserDataList {
    1: required EveUserData head
    2: required list<EveUserData> tail
}

struct User {
    1: required EveUserData eveUserData
    2: required i32 userId
    3: required string email
    4: optional string password
    5: optional string salt
    6: required bool isBanned
    7: required Timestamp creationTime
    8: required Timestamp lastLoggedIn
    9: required string languageCode
    10: required list<PermissionBit> userPermissions
}

struct LegacyCredentials {
    1: required i32 keyId
    2: required string vCode
    3: optional i64 characterId
    4: optional string name
}

struct SSOCredentials {
    1: required string refreshToken
    2: optional string accessToken
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
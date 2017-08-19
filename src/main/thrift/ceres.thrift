namespace java org.red.ceres.finagle

include "iris.thrift"


struct SuccessfulLoginResponse {
  1: iris.UserMini userMini,
  2: i64 currentUser
}

service UserService {
    iris.EveUserDataList getEveUser(1: iris.LegacyCredentials credentials) throws (1: iris.ResourceNotFoundException err1, 2: iris.BadEveCredential err2);
    //iris.UserMini createLegacyUser(1: string email, 2: iris.LegacyCredentials credentials, 3: string password) throws (1: iris.ResourceNotFoundException err1, 2: iris.BadEveCredential err2, 3: iris.ConflictingEntityException err3);
    SuccessfulLoginResponse loginSSO(1: string authCode) throws (1: iris.ResourceNotFoundException err1, 2: iris.BadEveCredential err2);
    //iris.UserMini loginPassword(1: string login, 2: string password) throws (1: iris.ResourceNotFoundException err1);
    //iris.UserMini createSSOUser(1: string email, 2: iris.SSOCredentials credentials, 3: optional string password) throws (1: iris.ResourceNotFoundException err1, 2: iris.BadEveCredential err2, 3: iris.ConflictingEntityException err3);
    //iris.UserMini verifyUserLegacy(1: string nameOrEmail, 2: string password) throws (1: iris.ResourceNotFoundException err1, 2: iris.AuthenticationException err2);
    //iris.UserMini verifyUserSSO(1: string ssoToken) throws (1: iris.ResourceNotFoundException err1, 2: iris.AuthenticationException err2);
    iris.User getUser(1: i32 userId) throws (1: iris.ResourceNotFoundException err1);
    iris.UserMini getUserMini(1: i32 userId) throws (1: iris.ResourceNotFoundException err1);
    void triggerUserUpdate(1: i32 userId);
    //void updateEveUserData(1: iris.EveUserData eveUserData) throws (1: iris.ResourceNotFoundException err1);
    //void updatePassword(1: i32 userId, 2: string newPassword) throws (1: iris.ResourceNotFoundException err1);
    //void requestPasswordReset(1: string email) throws (1: iris.ResourceNotFoundException err1);
    //void completePasswordReset(1: string email, 2: string token, 3: string newPassword) throws (1: iris.ResourceNotFoundException err1);
}

service PermissionService {
    list<iris.PermissionBit> getPermissionBits(1: i64 mask);
    i64 getPermissionMask(1: list<iris.PermissionBit> permissionList);
    list<iris.PermissionBit> getPermissionList();
}
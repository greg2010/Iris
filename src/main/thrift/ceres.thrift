namespace java org.red.ceres.finagle

include "iris.thrift"


struct SuccessfulLoginResponse {
  1: iris.UserMini userMini,
  2: i64 currentUser
}

service UserService {
    iris.EveUserDataList getEveUser(1: iris.LegacyCredentials credentials) throws (1: iris.ResourceNotFoundException err1, 2: iris.BadEveCredential err2);
    SuccessfulLoginResponse loginSSO(1: string authCode) throws (1: iris.ResourceNotFoundException err1, 2: iris.BadEveCredential err2, 3: iris.CCPException err3);
    iris.User getUser(1: i32 userId) throws (1: iris.ResourceNotFoundException err1);
    iris.UserMini getUserMini(1: i32 userId) throws (1: iris.ResourceNotFoundException err1);
    void triggerUserUpdate(1: i32 userId);
}

service PermissionService {
    list<iris.PermissionBit> getPermissionBits(1: i64 mask);
    i64 getPermissionMask(1: list<iris.PermissionBit> permissionList);
    list<iris.PermissionBit> getPermissionList();
}
namespace java org.red.ceres.finagle

include "iris.thrift"


service UserService {
    iris.UserMini createLegacyUser(1: string email, 2: iris.LegacyCredentials credentials, 3: string password);
    iris.UserMini createSSOUser(1: string email, 2: iris.SSOCredentials credentials, 3: optional string password);
    iris.UserMini verifyUserLegacy(1: string nameOrEmail, 2: string password);
    iris.UserMini verifyUserSSO(1: string ssoToken);
    iris.User getUser(1: i32 userId);
    iris.UserMini getUserMini(1: i32 userId);
    void triggerUserUpdate(1: i32 userId);
    void updateUserData(1: iris.EveUserData eveUserData);
    void updatePassword(1: i32 userId, 2: string newPassword);
    void requestPasswordReset(1: string email);
    void completePasswordReset(1: string email, 2: string token, 3: string newPassword);
}
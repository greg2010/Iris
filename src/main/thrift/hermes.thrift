namespace java org.red.hermes.finagle

include "iris.thrift"

service TeamspeakService {
    void registerUserOnTeamspeak(1: iris.User user, 2: string userIp);
    string getTeamspeakUniqueId(1: i32 userId);
    i32 getUserIdByUniqueId(1: string uniqueId);
    void syncTeamspeakUser(1: iris.User user);
}
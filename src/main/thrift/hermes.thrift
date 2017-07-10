namespace java org.red.hermes.finagle

include "iris.thrift"

service TeamspeakService {
    void registerUserOnTeamspeak(1: iris.User user, 2: string userIp) throws (1: iris.ResourceNotFoundException err1, 2: iris.ConflictingEntityException err2);
    string getTeamspeakUniqueId(1: i32 userId) throws (1: iris.ResourceNotFoundException err1);
    i32 getUserIdByUniqueId(1: string uniqueId) throws (1: iris.ResourceNotFoundException err1);
    void syncTeamspeakUser(1: iris.User user); // Throws runtime exception. Not implemented yet.
}
package main.Server.Asia;

import DPSS_CORBA.GameServerPOA;
import org.omg.CORBA.ORB;

public class AsianServerImpl extends GameServerPOA {

    private ORB orb;
    public void setORB(ORB orb_val) { orb = orb_val;
    }

    @Override
    public String createPlayerAccount(String FirstName, String LastName, float Age, String Username, String Password, String IPAddress) {
        return null;
    }

    @Override
    public String playerSignIn(String Username, String Password, String IPAddress) {
        return null;
    }

    @Override
    public String playerSignOut(String Username, String IPAddress) {
        return "signedout";
    }

    @Override
    public String getPlayerStatus(String AdminUsername, String AdminPassword, String IPAddress, boolean checkOtherServers) {
        return null;
    }

    @Override
    public String transferAccount(String Username, String Password, String OldIPAddress, String NewIPAddress) {
        return null;
    }

    @Override
    public String suspendAccount(String AdminUsername, String AdminPassword, String AdminIP, String UsernameToSuspend) {
        return null;
    }
}

package main.Client;

import DPSS_CORBA.GameServer;
import DPSS_CORBA.GameServerHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class PlayerClient {

    static GameServer gameServerImpl;

    public static void main(String[] args) {

        try {

            // create and initialize the ORB
            ORB orb = ORB.init(args, null);
            // get the root naming context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            // Use NamingContextExt instead of NamingContext. This is part of the Interoperable naming Service.
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // resolve the Object Reference in Naming
            String name = "Hello";
            gameServerImpl = GameServerHelper.narrow(ncRef.resolve_str(name));
            System.out.println("Obtained a handle on server object: " + gameServerImpl);
            System.out.println(gameServerImpl.playerSignOut("test","121212"));
            //gameServerImpl.shutdown();
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);

        }
    }
}

package main.Server.America;

import DPSS_CORBA.GameServer;
import DPSS_CORBA.GameServerHelper;
import main.Constants.Constants;
import main.Server.Asia.AsianServerImpl;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class AmericanServer {

    public static void main(String args[]) {
        // create and initialize the ORB
        ORB orb = ORB.init(args, null);
        try {
            // get reference to rootpoa & activate the POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();
            // create servant and register it with the ORB
            AmericanServerImpl americanServer = new AmericanServerImpl();
            americanServer.setORB(orb);

            // get object reference from the servant
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(americanServer);

            GameServer href = GameServerHelper.narrow(ref);
            // get the root naming context
            // NameService invokes the name service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            // Use NamingContextExt which is part of the Interoperable Naming Service (INS) specification.
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // bind the Object Reference in Naming
            NameComponent path[] = ncRef.to_name(Constants.SERVER_NAME_AMERICA);
            ncRef.rebind(path, href);
            System.out.println("AmericanServer ready and waiting ...");
            // wait for invocations from clients
            orb.run();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
        orb.shutdown(false);
        System.out.println("AmericanServer Exiting ...");
    }
}


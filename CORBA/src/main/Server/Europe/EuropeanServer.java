package main.Server.Europe;

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

public class EuropeanServer {
    public static void main(String args[]) {
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);
            // get reference to rootpoa & activate the POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();
            // create servant and register it with the ORB
            EuropeanServerImpl europeanServer = new EuropeanServerImpl();
            europeanServer.setORB(orb);

            // get object reference from the servant
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(europeanServer);

            GameServer href = GameServerHelper.narrow(ref);
            // get the root naming context
            // NameService invokes the name service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            // Use NamingContextExt which is part of the Interoperable Naming Service (INS) specification.
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // bind the Object Reference in Naming
            NameComponent path[] = ncRef.to_name(Constants.SERVER_NAME_EUROPE);
            ncRef.rebind(path, href);
            System.out.println("EuropeanServer ready and waiting ...");
            // wait for invocations from clients
            orb.run();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
         //   e.printStackTrace(System.out);
            System.out.println("Some issue here ");
        }
        System.out.println("EuropeanServer Exiting ...");
    }
}


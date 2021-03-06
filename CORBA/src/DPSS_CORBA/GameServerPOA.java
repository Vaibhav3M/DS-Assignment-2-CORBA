package DPSS_CORBA;


/**
* DPSS_CORBA/GameServerPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from DPSS-CORBA.idl
* Tuesday, June 23, 2020 8:00:45 o'clock PM EDT
*/

public abstract class GameServerPOA extends org.omg.PortableServer.Servant
 implements DPSS_CORBA.GameServerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("createPlayerAccount", new java.lang.Integer (0));
    _methods.put ("playerSignIn", new java.lang.Integer (1));
    _methods.put ("playerSignOut", new java.lang.Integer (2));
    _methods.put ("getPlayerStatus", new java.lang.Integer (3));
    _methods.put ("transferAccount", new java.lang.Integer (4));
    _methods.put ("suspendAccount", new java.lang.Integer (5));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // DPSS_CORBA/GameServer/createPlayerAccount
       {
         String FirstName = in.read_string ();
         String LastName = in.read_string ();
         float Age = in.read_float ();
         String Username = in.read_string ();
         String Password = in.read_string ();
         String IPAddress = in.read_string ();
         String $result = null;
         $result = this.createPlayerAccount (FirstName, LastName, Age, Username, Password, IPAddress);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // DPSS_CORBA/GameServer/playerSignIn
       {
         String Username = in.read_string ();
         String Password = in.read_string ();
         String IPAddress = in.read_string ();
         String $result = null;
         $result = this.playerSignIn (Username, Password, IPAddress);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // DPSS_CORBA/GameServer/playerSignOut
       {
         String Username = in.read_string ();
         String IPAddress = in.read_string ();
         String $result = null;
         $result = this.playerSignOut (Username, IPAddress);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // DPSS_CORBA/GameServer/getPlayerStatus
       {
         String AdminUsername = in.read_string ();
         String AdminPassword = in.read_string ();
         String IPAddress = in.read_string ();
         boolean checkOtherServers = in.read_boolean ();
         String $result = null;
         $result = this.getPlayerStatus (AdminUsername, AdminPassword, IPAddress, checkOtherServers);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 4:  // DPSS_CORBA/GameServer/transferAccount
       {
         String Username = in.read_string ();
         String Password = in.read_string ();
         String OldIPAddress = in.read_string ();
         String NewIPAddress = in.read_string ();
         String $result = null;
         $result = this.transferAccount (Username, Password, OldIPAddress, NewIPAddress);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 5:  // DPSS_CORBA/GameServer/suspendAccount
       {
         String AdminUsername = in.read_string ();
         String AdminPassword = in.read_string ();
         String AdminIP = in.read_string ();
         String UsernameToSuspend = in.read_string ();
         String $result = null;
         $result = this.suspendAccount (AdminUsername, AdminPassword, AdminIP, UsernameToSuspend);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:DPSS_CORBA/GameServer:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public GameServer _this() 
  {
    return GameServerHelper.narrow(
    super._this_object());
  }

  public GameServer _this(org.omg.CORBA.ORB orb) 
  {
    return GameServerHelper.narrow(
    super._this_object(orb));
  }


} // class GameServerPOA

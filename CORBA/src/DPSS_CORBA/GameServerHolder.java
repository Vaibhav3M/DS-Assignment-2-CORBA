package DPSS_CORBA;

/**
* DPSS_CORBA/GameServerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from DPSS-CORBA.idl
* Tuesday, June 23, 2020 8:00:45 o'clock PM EDT
*/

public final class GameServerHolder implements org.omg.CORBA.portable.Streamable
{
  public DPSS_CORBA.GameServer value = null;

  public GameServerHolder ()
  {
  }

  public GameServerHolder (DPSS_CORBA.GameServer initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DPSS_CORBA.GameServerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DPSS_CORBA.GameServerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DPSS_CORBA.GameServerHelper.type ();
  }

}

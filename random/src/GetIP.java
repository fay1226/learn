import java.net.*;

public class GetIP
{
	public static void main(String[] args){
		try
		{
			InetAddress in=InetAddress.getLocalHost();
			String ip=in.getHostAddress().toString();
			String local=in.getHostName().toString();
			System.out.println(local+":"+ip);
		}
		catch (UnknownHostException e)
		{
			System.out.println("无法获取IP.");
		}
	}
}

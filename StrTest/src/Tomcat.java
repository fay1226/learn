import java.net.*;
import java.io.*;

public class Tomcat
{
	public static void main(String[] args){
		Server s = new Server();
		String charset = "utf-8";
		String webRoot = "/storage/emulated/0/AppProjects";
		s.server(charset,webRoot);
	}
}

class Handler implements Runnable
{
	private Socket socket;
	private String charset = "utf-8";
	private String webRoot = "/storage/emulated/0/AppProjects";
	public Handler(Socket socket,String charset,String webRoot){
		this.socket = socket;
		this.charset = charset;
		this.webRoot = webRoot;
	}
	
	@Override
	public void run(){
		try{
			//解析请求
			InputStream in = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in,charset));
			StringBuilder sb = new StringBuilder();
			String temp = null;
			while((temp=(br.readLine()))!=null&&temp.length()>0){
				sb.append(temp);
				sb.append("\r\n");
			}
			System.out.println(sb.toString());
			//做出响应
			OutputStream out = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(out,charset));
			writer.println("HTTP/1.1 200 OK");
			writer.println("Content-Type:text/html;charset="+charset);
			writer.println();//请求头写完需要换行结束符
			String[] msgs = sb.toString().split(" ");
			if(msgs.length>2){
				try{
					FileInputStream fileIn = new FileInputStream(new File(webRoot+msgs[1]));
					byte[] buff = new byte[1024];
					int length = 0;
					while((length = fileIn.read(buff))!=-1){
						out.write(buff,0,length);
					}
					fileIn.close();
					out.close();
				}catch (FileNotFoundException e){
					writer.println("<h1 style='text-align:center;color:red;'>404啦,访问的页面找不到!</h1>");
				}
			}
			System.out.println("响应完成。");
			writer.flush();
			writer.close();
		}catch (IOException e){}
	}
}

class Server
{
	public static void server(String charset,String webRoot){
		try{
			ServerSocket server = new ServerSocket(8080);//创建服务
			System.out.println("服务器已启动……\n等待连接……");
			while(true){
				Socket socket = server.accept();//等待客户端(浏览器)连接
				System.out.println("连接成功。");
				Thread thread = new Thread(new Handler(socket,charset,webRoot));
				thread.start();
			}
		}catch (IOException e){}
	}
}

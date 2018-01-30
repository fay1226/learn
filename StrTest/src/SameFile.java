import java.io.*;
import java.security.*;
import java.math.*;

public class SameFile
{
	// 计算文件的 MD5 值
	public static String getFileMD5(File file) {
		if (!file.isFile()||!file.exists()) {
			return "请选择一个文件";
		}
		MessageDigest digest = null;
		FileInputStream in = null;
		byte buffer[] = new byte[1024];
		int len;
		try {
			digest =MessageDigest.getInstance("MD5");
			in = new FileInputStream(file);
			while ((len = in.read(buffer)) != -1) {
				digest.update(buffer, 0, len);
			}
			in.close();
			BigInteger bigInt = new BigInteger(1, digest.digest());
			StringBuffer md5=new StringBuffer(bigInt.toString(16));
			for(int i=32-md5.length();i>0;i--) md5.insert(0,"0");
			return md5.toString();
		} catch (Exception e) {
			return "解析异常";
		}
	}
	// 计算文件的 SHA-1 值
	public static String getFileSha1(File file) {
		if (!file.isFile()||!file.exists()) {
			return "请选择一个文件";
		}
		MessageDigest digest = null;
		FileInputStream in = null;
		byte buffer[] = new byte[2048];
		int len;
		try {
			digest =MessageDigest.getInstance("SHA-1");
			in = new FileInputStream(file);
			while ((len = in.read(buffer)) != -1) {
				digest.update(buffer, 0, len);
			}
			in.close();
			BigInteger bigInt = new BigInteger(1, digest.digest());
			StringBuffer sha1=new StringBuffer(bigInt.toString(16));
			for(int i=40-sha1.length();i>0;i--) sha1.insert(0,"0");
			return sha1.toString();
		} catch (Exception e) {
			return "解析异常";
		}
	}
	
	public static void main(String[] args){
		File file1=new File("/storage/emulated/0/QQBrowser/文档/txt.txt");
		File file2=new File("/storage/emulated/0/QQBrowser/文档/doc.doc");
		System.out.println("文件1："+file1+"\n文件2："+file2);
		System.out.println("\n文件大小:"+file1.length()+"B,"+file2.length()+"B");
		String md51=getFileMD5(file1);
		String md52=getFileMD5(file2);
		String sha1=getFileSha1(file1);
		String sha2=getFileSha1(file2);
		if(file1.length()==file2.length()){
			System.out.println("\nMD5:\n"+md51+"\n"+md52);
			if(md51.equals(md52)&&!"请选择一个文件".equals(md51)&&!"请选择一个文件".equals(md52)){
				System.out.println("MD5 PASS!!");
				System.out.println("\n文件已存在！");
			}else System.out.println("\n新文件。");
			System.out.println("\nSHA-1:\n"+sha1+"\n"+sha2);
			if(sha1.equals(sha2)&&!"请选择一个文件".equals(sha1)&&!"请选择一个文件".equals(sha2)){
				System.out.println("SHA-1 PASS!!");
				System.out.println("\n文件已存在！");
			}else System.out.println("\n新文件。");
			
			if(md51.equals(md52)&&sha1.equals(sha2)){
				System.out.println("ALL PASS");
				System.out.println("\n文件已存在！");
			}else System.out.println("\n新文件。");
		}else System.out.println("\nSIZE OVER!!\n新文件。");
	}
}

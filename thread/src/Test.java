public class Test
{
	public static void main(String[] args){
		//thTest();
		//ruTest();
		otTest();
	}
	//测试继承Thread类创建的进程
	public static void thTest(){
		//创建多个进程实例
		MyThread t1=new MyThread();
		t1.setName("进程1=");
		MyThread t2=new MyThread();
		t2.setName("进程2=");
		t1.start();
		t2.start();
	}
	//测试实现Runnable接口创建的进程
	public static void ruTest(){
		//多个进程只创建了一个实例【资源共享】
		MyThread2 thread=new MyThread2();
		Thread t1=new Thread(thread,"进程1=");
		Thread t2=new Thread(thread,"进程2=");
		t1.start();
		t2.start();
	}
	//测试匿名内部类实现
	public static void otTest(){
		//OtherThread.thread();
		OtherThread.runnable();
	}
}

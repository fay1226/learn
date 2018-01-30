import java.util.*;
/**
*创建进程的两种方式
*注:可以匿名内部类创建进程
**/
//extends Thread类
public class MyThread extends Thread
{
	@Override
	public void run(){
		for(int i=1; i<10; i++){
			System.out.println(getName()+i);
			try{
				sleep(500);
			}catch (InterruptedException e){}
		}
	}
}

//implements Runnable接口，
//使用时只需创建一个进程实例，还能继承其他父类【扩展性,资源共享】
class MyThread2 implements Runnable
{
	@Override
	public void run(){
		String name=Thread.currentThread().getName();
		for(int i=1; i<10; i++){
			System.out.println(name+i);
			try{
				Thread.sleep(500);
			}catch (InterruptedException e){}
		}
	}
}

//匿名内部类
class OtherThread{
	//匿名内部类①
	public static void thread(){
		/*Thread th = new Thread("Thread");
		th.start();*/
		new Thread("线程"){
			@Override
			public void run(){
				for(int i=1; i<10; i++){
					System.out.println(getName()+i);
					try{
						sleep(500);
					}catch (InterruptedException e){}
				}
			}
		}.start();
	}
	
	//匿名内部类②
	public static void runnable(){
		/*Thread th = new Thread(target,"");*/
		new Thread(new Runnable(){
			@Override
			public void run(){
				for(int i=1; i<10; i++){
					System.out.println(Thread.currentThread().getName()+i);
					try{
						Thread.sleep(500);
					}catch (InterruptedException e){}
				}
			}
		},"进程"){
			//如何自己覆盖了Runnable的run()，只执行自己的run()
			/*public void run(){
				for(int i=10; i<20; i++){
					System.out.println(getName()+i);
					try{
						sleep(500);
					}catch (InterruptedException e){}
				}
			}*/
		}.start();
	}
}

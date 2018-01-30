public class OtherThread
{
	static int a = 3;
	static int b = 4;
	public static void main(String[] args){
		new Thread(new Runnable(){
			@Override
			public void run(){
				while(a<b){
					System.out.println(Thread.currentThread().getName()+"：a="+a+"，b="+b);
				}
				System.out.println(Thread.currentThread().getName()+"：a="+a+"，b="+b);
				b++;
			}
		},"A").start();
		new Thread(new Runnable(){
			@Override
			public void run(){
				a++;
				System.out.println(Thread.currentThread().getName()+"：a="+a);
			}
		},"B").start();
	}
}

class A{
	public static int num = 0;
	public static void main(String[] args){
		for(int i=0;i<10;i++){
			new Thread(new Runnable(){
					@Override
					public void run(){
						for(int j=0;j<100;j++){
							num++;
						}
					}
				}).start();
		}
		System.out.println(num);
	}
}

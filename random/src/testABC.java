import java.util.*;

public class testABC
{
	public static void main(String[] args){
		System.out.println("请输入要打印的三角形的行数：");
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		zup_abc(m);
		zdown_abc(m);
		upz_abc(m);
		upz_abc2(m);
		downz_abc(m);
		downz_abc2(m);
		up_abc(m);
		up_abc2(m);
		down_abc(m);
		down_abc2(m);
	}
	//上正三角形
	public static void zup_abc(int height){
		System.out.println("上正三角形:");
		for (int i = 1; i <= height; i++){
			//i为行数
			for (int k = 0; k < height - i; k++){
				//k为每行空格数
				System.out.print(" ");
			}
			for(int j = 0; j < 2 * i - 1; j++){
				//j为每行*数
				System.out.print("*");
			}
			System.out.println();
		}
	}
	//下正三角形
	public static void zdown_abc(int height){
		System.out.println("下正三角形:");
		for (int i = height; i >= 1; i--){
			//i为行数
			for (int k = 0; k < height - i; k++){
				//k为每行空格数
				System.out.print(" ");
			}
			for(int j = 0; j < 2 * i - 1; j++){
				//j为每行*数
				System.out.print("*");
			}
			System.out.println();
		}
	}
	//上直三角形
	public static void upz_abc(int height){
		System.out.println("上直角三角形:");
		for (int i = 1; i <= height; i++){
			//i为行数
			for(int j = 0; j < 2 * i - 1; j++){
				//j为每行*数
				System.out.print("*");
			}
			for (int k = 0; k <= height - i; k++){
				//k为每行空格数
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void upz_abc2(int height){
		System.out.println("上直角三角形2:");
		for (int i = height; i >= 1; i--){
			//i为行数
			for(int j = 0; j < 2 *(i - 1); j++){
				//j为每行空格数
				System.out.print(" ");
			}
			for (int k = 0; k <= 2 *(height - i); k++){
				//k为每行*数
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	//下直角三角形
	public static void downz_abc(int height){
		System.out.println("下直角三角形:");
		for (int i = height; i >= 1; i--){
			//i为行数
			for(int j = 0; j < 2 * i - 1; j++){
				//j为每行*数
				System.out.print("*");
			}
			for (int k = 0; k < height - i; k++){
				//k为每行*数
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	public static void downz_abc2(int height){
		System.out.println("下直角三角形2:");
		for (int i = 1; i <= height; i++){
			//i为行数
			for(int j = 0; j < 2 * (i - 1); j++){
				//j为每行*数
				System.out.print(" ");
			}
			for (int k = 0; k <= 2 * (height - i); k++){
				//k为每行空格数
				System.out.print("*");
			}
			System.out.println();
		}
	}
	//下三角形
	public static void down_abc(int height){
		System.out.println("下三角形:");
		for (int i = 1; i <= height; i++){
			//i为行数
			for(int j = 0; j < 2 * i - 2; j++){
				//j为每行空格数
				System.out.print(" ");
			}
			for (int k = 0; k <= height - i; k++){
				//k为每行*数
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void down_abc2(int height){
		System.out.println("下三角形2:");
		for (int i = height; i >= 1; i--){
			//i为行数
			for (int k = 0; k < i - 1; k++){
				//k为每行空格数
				System.out.print(" ");
			}
			for(int j = 0; j < 2 * i - 1; j++){
				//j为每行*数
				System.out.print("*");
			}
			System.out.println();
		}
	}

	//上三角形
	public static void up_abc(int height){
		System.out.println("上三角形:");
		for (int i = height; i >= 1; i--){
			//i为行数
			for(int j = 0; j < 2 * i - 2; j++){
				//j为每行空格数
				System.out.print(" ");
			}
			for (int k = 0; k <= height - i; k++){
				//k为每行*数
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void up_abc2(int height){
		System.out.println("上三角形2:");
		for (int i = 1; i <= height; i++){
			//i为行数
			for (int k = 0; k < i - 1; k++){
				//k为每行空格数
				System.out.print(" ");
			}
			for(int j = 0; j < 2 * i - 1; j++){
				//j为每行*数
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

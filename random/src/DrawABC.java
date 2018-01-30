public class DrawABC
{
	public static void main(String[] args){
		
	}
}
interface AbcProduct{
	public void draw();
}
abstract class AbcFactory{
	public abstract AbcProduct abcProduct();
}
class ZupFactory extends AbcFactory
{
	@Override
	public AbcProduct abcProduct()
	{
		// TODO: Implement this method
		return null;
	}
}
class Zup implements AbcProduct
{
	@Override
	public void draw()
	{
		System.out.println("product");
	}
}

package Baitapbuoi2;

public class Duck extends Animal {

	private boolean hasEggs;
	public Duck()
	{
		name="Duck";
		hasEggs=true;
	}
	
	public Duck(int _hp, int _age, int _eager, int _x, int _y)
	{
		name="Duck";
		hasEggs=true;
		hp=_hp;
		age=_age;
		eager = _eager;
		x=_x;
		y=_y;
	}
	@Override
	public void Move(int _x, int _y) {
		x =_x + 3;
		y =_y + 3;
		
	}
	public boolean getHasEggs()
	{
		return this.hasEggs;
	}
}

package Baitapbuoi2;

public class Sheep extends Animal {
	public Sheep(int _hp, int _age, int _eager, int _x, int _y) {
		name ="Sheep";
		hp=_hp;
		age=_age;
		eager = _eager;
		x=_x;
		y=_y;
	}
	public Sheep() {
		name ="Sheep";
	}
	@Override
	public void Move(int _x, int _y) {
		x = _x;
		y = _y;

	}

}

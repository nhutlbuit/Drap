package vidu.buoi2.farm;

public abstract class Animal {
protected int hp;
protected int eager;
protected int age;

public int getHp() {
	return hp;
}

public void setHp(int hp) {
	this.hp = hp;
}

public int getEager() {
	return eager;
}

public void setEager(int eager) {
	this.eager = eager;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public abstract void Move(int x, int y);
}


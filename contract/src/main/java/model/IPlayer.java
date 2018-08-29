package model;

public interface IPlayer extends IElement{
	public void moveUP();
	public void moveDOWN();
	public void moveLEFT();
	public void moveRIGHT();
	public boolean isAlive();
	public void setAlive(boolean b);

}

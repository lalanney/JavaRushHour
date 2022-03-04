import java.util.Random;

public enum Direction
{	
	VERTICAL,

	HORIZONTAL;

	public static Direction randomDirection()
	{
		return Direction.values()[new Random().nextInt(Direction.values().length)];
	}
}

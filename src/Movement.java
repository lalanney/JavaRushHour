
public class Movement
{

	private Direction direction;

	private Position position;
	
	private int deplacement;

	public Direction getDirection()
	{
		return this.direction;
	}

	public Position getPosition()
	{
		return this.position;
	}

	public int getDeplacement()
	{
		return this.deplacement;
	}

	public Movement(Position position, Direction direction, int deplacement)
	{
		this.direction = direction;
		this.position = position;
		this.deplacement = deplacement;
	}
}
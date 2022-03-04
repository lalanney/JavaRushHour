
public class Vehicle
{
	private Color color;

	public Color getColor()
	{
		return this.color;
	}

	private Position[] positions;

	private Direction direction;

	public Direction getDirection()
	{
		return this.direction;
	}

	public Position[] getPositions()
	{
		return this.positions;
	}

	public Vehicle(Color color, Position[] positions, Direction direction)
	{
		this.color = color;
		this.positions = positions;
		this.direction = direction;
	}
}
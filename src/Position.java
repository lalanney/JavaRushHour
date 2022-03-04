import java.util.Random;

public class Position
{
	private static final int MAX_SIZE = 6;

	private int x;

	private int y;

	public Position(int x0, int y0)
	{
		/*
		 * if(y0<0 || y0>MAX_SIZE || x0<0 || x0>MAX_SIZE) { throw new
		 * positionOutOfBoardExeption(); } else { this.x = x0; this.y = y0; }
		 */
		this.x = x0;
		this.y = y0;
	}

	public static Position aleaPosition() throws PositionOutOfBoardException
	{
		int x = new Random().nextInt(MAX_SIZE);
		int y = new Random().nextInt(MAX_SIZE);

		Position position = new Position(x, y);
		return position;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getX()
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
	}

	public boolean equals(Position posi)
	{
		if (posi.getX() == this.x && posi.getY() == this.y)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
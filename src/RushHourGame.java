
public class RushHourGame
{
	private Board board;

	private Player player;

	public RushHourGame() throws PositionOutOfBoardException
	{
		this.board = new Board();
		this.player = new Player();
	}

	public boolean isMovementValid(Movement movement) throws PositionOutOfBoardException
	{
		Vehicle[] vehicles = this.board.getVehicles();
		Position position = movement.getPosition();
		
		for (int indexVehicle = 0; indexVehicle < vehicles.length; indexVehicle++)
		{
			Position positionCurrs[] = vehicles[indexVehicle].getPositions();

			for (int indexPosition = 0; indexPosition < positionCurrs.length; indexPosition++)
			{
				if (positionCurrs[indexPosition].equals(position))
				{
					if (movement.getDirection() == vehicles[indexVehicle].getDirection())
					{
						if (movement.getDeplacement() > 0)
						{
							return moveForward(movement, vehicles, positionCurrs);
						}
						if (movement.getDeplacement() < 0)
						{
							return moveBack(movement, vehicles, positionCurrs);
						}
					}
				}
			}
		}
		return false;
	}

	private boolean moveBack(Movement movement, Vehicle[] vehicles, Position[] positionCurrs) throws PositionOutOfBoardException 
	{
		Position posimin = this.player.posiMin(positionCurrs);
		
		if (movement.getDirection() == Direction.VERTICAL)
		{
			return this.player.testVerticalMovement(posimin, movement.getDeplacement(), vehicles);
		}
		else
		{
			return this.player.testHorizontalMovement(posimin, movement.getDeplacement(), vehicles);
		}
	}

	private boolean moveForward(Movement movement, Vehicle[] vehicles, Position[] positionCurrs) throws PositionOutOfBoardException 
	{
		Position posimax = this.player.posiMax(positionCurrs);

		if (movement.getDirection() == Direction.VERTICAL)
		{
			return this.player.testVerticalMovement(posimax, movement.getDeplacement(), vehicles);
		}
		else
		{
			return this.player.testHorizontalMovement(posimax, movement.getDeplacement(), vehicles);
		}
	}

	public boolean updateMovement(Movement movement)
	{
		Vehicle[] vehicles = this.board.getVehicles();
		Position positionCurr = movement.getPosition();

		for (int indexVehicle = 0; indexVehicle < vehicles.length; indexVehicle++)
		{
			Position tabPositions[] = vehicles[indexVehicle].getPositions();
			
			for (int indexPosition = 0; indexPosition < tabPositions.length; indexPosition++)
			{
				if (tabPositions[indexPosition].equals(positionCurr))
				{
					if (movement.getDirection() == Direction.HORIZONTAL)
					{
						for (int indexTabPosition = 0; indexTabPosition < tabPositions.length; indexTabPosition++)
						{
							tabPositions[indexTabPosition].setX(tabPositions[indexTabPosition].getX() + movement.getDeplacement());
						}
						
						this.board.toString();
						return true;
					}

					if (movement.getDirection() == Direction.VERTICAL)
					{
						for (int indexTabPosition = 0; indexTabPosition < tabPositions.length; indexTabPosition++)
						{
							tabPositions[indexTabPosition].setY(tabPositions[indexTabPosition].getY() + movement.getDeplacement());
						}
						this.board.toString();
						return true;
					}
				}
			}
		}
		return false;
	}

	public void play() throws PositionOutOfBoardException
	{
		int laps = 0;
		this.board.toString();
		// Position posi = new Position(5,4);
		// Movement test = new Movement(posi, Direction.VERTICAL,1);
		while (this.board.redCarOnExit() != true)
		{

			Movement movementPlayer = this.player.randomMovement();
			while (isMovementValid(movementPlayer) == false)
			{
				movementPlayer = this.player.randomMovement();
			}
			updateMovement(movementPlayer);
			this.board.toString();
			laps++;
		}
		System.out.println("Vous avez gagné en " + laps + " coups");
	}

}
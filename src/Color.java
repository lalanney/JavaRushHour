import java.util.Random;

public enum Color
{
	RED,
	BLUE,
	YELLOW,
	GREEN,
	ORANGE,
	BLACK,
	PURPLE,
	BROWN;

	public static Color randomColor()
	{
		return Color.values()[new Random().nextInt(Color.values().length)];
	}
}

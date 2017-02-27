package nwd;

public class NWD {
	public int Euklides(int a, int b)
	{
		while (a != b)
		{
			if (a > b)
			{
				a = a - b;
			}
			else
			{
				b = b - a;
			}
		}
		return a;
	}
}

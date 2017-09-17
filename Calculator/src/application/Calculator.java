package application;

public class Calculator 
{	
	private static double num1 , num2;
	private static double result;
	
	public static void setNum(double n1, double n2)
	{
		num1 = n1;
		num2 = n2;
	}
	
	public static void add()
	{
		result = num1 + num2 ;
	}
	
	public static void subtract()
	{
		result = num1 - num2;
	}
	
	public static void multiply()
	{
		result = num1 * num2;
	}
	
	public static void divide()
	{
		result =num1 / num2;
	}
	
	public static double getResult()
	{
		return new Double(result);
	}
	
	public static void reset()
	{
		num1 = 0;
		num2 = 0;
		result = 0;
	}
}

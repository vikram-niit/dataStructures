package matrix;

import java.io.*;
public class Matrix
{
	int[][] matrix;
	int rows;
	int columns;
	
	public Matrix()
	{
		rows = 2;
		columns = 2;
		
		matrix = new int[rows+1][columns+1];	
	}
	
	public Matrix(int rows, int columns)
	{
		this.rows = rows;
		this.columns = columns;
		
		matrix = new int[rows+1][columns+1];
	}
	public static Matrix add(Matrix m1, Matrix m2) throws MatricesIncompatibleException
	{
		if((m1.rows != m2.rows) && (m1.columns != m2.columns))
			throw new MatricesIncompatibleException();
		
		Matrix result = new Matrix(m1.rows, m1.columns);
		
		for(int i=1;i<=m1.rows;i++)
			for(int j=1;j<=m1.columns;j++)
				result.matrix[i][j] = m1.matrix[i][j] + m2.matrix[i][j];	

				return result;
	}
	
	public static Matrix subtract(Matrix m1, Matrix m2) throws MatricesIncompatibleException
	{
		if((m1.rows != m2.rows) && (m1.columns != m2.columns))
			throw new MatricesIncompatibleException();
		
		Matrix result = new Matrix(m1.rows, m1.columns);
		
		for(int i=1;i<=m1.rows;i++)
			for(int j=1;j<=m1.columns;j++)
				result.matrix[i][j] = m1.matrix[i][j] - m2.matrix[i][j];

				return result;
	}
	
	public static Matrix multiply(Matrix m1, Matrix m2) throws MatricesIncompatibleException
	{
		if(m1.columns != m2.rows)
			throw new MatricesIncompatibleException();
		
		Matrix result = new Matrix(m1.rows, m2.columns);
		
		for(int i=1;i<=m1.rows;i++)
			for(int j=1;j<=m2.columns;j++)
				for(int k=1;k<=m1.rows;k++)
					result.matrix[i][j]+= m1.matrix[i][k] * m2.matrix[k][j];
				
				return result;
	}
	
	public String toString()
	{
		StringBuffer strBuffer = new StringBuffer();
		
		for(int i=1;i<=rows;i++)
		{
			for(int j=1;j<=columns;j++)
				strBuffer.append(matrix[i][j]+" ");
			
			strBuffer.append("\n");
		}
		
		return strBuffer.toString();
	}
	
	public void readMatrix()
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try{			
			System.out.println("Enter the dimensions of matrix 1");
			System.out.println("rows:");
			int rows = Integer.parseInt(reader.readLine());
			System.out.println("cols:");
			int columns = Integer.parseInt(reader.readLine());
			
			this.rows = rows;
			this.columns = columns;
			this.matrix = new int[rows+1][columns+1];
			
			System.out.println("Enter the elements");
			for(int i=1;i<=rows;i++)
				for(int j=1;j<=columns;j++)
					this.matrix[i][j] = Integer.parseInt(reader.readLine());
				
		}catch(IOException ex){
			System.out.println(ex);
		}
	}
	public static void main(String[] args)
	{
		Matrix m1 = new Matrix();
		Matrix m2 = new Matrix();
		Matrix result = new Matrix();
		
		m1.readMatrix();
		
		m2.readMatrix();
		
		System.out.println("===============================");
		System.out.println("Matrix 1");
		System.out.println("===============================");
		System.out.println(m1);
		System.out.println("===============================");
		System.out.println("Matrix 2");
		System.out.println("===============================");
		System.out.println(m2);
		System.out.println();		
		
		try{
			System.out.println("===============================");
			System.out.println("Matrix Addition");
			System.out.println("===============================");
			result = add(m1, m2);
			System.out.println(result);
			
			
			System.out.println("===============================");
			System.out.println("Matrix Subtraction");
			System.out.println("===============================");
			result = subtract(m1, m2);
			System.out.println(result);
		}
		catch(MatricesIncompatibleException ex){
			System.out.println(ex);
		}finally{
			try{
				System.out.println("===============================");
				System.out.println("Matrix Multiplication");
				System.out.println("===============================");
				result = multiply(m1, m2);
				System.out.println(result);
			
			}catch(MatricesIncompatibleException ex){
				System.out.println(ex);
			}
		}				
		
	}
}
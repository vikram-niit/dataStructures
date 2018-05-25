package linearList;

public class ArrayMain
{
	public static void main(String[] args)
	{
		
		LinearList<Integer> list = new ArrayLinearList<Integer>(Integer.class, 5);

		list.add(1, 0);
		list.add(2, 1);
		list.add(3, 2);
		list.add(4, 3);

		System.out.println(list);

		list.add(5, 2);
		
		System.out.println("list after adding 5 at index 2 :"+list);

		list.remove(3);
		
		System.out.println("list after removing element 3 from the list :"+list);

		System.out.println("IndexOf 5 = "+list.indexOf(5));
		
		list.add(100, 2);

		System.out.println("list after adding 100 at index 2 :"+list);
		
		System.out.println("getI(4) = "+list.get(4));

		list.add(200, 5);
	
		System.out.println("list after adding element at position 5 : "+list);
	}
}

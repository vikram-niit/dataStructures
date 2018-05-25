package polynomialAddAndSubtract;

import polynomialAddAndSubtract.*;

public class PolynomialAddAndSubtract
{
	private DoublyLinkedList quotientList;
	private DoublyLinkedList remainderList;
	
	
	public PolynomialAddAndSubtract()
	{
		quotientList = new DoublyLinkedList();
		remainderList = new DoublyLinkedList();
	}
	public DoublyLinkedList getQuotientList()
	{
		return this.quotientList;
	}
	
	public DoublyLinkedList getRemainderList()
	{
		return this.remainderList;
	}
	
	public DoublyLinkedList add(DoublyLinkedList list1, DoublyLinkedList list2)
	{ 		
		Node temp1 = list1.getHead();
		Node temp2 = list2.getHead();
		DoublyLinkedList resultList = new DoublyLinkedList();
		
		
			// traverse to the end of the 2 lists and evaluate from the last
			// starting from coefficients of the terms with power zero	
			if(temp1 != null)
			while(temp1.getRight() != null)
				temp1 = temp1.getRight();
			
			if(temp2 != null)
			while(temp2.getRight() != null)
				temp2 = temp2.getRight();
			
			int result = 0;
			while(temp1 != null && temp2 != null)
			{
				result = temp1.getData() + temp2.getData();
				
				Node newNode = new Node();
				newNode.setData(result);
				
				resultList.insertAtTheBeginning(newNode);
				
				temp1 = temp1.getLeft();
				temp2 = temp2.getLeft();
			}
		
		
		//if degree of polynomial 1 is less than that of polynomial 2
		// copy the remaining coefficients of polynomial 2 to resultList
		if(temp1 == null)
		{
			while(temp2 != null)
			{
				Node newNode = new Node();
				newNode.setData(temp2.getData());
				
				resultList.insertAtTheBeginning(newNode);
				
				temp2 = temp2.getLeft();
			}
		}
		// if degree of polynomial 1 is greater than that of polynomial 2
		// copy the remaining coefficients of polynomial 1 to resultList
		else if(temp2 == null)
		{
			while(temp1 != null)
			{
				Node newNode = new Node();
				newNode.setData(temp1.getData());
				
				resultList.insertAtTheBeginning(newNode);
				
				temp1 = temp1.getLeft();
			}// End of while
		}// End of if-else		
			
		return resultList;
	}	
	
	public DoublyLinkedList subtract(DoublyLinkedList list1, DoublyLinkedList list2)
	{ 			
		Node temp1 = list1.getHead();
		Node temp2 = list2.getHead();
		DoublyLinkedList resultList = new DoublyLinkedList();
		
		
			// traverse to the end of the 2 lists and evaluate from the last
			// starting from coefficients of the terms with power zero	
			if(temp1 != null)
			while(temp1.getRight() != null)
				temp1 = temp1.getRight();
			
			if(temp2 != null)
			while(temp2.getRight() != null)
				temp2 = temp2.getRight();
			
			int result = 0;
			while(temp1 != null && temp2 != null)
			{
				result = temp1.getData() - temp2.getData();
				
				Node newNode = new Node();
				newNode.setData(result);
				
				resultList.insertAtTheBeginning(newNode);
				
				temp1 = temp1.getLeft();
				temp2 = temp2.getLeft();
			}
		
		
		//if degree of polynomial 1 is less than that of polynomial 2
		// copy the remaining coefficients of polynomial 2 to resultList
		if(temp1 == null)
		{
			while(temp2 != null)
			{
				Node newNode = new Node();
				newNode.setData(temp2.getData());
				
				resultList.insertAtTheBeginning(newNode);
				
				temp2 = temp2.getLeft();
			}
		}
		// if degree of polynomial 1 is greater than that of polynomial 2
		// copy the remaining coefficients of polynomial 1 to resultList
		else if(temp2 == null)
		{
			while(temp1 != null)
			{
				Node newNode = new Node();
				newNode.setData(temp1.getData());
				
				resultList.insertAtTheBeginning(newNode);
				
				temp1 = temp1.getLeft();
			}// End of while
		}// End of if-else		
			
		return resultList;
	}	
	
	public DoublyLinkedList multiply(DoublyLinkedList list1, DoublyLinkedList list2)
	{
			Node temp1 = list1.getHead();
			Node temp2 = list2.getHead();
			
			int degree1 = list1.getCount() - 1;
			int degree2 = list2.getCount() - 1;
			
			DoublyLinkedList resultList = new DoublyLinkedList();
			DoublyLinkedList partialProduct = new DoublyLinkedList();
			
			int coefficient = 0;
			
			//multiply each coefficient of the 2nd polynomial with each term of the 1st polynomial
			while(temp2 != null)
			{
				coefficient = temp2.getData();
				
				// get the head pointer of the first polynomial
				temp1 = list1.getHead();
				// create a new list to hold partial product in each iteration
				partialProduct = new DoublyLinkedList();
				
				//multiply the coefficient with the each term of the 1st polynomial
				while(temp1 != null)
				{
					int result = temp1.getData() * coefficient;
					Node newNode = new Node(result);
					
					partialProduct.insertAtTheEnd(newNode);
					
					temp1 = temp1.getRight();
				}
				
				// increase the degree of each term of the partial product degree of the 
				// current term of the 2nd polynomial by shifting the polynomial and 
				// adding new nodes at the end
				int i = degree2;
				while(i!=0)
				{
					partialProduct.insertAtTheEnd(new Node(0));
					i--;	
				}
				// decrement degree of the 2nd polynomial, consider the next term of the 2nd polynomial
				degree2--;
				
				// add partial product to the resultList
				resultList = this.add(resultList, partialProduct);
				
				temp2 = temp2.getRight();
			}
			
			return resultList;
	}
	
	public DoublyLinkedList divide(DoublyLinkedList list1, DoublyLinkedList list2)
	{
		Node dividend = list1.getHead();
		Node divisor = list2.getHead();
		
		int degree1 = list1.getCount() - 1;
		int degree2 = list2.getCount() - 1;
		
		DoublyLinkedList partialQuotient = new DoublyLinkedList();
		DoublyLinkedList partialRemainder = new DoublyLinkedList();
		DoublyLinkedList partialProduct = new DoublyLinkedList();
		
		// copy list1 to partialRemainder
		partialRemainder = subtract(list1, partialProduct);
		System.out.println("partial remainder = "+partialRemainder);
		System.out.println("list1 = "+list1);
		
		System.out.println((partialRemainder.getCount() - 1) + (list2.getCount() - 1));
		// while degree of partialRemainder >= degree of divisor(list2)
		// compute partialQuotient
		// compute partialProduct
		// compute partialRemainder
		while((partialRemainder.getCount() - 1) >= (list2.getCount() - 1))
		{			
				partialProduct = new DoublyLinkedList();
				partialQuotient = new DoublyLinkedList();
				
				// compute partialQuotient
				int quotient = partialRemainder.getHead().getData() / divisor.getData();
				partialQuotient.insertAtTheEnd(new Node(quotient));
				
				// shift the quotient by the degree difference of partialRemainder and divisor
				int degreeDifference = (partialRemainder.getCount() - 1 ) - (list2.getCount() - 1);				
				
				
				// shift the quotient by adding new nodes at the end
				while(degreeDifference != 0)
				{
					partialQuotient.insertAtTheEnd(new Node(0));
					degreeDifference--;
				}				
				
				// End of computing partialQuotient
				
				// compute PartialProduct
				partialProduct = multiply(list2, partialQuotient);
				// End of compute PartialProduct				
				// System.out.println("partialProduct="+partialProduct);
				
				// compute PartialRemainder
				partialRemainder = subtract(partialRemainder, partialProduct);
				// System.out.println("partial remainder = "+partialRemainder);				
				
				
				// shift the remainder right by deleting the nodes with zero coefficients
				Node temp = partialRemainder.getHead();			
				
				while(temp != null)
				{
					if(temp.getData() != 0) break;
					
					temp = temp.getRight();
					partialRemainder.deleteFirst();
				}
				
				// System.out.println("partial remainder after deleting nodes with zero coefficients = "+partialRemainder);				
				// End of computePartialRemainder							
				
				quotientList  = add(quotientList, partialQuotient);								
		}
		
		remainderList = partialRemainder;
		 
		return partialRemainder;		
	}
	
	public static void main(String[] args)
	{
		DoublyLinkedList list1 = new DoublyLinkedList();
		DoublyLinkedList list2 = new DoublyLinkedList();
		
		PolynomialAddAndSubtract p = new PolynomialAddAndSubtract();
		
		list1.insertAtTheBeginning(new Node(1));
		list1.insertAtTheBeginning(new Node(2));
		list1.insertAtTheBeginning(new Node(1));
		
		list2.insertAtTheBeginning(new Node(1));
		list2.insertAtTheBeginning(new Node(1));
		//list2.insertAtTheBeginning(new Node(9));
		//list2.insertAtTheBeginning(new Node(9));
		//list2.insertAtTheBeginning(new Node(9));
	
		System.out.println("======================");
		System.out.println("Polynomial addition");
		System.out.println("======================");
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(p.add(list1, list2));
		
		
		System.out.println();
		System.out.println("======================");
		System.out.println("Polynomial subtraction");
		System.out.println("======================");
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(p.subtract(list1, list2));
		
		System.out.println();
		System.out.println("======================");
		System.out.println("Polynomial Multiplication");
		System.out.println("======================");
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(p.multiply(list1, list2));
		
		System.out.println();
		System.out.println("======================");
		System.out.println("Polynomial Division");
		System.out.println("======================");
		System.out.println(list1);
		System.out.println(list2);
		System.out.println("Remainder = "+p.divide(list1, list2));
		System.out.println("Quotient = "+p.getQuotientList());
		
	
	}
	
}

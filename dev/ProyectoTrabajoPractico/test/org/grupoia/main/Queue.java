package org.grupoia.main;

class Queue
{
	int n;
	Link front, rear;
	
	public Queue()
	{
		n = 0;//# of items on the queue
		front = null;
		rear = null;
	}
	
	public boolean isEmpty()
	{
		return front == null;
	}
	
	public void addNode(Object obj)
	{
		Link temp = new Link();
		temp.info =(Object) obj;
		n++;
		temp.next = null;
		if(isEmpty() )
		{
			front = temp;
		}
		else
		{
			rear.next = temp;
		}
		rear = temp;
	}
	
	public Object remove()
	{
		if(isEmpty() )
		{
			throw new EmptyStackException("Sorry: MT stack");
		}
		n--;
		Object temp = front.info;
		front = front.next;
		return temp;
	}
	
	public int size()
	{
		return n;
	}
	
	public void print()
	{
		Link temp = front;
		while(temp != null)
		{
			System.out.print(temp);
			temp = temp.next;
		}
		System.out.println();
	}	
}


class Link
{
	Object info;
	Link next;
	
	public String toString()
	{
		return "" + info;
	}
}

class EmptyStackException extends RuntimeException
{
	public EmptyStackException()
	{
		super();
	}
	
	public EmptyStackException(String s)
	{
		super(s);
	}
}

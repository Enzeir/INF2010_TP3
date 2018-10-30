import java.util.List;

public class BinaryNode<T extends Comparable<? super T> > {
    private T data;
    private BinaryNode<T> right;
    private BinaryNode<T> left;

    // TODO: initialisation
    // O(1)
    public BinaryNode(T data) 
    {
    	this.data = data;
    	this.right = null;
    	this.left = null;
    }

    // TODO: on retourne la donnee voulue
    // O(1)
    public T getData() 
    {
        return data;
    }

    // TODO: on ajoute une nouvelle donnee au bon endroit
    // O(log(n))
    public void insert(T item) 
    {
    	if(item.compareTo(this.data) <= 0)
    	{
    		if(this.left != null)
    		{
    			this.left.insert(item);
    		}
    		else 
    		{
    			this.left = new BinaryNode<T>(item);
    		}
    	}
    	else
    	{
    		if(this.right != null)
    		{
    			this.right.insert(item);
    		}
    		else 
    		{
    			this.right = new BinaryNode<T>(item);
    		}
    	}
    }

    // TODO: est-ce que l'item fais partie du noeuds courant
    // O(log(n))
    public boolean contains(T item) {
    	boolean containsValue = false;
    	if(data.compareTo(item) == 0)
    	{
    		containsValue = true;
    	}
    	else if(data.compareTo(item) > 0 && left != null )
    	{
    		containsValue = left.contains(item);
    	}
    	else if(data.compareTo(item) < 0 && right != null)
    	{
    		containsValue = right.contains(item);
    	}
        return containsValue;
    }

    // TODO: on retourne la maximale de l'arbre
    // O(n)
    public int getHeight() {
    	int height = 0;  	
    	if(left != null && right != null)
    	{
    		height = Math.max(left.getHeight(), right.getHeight())+1;
    	}else if(right != null)
    	{
    		height = right.getHeight() + 1;
    	}
    	else if(left != null)
    	{
    		height = left.getHeight() + 1;
    	}    	
    	
        return height;
    }

    // TODO: l'ordre d'insertion dans la liste est l'ordre logique
    // de manière que le plus petit item sera le premier inseré
    // O(n)
    public void fillListInOrder(List<BinaryNode<T>> result) {
    	if(left != null) 
    	{
    		left.fillListInOrder(result);
    	}
    	result.add(this);
    	if(right!= null)
    	{
    		right.fillListInOrder(result);
    	}
    }
}

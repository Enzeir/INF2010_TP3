import java.util.List;

public class CompanyNode implements Comparable<CompanyNode> {
    private Integer money;
    private BinarySearchTree<CompanyNode> childs;
    public CompanyNode worstChild;

    // TODO: initialisation
    // O(1)
    public CompanyNode(Integer data) {
    	money = data;
    	childs = null ;
    	worstChild = this;
    }

    // TODO: la compagnie courante achete une autre compagnie
    // O(log(n))
    public void buy(CompanyNode item) {
    	if(childs == null) {
    		childs = new BinarySearchTree<>(item);
    	}else {
    		childs.insert(item);
    	}
    	
    	money += item.getMoney();
    	
    	
    	if(worstChild.getMoney() > item.worstChild.getMoney())
    	{
    		worstChild = item.worstChild;
    	}
    }

    // TODO: on retourne le montant en banque de la compagnie
    // O(1)
    public Integer getMoney() {
        return money;
    }

    // TODO: on rempli le builder de la compagnie et de ses enfants avec le format
    //A
    // > A1
    // > A2
    // >  > A21...
    // les enfants sont afficher du plus grand au plus petit (voir TestCompany.testPrint)
    // O(n)
    public void fillStringBuilderInOrder(StringBuilder builder, String prefix) {    	
    	builder.append(getMoney().toString()+"\n");

    	String test = prefix;
    	
    	
    	if(childs != null) {
    		for(int i = childs.getItemsInOrder().size() - 1; i>= 0; i--) {
    	    	builder.append(prefix);
    	    	
    	    	if(childs.getItemsInOrder().get(i).getData().childs != null)
    	    		prefix += " > ";
    	    	else
    	    	if(i == 0)
    	    		prefix = prefix.substring(2, prefix.length()-1);
    	    	
    			childs.getItemsInOrder().get(i).getData().fillStringBuilderInOrder(builder, prefix);
    		}
    		
    		
    	}
    	
    }

    // TODO: on override le comparateur pour defenir l'ordre
    @Override
    public int compareTo(CompanyNode item) {
        return money - item.getMoney();
    }
    
    public String toString()
    {
    	return getMoney().toString();
    }
}

package org.cytoscape.cyTron.internal.model;

/**
 *
 * @author alex
 */
public class Gene {
    
    private final String name;

    public Gene(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 37*result + this.name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof Gene))
            return false;
       
       if (obj == this)
            return true;
       
       Gene gene = (Gene) obj;
       return this.name.equals(gene.getName());
    }
    
    
    
}

package org.cytoscape.cyTron.internal.model;

/**
 *
 * @author alex
 */
public class Event {

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Gene getGene() {
        return gene;
    }
    
    private EventType eventType;
    private Gene gene;

    public Event(EventType eventType, Gene gene) {
        this.eventType = eventType;
        this.gene = gene;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 37*result + 
                this.eventType.hashCode() + 
                this.gene.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof Event))
            return false;
        if (obj == this)
            return true;

        Event event = (Event) obj;
        return this.eventType.equals(event.getEventType()) &&
                this.gene.equals(event.getGene());
    } 
    
}

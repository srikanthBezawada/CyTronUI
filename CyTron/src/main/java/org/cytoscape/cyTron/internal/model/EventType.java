package org.cytoscape.cyTron.internal.model;

import java.awt.Color;

public class EventType {

    String name;
    Color color;

    public EventType(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 37*result + this.name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof EventType))
            return false;
       
       if (obj == this)
            return true;
       
       EventType eventType = (EventType) obj;
       return this.name.equals(eventType.getName());
    }

}

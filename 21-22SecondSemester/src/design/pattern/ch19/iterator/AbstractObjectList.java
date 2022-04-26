package design.pattern.ch19.iterator;

import java.util.List;

public abstract class AbstractObjectList {
    
    protected List<Object> objects;
    
    public AbstractObjectList(List<Object> objects) {
        this.objects = objects;
    }
    
    public void addObject(Object object) {
        this.objects.add(object);
    }
    
    public void removeObject(Object object) {
        this.objects.remove(object);
    }
    
    public List<Object> getObjects() {
        return objects;
    }
    
    public abstract AbstractIterator createIterator();
}

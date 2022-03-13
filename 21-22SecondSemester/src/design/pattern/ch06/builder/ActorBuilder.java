package design.pattern.ch06.builder;

public abstract class ActorBuilder {
    protected Actor actor = new Actor();
    
    public abstract void buildType();
    public abstract void buildSex();
    public abstract void buildFace();
    public abstract void buildCostume();
    public abstract void buildHairStyle();
    
    /**
     * 钩子方法
     */
    public boolean isBareHeaded() {
        return false;
    }
    
    public Actor createActor() {
        return actor;
    }
}

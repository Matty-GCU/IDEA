package design.pattern.ch06.builder;

public class AngelBuilder extends ActorBuilder {
    @Override
    public void buildType() {
        actor.setType("天使");
    }
    
    @Override
    public void buildSex() {
        actor.setSex("女");
    }
    
    @Override
    public void buildFace() {
        actor.setFace("美丽");
    }
    
    @Override
    public void buildCostume() {
        actor.setCostume("白裙");
    }
    
    @Override
    public void buildHairStyle() {
        actor.setHairStyle("长发");
    }
}

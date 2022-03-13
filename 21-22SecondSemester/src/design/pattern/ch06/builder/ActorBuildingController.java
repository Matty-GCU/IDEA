package design.pattern.ch06.builder;

public class ActorBuildingController {
    
    public Actor build(ActorBuilder actorBuilder) {
        actorBuilder.buildType();
        actorBuilder.buildSex();
        actorBuilder.buildFace();
        actorBuilder.buildCostume();
        if(! actorBuilder.isBareHeaded()) {
            actorBuilder.buildHairStyle();
        }
        Actor actor = actorBuilder.createActor();
        return actor;
    }
    
}

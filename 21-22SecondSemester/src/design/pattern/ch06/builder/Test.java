package design.pattern.ch06.builder;

import design.pattern.ch04.factorymethod.XMLUtil;

public class Test {
    public static void main(String[] args) {
        ActorBuilder actorBuilder
            = (ActorBuilder) XMLUtil.getObjectFromXMLByTagName("src/design/pattern/ch06/builder/config.xml", "actorBuilder");
        ActorBuildingController controller = new ActorBuildingController();
        Actor actor = controller.build(actorBuilder);
        System.out.println(actor);
    }
}

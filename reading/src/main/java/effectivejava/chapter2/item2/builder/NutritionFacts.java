package effectivejava.chapter2.item2.builder;

// ABuilder Pattern  (Page 13)
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;

        // Optional parameters - initialized to default values
        private int calories      = 0;
        private int fat           = 0;
        private int sodium        = 0;
        private int carbohydrate  = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings    = servings;
        }

        public Builder calories(int val)
        { calories = val;      return this; }
        public Builder fat(int val)
        { fat = val;           return this; }
        public Builder sodium(int val)
        { sodium = val;        return this; }
        public Builder carbohydrate(int val)
        { carbohydrate = val;  return this; }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

//    private NutritionFacts(Builder builder) {
    NutritionFacts(Builder builder) {
        servingSize  = builder.servingSize;
        servings     = builder.servings;
        calories     = builder.calories;
        fat          = builder.fat;
        sodium       = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
        
        //经历向上强转
        Child child = ((Child.ABuilder)(new Child.ABuilder(240, 8).calories(100).sodium(35))).abc(15).build();
    }
}


/**
 * 子类新增了一个属性，如果没有采取【递归类型参数】和【模拟的self类型】这两种解决方案，则必须要经历强制类型转换
 */
class Child extends NutritionFacts {
    //新增的属性
    private int abc;
    
    public static class ABuilder extends NutritionFacts.Builder {
        //新增的属性
        private int abc;
        
        public ABuilder abc(int abc) {
            this.abc = abc;
            return this;
        }
        
        public ABuilder(int servingSize, int servings) {
            super(servingSize, servings);
        }
        
        @Override
        public Child build() {
            return new Child(this);
        }
    }
    
    private Child(ABuilder aBuilder) {
        super(aBuilder);
        this.abc = aBuilder.abc;
    }
}
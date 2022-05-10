package com.example.springbootenableothers.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    /**
     * Select and return the names of which class(es) should be imported based on
     * the {@link AnnotationMetadata} of the importing @{@link Configuration} class.
     * @return the class names, or an empty array if none
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //既然是字符串，那就可以是动态传入的，不用写死
        return new String[]{"com.example.springbootenableothers.pojo.Admin", "com.example.springbootenableothers.pojo.User"};
    }
}

package com.allen.spring.keep.importbean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author allen
 * @descript
 * @date 2020-03-21 8:09 PM
 */
public class AllenImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.allen.spring.keep.importbean.Triger"};
    }
}

package com.allen.spring.keep.importbean;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author allen
 * @descript
 * @date 2020-03-21 8:17 PM
 */
public class AllenImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata 当前类的注解信心
     * @param registry
     * @param importBeanNameGenerator
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry,
                                         BeanNameGenerator importBeanNameGenerator) {

        boolean bean1 = registry.containsBeanDefinition("com.allen.spring.keep.importbean.Dog");
        boolean bean2 = registry.containsBeanDefinition("com.allen.spring.keep.importbean.Cat");
        // 如果Dog和Cat同时存在于我们的IOC容器中，那么创建Pig类加入到容器
        // 对于我们要注册的bean,给bean进行封装

        if (bean1 && bean2){
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Pig.class);
            registry.registerBeanDefinition("pig",rootBeanDefinition);
        }
    }
}

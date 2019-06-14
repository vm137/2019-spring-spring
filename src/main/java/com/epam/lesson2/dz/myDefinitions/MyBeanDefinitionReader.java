package com.epam.lesson2.dz.myDefinitions;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class MyBeanDefinitionReader extends AbstractBeanDefinitionReader {

    /**
     * Create a new AbstractBeanDefinitionReader for the given bean factory.
     * <p>If the passed-in bean factory does not only implement the BeanDefinitionRegistry
     * interface but also the ResourceLoader interface, it will be used as default
     * ResourceLoader as well. This will usually be the case for
     * {@link ApplicationContext} implementations.
     * <p>If given a plain BeanDefinitionRegistry, the default ResourceLoader will be a
     * {@link PathMatchingResourcePatternResolver}.
     * <p>If the passed-in bean factory also implements "@link EnvironmentCapable" its
     * environment will be used by this reader.  Otherwise, the reader will initialize and
     * use a "@link StandardEnvironment". All ApplicationContext implementations are
     * EnvironmentCapable, while normal BeanFactory implementations are not.
     *
     * @param registry the BeanFactory to load bean definitions into,
     *                 in the form of a BeanDefinitionRegistry
     * @see #setResourceLoader
     * @see #setEnvironment
     */
    public MyBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    /**
     * Load bean definitions from the specified resource.
     *
     * @param resource the resource descriptor
     * @return the number of bean definitions found
     * @throws BeanDefinitionStoreException in case of loading or parsing errors
     */
    @Override
    public int loadBeanDefinitions(Resource resource) throws BeanDefinitionStoreException {
        String beanName;
        GenericBeanDefinition beanDefinition;

        beanDefinition = new GenericBeanDefinition();
        beanName = "indexService";
        beanDefinition.setBeanClass(com.epam.lesson2.dz.application.IndexService.class);
        getRegistry().registerBeanDefinition(beanName, beanDefinition);

        beanDefinition = new GenericBeanDefinition();
        beanName = "indexApp";
        beanDefinition.setBeanClass(com.epam.lesson2.dz.application.IndexApp.class);

        ConstructorArgumentValues values2 = new ConstructorArgumentValues();
        values2.addGenericArgumentValue(new RuntimeBeanReference("indexService"));
        beanDefinition.setConstructorArgumentValues(values2);
        getRegistry().registerBeanDefinition(beanName, beanDefinition);

        return getRegistry().getBeanDefinitionNames().length;
    }
}

// equivalent in application-conf.xml
//
//    <bean
//      id="indexService"
//    class="com.baeldung.di.spring.IndexService" />
//
//    <bean
//      id="indexApp"
//    class="com.baeldung.di.spring.IndexApp" >
//    <property name="service" ref="indexService" />
//    </bean>

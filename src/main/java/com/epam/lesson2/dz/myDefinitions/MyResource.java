package com.epam.lesson2.dz.myDefinitions;

import org.springframework.core.io.AbstractResource;

import java.io.*;
import java.util.Set;

public class MyResource extends AbstractResource {
    private Set<MyBeanDefinition> myBeans;

    public void setMyBeans(Set<MyBeanDefinition> myBeans) {
        this.myBeans = myBeans;
    }

    public Set<MyBeanDefinition> getMyBeans() {
        return myBeans;
    }

    @Override
    public String getDescription() {
        return null;
    }

    /**
     * Return an {@link InputStream} for the content of an underlying resource.
     * <p>It is expected that each call creates a <i>fresh</i> stream.
     * <p>This requirement is particularly important when you consider an API such
     * as JavaMail, which needs to be able to read the stream multiple times when
     * creating mail attachments. For such a use case, it is <i>required</i>
     * that each {@code getInputStream()} call returns a fresh stream.
     *
     * @return the input stream for the underlying resource (must not be {@code null})
     * @throws FileNotFoundException if the underlying resource doesn't exist
     * @throws IOException           if the content stream could not be opened
     */
    @Override
    public InputStream getInputStream() throws IOException {
        return null;
    }
}

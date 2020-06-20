package com.frontbackend.thymeleaf.dialect;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;

@Component
public class WelcomeDialect extends AbstractProcessorDialect {

    public WelcomeDialect() {
        super("FrontBackend Dialect", // Dialect name
                "frontbackend", // Dialect prefix (frontbackend:*)
                1000); // Dialect precedence
    }

    @Override
    public Set<IProcessor> getProcessors(String s) {
        final Set<IProcessor> processors = new HashSet<>();
        processors.add(new WelcomeToAttributeTagProcessor(getPrefix()));
        processors.add(new WelcomeHeaderTagProcessor(getPrefix()));
        return processors;
    }
}

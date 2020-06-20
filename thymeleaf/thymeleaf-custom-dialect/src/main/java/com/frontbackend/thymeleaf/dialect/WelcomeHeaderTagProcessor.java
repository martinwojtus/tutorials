package com.frontbackend.thymeleaf.dialect;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;
import org.unbescape.html.HtmlEscape;

public class WelcomeHeaderTagProcessor extends AbstractElementTagProcessor {

    private static final String TAG_NAME = "header";
    private static final int PRECEDENCE = 1000;

    public WelcomeHeaderTagProcessor(final String dialectPrefix) {
        super(TemplateMode.HTML, dialectPrefix, TAG_NAME, true, null, false, PRECEDENCE);
    }

    @Override
    protected void doProcess(final ITemplateContext context, final IProcessableElementTag tag, final IElementTagStructureHandler structureHandler) {
        final String title = tag.getAttributeValue("title");

        final IModelFactory modelFactory = context.getModelFactory();
        final IModel model = modelFactory.createModel();

        model.add(modelFactory.createOpenElementTag("h1"));
        model.add(modelFactory.createText(HtmlEscape.escapeHtml5(title)));
        model.add(modelFactory.createCloseElementTag("h1"));

        structureHandler.replaceWith(model, false);
    }
}

package grails.plugin.react.view

import grails.plugin.react.view.internal.ReactViewsTransform
import grails.views.ResolvableGroovyTemplateEngine
import grails.views.ViewConfiguration
import grails.views.compiler.ViewsTransform
import groovy.transform.CompileStatic
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.ASTTransformationCustomizer

/**
 * A template engine for parsing React views
 *
 * @author Graeme Rocher
 * @since 1.0
 */
@CompileStatic
class ReactViewTemplateEngine extends ResolvableGroovyTemplateEngine {
    private final boolean compileStatic

    /**
     * Constructs a ReactViewTemplateEngine with the default configuration
     */
    ReactViewTemplateEngine() {
        this(new ReactViewConfiguration())
    }

    /**
     * Constructs a ReactViewTemplateEngine with a custom base class
     *
     * @param baseClassName The name of the base class
     */
    ReactViewTemplateEngine(ViewConfiguration configuration) {
        super(configuration)
        this.compileStatic = configuration.compileStatic
    }

    @Override
    protected ViewsTransform newViewsTransform() {
        return new ReactViewsTransform(viewConfiguration.extension)
    }

    @Override
    String getDynamicTemplatePrefix() {
        "ReactView".intern()
    }

}

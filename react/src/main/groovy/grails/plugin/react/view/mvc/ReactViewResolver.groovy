package grails.plugin.react.view.mvc

import grails.core.support.proxy.ProxyHandler
import grails.plugin.react.renderer.ReactViewHtmlRenderer
import grails.plugin.react.view.ReactViewConfiguration
import grails.plugin.react.view.ReactViewTemplate
import grails.plugin.react.view.ReactViewTemplateEngine
import grails.rest.render.RendererRegistry
import grails.views.mvc.SmartViewResolver
import grails.web.mime.MimeType
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired

import javax.annotation.PostConstruct
/**
 * @author Graeme Rocher
 * @since 1.0
 */
@CompileStatic
class ReactViewResolver extends SmartViewResolver {

    public static final String REACT_VIEW_SUFFIX = ".${ReactViewTemplate.EXTENSION}"

    @Autowired(required = false)
    ProxyHandler proxyHandler

    @Autowired(required = false)
    RendererRegistry rendererRegistry


    ReactViewResolver(ReactViewConfiguration configuration = new ReactViewConfiguration()) {
        super(new ReactViewTemplateEngine(configuration))
        setSuffix(REACT_VIEW_SUFFIX)
        setContentType(MimeType.HTML.name)
    }

    ReactViewResolver(ReactViewTemplateEngine templateEngine) {
        super(templateEngine)
    }

    @PostConstruct
    void initialize() {
        if(rendererRegistry != null) {
            def defaultReactRenderer = rendererRegistry.findRenderer(MimeType.HTML, Object.class)

            rendererRegistry.addDefaultRenderer(
                    new ReactViewHtmlRenderer<Object>(Object.class, this , proxyHandler, rendererRegistry, defaultReactRenderer)
            )
        }
    }
}

package grails.plugin.react.renderer

import grails.core.support.proxy.ProxyHandler
import grails.rest.render.Renderer
import grails.rest.render.RendererRegistry
import grails.views.mvc.SmartViewResolver
import grails.views.mvc.renderer.DefaultViewRenderer
import grails.web.mime.MimeType
import groovy.transform.CompileStatic

/**
 * A renderer that will lookup a JSON view if it exists and render it, otherwise fallback to default
 *
 * @author Graeme Rocher
 * @since 1.0
 */
@CompileStatic
class ReactViewHtmlRenderer<T> extends DefaultViewRenderer<T> {


    ReactViewHtmlRenderer(Class<T> targetType, SmartViewResolver viewResolver, ProxyHandler proxyHandler, RendererRegistry rendererRegistry, Renderer defaultRenderer) {
        super(targetType, MimeType.HTML, viewResolver, proxyHandler, rendererRegistry, defaultRenderer)
    }

    ReactViewHtmlRenderer(Class<T> targetType, MimeType mimeType, SmartViewResolver viewResolver, ProxyHandler proxyHandler, RendererRegistry rendererRegistry, Renderer defaultRenderer) {
        super(targetType, mimeType, viewResolver, proxyHandler, rendererRegistry, defaultRenderer)
    }

}

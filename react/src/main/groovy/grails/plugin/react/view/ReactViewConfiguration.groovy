package grails.plugin.react.view

import grails.views.GenericViewConfiguration
import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Default configuration for JSON views
 *
 * @author Graeme Rocher
 * @since 1.0
 */
@ConfigurationProperties('grails.views.react')
class ReactViewConfiguration implements GenericViewConfiguration {


    public static final String MODULE_NAME = "react"

    ReactViewConfiguration() {
        setExtension(ReactViewTemplate.EXTENSION)
        setCompileStatic(true)
        setBaseTemplateClass(ReactViewTemplate)
    }

    @Override
    String getViewModuleName() {
         MODULE_NAME
    }
}

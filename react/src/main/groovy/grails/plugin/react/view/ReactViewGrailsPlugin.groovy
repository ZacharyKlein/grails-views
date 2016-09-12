package grails.plugin.react.view

import grails.plugin.react.view.mvc.ReactViewResolver
import grails.plugins.*
import grails.views.mvc.GenericGroovyTemplateViewResolver
import grails.views.resolve.PluginAwareTemplateResolver

class ReactViewGrailsPlugin extends Plugin {

    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "3.1.0 > *"

    def title = "React View" // Headline display name of the plugin
    def author = "Chris Rosburg"
    def authorEmail = "info@chris-rosburg.de"
    def description = '''\
A plugin that allows rendering of React views
'''
    def profiles = ['web']

    // URL to the plugin's documentation
    def documentation = "http://grails.github.io/grails-views/latest"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
    def organization = [ name: "Virtual Blue", url: "http://www.virtual-blue.com/" ]

    // Any additional developers beyond the author specified above.
    def developers = [ [ name: "Chris Rosburg", email: "info@chris-rosburg.de" ]]

    // Location of the plugin's issue tracker.
    def issueManagement = [ system: "Github", url: "http://github.com/grails/grails-views/issues" ]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "http://github.com/grails/grails-views" ]

    Closure doWithSpring() { {->
            reactViewConfiguration(ReactViewConfiguration)
            reactSmartViewResolver(ReactViewResolver, reactViewConfiguration) {
                templateResolver = bean(PluginAwareTemplateResolver, reactViewConfiguration)
            }
            reactViewResolver(GenericGroovyTemplateViewResolver,  reactSmartViewResolver )
        }
    }
}

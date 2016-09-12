package grails.plugin.react.view

import grails.plugin.react.view.api.ReactView
import grails.views.AbstractWritableScript
import groovy.transform.CompileStatic
import groovy.transform.InheritConstructors


/**
 * All JSON views subclass this superclass
 *
 * @author Graeme Rocher
 * @since 1.0
 */
@CompileStatic
@InheritConstructors
abstract class ReactViewTemplate extends AbstractWritableScript implements ReactView {
    public static final String EXTENSION = "jsx"
    public static final String TYPE = "view.jsx"

    @Override
    Writer doWrite(Writer out) throws IOException {
        run()
        return out
    }
}
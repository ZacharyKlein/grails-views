package grails.plugin.react.view.internal

import grails.compiler.traits.TraitInjector
import grails.plugin.react.view.ReactViewTemplate
import grails.views.compiler.ViewsTransform
import groovy.transform.CompileStatic
import groovy.transform.InheritConstructors
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.transform.GroovyASTTransformation
import org.grails.core.io.support.GrailsFactoriesLoader

/**
 * @author Graeme ROcher
 * @since 1.0
 */
@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
@CompileStatic
@InheritConstructors
class ReactViewsTransform extends ViewsTransform {
    @Override
    protected List<TraitInjector> findTraitInjectors() {
        def injectors = super.findTraitInjectors()

        injectors += GrailsFactoriesLoader.loadFactories(TraitInjector).findAll() { TraitInjector ti ->
            ti.artefactTypes.contains(ReactViewTemplate.TYPE)
        }
        return injectors
    }
}

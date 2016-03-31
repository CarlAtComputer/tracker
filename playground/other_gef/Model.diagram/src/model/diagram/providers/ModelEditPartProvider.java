package model.diagram.providers;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

import model.diagram.edit.parts.CarEditPart;
import model.diagram.edit.parts.ModelEditPartFactory;
import model.diagram.part.ModelVisualIDRegistry;

/**
 * @generated
 */
public class ModelEditPartProvider extends DefaultEditPartProvider {

	/**
	* @generated
	*/
	public ModelEditPartProvider() {
		super(new ModelEditPartFactory(), ModelVisualIDRegistry.TYPED_INSTANCE, CarEditPart.MODEL_ID);
	}

}

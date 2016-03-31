	package model.diagram.part;

	/**
 * @generated
 */
public class ModelDiagramUpdater {
		
		/**
 * @generated
 */
public static java.util.List<model.diagram.part.ModelNodeDescriptor> getSemanticChildren(org.eclipse.gmf.runtime.notation.View view) {
		return java.util.Collections.emptyList();
}
		
		/**
 * @generated
 */
public static java.util.List<model.diagram.part.ModelLinkDescriptor> getContainedLinks(org.eclipse.gmf.runtime.notation.View view) {
		switch (model.diagram.part.ModelVisualIDRegistry.getVisualID(view)) {
		case model.diagram.edit.parts.CarEditPart.VISUAL_ID:
	return getCar_1000ContainedLinks(view);
case model.diagram.edit.parts.ColorEditPart.VISUAL_ID:
	return getColor_4001ContainedLinks(view);
	}
		return java.util.Collections.emptyList();
}
	
		/**
 * @generated
 */
public static java.util.List<model.diagram.part.ModelLinkDescriptor> getIncomingLinks(org.eclipse.gmf.runtime.notation.View view) {
		switch (model.diagram.part.ModelVisualIDRegistry.getVisualID(view)) {
		case model.diagram.edit.parts.ColorEditPart.VISUAL_ID:
	return getColor_4001IncomingLinks(view);
	}
		return java.util.Collections.emptyList();
}
	
		/**
 * @generated
 */
public static java.util.List<model.diagram.part.ModelLinkDescriptor> getOutgoingLinks(org.eclipse.gmf.runtime.notation.View view) {
		switch (model.diagram.part.ModelVisualIDRegistry.getVisualID(view)) {
		case model.diagram.edit.parts.ColorEditPart.VISUAL_ID:
	return getColor_4001OutgoingLinks(view);
	}
		return java.util.Collections.emptyList();
}
		
/**
 * @generated
 */
public static java.util.List<model.diagram.part.ModelLinkDescriptor> getCar_1000ContainedLinks(org.eclipse.gmf.runtime.notation.View view) {
	model.Car modelElement = (model.Car) view.getElement();
		java.util.LinkedList<model.diagram.part.ModelLinkDescriptor> result = new java.util.LinkedList<model.diagram.part.ModelLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Color_4001(modelElement));	
	return result;
}
	
/**
 * @generated
 */
public static java.util.List<model.diagram.part.ModelLinkDescriptor> getColor_4001ContainedLinks(org.eclipse.gmf.runtime.notation.View view) {
	return java.util.Collections.emptyList();
}
		
/**
 * @generated
 */
public static java.util.List<model.diagram.part.ModelLinkDescriptor> getColor_4001IncomingLinks(org.eclipse.gmf.runtime.notation.View view) {
	return java.util.Collections.emptyList();
}
		
/**
 * @generated
 */
public static java.util.List<model.diagram.part.ModelLinkDescriptor> getColor_4001OutgoingLinks(org.eclipse.gmf.runtime.notation.View view) {
	return java.util.Collections.emptyList();
}
	
	/**
 * @generated
 */
private static java.util.Collection<model.diagram.part.ModelLinkDescriptor> getContainedTypeModelFacetLinks_Color_4001(model.Car container) {
	java.util.LinkedList<model.diagram.part.ModelLinkDescriptor> result = new java.util.LinkedList<model.diagram.part.ModelLinkDescriptor>();
				model.Color link = container.getColor();
			if (model.diagram.edit.parts.ColorEditPart.VISUAL_ID != model.diagram.part.ModelVisualIDRegistry.getLinkWithClassVisualID(link)) {
	return result;
}
			
						result.add(new model.diagram.part.ModelLinkDescriptor(container, , link, model.diagram.providers.ModelElementTypes.Color_4001, model.diagram.edit.parts.ColorEditPart.VISUAL_ID));
			return result;	
}
			
					/**
 * @generated
 */
	public static final org.eclipse.gmf.tooling.runtime.update.DiagramUpdater TYPED_INSTANCE = new org.eclipse.gmf.tooling.runtime.update.DiagramUpdater() {
				/**
 * @generated
 */
		@Override

		public java.util.List<model.diagram.part.ModelNodeDescriptor> getSemanticChildren(org.eclipse.gmf.runtime.notation.View view) {
			return ModelDiagramUpdater.getSemanticChildren(view);
		}

		/**
 * @generated
 */
		@Override

		public java.util.List<model.diagram.part.ModelLinkDescriptor> getContainedLinks(org.eclipse.gmf.runtime.notation.View view) {
			return ModelDiagramUpdater.getContainedLinks(view);
		}

		/**
 * @generated
 */
		@Override

		public java.util.List<model.diagram.part.ModelLinkDescriptor> getIncomingLinks(org.eclipse.gmf.runtime.notation.View view) {
			return ModelDiagramUpdater.getIncomingLinks(view);
		}

		/**
 * @generated
 */
		@Override

		public java.util.List<model.diagram.part.ModelLinkDescriptor> getOutgoingLinks(org.eclipse.gmf.runtime.notation.View view) {
			return ModelDiagramUpdater.getOutgoingLinks(view);
		}
	}; 
			
	}

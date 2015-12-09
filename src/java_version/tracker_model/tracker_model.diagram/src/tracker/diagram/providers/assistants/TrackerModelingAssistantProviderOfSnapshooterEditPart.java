package tracker.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import tracker.diagram.edit.parts.SnapshooterEditPart;
import tracker.diagram.providers.TrackerElementTypes;
import tracker.diagram.providers.TrackerModelingAssistantProvider;

/**
 * @generated
 */
public class TrackerModelingAssistantProviderOfSnapshooterEditPart extends TrackerModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((SnapshooterEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(SnapshooterEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(TrackerElementTypes.ChronosSnapshooter_4002);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((SnapshooterEditPart) targetEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(SnapshooterEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == TrackerElementTypes.ChronosSnapshooter_4002) {
			types.add(TrackerElementTypes.Chronos_2002);
		}
		return types;
	}

}

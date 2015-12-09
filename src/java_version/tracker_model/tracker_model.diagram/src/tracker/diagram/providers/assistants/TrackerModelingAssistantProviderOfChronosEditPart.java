package tracker.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import tracker.diagram.edit.parts.ChronosEditPart;
import tracker.diagram.edit.parts.ClerkEditPart;
import tracker.diagram.edit.parts.SnapshooterEditPart;
import tracker.diagram.providers.TrackerElementTypes;
import tracker.diagram.providers.TrackerModelingAssistantProvider;

/**
 * @generated
 */
public class TrackerModelingAssistantProviderOfChronosEditPart extends TrackerModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((ChronosEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(ChronosEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(TrackerElementTypes.ChronosClerk_4001);
		types.add(TrackerElementTypes.ChronosSnapshooter_4002);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((ChronosEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(ChronosEditPart source,
			IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ClerkEditPart) {
			types.add(TrackerElementTypes.ChronosClerk_4001);
		}
		if (targetEditPart instanceof SnapshooterEditPart) {
			types.add(TrackerElementTypes.ChronosSnapshooter_4002);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((ChronosEditPart) sourceEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(ChronosEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == TrackerElementTypes.ChronosClerk_4001) {
			types.add(TrackerElementTypes.Clerk_2003);
		} else if (relationshipType == TrackerElementTypes.ChronosSnapshooter_4002) {
			types.add(TrackerElementTypes.Snapshooter_2001);
		}
		return types;
	}

}

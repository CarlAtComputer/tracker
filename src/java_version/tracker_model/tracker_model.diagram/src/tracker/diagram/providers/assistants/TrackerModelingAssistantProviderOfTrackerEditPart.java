package tracker.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import tracker.diagram.providers.TrackerElementTypes;
import tracker.diagram.providers.TrackerModelingAssistantProvider;

/**
 * @generated
 */
public class TrackerModelingAssistantProviderOfTrackerEditPart extends TrackerModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(TrackerElementTypes.Snapshooter_2001);
		types.add(TrackerElementTypes.Chronos_2002);
		types.add(TrackerElementTypes.Clerk_2003);
		return types;
	}

}

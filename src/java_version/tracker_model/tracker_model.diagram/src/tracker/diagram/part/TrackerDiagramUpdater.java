package tracker.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import tracker.Chronos;
import tracker.Clerk;
import tracker.Datasource;
import tracker.Snapshooter;
import tracker.Tracker;
import tracker.TrackerPackage;
import tracker.diagram.edit.parts.ChronosClerkEditPart;
import tracker.diagram.edit.parts.ChronosEditPart;
import tracker.diagram.edit.parts.ChronosSnapshooterEditPart;
import tracker.diagram.edit.parts.ClerkEditPart;
import tracker.diagram.edit.parts.SnapshooterDatasourcesEditPart;
import tracker.diagram.edit.parts.SnapshooterEditPart;
import tracker.diagram.edit.parts.TrackerEditPart;
import tracker.diagram.providers.TrackerElementTypes;

/**
 * @generated
 */
public class TrackerDiagramUpdater {

	/**
	* @generated
	*/
	public static List<TrackerNodeDescriptor> getSemanticChildren(View view) {
		switch (TrackerVisualIDRegistry.getVisualID(view)) {
		case TrackerEditPart.VISUAL_ID:
			return getTracker_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<TrackerNodeDescriptor> getTracker_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Tracker modelElement = (Tracker) view.getElement();
		LinkedList<TrackerNodeDescriptor> result = new LinkedList<TrackerNodeDescriptor>();
		for (Iterator<?> it = modelElement.getSnapshooter().iterator(); it.hasNext();) {
			Snapshooter childElement = (Snapshooter) it.next();
			int visualID = TrackerVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SnapshooterEditPart.VISUAL_ID) {
				result.add(new TrackerNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getChronos().iterator(); it.hasNext();) {
			Chronos childElement = (Chronos) it.next();
			int visualID = TrackerVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ChronosEditPart.VISUAL_ID) {
				result.add(new TrackerNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getClerk().iterator(); it.hasNext();) {
			Clerk childElement = (Clerk) it.next();
			int visualID = TrackerVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ClerkEditPart.VISUAL_ID) {
				result.add(new TrackerNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<TrackerLinkDescriptor> getContainedLinks(View view) {
		switch (TrackerVisualIDRegistry.getVisualID(view)) {
		case TrackerEditPart.VISUAL_ID:
			return getTracker_1000ContainedLinks(view);
		case SnapshooterEditPart.VISUAL_ID:
			return getSnapshooter_2001ContainedLinks(view);
		case ChronosEditPart.VISUAL_ID:
			return getChronos_2002ContainedLinks(view);
		case ClerkEditPart.VISUAL_ID:
			return getClerk_2003ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<TrackerLinkDescriptor> getIncomingLinks(View view) {
		switch (TrackerVisualIDRegistry.getVisualID(view)) {
		case SnapshooterEditPart.VISUAL_ID:
			return getSnapshooter_2001IncomingLinks(view);
		case ChronosEditPart.VISUAL_ID:
			return getChronos_2002IncomingLinks(view);
		case ClerkEditPart.VISUAL_ID:
			return getClerk_2003IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<TrackerLinkDescriptor> getOutgoingLinks(View view) {
		switch (TrackerVisualIDRegistry.getVisualID(view)) {
		case SnapshooterEditPart.VISUAL_ID:
			return getSnapshooter_2001OutgoingLinks(view);
		case ChronosEditPart.VISUAL_ID:
			return getChronos_2002OutgoingLinks(view);
		case ClerkEditPart.VISUAL_ID:
			return getClerk_2003OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TrackerLinkDescriptor> getTracker_1000ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TrackerLinkDescriptor> getSnapshooter_2001ContainedLinks(View view) {
		Snapshooter modelElement = (Snapshooter) view.getElement();
		LinkedList<TrackerLinkDescriptor> result = new LinkedList<TrackerLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Snapshooter_Datasources_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<TrackerLinkDescriptor> getChronos_2002ContainedLinks(View view) {
		Chronos modelElement = (Chronos) view.getElement();
		LinkedList<TrackerLinkDescriptor> result = new LinkedList<TrackerLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Chronos_Clerk_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Chronos_Snapshooter_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<TrackerLinkDescriptor> getClerk_2003ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TrackerLinkDescriptor> getSnapshooter_2001IncomingLinks(View view) {
		Snapshooter modelElement = (Snapshooter) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<TrackerLinkDescriptor> result = new LinkedList<TrackerLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Chronos_Snapshooter_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<TrackerLinkDescriptor> getChronos_2002IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<TrackerLinkDescriptor> getClerk_2003IncomingLinks(View view) {
		Clerk modelElement = (Clerk) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<TrackerLinkDescriptor> result = new LinkedList<TrackerLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Chronos_Clerk_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<TrackerLinkDescriptor> getSnapshooter_2001OutgoingLinks(View view) {
		Snapshooter modelElement = (Snapshooter) view.getElement();
		LinkedList<TrackerLinkDescriptor> result = new LinkedList<TrackerLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Snapshooter_Datasources_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<TrackerLinkDescriptor> getChronos_2002OutgoingLinks(View view) {
		Chronos modelElement = (Chronos) view.getElement();
		LinkedList<TrackerLinkDescriptor> result = new LinkedList<TrackerLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Chronos_Clerk_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Chronos_Snapshooter_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<TrackerLinkDescriptor> getClerk_2003OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<TrackerLinkDescriptor> getIncomingFeatureModelFacetLinks_Chronos_Clerk_4001(Clerk target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<TrackerLinkDescriptor> result = new LinkedList<TrackerLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == TrackerPackage.eINSTANCE.getChronos_Clerk()) {
				result.add(new TrackerLinkDescriptor(setting.getEObject(), target,
						TrackerElementTypes.ChronosClerk_4001, ChronosClerkEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<TrackerLinkDescriptor> getIncomingFeatureModelFacetLinks_Chronos_Snapshooter_4002(
			Snapshooter target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<TrackerLinkDescriptor> result = new LinkedList<TrackerLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == TrackerPackage.eINSTANCE.getChronos_Snapshooter()) {
				result.add(new TrackerLinkDescriptor(setting.getEObject(), target,
						TrackerElementTypes.ChronosSnapshooter_4002, ChronosSnapshooterEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<TrackerLinkDescriptor> getOutgoingFeatureModelFacetLinks_Chronos_Clerk_4001(
			Chronos source) {
		LinkedList<TrackerLinkDescriptor> result = new LinkedList<TrackerLinkDescriptor>();
		Clerk destination = source.getClerk();
		if (destination == null) {
			return result;
		}
		result.add(new TrackerLinkDescriptor(source, destination, TrackerElementTypes.ChronosClerk_4001,
				ChronosClerkEditPart.VISUAL_ID));
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<TrackerLinkDescriptor> getOutgoingFeatureModelFacetLinks_Chronos_Snapshooter_4002(
			Chronos source) {
		LinkedList<TrackerLinkDescriptor> result = new LinkedList<TrackerLinkDescriptor>();
		Snapshooter destination = source.getSnapshooter();
		if (destination == null) {
			return result;
		}
		result.add(new TrackerLinkDescriptor(source, destination, TrackerElementTypes.ChronosSnapshooter_4002,
				ChronosSnapshooterEditPart.VISUAL_ID));
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<TrackerLinkDescriptor> getOutgoingFeatureModelFacetLinks_Snapshooter_Datasources_4003(
			Snapshooter source) {
		LinkedList<TrackerLinkDescriptor> result = new LinkedList<TrackerLinkDescriptor>();
		for (Iterator<?> destinations = source.getDatasources().iterator(); destinations.hasNext();) {
			Datasource destination = (Datasource) destinations.next();
			result.add(new TrackerLinkDescriptor(source, destination, TrackerElementTypes.SnapshooterDatasources_4003,
					SnapshooterDatasourcesEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		* @generated
		*/
		@Override

		public List<TrackerNodeDescriptor> getSemanticChildren(View view) {
			return TrackerDiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<TrackerLinkDescriptor> getContainedLinks(View view) {
			return TrackerDiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<TrackerLinkDescriptor> getIncomingLinks(View view) {
			return TrackerDiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<TrackerLinkDescriptor> getOutgoingLinks(View view) {
			return TrackerDiagramUpdater.getOutgoingLinks(view);
		}
	};

}

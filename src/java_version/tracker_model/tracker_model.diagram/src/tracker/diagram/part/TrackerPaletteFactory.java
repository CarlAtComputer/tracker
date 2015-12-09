
package tracker.diagram.part;

import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;

import tracker.diagram.providers.TrackerElementTypes;

/**
 * @generated
 */
public class TrackerPaletteFactory {

	/**
	* @generated
	*/
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createTracker1Group());
	}

	/**
	* Creates "tracker" palette tool group
	* @generated
	*/
	private PaletteContainer createTracker1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Tracker1Group_title);
		paletteContainer.setId("createTracker1Group"); //$NON-NLS-1$
		paletteContainer.add(createChronos1CreationTool());
		paletteContainer.add(createChronosSnapshooter2CreationTool());
		paletteContainer.add(createChronosClerk3CreationTool());
		paletteContainer.add(createSnapshooter4CreationTool());
		paletteContainer.add(createSnapshooterDatasources5CreationTool());
		paletteContainer.add(createClerk6CreationTool());
		paletteContainer.add(createDatasource7CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createChronos1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Chronos1CreationTool_title,
				Messages.Chronos1CreationTool_desc, Collections.singletonList(TrackerElementTypes.Chronos_2002));
		entry.setId("createChronos1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(TrackerElementTypes.getImageDescriptor(TrackerElementTypes.Chronos_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createChronosSnapshooter2CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.ChronosSnapshooter2CreationTool_title,
				Messages.ChronosSnapshooter2CreationTool_desc,
				Collections.singletonList(TrackerElementTypes.ChronosSnapshooter_4002));
		entry.setId("createChronosSnapshooter2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(TrackerElementTypes.getImageDescriptor(TrackerElementTypes.ChronosSnapshooter_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createChronosClerk3CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.ChronosClerk3CreationTool_title,
				Messages.ChronosClerk3CreationTool_desc,
				Collections.singletonList(TrackerElementTypes.ChronosClerk_4001));
		entry.setId("createChronosClerk3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(TrackerElementTypes.getImageDescriptor(TrackerElementTypes.ChronosClerk_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createSnapshooter4CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Snapshooter4CreationTool_title,
				Messages.Snapshooter4CreationTool_desc,
				Collections.singletonList(TrackerElementTypes.Snapshooter_2001));
		entry.setId("createSnapshooter4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(TrackerElementTypes.getImageDescriptor(TrackerElementTypes.Snapshooter_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createSnapshooterDatasources5CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.SnapshooterDatasources5CreationTool_title,
				Messages.SnapshooterDatasources5CreationTool_desc,
				Collections.singletonList(TrackerElementTypes.SnapshooterDatasources_4003));
		entry.setId("createSnapshooterDatasources5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(TrackerElementTypes.getImageDescriptor(TrackerElementTypes.SnapshooterDatasources_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createClerk6CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Clerk6CreationTool_title,
				Messages.Clerk6CreationTool_desc, Collections.singletonList(TrackerElementTypes.Clerk_2003));
		entry.setId("createClerk6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(TrackerElementTypes.getImageDescriptor(TrackerElementTypes.Clerk_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createDatasource7CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.Datasource7CreationTool_title, Messages.Datasource7CreationTool_desc,
				null, null) {
		};
		entry.setId("createDatasource7CreationTool"); //$NON-NLS-1$
		return entry;
	}

}


package model.diagram.part;

import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultLinkToolEntry;

import model.diagram.providers.ModelElementTypes;

/**
 * @generated
 */
public class ModelPaletteFactory {

	/**
	* @generated
	*/
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createModel1Group());
	}

	/**
	* Creates "model" palette tool group
	* @generated
	*/
	private PaletteContainer createModel1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Model1Group_title);
		paletteContainer.setId("createModel1Group"); //$NON-NLS-1$
		paletteContainer.add(createCar1CreationTool());
		paletteContainer.add(createCarTires2CreationTool());
		paletteContainer.add(createCarColor3CreationTool());
		paletteContainer.add(createTire4CreationTool());
		paletteContainer.add(createColor5CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createCar1CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.Car1CreationTool_title, Messages.Car1CreationTool_desc, null, null) {
		};
		entry.setId("createCar1CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createCarTires2CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.CarTires2CreationTool_title, Messages.CarTires2CreationTool_desc, null,
				null) {
		};
		entry.setId("createCarTires2CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createCarColor3CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.CarColor3CreationTool_title,
				Messages.CarColor3CreationTool_desc, Collections.singletonList(ModelElementTypes.Color_4001));
		entry.setId("createCarColor3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ModelElementTypes.getImageDescriptor(ModelElementTypes.Color_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createTire4CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.Tire4CreationTool_title, Messages.Tire4CreationTool_desc, null, null) {
		};
		entry.setId("createTire4CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createColor5CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.Color5CreationTool_title, Messages.Color5CreationTool_desc, null,
				null) {
		};
		entry.setId("createColor5CreationTool"); //$NON-NLS-1$
		return entry;
	}

}

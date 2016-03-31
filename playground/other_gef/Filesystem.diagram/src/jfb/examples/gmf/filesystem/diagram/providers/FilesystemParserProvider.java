package jfb.examples.gmf.filesystem.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import jfb.examples.gmf.filesystem.FilesystemPackage;
import jfb.examples.gmf.filesystem.diagram.edit.parts.FileNameEditPart;
import jfb.examples.gmf.filesystem.diagram.edit.parts.FolderNameEditPart;
import jfb.examples.gmf.filesystem.diagram.parsers.MessageFormatParser;
import jfb.examples.gmf.filesystem.diagram.part.FilesystemVisualIDRegistry;

/**
 * @generated
 */
public class FilesystemParserProvider extends AbstractProvider implements IParserProvider {

	/**
	* @generated
	*/
	private IParser folderName_5001Parser;

	/**
	* @generated
	*/
	private IParser getFolderName_5001Parser() {
		if (folderName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { FilesystemPackage.eINSTANCE.getFolder_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			folderName_5001Parser = parser;
		}
		return folderName_5001Parser;
	}

	/**
	* @generated
	*/
	private IParser fileName_5002Parser;

	/**
	* @generated
	*/
	private IParser getFileName_5002Parser() {
		if (fileName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { FilesystemPackage.eINSTANCE.getFile_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			fileName_5002Parser = parser;
		}
		return fileName_5002Parser;
	}

	/**
	* @generated
	*/
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case FolderNameEditPart.VISUAL_ID:
			return getFolderName_5001Parser();
		case FileNameEditPart.VISUAL_ID:
			return getFileName_5002Parser();
		}
		return null;
	}

	/**
	* Utility method that consults ParserService
	* @generated
	*/
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	* @generated
	*/
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(FilesystemVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(FilesystemVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	* @generated
	*/
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (FilesystemElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	* @generated
	*/
	private static class HintAdapter extends ParserHintAdapter {

		/**
		* @generated
		*/
		private final IElementType elementType;

		/**
		* @generated
		*/
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		* @generated
		*/
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}

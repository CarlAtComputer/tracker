package model.diagram.edit.commands;

/**
 * @generated
 */
public class ColorCreateCommand extends org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand {
	
	/**
 * @generated
 */
	private final org.eclipse.emf.ecore.EObject source;

	/**
 * @generated
 */
	private final org.eclipse.emf.ecore.EObject target;

	/**
 * @generated
 */
	public ColorCreateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest request, org.eclipse.emf.ecore.EObject source, org.eclipse.emf.ecore.EObject target) {
		super(request.getLabel(), null, request);
			this.source = source;
	this.target = target;
	}
	
	/**
 * @generated
 */
	public boolean canExecute() {
		if (source == null && target == null) {
			return false;
		}
		if (source != null && false == source instanceof model.Car) {
			return false;
		}
		if (target != null && ) {
			return false;
		}
		if (getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
			return model.diagram.edit.policies.ModelBaseItemSemanticEditPolicy.getLinkConstraints().canCreateColor_4001(getSource(), getTarget());
	}

	
	/**
 * @generated
 */
	protected org.eclipse.gmf.runtime.common.core.command.CommandResult doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor monitor, org.eclipse.core.runtime.IAdaptable info) throws org.eclipse.core.commands.ExecutionException {
		if (!canExecute()) {
			throw new org.eclipse.core.commands.ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}
		
		model.Color newElement = model.ModelFactory.eINSTANCE.createColor();
		getSource().setColor(newElement);				newElement.setColorName(getTarget());						doConfigure(newElement, monitor, info);
		((org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest) getRequest()).setNewElement(newElement);
		return org.eclipse.gmf.runtime.common.core.command.CommandResult.newOKCommandResult(newElement);

	}


		/**
 * @generated
 */
	protected void doConfigure(model.Color newElement, org.eclipse.core.runtime.IProgressMonitor monitor, org.eclipse.core.runtime.IAdaptable info) throws org.eclipse.core.commands.ExecutionException {
		org.eclipse.gmf.runtime.emf.type.core.IElementType elementType = ((org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest) getRequest()).getElementType();
		org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest configureRequest = new org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest) getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		configureRequest.setParameter(org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest.SOURCE, getSource());
		configureRequest.setParameter(org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest.TARGET, getTarget());
		org.eclipse.gmf.runtime.common.core.command.ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if (configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

	/**
 * @generated
 */
	protected void setElementToEdit(org.eclipse.emf.ecore.EObject element) {
		throw new UnsupportedOperationException();
	}
	
	/**
 * @generated
 */
	protected model.Car getSource() {
		return (model.Car) source;
	}

	/**
 * @generated
 */
	protected  getTarget() {
		return ;
	}
	
}

package model.diagram.edit.commands;

/**
 * @generated
 */
public class ColorReorientCommand extends org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand {

	/**
 * @generated
 */
	private final int reorientDirection;

	/**
 * @generated
 */
	private final org.eclipse.emf.ecore.EObject oldEnd;

	/**
 * @generated
 */
	private final org.eclipse.emf.ecore.EObject newEnd;

	/**
 * @generated
 */
	public ColorReorientCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}
	
	/**
 * @generated
 */
	public boolean canExecute() {
			if (false == getElementToEdit() instanceof model.Color) {
		return false;
	}
		if (reorientDirection == org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
 * @generated
 */
	protected boolean canReorientSource() {
			if (!(oldEnd instanceof model.Car && newEnd instanceof model.Car)) {
		return false;
	}
				
			return model.diagram.edit.policies.ModelBaseItemSemanticEditPolicy.getLinkConstraints().canExistColor_4001(getLink(), getNewSource(), target);
	}

	/**
 * @generated
 */
	protected boolean canReorientTarget() {
			if (!( && )) {
		return false;
	}
			if (!(getLink().eContainer() instanceof model.Car)) {
			return false;
		}
		model.Car source = (model.Car) getLink().eContainer();
			return model.diagram.edit.policies.ModelBaseItemSemanticEditPolicy.getLinkConstraints().canExistColor_4001(getLink(), source, getNewTarget());
	}
	
	/**
 * @generated
 */
	protected org.eclipse.gmf.runtime.common.core.command.CommandResult doExecuteWithResult(
			org.eclipse.core.runtime.IProgressMonitor monitor, org.eclipse.core.runtime.IAdaptable info)
			throws org.eclipse.core.commands.ExecutionException {
		if (!canExecute()) {
			throw new org.eclipse.core.commands.ExecutionException("Invalid arguments in reorient link command");  //$NON-NLS-1$
		}
		if (reorientDirection == org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
 * @generated
 */
	protected org.eclipse.gmf.runtime.common.core.command.CommandResult reorientSource() throws org.eclipse.core.commands.ExecutionException {
				getOldSource().setColor(null);
	getNewSource().setColor(getLink());
	return org.eclipse.gmf.runtime.common.core.command.CommandResult.newOKCommandResult(getLink());
	}

	/**
 * @generated
 */
	protected org.eclipse.gmf.runtime.common.core.command.CommandResult reorientTarget() throws org.eclipse.core.commands.ExecutionException {
				getLink().setColorName(getNewTarget());
	return org.eclipse.gmf.runtime.common.core.command.CommandResult.newOKCommandResult(getLink());
	}
		
	/**
 * @generated
 */
	protected model.Color getLink() {
		return (model.Color) getElementToEdit();
	}
	
	/**
 * @generated
 */
	protected model.Car getOldSource() {
		return (model.Car) oldEnd;
	}
	
	/**
 * @generated
 */
	protected model.Car getNewSource() {
		return (model.Car) newEnd;
	}
	
	/**
 * @generated
 */
	protected  getOldTarget() {
		return ;
	}
	
	/**
 * @generated
 */
	protected  getNewTarget() {
		return ;
	}
}

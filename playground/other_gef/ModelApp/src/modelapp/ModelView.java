 
package modelapp;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecp.ui.view.ECPRendererException;
import org.eclipse.emf.ecp.ui.view.swt.DefaultReferenceService;
import org.eclipse.emf.ecp.ui.view.swt.ECPSWTView;
import org.eclipse.emf.ecp.ui.view.swt.ECPSWTViewRenderer;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContextFactory;
import org.eclipse.emf.ecp.view.spi.provider.ViewProviderHelper;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import model.Car;
import model.ModelPackage;
import model.Tire;

public class ModelView {
	@Inject
	public ModelView() {
		
	}
	
	@PostConstruct
	public void createComposite(Composite parent) {
		final EObject dummyObject = getDummyEObject();
		try {
			final Composite upper = new Composite(parent, SWT.NONE);
			upper.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
			upper.setLayout(GridLayoutFactory.fillDefaults().margins(10, 10).create());
			upper.setLayoutData(GridDataFactory.fillDefaults().create());

			final ViewModelContext vmc = ViewModelContextFactory.INSTANCE.createViewModelContext(ViewProviderHelper.getView(dummyObject, null), dummyObject, new DefaultReferenceService());
			
			final ECPSWTView view = ECPSWTViewRenderer.INSTANCE.render(upper, vmc);
			
			upper.layout();
			
			Composite content = new Composite(parent, SWT.NONE);
			content.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
			content.setLayout(GridLayoutFactory.fillDefaults().margins(10, 10).create());
			content.setLayoutData(GridDataFactory.fillDefaults().create());
			
			Button b = new Button(content, SWT.NONE);
			b.setText("SAVE");
			b.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					Car car = (Car) view.getViewModelContext().getDomainModel();
					System.out.println(car.getName());
					EList<Tire> tires = car.getTires();
					for (Tire tire : tires) {
						System.out.println(tire.getBrand());
					}
				}
			});
			
		} catch (final ECPRendererException e) {
			e.printStackTrace();
		}
		parent.layout();
	}

	private EObject getDummyEObject() {
		// Replace this with your own model EClass to test the application with a custom model
		final EClass eClass = ModelPackage.eINSTANCE.getCar();
		Car car = (Car) EcoreUtil.create(eClass);
		car.setName("test");
		return car;
	}
	
	
}
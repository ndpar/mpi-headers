package examples;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

import flex.data.DataServiceTransaction;

@Service
@ManagedResource(objectName = "examples:service=ChangeListener")
public class ChangeListener {
    public static final String DESTINATION = "MyDestination";

    @ManagedOperation
    @ManagedOperationParameters( {
        @ManagedOperationParameter(name = "id", description = "Key"),
        @ManagedOperationParameter(name = "name", description = "Name")
    })
    public void createObject(Integer id, String name) {
        DataServiceTransaction transaction = DataServiceTransaction.begin(false);
        transaction.createItem(DESTINATION, ObjectBuilder.buildDomainObject(id, name));
        transaction.commit();
    }

    @ManagedOperation
    @ManagedOperationParameters( {
        @ManagedOperationParameter(name = "id", description = "Key"),
        @ManagedOperationParameter(name = "name", description = "Name")
    })
    public void updateObject(Integer id, String name) {
        DataServiceTransaction transaction = DataServiceTransaction.begin(false);
        transaction.updateItem(DESTINATION, ObjectBuilder.buildDomainObject(id, name), null, null);
        transaction.commit();
    }
}

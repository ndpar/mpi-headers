package examples;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

@Service
@ManagedResource(objectName = "examples:service=BulkObjectUpdater")
public class BulkObjectUpdater {

    @Autowired
    private ChangeListener changeListener;

    private int bulkSize = 10;

    private int kbs = 100;

    @ManagedAttribute
    public void setBulkSize(int bulkSize) {
        this.bulkSize = bulkSize;
    }

    @ManagedAttribute
    public int getBulkSize() {
        return bulkSize;
    }

    @ManagedAttribute
    public void setKbs(int kbs) {
        this.kbs = kbs;
    }

    @ManagedAttribute
    public int getKbs() {
        return kbs;
    }

    public void update() {
        for (int i = 0; i < bulkSize; i++) {
            changeListener.updateObject(i % 400, UUID.randomUUID().toString());
        }
    }
}

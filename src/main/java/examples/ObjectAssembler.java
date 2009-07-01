package examples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import flex.data.assemblers.AbstractAssembler;

public class ObjectAssembler extends AbstractAssembler {

    protected final Log log = LogFactory.getLog(getClass());

    @Override
    @SuppressWarnings("unchecked")
    public Collection fill(List fillParameters) {
        log.debug("params=" + fillParameters);
        Collection<DomainObject> result = new ArrayList<DomainObject>();
        for (int i = 0; i < 400; i++) {
            result.add(ObjectBuilder.buildDomainObject(i));
        }
        return result;
    }
}

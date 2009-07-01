package examples;

import java.util.UUID;

public abstract class ObjectBuilder {

    public static DomainObject buildDomainObject(Integer id) {
        return buildDomainObject(id, UUID.randomUUID().toString());
    }

    public static DomainObject buildDomainObject(Integer id, String name) {
        DomainObject result = new DomainObject();
        result.setId(id);
        result.setName(name);
        return result;
    }
}

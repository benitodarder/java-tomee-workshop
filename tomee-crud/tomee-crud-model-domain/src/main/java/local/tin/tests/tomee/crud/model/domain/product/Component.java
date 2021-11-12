package local.tin.tests.tomee.crud.model.domain.product;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import local.tin.tests.tomee.crud.model.domain.abstracts.AbstractNamedProduct;

/**
 *
 * @author benito.darder
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Component extends AbstractNamedProduct {
    
    private Integer id;
    private Unit unit;
    @XmlElementWrapper(name="assemblies")
    @XmlElementRef 
    private Set<Assembly> assemblies;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.getName());
        hash = 29 * hash + Objects.hashCode(this.unit);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Component other = (Component) obj;
        if (!Objects.equals(this.getName(), other.getName())) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.unit, other.unit);
    }  

    @Override
    public String toString() {
        return "Component{" + "id=" + id + ", name=" + getName() + ", unit=" + unit + ", assemblies=" + assemblies + '}';
    }

    public Set<Assembly> getAssemblies() {
        if (assemblies == null) {
            assemblies = new HashSet<>();
        }
        return assemblies;
    }

    public void setAssemblies(Set<Assembly> assemblies) {
        this.assemblies = assemblies;
    }

    
}

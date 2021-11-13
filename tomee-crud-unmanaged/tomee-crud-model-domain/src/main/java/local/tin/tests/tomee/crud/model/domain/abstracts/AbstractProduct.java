package local.tin.tests.tomee.crud.model.domain.abstracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import local.tin.tests.tomee.crud.model.domain.product.Assembly;

/**
 *
 * @author benito.darder
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Assembly.class})
public abstract class AbstractProduct extends AbstractEnableable {
    
   
    
}

package local.tin.tests.tomee.crud.model.domain.messaging;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import local.tin.tests.tomee.crud.model.domain.abstracts.AbstractProduct;
import local.tin.tests.tomee.crud.model.domain.deserializers.RequestDeserializer;


/**
 *
 * @author benito.darder
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({AbstractProduct.class})
@JsonDeserialize(using = RequestDeserializer.class)
public class Request extends AbstractRequest {

}

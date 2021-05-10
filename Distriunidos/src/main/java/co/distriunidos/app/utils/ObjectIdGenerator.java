package co.distriunidos.app.utils;

import java.io.Serializable;
import org.bson.types.ObjectId;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ObjectIdGenerator implements IdentifierGenerator {

  @Override
  public Serializable generate(
      SharedSessionContractImplementor sharedSessionContractImplementor, Object o)
      throws HibernateException {
    return ObjectId.get().toHexString();
  }
}

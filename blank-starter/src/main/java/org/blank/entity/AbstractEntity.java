package org.blank.entity;

import lombok.Data;
import org.blank.bean.BaseBean;

import java.io.Serializable;
import java.util.Objects;

@Data
public abstract class AbstractEntity<ID extends Serializable> extends BaseBean {
    private ID id;

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity<?> that = (AbstractEntity<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

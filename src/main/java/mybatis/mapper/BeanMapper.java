package mybatis.mapper;

import java.util.List;

public interface BeanMapper<T> {

    public boolean insert(T t);

    public boolean update(T t);

    public boolean delete();

    public T select();

    public List<T> selectAll();
}

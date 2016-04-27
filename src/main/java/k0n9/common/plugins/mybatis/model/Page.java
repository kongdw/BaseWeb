package k0n9.common.plugins.mybatis.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author DavidKong
 * @version 1.0
 */
public class Page<E> {

    private final List<E> data = new ArrayList<E>();
    private final long totalElements;//记录条数
    private long totalPages;//总页数
    public Page(Collection<? extends E> content, long recordsTotal) {
        this.data.addAll(content);
        this.totalElements = recordsTotal;
    }

    public List<E> getData() {
        return data;
    }

    public long getRecordsTotal() {
        return totalElements;
    }


}

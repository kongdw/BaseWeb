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
    private final long recordsTotal;
    private long recordsFiltered;

    public Page(Collection<? extends E> content, long recordsTotal) {
        this.data.addAll(content);
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsTotal;
    }

    public List<E> getData() {
        return data;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}

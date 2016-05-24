package k0n9.module.archive.entity;

import k0n9.common.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author David Kong
 * @version 1.0
 */
@Entity
@Table(name = "a")
public class Archive extends BaseEntity<Long> {
    private static final long serialVersionUID = -6319179178860306571L;

    private Long id;
    //标题
    private String title;
    //文件类别 收文|发文|归档
    private Type type;
    //档案类别
    private Category category;
    //保管期限
    private DeadLine deadLine;
    //公文种类 通知|命令|公告
    private DocumentClass docClass;
    private Integer year;
    //文件字号
    private String docNo;
    private Date docDate;
    //柜号
    private String forcerNo;
    //盒号
    private String boxNo;
    //全宗号
    private String fondsNo;
    //份数
    private Integer partNum;
    //页数
    private Integer pageNum;
    //责任人
    private String responsible;
    //科室
    private String dept;
    //保密级别
    private PrivacyLevel privacyLevel;
    //紧急程度
    private UrgentLevel urgentLevel;
    private String remark;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public DeadLine getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(DeadLine deadLine) {
        this.deadLine = deadLine;
    }

    public DocumentClass getDocClass() {
        return docClass;
    }

    public void setDocClass(DocumentClass docClass) {
        this.docClass = docClass;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getForcerNo() {
        return forcerNo;
    }

    public void setForcerNo(String forcerNo) {
        this.forcerNo = forcerNo;
    }

    public String getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }

    public String getFondsNo() {
        return fondsNo;
    }

    public void setFondsNo(String fondsNo) {
        this.fondsNo = fondsNo;
    }

    public Integer getPartNum() {
        return partNum;
    }

    public void setPartNum(Integer partNum) {
        this.partNum = partNum;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public PrivacyLevel getPrivacyLevel() {
        return privacyLevel;
    }

    public void setPrivacyLevel(PrivacyLevel privacyLevel) {
        this.privacyLevel = privacyLevel;
    }

    public UrgentLevel getUrgentLevel() {
        return urgentLevel;
    }

    public void setUrgentLevel(UrgentLevel urgentLevel) {
        this.urgentLevel = urgentLevel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}

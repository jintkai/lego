package com.legoweb.entity;

public class PageCondition<T> extends PageInfo {
    private Integer leftOffset;
    private Integer rightOffset;

    public Integer getLeftOffset() {
        this.leftOffset = (this.getPage()-1)*this.getPageSize();
        return leftOffset;
    }

    private void setLeftOffset(Integer leftOffset) {
        this.leftOffset = leftOffset;
    }

    public Integer getRightOffset() {
        this.rightOffset = this.getPageSize();
        return rightOffset;
    }

    private void setRightOffset(Integer rightOffset) {
        this.rightOffset = rightOffset;
    }
}

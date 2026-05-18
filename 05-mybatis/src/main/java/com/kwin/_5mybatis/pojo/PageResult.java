package com.kwin._5mybatis.pojo;

import com.github.pagehelper.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult implements Serializable {
    private int current;
    private int size;
    private int pages;
    private long total;
    private List records;

    public PageResult(Page page) {
        this.current = page.getPageNum();
        this.size = page.getPageSize();
        this.pages = page.getPages();
        this.total = page.getTotal();
        this.records = page.getResult();
    }
}

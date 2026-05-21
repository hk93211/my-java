package com.kwin._6mybatisplus.pojo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult implements Serializable {
    private long current;
    private long size;
    private long pages;
    private long total;
    private List records;

    public PageResult(Page page) {
        this.current = page.getCurrent();
        this.size = page.getSize();
        this.pages = page.getPages();
        this.total = page.getTotal();
        this.records = page.getRecords();
    }
}

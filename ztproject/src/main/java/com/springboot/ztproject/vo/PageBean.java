package com.springboot.ztproject.vo;

import lombok.Data;

import java.util.List;

/**
 * 封装pageBean
 *
 * @param <T>
 * @author tsc
 * @date 2019年4月4日16:47:03
 */
@Data
public class PageBean<T> {
    /** 总条数*/
    private Integer totalCount;
    /** 每页大小*/
    private Integer pageSize = 10;
    /** 第几页 */
    private Integer pageNumber = 1;
    /** 起始记录 */
    private Integer pageIndex;
    /** 排序方式 */
    private String sortOrder = "asc";
    /** 结果集 */
    private List<T> dataList;
}

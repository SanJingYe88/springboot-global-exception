package it.com.sbe.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * PageResult 分页请求, 返回结果实体类
 *
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PageResult<T> {
    private Long total;
    private List<T> rows;
}

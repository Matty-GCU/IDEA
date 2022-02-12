package xyz.wuhang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    /**
     * 博客id
     */
    String id;

    /**
     * 博客标题
     */
    String title;

    /**
     * 博客作者
     */
    String author;

    /**
     * 发布时间
     */
    Date createTime;

    /**
     * 博客浏览量
     */
    int views;
}

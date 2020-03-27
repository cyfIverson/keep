package com.allen.keep.concurrent.DevelopmentNorm;

/**
 * @author allen
 * @descript 开发需要注意的---参考阿里开发规范 主要为面试准备
 * @date 2020-03-25 11:59 PM
 */
public class DevelopmentNorm {

    /**
     *
     * 一、命名 --重要，基础
     * （1）【规范】类名使用UpperCamelCase 风格，必须遵从驼峰形式，但以下情形例外： （ 领域模型的相关命名 ）DO / BO / DTO / VO 等
     * （2）【规范】方法名、参数名、成员变量、局部变量都统一使用lowerCamelCase 风格，必须遵从驼峰形式
     * （3）【规范】常量命名全部大写，单词间用下划线隔开，力求语义表达完整清楚，不要嫌名字长
     * （4）【规范】各层命名规约：
     * A) Service / DAO 层方法命名规约
     * 1 ） 获取单个对象的方法用 get 做前缀。
     * 2 ） 获取多个对象的方法用 list 做前缀（习惯：getXXXList）。
     * 3 ） 获取统计值的方法用 count 做前缀。
     * 4 ） 插入的方法用 save（ 推荐 ） 或 insert 做前缀。
     * 5 ） 删除的方法用 remove（ 推荐 ） 或 delete 做前缀。
     * 6 ） 修改的方法用 update 做前缀(或modify)。
     * B) 领域模型命名规约
     * 1 ） 数据对象： xxxDO ， xxx 即为数据表名。
     * 2 ） 数据传输对象： xxxDTO ， xxx 为业务领域相关的名称。
     * 3 ） 展示对象： xxxVO ， xxx 一般为网页名称。
     * 4 ） POJO 是 DO / DTO / BO / VO 的统称，禁止命名成 xxxPOJO
     *
     * OOP规约
     * 二、重要 -- 中等
     * 【规范】Object 的 equals 方法容易抛空指针异常，应使用常量或确定有值的对象来调用equals
     * 【规范】所有的相同类型的包装类对象之间值的比较，全部使用 equals 方法比较。(注意空指针) --  这个开发人员经常会犯错
     *
     *
     *
     *
     *
     *
     *
     *
     */

    public static void main(String[] args) {
        // Integer的缓冲区的值范围：-128 --- 127 （常量池）
        Integer a = 1;
        Integer b = 1;
        Integer c = 128;
        Integer d = 128;
        System.out.println(a == b);
        System.out.println(c == d);
    }
}

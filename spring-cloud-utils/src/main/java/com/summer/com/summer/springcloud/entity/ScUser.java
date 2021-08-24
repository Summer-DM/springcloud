package com.summer.com.summer.springcloud.entity;

import java.time.LocalDate;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Summer_DM
 * @since 2021-08-16
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class ScUser implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * 主键id
     */
        private String id;

      /**
     * 用户姓名
     */
      private String name;

      /**
     * 用户密码
     */
      private String password;

      /**
     * 用户出生年月
     */
      private LocalDate birthday;

      /**
     * 用户性别
     */
      private String sex;

      /**
     * 用户年龄
     */
      private String age;

      /**
     * 用户家庭住址
     */
      private String address;


}

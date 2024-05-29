package org.blank.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;
@Data
@TableName("Users")
public class User extends AbstractEntity<String>{
    //@TableId
//    private String id;
    @TableField("UserName")
    private String UserName;
    @TableField("PasswordHash")
    private  String PasswordHash;
    @TableField("Role")
    private String Role;
    @TableField("CreatedAt")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date CreatedAt;





    public User() {
    }

    public User(String id,String role, String passwordHash, String userName) {
        Role = role;
        PasswordHash = passwordHash;
        UserName = userName;
        super.setId(id);
        this.setCreatedAt(new Date());
    }
}

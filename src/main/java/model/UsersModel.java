package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UsersModel {
    private int id;
    private String userName;
    private String passWord;
    private String lastName;
    private String firstName;
    private Timestamp birthDate;
    private String gender;
    private Timestamp createdDate;
    private String createdBy;
    private Timestamp modifiedDate;
    private String modifiedBy;
    private int role;
}

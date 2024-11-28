package com.solution.sos_bit.entity;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import com.solution.sos_bit.dto.UserDTO;

import jakarta.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @Column(name = "username",nullable = false,length = 50,unique = true)	
    private String username;

    @Column(name = "name",nullable = false,length = 100)
    private String name;

    @Column(name = "email",nullable = false,length = 50)
    private String email;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "password",nullable = false)
    private String password;
       
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name =  "role_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_role"))
    private RoleEntity roleEntity;
    
   

    
    public UserEntity(UserDTO usuario) {
		BeanUtils.copyProperties(usuario, this);
	}

    public UserEntity() {
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		return Objects.equals(username, other.username);
	}

	public void setRole(RoleEntity roleEntity2) {
				this.roleEntity = roleEntity2;
					
	}

}

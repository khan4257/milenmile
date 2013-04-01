/**
 * Project		: MileNMile
 * FileName		: Role.java
 * Package		: com.appdisco.mnm.model
 * 
 * @brief		: 
 * @author		: KHAN
 * @date		: 2013. 3. 6. 오후 1:19:27
 */
package com.appdisco.mnm.model;

import org.springframework.security.core.GrantedAuthority;


/**
 * <PRE>
 * @class	: com.appdisco.mnm.model.Role
 * @file	: Role.java
 * @brief	: 
 * @author	: KHAN
 * @date	: 2013. 3. 6. 오후 1:19:27
 * </PRE>
 */
public class Role extends BaseModel<Integer> implements GrantedAuthority {
	
	static enum UserRole {
		SUPER_ADMIN	(1, "ROLE_SUPER_ADMIN", 	"Super Admin User"),
		ADMIN		(2, "ROLE_ADMIN", 			"Admin User"),
		ADVERTISER	(3, "ROLE_ADVERTISER", 		"Advertiser User"),
		STOREMANAGER(4, "ROLE_STOREMANAGER", 	"Store management User"),
		MARKETER	(5, "ROLE_MARKETER", 		"Marketing User"),
		USER		(6, "ROLE_USER", 			"User"),
		GUEST		(9, "ROLE_GUEST", 			"Guest User");
		
		int id;
		String name;
		String description;
		
		UserRole(int id, String name, String description) {
			this.id = id;
			this.name = name;
			this.description = description;
		}
		
		static UserRole valueOf(Integer id) {
			switch (id) {
			case 1:
				return SUPER_ADMIN;
			case 2:
				return ADMIN;
			case 3:
				return ADVERTISER;
			case 4:
				return STOREMANAGER;
			case 5:
				return MARKETER;
			case 6:
				return USER;
			case 9:
				return GUEST;
			default: 
				throw new AssertionError("Unknown role:" + id);
			}
		}
	}

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 2352809708066161437L;

	private String name;
	
	private String description;
	
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name Set to name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description Set to description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Role)) {
            return false;
        }

        final Role role = (Role) o;

        return !(name != null ? !name.equals(role.name) : role.name != null);
    }

    @Override
    public int hashCode() {
        return (name != null ? name.hashCode() : 0);
    }

	/**
	 * @return
	 */
	@Override
	public String getAuthority() {
		return getName();
	}
	
	public UserRole getUserRole() {
		return UserRole.valueOf(getId());
	}
	
	public static Role getRole(Integer id) {
		UserRole uRole = UserRole.valueOf(id);
		Role role = new Role();
		role.setId(uRole.id);
		role.setName(uRole.name);
		role.setDescription(uRole.description);
		return role;
	}
//    @Override
//    public String toString() {
//        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append(this.name).toString();
//    }
}
